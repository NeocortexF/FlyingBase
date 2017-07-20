package secure;

import java.sql.*;
import javax.swing.*;

/**
 * @author NeocortexF
 *         Это класс для подключения Login
 *         Здесь подключение закрывать не надо. Подкл закрывает форма Login
 */
public class MySqlConnect {
    Connection conn = null;


    public static Connection ConnectDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}

