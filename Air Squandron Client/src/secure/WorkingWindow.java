package secure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkingWindow extends javax.swing.JFrame {

    private String folderName = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFiles;
    private javax.swing.JButton bSend;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JRadioButton rClear;
    private javax.swing.JRadioButton rCommander;
    private javax.swing.JRadioButton rZam;
    private javax.swing.JTable tableEvent1;
    private javax.swing.JTable tableEvent2;
    private javax.swing.JTable tableEvent3;
    private javax.swing.JTable tableEvent4;
    private javax.swing.JTable tableMainInfo;
    private javax.swing.JTextField tfNameAE;
    private javax.swing.JEditorPane txtEditAnalysis;
    private javax.swing.JEditorPane txtEditCorAct;
    private javax.swing.JTextPane txtFeedbackGlazkov;
    private javax.swing.JTextPane txtPrim;
    public WorkingWindow(String str) {
        folderName = str;
        initComponents();
        retrieve(str);
        tableMainInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        txtEditAnalysis.getDocument().addDocumentListener(new MyDocumentListener());
        txtEditCorAct.getDocument().addDocumentListener(new MyDocumentListener());
        tfNameAE.getDocument().addDocumentListener(new MyDocumentListener());
        MyDocumentListener.setDocumentChanged(false);
    }

    private void retrieve(String str) {
        DefaultTableModel dmWW = new DBUpdaterWorkingWindow().getData(str);
        DefaultTableModel dmEv1 = new DBUpdaterEvent1().getData(str);
        DefaultTableModel dmEv2 = new DBUpdaterEvent2().getData(str);
        DefaultTableModel dmEv3 = new DBUpdaterEvent3().getData(str);
        DefaultTableModel dmEv4 = new DBUpdaterEvent4().getData(str);

        Object[] lowerData = new DBUpdaterWorkingWindow().getLowerData(str);
        if (lowerData[0] != null) {
            String prim = lowerData[0].toString();
            txtPrim.setText(prim);
        }
        if (lowerData[1] != null) {
            String commander = lowerData[1].toString();
            tfNameAE.setText(commander);
        }
        if (lowerData[2] != null) {
            String corAct = lowerData[2].toString();
            txtEditCorAct.setText(corAct);
        }
        if (lowerData[3] != null) {
            String analysis = lowerData[3].toString();
            txtEditAnalysis.setText(analysis);
        }
        if (lowerData[4] != null) {
            String glaz = lowerData[4].toString();
            txtFeedbackGlazkov.setText(glaz);
        }

        tableMainInfo.setModel(dmWW);
        tableMainInfo.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableMainInfo.getColumnModel().getColumn(0).setMaxWidth(90);
        tableMainInfo.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableMainInfo.getColumnModel().getColumn(1).setMaxWidth(120);
        tableMainInfo.getColumnModel().getColumn(2).setPreferredWidth(80);
        tableMainInfo.getColumnModel().getColumn(2).setMaxWidth(90);
        tableMainInfo.getColumnModel().getColumn(3).setPreferredWidth(80);
        tableMainInfo.getColumnModel().getColumn(3).setMaxWidth(90);
        tableMainInfo.getColumnModel().getColumn(4).setPreferredWidth(80);
        tableMainInfo.getColumnModel().getColumn(4).setMaxWidth(90);
        tableMainInfo.getColumnModel().getColumn(5).setPreferredWidth(120);
        tableMainInfo.getColumnModel().getColumn(5).setMaxWidth(150);
        tableMainInfo.getColumnModel().getColumn(6).setPreferredWidth(70);
        tableMainInfo.getColumnModel().getColumn(6).setMaxWidth(80);
        tableMainInfo.getColumnModel().getColumn(7).setPreferredWidth(70);
        tableMainInfo.getColumnModel().getColumn(7).setMaxWidth(80);
        tableMainInfo.getColumnModel().getColumn(8).setPreferredWidth(70);
        tableMainInfo.getColumnModel().getColumn(8).setMaxWidth(80);
        tableMainInfo.getColumnModel().getColumn(10).setPreferredWidth(100);
        tableMainInfo.getColumnModel().getColumn(10).setMaxWidth(120);
        tableMainInfo.getColumnModel().getColumn(11).setPreferredWidth(90);
        tableMainInfo.getColumnModel().getColumn(11).setMaxWidth(100);
        tableMainInfo.getColumnModel().getColumn(12).setPreferredWidth(90);
        tableMainInfo.getColumnModel().getColumn(12).setMaxWidth(100);

        tableEvent1.setModel(dmEv1);
        tableEvent1.getColumnModel().getColumn(0).setPreferredWidth(120);
        tableEvent1.getColumnModel().getColumn(0).setMaxWidth(150);
        tableEvent1.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableEvent1.getColumnModel().getColumn(2).setMaxWidth(350);
        tableEvent1.getColumnModel().getColumn(3).setPreferredWidth(77);
        tableEvent1.getColumnModel().getColumn(3).setMaxWidth(110);

        tableEvent2.setModel(dmEv2);
        tableEvent2.getColumnModel().getColumn(0).setPreferredWidth(120);
        tableEvent2.getColumnModel().getColumn(0).setMaxWidth(150);
        tableEvent2.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableEvent2.getColumnModel().getColumn(2).setMaxWidth(350);
        tableEvent2.getColumnModel().getColumn(3).setPreferredWidth(77);
        tableEvent2.getColumnModel().getColumn(3).setMaxWidth(110);

        tableEvent3.setModel(dmEv3);
        tableEvent3.getColumnModel().getColumn(0).setPreferredWidth(120);
        tableEvent3.getColumnModel().getColumn(0).setMaxWidth(150);
        tableEvent3.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableEvent3.getColumnModel().getColumn(2).setMaxWidth(350);
        tableEvent3.getColumnModel().getColumn(3).setPreferredWidth(77);
        tableEvent3.getColumnModel().getColumn(3).setMaxWidth(110);

        tableEvent4.setModel(dmEv4);
        tableEvent4.getColumnModel().getColumn(0).setPreferredWidth(120);
        tableEvent4.getColumnModel().getColumn(0).setMaxWidth(150);
        tableEvent4.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableEvent4.getColumnModel().getColumn(2).setMaxWidth(350);
        tableEvent4.getColumnModel().getColumn(3).setPreferredWidth(77);
        tableEvent4.getColumnModel().getColumn(3).setMaxWidth(110);
    }

    private String getNames(int key, String escadra) {
        //метод возвращает имя КАЭ, ЗКАЭ, ПИ по ключу 1,2,3 соотвественно
        String name = null;


        String sql = "";

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;

        switch (key) {
            case 1:
                sql = "SELECT * FROM " + escadra + " WHERE id = 1";
                break;
            case 2:
                sql = "SELECT * FROM " + escadra + " WHERE id = 2";
                break;
            case 3:
                sql = "SELECT * FROM " + escadra + " WHERE id = 3";
                break;
        }
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                name = rs.getString(2);
                return name;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
            ;
        }
        return name;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel3 = new javax.swing.JPanel();
        bSend = new javax.swing.JButton();
        tfNameAE = new javax.swing.JTextField();
        rZam = new javax.swing.JRadioButton();
        bFiles = new javax.swing.JButton();
        rCommander = new javax.swing.JRadioButton();
        rClear = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtEditAnalysis = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEditCorAct = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableMainInfo = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {     // наверное зджесь номер ряда
                return getValueAt(0, column).getClass();
            }
        };
        jScrollPane4 = new javax.swing.JScrollPane();
        tableEvent4 = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {     // наверное зджесь номер ряда
                return getValueAt(0, column).getClass();
            }
        };
        jScrollPane5 = new javax.swing.JScrollPane();
        tableEvent1 = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {     // наверное зджесь номер ряда
                return getValueAt(0, column).getClass();
            }
        };
        jScrollPane6 = new javax.swing.JScrollPane();
        tableEvent2 = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {     // наверное зджесь номер ряда
                return getValueAt(0, column).getClass();
            }
        };
        jScrollPane7 = new javax.swing.JScrollPane();
        tableEvent3 = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {     // наверное зджесь номер ряда
                return getValueAt(0, column).getClass();
            }
        };
        jPanel6 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtPrim = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtFeedbackGlazkov = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: AirSquadron");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bSend.setFont(new java.awt.Font("Tahoma", 0, 14));
        bSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paper-airplane-icon.png"))); // NOI18N
        bSend.setText("Отправить ответ");
        bSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSendActionPerformed(evt);
            }
        });

        tfNameAE.setFont(new java.awt.Font("Tahoma", 0, 14));

        buttonGroup1.add(rZam);
        rZam.setFont(new java.awt.Font("Tahoma", 1, 14));
        rZam.setText("Зам. командира АЭ");
        rZam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rZamActionPerformed(evt);
            }
        });

        bFiles.setFont(new java.awt.Font("Tahoma", 0, 14));
        bFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/files-folders.png"))); // NOI18N
        bFiles.setText("Открыть материалы");
        bFiles.setToolTipText("Открывает или создает папку на сервере для хранения материалов события");
        bFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFilesActionPerformed(evt);
            }
        });

        buttonGroup1.add(rCommander);
        rCommander.setFont(new java.awt.Font("Tahoma", 1, 14));
        rCommander.setText("Командир АЭ");
        rCommander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCommanderActionPerformed(evt);
            }
        });

        buttonGroup1.add(rClear);
        rClear.setFont(new java.awt.Font("Tahoma", 0, 14));
        rClear.setText("Лицо замещающее");
        rClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bFiles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                                .addComponent(rClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rZam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfNameAE, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(rCommander)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bSend)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tfNameAE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bFiles)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(bSend)
                                                .addComponent(rCommander)
                                                .addComponent(rZam)
                                                .addComponent(rClear)))
                                .addContainerGap())
        );

        txtEditAnalysis.setFont(new java.awt.Font("Tahoma", 0, 14));
        jScrollPane1.setViewportView(txtEditAnalysis);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setText("Анализ событий полета");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel2.setText("Корректирующие действия");

        txtEditCorAct.setFont(new java.awt.Font("Tahoma", 0, 14));
        jScrollPane2.setViewportView(txtEditCorAct);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableMainInfo.setFont(new java.awt.Font("Tahoma", 0, 14));
        tableMainInfo.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "№", "Дата полета", "Рейс", "Вылет", "Прибытие", "Борт. номер", "КВС ID", "ВП ID", "PF", "Необходимые мероприятия", "Срок КД", "КД одобр", "Закрыто"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        tableMainInfo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tableMainInfo.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableMainInfo);
        tableMainInfo.getColumnModel().getColumn(0).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(0).setPreferredWidth(40);
        tableMainInfo.getColumnModel().getColumn(1).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(1).setPreferredWidth(80);
        tableMainInfo.getColumnModel().getColumn(2).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(2).setPreferredWidth(75);
        tableMainInfo.getColumnModel().getColumn(3).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(3).setPreferredWidth(75);
        tableMainInfo.getColumnModel().getColumn(4).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(4).setPreferredWidth(75);
        tableMainInfo.getColumnModel().getColumn(5).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(5).setPreferredWidth(110);
        tableMainInfo.getColumnModel().getColumn(6).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(6).setPreferredWidth(45);
        tableMainInfo.getColumnModel().getColumn(7).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(7).setPreferredWidth(45);
        tableMainInfo.getColumnModel().getColumn(8).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(8).setPreferredWidth(45);
        tableMainInfo.getColumnModel().getColumn(9).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(9).setPreferredWidth(150);
        tableMainInfo.getColumnModel().getColumn(10).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(10).setPreferredWidth(80);
        tableMainInfo.getColumnModel().getColumn(11).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(11).setPreferredWidth(45);
        tableMainInfo.getColumnModel().getColumn(12).setResizable(false);
        tableMainInfo.getColumnModel().getColumn(12).setPreferredWidth(45);

        tableEvent4.setFont(new java.awt.Font("Tahoma", 0, 14));
        tableEvent4.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "AirFASE Evenet 4", "Классификация события", "Предварительная оценка риска", "Индекс"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableEvent4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tableEvent4);
        tableEvent4.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableEvent4.getColumnModel().getColumn(0).setMaxWidth(150);
        tableEvent4.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableEvent4.getColumnModel().getColumn(2).setMaxWidth(350);
        tableEvent4.getColumnModel().getColumn(3).setPreferredWidth(77);
        tableEvent4.getColumnModel().getColumn(3).setMaxWidth(77);

        tableEvent1.setFont(new java.awt.Font("Tahoma", 0, 14));
        tableEvent1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "AirFASE Event 1", "Классификация события", "Предварительная оценка риска", "Индекс"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableEvent1.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableEvent1);
        tableEvent1.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableEvent1.getColumnModel().getColumn(0).setMaxWidth(150);
        tableEvent1.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableEvent1.getColumnModel().getColumn(2).setMaxWidth(350);
        tableEvent1.getColumnModel().getColumn(3).setPreferredWidth(77);
        tableEvent1.getColumnModel().getColumn(3).setMaxWidth(100);

        tableEvent2.setFont(new java.awt.Font("Tahoma", 0, 14));
        tableEvent2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "AirFASE Event 2", "Классификация события", "Предварительная оценка риска", "Индекс"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableEvent2.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tableEvent2);
        tableEvent2.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableEvent2.getColumnModel().getColumn(0).setMaxWidth(150);
        tableEvent2.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableEvent2.getColumnModel().getColumn(2).setMaxWidth(350);
        tableEvent2.getColumnModel().getColumn(3).setPreferredWidth(77);
        tableEvent2.getColumnModel().getColumn(3).setMaxWidth(77);

        tableEvent3.setFont(new java.awt.Font("Tahoma", 0, 14));
        tableEvent3.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "AirFASE Event 3", "Классификация события", "Предварительная оценка риска", "Индекс"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableEvent3.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tableEvent3);
        tableEvent3.getColumnModel().getColumn(0).setPreferredWidth(150);
        tableEvent3.getColumnModel().getColumn(0).setMaxWidth(150);
        tableEvent3.getColumnModel().getColumn(2).setPreferredWidth(350);
        tableEvent3.getColumnModel().getColumn(2).setMaxWidth(350);
        tableEvent3.getColumnModel().getColumn(3).setPreferredWidth(77);
        tableEvent3.getColumnModel().getColumn(3).setMaxWidth(77);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtPrim.setEditable(false);
        txtPrim.setFont(new java.awt.Font("Tahoma", 0, 14));
        jScrollPane8.setViewportView(txtPrim);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel5.setText("Примечания");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtFeedbackGlazkov.setEditable(false);
        txtFeedbackGlazkov.setFont(new java.awt.Font("Tahoma", 0, 14));
        jScrollPane9.setViewportView(txtFeedbackGlazkov);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel6.setText("Обратная связь из летного отряда");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6))
                                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSendActionPerformed
        // Кнопка отправить ответ
        if ((tfNameAE.getText().length() == 0 || tfNameAE.getText().equals("") || tfNameAE.getText().equals(" "))) {
            JOptionPane.showMessageDialog(null, "Поле ответственное лицо не может быть пустым!");
        } else {
            if (new DBUpdaterWorkingWindow().update(tableMainInfo.getValueAt(0, 0).toString(), txtEditAnalysis.getText(), txtEditCorAct.getText(), tfNameAE.getText())) {
                JOptionPane.showMessageDialog(null, "Информация была отправленна в летный отряд.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Не получилось отправить. Проверьте доступ к базе данных.");
            }
        }

    }//GEN-LAST:event_bSendActionPerformed

    private void rClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rClearActionPerformed
// радио кнопка очистить
        tfNameAE.setText("");
    }//GEN-LAST:event_rClearActionPerformed

    //  ----------------------------------------------------------------------------- номер экспдрильи в продакшн
    private void rCommanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCommanderActionPerformed
// радио кнопка командир АЭ
        String name = getNames(1, Escadras.escadra12.toString());
        tfNameAE.setText("КАЭ " + name);
    }//GEN-LAST:event_rCommanderActionPerformed

    private void rZamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rZamActionPerformed
        // радио кнопка зам командир АЭ
        String name = getNames(2, Escadras.escadra12.toString());
        tfNameAE.setText("ЗКАЭ " + name);
    }//GEN-LAST:event_rZamActionPerformed

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
            } else {
                setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                evt.getWindow().setVisible(true);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void bFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFilesActionPerformed

        String fileFolder = Main.netFolderPath + folderName;

        File f = new File(fileFolder);

        if (f.exists()) {
            try {
                Runtime.getRuntime().exec("explorer " + fileFolder);
            } catch (IOException ex) {
                Logger.getLogger(WorkingWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            new File(fileFolder).mkdir();
            try {
                Runtime.getRuntime().exec("explorer " + fileFolder);
            } catch (IOException ex) {
                Logger.getLogger(WorkingWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bFilesActionPerformed
    // End of variables declaration//GEN-END:variables
}
