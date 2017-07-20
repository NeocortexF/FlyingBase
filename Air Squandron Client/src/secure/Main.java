package secure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static String loginPath;
    public static String netFolderPath;
    public static String username = "some_user_name";
    public static String password = "some_user_password;
    static Scanner scn;
    static Scanner s
    public static String conIninialiazedStr;
    canNetFolder;
    public String conString = "jdbc:mysql://" + loginPath + "?characterEncoding=utf8&amp;autoReconnect=true;";

    private static void openFile() {
        try {
            File file = new File("./lib/login.properties").getAbsoluteFile();
            scn = new Scanner(file);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Файл login.properties не найден");
        }
    }

    private static void openNetFolder() {
        try {
            File file = new File("./lib/netfolder.ini").getAbsoluteFile();
            scanNetFolder = new Scanner(file);
            netFolderPath = scanNetFolder.nextLine();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Файл netfolder.ini не найден");
        }
    }

    private static void readFile() {
        loginPath = scn.next();
        conIninialiazedStr = "jdbc:mysql://" + loginPath + "?characterEncoding=utf8&amp;autoReconnect=true;";
    }

    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        openFile();
        readFile();
        openNetFolder();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int locX = (screenSize.width - 700) / 2;
                int locY = (screenSize.height - 350) / 2;
                Login log = new Login();
                log.setLocation(locX, locY);
                log.setVisible(true);
            }
        });
    }
}
