package secure;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login extends javax.swing.JFrame {

    public static Welcome w;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    LoginSettings logSet;

    public Login() throws FileNotFoundException, IOException {
        initComponents();
        initLogin();
        jPanel1.getRootPane().setDefaultButton(btnSubmit);
    }

    private void initLogin() throws FileNotFoundException, IOException {
        if (checkBox.isSelected()) {
            String loginName = openFile();
            txtusername.setText(loginName);
        } else {
            txtusername.setText(null);
        }
    }

    private String openFile() throws IOException {
        //метод открывает файл с именем юзера
        Scanner scn;
        String loginName = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("./lib/mute.lib"));
            if (br.readLine() == null) {
                loginName = "";
            } else {
                File file = new File("./lib/mute.lib").getAbsoluteFile();
                scn = new Scanner(file);
                loginName = scn.next();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Файл mute.lib не найден");
        }
        return loginName;
    }

    private void clearFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("./lib/mute.lib");
        writer.print("");
        writer.close();
    }

    private void writeFile() {
        File myFile = new File("./lib/mute.lib");
        String newConnectionString = txtusername.getText();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
            writer.write(newConnectionString);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(LoginSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        txtusername = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        checkBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Flying Base: Flight Department");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FB Icon.png")));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtpassword.setFont(new java.awt.Font("Dialog", 0, 18));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel2.setText("Пароль:");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel1.setText("Имя пользователя:");

        btnSubmit.setFont(new java.awt.Font("Dialog", 1, 18));
        btnSubmit.setText("Войти");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        txtusername.setFont(new java.awt.Font("Dialog", 0, 18));

        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configuration_settings_setup.png"))); // NOI18N
        jButton1.setToolTipText("Настройки подключения к базе данных");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flyingbase logo2.png"))); // NOI18N

        checkBox.setFont(new java.awt.Font("Tahoma", 0, 18));
        checkBox.setSelected(true);
        checkBox.setText("Запомнить логин");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jLabel3)
                                .addGap(65, 65, 65))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtpassword, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtusername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(checkBox, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(133, 133, 133)
                                                .addComponent(jButton1)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(checkBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1)
                                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // Кнопка входа в базу данных
        conn = MySqlConnect.ConnectDB();
        String Sql = "SELECT * FROM login WHERE username=? and pass=?";
        try {
            pst = conn.prepareStatement(Sql);
            pst.setString(1, txtusername.getText());
            pst.setString(2, txtpassword.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                if (checkBox.isSelected()) {
                    //                  ----------------------------------------------------------------------
                    writeFile();
                } else {
                    clearFile();
                }
                w = new Welcome();
                w.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Неправильное имя пользователя или пароль",
                        "Доступ запрещен!",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int locX = (screenSize.width - 612) / 2;
            int locY = (screenSize.height - 300) / 2;
            logSet = new LoginSettings();
            logSet.setLocation(locX, locY);
            logSet.setVisible(true);
        }
    }//GEN-LAST:event_jButton1KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
