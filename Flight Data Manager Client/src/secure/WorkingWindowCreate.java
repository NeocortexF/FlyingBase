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

public class WorkingWindowCreate extends javax.swing.JFrame {

    private String folderName = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClearForm;
    private javax.swing.JButton bFiles;
    private javax.swing.JButton bSave;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private com.toedter.calendar.JDateChooser jdateFlight;
    private com.toedter.calendar.JDateChooser jdateProcessing;
    private javax.swing.JTextField tfAirFASE1;
    private javax.swing.JTextField tfAirFASE2;
    private javax.swing.JTextField tfAirFASE3;
    private javax.swing.JTextField tfAirFASE4;
    private javax.swing.JTextField tfEvent1;
    private javax.swing.JTextField tfEvent2;
    private javax.swing.JTextField tfEvent3;
    private javax.swing.JTextField tfEvent4;
    private javax.swing.JTextField txtArrival;
    private javax.swing.JTextField txtDeparture;
    private javax.swing.JTextField txtFlightNbr;
    private javax.swing.JTextField txtIncomingNbr;
    private javax.swing.JTextPane txtPrim;

    public WorkingWindowCreate() throws SQLException {
        initComponents();
        initFleet();
        initClassificator();
        initGopiPersonal();

        //мутим преффикс и автоинкримент
        //получаем последнюю заполненую строку Incoming_number
        String getStr = new DBUpdaterWorkingWindow().getNewRow();
        //отрезаем преффикс и переводим в инт, прибавляем 1
        String strWithoutPreffics = getStr.substring(3, getStr.length());
        int incNbr = Integer.parseInt(strWithoutPreffics);
        incNbr = incNbr + 1;
        // добавляем преффикс и переводим с строку
        String preffics = getStr.substring(0, 2);
        String readyStringNbr = preffics + "-" + incNbr;
        //передаем значение в ячейку формы
        txtIncomingNbr.setText(readyStringNbr);
        //устанавливаем имя конечной папки для сохранений на сервер вложенных файлов равное номеру сообщения
        folderName = readyStringNbr;

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
        //получаем массив объектов полученный контроллером DBUpdaterWorkingWindow из БД
        Object[] data = new DBUpdaterWorkingWindow().getData(str);
        //сделал без проверки полученного из массива объекта на null
        //по концепции БД строка записи не должна не иметь входящего номера
        txtIncomingNbr.setText(data[0].toString());
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
        //кем обработано и примичение
        if (data[19] == null) {
        } else {
            comboProcBy.setSelectedItem(data[19]);
        }
        if (data[20] == null) {
        } else {
            txtPrim.setText(data[20].toString());
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
        jLabel1 = new javax.swing.JLabel();
        txtIncomingNbr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboTail = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFlightNbr = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDeparture = new javax.swing.JTextField();
        txtArrival = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel10 = new javax.swing.JLabel();
        tfEvent1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfAirFASE1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        comboAss1 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        tfEvent2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfEvent3 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfEvent4 = new javax.swing.JTextField();
        tfAirFASE2 = new javax.swing.JTextField();
        tfAirFASE3 = new javax.swing.JTextField();
        tfAirFASE4 = new javax.swing.JTextField();
        comboAss2 = new javax.swing.JComboBox();
        comboAss3 = new javax.swing.JComboBox();
        comboAss4 = new javax.swing.JComboBox();
        bSave = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jdateProcessing = new com.toedter.calendar.JDateChooser();
        jdateFlight = new com.toedter.calendar.JDateChooser();
        comboProcBy = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPrim = new javax.swing.JTextPane();
        bClearForm = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        bFiles = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Создать новое событие в базе");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setText("Вх. номер");

        txtIncomingNbr.setToolTipText("Для того, что бы начать новый отчет, например, после Нового Года, просто при создании нового события впишите новый преффикс и номер 1. Например \"17-1\" далее программа подхватит и будет нумеровать автоматически, следующие события");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel2.setText("Дата обработки");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel3.setText("Дата полета");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel4.setText("Бортовой номер");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel5.setText("Номер рейса");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel6.setText("Аэропорт вылета");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel7.setText("Аэропорт посадки");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/airport.png"))); // NOI18N
        jButton3.setToolTipText("Выбрать аэропорты вылета и посадки");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel8.setText("Классификация события");

        jTree1.setDragEnabled(true);
        jTree1.setDropMode(javax.swing.DropMode.ON);
        jScrollPane1.setViewportView(jTree1);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel10.setText("Event 1");

        tfEvent1.setDropMode(javax.swing.DropMode.INSERT);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel11.setText("Event AirFASE Nbr");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel12.setText("Предварительная оценка риска");

        comboAss1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "<html><bgcolor = #8DFF41><b>Низкий риск (1-10) </b></bgcolor>", "<html><bgcolor = #EBFF14><b>Умеренный риск (20-50) </b></bgcolor>", "<html><bgcolor = #FFAC05><b>Высокий риск (100-102) </b></bgcolor>", "<html><bgcolor = red><b>Недопустимый риск (>500) </b></bgcolor>", "Не учитывать", "Не действительно"}));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel13.setText("Event 2");

        tfEvent2.setDropMode(javax.swing.DropMode.INSERT);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel14.setText("Event 3");

        tfEvent3.setDropMode(javax.swing.DropMode.INSERT);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel15.setText("Event 4");

        tfEvent4.setDropMode(javax.swing.DropMode.INSERT);

        tfAirFASE4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAirFASE4ActionPerformed(evt);
            }
        });

        comboAss2.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"  ", "<html><bgcolor = #8DFF41><b>Низкий риск (1-10) </b></bgcolor>", "<html><bgcolor = #EBFF14><b>Умеренный риск (20-50) </b></bgcolor>", "<html><bgcolor = #FFAC05><b>Высокий риск (100-102) </b></bgcolor>", "<html><bgcolor = red><b>Недопустимый риск (>500) </b></bgcolor>", "Не учитывать", "Не действительно"}));

        comboAss3.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "<html><bgcolor = #8DFF41><b>Низкий риск (1-10) </b></bgcolor>", "<html><bgcolor = #EBFF14><b>Умеренный риск (20-50) </b></bgcolor>", "<html><bgcolor = #FFAC05><b>Высокий риск (100-102) </b></bgcolor>", "<html><bgcolor = red><b>Недопустимый риск (>500) </b></bgcolor>", "Не учитывать", "Не действительно"}));

        comboAss4.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "<html><bgcolor = #8DFF41><b>Низкий риск (1-10) </b></bgcolor>", "<html><bgcolor = #EBFF14><b>Умеренный риск (20-50) </b></bgcolor>", "<html><bgcolor = #FFAC05><b>Высокий риск (100-102) </b></bgcolor>", "<html><bgcolor = red><b>Недопустимый риск (>500) </b></bgcolor>", "Не учитывать", "Не действительно"}));

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        bSave.setText("Сохранить");
        bSave.setToolTipText("");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel16.setText("Обработал(а)");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel17.setText("Примечание");

        jScrollPane2.setViewportView(txtPrim);

        bClearForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        bClearForm.setText("Очистить форму");
        bClearForm.setToolTipText("");
        bClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearFormActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel18.setText("Материалы события");

        bFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/files-folders.png"))); // NOI18N
        bFiles.setText("Открыть папку");
        bFiles.setToolTipText("Открывает или создает папку на сервере для хранения материалов события");
        bFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFilesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(txtIncomingNbr, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jdateProcessing, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jdateFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(comboTail, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtFlightNbr, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtArrival, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(tfEvent4, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                                                        .addComponent(tfEvent3, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                                                        .addComponent(tfEvent2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                                                        .addComponent(tfEvent1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tfAirFASE4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                                        .addComponent(tfAirFASE3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                                        .addComponent(tfAirFASE1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                                        .addComponent(tfAirFASE2, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboAss2, 0, 291, Short.MAX_VALUE)
                                                        .addComponent(jLabel12)
                                                        .addComponent(comboAss1, 0, 291, Short.MAX_VALUE)
                                                        .addComponent(comboAss4, 0, 291, Short.MAX_VALUE)
                                                        .addComponent(comboAss3, 0, 291, Short.MAX_VALUE)))
                                        .addComponent(jLabel17)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel18)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 766, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel9)
                                                                                .addGap(2, 2, 2))
                                                                        .addComponent(jLabel16)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(bFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(473, 473, 473)
                                                                .addComponent(bClearForm)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(comboProcBy, 0, 293, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bSave)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(comboTail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtFlightNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(txtIncomingNbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jdateProcessing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jdateFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfEvent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfEvent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfAirFASE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboAss2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfEvent3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfAirFASE3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboAss3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfEvent4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfAirFASE4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboAss4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tfAirFASE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(comboAss1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel18)
                                                .addComponent(jLabel16)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bFiles)
                                        .addComponent(bSave)
                                        .addComponent(comboProcBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bClearForm))
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
// TODO add your handling code here:
    }//GEN-LAST:event_tfAirFASE4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Список аэропортов
        AirportsCreate airWindow = new AirportsCreate();
        //сетаем родителя (окно WorkingWindow2) в окно Airports для взаимосвязим между ними
        airWindow.setParent(this);
        airWindow.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed

        // Кнопка создать сообщение
        if (jdateProcessing.getDate() == null || jdateFlight.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Поля дата обработки и дата полета не могут быть пустыми!");
        } else {
            if (new DBUpdaterWorkingWindow().add(txtIncomingNbr.getText(), jdateProcessing.getDate(), jdateFlight.getDate(),
                    comboTail.getSelectedItem().toString(), txtFlightNbr.getText(), txtDeparture.getText(), txtArrival.getText(), tfEvent1.getText(),
                    tfEvent2.getText(), tfEvent3.getText(), tfEvent4.getText(), tfAirFASE1.getText(), tfAirFASE2.getText(), tfAirFASE3.getText(),
                    tfAirFASE4.getText(), comboAss1.getSelectedItem().toString(), comboAss2.getSelectedItem().toString(), comboAss3.getSelectedItem().toString(),
                    comboAss4.getSelectedItem().toString(), txtPrim.getText(), comboProcBy.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Все данные успешно сохранены на сервере");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Не получилось сохранить, пожалуйста, проинформируйте разработчка об этом!");
            }
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearFormActionPerformed
// Кнопка очистить заполненые поля формы
        Object[] options = {"Очистить", "Отмена"};
        int n = JOptionPane.showOptionDialog(null, "Вы действительно собираетесь очистить данную форму?", "Предупреждение!", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        if (n == JOptionPane.YES_OPTION) {

            jdateProcessing.setCalendar(null);
            jdateFlight.setCalendar(null);
            comboTail.setSelectedIndex(0);
            txtFlightNbr.setText(null);
            txtDeparture.setText(null);
            txtArrival.setText(null);
            tfEvent1.setText(null);
            tfEvent2.setText(null);
            tfEvent3.setText(null);
            tfEvent4.setText(null);
            tfAirFASE1.setText(null);
            tfAirFASE2.setText(null);
            tfAirFASE3.setText(null);
            tfAirFASE4.setText(null);
            txtPrim.setText(null);
            comboAss1.setSelectedIndex(0);
            comboAss2.setSelectedIndex(0);
            comboAss3.setSelectedIndex(0);
            comboAss4.setSelectedIndex(0);

            JOptionPane.showMessageDialog(null,
                    "Форма была успешно очищена!",
                    "Очистка формы",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bClearFormActionPerformed

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
