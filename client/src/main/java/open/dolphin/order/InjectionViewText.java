/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Baka.java
 *
 * Created on 2009/05/09, 9:13:54
 */

package open.dolphin.order;

/**
 *
 * @author kushiro
 */
public class InjectionViewText extends javax.swing.JPanel implements IInjectionView {

    /** Creates new form Baka */
    public InjectionViewText() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        setTable = new javax.swing.JTable();
        techChk = new javax.swing.JCheckBox();
        stampNameField = new javax.swing.JTextField();
        okCntBtn = new javax.swing.JButton();
        okBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        rtBtn = new javax.swing.JCheckBox();
        countField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchResultTable = new javax.swing.JTable();
        noChargeChk = new javax.swing.JCheckBox();
        partialChk = new javax.swing.JCheckBox();
        numberCombo = new javax.swing.JComboBox();
        numberComobo = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 11, 11));
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));

        infoLabel.setText("info"); // NOI18N

        setTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("open/dolphin/order/resources/InjectionView"); // NOI18N
        setTable.setToolTipText(bundle.getString("setTable.toolTipText")); // NOI18N
        jScrollPane1.setViewportView(setTable);

        techChk.setText(bundle.getString("teckChk.text")); // NOI18N
        techChk.setToolTipText(bundle.getString("techChk.toolTipText")); // NOI18N
        techChk.setEnabled(false);

        stampNameField.setBackground(new java.awt.Color(255, 255, 0));
        stampNameField.setToolTipText(bundle.getString("stampNameField.toolTipText")); // NOI18N

        okCntBtn.setText(bundle.getString("okCntBtn.text")); // NOI18N
        okCntBtn.setToolTipText(bundle.getString("okCntBtn.toolTipText")); // NOI18N

        okBtn.setText(bundle.getString("okBtn.text")); // NOI18N
        okBtn.setToolTipText(bundle.getString("okBtn.toolTipText")); // NOI18N

        clearBtn.setText(bundle.getString("clearBtn.text")); // NOI18N
        clearBtn.setToolTipText(bundle.getString("clearBtn.toolTipText")); // NOI18N

        deleteBtn.setText(bundle.getString("deleteBtn.text")); // NOI18N
        deleteBtn.setToolTipText(bundle.getString("deleteBtn.toolTipText")); // NOI18N

        searchTextField.setToolTipText(bundle.getString("searchTextField.toolTipText")); // NOI18N

        rtBtn.setText(bundle.getString("rtBtn.text")); // NOI18N
        rtBtn.setToolTipText(bundle.getString("rtBtn.toolTipText")); // NOI18N

        countField.setToolTipText(bundle.getString("countField.toolTipText")); // NOI18N

        jLabel4.setText(bundle.getString("jLabel4.text")); // NOI18N

        searchResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(searchResultTable);

        noChargeChk.setText(bundle.getString("noChargeChk.text")); // NOI18N
        noChargeChk.setToolTipText(bundle.getString("noChargeChk.toolTipText")); // NOI18N

        partialChk.setText(bundle.getString("partialCh.text")); // NOI18N
        partialChk.setToolTipText(bundle.getString("partialCh.toolTipText")); // NOI18N

        numberCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        numberCombo.setToolTipText(bundle.getString("numberCombo.toolTipText")); // NOI18N
        numberCombo.setName("numberCombo"); // NOI18N

        numberComobo.setText(bundle.getString("numberComobo.text")); // NOI18N
        numberComobo.setName("numberComobo"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numberComobo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noChargeChk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(techChk))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(stampNameField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rtBtn)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(partialChk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(countField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(deleteBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(okBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(okCntBtn))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(techChk)
                            .addComponent(noChargeChk)
                            .addComponent(numberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberComobo))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(infoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn)
                    .addComponent(clearBtn)
                    .addComponent(okBtn)
                    .addComponent(okCntBtn)
                    .addComponent(stampNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rtBtn)
                        .addComponent(partialChk)
                        .addComponent(jLabel4)
                        .addComponent(countField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField countField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox noChargeChk;
    private javax.swing.JComboBox numberCombo;
    private javax.swing.JLabel numberComobo;
    private javax.swing.JButton okBtn;
    private javax.swing.JButton okCntBtn;
    private javax.swing.JCheckBox partialChk;
    private javax.swing.JCheckBox rtBtn;
    private javax.swing.JTable searchResultTable;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable setTable;
    private javax.swing.JTextField stampNameField;
    private javax.swing.JCheckBox techChk;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the clearBtn
     */
    @Override
    public javax.swing.JButton getClearBtn() {
        return clearBtn;
    }

    /**
     * @return the countField
     */
    @Override
    public javax.swing.JTextField getCountField() {
        return countField;
    }

    /**
     * @return the deleteBtn
     */
    @Override
    public javax.swing.JButton getDeleteBtn() {
        return deleteBtn;
    }

    /**
     * @return the infoLabel
     */
    @Override
    public javax.swing.JLabel getInfoLabel() {
        return infoLabel;
    }

    /**
     * @return the okBtn
     */
    @Override
    public javax.swing.JButton getOkBtn() {
        return okBtn;
    }

    /**
     * @return the okCntBtn
     */
    @Override
    public javax.swing.JButton getOkCntBtn() {
        return okCntBtn;
    }

    /**
     * @return the rtBtn
     */
    @Override
    public javax.swing.JCheckBox getRtBtn() {
        return rtBtn;
    }

    /**
     * @return the searchResultTabel
     */
    @Override
    public javax.swing.JTable getSearchResultTable() {
        return searchResultTable;
    }

    /**
     * @return the searchTextField
     */
    @Override
    public javax.swing.JTextField getSearchTextField() {
        return searchTextField;
    }

    /**
     * @return the stampNameField
     */
    @Override
    public javax.swing.JTextField getStampNameField() {
        return stampNameField;
    }

    /**
     * @return the techChk
     */
    @Override
    public javax.swing.JCheckBox getTechChk() {
        return techChk;
    }

    /**
     * @return the setTable
     */
    @Override
    public javax.swing.JTable getSetTable() {
        return setTable;
    }

    @Override
    public javax.swing.JCheckBox getNoChargeChk() {
        return noChargeChk;
    }

    @Override
    public javax.swing.JCheckBox getPartialChk() {
        return partialChk;
    }

    @Override
    public javax.swing.JComboBox getNumberCombo() {
        return numberCombo;
    }

//s.oh^ 2014/10/22 Icon表示
    @Override
    public javax.swing.JLabel getSearchLabel() {
        return jLabel3;
    }
//s.oh$

}
