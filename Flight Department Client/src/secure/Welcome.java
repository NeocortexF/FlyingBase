package secure;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Welcome extends JFrame {

    public static String str = null;
    private int tabIndex = 0;
    public static String consoleCurrentText = "";
    public static String consoleNewText;
    private Scanner scan;
    public static int sqlFlag = 1;

    public Welcome() {

        initComponents();
        retrieve(1);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    //метод обновления консоли
    public String getConcoleText(String incomingMessage) {
        StringBuilder sb = new StringBuilder();
        sb.append(consoleCurrentText);
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sb.append(sdf.format(cal.getTime()));
        sb.append(incomingMessage);
        sb.append(System.getProperty("line.separator"));
        consoleNewText = sb.toString();
        consoleCurrentText = consoleNewText;
        txtConsole.setText(consoleCurrentText);
        return consoleNewText;
    }
    // Методы дополнительной фильтрации из пунктов меню главного окна

    public void retrieveFilterPilot(int pilotID) {
        DefaultTableModel dm = new DBUpdater().getDataFilterPilot(pilotID);

        ColorRenderer colorRenderer = new ColorRenderer();
        colorRenderer.setHorizontalAlignment(JLabel.CENTER);

        ColorRendererAE rendAe = new ColorRendererAE();
        rendAe.setHorizontalAlignment(JLabel.CENTER);

        jTable1.setModel(dm);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(rendAe);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(11).setCellRenderer(colorRenderer);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(13).setMinWidth(0);
        jTable1.getColumnModel().getColumn(13).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(14).setMinWidth(0);
        jTable1.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    public void retrieveFilterEvent(int eventID) {
        DefaultTableModel dm = new DBUpdater().getDataFilterEvent(eventID);

        ColorRenderer colorRenderer = new ColorRenderer();
        colorRenderer.setHorizontalAlignment(JLabel.CENTER);

        ColorRendererAE rendAe = new ColorRendererAE();
        rendAe.setHorizontalAlignment(JLabel.CENTER);

        jTable1.setModel(dm);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(rendAe);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(11).setCellRenderer(colorRenderer);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(13).setMinWidth(0);
        jTable1.getColumnModel().getColumn(13).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(14).setMinWidth(0);
        jTable1.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    public void retrieveFilterDeparture(String codeICAO) {
        DefaultTableModel dm = new DBUpdater().getDataFilterDeparture(codeICAO);

        ColorRenderer colorRenderer = new ColorRenderer();
        colorRenderer.setHorizontalAlignment(JLabel.CENTER);

        ColorRendererAE rendAe = new ColorRendererAE();
        rendAe.setHorizontalAlignment(JLabel.CENTER);

        jTable1.setModel(dm);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(rendAe);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(11).setCellRenderer(colorRenderer);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(13).setMinWidth(0);
        jTable1.getColumnModel().getColumn(13).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(14).setMinWidth(0);
        jTable1.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    public void retrieveFilterArrival(String codeICAO) {
        DefaultTableModel dm = new DBUpdater().getDataFilterArrival(codeICAO);

        ColorRenderer colorRenderer = new ColorRenderer();
        colorRenderer.setHorizontalAlignment(JLabel.CENTER);

        ColorRendererAE rendAe = new ColorRendererAE();
        rendAe.setHorizontalAlignment(JLabel.CENTER);

        jTable1.setModel(dm);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(rendAe);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(11).setCellRenderer(colorRenderer);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(13).setMinWidth(0);
        jTable1.getColumnModel().getColumn(13).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(14).setMinWidth(0);
        jTable1.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    public void retrieveFilterTail(String tailNumberOfAc) {
        DefaultTableModel dm = new DBUpdater().getDataFilterTail(tailNumberOfAc);

        ColorRenderer colorRenderer = new ColorRenderer();
        colorRenderer.setHorizontalAlignment(JLabel.CENTER);

        ColorRendererAE rendAe = new ColorRendererAE();
        rendAe.setHorizontalAlignment(JLabel.CENTER);

        jTable1.setModel(dm);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(rendAe);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(11).setCellRenderer(colorRenderer);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(13).setMinWidth(0);
        jTable1.getColumnModel().getColumn(13).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(14).setMinWidth(0);
        jTable1.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    //обновление Jtable
    private void retrieve(int sqlFlag) {
        DefaultTableModel dm = new DBUpdater().getData(sqlFlag);

        ColorRenderer colorRenderer = new ColorRenderer();
        colorRenderer.setHorizontalAlignment(JLabel.CENTER);

        ColorRendererAE rendAe = new ColorRendererAE();
        rendAe.setHorizontalAlignment(JLabel.CENTER);

        jTable1.setModel(dm);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(7).setCellRenderer(rendAe);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(11).setCellRenderer(colorRenderer);
        jTable1.getColumnModel().getColumn(13).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(13).setMinWidth(0);
        jTable1.getColumnModel().getColumn(13).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(14).setPreferredWidth(0);
        jTable1.getColumnModel().getColumn(14).setMinWidth(0);
        jTable1.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        // метод для изменения размера шрифта в программе
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, f);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jProgressBar1 = new javax.swing.JProgressBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {     // наверное зджесь номер ряда
                return getValueAt(0, column).getClass();
            }
        };
        jPanel2 = new javax.swing.JPanel();
        bRetrieve = new javax.swing.JButton();
        bSelect = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();
        radioNotApproved = new javax.swing.JRadioButton();
        radioNotClosed = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        radioAll = new javax.swing.JRadioButton();
        radioNoGreen = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniClassic = new javax.swing.JMenuItem();
        mniWindows = new javax.swing.JMenuItem();
        mniMotif = new javax.swing.JMenuItem();
        mniNimbus = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniFont12 = new javax.swing.JMenuItem();
        mniFont14 = new javax.swing.JMenuItem();
        mniFont16 = new javax.swing.JMenuItem();
        mniFont18 = new javax.swing.JMenuItem();
        mniCommanderName = new javax.swing.JMenu();
        mniChebrov = new javax.swing.JMenuItem();
        mniZubkov = new javax.swing.JMenuItem();
        mniCommanderLO = new javax.swing.JMenuItem();
        mniZamCom = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        mniTab0 = new javax.swing.JMenuItem();
        mniTab1 = new javax.swing.JMenuItem();
        mniTab2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mniAdminUsers = new javax.swing.JMenuItem();
        mniClassificator = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        mnuIndividual = new javax.swing.JMenuItem();
        mnuTop10 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        mnuFilterPilot = new javax.swing.JMenuItem();
        mnuFilterEvent = new javax.swing.JMenuItem();
        mnuFilterAC = new javax.swing.JMenuItem();
        mnuFilterDeparture = new javax.swing.JMenuItem();
        mnuFilterArrival = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuLycense = new javax.swing.JMenuItem();
        mnuBagReport = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Flying Base: Flight Department ");
        setBackground(new java.awt.Color(102, 102, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Arial", 0, 14));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "№", "Дата обработки", "Дата полета", "Рейс", "Взлет", "Посадка", "Борт. номер", "AirFASE_1", "AirFASE_2", "AirFASE_3", "AirFASE_4", "Обработал(а)", "Принято и отправлено"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(2).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setResizable(false);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(4).setResizable(false);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(5).setResizable(false);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(6).setResizable(false);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(7).setResizable(false);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(8).setResizable(false);
        jTable1.getColumnModel().getColumn(9).setResizable(false);
        jTable1.getColumnModel().getColumn(10).setResizable(false);
        jTable1.getColumnModel().getColumn(11).setResizable(false);
        jTable1.getColumnModel().getColumn(12).setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bRetrieve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh-icon.png"))); // NOI18N
        bRetrieve.setText("Обновить данные");
        bRetrieve.setToolTipText("Обновить данные. Так же можно использовать нажатие клавиши F5 на клавиатуре. Дополнительно можно выбрать фильтр тех данных, которые вы хотите получить.");
        bRetrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetrieveActionPerformed(evt);
            }
        });

        bSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        bSelect.setText("Выбрать событие");
        bSelect.setToolTipText("Выбрать событие для детального отображения и возможности редактирования. Так же можно использовать двойной щелчок по событию в перечне событий.");
        bSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectActionPerformed(evt);
            }
        });

        txtConsole.setColumns(20);
        txtConsole.setEditable(false);
        txtConsole.setRows(5);
        jScrollPane2.setViewportView(txtConsole);

        buttonGroup1.add(radioNotApproved);
        radioNotApproved.setText("Не одобренные");
        radioNotApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNotApprovedActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioNotClosed);
        radioNotClosed.setText("Не закрытые");
        radioNotClosed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNotClosedActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setText("Фильтр событий");

        buttonGroup1.add(radioAll);
        radioAll.setSelected(true);
        radioAll.setText("Показать все");
        radioAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAllActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioNoGreen);
        radioNoGreen.setText("Без низкого риска");
        radioNoGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoGreenActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel2.setText("Последние выполненные действия");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(radioAll)
                                                        .addComponent(radioNotApproved))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(radioNoGreen)
                                                        .addComponent(radioNotClosed))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(bRetrieve)
                                                        .addComponent(bSelect))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bSelect, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(radioNoGreen, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(radioAll, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bRetrieve, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(radioNotClosed, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(radioNotApproved, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Внешний вид");
        jMenu1.setActionCommand("Внешний вид    ");

        mniClassic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/classic.png"))); // NOI18N
        mniClassic.setText("Classic");
        mniClassic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniClassicActionPerformed(evt);
            }
        });
        jMenu1.add(mniClassic);

        mniWindows.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/windows.png"))); // NOI18N
        mniWindows.setText("Windows");
        mniWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniWindowsActionPerformed(evt);
            }
        });
        jMenu1.add(mniWindows);

        mniMotif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/motif.png"))); // NOI18N
        mniMotif.setText("Motif");
        mniMotif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniMotifActionPerformed(evt);
            }
        });
        jMenu1.add(mniMotif);

        mniNimbus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nimbus.png"))); // NOI18N
        mniNimbus.setText("Nimbus");
        mniNimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNimbusActionPerformed(evt);
            }
        });
        jMenu1.add(mniNimbus);
        jMenu1.add(jSeparator1);

        mniFont12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volumeLow.png"))); // NOI18N
        mniFont12.setText("Мелкий шрифт");
        mniFont12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFont12ActionPerformed(evt);
            }
        });
        jMenu1.add(mniFont12);

        mniFont14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volumeLowMid.png"))); // NOI18N
        mniFont14.setText("Средний шрифт");
        mniFont14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFont14ActionPerformed(evt);
            }
        });
        jMenu1.add(mniFont14);

        mniFont16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volumeMid.png"))); // NOI18N
        mniFont16.setText("Крупный шрифт");
        mniFont16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFont16ActionPerformed(evt);
            }
        });
        jMenu1.add(mniFont16);

        mniFont18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volumeHigh.png"))); // NOI18N
        mniFont18.setText("Самый крупный");
        mniFont18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFont18ActionPerformed(evt);
            }
        });
        jMenu1.add(mniFont18);

        jMenuBar1.add(jMenu1);

        mniCommanderName.setText("Персональные настройки");
        mniCommanderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCommanderNameActionPerformed(evt);
            }
        });

        mniChebrov.setText("ФИО Начальника ИБП");
        mniChebrov.setEnabled(false);
        mniChebrov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniChebrovActionPerformed(evt);
            }
        });
        mniCommanderName.add(mniChebrov);

        mniZubkov.setText("ФИО Зам. Начальника ИБП");
        mniZubkov.setEnabled(false);
        mniCommanderName.add(mniZubkov);

        mniCommanderLO.setText("ФИО Командира ЛО");
        mniCommanderLO.setEnabled(false);
        mniCommanderName.add(mniCommanderLO);

        mniZamCom.setText("ФИО Зам. Командира ЛО");
        mniZamCom.setEnabled(false);
        mniCommanderName.add(mniZamCom);
        mniCommanderName.add(jSeparator2);

        jMenu5.setText("Стартовая закладка рабочего окна");

        mniTab0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sendToPilots.png"))); // NOI18N
        mniTab0.setText("Отправка в авиаэскадрилью");
        mniTab0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTab0ActionPerformed(evt);
            }
        });
        jMenu5.add(mniTab0);

        mniTab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/stock.png"))); // NOI18N
        mniTab1.setText("Оценка корректирующих действий");
        mniTab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTab1ActionPerformed(evt);
            }
        });
        jMenu5.add(mniTab1);

        mniTab2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/matrix.png"))); // NOI18N
        mniTab2.setText("Окончательная оценка риска");
        mniTab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTab2ActionPerformed(evt);
            }
        });
        jMenu5.add(mniTab2);

        mniCommanderName.add(jMenu5);

        jMenuBar1.add(mniCommanderName);

        jMenu4.setText("Администрирование");

        mniAdminUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/сreate user.png"))); // NOI18N
        mniAdminUsers.setText("Пользователи");
        mniAdminUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAdminUsersActionPerformed(evt);
            }
        });
        jMenu4.add(mniAdminUsers);

        mniClassificator.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/color_management.png"))); // NOI18N
        mniClassificator.setText("Классификатор");
        mniClassificator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniClassificatorActionPerformed(evt);
            }
        });
        jMenu4.add(mniClassificator);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Отчеты и статистика");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/choose.png"))); // NOI18N
        jMenuItem1.setText("На отчет для анализа ЛО");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);
        jMenu6.add(jSeparator3);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/anal_pie_chart.png"))); // NOI18N
        jMenu7.setText("Статистика по степени риска");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/piechart-16.png"))); // NOI18N
        jMenuItem2.setText("Распределение по степени риска");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Areacharts-16.png"))); // NOI18N
        jMenuItem3.setText("Помесячная по степени риска");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Barchart1-16.png"))); // NOI18N
        jMenuItem4.setText("10 наиболее частых событий");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);
        jMenu7.add(jSeparator4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trend oran.png"))); // NOI18N
        jMenuItem5.setText("Динамика по высокому риску");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trend yell.png"))); // NOI18N
        jMenuItem9.setText("Динамика по умеренному риску");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/trend green.png"))); // NOI18N
        jMenuItem10.setText("Динамика по низкому риску");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem10);

        jMenu6.add(jMenu7);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/barchart.png"))); // NOI18N
        jMenu8.setText("Статистика индивидуальной работы");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kvspilot.png"))); // NOI18N
        jMenuItem7.setText("КВС пилотирующий");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2ppilot.png"))); // NOI18N
        jMenuItem8.setText("2П пилотирующий");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem8);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/kvsekipaj.png"))); // NOI18N
        jMenuItem6.setText("КВС экипаж");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem6);

        mnuIndividual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gnumeric.png"))); // NOI18N
        mnuIndividual.setText("Индивидуальная");
        mnuIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIndividualActionPerformed(evt);
            }
        });
        jMenu8.add(mnuIndividual);

        mnuTop10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/top10.png"))); // NOI18N
        mnuTop10.setText("Топ 10 по ЛО");
        mnuTop10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuTop10ActionPerformed(evt);
            }
        });
        jMenu8.add(mnuTop10);

        jMenu6.add(jMenu8);

        jMenuBar1.add(jMenu6);

        jMenu9.setText("Доп. фильтры");

        mnuFilterPilot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pilotDark.png"))); // NOI18N
        mnuFilterPilot.setText("По пилоту");
        mnuFilterPilot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFilterPilotActionPerformed(evt);
            }
        });
        jMenu9.add(mnuFilterPilot);

        mnuFilterEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/number.png"))); // NOI18N
        mnuFilterEvent.setText("По номеру Event");
        mnuFilterEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFilterEventActionPerformed(evt);
            }
        });
        jMenu9.add(mnuFilterEvent);

        mnuFilterAC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tailnbr.png"))); // NOI18N
        mnuFilterAC.setText("По бортовому номеру");
        mnuFilterAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFilterACActionPerformed(evt);
            }
        });
        jMenu9.add(mnuFilterAC);

        mnuFilterDeparture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/departure.png"))); // NOI18N
        mnuFilterDeparture.setText("По аэропорту вылета");
        mnuFilterDeparture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFilterDepartureActionPerformed(evt);
            }
        });
        jMenu9.add(mnuFilterDeparture);

        mnuFilterArrival.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arriva.png"))); // NOI18N
        mnuFilterArrival.setText("По аэропорту посадки");
        mnuFilterArrival.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFilterArrivalActionPerformed(evt);
            }
        });
        jMenu9.add(mnuFilterArrival);

        jMenuBar1.add(jMenu9);

        mnuHelp.setText("?");

        mnuLycense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/copyright.png"))); // NOI18N
        mnuLycense.setText("Лицензионное соглашение");
        mnuLycense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLycenseActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuLycense);

        mnuBagReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bugerror.png"))); // NOI18N
        mnuBagReport.setText("Сообщить об ошибке");
        mnuBagReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBagReportActionPerformed(evt);
            }
        });
        mnuHelp.add(mnuBagReport);

        jMenuBar1.add(mnuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Look and feel menu
    private void mniClassicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniClassicActionPerformed

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_mniClassicActionPerformed

    private void mniWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniWindowsActionPerformed
// Пункт меню UI Windows
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniWindowsActionPerformed

    private void mniMotifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniMotifActionPerformed
        // Пункт меню UI Motif
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniMotifActionPerformed

    private void mniNimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNimbusActionPerformed
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniNimbusActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // событие клик по таблице
        if (evt.getClickCount() == 2) {
            if (!jTable1.getValueAt(jTable1.getSelectedRow(), 0).equals("")) { //
                str = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Для детального просмотра, пожалуйста, выберите доступное событие из списка",
                        "Вы не выбрали событие!",
                        JOptionPane.ERROR_MESSAGE);
            }
            getConcoleText(" >> Событие номер " + str + " было выбрано для просмотра");

            WorkingWindow3 ww;
            //           ----------------------------------------------------------------------
            openFile();
            String status = readFile();
            int statusInt = Integer.parseInt(status);
            tabIndex = statusInt;
            try {
                ww = new WorkingWindow3(str, tabIndex);
                ww.setParent(this);
                ww.setVisible(true);
            } catch (ParseException ex) {
                Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void bRetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetrieveActionPerformed
        // извлечь данные из базы
        retrieve(sqlFlag);
        getConcoleText(" >> Произведено обновление данных из базы сервера ");
    }//GEN-LAST:event_bRetrieveActionPerformed

    private void bSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectActionPerformed
        // кнопка выбрать сообщение для работы с ним
        if (!jTable1.getValueAt(jTable1.getSelectedRow(), 0).equals("")) { //
            str = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для детального просмотра, пожалуйста, выберите доступное событие из списка",
                    "Вы не выбрали событие!",
                    JOptionPane.ERROR_MESSAGE);
        }
        getConcoleText(" >> Событие номер " + str + " было выбрано для просмотра");

        WorkingWindow3 ww;
        //          ----------------------------------------------------------------------
        openFile();
        String status = readFile();
        int statusInt = Integer.parseInt(status);
        tabIndex = statusInt;
        try {
            ww = new WorkingWindow3(str, tabIndex);
            ww.setParent(this);
            ww.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bSelectActionPerformed

    private void mniCommanderNameActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void mniChebrovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniChebrovActionPerformed
    // Меню изменить имя командира авиаэскадрильи
    }//GEN-LAST:event_mniChebrovActionPerformed

    private void mniFont12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFont12ActionPerformed
    // Меню мелкий шрифт
        setUIFont(new javax.swing.plaf.FontUIResource("Tahoma", Font.PLAIN, 12));
    }//GEN-LAST:event_mniFont12ActionPerformed

    private void mniFont14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFont14ActionPerformed
    // Меню средний шрифт
        setUIFont(new javax.swing.plaf.FontUIResource("Tahoma", Font.PLAIN, 14));
    }//GEN-LAST:event_mniFont14ActionPerformed

    private void mniFont16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFont16ActionPerformed
    // Меню крупный шрифт
        setUIFont(new javax.swing.plaf.FontUIResource("Tahoma", Font.PLAIN, 16));
    }//GEN-LAST:event_mniFont16ActionPerformed

    private void mniFont18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFont18ActionPerformed
    // Меню самый курпный шрифт
        setUIFont(new javax.swing.plaf.FontUIResource("Tahoma", Font.PLAIN, 18));
    }//GEN-LAST:event_mniFont18ActionPerformed

    private void mniAdminUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAdminUsersActionPerformed
    // панель администрирования юзер - пароль
        AdminPanel apanel = new AdminPanel();
        apanel.setVisible(true);
    }//GEN-LAST:event_mniAdminUsersActionPerformed

    private void openFile() {
        //метод открывает файл с настройками рабочего окна
        try {
            File file = new File("./lib/windowsettings.properties").getAbsoluteFile();
            scan = new Scanner(file);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Файл windowsettings.properties не найден");
        }

    }

    private String readFile() {
        //метод читает файл
        //     ----------------------------------------------------------------------
        String statusMessage = scan.next();
        //String statusMessage = "1";
        return statusMessage;
    }

    private void mniTab0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTab0ActionPerformed
    // Пункт меню сделать первую закладку по умолчанию
        tabIndex = 0;
        File myFile = new File("./lib/windowsettings.properties").getAbsoluteFile();
        String newPropertyString = "0";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
            writer.write(newPropertyString);
            //очитсить буфер java куда сохраняется порциями для записи к файлу сразу порции а не 10 раз открывтат  файл
            writer.flush();
            //закрыть файл
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniTab0ActionPerformed

    private void mniTab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTab1ActionPerformed
    // Пункт меню сделать вторую закладку по умолчанию
        tabIndex = 1;
        File myFile = new File("./lib/windowsettings.properties").getAbsoluteFile();
        String newPropertyString = "1";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
            writer.write(newPropertyString);
            //очитсить буфер java куда сохраняется порциями для записи к файлу сразу порции а не 10 раз открывтат  файл
            writer.flush();
            //закрыть файл
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniTab1ActionPerformed

    private void mniTab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTab2ActionPerformed
    // Пункт меню сделать третью закладку по умолчанию
        tabIndex = 2;
        File myFile = new File("./lib/windowsettings.properties").getAbsoluteFile();
        String newPropertyString = "2";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
            writer.write(newPropertyString);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mniTab2ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        //Обновление на F5
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            retrieve(sqlFlag);
            getConcoleText(" >> произведено обновление данных из базы данных ");
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void radioNotClosedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNotClosedActionPerformed
        sqlFlag = 3;
    }//GEN-LAST:event_radioNotClosedActionPerformed

    private void mnuBagReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBagReportActionPerformed
        BugReport br = new BugReport();
        br.setVisible(true);
    }//GEN-LAST:event_mnuBagReportActionPerformed

    private void mnuLycenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLycenseActionPerformed
        Lycense lc = new Lycense();
        lc.setVisible(true);
    }//GEN-LAST:event_mnuLycenseActionPerformed

    private void radioAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAllActionPerformed
        sqlFlag = 1;
    }//GEN-LAST:event_radioAllActionPerformed

    private void radioNoGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoGreenActionPerformed
        sqlFlag = 2;
    }//GEN-LAST:event_radioNoGreenActionPerformed

    private void radioNotApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNotApprovedActionPerformed
        sqlFlag = 4;
    }//GEN-LAST:event_radioNotApprovedActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //подтверждение выхода из программы
        Object[] options = {"Да", "Нет"};
        int status = JOptionPane.showOptionDialog(evt.getWindow(),
                "Вы действительно хотите выйти из программы?", "Закрыть программу",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);
        if (status == 0) {
            evt.getWindow().setVisible(false);
            System.exit(0);
        }
        throw new UnsupportedOperationException("Not supported method in formWindowClosing");
    }//GEN-LAST:event_formWindowClosing

    private void mniClassificatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniClassificatorActionPerformed
        ClassificatorSubcategoryUI classificatorUI;
        classificatorUI = new ClassificatorSubcategoryUI();
        classificatorUI.setVisible(true);
    }//GEN-LAST:event_mniClassificatorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Analysis analysis = new Analysis();
        analysis.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        StatisticGeneralRisk statGeneral = new StatisticGeneralRisk();
        statGeneral.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        StatisticTrendHighRisk statHighTrend = new StatisticTrendHighRisk();
        statHighTrend.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        StatisticTrendLowRisk statLowTrend = new StatisticTrendLowRisk();
        statLowTrend.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        StatisticTrendMidRisk statMidTrend = new StatisticTrendMidRisk();
        statMidTrend.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        StatisticMoreOften statMoreOften = new StatisticMoreOften();
        statMoreOften.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        StatisticMonthly onMonthly = new StatisticMonthly();
        onMonthly.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        StatisticCaptainPF captainPF = new StatisticCaptainPF();
        captainPF.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        StatisticFirstOfficerPF firstOfficerPF = new StatisticFirstOfficerPF();
        firstOfficerPF.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        StatisticCaptainCrew captainCrew = new StatisticCaptainCrew();
        captainCrew.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mnuIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIndividualActionPerformed
        StatisticIndividual statIndividual = new StatisticIndividual();
        statIndividual.setVisible(true);
    }//GEN-LAST:event_mnuIndividualActionPerformed

    private void mnuFilterPilotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFilterPilotActionPerformed
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        FilterPilot filterPilot = new FilterPilot();
        int locX = (screenSize.width - 200) / 2;
        int locY = (screenSize.height - 150) / 2;
        filterPilot.setLocation(locX, locY);
        filterPilot.setVisible(true);
    }//GEN-LAST:event_mnuFilterPilotActionPerformed

    private void mnuFilterEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFilterEventActionPerformed
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        FilterEvent filterEvent = new FilterEvent();
        int locX = (screenSize.width - 200) / 2;
        int locY = (screenSize.height - 150) / 2;
        filterEvent.setLocation(locX, locY);
        filterEvent.setVisible(true);
    }//GEN-LAST:event_mnuFilterEventActionPerformed

    private void mnuFilterDepartureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFilterDepartureActionPerformed
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        FilterDeparture filterDeparture = new FilterDeparture();
        int locX = (screenSize.width - 200) / 2;
        int locY = (screenSize.height - 150) / 2;
        filterDeparture.setLocation(locX, locY);
        filterDeparture.setVisible(true);
    }//GEN-LAST:event_mnuFilterDepartureActionPerformed

    private void mnuFilterArrivalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFilterArrivalActionPerformed
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        FilterArrival filterArrival = new FilterArrival();
        int locX = (screenSize.width - 200) / 2;
        int locY = (screenSize.height - 150) / 2;
        filterArrival.setLocation(locX, locY);
        filterArrival.setVisible(true);
    }//GEN-LAST:event_mnuFilterArrivalActionPerformed

    private void mnuFilterACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFilterACActionPerformed
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        FilterTailNumber filterTail = new FilterTailNumber();
        int locX = (screenSize.width - 200) / 2;
        int locY = (screenSize.height - 150) / 2;
        filterTail.setLocation(locX, locY);
        filterTail.setVisible(true);
    }//GEN-LAST:event_mnuFilterACActionPerformed

    private void mnuTop10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuTop10ActionPerformed
        StatisticPilotsInEvents top10 = new StatisticPilotsInEvents();
        top10.setVisible(true);
    }//GEN-LAST:event_mnuTop10ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRetrieve;
    private javax.swing.JButton bSelect;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mniAdminUsers;
    private javax.swing.JMenuItem mniChebrov;
    private javax.swing.JMenuItem mniClassic;
    private javax.swing.JMenuItem mniClassificator;
    private javax.swing.JMenuItem mniCommanderLO;
    private javax.swing.JMenu mniCommanderName;
    private javax.swing.JMenuItem mniFont12;
    private javax.swing.JMenuItem mniFont14;
    private javax.swing.JMenuItem mniFont16;
    private javax.swing.JMenuItem mniFont18;
    private javax.swing.JMenuItem mniMotif;
    private javax.swing.JMenuItem mniNimbus;
    private javax.swing.JMenuItem mniTab0;
    private javax.swing.JMenuItem mniTab1;
    private javax.swing.JMenuItem mniTab2;
    private javax.swing.JMenuItem mniWindows;
    private javax.swing.JMenuItem mniZamCom;
    private javax.swing.JMenuItem mniZubkov;
    private javax.swing.JMenuItem mnuBagReport;
    private javax.swing.JMenuItem mnuFilterAC;
    private javax.swing.JMenuItem mnuFilterArrival;
    private javax.swing.JMenuItem mnuFilterDeparture;
    private javax.swing.JMenuItem mnuFilterEvent;
    private javax.swing.JMenuItem mnuFilterPilot;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuIndividual;
    private javax.swing.JMenuItem mnuLycense;
    private javax.swing.JMenuItem mnuTop10;
    private javax.swing.JRadioButton radioAll;
    private javax.swing.JRadioButton radioNoGreen;
    private javax.swing.JRadioButton radioNotApproved;
    private javax.swing.JRadioButton radioNotClosed;
    private javax.swing.JTextArea txtConsole;
    // End of variables declaration//GEN-END:variables
}
