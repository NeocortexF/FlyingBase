package secure;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Welcome extends JFrame {

    public static String str = "";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCreate;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bRetrieve;
    private javax.swing.JButton bSelect;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mniAdminUsers;
    private javax.swing.JMenuItem mniClassic;
    private javax.swing.JMenuItem mniCommander;
    private javax.swing.JMenu mniCommanderName;
    private javax.swing.JMenuItem mniFleet;
    private javax.swing.JMenuItem mniFont12;
    private javax.swing.JMenuItem mniFont14;
    private javax.swing.JMenuItem mniFont16;
    private javax.swing.JMenuItem mniFont18;
    private javax.swing.JMenuItem mniMotif;
    private javax.swing.JMenuItem mniNimbus;
    private javax.swing.JMenuItem mniWindows;
    private javax.swing.JMenuItem mnuAirportEdit;
    private javax.swing.JMenuItem mnuBagReport;
    private javax.swing.JMenu mnuHelp;
    private javax.swing.JMenuItem mnuLycense;

    public Welcome() {
        initComponents();
        retrieve();
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

    private void retrieve() {
        DefaultTableModel dm = new DBUpdater().getData();
        jTable1.setModel(dm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jProgressBar1 = new javax.swing.JProgressBar();
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
        bDelete = new javax.swing.JButton();
        bCreate = new javax.swing.JButton();
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
        jMenu4 = new javax.swing.JMenu();
        mniAdminUsers = new javax.swing.JMenuItem();
        mniFleet = new javax.swing.JMenuItem();
        mnuAirportEdit = new javax.swing.JMenuItem();
        mnuHelp = new javax.swing.JMenu();
        mnuLycense = new javax.swing.JMenuItem();
        mnuBagReport = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Flying Base: Flight Data Manager");
        setBackground(new java.awt.Color(102, 102, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1226, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bRetrieve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh-icon.png"))); // NOI18N
        bRetrieve.setText("Обновить данные");
        bRetrieve.setToolTipText("Обновить данные можно нажатием клавиши F5");
        bRetrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetrieveActionPerformed(evt);
            }
        });

        bSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        bSelect.setText("Редактировать");
        bSelect.setToolTipText("Выбрать событие для детального отображения и возможности редактирования");
        bSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectActionPerformed(evt);
            }
        });

        bDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        bDelete.setText("Удалить");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/document-new.png"))); // NOI18N
        bCreate.setText("Создать");
        bCreate.setToolTipText("Создать новую запись о летном событии в базе данных");
        bCreate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bRetrieve)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bSelect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 748, Short.MAX_VALUE)
                                .addComponent(bCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bDelete)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bCreate)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(bRetrieve)
                                                .addComponent(bSelect)
                                                .addComponent(bDelete)))
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

        mniCommander.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/person_10.png"))); // NOI18N
        mniCommander.setText("ФИО сотрудников ГОПИ");
        mniCommander.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCommanderActionPerformed(evt);
            }
        });
        mniCommanderName.add(mniCommander);

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

        mniFleet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sendToPilots.png"))); // NOI18N
        mniFleet.setText("Флот");
        mniFleet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFleetActionPerformed(evt);
            }
        });
        jMenu4.add(mniFleet);

        mnuAirportEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dictionary.png"))); // NOI18N
        mnuAirportEdit.setText("Справочник аэропортов");
        jMenu4.add(mnuAirportEdit);

        jMenuBar1.add(jMenu4);

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
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            WorkingWindow2 ww;
            try {
                ww = new WorkingWindow2(str);
                ww.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void bRetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetrieveActionPerformed
        // кнопка извлечь данные из базы
        retrieve();
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
        WorkingWindow2 ww;
        try {
            ww = new WorkingWindow2(str);
            ww.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bSelectActionPerformed

    private void mniCommanderNameActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void mniCommanderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCommanderActionPerformed
        // Меню изменить перечень сотрудников ГОПИ
        GopiPerson gopiPerson = new GopiPerson();
        gopiPerson.setVisible(true);
    }//GEN-LAST:event_mniCommanderActionPerformed

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

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // кнопка удалить
        if (!jTable1.getValueAt(jTable1.getSelectedRow(), 0).equals("")) { //
            str = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            //диалог на удаление
            Object[] options = {"Удалить", "Отмена"};
            int n = JOptionPane.showOptionDialog(null, "Вы действительно собираетесь удалить событие  " + str + "?", "Предупреждение!", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n == JOptionPane.YES_OPTION) {
                Boolean delete = new DBUpdater().delete(str);
                JOptionPane.showMessageDialog(null,
                        "Событие номер " + str + " было успешно удалено из базы данных!",
                        "Удаление",
                        JOptionPane.INFORMATION_MESSAGE);
                retrieve();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Для удаления, пожалуйста, выберите доступное событие из списка",
                    "Вы не выбрали событие!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void mniAdminUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAdminUsersActionPerformed
        // панель администрирования юзер - пароль
        AdminPanel apanel = new AdminPanel();
        apanel.setVisible(true);
    }//GEN-LAST:event_mniAdminUsersActionPerformed

    private void mnuLycenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLycenseActionPerformed
        Lycense lc = new Lycense();
        lc.setVisible(true);
    }//GEN-LAST:event_mnuLycenseActionPerformed

    private void mnuBagReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBagReportActionPerformed
        BugReport br = new BugReport();
        br.setVisible(true);
    }//GEN-LAST:event_mnuBagReportActionPerformed

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

    private void mniFleetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFleetActionPerformed
        FleetPanel fPanel = new FleetPanel();
        fPanel.setVisible(true);
    }//GEN-LAST:event_mniFleetActionPerformed

    private void bCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCreateActionPerformed
        // кнопка создать новое сообщение
        WorkingWindowCreate wwc;
        try {
            wwc = new WorkingWindowCreate();
            wwc.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bCreateActionPerformed
    // End of variables declaration//GEN-END:variables
}
