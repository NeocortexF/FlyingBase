package secure;

import java.sql.*;
import javax.swing.*;

public class MySqlConnect {
    Connection conn = null;

    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

