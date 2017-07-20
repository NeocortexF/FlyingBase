package secure;

import java.awt.Color;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class WorkingWindow3 extends javax.swing.JFrame {

    private String globalIncNbr;
    private String corActFIO;
    private String talonCloseFIO;
    private String insideStr;
    private String folderName = "";
    private boolean comboChanged = false;
    private Scanner scan;

    public WorkingWindow3(String str) throws ParseException {
        initComponents();
        insideStr = str;
        folderName = str;
        retrieve(str);
    }

    private void retrieve(String str) throws ParseException {
        //заполняем таблицу
        DefaultTableModel dmWW = new DBUpdaterWorkingWindow().getLookData(str);
        tableGeneralInfo.setModel(dmWW);
        //глобальная переменная инкамин намбер
        globalIncNbr = tableGeneralInfo.getValueAt(0, 0).toString();
        //заполняем остальные поля в нередактируемой зоне
        Object[] data = new DBUpdaterWorkingWindow().getEventsData(str);

        Color greenMatrix = new Color(34, 177, 76);
        Color yellowMatrix = new Color(255, 242, 0);
        Color orangeMatrix = new Color(255, 127, 39);
        Color redMatrix = new Color(237, 28, 36);

        if (data[0] == null) {
        } else {
            tfEvent1.setText(data[0].toString());
        }
        if (data[1] == null) {
        } else {
            tfAirFASE1.setText(data[1].toString());
        }
        if (data[2] == null) {
        } else {
            String parseAssesment = data[2].toString();
            if (parseAssesment.contains("Низкий")) {
                tfAss1.setText("Низкий риск 1-10");
                tfAss1.setBackground(greenMatrix);
            } else if (parseAssesment.contains("Умерен")) {
                tfAss1.setText("Умеренный риск 20-50");
                tfAss1.setBackground(yellowMatrix);
            } else if (parseAssesment.contains("Высокий")) {
                tfAss1.setText("Высокий риск 100-102");
                tfAss1.setBackground(orangeMatrix);
            } else if (parseAssesment.contains("Недоп")) {
                tfAss1.setText("Недопустимый риск 500-2500");
                tfAss1.setBackground(redMatrix);
            } else if (parseAssesment.contains("учит")) {
                tfAss1.setText("Не учитывать");
                tfAss1.setBackground(Color.WHITE);
            } else if (parseAssesment.contains("действ")) {
                tfAss1.setText("Не действительно");
                tfAss1.setBackground(Color.WHITE);
            } else {
                tfAss1.setText("");
                tfAss1.setBackground(Color.WHITE);
            }
        }
        if (data[3] == null) {
        } else {
            tfEvent2.setText(data[3].toString());
        }
        if (data[4] == null) {
        } else {
            tfAirFASE2.setText(data[4].toString());
        }
        if (data[5] == null) {
        } else {
            String parseAssesment = data[5].toString();
            if (parseAssesment.contains("Низкий")) {
                tfAss2.setText("Низкий риск 1-10");
                tfAss2.setBackground(greenMatrix);
            } else if (parseAssesment.contains("Умерен")) {
                tfAss2.setText("Умеренный риск 20-50");
                tfAss2.setBackground(yellowMatrix);
            } else if (parseAssesment.contains("Высокий")) {
                tfAss2.setText("Высокий риск 100-102");
                tfAss2.setBackground(orangeMatrix);
            } else if (parseAssesment.contains("Недоп")) {
                tfAss2.setText("Недопустимый риск 500-2500");
                tfAss2.setBackground(redMatrix);
            } else if (parseAssesment.contains("учит")) {
                tfAss2.setText("Не учитывать");
                tfAss2.setBackground(Color.WHITE);
            } else if (parseAssesment.contains("действ")) {
                tfAss2.setText("Не действительно");
                tfAss2.setBackground(Color.WHITE);
            } else {
                tfAss2.setText("");
                tfAss2.setBackground(Color.WHITE);
            }
        }
        if (data[6] == null) {
        } else {
            tfEvent3.setText(data[6].toString());
        }
        if (data[7] == null) {
        } else {
            tfAirFASE3.setText(data[7].toString());
        }
        if (data[8] == null) {
        } else {
            String parseAssesment = data[8].toString();
            if (parseAssesment.contains("Низкий")) {
                tfAss3.setText("Низкий риск 1-10");
                tfAss3.setBackground(greenMatrix);
            } else if (parseAssesment.contains("Умерен")) {
                tfAss3.setText("Умеренный риск 20-50");
                tfAss3.setBackground(yellowMatrix);
            } else if (parseAssesment.contains("Высокий")) {
                tfAss3.setText("Высокий риск 100-102");
                tfAss3.setBackground(orangeMatrix);
            } else if (parseAssesment.contains("Недоп")) {
                tfAss3.setText("Недопустимый риск 500-2500");
                tfAss3.setBackground(redMatrix);
            } else if (parseAssesment.contains("учит")) {
                tfAss3.setText("Не учитывать");
                tfAss3.setBackground(Color.WHITE);
            } else if (parseAssesment.contains("действ")) {
                tfAss3.setText("Не действительно");
                tfAss3.setBackground(Color.WHITE);
            } else {
                tfAss3.setText("");
                tfAss3.setBackground(Color.WHITE);
            }
        }
        if (data[9] == null) {
        } else {
            tfEvent4.setText(data[9].toString());
        }
        if (data[10] == null) {
        } else {
            tfAirFASE4.setText(data[10].toString());
        }
        if (data[11] == null) {
        } else {
            String parseAssesment = data[11].toString();
            if (parseAssesment.contains("Низкий")) {
                tfAss4.setText("Низкий риск 1-10");
                tfAss4.setBackground(greenMatrix);
            } else if (parseAssesment.contains("Умерен")) {
                tfAss4.setText("Умеренный риск 20-50");
                tfAss4.setBackground(yellowMatrix);
            } else if (parseAssesment.contains("Высокий")) {
                tfAss4.setText("Высокий риск 100-102");
                tfAss4.setBackground(orangeMatrix);
            } else if (parseAssesment.contains("Недоп")) {
                tfAss4.setText("Недопустимый риск 500-2500");
                tfAss4.setBackground(redMatrix);
            } else if (parseAssesment.contains("учит")) {
                tfAss4.setText("Не учитывать");
                tfAss4.setBackground(Color.WHITE);
            } else if (parseAssesment.contains("действ")) {
                tfAss4.setText("Не действительно");
                tfAss4.setBackground(Color.WHITE);
            } else {
                tfAss4.setText("");
                tfAss4.setBackground(Color.WHITE);
            }
        }
        if (data[12] == null) {
        } else {
            tpPrim.setText(data[12].toString());
        }
        if (data[13] == null) {
        } else {
            tpAnalysis.setText(data[13].toString());
        }
        if (data[14] == null) {
        } else {
            tpCorrectiveActions.setText(data[14].toString());
        }
        if (data[15] == null) {
        } else {
            tfCommanderAE.setText(data[15].toString());
        }
        if (data[16] == null) {
        } else {
            tfAnalysisDate.setText(data[16].toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGeneralInfo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfEvent1 = new javax.swing.JTextField();
        tfAss1 = new javax.swing.JTextField();
        tfAirFASE1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfEvent2 = new javax.swing.JTextField();
        tfAirFASE2 = new javax.swing.JTextField();
        tfAss2 = new javax.swing.JTextField();
        tfEvent3 = new javax.swing.JTextField();
        tfAirFASE3 = new javax.swing.JTextField();
        tfAss3 = new javax.swing.JTextField();
        tfEvent4 = new javax.swing.JTextField();
        tfAirFASE4 = new javax.swing.JTextField();
        tfAss4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tpPrim = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tpAnalysis = new javax.swing.JTextPane();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tpCorrectiveActions = new javax.swing.JTextPane();
        jLabel14 = new javax.swing.JLabel();
        tfCommanderAE = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tfAnalysisDate = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1053, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 288, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: Flight Department ");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableGeneralInfo.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "№", "Дата обработки", "Дата полета", "Борт", "Рейс", "Взлет", "Посадка"
                }
        ));
        jScrollPane1.setViewportView(tableGeneralInfo);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setText("События полета");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel2.setText("Предварительная оценка риска");

        tfEvent1.setEditable(false);

        tfAss1.setEditable(false);

        tfAirFASE1.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel3.setText("AirFASE №");

        tfEvent2.setEditable(false);

        tfAirFASE2.setEditable(false);

        tfAss2.setEditable(false);

        tfEvent3.setEditable(false);

        tfAirFASE3.setEditable(false);

        tfAss3.setEditable(false);

        tfEvent4.setEditable(false);
        tfEvent4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEvent4ActionPerformed(evt);
            }
        });

        tfAirFASE4.setEditable(false);

        tfAss4.setEditable(false);

        tpPrim.setEditable(false);
        jScrollPane2.setViewportView(tpPrim);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel11.setText("Примечание");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel12.setText("Анализ полета");

        tpAnalysis.setEditable(false);
        jScrollPane3.setViewportView(tpAnalysis);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel13.setText("Корректирующие действия");

        tpCorrectiveActions.setEditable(false);
        jScrollPane4.setViewportView(tpCorrectiveActions);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel14.setText("Командир АЭ / Заместитель командира АЭ:");

        tfCommanderAE.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel19.setText("Дата анализа:");

        tfAnalysisDate.setEditable(false);
        tfAnalysisDate.setToolTipText("Дата устанавливается автоматически при нажатии на кнопку \"Отправить\" в клиенте авиаэскадрильи. Дата соотвествует настройкам сервера.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel13))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel12))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel11))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tfEvent1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                                                                        .addComponent(tfEvent2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                                                                        .addComponent(tfEvent3, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                                                                        .addComponent(tfEvent4, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(jLabel1)
                                                                .addGap(454, 454, 454)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tfAirFASE4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                                                        .addComponent(tfAirFASE3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                                                        .addComponent(tfAirFASE2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                                                        .addComponent(tfAirFASE1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(78, 78, 78)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(tfAss2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                                                .addComponent(tfAss1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                                                .addComponent(tfAss3, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                                                .addComponent(tfAss4, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel19)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tfAnalysisDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                                                                .addComponent(jLabel14)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tfCommanderAE, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfEvent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfAss1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfAirFASE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfEvent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfAirFASE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfAss2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfEvent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfAss3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfAirFASE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfEvent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfAss4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfAirFASE4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfCommanderAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel19)
                                        .addComponent(tfAnalysisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableGeneralInfo;
    private javax.swing.JTextField tfAirFASE1;
    private javax.swing.JTextField tfAirFASE2;
    private javax.swing.JTextField tfAirFASE3;
    private javax.swing.JTextField tfAirFASE4;
    private javax.swing.JTextField tfAnalysisDate;
    private javax.swing.JTextField tfAss1;
    private javax.swing.JTextField tfAss2;
    private javax.swing.JTextField tfAss3;
    private javax.swing.JTextField tfAss4;
    private javax.swing.JTextField tfCommanderAE;
    private javax.swing.JTextField tfEvent1;
    private javax.swing.JTextField tfEvent2;
    private javax.swing.JTextField tfEvent3;
    private javax.swing.JTextField tfEvent4;
    private javax.swing.JTextPane tpAnalysis;
    private javax.swing.JTextPane tpCorrectiveActions;
    private javax.swing.JTextPane tpPrim;
    // End of variables declaration//GEN-END:variables
}
