/*
 * контролер подключение к ДБ для окна выбора. 
 */
package secure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class FleetPanelDBUpdater extends JFrame {

    //retrieve data 
    public DefaultTableModel getData() {

        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("№ п/п");
        dm.addColumn("Бортовой номер");
        dm.addColumn("ID в базе");

        int currentNumber = 0;
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM fleet order by tail";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                currentNumber = currentNumber + 1;
                String ID = rs.getString(1);
                String tailNumber = rs.getString(2);
                dm.addRow(new Object[]{currentNumber, tailNumber, ID});
            }
            return dm;
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


    public Boolean update(String id, String tail) {
        Connection con = null;
        Statement s = null;
        String sql = "UPDATE fleet SET tail = '" + tail + "' WHERE ID ='" + id + "'";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.execute(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
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
    }


    public Boolean delete(String id) {
        Connection con = null;
        Statement s = null;
        String sql = "DELETE FROM fleet WHERE ID = '" + id + "'";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.execute(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
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
    }

    //  ? 
    public boolean add(String tailNbr) {
        Connection con = null;
        Statement s = null;
        String sql = "INSERT INTO fleet(tail) VALUES('" + tailNbr + "')";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.execute(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
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
        return false;
    }
}
