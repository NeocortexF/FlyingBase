package secure;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ClassificatorSubcategoryUI extends javax.swing.JFrame {

    private void retrieve() {
        //заполняем таблицу
        AbstractTableModel dmClassificator = new ClassificatorUpdater().getSubCategory();
        subcategoryTable.setModel(dmClassificator);
        subcategoryTable.getColumnModel().getColumn(0).setPreferredWidth(90);
        subcategoryTable.getColumnModel().getColumn(0).setMaxWidth(150);
        subcategoryTable.getColumnModel().getColumn(1).setPreferredWidth(90);
        subcategoryTable.getColumnModel().getColumn(1).setMaxWidth(150);
    }

    public ClassificatorSubcategoryUI() {
        initComponents();
        retrieve();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subcategoryTable = new javax.swing.JTable();
        bSave = new javax.swing.JButton();
        bAddRow = new javax.swing.JButton();
        bDeleteRow = new javax.swing.JButton();
        bMoveUp = new javax.swing.JButton();
        bMoveDown = new javax.swing.JButton();
        bCategoryChange = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Classificator");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        subcategoryTable.setFont(new java.awt.Font("Tahoma", 0, 14));
        subcategoryTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "№ по порядку", "Категория", "Пункт классификатора"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        subcategoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(subcategoryTable);

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

        bCategoryChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newcategory.png"))); // NOI18N
        bCategoryChange.setToolTipText("Изменить категории классификатора");
        bCategoryChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCategoryChangeActionPerformed(evt);
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
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
                                                .addComponent(bSave))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bMoveDown)
                                        .addComponent(bMoveUp)
                                        .addComponent(bCategoryChange))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(bCategoryChange)
                                                .addGap(131, 131, 131)
                                                .addComponent(bMoveUp)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bMoveDown))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
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
        DefaultTableModel model = (DefaultTableModel) subcategoryTable.getModel();
        int[] rows = subcategoryTable.getSelectedRows();
        model.moveRow(rows[0], rows[rows.length - 1], rows[0] - 1);
        subcategoryTable.setRowSelectionInterval(rows[0] - 1, rows[rows.length - 1] - 1);
    }

    private void moveDown() {
        DefaultTableModel model = (DefaultTableModel) subcategoryTable.getModel();
        int[] rows = subcategoryTable.getSelectedRows();
        model.moveRow(rows[0], rows[rows.length - 1], rows[0] + 1);
        subcategoryTable.setRowSelectionInterval(rows[0] + 1, rows[rows.length - 1] + 1);
    }

    public Object[] getDataFromTable() {
        DefaultTableModel model = (DefaultTableModel) subcategoryTable.getModel();
        int rows = model.getRowCount();
        Object[] dataFromTable;
        ArrayList dataFromTableList = new ArrayList();
        for (int row = 0; row < rows; row++) {
            int id = row;
            Object catid = subcategoryTable.getValueAt(row, 1);
            Object catname = subcategoryTable.getValueAt(row, 2);
            dataFromTableList.add(id);
            dataFromTableList.add(catid);
            dataFromTableList.add(catname);
        }
        dataFromTable = dataFromTableList.toArray();
        return dataFromTable;
    }

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        DefaultTableModel model = (DefaultTableModel) subcategoryTable.getModel();
        Object[] data = getDataFromTable();
        int rows = model.getRowCount();
        ClassificatorUpdater updater = new ClassificatorUpdater();
        updater.cleanTableSubcategory();
        updater.saveDataFromTableToSQL(data, rows);
        JOptionPane.showMessageDialog(null, "Изменения успешно сохранены");
    }//GEN-LAST:event_bSaveActionPerformed

    private void bAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddRowActionPerformed

        DefaultTableModel model = (DefaultTableModel) subcategoryTable.getModel();
        int lastRow = model.getRowCount();
        model.addRow(new Object[]{lastRow, 0, ""});
    }//GEN-LAST:event_bAddRowActionPerformed

    private void bDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteRowActionPerformed

        DefaultTableModel model = (DefaultTableModel) subcategoryTable.getModel();
        int row = subcategoryTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, выберите пункт классификатора для удаления");
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

    private void bCategoryChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCategoryChangeActionPerformed
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 500) / 2;
        int locY = (screenSize.height - 480) / 2;
        ClassificatorCatUI classificatorUI = new ClassificatorCatUI();
        classificatorUI.setLocation(locX, locY);
        classificatorUI.setVisible(true);
    }//GEN-LAST:event_bCategoryChangeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddRow;
    private javax.swing.JButton bCategoryChange;
    private javax.swing.JButton bDeleteRow;
    private javax.swing.JButton bMoveDown;
    private javax.swing.JButton bMoveUp;
    private javax.swing.JButton bSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable subcategoryTable;
    // End of variables declaration//GEN-END:variables
}
