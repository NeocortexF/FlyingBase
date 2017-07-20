package secure;

import java.awt.Color;
import java.awt.Toolkit;

public class MatrixWindow extends javax.swing.JFrame {

    Color greenMatrix = new Color(34, 177, 76);
    Color yellowMatrix = new Color(255, 242, 0);
    Color orangeMatrix = new Color(255, 127, 39);
    Color redMatrix = new Color(237, 28, 36);

    public MatrixWindow() {
        initComponents();
    }

    //взаимодействие между окнами
    //создаем ссылку на родителя
    private WorkingWindow3 parent;

    public void setParent(WorkingWindow3 ww3) {
        this.parent = ww3;
    }

    public WorkingWindow3 getParent() {
        return this.parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        b2 = new javax.swing.JButton();
        b101 = new javax.swing.JButton();
        b500 = new javax.swing.JButton();
        b10 = new javax.swing.JButton();
        b102 = new javax.swing.JButton();
        b2500 = new javax.swing.JButton();
        b50 = new javax.swing.JButton();
        b502 = new javax.swing.JButton();
        b100 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b21 = new javax.swing.JButton();
        b20 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: Risk Assessment Matrix");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        b2.setBackground(new java.awt.Color(51, 204, 0));
        b2.setFont(new java.awt.Font("Tahoma", 1, 16));
        b2.setText("2");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b101.setBackground(new java.awt.Color(255, 153, 0));
        b101.setFont(new java.awt.Font("Tahoma", 1, 16));
        b101.setText("101");
        b101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b101ActionPerformed(evt);
            }
        });

        b500.setBackground(new java.awt.Color(255, 0, 0));
        b500.setFont(new java.awt.Font("Tahoma", 1, 16));
        b500.setText("500");
        b500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b500ActionPerformed(evt);
            }
        });

        b10.setBackground(new java.awt.Color(51, 204, 0));
        b10.setFont(new java.awt.Font("Tahoma", 1, 16));
        b10.setText("10");
        b10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b10ActionPerformed(evt);
            }
        });

        b102.setBackground(new java.awt.Color(255, 153, 0));
        b102.setFont(new java.awt.Font("Tahoma", 1, 16));
        b102.setText("102");
        b102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b102ActionPerformed(evt);
            }
        });

        b2500.setBackground(new java.awt.Color(255, 0, 0));
        b2500.setFont(new java.awt.Font("Tahoma", 1, 16));
        b2500.setText("2500");
        b2500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2500ActionPerformed(evt);
            }
        });

        b50.setBackground(new java.awt.Color(255, 255, 0));
        b50.setFont(new java.awt.Font("Tahoma", 1, 16));
        b50.setText("50");
        b50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b50ActionPerformed(evt);
            }
        });

        b502.setBackground(new java.awt.Color(255, 0, 0));
        b502.setFont(new java.awt.Font("Tahoma", 1, 16));
        b502.setText("502");
        b502.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b502ActionPerformed(evt);
            }
        });

        b100.setBackground(new java.awt.Color(255, 153, 0));
        b100.setFont(new java.awt.Font("Tahoma", 1, 16));
        b100.setText("100");
        b100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b100ActionPerformed(evt);
            }
        });

        b4.setBackground(new java.awt.Color(51, 204, 0));
        b4.setFont(new java.awt.Font("Tahoma", 1, 16));
        b4.setText("4");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b21.setBackground(new java.awt.Color(255, 255, 0));
        b21.setFont(new java.awt.Font("Tahoma", 1, 16));
        b21.setText("21");
        b21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b21ActionPerformed(evt);
            }
        });

        b20.setBackground(new java.awt.Color(255, 255, 0));
        b20.setFont(new java.awt.Font("Tahoma", 1, 16));
        b20.setText("20");
        b20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b20ActionPerformed(evt);
            }
        });

        b1.setBackground(new java.awt.Color(51, 204, 0));
        b1.setFont(new java.awt.Font("Tahoma", 1, 16));
        b1.setText("1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(b50, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(b102, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(b502, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(b2500, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(b101, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(b500, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(b1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(b20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(b100, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(b50, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b2500, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b502, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b102, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(b21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b101, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b500, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b100, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel3.setText("Эффективны");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel4.setText("Минимальны");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel5.setText("Ограничены");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel6.setText("Не эффективны");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel7.setText("Катастрофа");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel8.setText("авиационное");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel9.setText("травмы или");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel10.setText("относящихся к АП");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel11.setText("происшествие");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel12.setText("Тяжелое");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel13.setText("повреждения");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel14.setText("Небольшие");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel15.setText("Без последствий");

        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 2, 14));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(2);
        jTextArea1.setText("Вопрос 2: Какова была эффективность оставшихся барьеров между данным событием  и наиболее правдоподобным сценарием, относящимся к авиационному происшествию?");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setFont(new java.awt.Font("Times New Roman", 2, 14));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(2);
        jTextArea2.setText("Вопрос 1: Если бы данное событие  привело к последствию, относящимуся к авиационному происшествию, каковым было бы  наиболее правдоподобное последствие?");
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/safety-first.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel7)
                                                                .addComponent(jLabel14)
                                                                .addComponent(jLabel13)
                                                                .addComponent(jLabel9)
                                                                .addComponent(jLabel11)
                                                                .addComponent(jLabel8)
                                                                .addComponent(jLabel12)
                                                                .addComponent(jLabel10)
                                                                .addComponent(jLabel15))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel6))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(66, 66, 66)
                                                                .addComponent(jLabel7)
                                                                .addGap(55, 55, 55)
                                                                .addComponent(jLabel12)
                                                                .addGap(7, 7, 7)
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel11)
                                                                .addGap(34, 34, 34)
                                                                .addComponent(jLabel14)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel9)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel13)
                                                                .addGap(48, 48, 48)
                                                                .addComponent(jLabel15)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel10)))))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
// Matrix button 1 
        this.parent.setTfRiskIndex("Низкий риск - 1", greenMatrix);
        this.parent.setTfIndex("1");
        this.dispose();
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
// Matrix button 2
        this.parent.setTfRiskIndex("Низкий риск - 2", greenMatrix);
        this.parent.setTfIndex("2");
        this.dispose();
    }//GEN-LAST:event_b2ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
// Matrix button 4
        this.parent.setTfRiskIndex("Низкий риск - 4", greenMatrix);
        this.parent.setTfIndex("4");
        this.dispose();
    }//GEN-LAST:event_b4ActionPerformed

    private void b10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b10ActionPerformed
// Matrix button 10
        this.parent.setTfRiskIndex("Низкий риск - 10", greenMatrix);
        this.parent.setTfIndex("10");
        this.dispose();
    }//GEN-LAST:event_b10ActionPerformed

    private void b20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b20ActionPerformed
// Matrix button 20
        this.parent.setTfRiskIndex("Умеренный риск - 20", yellowMatrix);
        this.parent.setTfIndex("20");
        this.dispose();
    }//GEN-LAST:event_b20ActionPerformed

    private void b21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b21ActionPerformed
// Matrix button 21
        this.parent.setTfRiskIndex("Умеренный риск - 21", yellowMatrix);
        this.parent.setTfIndex("21");
        this.dispose();
    }//GEN-LAST:event_b21ActionPerformed

    private void b50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b50ActionPerformed
// Matrix button 50
        this.parent.setTfRiskIndex("Умеренный риск - 50", yellowMatrix);
        this.parent.setTfIndex("50");
        this.dispose();
    }//GEN-LAST:event_b50ActionPerformed

    private void b100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b100ActionPerformed
// Matrix button 100
        this.parent.setTfRiskIndex("Высокий риск - 100", orangeMatrix);
        this.parent.setTfIndex("100");
        this.dispose();
    }//GEN-LAST:event_b100ActionPerformed

    private void b101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b101ActionPerformed
// Matrix button 101
        this.parent.setTfRiskIndex("Высокий риск - 101", orangeMatrix);
        this.parent.setTfIndex("101");
        this.dispose();
    }//GEN-LAST:event_b101ActionPerformed

    private void b102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b102ActionPerformed
// Matrix button 102
        this.parent.setTfRiskIndex("Высокий риск - 102", orangeMatrix);
        this.parent.setTfIndex("102");
        this.dispose();
    }//GEN-LAST:event_b102ActionPerformed

    private void b500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b500ActionPerformed
// Matrix button 500
        this.parent.setTfRiskIndex("Недопустимый риск - 500", redMatrix);
        this.parent.setTfIndex("500");
        this.dispose();
    }//GEN-LAST:event_b500ActionPerformed

    private void b502ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b502ActionPerformed
// Matrix button 502
        this.parent.setTfRiskIndex("Недопустимый риск - 502", redMatrix);
        this.parent.setTfIndex("502");
        this.dispose();
    }//GEN-LAST:event_b502ActionPerformed

    private void b2500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2500ActionPerformed
// Matrix button 2500
        this.parent.setTfRiskIndex("Недопустимый риск - 2500", redMatrix);
        this.parent.setTfIndex("2500");
        this.dispose();
    }//GEN-LAST:event_b2500ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b10;
    private javax.swing.JButton b100;
    private javax.swing.JButton b101;
    private javax.swing.JButton b102;
    private javax.swing.JButton b2;
    private javax.swing.JButton b20;
    private javax.swing.JButton b21;
    private javax.swing.JButton b2500;
    private javax.swing.JButton b4;
    private javax.swing.JButton b50;
    private javax.swing.JButton b500;
    private javax.swing.JButton b502;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
