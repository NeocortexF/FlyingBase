package secure;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AirportsCreate extends javax.swing.JFrame {

    public static String strDeparture = null;
    public static String strArrival = null;
    public static String airportID = null;

    public AirportsCreate() {
        initComponents();
        jtableAirports.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        retrieve();
    }

    private void retrieve() {
        DefaultTableModel dm = new AirportDBUpdater().getData();
        jtableAirports.setModel(dm);
        jtableAirports.getColumnModel().getColumn(0).setPreferredWidth(40);
        jtableAirports.getColumnModel().getColumn(0).setMaxWidth(40);
        jtableAirports.getColumnModel().getColumn(2).setPreferredWidth(70);
        jtableAirports.getColumnModel().getColumn(2).setMaxWidth(70);
    }

    //взаимодействие между окнами
    //создаем ссылку на родителя
    private WorkingWindowCreate parent;

    public void setParent(WorkingWindowCreate ww) {
        this.parent = ww;
    }

    @Override
    public WorkingWindowCreate getParent() {
        return this.parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableAirports = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        jButton1.setText("Заполнить а/п вылета");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Заполнить а/п посадки");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("* после редактирования/добавления нажмите Обновить");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                                .addComponent(jButton2))
                                        .addComponent(jLabel1))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // аэропорт вылета
        // проверяем выбран ли какой то пункт. метод возращает -1 если ничего не выбрано
        if (jtableAirports.getSelectedRow() != -1) {
            strDeparture = jtableAirports.getValueAt(jtableAirports.getSelectedRow(), 2).toString();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для заполенения текстового поля 'Аэропорт вылета', пожалуйста, выберите доступное имя аэропорта из списка или введите его в поле вручную",
                    "Вы не выбрали аэропорт вылета!",
                    JOptionPane.ERROR_MESSAGE);
        }
        this.parent.getTxtDeparture().setText(strDeparture);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // аэропорт посадки
        if (jtableAirports.getSelectedRow() != -1) {
            strArrival = jtableAirports.getValueAt(jtableAirports.getSelectedRow(), 2).toString();
            this.parent.getTxtArrival().setText(strArrival);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для заполенения текстового поля 'Аэропорт посадки', пожалуйста, выберите доступное имя аэропорта из списка или введите его в поле вручную",
                    "Вы не выбрали аэропорт посадки!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableAirports;
    // End of variables declaration//GEN-END:variables
}
