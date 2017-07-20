package secure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

public class PersonnelDBUpdater {

    public DefaultTableModel getData() {
        DefaultTableModel dm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dm.addColumn("№ в базе");
        dm.addColumn("Фамилия Имя Отчество");
        dm.addColumn("Табельный №");
        dm.addColumn("Номер АЭ");
        dm.addColumn("Должность");

        String sql = "SELECT * FROM person order by Name";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String tabelNumber = rs.getString(3);
                String ae = rs.getString(4);
                String position = rs.getString(5);

                dm.addRow(new Object[]{id, name, tabelNumber, ae, position});
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

    public Object[] getDataForEdit(String ID) {
        String sql = "SELECT * FROM person WHERE person_id = '" + ID + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(2);
                String tabelNumber = rs.getString(3);
                String ae = rs.getString(4);
                String position = rs.getString(5);
                Object[] dataForEdit = new Object[]{name, tabelNumber, ae, position};
                return dataForEdit;
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

    public Boolean update(String id, String name, String tabelNbr, String ae, String position) {
        String sql = "UPDATE person SET Name = ?, ID = ?,"
                + "AE = ?, Position = ?  WHERE person_id ='" + id + "'";
        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, name);
            s.setString(2, tabelNbr);
            s.setString(3, ae);
            s.setString(4, position);
            s.execute();
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
        String sql = "DELETE FROM person WHERE person_id = '" + id + "'";
        Connection con = null;
        Statement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
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

    public boolean add(String name, String tabelNbr, String ae, String position) {
        String sql = "INSERT INTO person(Name, ID, AE, Position) VALUES(?, ?,"
                + "?, ?)";
        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, name);
            s.setString(2, tabelNbr);
            s.setString(3, ae);
            s.setString(4, position);
            s.execute();
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

    public Object[] getInfoKVS(String ID) {
        String sql = "SELECT * FROM person WHERE ID = '" + ID + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(2);
                String ae = rs.getString(4);
                String position = rs.getString(5);
                Object[] dataForInfo = new Object[]{name, ae, position};
                return dataForInfo;
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
}
