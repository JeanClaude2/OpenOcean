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
public class BaseView extends javax.swing.JPanel implements IBaseView {

    /** Creates new form Baka */
    public BaseView() {
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
        jLabel2 = new javax.swing.JLabel();
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
        partialChk = new javax.swing.JCheckBox();
        numberCombo = new javax.swing.JComboBox();
        numberLabel = new javax.swing.JLabel();

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
        setTable.setToolTipText("セット内容は Drag & Drop で順番を入れ替えることができます。"); // NOI18N
        jScrollPane1.setViewportView(setTable);

        techChk.setText("診療行為"); // NOI18N
        techChk.setToolTipText("診療行為がセットにあればチェックされます。"); // NOI18N
        techChk.setEnabled(false);

        jLabel2.setText("セット名"); // NOI18N

        stampNameField.setBackground(new java.awt.Color(255, 255, 0));
        stampNameField.setToolTipText("セット名を入力します。"); // NOI18N

        okCntBtn.setToolTipText("セットをカルテに展開し継続します。"); // NOI18N

        okBtn.setToolTipText("セットをカルテに展開し終了します。"); // NOI18N

        clearBtn.setToolTipText("セット内容をクリアします。"); // NOI18N

        deleteBtn.setToolTipText("選択した項目を削除します。"); // NOI18N

        searchTextField.setToolTipText("検索したい点数マスタ項目を入力します。"); // NOI18N

        rtBtn.setText("RT"); // NOI18N
        rtBtn.setToolTipText("チェックすると入力中にリアルタイムで検索します。"); // NOI18N

        countField.setToolTipText("検索結果の件数を表示します。"); // NOI18N

        jLabel4.setText("件数"); // NOI18N

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

        partialChk.setText("部分一致"); // NOI18N

        numberCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("open/dolphin/order/Bundle"); // NOI18N
        numberCombo.setToolTipText(bundle.getString("BaseView.numberCombo.toolTipText")); // NOI18N
        numberCombo.setName("numberCombo"); // NOI18N

        numberLabel.setText(bundle.getString("BaseView.numberLabel.text")); // NOI18N
        numberLabel.setName("numberLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(techChk))
            .addComponent(jScrollPane2)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stampNameField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rtBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(partialChk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(okCntBtn))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(techChk)
                        .addComponent(numberCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numberLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okCntBtn)
                    .addComponent(okBtn)
                    .addComponent(clearBtn)
                    .addComponent(deleteBtn)
                    .addComponent(jLabel2)
                    .addComponent(stampNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(rtBtn)
                    .addComponent(partialChk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JTextField countField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox numberCombo;
    private javax.swing.JLabel numberLabel;
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
