package secure;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class AirportDBUpdater {

    public DefaultTableModel getData() {
        DefaultTableModel dm = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dm.addColumn("№");
        dm.addColumn("Аэропорт");
        dm.addColumn("Код ICAO");

        String sql = "SELECT * FROM airports order by airport";
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
                String airportName = rs.getString(2);
                String codeICAO = rs.getString(3);

                dm.addRow(new Object[]{id, airportName, codeICAO});
            }
            return dm;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
            ;
        }
        return null;
    }

    public Object[] getDataForEdit(String ID) {
        String sql = "SELECT * FROM airports WHERE id = '" + ID + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String airportName = rs.getString(2);
                String codeICAO = rs.getString(3);
                Object[] dataForEdit = new Object[]{airportName, codeICAO};
                return dataForEdit;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
            ;
        }
        return null;
    }

    public Boolean update(String id, String airportName, String codeICAO) {
        String sql = "UPDATE airports SET airport = ?, code = ?"
                + " WHERE id ='" + id + "'";
        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, airportName);
            s.setString(2, codeICAO);
            s.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
            ;
        }
    }

    public Boolean delete(String id) {
        String sql = "DELETE FROM airports WHERE id = '" + id + "'";
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
                if (s != null) {
                    s.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
            ;
        }
    }

    public boolean add(String airportName, String codeICAO) {
        String sql = "INSERT INTO airports(airport, code) VALUES(?, ?)";
        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, airportName);
            s.setString(2, codeICAO);
            s.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
            ;
        }
        return false;
    }

    public String getInfoAirport(String code) {
        String sql = "SELECT airport FROM airports WHERE code = '" + code + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String airportName = rs.getString(1);
                return airportName;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
            ;
        }
        return null;
    }
}
