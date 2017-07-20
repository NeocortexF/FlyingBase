package secure;

import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Welcome extends JFrame {

    public static String str = null;
    public static int sqlFlag = 1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRetrieve;
    private javax.swing.JButton bSelect;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mniClassic;
    private javax.swing.JMenuItem mniCommander;
    private javax.swing.JMenu mniCommanderName;
    private javax.swing.JMenuItem mniFont12;
    private javax.swing.JMenuItem mniFont14;
    private javax.swing.JMenuItem mniFont16;
    private javax.swing.JMenuItem mniFont18;
    private javax.swing.JMenuItem mniMotif;
    private javax.swing.JMenuItem mniNimbus;
    private javax.swing.JMenuItem mniWindows;
    private javax.swing.JMenuItem mniZam;
    private javax.swing.JMenuItem mnuBagReport;
    private javax.swing.JMenuItem mnuLycense;
    private javax.swing.JRadioButton radioAll;
    private javax.swing.JRadioButton radioNoGreen;
    private javax.swing.JRadioButton radioNotApproved;
    private javax.swing.JRadioButton radioNotClosed;
    public Welcome() {

        initComponents();
        retrieve(1);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

    private void retrieve(int sqlFlag) {
        //sqlFlag - один из четырех фильтров на панеле. 1 - показать все записи
        //второй параметр - номер авиаэскадрильи
        DefaultTableModel dm = new DBUpdater().getData(sqlFlag, 12);
        jTable1.setModel(dm);

        ColorRenderer colorRenderer = new ColorRenderer();
        colorRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(45);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(15);
        jTable1.getColumnModel().getColumn(11).setCellRenderer(colorRenderer);
        jTable1.getColumnModel().getColumn(12).setPreferredWidth(30);
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
        bRetrieve = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable() {
            @Override
            public Class getColumnClass(int column) {     // наверное зджесь номер ряда
                return getValueAt(0, column).getClass();
            }
        };
        bSelect = new javax.swing.JButton();
        radioAll = new javax.swing.JRadioButton();
        radioNoGreen = new javax.swing.JRadioButton();
        radioNotApproved = new javax.swing.JRadioButton();
        radioNotClosed = new javax.swing.JRadioButton();
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
        mniCommander = new javax.swing.JMenuItem();
        mniZam = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuLycense = new javax.swing.JMenuItem();
        mnuBagReport = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Flying Base: AirSquadron №12");
        setBackground(new java.awt.Color(102, 102, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bRetrieve.setFont(new java.awt.Font("Tahoma", 0, 14));
        bRetrieve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh-icon.png"))); // NOI18N
        bRetrieve.setText("Обновить");
        bRetrieve.setToolTipText("Обновить данные. Так же можно использовать нажатие клавиши F5 на клавиатуре. Дополнительно можно выбрать фильтр тех данных, которые вы хотите получить.");
        bRetrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetrieveActionPerformed(evt);
            }
        });

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "№", "Дата полета", "Рейс", "null", "А/п посадки", "Борт. номер", "КВС", "ВП", "Риск", "Срок КД", "КД одобр", "Закрыт"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false, false
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
        jTable1.getColumnModel().getColumn(8).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(9).setResizable(false);
        jTable1.getColumnModel().getColumn(9).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(10).setResizable(false);
        jTable1.getColumnModel().getColumn(10).setPreferredWidth(75);
        jTable1.getColumnModel().getColumn(10).setCellRenderer(new MyRenderer());
        jTable1.getColumnModel().getColumn(11).setResizable(false);
        jTable1.getColumnModel().getColumn(11).setPreferredWidth(75);

        bSelect.setFont(new java.awt.Font("Tahoma", 0, 14));
        bSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/choose.png"))); // NOI18N
        bSelect.setText("Выбрать");
        bSelect.setToolTipText("Выбрать событие для детального отображения");
        bSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioAll);
        radioAll.setFont(new java.awt.Font("Tahoma", 0, 14));
        radioAll.setSelected(true);
        radioAll.setText("Показать все");
        radioAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAllActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioNoGreen);
        radioNoGreen.setFont(new java.awt.Font("Tahoma", 0, 14));
        radioNoGreen.setText("Без низкого риска");
        radioNoGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoGreenActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioNotApproved);
        radioNotApproved.setFont(new java.awt.Font("Tahoma", 0, 14));
        radioNotApproved.setText("Не одобренные");
        radioNotApproved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNotApprovedActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioNotClosed);
        radioNotClosed.setFont(new java.awt.Font("Tahoma", 0, 14));
        radioNotClosed.setText("Не закрытые");
        radioNotClosed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNotClosedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1092, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(radioAll)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radioNoGreen)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radioNotApproved)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radioNotClosed)
                                                .addGap(18, 18, 18)
                                                .addComponent(bRetrieve)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bSelect)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bSelect)
                                        .addComponent(bRetrieve)
                                        .addComponent(radioNotClosed)
                                        .addComponent(radioNotApproved)
                                        .addComponent(radioNoGreen)
                                        .addComponent(radioAll))
                                .addContainerGap())
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

        mniCommander.setText("ФИО Командира АЭ");
        mniCommander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCommanderActionPerformed(evt);
            }
        });
        mniCommanderName.add(mniCommander);

        mniZam.setText("ФИО Зам. командира АЭ");
        mniZam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniZamActionPerformed(evt);
            }
        });
        mniCommanderName.add(mniZam);

        jMenuBar1.add(mniCommanderName);

        jMenu4.setText("?");

        mnuLycense.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/copyright.png"))); // NOI18N
        mnuLycense.setText("Лицензионное соглашение");
        mnuLycense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLycenseActionPerformed(evt);
            }
        });
        jMenu4.add(mnuLycense);

        mnuBagReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bugerror.png"))); // NOI18N
        mnuBagReport.setText("Сообщить об ошибке");
        mnuBagReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBagReportActionPerformed(evt);
            }
        });
        jMenu4.add(mnuBagReport);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

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

    // Look and feel menu
    private void mniClassicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniClassicActionPerformed
    /* Set the Nimbus look and feel */
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
        // Пункт меню UI Nimbus
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
        if (evt.getClickCount() == 2) {
            if (!jTable1.getValueAt(jTable1.getSelectedRow(), 0).equals("")) { //

                str = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Для детального просмотра, пожалуйста, выберите доступное событие из списка",
                        "Вы не выбрали событие!",
                        JOptionPane.ERROR_MESSAGE);
            }
            WorkingWindow ww = new WorkingWindow(str);
            ww.setVisible(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void bRetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetrieveActionPerformed
        // кнопка извлечь данные из базы
        retrieve(sqlFlag);
    }//GEN-LAST:event_bRetrieveActionPerformed

    private void bSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectActionPerformed
        // кнопка выбрать сообщение для работы с ним
        if (!jTable1.getValueAt(jTable1.getSelectedRow(), 0).equals("")) {
            str = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для детального просмотра, пожалуйста, выберите доступное событие из списка",
                    "Вы не выбрали событие!",
                    JOptionPane.ERROR_MESSAGE);
        }
        WorkingWindow ww = new WorkingWindow(str);
        ww.setVisible(true);
    }//GEN-LAST:event_bSelectActionPerformed

    private void mniCommanderNameActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void mniCommanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCommanderActionPerformed
// Меню изменить имя командира авиаэскадрильи
        WindowMenuCom wmenu = new WindowMenuCom();
        wmenu.setVisible(true);
    }//GEN-LAST:event_mniCommanderActionPerformed

    private void mniZamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniZamActionPerformed
//  Меню изменить имя заместителя командира авиаэскадрильи
        WindowMenuZam wzam = new WindowMenuZam();
        wzam.setVisible(true);
    }//GEN-LAST:event_mniZamActionPerformed

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

    private void mnuLycenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLycenseActionPerformed
        Lycense lc = new Lycense();
        lc.setVisible(true);
    }//GEN-LAST:event_mnuLycenseActionPerformed

    private void mnuBagReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBagReportActionPerformed
        BugReport br = new BugReport();
        br.setVisible(true);
    }//GEN-LAST:event_mnuBagReportActionPerformed

    private void radioAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAllActionPerformed
        sqlFlag = 1;
    }//GEN-LAST:event_radioAllActionPerformed

    private void radioNoGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoGreenActionPerformed
        sqlFlag = 2;
    }//GEN-LAST:event_radioNoGreenActionPerformed

    private void radioNotApprovedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNotApprovedActionPerformed
        sqlFlag = 4;
    }//GEN-LAST:event_radioNotApprovedActionPerformed

    private void radioNotClosedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNotClosedActionPerformed
        sqlFlag = 3;
    }//GEN-LAST:event_radioNotClosedActionPerformed

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
        throw new UnsupportedOperationException("Not supported shit");
    }//GEN-LAST:event_formWindowClosing
    // End of variables declaration//GEN-END:variables
}
