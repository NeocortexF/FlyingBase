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

public class GopiDBUpdater extends JFrame {

    //retrieve data 
    public DefaultTableModel getData() {

        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("Uniq ID");
        dm.addColumn("ФИО");

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM gopi order by name";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String ID = rs.getString(1);
                String userName = rs.getString(2);
                dm.addRow(new Object[]{ID, userName});
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

    public String getUsername(String ID) {
        String sql = "SELECT * FROM gopi WHERE ID = '" + ID + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(2);
                return name;
            }
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

    public Boolean update(String id, String name) {
        Connection con = null;
        Statement s = null;
        String sql = "UPDATE gopi SET name = '" + name + "' WHERE ID ='" + id + "'";
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
        String sql = "DELETE FROM gopi WHERE ID = '" + id + "'";
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

    public boolean add(String name) {
        Connection con = null;
        Statement s = null;
        String sql = "INSERT INTO gopi(name) VALUES('" + name + "')";
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
