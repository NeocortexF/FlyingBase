package secure;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class WorkingWindow3 extends javax.swing.JFrame {

    public static final String FD_CHIEF_SURNAME = "Иванов";
    public static final String FD_SUBCHIEF = "Петров";
    public static final String SAFETY_MANAGER = "Сидоров";
    public static final String FD_SUBCHIEF_ASSESSMENT = "Петров П.П.";
    public static final String FD_CHEIF_ASSESSMENT = "Иванов И.И.";
    public static final String SAFETY_MANAGER_ASSESSMENT = "Сидоров С.С.";
    private String globalIncNbr;
    private String corActFIO;
    private String talonCloseFIO;
    private String insideStr;
    private String folderName = "";
    private boolean comboChanged = false;
    private Scanner scan;

    public WorkingWindow3(String str, int tabIndex) throws ParseException {
        initComponents();
        insideStr = str;
        folderName = str;
        retrieve(str);
        jTabbedPane1.setSelectedIndex(tabIndex);
        hideIndexTextField();
        tfKVS.getDocument().addDocumentListener(new MyDocumentListener());
        tfVP.getDocument().addDocumentListener(new MyDocumentListener());
        tpInfoFromGLazkov.getDocument().addDocumentListener(new MyDocumentListener());
        tfRiskIndex.getDocument().addDocumentListener(new MyDocumentListener());

        MyDocumentListener.setDocumentChanged(false);
        comboChanged = false;

    }

    private void retrieve(String str) throws ParseException {
        //заполняем таблицу
        DefaultTableModel dmWW = new DBUpdaterWorkingWindow().getData(str);
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

        //заполняем поля в нижней панеле (все 3 вкладки)
        Object[] lowerPanelData = new DBUpdaterWorkingWindow().getLowerPanelData(str);
        if (lowerPanelData[0] == null) {
        } else {
            tfKVS.setText(lowerPanelData[0].toString());
        }
        if (lowerPanelData[1] == null) {
        } else {
            tfVP.setText(lowerPanelData[1].toString());
        }
        if (lowerPanelData[2] == null) {
        } else {
            String tempStr = lowerPanelData[2].toString();
            if (tempStr.contains("КВС")) {
                comboPF.setSelectedIndex(1);
            } else if (tempStr.contains("2П")) {
                comboPF.setSelectedIndex(2);
            }
        }
        if (lowerPanelData[3] == null) {
        } else {
            String tempStr = lowerPanelData[3].toString();
            if (tempStr.equals("2")) {
                comboAE.setSelectedIndex(1);
            } else if (tempStr.equals("3")) {
                comboAE.setSelectedIndex(2);
            } else if (tempStr.equals("4")) {
                comboAE.setSelectedIndex(3);
            } else if (tempStr.equals("5")) {
                comboAE.setSelectedIndex(4);
            } else if (tempStr.equals("6")) {
                comboAE.setSelectedIndex(5);
            } else if (tempStr.equals("7")) {
                comboAE.setSelectedIndex(6);
            } else if (tempStr.equals("8")) {
                comboAE.setSelectedIndex(7);
            } else if (tempStr.equals("10")) {
                comboAE.setSelectedIndex(8);
            } else if (tempStr.equals("12")) {
                comboAE.setSelectedIndex(9);
            }
        }
        if (lowerPanelData[4] == null) {
        } else {
            String tempStr = lowerPanelData[4].toString();
            if (tempStr.contains("Анализ")) {
                comboNesActions.setSelectedIndex(1);
            } else if (tempStr.contains("ИБП")) {
                comboNesActions.setSelectedIndex(3);
            } else if (tempStr.contains("ЛО")) {
                comboNesActions.setSelectedIndex(2);
            } else if (tempStr.contains("ПРАПИ")) {
                comboNesActions.setSelectedIndex(4);
            } else if (tempStr.contains("учит")) {
                comboNesActions.setSelectedIndex(5);
            } else if (tempStr.contains("действ")) {
                comboNesActions.setSelectedIndex(6);
            } else {
                comboNesActions.setSelectedIndex(0);
            }
        }
        if (lowerPanelData[5] == null) {
        } else {
            comboControl.setSelectedItem(lowerPanelData[5]);
        }
        if (lowerPanelData[6] == null) {
        } else {
            Object tempDate = lowerPanelData[6];
            String stringDate = tempDate.toString();
            SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyy");
            Date date = (Date) parser.parse(stringDate);
            dateCorDeadline.setDate(date);
        }
        if (lowerPanelData[7] == null) {
        } else {
            tpInfoFromGLazkov.setText(lowerPanelData[7].toString());
        }
        //радио кнопка одобренный действий получение
        if (lowerPanelData[8] == null) {
            rbNotCA.setSelected(true);
        } else {
            String tempStr = lowerPanelData[8].toString();
            if (tempStr.contains(FD_CHIEF_SURNAME)) {
                rbGlazkov.setSelected(true);
            } else if (tempStr.contains(FD_SUBCHIEF)) {
                rbRedkin.setSelected(true);
            } else if (tempStr.equals("") || tempStr.equals(" ")) {
                rbNotCA.setSelected(true);
            }
        }
        if (lowerPanelData[10] == null) {
            rbNotClosure.setSelected(true);
        } else {
            String tempStr = lowerPanelData[10].toString();
            if (tempStr.contains(FD_CHIEF_SURNAME)) {
                rbZubkov.setSelected(true);
            } else if (tempStr.contains(SAFETY_MANAGER)) {
                rbChebrov.setSelected(true);
            } else if (tempStr.equals("") || tempStr.equals(" ")) {
                rbNotClosure.setSelected(true);
            }
        }
        if (lowerPanelData[12] == null) {
        } else {
            String tempStr = lowerPanelData[12].toString();
            int risk = Integer.parseInt(tempStr);
            if (risk == 0) {
                tfRiskIndex.setText("Нет оценки или не действительно");
                tfRiskIndexFD.setText("Нет оценки или не действительно");
            } else if (risk <= 19) {
                setTfRiskIndex("Низкий риск - " + risk, greenMatrix);
                setTfRiskIndexFD("Низкий риск - " + risk, greenMatrix);
            } else if (risk > 19 && risk <= 99) {
                setTfRiskIndex("Умеренный риск - " + risk, yellowMatrix);
                setTfRiskIndexFD("Умеренный риск - " + risk, yellowMatrix);
            } else if (risk >= 100 && risk < 104) {
                setTfRiskIndex("Высокий риск - " + risk, orangeMatrix);
                setTfRiskIndexFD("Высокий риск - " + risk, orangeMatrix);
            } else if (risk >= 105) {
                setTfRiskIndex("Недопустимый риск - " + risk, redMatrix);
                setTfRiskIndexFD("Недопустимый риск - " + risk, redMatrix);
            } else {
                tfRiskIndex.setText("Оценка не определена");
                tfRiskIndexFD.setText("Оценка не определена");
            }
        }
    }

    private void hideIndexTextField() {
        tfIndex.setVisible(false);
        tfIndexFD.setVisible(false);
    }

    public JTextField getTfRiskIndex() {
        return tfRiskIndex;
    }

    public void setTfRiskIndex(String tfRiskIndex, Color color) {
        this.tfRiskIndex.setText(tfRiskIndex);
        this.tfRiskIndex.setBackground(color);
    }

    public void setTfRiskIndexFD(String tfRiskIndex, Color color) {
        this.tfRiskIndexFD.setText(tfRiskIndex);
        this.tfRiskIndexFD.setBackground(color);
    }

    public JTextField getTfIndex() {
        return tfIndex;
    }

    public void setTfIndex(String index) {
        this.tfIndex.setText(index);
    }

    public void setTfIndexFD(String index) {
        this.tfIndexFD.setText(index);
    }

    public void setKVSid(String id) {
        this.tfKVS.setText(id);
    }

    public void setVPid(String id) {
        this.tfVP.setText(id);
    }

    //взаимодействие между окнами
    //создаем ссылку на родителя
    private Welcome parent;

    public void setParent(Welcome w) {
        this.parent = w;
    }

    @Override
    public Welcome getParent() {
        return this.parent;
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
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfKVS = new javax.swing.JTextField();
        tfVP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboPF = new javax.swing.JComboBox();
        comboAE = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        comboNesActions = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboControl = new javax.swing.JComboBox();
        dateCorDeadline = new com.toedter.calendar.JDateChooser();
        bSendToAE = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        bCrew = new javax.swing.JButton();
        bInfoVp = new javax.swing.JButton();
        bInfoKvs = new javax.swing.JButton();
        bFiles = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tpInfoFromGLazkov = new javax.swing.JTextPane();
        jLabel16 = new javax.swing.JLabel();
        rbNotCA = new javax.swing.JRadioButton();
        rbGlazkov = new javax.swing.JRadioButton();
        rbRedkin = new javax.swing.JRadioButton();
        bAcceptCorAct = new javax.swing.JButton();
        bCorrActGreen = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        bMatrixFD = new javax.swing.JButton();
        tfRiskIndexFD = new javax.swing.JTextField();
        tfIndexFD = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        tfRiskIndex = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tfIndex = new javax.swing.JTextField();
        bMatrix = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        rbZubkov = new javax.swing.JRadioButton();
        rbNotClosure = new javax.swing.JRadioButton();
        bAcceptClosure = new javax.swing.JButton();
        rbChebrov = new javax.swing.JRadioButton();

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

        tableGeneralInfo.setFont(new java.awt.Font("Tahoma", 0, 14));
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
        tfEvent1.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfAss1.setEditable(false);
        tfAss1.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfAirFASE1.setEditable(false);
        tfAirFASE1.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel3.setText("AirFASE №");

        tfEvent2.setEditable(false);
        tfEvent2.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfAirFASE2.setEditable(false);
        tfAirFASE2.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfAss2.setEditable(false);
        tfAss2.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfEvent3.setEditable(false);
        tfEvent3.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfAirFASE3.setEditable(false);
        tfAirFASE3.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfAss3.setEditable(false);
        tfAss3.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfEvent4.setEditable(false);
        tfEvent4.setFont(new java.awt.Font("Tahoma", 0, 14));
        tfEvent4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEvent4ActionPerformed(evt);
            }
        });

        tfAirFASE4.setEditable(false);
        tfAirFASE4.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfAss4.setEditable(false);
        tfAss4.setFont(new java.awt.Font("Tahoma", 0, 14));

        tpPrim.setEditable(false);
        tpPrim.setFont(new java.awt.Font("Tahoma", 0, 14));
        jScrollPane2.setViewportView(tpPrim);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel11.setText("Примечание");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel12.setText("Анализ полета *");

        tpAnalysis.setFont(new java.awt.Font("Tahoma", 0, 14));
        jScrollPane3.setViewportView(tpAnalysis);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel13.setText("Корректирующие действия *");

        tpCorrectiveActions.setFont(new java.awt.Font("Tahoma", 0, 14));
        jScrollPane4.setViewportView(tpCorrectiveActions);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel14.setText("Командир АЭ / Зам. командира АЭ:");

        tfCommanderAE.setEditable(false);
        tfCommanderAE.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel19.setText("Дата анализа:");

        tfAnalysisDate.setFont(new java.awt.Font("Tahoma", 0, 14));
        tfAnalysisDate.setToolTipText("Дата устанавливается автоматически при нажатии на кнопку \"Отправить\" в клиенте авиаэскадрильи. Дата соотвествует настройкам сервера.");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editList.png"))); // NOI18N
        jButton1.setText("Исправить *");
        jButton1.setToolTipText("Исправить анализ полета и корректирующие действия");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tfEvent1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                                                                        .addComponent(tfEvent2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                                                                        .addComponent(tfEvent3, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                                                                        .addComponent(tfEvent4, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(jLabel1)
                                                                .addGap(454, 454, 454)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(tfAirFASE4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                                                        .addComponent(tfAirFASE3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                                                        .addComponent(tfAirFASE2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                                                        .addComponent(tfAirFASE1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(78, 78, 78)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(tfAss2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                                                .addComponent(tfAss1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                                                .addComponent(tfAss3, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                                                .addComponent(tfAss4, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel19)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tfAnalysisDate, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel14)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(tfCommanderAE, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                                                .addComponent(jButton1))
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE))))
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
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19)
                                        .addComponent(tfAnalysisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)
                                        .addComponent(tfCommanderAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addContainerGap())
        );

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel4.setText("КВС ID");

        tfKVS.setFont(new java.awt.Font("Tahoma", 0, 14));

        tfVP.setFont(new java.awt.Font("Tahoma", 0, 14));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel5.setText("ВП ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel6.setText("Пилотирующий");

        comboPF.setFont(new java.awt.Font("Tahoma", 0, 14));
        comboPF.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "КВС", "2П"}));
        comboPF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPFItemStateChanged(evt);
            }
        });

        comboAE.setFont(new java.awt.Font("Tahoma", 0, 14));
        comboAE.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "2", "3", "4", "5", "6", "7", "8", "10", "11", "12"}));
        comboAE.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAEItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel7.setText("№АЭ");

        comboNesActions.setFont(new java.awt.Font("Tahoma", 0, 14));
        comboNesActions.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "<html><bgcolor = #8DFF41><b>Анализ в АЭ </b></bgcolor>", "<html><bgcolor = #EBFF14><b>Углубленный анализ в ЛО </b></bgcolor>", "<html><bgcolor = #FFAC05><b>Служебное расследование в ЛО</b></bgcolor>", "<html><bgcolor = red><b>Расследование в соответствие с ПРАПИ</b></bgcolor>", "Не учитывать", "Не действительно"}));
        comboNesActions.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboNesActionsItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel8.setText("Необходимые мероприятия");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel9.setText("Контроль");

        comboControl.setFont(new java.awt.Font("Tahoma", 0, 14));
        comboControl.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", FD_CHEIF_ASSESSMENT, FD_SUBCHIEF_ASSESSMENT}));
        comboControl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboControlItemStateChanged(evt);
            }
        });

        dateCorDeadline.setFont(new java.awt.Font("Tahoma", 0, 14));

        bSendToAE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sendToPilots.png"))); // NOI18N
        bSendToAE.setText("Отправить в АЭ");
        bSendToAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSendToAEActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel10.setText(" Срок КД");

        bCrew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pilot.png"))); // NOI18N
        bCrew.setText("Выбрать экипаж");
        bCrew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrewActionPerformed(evt);
            }
        });

        bInfoVp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info2.png"))); // NOI18N
        bInfoVp.setToolTipText("Информация по второму пилоту");
        bInfoVp.setMaximumSize(new java.awt.Dimension(20, 20));
        bInfoVp.setMinimumSize(new java.awt.Dimension(20, 20));
        bInfoVp.setPreferredSize(new java.awt.Dimension(20, 20));
        bInfoVp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInfoVpActionPerformed(evt);
            }
        });

        bInfoKvs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/info2.png"))); // NOI18N
        bInfoKvs.setToolTipText("Информация по командиру");
        bInfoKvs.setMaximumSize(new java.awt.Dimension(20, 20));
        bInfoKvs.setMinimumSize(new java.awt.Dimension(20, 20));
        bInfoKvs.setPreferredSize(new java.awt.Dimension(20, 20));
        bInfoKvs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInfoKvsActionPerformed(evt);
            }
        });

        bFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/files-folders.png"))); // NOI18N
        bFiles.setText("Материалы");
        bFiles.setToolTipText("Открывает или создает папку на сервере для хранения материалов события");
        bFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFilesActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel20.setText("Действия");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(bCrew)
                                                .addGap(696, 696, 696))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tfKVS, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bInfoKvs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(tfVP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bInfoVp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboPF, 0, 131, Short.MAX_VALUE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboAE, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboNesActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9)
                                                        .addComponent(comboControl, 0, 79, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(63, 63, 63))
                                                        .addComponent(dateCorDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bFiles, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bSendToAE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(dateCorDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(bInfoVp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel20)
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel7))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(comboPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(comboNesActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(comboControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(comboAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(tfKVS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(tfVP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(bSendToAE)))
                                        .addComponent(bInfoKvs, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bCrew)
                                        .addComponent(bFiles))
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Отправка в авиаэскадрилью", jPanel2);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel15.setText("Для информации в авиаэскадрилью о данном событии");
        jLabel15.setToolTipText("Для отправки сообщения в авиаэскадрилью, просто заполните поле ниже и нажмите кнопку \"Подтвердить\". В эскадрильи смогут увидить причину, почему корректирующие действия по событию не были, например, приняты.");

        tpInfoFromGLazkov.setFont(new java.awt.Font("Tahoma", 0, 14));
        jScrollPane5.setViewportView(tpInfoFromGLazkov);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel16.setText("Оценка корректирующих действий");

        buttonGroup1.add(rbNotCA);
        rbNotCA.setText("Не одобрены");
        rbNotCA.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbNotCAItemStateChanged(evt);
            }
        });
        rbNotCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNotCAActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbGlazkov);
        rbGlazkov.setText("Командир ЛО");
        rbGlazkov.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbGlazkovItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rbRedkin);
        rbRedkin.setText("Зам КЛО");
        rbRedkin.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbRedkinItemStateChanged(evt);
            }
        });

        bAcceptCorAct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OK.png"))); // NOI18N
        bAcceptCorAct.setText("Подтвердить");
        bAcceptCorAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcceptCorActActionPerformed(evt);
            }
        });

        bCorrActGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/green.png"))); // NOI18N
        bCorrActGreen.setText("Присвоить низкий");
        bCorrActGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCorrActGreenActionPerformed(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bMatrixFD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matrix.png"))); // NOI18N
        bMatrixFD.setText("Матрица риска");
        bMatrixFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMatrixFDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(tfIndexFD, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bMatrixFD))
                                        .addComponent(tfRiskIndexFD, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tfRiskIndexFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(bMatrixFD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfIndexFD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addComponent(rbNotCA)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(rbRedkin)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(rbGlazkov))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addComponent(bAcceptCorAct)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bCorrActGreen))))
                                        .addComponent(jLabel16))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(rbGlazkov)
                                                        .addComponent(rbRedkin)
                                                        .addComponent(rbNotCA))
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(bCorrActGreen)
                                                        .addComponent(bAcceptCorAct)))
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jTabbedPane1.addTab("Оценка корректирующих действий", jPanel3);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel18.setText("Окончательная оценка риска и закрытие талона");

        bMatrix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matrix.png"))); // NOI18N
        bMatrix.setText("Матрица риска");
        bMatrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMatrixActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup2.add(rbZubkov);
        rbZubkov.setText("Зам Нач. ИБП");
        rbZubkov.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbZubkovItemStateChanged(evt);
            }
        });

        buttonGroup2.add(rbNotClosure);
        rbNotClosure.setText("Не закрыт");
        rbNotClosure.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbNotClosureItemStateChanged(evt);
            }
        });

        bAcceptClosure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/OK.png"))); // NOI18N
        bAcceptClosure.setText("Подтвердить");
        bAcceptClosure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAcceptClosureActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbChebrov);
        rbChebrov.setText("Начальник ИБП");
        rbChebrov.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbChebrovItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(rbNotClosure)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbZubkov)
                                                .addGap(18, 18, 18)
                                                .addComponent(rbChebrov)
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(bAcceptClosure)
                                                .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbChebrov)
                                        .addComponent(rbZubkov)
                                        .addComponent(rbNotClosure))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bAcceptClosure)
                                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap(16, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(tfIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(164, 164, 164)
                                                .addComponent(tfRiskIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(bMatrix)
                                                .addGap(6, 6, 6))
                                        .addComponent(jLabel18))
                                .addGap(46, 46, 46)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(tfIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel18)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(bMatrix)
                                                        .addComponent(tfRiskIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(467, 467, 467)
                                                .addComponent(jLabel22))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Закрытие талона", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jTabbedPane1, 0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEvent4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEvent4ActionPerformed
// TODO удалить этот метод 
    }//GEN-LAST:event_tfEvent4ActionPerformed

    private void bMatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMatrixActionPerformed
// кнопка вызова матрицы
        MatrixWindow matrix = new MatrixWindow();
        matrix.setParent(this);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 900) / 2;
        int locY = (screenSize.height - 630) / 2;
        matrix.setLocation(locX, locY);
        matrix.setVisible(true);
    }//GEN-LAST:event_bMatrixActionPerformed

    private void rbNotCAItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbNotCAItemStateChanged
// изменения фона и текста кнопки "не закрыто" в ЛО если выбрана
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            rbNotCA.setForeground(Color.red);
            rbNotCA.setFont(rbNotCA.getFont().deriveFont(Font.BOLD | Font.ITALIC));
            corActFIO = "";
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            rbNotCA.setForeground(jPanel5.getForeground());
            rbNotCA.setFont(rbNotClosure.getFont().deriveFont(Font.PLAIN));
        }
    }//GEN-LAST:event_rbNotCAItemStateChanged

    private void rbRedkinItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbRedkinItemStateChanged
// изменения фона и текста кнопки "Зам КЛО" в ЛО если выбрана
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            rbRedkin.setForeground(Color.BLUE);
            rbRedkin.setFont(rbRedkin.getFont().deriveFont(Font.BOLD | Font.ITALIC));
            corActFIO = FD_SUBCHIEF_ASSESSMENT;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            rbRedkin.setForeground(jPanel5.getForeground());
            rbRedkin.setFont(rbRedkin.getFont().deriveFont(Font.PLAIN));
        }
    }//GEN-LAST:event_rbRedkinItemStateChanged

    private void rbGlazkovItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbGlazkovItemStateChanged
// изменения фона и текста кнопки "Командир ЛО" в ЛО если выбрана
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            rbGlazkov.setForeground(Color.BLUE);
            rbGlazkov.setFont(rbGlazkov.getFont().deriveFont(Font.BOLD | Font.ITALIC));
            corActFIO = FD_CHEIF_ASSESSMENT;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            rbGlazkov.setForeground(jPanel5.getForeground());
            rbGlazkov.setFont(rbGlazkov.getFont().deriveFont(Font.PLAIN));
        }
    }//GEN-LAST:event_rbGlazkovItemStateChanged

    private void bSendToAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSendToAEActionPerformed
// Отправка в авиаэскадрилью - кнопка отправить
        if (dateCorDeadline.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Срок КД не заполнен!");
        } else {
            //подготавливаем стоки, где не должно быть одинарных ковычек при помощи регулярный выражений
            String kvs = tfKVS.getText();
            String kvsPrepared = kvs.replaceAll("\\'", "");
            String vp = tfVP.getText();
            String vpPrepared = vp.replaceAll("\\'", "");
            try {
                // Кнопка отправить ответ
                if (new DBUpdaterWorkingWindow().update(globalIncNbr, kvsPrepared, vpPrepared, comboPF.getSelectedItem().toString(),
                        comboAE.getSelectedItem().toString(), comboNesActions.getSelectedItem().toString(), comboControl.getSelectedItem().toString(),
                        dateCorDeadline.getDate())) {
                    JOptionPane.showMessageDialog(null, "Событие успешно передано в авиаэскадрилью № " + comboAE.getSelectedItem().toString());
                    this.parent.getConcoleText(" >> Событие номер " + insideStr + " было передано в авиаэскадрилью № " + comboAE.getSelectedItem().toString());
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Не получилось сохранить, пожалуйста, проинформируйте разработчка об ошибке! Метод bSendToAEActionPerformed класса WorkingWindow3");
                }
            } catch (ParseException ex) {
                Logger.getLogger(WorkingWindow3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bSendToAEActionPerformed

    private void bAcceptCorActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcceptCorActActionPerformed
// Оценка корректирующих действий - работа кнопки "подтвердить"
        String indexIncoming;
        int index = 0;
        if ((tfRiskIndexFD.getText().isEmpty() & rbRedkin.isSelected() == true) || (tfRiskIndexFD.getText().isEmpty() & rbGlazkov.isSelected() == true)) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, выберите степень риска!");
        } else if (tfRiskIndexFD.getText().contains("риск") & rbRedkin.isSelected() == false & rbGlazkov.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Если выбрана степень риска, то пожалуйста, выберите должность лица, производящего оценку корректирующих действий. Либо измените поле с оценкой риска");
        } else {
            // если пользователь все заполнил - закрываем талон, отправляем данные в БД
            try {
                if (tfIndexFD.getText().length() != 0) {
                    indexIncoming = tfIndexFD.getText();
                    index = Integer.parseInt(indexIncoming);
                }
                //если индекс риска 10 и менее - сразу закрываем талон
                if ((index <= 10 & rbRedkin.isSelected() == true) || (index <= 10 & rbGlazkov.isSelected() == true)) {
                    String talonClosingToken = SAFETY_MANAGER_ASSESSMENT;
                    if (new DBUpdaterWorkingWindow().update2pageWithClosure(globalIncNbr, tpInfoFromGLazkov.getText(), index, corActFIO, talonClosingToken)) {
                        JOptionPane.showMessageDialog(null, "Информация успешно добавлена в базу данных");
                        if (rbRedkin.isSelected() == true || rbGlazkov.isSelected() == true) {
                            this.parent.getConcoleText(" >> Корректирующие дейcтвия по событию номер " + insideStr + " были одобренны. Событие получило статус <КД одобрены> в базе.");
                            dispose();
                        } else {
                            this.parent.getConcoleText(" >> Ответ по событию номер " + insideStr + " был передан в авиаэскадрилью № " + comboAE.getSelectedItem().toString() + " Событие имеет статус <КД не одобрены>");
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Не получилось сохранить запись, пожалуйста, проверьте подключение к базе данных!");
                    }
                    //иначе выставляем риск и оставляет талон закрытм
                } else {
                    if (new DBUpdaterWorkingWindow().update2page(globalIncNbr, tpInfoFromGLazkov.getText(), index, corActFIO)) {
                        JOptionPane.showMessageDialog(null, "Информация успешно добавлена в базу данных");
                        if (rbRedkin.isSelected() == true || rbGlazkov.isSelected() == true) {
                            this.parent.getConcoleText(" >> Корректирующие дейcтвия по событию номер " + insideStr + " были одобренны. Событие получило статус <КД одобрены> в базе.");
                            dispose();
                        } else {
                            this.parent.getConcoleText(" >> Ответ по событию номер " + insideStr + " был передан в авиаэскадрилью № " + comboAE.getSelectedItem().toString() + " Событие имеет статус <КД не одобрены>");
                            dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Не получилось сохранить запись, пожалуйста, проверьте подключение к базе данных!");
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(WorkingWindow3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bAcceptCorActActionPerformed

    private void rbNotCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNotCAActionPerformed
// TODO удалить метод     
    }//GEN-LAST:event_rbNotCAActionPerformed

    private void bCorrActGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCorrActGreenActionPerformed
// Оценка корректирующих действий - работа кнопки "быстро зеленый"
        if (rbRedkin.isSelected() == false & rbGlazkov.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, выберите должность закрывающего, для быстрой оценки корректирующих действий");
        } else {
            try {
                // Кнопка отправить ответ
                String talonClosingToken = SAFETY_MANAGER_ASSESSMENT;
                int index = 2;
                if (new DBUpdaterWorkingWindow().update2pageWithClosure(globalIncNbr, tpInfoFromGLazkov.getText(), index, corActFIO, talonClosingToken)) {
                    JOptionPane.showMessageDialog(null, "Информация успешно добавлена в базу данных");
                    if (rbRedkin.isSelected() == true || rbGlazkov.isSelected() == true) {
                        this.parent.getConcoleText(" >> Корректирующие дейcтвия по событию номер " + insideStr + " были одобренны. Событие получило статус <КД одобрены> в базе.");
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Не получилось сохранить запись, пожалуйста, проверьте подключение к базе данных!");
                }
            } catch (ParseException ex) {
                Logger.getLogger(WorkingWindow3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bCorrActGreenActionPerformed

    private void bCrewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrewActionPerformed
// кнопка вызова справочника персонала
        Personnel pers = new Personnel();
        pers.setParent(this);
        pers.setVisible(true);
    }//GEN-LAST:event_bCrewActionPerformed

    private void bInfoKvsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInfoKvsActionPerformed
// кнопка информация по командиру   
        if (tfKVS.getText().equals("") || tfKVS.getText().equals(" ") || tfKVS.getText().equals("  ") || tfKVS.getText() == null) {
        } else {
            String ID = tfKVS.getText();
            Object[] infoData = new PersonnelDBUpdater().getInfoKVS(ID);
            if (infoData == null) {
                JOptionPane.showMessageDialog(null, "Сотрудник с ID: " + ID + " не найден в перечне персонала ЛО");
            } else {
                String name, ae, position;
                if (infoData[0] == null) {
                    name = "";
                } else {
                    name = infoData[0].toString();
                }
                if (infoData[1] == null) {
                    ae = "";
                } else {
                    ae = infoData[1].toString();
                }
                if (infoData[2] == null) {
                    position = "";
                } else {
                    position = infoData[2].toString();
                }
                JOptionPane.showMessageDialog(null, "ФИО: " + name + " \nАвиаэскадрилья: " + ae + "\nДолжность: " + position);
            }
        }
    }//GEN-LAST:event_bInfoKvsActionPerformed

    private void bInfoVpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInfoVpActionPerformed
// кнопка информация по второму пилоту   
        if (tfVP.getText().equals("") || tfVP.getText().equals(" ") || tfVP.getText().equals("  ") || tfVP.getText() == null) {
        } else {
            String ID = tfVP.getText();
            Object[] infoData = new PersonnelDBUpdater().getInfoKVS(ID);
            if (infoData == null) {
                JOptionPane.showMessageDialog(null, "Сотрудник с ID: " + ID + " не найден в перечне персонала ЛО");
            } else {
                String name, ae, position;
                if (infoData[0] == null) {
                    name = "";
                } else {
                    name = infoData[0].toString();
                }
                if (infoData[1] == null) {
                    ae = "";
                } else {
                    ae = infoData[1].toString();
                }
                if (infoData[2] == null) {
                    position = "";
                } else {
                    position = infoData[2].toString();
                }
                JOptionPane.showMessageDialog(null, "ФИО: " + name + " \nАвиаэскадрилья: " + ae + "\nДолжность: " + position);
            }
        }
    }//GEN-LAST:event_bInfoVpActionPerformed

    private void openFile() {
        //метод открывает файл с нстройками рабочего окна
        try {
            File file = new File("./lib/exchange.properties").getAbsoluteFile();
            scan = new Scanner(file);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Файл exchange.properties не найден");
        }

    }

    private String readFile() {
        String folderNameOnServer = scan.next();
        return folderNameOnServer;
    }

    private void bFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFilesActionPerformed

        String fileFolder = Main.netFolderPath + folderName;

        File f = new File(fileFolder);

        if (f.exists()) {
            try {
                Runtime.getRuntime().exec("explorer " + fileFolder);
            } catch (IOException ex) {
                Logger.getLogger(WorkingWindow3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            new File(fileFolder).mkdir();
            try {
                Runtime.getRuntime().exec("explorer " + fileFolder);
            } catch (IOException ex) {
                Logger.getLogger(WorkingWindow3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bFilesActionPerformed

    private void rbZubkovItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbZubkovItemStateChanged
// изменения фона и текста кнопки "зам нач ИБП" в ИБП если выбрана
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            rbZubkov.setForeground(Color.BLUE);
            rbZubkov.setFont(rbZubkov.getFont().deriveFont(Font.BOLD | Font.ITALIC));
            talonCloseFIO = "Зубков О.В.";
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            rbZubkov.setForeground(jPanel5.getForeground());
            rbZubkov.setFont(rbZubkov.getFont().deriveFont(Font.PLAIN));
        }
    }//GEN-LAST:event_rbZubkovItemStateChanged

    private void rbChebrovItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbChebrovItemStateChanged
// изменения фона и текста кнопки "нач ИБП" в ИБП если выбрана
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            rbChebrov.setForeground(Color.BLUE);
            rbChebrov.setFont(rbChebrov.getFont().deriveFont(Font.BOLD | Font.ITALIC));
            talonCloseFIO = SAFETY_MANAGER_ASSESSMENT;
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            rbChebrov.setForeground(jPanel5.getForeground());
            rbChebrov.setFont(rbChebrov.getFont().deriveFont(Font.PLAIN));
        }
    }//GEN-LAST:event_rbChebrovItemStateChanged

    private void bAcceptClosureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAcceptClosureActionPerformed
// Закрытие талона - работа кнопки "подтвердить"
        String indexIncoming;
        int index = 0;

        if ((tfRiskIndex.getText().isEmpty() & rbZubkov.isSelected() == true) || (tfRiskIndex.getText().isEmpty() & rbChebrov.isSelected() == true)) {
            JOptionPane.showMessageDialog(null, "Пожалуйста, выберите степень риска!");
        } else if (rbNotClosure.isSelected() == true) {
            try {
                if (tfIndex.getText().length() != 0) {
                    indexIncoming = tfIndex.getText();
                    index = Integer.parseInt(indexIncoming);
                }
                // Кнопка отправить ответ
                talonCloseFIO = "";
                if (new DBUpdaterWorkingWindow().update3page(globalIncNbr, index, talonCloseFIO)) {
                    JOptionPane.showMessageDialog(null, "Талон получил статус <не закрыт>");
                    this.parent.getConcoleText(" >> Талон по событию номер " + insideStr + " получил статус <не закрыт>");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Не получилось сохранить, пожалуйста, проинформируйте разработчка об ошибке! Метод bAcceptClosureActionPerformed класса WorkingWindow3");
                }
            } catch (ParseException ex) {
                Logger.getLogger(WorkingWindow3.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (tfIndex.getText().length() != 0) {
                    indexIncoming = tfIndex.getText();
                    index = Integer.parseInt(indexIncoming);
                }
                // Кнопка отправить ответ
                if (new DBUpdaterWorkingWindow().update3page(globalIncNbr, index, talonCloseFIO)) {
                    JOptionPane.showMessageDialog(null, "Информация успешно добавлена в базу данных");
                    if (rbZubkov.isSelected() == true || rbChebrov.isSelected() == true) {

                        //newString = makeParsing();
                        this.parent.getConcoleText(" >> Талон по событию номер " + insideStr + " был <закрыт>.");
                        dispose();
                    } else {
                        this.parent.getConcoleText(" >> Талон по событию номер " + insideStr + " получил статус <не закрыт>");
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Не получилось сохранить, пожалуйста, проинформируйте разработчка об ошибке! Метод bAcceptClosureActionPerformed класса WorkingWindow3");
                }
            } catch (ParseException ex) {
                Logger.getLogger(WorkingWindow3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bAcceptClosureActionPerformed

    private void rbNotClosureItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbNotClosureItemStateChanged
// изменения фона и текста кнопки "не закрыто" в ИБП если выбрана
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            rbNotClosure.setForeground(Color.red);
            rbNotClosure.setFont(rbNotClosure.getFont().deriveFont(Font.BOLD | Font.ITALIC));
            talonCloseFIO = "";
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            rbNotClosure.setForeground(jPanel5.getForeground());
            rbNotClosure.setFont(rbNotClosure.getFont().deriveFont(Font.PLAIN));
        }
    }//GEN-LAST:event_rbNotClosureItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        boolean docChange = MyDocumentListener.isDocumentChanged();

        if (docChange == true || comboChanged == true) {

            Object[] options = {"Не сохранять", "Отмена"};
            int status = JOptionPane.showOptionDialog(evt.getWindow(),
                    "Вы действительно хотите закрыть окно? Все несохраненные данные - будут утеряны!", "Закрыть окно",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);
            if (status == 0) {
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dispose();
            } else {
                setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                evt.getWindow().setVisible(true);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void comboPFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPFItemStateChanged
        comboChanged = true;
    }//GEN-LAST:event_comboPFItemStateChanged

    private void comboAEItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAEItemStateChanged
        comboChanged = true;
    }//GEN-LAST:event_comboAEItemStateChanged

    private void comboNesActionsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboNesActionsItemStateChanged
        comboChanged = true;
    }//GEN-LAST:event_comboNesActionsItemStateChanged

    private void comboControlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboControlItemStateChanged
        comboChanged = true;
    }//GEN-LAST:event_comboControlItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // Кнопка отправить ответ
            if (new DBUpdaterWorkingWindow().updateAnalysis(globalIncNbr, tpAnalysis.getText(), tpCorrectiveActions.getText())) {
                JOptionPane.showMessageDialog(null, "Анализ и корректирующие действия были успешно изменены!");
            } else {
                JOptionPane.showMessageDialog(null, "Не получилось сохранить! Пожалуйста, проверьте доступность подключения к серверу");
            }
        } catch (ParseException ex) {
            Logger.getLogger(WorkingWindow3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bMatrixFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMatrixFDActionPerformed
        MatrixWindowFD matrixFD = new MatrixWindowFD();
        matrixFD.setParent(this);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (screenSize.width - 900) / 2;
        int locY = (screenSize.height - 630) / 2;
        matrixFD.setLocation(locX, locY);
        matrixFD.setVisible(true);
    }//GEN-LAST:event_bMatrixFDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAcceptClosure;
    private javax.swing.JButton bAcceptCorAct;
    private javax.swing.JButton bCorrActGreen;
    private javax.swing.JButton bCrew;
    private javax.swing.JButton bFiles;
    private javax.swing.JButton bInfoKvs;
    private javax.swing.JButton bInfoVp;
    private javax.swing.JButton bMatrix;
    private javax.swing.JButton bMatrixFD;
    private javax.swing.JButton bSendToAE;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox comboAE;
    private javax.swing.JComboBox comboControl;
    private javax.swing.JComboBox comboNesActions;
    private javax.swing.JComboBox comboPF;
    private com.toedter.calendar.JDateChooser dateCorDeadline;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbChebrov;
    private javax.swing.JRadioButton rbGlazkov;
    private javax.swing.JRadioButton rbNotCA;
    private javax.swing.JRadioButton rbNotClosure;
    private javax.swing.JRadioButton rbRedkin;
    private javax.swing.JRadioButton rbZubkov;
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
    private javax.swing.JTextField tfIndex;
    private javax.swing.JTextField tfIndexFD;
    private javax.swing.JTextField tfKVS;
    private javax.swing.JTextField tfRiskIndex;
    private javax.swing.JTextField tfRiskIndexFD;
    private javax.swing.JTextField tfVP;
    private javax.swing.JTextPane tpAnalysis;
    private javax.swing.JTextPane tpCorrectiveActions;
    private javax.swing.JTextPane tpInfoFromGLazkov;
    private javax.swing.JTextPane tpPrim;
    // End of variables declaration//GEN-END:variables
}
