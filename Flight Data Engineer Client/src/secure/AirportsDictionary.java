package secure;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AirportsDictionary extends javax.swing.JFrame {

    public static String strDeparture = null;
    public static String strArrival = null;
    public static String airportID = null;

    public AirportsDictionary() {
        initComponents();
        jtableAirports.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        retrieve();
    }

    private void retrieve() {
        DefaultTableModel dm = new AirportDBUpdater().getData();
        jtableAirports.setModel(dm);
        jtableAirports.getColumnModel().getColumn(0).setPreferredWidth(15);
        jtableAirports.getColumnModel().getColumn(1).setPreferredWidth(80);
        jtableAirports.getColumnModel().getColumn(2).setPreferredWidth(20);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableAirports = new javax.swing.JTable();
        bRefreshPerson = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bNewAirport = new javax.swing.JButton();
        bEditPilot = new javax.swing.JButton();
        bDeletePerson = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: Airports");
        setFocusCycleRoot(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Перечень аэропортов"));

        jtableAirports.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Название", "Код ИКАО"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jtableAirports.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jtableAirports.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtableAirports);

        bRefreshPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh-icon.png"))); // NOI18N
        bRefreshPerson.setText("Обновить");
        bRefreshPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshPersonActionPerformed(evt);
            }
        });

        jLabel1.setText("Подсказка: после редактирования/добавления нажмите Обновить");

        bNewAirport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/star.png"))); // NOI18N
        bNewAirport.setText("Новый аэропорт");
        bNewAirport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewAirportActionPerformed(evt);
            }
        });

        bEditPilot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        bEditPilot.setText("Редактировать");
        bEditPilot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditPilotActionPerformed(evt);
            }
        });

        bDeletePerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bDeletePerson.setText("Удалить");
        bDeletePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletePersonActionPerformed(evt);
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
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bRefreshPerson, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                        .addComponent(bEditPilot, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                        .addComponent(bNewAirport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bDeletePerson, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                                        .addComponent(jLabel1))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(bNewAirport)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bEditPilot)
                                                .addGap(18, 18, 18)
                                                .addComponent(bDeletePerson)
                                                .addGap(18, 18, 18)
                                                .addComponent(bRefreshPerson)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void bRefreshPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshPersonActionPerformed
        retrieve();
    }//GEN-LAST:event_bRefreshPersonActionPerformed

    private void bNewAirportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewAirportActionPerformed
    // Создать аэропорт

        AirportNew newAirport = new AirportNew();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 350) / 2;
        int locY = (screenSize.height - 260) / 2;
        newAirport.setLocation(locX, locY);
        newAirport.setVisible(true);

    }//GEN-LAST:event_bNewAirportActionPerformed

    private void bEditPilotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditPilotActionPerformed
    // Редактировать аэропорт
        if (!jtableAirports.getValueAt(jtableAirports.getSelectedRow(), 0).equals("")) {
            airportID = jtableAirports.getValueAt(jtableAirports.getSelectedRow(), 0).toString();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для редактирования, пожалуйста, выберите аэропорт из списка",
                    "Вы не выбрали аэропорт!",
                    JOptionPane.ERROR_MESSAGE);
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 350) / 2;
        int locY = (screenSize.height - 260) / 2;
        AirportEdit editAirportWindow = new AirportEdit(airportID);
        editAirportWindow.setLocation(locX, locY);
        editAirportWindow.setVisible(true);
    }//GEN-LAST:event_bEditPilotActionPerformed

    private void bDeletePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletePersonActionPerformed
        // кнопка удалить
        String airportName;
        if (!jtableAirports.getValueAt(jtableAirports.getSelectedRow(), 0).equals("")) { //
            airportID = jtableAirports.getValueAt(jtableAirports.getSelectedRow(), 0).toString();
            airportName = jtableAirports.getValueAt(jtableAirports.getSelectedRow(), 1).toString();

            //диалог на удаление
            Object[] options = {"Удалить", "Отмена"};
            int n = JOptionPane.showOptionDialog(null, "Вы действительно собираетесь удалить  " + airportName + "?", "Предупреждение!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                Boolean delete = new AirportDBUpdater().delete(airportID);
                JOptionPane.showMessageDialog(null,
                        airportName + " был удален из списка!",
                        "Удаление аэропорта",
                        JOptionPane.INFORMATION_MESSAGE);
                retrieve();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для удаления, пожалуйста, выберите аэропорт из списка",
                    "Вы не выбрали аэропорт!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bDeletePersonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDeletePerson;
    private javax.swing.JButton bEditPilot;
    private javax.swing.JButton bNewAirport;
    private javax.swing.JButton bRefreshPerson;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableAirports;
    // End of variables declaration//GEN-END:variables
}
