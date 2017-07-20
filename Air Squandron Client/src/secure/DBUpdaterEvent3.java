package secure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUpdaterEvent3 extends JFrame {

    ImageIcon iconOK = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/OK.png")));
    ImageIcon iconError = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Error.png")));
    ImageIcon iconYellow = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/yellow 16x32.png")));
    ImageIcon iconRed = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/red 16x32.png")));
    ImageIcon iconGreen = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/green 16x32.png")));
    ImageIcon iconOrange = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/orange 16x32.png")));
    ImageIcon iconWhite = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/white 16x32.png")));

    public DefaultTableModel getData(String str) {
        DefaultTableModel dmEv3 = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dmEv3.addColumn("AirFASE Event 3");
        dmEv3.addColumn("Классификация события");
        dmEv3.addColumn("Предварительная оценка риска");
        dmEv3.addColumn("Индекс");

        String sql = "SELECT * FROM flightdata WHERE Incoming_number='" + str + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);

            while (rs.next()) {

                String airEvent1 = rs.getString(29);
                String classification = rs.getString(28);
                String assess = rs.getString(30);

                if (assess != null) {
                    if (assess.contains("Низкий")) {
                        dmEv3.addRow(new Object[]{airEvent1, classification, assess, iconGreen});
                    } else if (assess.contains("Умеренный")) {
                        dmEv3.addRow(new Object[]{airEvent1, classification, assess, iconYellow});
                    } else if (assess.contains("Высокий")) {
                        dmEv3.addRow(new Object[]{airEvent1, classification, assess, iconOrange});
                    } else if (assess.contains("Недопустимый")) {
                        dmEv3.addRow(new Object[]{airEvent1, classification, assess, iconRed});
                    } else {
                        dmEv3.addRow(new Object[]{airEvent1, classification, assess, iconWhite});
                    }
                }
            }
            return dmEv3;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
            }
            ;
            try {
                if (s != null) s.close();
            } catch (Exception e) {
            }
            ;
            try {
                if (con != null) con.close();
            } catch (Exception e) {
            }
            ;
        }
        return null;
    }
}
