/*
 * Панель администрирования. Форма добавления удаления пользователей и паролей
 */
package secure;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class FleetPanel extends javax.swing.JFrame {

    public static String userID = null;

    public FleetPanel() {
        initComponents();
        retrieve();
        tableFleet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void retrieve() {
        DefaultTableModel userModel = new FleetPanelDBUpdater().getData();
        tableFleet.setModel(userModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFleet = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {     // наверное зджесь номер ряда
                return getValueAt(0, column).getClass();
            }
        };
        bDelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bRefresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: Administration Panel");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setText("Флот Авиакомпании \"Уральские Авиалинии\"");

        tableFleet.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID в базе данных", "Бортовой номер"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tableFleet.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableFleet);

        bDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bDelete.setText("Удалить");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sendToPilots.png"))); // NOI18N
        jButton2.setText("Добавить борт");
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

        jLabel2.setText("*База данных автоматически сортирует флот по алфавиту");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                                                .addGap(9, 9, 9)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                                        .addComponent(bRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                                        .addComponent(jLabel2))
                                .addContainerGap())
        );
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
                                                .addComponent(bRefresh)
                                                .addGap(56, 56, 56)
                                                .addComponent(bDelete))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
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
        FleetNewAircraft flt = new FleetNewAircraft();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 350) / 2;
        int locY = (screenSize.height - 260) / 2;
        flt.setLocation(locX, locY);
        flt.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshActionPerformed
        // обновить
        retrieve();
    }//GEN-LAST:event_bRefreshActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // кнопка удалить
        String userName;
        if (!tableFleet.getValueAt(tableFleet.getSelectedRow(), 2).equals("")) { //
            userID = tableFleet.getValueAt(tableFleet.getSelectedRow(), 2).toString();
            userName = tableFleet.getValueAt(tableFleet.getSelectedRow(), 1).toString();

            //диалог на удаление
            Object[] options = {"Удалить", "Отмена"};
            int n = JOptionPane.showOptionDialog(null, "Вы действительно собираетесь удалить бортовой номер  " + userName + "?", "Предупреждение!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                Boolean delete = new FleetPanelDBUpdater().delete(userID);
                JOptionPane.showMessageDialog(null,
                        "Бортовой номер был удален из флота АК!",
                        "Удаление бортового номера",
                        JOptionPane.INFORMATION_MESSAGE);
                retrieve();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для удаления, пожалуйста, выберите бортовой номер из списка",
                    "Вы не выбрали бортовой номер!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bRefresh;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableFleet;
    // End of variables declaration//GEN-END:variables
}
