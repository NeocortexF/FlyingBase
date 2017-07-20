package secure;

import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ClassificatorCatUI extends javax.swing.JFrame {

    private void retrieve() {
        AbstractTableModel dmClassificator = new ClassificatorUpdater().getCategory();
        categoryTable.setModel(dmClassificator);
        categoryTable.getColumnModel().getColumn(0).setPreferredWidth(90);
        categoryTable.getColumnModel().getColumn(0).setMaxWidth(150);
    }

    public ClassificatorCatUI() {
        initComponents();
        retrieve();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        bSave = new javax.swing.JButton();
        bAddRow = new javax.swing.JButton();
        bDeleteRow = new javax.swing.JButton();
        bMoveUp = new javax.swing.JButton();
        bMoveDown = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Classificator");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        categoryTable.setFont(new java.awt.Font("Tahoma", 0, 14));
        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "№ категории", "Имя категории"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        categoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(categoryTable);

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        bSave.setText("Сохранить");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bAddRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/category.png"))); // NOI18N
        bAddRow.setText("Вставить ряд");
        bAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddRowActionPerformed(evt);
            }
        });

        bDeleteRow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bDeleteRow.setText("Удалить ряд");
        bDeleteRow.setToolTipText("Удаление работает в режиме редактора таблицы! Не забудьте нажать сохранить, после удаления или внесения других изменений в таблицу. (Как отображается таблица на экране, так и будет занесена в БД)");
        bDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteRowActionPerformed(evt);
            }
        });

        bMoveUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow up.png"))); // NOI18N
        bMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMoveUpActionPerformed(evt);
            }
        });

        bMoveDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow down.png"))); // NOI18N
        bMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMoveDownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(bAddRow)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bDeleteRow)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bSave))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bMoveDown)
                                        .addComponent(bMoveUp))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(172, 172, 172)
                                                .addComponent(bMoveUp)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bMoveDown))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bAddRow)
                                        .addComponent(bDeleteRow)
                                        .addComponent(bSave))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moveUp() {
        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();
        int[] rows = categoryTable.getSelectedRows();
        model.moveRow(rows[0], rows[rows.length - 1], rows[0] - 1);
        categoryTable.setRowSelectionInterval(rows[0] - 1, rows[rows.length - 1] - 1);
    }

    private void moveDown() {
        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();
        int[] rows = categoryTable.getSelectedRows();
        model.moveRow(rows[0], rows[rows.length - 1], rows[0] + 1);
        categoryTable.setRowSelectionInterval(rows[0] + 1, rows[rows.length - 1] + 1);
    }

    public Object[] getDataFromTable() {
        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();
        int rows = model.getRowCount();
        Object[] dataFromTable;
        ArrayList dataFromTableList = new ArrayList();
        for (int row = 0; row < rows; row++) {
            int id = row + 1;
            Object catname = categoryTable.getValueAt(row, 1);
            dataFromTableList.add(id);
            dataFromTableList.add(catname);
        }
        dataFromTable = dataFromTableList.toArray();
        return dataFromTable;
    }

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();
        Object[] data = getDataFromTable();
        int rows = model.getRowCount();
        ClassificatorUpdater updater = new ClassificatorUpdater();
        updater.cleanTableСategory();
        updater.saveDataFromCategory(data, rows);
        JOptionPane.showMessageDialog(null, "Изменения успешно сохранены");
    }//GEN-LAST:event_bSaveActionPerformed

    private void bAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddRowActionPerformed

        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();
        int lastRow = model.getRowCount() + 1;
        model.addRow(new Object[]{lastRow, ""});
    }//GEN-LAST:event_bAddRowActionPerformed

    private void bDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteRowActionPerformed

        DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();
        int row = categoryTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, выберите ряд для удаления");
        } else {
            Object[] options = {"Удалить", "Отмена"};
            int n = JOptionPane.showOptionDialog(null, "Вы действительно собираетесь удалить выбранный ряд?", "Предупреждение!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                model.removeRow(row);
            }
        }
    }//GEN-LAST:event_bDeleteRowActionPerformed

    private void bMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMoveUpActionPerformed
        moveUp();
    }//GEN-LAST:event_bMoveUpActionPerformed

    private void bMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMoveDownActionPerformed
        moveDown();
    }//GEN-LAST:event_bMoveDownActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddRow;
    private javax.swing.JButton bDeleteRow;
    private javax.swing.JButton bMoveDown;
    private javax.swing.JButton bMoveUp;
    private javax.swing.JButton bSave;
    private javax.swing.JTable categoryTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
