package secure;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ClassificatorUpdater {

    public DefaultTableModel getCategory() {

        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("№ категории");
        dm.addColumn("Категория");

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM category";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String ID = rs.getString(1);
                String category = rs.getString(2);
                dm.addRow(new Object[]{ID, category});
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

    public DefaultTableModel getSubCategory() {

        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Категория");
        dm.addColumn("Пункт классификатора");

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM subcategory";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                int subID = rs.getInt(1);
                int catID = rs.getInt(2);
                String subName = rs.getString(3);
                dm.addRow(new Object[]{subID, catID, subName});
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

    public boolean addCategory(String category) {
        Connection con = null;
        Statement s = null;
        String sql = "INSERT INTO category(catname) VALUES('" + category + "')";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.execute(sql);
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

    public Object[] getDetails(String ID) {
        String sql = "SELECT * FROM category WHERE catid = '" + ID + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        Object[] details;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                Object id = rs.getObject(1);
                Object category = rs.getObject(2);
                details = new Object[]{id, category};
                return details;
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

    public Boolean updateCategory(String id, String category) {
        Connection con = null;
        Statement s = null;
        String sql = "UPDATE category SET catname = '" + category + "' WHERE catid ='" + id + "'";
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
        Connection con = null;
        Statement s = null;
        String sql = "DELETE FROM category WHERE catid = '" + id + "'";
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

    public Boolean updateSubCategory() throws SQLException {
        Connection con = null;
        Statement s = null;
        String sql = "UPDATE subcategory SET catid = ?, scatname=? WHERE scatid = ?";
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

    public void cleanTableSubcategory() {
        Connection con = null;
        Statement s = null;
        String sql = "DELETE FROM subcategory";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.execute(sql);
        } catch (SQLException ex) {
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
    }

    public void cleanTableСategory() {
        Connection con = null;
        Statement s = null;
        String sql = "DELETE FROM category";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.execute(sql);
        } catch (SQLException ex) {
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
    }

    public void saveDataFromTableToSQL(Object[] data, int rows) {

        int id = 0;
        int catid = 0;
        Object catname;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            con.setAutoCommit(false);
            String sql = "INSERT INTO subcategory(scatid, catid, scatname) values (?,?,?)";
            pst = con.prepareStatement(sql);

            int i = 0;
            for (int row = 0; row < rows; row++) {
                id = Integer.parseInt(data[i].toString());
                pst.setInt(1, id);
                i++;
                catid = Integer.parseInt(data[i].toString());
                pst.setInt(2, catid);
                i++;
                catname = data[i];
                pst.setObject(3, catname);
                i++;
                pst.addBatch();
            }
            pst.executeBatch();
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ClassificatorUpdater.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
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

    public void saveDataFromCategory(Object[] data, int rows) {

        int id = 0;
        Object catname;
        Connection con = null;
        PreparedStatement pst = null;

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            con.setAutoCommit(false);
            String sql = "INSERT INTO category(catid, catname) values (?,?)";
            pst = con.prepareStatement(sql);

            int i = 0;
            for (int row = 0; row < rows; row++) {
                id = Integer.parseInt(data[i].toString());
                pst.setInt(1, id);
                i++;
                catname = data[i];
                pst.setObject(2, catname);
                i++;
                pst.addBatch();
            }
            pst.executeBatch();
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ClassificatorUpdater.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
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
}
