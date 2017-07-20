package secure;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Personnel extends javax.swing.JFrame {

    public static String pilotID = null;

    private void retrieve() {
        DefaultTableModel dmPerson = new PersonnelDBUpdater().getData();
        personTable.setModel(dmPerson);

        personTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        personTable.getColumnModel().getColumn(0).setMaxWidth(70);
        personTable.getColumnModel().getColumn(2).setPreferredWidth(90);
        personTable.getColumnModel().getColumn(2).setMaxWidth(90);
        personTable.getColumnModel().getColumn(3).setPreferredWidth(90);
        personTable.getColumnModel().getColumn(3).setMaxWidth(90);
    }


    public Personnel() {
        initComponents();
        retrieve();
        personTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private WorkingWindow3 parent;

    public void setParent(WorkingWindow3 ww3) {
        this.parent = ww3;
    }

    @Override
    public WorkingWindow3 getParent() {
        return this.parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();
        bAddKVS = new javax.swing.JButton();
        bAddVP = new javax.swing.JButton();
        bNewPilot = new javax.swing.JButton();
        bEditPilot = new javax.swing.JButton();
        bRefreshPerson = new javax.swing.JButton();
        bDeletePerson = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: Flight Department Personnel");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        personTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Фамилия Имя Отчество", "Табельный №", "Номер АЭ", "Должность"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        personTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(personTable);

        bAddKVS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pilot.png"))); // NOI18N
        bAddKVS.setText("Заполнить КВС ID");
        bAddKVS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddKVSActionPerformed(evt);
            }
        });

        bAddVP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pilot.png"))); // NOI18N
        bAddVP.setText("Заполнить ВП ID");
        bAddVP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddVPActionPerformed(evt);
            }
        });

        bNewPilot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pilotNew.png"))); // NOI18N
        bNewPilot.setText("Новый пилот");
        bNewPilot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewPilotActionPerformed(evt);
            }
        });

        bEditPilot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        bEditPilot.setText("Редактировать");
        bEditPilot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditPilotActionPerformed(evt);
            }
        });

        bRefreshPerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh-icon.png"))); // NOI18N
        bRefreshPerson.setText("Обновить");
        bRefreshPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshPersonActionPerformed(evt);
            }
        });

        bDeletePerson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bDeletePerson.setText("Удалить");
        bDeletePerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletePersonActionPerformed(evt);
            }
        });

        jLabel1.setText("Подсказка: после редактирования/добавления нажмите Обновить");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(bAddKVS)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bAddVP))
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(bRefreshPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bDeletePerson, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(bNewPilot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bEditPilot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bNewPilot)
                                        .addComponent(bRefreshPerson)
                                        .addComponent(bAddKVS)
                                        .addComponent(bAddVP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(bDeletePerson)
                                                .addComponent(bEditPilot))
                                        .addComponent(jLabel1))
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

    private void bNewPilotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewPilotActionPerformed
    // Создать пилота
        PersonnelNewPilot newPilotWindow = new PersonnelNewPilot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 350) / 2;
        int locY = (screenSize.height - 260) / 2;
        newPilotWindow.setLocation(locX, locY);
        newPilotWindow.setVisible(true);

    }//GEN-LAST:event_bNewPilotActionPerformed

    private void bEditPilotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditPilotActionPerformed
    // Редактировать пилота
        if (!personTable.getValueAt(personTable.getSelectedRow(), 0).equals("")) {
            pilotID = personTable.getValueAt(personTable.getSelectedRow(), 0).toString();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для редактирования, пожалуйста, выберите летчика из списка",
                    "Вы не выбрали летчика!",
                    JOptionPane.ERROR_MESSAGE);
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 350) / 2;
        int locY = (screenSize.height - 260) / 2;
        PersonnelEdit editPilotWindow = new PersonnelEdit(pilotID);
        editPilotWindow.setLocation(locX, locY);
        editPilotWindow.setVisible(true);
    }//GEN-LAST:event_bEditPilotActionPerformed

    private void bRefreshPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshPersonActionPerformed
        // обновить
        retrieve();
    }//GEN-LAST:event_bRefreshPersonActionPerformed

    private void bDeletePersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletePersonActionPerformed
        // кнопка удалить
        String userName;
        if (!personTable.getValueAt(personTable.getSelectedRow(), 0).equals("")) { //
            pilotID = personTable.getValueAt(personTable.getSelectedRow(), 0).toString();
            userName = personTable.getValueAt(personTable.getSelectedRow(), 1).toString();

            //диалог на удаление
            Object[] options = {"Удалить", "Отмена"};
            int n = JOptionPane.showOptionDialog(null, "Вы действительно собираетесь удалить  " + userName + "?", "Предупреждение!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                Boolean delete = new PersonnelDBUpdater().delete(pilotID);
                JOptionPane.showMessageDialog(null,
                        userName + " был удален из списка ЛО!",
                        "Удаление пилота из списка",
                        JOptionPane.INFORMATION_MESSAGE);
                retrieve();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для удаления, пожалуйста, выберите летчика из списка",
                    "Вы не выбрали летчика!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bDeletePersonActionPerformed

    private void bAddKVSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddKVSActionPerformed
        // Заполнить значение КВС ID
        String id = "";
        if (personTable.getSelectedRow() != -1) { //
            id = personTable.getValueAt(personTable.getSelectedRow(), 2).toString();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для заполнение графы 'КВС ID', пожалуйста, выберите из списка персонала ЛО члена экипажа",
                    "Выбор персонала",
                    JOptionPane.ERROR_MESSAGE);
        }
        this.parent.setKVSid(id);
    }//GEN-LAST:event_bAddKVSActionPerformed

    private void bAddVPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddVPActionPerformed
        // Заполнить значение второй пилот ID
        String id = "";

        if (personTable.getSelectedRow() != -1) { //
            id = personTable.getValueAt(personTable.getSelectedRow(), 2).toString();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для заполнение графы 'ВП ID', пожалуйста, выберите из списка персонала ЛО члена экипажа",
                    "Выбор персонала",
                    JOptionPane.ERROR_MESSAGE);
        }
        this.parent.setVPid(id);
    }//GEN-LAST:event_bAddVPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddKVS;
    private javax.swing.JButton bAddVP;
    private javax.swing.JButton bDeletePerson;
    private javax.swing.JButton bEditPilot;
    private javax.swing.JButton bNewPilot;
    private javax.swing.JButton bRefreshPerson;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable personTable;
    // End of variables declaration//GEN-END:variables
}
