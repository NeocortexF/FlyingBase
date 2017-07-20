/*
 * Панель администрирования. Форма добавления удаления пользователей и паролей
 */
package secure;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AdminPanel extends javax.swing.JFrame {

    public static String userID = null;

    public AdminPanel() {
        initComponents();
        retrieve();
        tableUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void retrieve() {
        DefaultTableModel userModel = new AdminPanelDBUpdater().getData();
        tableUsers.setModel(userModel);
        tableUsers.getColumnModel().getColumn(0).setPreferredWidth(25);
        tableUsers.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsers = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {     // наверное зджесь номер ряда
                return getValueAt(0, column).getClass();
            }
        };
        bDelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bRefresh = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: Administration Panel");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setText("Список пользователей");

        tableUsers.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Имя пользователя", "Пароль"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tableUsers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableUsers);

        bDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bDelete.setText("Удалить");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/сreate user.png"))); // NOI18N
        jButton2.setText("Добавить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh-icon.png"))); // NOI18N
        bRefresh.setText("Обновить");
        bRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshActionPerformed(evt);
            }
        });

        bEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        bEdit.setText("Редактировать");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        jLabel2.setText("*база данных автоматически сортирует пользователей по ФИО в этом списке");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(bRefresh)
                                                        .addComponent(bDelete)
                                                        .addComponent(bEdit)
                                                        .addComponent(jButton2)))
                                        .addComponent(jLabel2))
                                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[]{bDelete, bEdit, bRefresh, jButton2});

        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bEdit)
                                                .addGap(69, 69, 69)
                                                .addComponent(bRefresh)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bDelete))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Создать пользователя
        AdminUserCreate adm = new AdminUserCreate();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 350) / 2;
        int locY = (screenSize.height - 260) / 2;
        adm.setLocation(locX, locY);
        adm.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshActionPerformed
        // обновить
        retrieve();
    }//GEN-LAST:event_bRefreshActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // кнопка удалить
        String userName;
        if (!tableUsers.getValueAt(tableUsers.getSelectedRow(), 0).equals("")) { //
            userID = tableUsers.getValueAt(tableUsers.getSelectedRow(), 0).toString();
            userName = tableUsers.getValueAt(tableUsers.getSelectedRow(), 1).toString();

            //диалог на удаление
            Object[] options = {"Удалить", "Отмена"};
            int n = JOptionPane.showOptionDialog(null, "Вы действительно собираетесь удалить пользователя  " + userName + "?", "Предупреждение!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                Boolean delete = new AdminPanelDBUpdater().delete(userID);
                JOptionPane.showMessageDialog(null,
                        "Пользователь был удален!",
                        "Удаление пользователя",
                        JOptionPane.INFORMATION_MESSAGE);
                retrieve();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для удаления, пожалуйста, выберите пользователя из списка",
                    "Вы не выбрали пользователя!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // редактировать пользователя
        if (!tableUsers.getValueAt(tableUsers.getSelectedRow(), 0).equals("")) {
            userID = tableUsers.getValueAt(tableUsers.getSelectedRow(), 0).toString();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для детального просмотра, пожалуйста, выберите пользователя из списка",
                    "Вы не выбрали пользователя!",
                    JOptionPane.ERROR_MESSAGE);
        }


        AdminPanelEdit admEd = new AdminPanelEdit(userID);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 350) / 2;
        int locY = (screenSize.height - 260) / 2;
        admEd.setLocation(locX, locY);
        admEd.setVisible(true);
    }//GEN-LAST:event_bEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bRefresh;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUsers;
    // End of variables declaration//GEN-END:variables
}
