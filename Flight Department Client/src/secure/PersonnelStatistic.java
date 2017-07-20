package secure;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class PersonnelStatistic extends javax.swing.JFrame {

    public static String pilotIDtoStat = null;

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

    public PersonnelStatistic() {
        initComponents();
        retrieve();
        personTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private StatisticIndividual parent;

    public void setParent(StatisticIndividual stInd) {
        this.parent = stInd;
    }

    @Override
    public StatisticIndividual getParent() {
        return this.parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personTable = new javax.swing.JTable();
        bAddKVS = new javax.swing.JButton();

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

        bAddKVS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/okey.png"))); // NOI18N
        bAddKVS.setText("Выбрать");
        bAddKVS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddKVSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
                                        .addComponent(bAddKVS, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bAddKVS)
                                .addGap(42, 42, 42))
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

    private void bAddKVSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddKVSActionPerformed
        // Заполнить значение КВС ID
        String id = "";
        if (personTable.getSelectedRow() != -1) { //
            id = personTable.getValueAt(personTable.getSelectedRow(), 2).toString();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Пожалуйста, выберите из списка персонала ЛО члена экипажа",
                    "Выбор персонала",
                    JOptionPane.ERROR_MESSAGE);
        }
        this.parent.setKVSid(id);
        dispose();
    }//GEN-LAST:event_bAddKVSActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddKVS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable personTable;
    // End of variables declaration//GEN-END:variables
}
