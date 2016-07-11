package open.dolphin.table;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

/**
 * TableSorter is a decorator for TableModels; adding sorting functionality to a
 * supplied TableModel. TableSorter does not store or copy the data in its
 * TableModel; instead it maintains a map from the row indexes of the view to
 * the row indexes of the model. As requests are made of the sorter (like
 * getValueAt(row, col)) they are passed to the underlying model after the row
 * numbers have been translated via the internal mapping array. This way, the
 * TableSorter appears to hold another copy of the table with the rows in a
 * different order.
 * <p/>
 * TableSorter registers itself as a listener to the underlying model, just as
 * the JTable itself would. Events recieved from the model are examined,
 * sometimes manipulated (typically widened), and then passed on to the
 * TableSorter's listeners (typically the JTable). If a change to the model has
 * invalidated the order of TableSorter's rows, a note of this is made and the
 * sorter will resort the rows the next time a value is requested.
 * <p/>
 * When the tableHeader property is set, either by using the setTableHeader()
 * method or the two argument constructor, the table header may be used as a
 * complete UI for TableSorter. The default renderer of the tableHeader is
 * decorated with a renderer that indicates the sorting status of each column.
 * In addition, a mouse listener is installed with the following behavior: <ul>
 * <li> Mouse-click: Clears the sorting status of all other columns and advances
 * the sorting status of that column through three values: {NOT_SORTED,
 * ASCENDING, DESCENDING} (then back to NOT_SORTED again). <li>
 * SHIFT-mouse-click: Clears the sorting status of all other columns and cycles
 * the sorting status of the column through the same three values, in the
 * opposite order: {NOT_SORTED, DESCENDING, ASCENDING}. <li> CONTROL-mouse-click
 * and CONTROL-SHIFT-mouse-click: as above except that the changes to the column
 * do not cancel the statuses of columns that are already sorting - giving a way
 * to initiate a compound sort. </ul>
 * <p/>
 * This class first appeared in the swing table demos in 1997 (v1.5) and then
 * had a major rewrite in 2004 (v2.0) to make it compatible with Java 1.4.
 * <p/>
 * This rewrite makes the class compile cleanly with Java 1.5 while maintaining
 * backward compatibility with TableSorter v2.0.
 *
 * @author Philip Milne
 * @author Brendon McLean
 * @author Dan van Enckevort
 * @author Parwinder Sekhon
 * @author ouroborus@ouroborus.org
 * @version 2.1 04/29/06
 */
public class TableSorter extends AbstractTableModel {

    private static final long serialVersionUID = -6741510791689094269L;
    protected TableModel tableModel;
    public static final int DESCENDING = -1;
    public static final int NOT_SORTED = 0;
    public static final int ASCENDING = 1;
    private static Directive EMPTY_DIRECTIVE = new Directive(-1, NOT_SORTED);
    public static final Comparator<Object> COMPARABLE_COMPARATOR = (Object o1, Object o2) -> {
        Method m;
        try {
            // See if o1 is capable of comparing itself to o2
            m = o1.getClass().getDeclaredMethod("compareTo", o2.getClass());
        } catch (NoSuchMethodException e) {
            throw new ClassCastException();
        }
        
        Object retVal;
        try {
            // make the comparison
            retVal = m.invoke(o1, o2);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ClassCastException();
        }
        
        // Comparable.compareTo() is supposed to return int but invoke()
        // returns Object. We can't cast an Object to an int but we can
        // cast it to an Integer and then extract the int from the Integer.
        // But first, make sure it can be done.
        //Integer i = new Integer(0);
        Integer i = 0;
        if (!i.getClass().isInstance(retVal)) {
            throw new ClassCastException();
        }
        
        return i.getClass().cast(retVal);
    };
    public static final Comparator<Object> LEXICAL_COMPARATOR = (Object o1, Object o2) -> o1.toString().compareTo(o2.toString());
    private Row[] viewToModel;
    private int[] modelToView;
    private JTableHeader tableHeader;
    private MouseListener mouseListener;
    private TableModelListener tableModelListener;
    private final Map<Class, Comparator<Object>> columnComparators = new HashMap<>();
    private final List<Directive> sortingColumns = new ArrayList<>();

    public TableSorter() {
        this.mouseListener = new MouseHandler();
        this.tableModelListener = new TableModelHandler();
    }

    public TableSorter(TableModel tableModel) {
        this();
        setTableModel(tableModel);
    }

    public TableSorter(TableModel tableModel, JTableHeader tableHeader) {
        this();
        setTableHeader(tableHeader);
        setTableModel(tableModel);
    }

    private void clearSortingState() {
        viewToModel = null;
        modelToView = null;
    }

    public TableModel getTableModel() {
        return tableModel;
    }

    public final void setTableModel(TableModel tableModel) {
        if (this.tableModel != null) {
            this.tableModel.removeTableModelListener(tableModelListener);
        }

        this.tableModel = tableModel;
        if (this.tableModel != null) {
            this.tableModel.addTableModelListener(tableModelListener);
        }

        clearSortingState();
        fireTableStructureChanged();
    }

    public JTableHeader getTableHeader() {
        return tableHeader;
    }

    public final void setTableHeader(JTableHeader tableHeader) {
        if (this.tableHeader != null) {
            this.tableHeader.removeMouseListener(mouseListener);
            TableCellRenderer defaultRenderer = this.tableHeader.getDefaultRenderer();
            if (defaultRenderer instanceof SortableHeaderRenderer) {
                this.tableHeader.setDefaultRenderer(((SortableHeaderRenderer) defaultRenderer).tableCellRenderer);
            }
        }
        this.tableHeader = tableHeader;
        if (this.tableHeader != null) {
            this.tableHeader.addMouseListener(mouseListener);
            this.tableHeader.setDefaultRenderer(
                    new SortableHeaderRenderer(this.tableHeader.getDefaultRenderer()));
        }
    }

    public boolean isSorting() {
        return !sortingColumns.isEmpty();
    }

    private Directive getDirective(int column) {
        for (int i = 0; i < sortingColumns.size(); i++) {
            Directive directive = sortingColumns.get(i);
            if (directive.column == column) {
                return directive;
            }
        }
        return EMPTY_DIRECTIVE;
    }

    public int getSortingStatus(int column) {
        return getDirective(column).direction;
    }

    private void sortingStatusChanged() {
        clearSortingState();
        fireTableDataChanged();
        if (tableHeader != null) {
            tableHeader.repaint();
        }
    }

    public void setSortingStatus(int column, int status) {
        Directive directive = getDirective(column);
        if (directive != EMPTY_DIRECTIVE) {
            sortingColumns.remove(directive);
        }
        if (status != NOT_SORTED) {
            sortingColumns.add(new Directive(column, status));
        }
        sortingStatusChanged();
    }

    protected Icon getHeaderRendererIcon(int column, int size) {
        Directive directive = getDirective(column);
        if (directive == EMPTY_DIRECTIVE) {
            return null;
        }
        return new Arrow(directive.direction == DESCENDING, size, sortingColumns.indexOf(directive));
    }

    private void cancelSorting() {
        sortingColumns.clear();
        sortingStatusChanged();
    }

    public void setColumnComparator(Class type, Comparator<Object> comparator) {
        if (comparator == null) {
            columnComparators.remove(type);
        } else {
            columnComparators.put(type, comparator);
        }
    }

    protected Comparator<Object> getComparator(int column) {
        Class columnType = tableModel.getColumnClass(column);
        Comparator<Object> comparator = columnComparators.get(columnType);
        if (comparator != null) {
            return comparator;
        }
        if (Comparable.class.isAssignableFrom(columnType)) {
            return COMPARABLE_COMPARATOR;
        }
        return LEXICAL_COMPARATOR;
    }

    private Row[] getViewToModel() {
        if (viewToModel == null) {
            int tableModelRowCount = tableModel.getRowCount();
            viewToModel = new Row[tableModelRowCount];
            for (int row = 0; row < tableModelRowCount; row++) {
                viewToModel[row] = new Row(row);
            }

            if (isSorting()) {
                Arrays.sort(viewToModel);
            }
        }
        return viewToModel;
    }

    public int modelIndex(int viewIndex) {
        return getViewToModel()[viewIndex].modelIndex;
    }

    private int[] getModelToView() {
        if (modelToView == null) {
            int n = getViewToModel().length;
            modelToView = new int[n];
            for (int i = 0; i < n; i++) {
                modelToView[modelIndex(i)] = i;
            }
        }
        return modelToView;
    }

    // TableModel interface methods
    @Override
    public int getRowCount() {
        return (tableModel == null) ? 0 : tableModel.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return (tableModel == null) ? 0 : tableModel.getColumnCount();
    }

    @Override
    public String getColumnName(int column) {
        return tableModel.getColumnName(column);
    }

    @Override
    public Class getColumnClass(int column) {
        return tableModel.getColumnClass(column);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return tableModel.isCellEditable(modelIndex(row), column);
    }

    @Override
    public Object getValueAt(int row, int column) {
//masuda^
        if (row > tableModel.getRowCount() - 1 || column > tableModel.getColumnCount()) {
            return null;
        }
//masuda$
        return tableModel.getValueAt(modelIndex(row), column);
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        tableModel.setValueAt(aValue, modelIndex(row), column);
    }

    // Helper classes
    private class Row implements Comparable<Row> {

        private int modelIndex;

        public Row(int index) {
            this.modelIndex = index;
        }

        @Override
        public int compareTo(Row o) {
            int row1 = modelIndex;
            int row2 = o.modelIndex;

            for (Iterator<Directive> it = sortingColumns.iterator(); it.hasNext();) {
                Directive directive = it.next();
                int column = directive.column;

                Object o1 = tableModel.getValueAt(row1, column);
                Object o2 = tableModel.getValueAt(row2, column);

                int comparison = 0;
                // Define null less than everything, except null.
                if (o1 == null && o2 == null) {
                    comparison = 0;
                } else if (o1 == null) {
                    comparison = -1;
                } else if (o2 == null) {
                    comparison = 1;
                } else {
                    comparison = getComparator(column).compare(o1, o2);
                }
                if (comparison != 0) {
//pns           Define null less than everything when DESCENDING,
//pns               and more than everything when ASCENDING,
//pns               so that null allways sink to the bottom.
                    if (directive.direction == DESCENDING) {
                        if (o1 == null) {
                            return 1;
                        }
                        if (o2 == null) {
                            return -1;
                        }
                        return -comparison;
                    } else {
                        if (o1 == null) {
                            return 1;
                        }
                        if (o2 == null) {
                            return -1;
                        }
                        return comparison;
                    }
                }
            }
            return 0;
        }
    }

    private class TableModelHandler implements TableModelListener {

        @Override
        public void tableChanged(TableModelEvent e) {
            // If we're not sorting by anything, just pass the event along.
            if (!isSorting()) {
                clearSortingState();
                fireTableChanged(e);
                return;
            }

            // If the table structure has changed, cancel the sorting; the
            // sorting columns may have been either moved or deleted from
            // the model.
            if (e.getFirstRow() == TableModelEvent.HEADER_ROW) {
                cancelSorting();
                fireTableChanged(e);
                return;
            }

            // We can map a cell event through to the view without widening
            // when the following conditions apply:
            //
            // a) all the changes are on one row (e.getFirstRow() == e.getLastRow()) and,
            // b) all the changes are in one column (column != TableModelEvent.ALL_COLUMNS) and,
            // c) we are not sorting on that column (getSortingStatus(column) == NOT_SORTED) and,
            // d) a reverse lookup will not trigger a sort (modelToView != null)
            //
            // Note: INSERT and DELETE events fail this test as they have column == ALL_COLUMNS.
            //
            // The last check, for (modelToView != null) is to see if modelToView
            // is already allocated. If we don't do this check; sorting can become
            // a performance bottleneck for applications where cells
            // change rapidly in different parts of the table. If cells
            // change alternately in the sorting column and then outside of
            // it this class can end up re-sorting on alternate cell updates -
            // which can be a performance problem for large tables. The last
            // clause avoids this problem.
            int column = e.getColumn();
            if (e.getFirstRow() == e.getLastRow()
                    && column != TableModelEvent.ALL_COLUMNS
                    && getSortingStatus(column) == NOT_SORTED
                    && modelToView != null) {
                int viewIndex = getModelToView()[e.getFirstRow()];
                fireTableChanged(new TableModelEvent(TableSorter.this,
                        viewIndex, viewIndex,
                        column, e.getType()));
                return;
            }

            // Something has happened to the data that may have invalidated the row order.
            clearSortingState();
            fireTableDataChanged();
        }
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            JTableHeader h = (JTableHeader) e.getSource();
            TableColumnModel columnModel = h.getColumnModel();
            int viewColumn = columnModel.getColumnIndexAtX(e.getX());
            int column = columnModel.getColumn(viewColumn).getModelIndex();
            if (column != -1) {
                int status = getSortingStatus(column);
                if (!e.isControlDown()) {
                    cancelSorting();
                }
                // Cycle the sorting states through {NOT_SORTED, ASCENDING, DESCENDING} or
                // {NOT_SORTED, DESCENDING, ASCENDING} depending on whether shift is pressed.
                status = status + (e.isShiftDown() ? -1 : 1);
                status = (status + 4) % 3 - 1; // signed mod, returning {-1, 0, 1}
                setSortingStatus(column, status);
            }
        }
    }

    private static class Arrow implements Icon {

        private final boolean descending;
        private final int size;
//masuda
        //private int priority;

        public Arrow(boolean descending, int size, int priority) {
            this.descending = descending;
            this.size = size;
//masuda
            //this.priority = priority;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {

//pns       use custom icon
            ImageIcon upIcon = new ImageIcon(getClass().getResource("/open/dolphin/resources/images/up.gif"));
            ImageIcon downIcon = new ImageIcon(getClass().getResource("/open/dolphin/resources/images/down.gif"));
            if (descending) {
                g.drawImage(downIcon.getImage(), x, y, null);
            } else {
                g.drawImage(upIcon.getImage(), x, y, null);
                /*
                 Color color = c == null ? Color.GRAY : c.getBackground();
                 // In a compound sort, make each succesive triangle 20%
                 // smaller than the previous one.
                 int dx = (int)(size/2*Math.pow(0.8, priority));
                 int dy = descending ? dx : -dx;
                 // Align icon (roughly) with font baseline.
                 y = y + 5*size/6 + (descending ? -dy : 0);
                 int shift = descending ? 1 : -1;
                 g.translate(x, y);
                 // Right diagonal.
                 g.setColor(color.darker());
                 g.drawLine(dx / 2, dy, 0, 0);
                 g.drawLine(dx / 2, dy + shift, 0, shift);
                 // Left diagonal.
                 g.setColor(color.brighter());
                 g.drawLine(dx / 2, dy, dx, 0);
                 g.drawLine(dx / 2, dy + shift, dx, shift);
                 // Horizontal line.
                 if (descending) {
                 g.setColor(color.darker().darker());
                 } else {
                 g.setColor(color.brighter().brighter());
                 }
                 g.drawLine(dx, 0, 0, 0);
                 g.setColor(color);
                 g.translate(-x, -y);
                 */
            }

            /*
             Color color = c == null ? Color.GRAY : c.getBackground();
             // In a compound sort, make each succesive triangle 20%
             // smaller than the previous one.
             int dx = (int)(size/2*Math.pow(0.8, priority));
             int dy = descending ? dx : -dx;
             // Align icon (roughly) with font baseline.
             y = y + 5*size/6 + (descending ? -dy : 0);
             int shift = descending ? 1 : -1;
             g.translate(x, y);

             // Right diagonal.
             g.setColor(color.darker());
             g.drawLine(dx / 2, dy, 0, 0);
             g.drawLine(dx / 2, dy + shift, 0, shift);

             // Left diagonal.
             g.setColor(color.brighter());
             g.drawLine(dx / 2, dy, dx, 0);
             g.drawLine(dx / 2, dy + shift, dx, shift);

             // Horizontal line.
             if (descending) {
             g.setColor(color.darker().darker());
             } else {
             g.setColor(color.brighter().brighter());
             }
             g.drawLine(dx, 0, 0, 0);

             g.setColor(color);
             g.translate(-x, -y);
             */
        }

        @Override
        public int getIconWidth() {
            return size;
        }

        @Override
        public int getIconHeight() {
            return size;
        }
    }

    private class SortableHeaderRenderer implements TableCellRenderer {

        private TableCellRenderer tableCellRenderer;

        public SortableHeaderRenderer(TableCellRenderer tableCellRenderer) {
            this.tableCellRenderer = tableCellRenderer;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
            Component c = tableCellRenderer.getTableCellRendererComponent(table,
                    value, isSelected, hasFocus, row, column);
            if (c instanceof JLabel) {
                JLabel l = (JLabel) c;
                l.setHorizontalTextPosition(JLabel.LEFT);
                int modelColumn = table.convertColumnIndexToModel(column);
                l.setIcon(getHeaderRendererIcon(modelColumn, l.getFont().getSize()));
            }
            return c;
        }
    }

    private static class Directive {

        private int column;
        private int direction;

        public Directive(int column, int direction) {
            this.column = column;
            this.direction = direction;
        }
    }
}