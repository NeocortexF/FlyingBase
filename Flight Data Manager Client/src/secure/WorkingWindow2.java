package secure;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkingWindow2 extends javax.swing.JFrame {

    private String folderName = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bChange;
    private javax.swing.JButton bFiles;
    private javax.swing.JButton bSave;
    private javax.swing.JComboBox comboAccepted;
    private javax.swing.JComboBox comboAss1;
    private javax.swing.JComboBox comboAss2;
    private javax.swing.JComboBox comboAss3;
    private javax.swing.JComboBox comboAss4;
    private javax.swing.JComboBox comboProcBy;
    private javax.swing.JComboBox comboTail;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTree jTree1;
    private com.toedter.calendar.JDateChooser jdateFlight;
    private com.toedter.calendar.JDateChooser jdateProcessing;
    private javax.swing.JTextField tfAirFASE1;
    private javax.swing.JTextField tfAirFASE2;
    private javax.swing.JTextField tfAirFASE3;
    private javax.swing.JTextField tfAirFASE4;
    private javax.swing.JTextField tfAnalysisDate;
    private javax.swing.JTextField tfCommanderAE;
    private javax.swing.JTextField tfEvent1;
    private javax.swing.JTextField tfEvent2;
    private javax.swing.JTextField tfEvent3;
    private javax.swing.JTextField tfEvent4;
    private javax.swing.JTextPane tpAnalysis;
    private javax.swing.JTextPane tpCorrectiveActions;
    private javax.swing.JTextField txtArrival;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtFlightNbr;
    private javax.swing.JTextField txtIncomingNbr;
    private javax.swing.JTextPane txtPrim;

    public WorkingWindow2(String str) throws ParseException, SQLException {
        folderName = str;
        initComponents();
        initFleet();
        initClassificator();
        initGopiPersonal();
        retrieve(str);
        tfEvent1.getDocument().addDocumentListener(new MyDocumentListener());
        tfEvent2.getDocument().addDocumentListener(new MyDocumentListener());
        tfEvent3.getDocument().addDocumentListener(new MyDocumentListener());
        tfEvent4.getDocument().addDocumentListener(new MyDocumentListener());
        tfAirFASE1.getDocument().addDocumentListener(new MyDocumentListener());
        tfAirFASE2.getDocument().addDocumentListener(new MyDocumentListener());
        tfAirFASE3.getDocument().addDocumentListener(new MyDocumentListener());
        tfAirFASE4.getDocument().addDocumentListener(new MyDocumentListener());
        txtPrim.getDocument().addDocumentListener(new MyDocumentListener());

        MyDocumentListener.setDocumentChanged(false);
    }

    private void initFleet() {

        Object[] fleet = new DBUpdaterWorkingWindow().getFleet();
        if (fleet.length == 0) {
            JOptionPane.showMessageDialog(null, "Список парка самолетов на сервере пуст!");
        } else {
            for (int i = 0; i < fleet.length; i++) {
                comboTail.addItem(fleet[i].toString());
            }
        }
    }

    private void initClassificator() throws SQLException {

        DefaultTreeModel treeModel = new DBUpdaterWorkingWindow().pop_tree();
        jTree1.setModel(treeModel);
    }

    private void initGopiPersonal() {

        Object[] gopiPersonal = new DBUpdaterWorkingWindow().getPersonal();
        if (gopiPersonal.length == 0) {
            JOptionPane.showMessageDialog(null, "Не удалось получить перечень персонала ГОПИ с сервера!");
        } else {
            for (int i = 0; i < gopiPersonal.length; i++) {
                comboProcBy.addItem(gopiPersonal[i].toString());
            }
        }
    }

    private void retrieve(String str) throws ParseException {
        Object[] data = new DBUpdaterWorkingWindow().getData(str);

        if (data[0] != null) {
            txtIncomingNbr.setText(data[0].toString());
        } else {
            JOptionPane.showMessageDialog(null, "Получен null в номер события Incoming_number из БД! Метод retrieve(String str) класса WorkingWindow2");
        }

        //так заполняется ДАТА в календарь JCalendar!!
        Object tempDate = data[1];
        if (tempDate == null) {
        } else {
            String stringDate = tempDate.toString();
            SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyy");
            Date date = (Date) parser.parse(stringDate);
            jdateProcessing.setDate(date);
        }

        Object tempDate2 = data[2];
        if (tempDate2 == null) {
        } else {
            String stringDate2 = tempDate2.toString();
            SimpleDateFormat parser2 = new SimpleDateFormat("dd.MM.yyyy");
            Date date2 = (Date) parser2.parse(stringDate2);
            jdateFlight.setDate(date2);
        }

        //общие данные по полету
        if (data[3] == null) {
        } else {
            txtFlightNbr.setText(data[3].toString());
        }
        if (data[4] == null) {
        } else {
            txtDeparture.setText(data[4].toString());
        }
        if (data[5] == null) {
        } else {
            txtArrival.setText(data[5].toString());
        }
        if (data[6] == null) {
        } else {
            comboTail.setSelectedItem(data[6]);
        }
        //номер события
        if (data[7] == null) {
        } else {
            tfAirFASE1.setText(data[7].toString());
        }
        if (data[8] == null) {
        } else {
            tfAirFASE2.setText(data[8].toString());
        }
        if (data[9] == null) {
        } else {
            tfAirFASE3.setText(data[9].toString());
        }
        if (data[10] == null) {
        } else {
            tfAirFASE4.setText(data[10].toString());
        }
        //классификация события
        if (data[11] == null) {
        } else {
            tfEvent1.setText(data[11].toString());
        }
        if (data[12] == null) {
        } else {
            tfEvent2.setText(data[12].toString());
        }
        if (data[13] == null) {
        } else {
            tfEvent3.setText(data[13].toString());
        }
        if (data[14] == null) {
        } else {
            tfEvent4.setText(data[14].toString());
        }
        //оценка события - нужно распарсить по содержанию слова в событии
        if (data[15] == null) {
        } else {
            String tempStr = data[15].toString();
            if (tempStr.contains("Низкий")) {
                comboAss1.setSelectedIndex(1);
            } else if (tempStr.contains("Умерен")) {
                comboAss1.setSelectedIndex(2);
            } else if (tempStr.contains("Высокий")) {
                comboAss1.setSelectedIndex(3);
            } else if (tempStr.contains("Недоп")) {
                comboAss1.setSelectedIndex(4);
            } else if (tempStr.contains("учит")) {
                comboAss1.setSelectedIndex(5);
            } else if (tempStr.contains("действ")) {
                comboAss1.setSelectedIndex(6);
            } else {
                comboAss1.setSelectedIndex(0);
            }
        }
        if (data[16] == null) {
        } else {
            String tempStr = data[16].toString();
            if (tempStr.contains("Низкий")) {
                comboAss2.setSelectedIndex(1);
            } else if (tempStr.contains("Умерен")) {
                comboAss2.setSelectedIndex(2);
            } else if (tempStr.contains("Высокий")) {
                comboAss2.setSelectedIndex(3);
            } else if (tempStr.contains("Недоп")) {
                comboAss2.setSelectedIndex(4);
            } else if (tempStr.contains("учит")) {
                comboAss2.setSelectedIndex(5);
            } else if (tempStr.contains("действ")) {
                comboAss2.setSelectedIndex(6);
            } else {
                comboAss2.setSelectedIndex(0);
            }
        }
        if (data[17] == null) {
        } else {
            String tempStr = data[17].toString();
            if (tempStr.contains("Низкий")) {
                comboAss3.setSelectedIndex(1);
            } else if (tempStr.contains("Умерен")) {
                comboAss3.setSelectedIndex(2);
            } else if (tempStr.contains("Высокий")) {
                comboAss3.setSelectedIndex(3);
            } else if (tempStr.contains("Недоп")) {
                comboAss3.setSelectedIndex(4);
            } else if (tempStr.contains("учит")) {
                comboAss3.setSelectedIndex(5);
            } else if (tempStr.contains("действ")) {
                comboAss3.setSelectedIndex(6);
            } else {
                comboAss3.setSelectedIndex(0);
            }
        }
        if (data[18] == null) {
        } else {
            String tempStr = data[18].toString();
            if (tempStr.contains("Низкий")) {
                comboAss4.setSelectedIndex(1);
            } else if (tempStr.contains("Умерен")) {
                comboAss4.setSelectedIndex(2);
            } else if (tempStr.contains("Высокий")) {
                comboAss4.setSelectedIndex(3);
            } else if (tempStr.contains("Недоп")) {
                comboAss4.setSelectedIndex(4);
            } else if (tempStr.contains("учит")) {
                comboAss4.setSelectedIndex(5);
            } else if (tempStr.contains("действ")) {
                comboAss4.setSelectedIndex(6);
            } else {
                comboAss4.setSelectedIndex(0);
            }
        }
        //кем обработано, примичение и одобрено ГОПИ
        if (data[19] == null) {
        } else {
            comboProcBy.setSelectedItem(data[19]);
        }
        if (data[20] == null) {
        } else {
            txtPrim.setText(data[20].toString());
        }
        if (data[21] == null) {
        } else {
            comboAccepted.setSelectedItem(data[21]);
        }
        if (data[22] == null) {
        } else {
            tpAnalysis.setText(data[22].toString());
        }
        if (data[23] == null) {
        } else {
            tpCorrectiveActions.setText(data[23].toString());
        }
        if (data[24] == null) {
        } else {
            tfCommanderAE.setText(data[24].toString());
        }
        if (data[25] == null) {
        } else {
            tfAnalysisDate.setText(data[25].toString());
        }
    }

    public JTextField getTxtArrival() {
        return txtArrival;
    }

    public void setTxtArrival(JTextField txtArrival) {
        this.txtArrival = txtArrival;
    }

    public JTextField getTxtDeparture() {
        return txtDeparture;
    }

    public void setTxtDeparture(JTextField txtDeparture) {
        this.txtDeparture = txtDeparture;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        comboProcBy = new javax.swing.JComboBox();
        comboAccepted = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        bSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPrim = new javax.swing.JTextPane();
        bChange = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        bFiles = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfEvent4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        tfAirFASE2 = new javax.swing.JTextField();
        tfEvent1 = new javax.swing.JTextField();
        txtDeparture = new javax.swing.JTextField();
        comboAss2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        comboAss4 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        tfAirFASE3 = new javax.swing.JTextField();
        jdateProcessing = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        comboAss1 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        txtIncomingNbr = new javax.swing.JTextField();
        txtFlightNbr = new javax.swing.JTextField();
        tfEvent2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jdateFlight = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        comboTail = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboAss3 = new javax.swing.JComboBox();
        tfEvent3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfAirFASE1 = new javax.swing.JTextField();
        txtArrival = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        tfAirFASE4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tpAnalysis = new javax.swing.JTextPane();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tpCorrectiveActions = new javax.swing.JTextPane();
        jLabel22 = new javax.swing.JLabel();
        tfAnalysisDate = new javax.swing.JTextField();
        tfCommanderAE = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: Flight Data Manager");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel16.setText("Обработал(а)");

        comboAccepted.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "Плотников С.К.", "Зенцов С.В."}));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel18.setText("Подтвердил");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel17.setText("Примечание");

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pilot.png"))); // NOI18N
        bSave.setText("Сохранить и отправить в ЛО");
        bSave.setToolTipText("Сохраняет внесенные изменения и подтверждает событие, отправляет данные в летный отряд.");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtPrim);

        bChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        bChange.setText("Сохранить без отправки");
        bChange.setToolTipText("Только сохраняет изменения внесенные в контекст события, например, если данные о событие необходимо будет еще раз отредактировать инженером ГОПИ");
        bChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChangeActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel19.setText("Материалы события:");

        bFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/files-folders.png"))); // NOI18N
        bFiles.setText("Открыть папку");
        bFiles.setToolTipText("Открывает или создает папку на сервере для хранения материалов события");
        bFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel16)
                                                .addGap(23, 23, 23))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel19)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bFiles)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bChange, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane2))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel18)
                                                        .addComponent(comboAccepted, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(bSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(comboProcBy, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(comboProcBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(comboAccepted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bSave)
                                        .addComponent(bChange)
                                        .addComponent(bFiles)
                                        .addComponent(jLabel19))
                                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel3.setText("Дата полета");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel13.setText("Event 2");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel10.setText("Event 1");

        tfEvent4.setDropMode(javax.swing.DropMode.INSERT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel2.setText("Дата обработки");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/airport.png"))); // NOI18N
        jButton3.setToolTipText("Выбрать аэропорты вылета и посадки");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tfEvent1.setDropMode(javax.swing.DropMode.INSERT);

        comboAss2.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"  ", "<html><bgcolor = #8DFF41><b>Низкий риск (1-10) </b></bgcolor>", "<html><bgcolor = #EBFF14><b>Умеренный риск (20-50) </b></bgcolor>", "<html><bgcolor = #FFAC05><b>Высокий риск (100-102) </b></bgcolor>", "<html><bgcolor = red><b>Недопустимый риск (>500) </b></bgcolor>", "Не учитывать", "Не действительно"}));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel12.setText("Предварительная оценка риска");

        comboAss4.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "<html><bgcolor = #8DFF41><b>Низкий риск (1-10) </b></bgcolor>", "<html><bgcolor = #EBFF14><b>Умеренный риск (20-50) </b></bgcolor>", "<html><bgcolor = #FFAC05><b>Высокий риск (100-102) </b></bgcolor>", "<html><bgcolor = red><b>Недопустимый риск (>500) </b></bgcolor>", "Не учитывать", "Не действительно"}));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel14.setText("Event 3");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel8.setText("Классификация события");

        comboAss1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "<html><bgcolor = #8DFF41><b>Низкий риск (1-10) </b></bgcolor>", "<html><bgcolor = #EBFF14><b>Умеренный риск (20-50) </b></bgcolor>", "<html><bgcolor = #FFAC05><b>Высокий риск (100-102) </b></bgcolor>", "<html><bgcolor = red><b>Недопустимый риск (>500) </b></bgcolor>", "Не учитывать", "Не действительно"}));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel15.setText("Event 4");

        tfEvent2.setDropMode(javax.swing.DropMode.INSERT);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel11.setText("AirFASE №");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel7.setText("Аэропорт посадки");

        comboTail.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "320 VP-BDL", "320 VP-BBQ", "320 VP-BFZ", "320 VP-BKB", "320 VP-BIE", "320 VP-BMW", "320 VP-BMT", "320 VQ-BAG", "320 VQ-BCY", "320 VP-BTZ", "320 VQ-BCZ", "320 VQ-BDJ", "320 VQ-BDM", "320 VQ-BFV", "320 VQ-BFW", "320 VQ-BLO", "320 VQ-BRE", "320 VQ-BNI", "320 VQ-BQN", "321 VQ-BCX", "321 VQ-BDA", "321 VQ-BKG", "321 VQ-BKH", "321 VQ-BKJ", "321 VQ-BOB", "321 VQ-BOC", "321 VQ-BOF", "321 VQ-BOZ", "321 VP-BVP", "321 VP-BBH", "319 VP-BTE", "319 VP-BTF", "319 VQ-BTP", "319 VQ-BTY", "319 VQ-BTZ", "319 VP-BJV", "319 VP-BBG"}));
        comboTail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTailActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel5.setText("Номер рейса");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel4.setText("Бортовой номер");

        comboAss3.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "<html><bgcolor = #8DFF41><b>Низкий риск (1-10) </b></bgcolor>", "<html><bgcolor = #EBFF14><b>Умеренный риск (20-50) </b></bgcolor>", "<html><bgcolor = #FFAC05><b>Высокий риск (100-102) </b></bgcolor>", "<html><bgcolor = red><b>Недопустимый риск (>500) </b></bgcolor>", "Не учитывать", "Не действительно"}));

        tfEvent3.setDropMode(javax.swing.DropMode.INSERT);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setText("Вх. номер");

        jTree1.setDragEnabled(true);
        jTree1.setDropMode(javax.swing.DropMode.ON);
        jScrollPane1.setViewportView(jTree1);

        tfAirFASE4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAirFASE4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel6.setText("Аэропорт вылета");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1225, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel10)
                                                                        .addComponent(tfEvent3, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                                                                        .addComponent(tfEvent2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                                                                        .addComponent(tfEvent1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                                                                        .addComponent(tfEvent4, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                                                                        .addComponent(jLabel15)
                                                                        .addComponent(jLabel13)
                                                                        .addComponent(jLabel14))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(tfAirFASE2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tfAirFASE3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                                        .addComponent(tfAirFASE4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                                                        .addComponent(tfAirFASE1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                                                        .addComponent(comboAss4, 0, 370, Short.MAX_VALUE)
                                                                        .addComponent(comboAss3, 0, 370, Short.MAX_VALUE)
                                                                        .addComponent(comboAss2, 0, 370, Short.MAX_VALUE)
                                                                        .addComponent(comboAss1, 0, 370, Short.MAX_VALUE)))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1019, Short.MAX_VALUE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(txtIncomingNbr, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                                                                .addGap(2, 2, 2))
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                                                .addGap(29, 29, 29))
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jdateProcessing, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jdateFlight, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(comboTail, 0, 171, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtFlightNbr, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtDeparture, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtArrival, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(13, 13, 13)))
                                                .addGap(0, 0, 0))))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel1)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jLabel3))
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jLabel7)
                                                                .addComponent(jLabel4)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(txtFlightNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(comboTail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(txtIncomingNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jdateProcessing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jdateFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfEvent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfEvent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfAirFASE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboAss2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfEvent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfAirFASE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboAss3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfEvent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfAirFASE4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboAss4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jLabel11))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfAirFASE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboAss1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel20.setText("Анализ полета");

        tpAnalysis.setEditable(false);
        jScrollPane3.setViewportView(tpAnalysis);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel21.setText("Корректирующие действия");

        tpCorrectiveActions.setEditable(false);
        jScrollPane4.setViewportView(tpCorrectiveActions);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel22.setText("Дата анализа:");

        tfAnalysisDate.setEditable(false);
        tfAnalysisDate.setToolTipText("Дата устанавливается автоматически при нажатии на кнопку \"Отправить\" в клиенте авиаэскадрильи. Дата соотвествует настройкам сервера.");

        tfCommanderAE.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfAnalysisDate, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfCommanderAE, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                        .addComponent(jLabel21))
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(tfAnalysisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfCommanderAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
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

    private void tfAirFASE4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAirFASE4ActionPerformed
// удалить блокнотом или другой ide
    }//GEN-LAST:event_tfAirFASE4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Список аэропортов
        Airports airWindow = new Airports();
        //сетаем родителя (окно WorkingWindow2) в окно Airports для взаимосвязим между ними
        airWindow.setParent(this);  //тут ww должно быть
        airWindow.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        if (jdateProcessing.getDate() == null || jdateFlight.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Поля дата обработки и дата полета не могут быть пустыми!");
        } else {
            try {
                // Кнопка отправить ответ
                if (comboAccepted.getSelectedItem().toString().length() == 1) {
                    JOptionPane.showMessageDialog(null, "Для подтверждения, пожалуйста, укажите свою фамилию.");
                } else {
                    if (new DBUpdaterWorkingWindow().update(txtIncomingNbr.getText(), jdateProcessing.getDate(), jdateFlight.getDate(),
                            comboTail.getSelectedItem().toString(), txtFlightNbr.getText(), txtDeparture.getText(), txtArrival.getText(), tfEvent1.getText(),
                            tfEvent2.getText(), tfEvent3.getText(), tfEvent4.getText(), tfAirFASE1.getText(), tfAirFASE2.getText(), tfAirFASE3.getText(),
                            tfAirFASE4.getText(), comboAss1.getSelectedItem().toString(), comboAss2.getSelectedItem().toString(), comboAss3.getSelectedItem().toString(),
                            comboAss4.getSelectedItem().toString(), txtPrim.getText(), comboProcBy.getSelectedItem().toString(), comboAccepted.getSelectedItem().toString())) {
                        JOptionPane.showMessageDialog(null, "Событие №" + txtIncomingNbr.getText() + " теперь доступно для летного отряда");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Не получилось сохранить, пожалуйста, роверьте доступ к базе данных на сервере!");
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(WorkingWindow2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChangeActionPerformed
// Кнопка только сохранить изменения
        try {
            if (new DBUpdaterWorkingWindow().updateWithoutApprove(txtIncomingNbr.getText(), jdateProcessing.getDate(), jdateFlight.getDate(),
                    comboTail.getSelectedItem().toString(), txtFlightNbr.getText(), txtDeparture.getText(), txtArrival.getText(), tfEvent1.getText(),
                    tfEvent2.getText(), tfEvent3.getText(), tfEvent4.getText(), tfAirFASE1.getText(), tfAirFASE2.getText(), tfAirFASE3.getText(),
                    tfAirFASE4.getText(), comboAss1.getSelectedItem().toString(), comboAss2.getSelectedItem().toString(), comboAss3.getSelectedItem().toString(),
                    comboAss4.getSelectedItem().toString(), txtPrim.getText(), comboProcBy.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Событие №" + txtIncomingNbr.getText() + " сохранено и доступно для дальнейшего редактирования. В дальнейшем, для отправки в летный отряд необходимо потдвердить событие");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Не получилось сохранить, пожалуйста, проверьте доступ к базе данных на сервере!");
            }

        } catch (ParseException ex) {
            Logger.getLogger(WorkingWindow2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bChangeActionPerformed

    private void comboTailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTailActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_comboTailActionPerformed

    private void bFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFilesActionPerformed

        String fileFolder = Main.netFolderPath + folderName;

        File f = new File(fileFolder);

        if (f.exists()) {
            try {
                Runtime.getRuntime().exec("explorer " + fileFolder);
            } catch (IOException ex) {
                Logger.getLogger(WorkingWindow2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            new File(fileFolder).mkdir();
            try {
                Runtime.getRuntime().exec("explorer " + fileFolder);
            } catch (IOException ex) {
                Logger.getLogger(WorkingWindow2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bFilesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boolean docChange = MyDocumentListener.isDocumentChanged();

        if (docChange == true) {

            Object[] options = {"Не сохранять", "Отмена"};
            int status = JOptionPane.showOptionDialog(evt.getWindow(),
                    "Вы действительно хотите закрыть окно? Все несохраненные данные - будут утеряны!", "Закрыть окно",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);
            if (status == 0) {
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dispose();
                // System.exit(0);
            } else {
                setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                evt.getWindow().setVisible(true);
            }
        }
    }//GEN-LAST:event_formWindowClosing
    // End of variables declaration//GEN-END:variables
}
