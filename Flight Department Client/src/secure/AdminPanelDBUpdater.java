/*
 * контролер подключение к ДБ для окна выбора. 
 */
package secure;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class AdminPanelDBUpdater extends JFrame {

    ImageIcon iconPass = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/key.png")));

    //retrieve data 
    public DefaultTableModel getData() {

        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("Uniq ID");
        dm.addColumn("Логин");
        dm.addColumn("Пароль");
        dm.addColumn("ФИО");
        dm.addColumn("Должность");

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login order by fio";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String ID = rs.getString(1);
                String userName = rs.getString(2);
                String pass = rs.getString(3);
                Object fio = rs.getObject(4);
                Object department = rs.getObject(5);
                dm.addRow(new Object[]{ID, userName, iconPass, fio, department});
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
        String sql = "SELECT * FROM login WHERE ID = '" + ID + "'";
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

    public String getPassword(String ID) {
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM login WHERE ID = '" + ID + "'";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String pass = rs.getString(3);
                return pass;
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

    public Object[] getDetails(String ID) {
        String sql = "SELECT * FROM login WHERE ID = '" + ID + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        Object[] details;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                Object fio = rs.getObject(4);
                Object department = rs.getObject(5);
                details = new Object[]{fio, department};
                return details;
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


    public Boolean update(String id, String name, String pass, String fio, String department) {
        Connection con = null;
        Statement s = null;
        String sql = "UPDATE login SET username = '" + name + "', pass ='" + pass + "', fio = '" + fio + "', department = '" + department + "' WHERE ID ='" + id + "'";
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
        String sql = "DELETE FROM login WHERE ID = '" + id + "'";
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

    public boolean add(String name, String pass, String fio, String department) {
        Connection con = null;
        Statement s = null;
        String sql = "INSERT INTO login(username, pass, fio, department) VALUES('" + name + "', '" + pass + "', '" + fio + "', '" + department + "')";
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
