package secure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class DBUpdaterWorkingWindow extends JFrame {

    public Object[] getEventsData(String str) {
        //массив объектов - модель данных верхней панели
        String sql = "SELECT * FROM flightdata WHERE Incoming_number='" + str + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                Object eventClass1 = rs.getObject(22);
                Object eventClass2 = rs.getObject(25);
                Object eventClass3 = rs.getObject(28);
                Object eventClass4 = rs.getObject(31);
                Object eventNbr1 = rs.getObject(23);
                Object eventNbr2 = rs.getObject(26);
                Object eventNbr3 = rs.getObject(29);
                Object eventNbr4 = rs.getObject(32);
                Object riskAss1 = rs.getObject(24);
                Object riskAss2 = rs.getObject(27);
                Object riskAss3 = rs.getObject(30);
                Object riskAss4 = rs.getObject(33);
                Object prim = rs.getObject(34);
                Object analysis = rs.getObject(14);
                Object corActions = rs.getObject(15);
                Object commander = rs.getObject(13);
                Object analysisData = rs.getObject(39);

                Object[] events = new Object[]{eventClass1, eventNbr1, riskAss1,
                        eventClass2, eventNbr2, riskAss2,
                        eventClass3, eventNbr3, riskAss3,
                        eventClass4, eventNbr4, riskAss4,
                        prim, analysis, corActions, commander, analysisData};
                return events;
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

    public Object[] getLowerPanelData(String str) {
        //массив объектов - модель данных нижней панели window3 (всех 3 вкладок)
        String sql = "SELECT * FROM flightdata WHERE Incoming_number='" + str + "'";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                Object kvs = rs.getObject(9);
                Object vp = rs.getObject(10);
                Object pf = rs.getObject(11);
                Object ae = rs.getObject(12);
                Object necActions = rs.getObject(17);
                Object control = rs.getObject(18);
                Object corActDeadline = rs.getObject(19);
                Object glazkov = rs.getObject(37);
                Object corActAccept = rs.getObject(20);
                Object finalRiskAss = rs.getObject(16);
                Object talonClosure = rs.getObject(21);
                Object finalRisk = rs.getObject(16);
                Object indexRsik = rs.getObject(38);

                Object[] lowerPanelData = new Object[]{kvs, vp, pf, ae, necActions, control,
                        corActDeadline, glazkov, corActAccept, finalRiskAss, talonClosure, finalRisk, indexRsik};
                return lowerPanelData;
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

    public DefaultTableModel getData(String str) {
        DefaultTableModel dmWW = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dmWW.addColumn("№");
        dmWW.addColumn("Дата обработки");
        dmWW.addColumn("Дата полета");
        dmWW.addColumn("Борт");
        dmWW.addColumn("Рейс");
        dmWW.addColumn("Взлет");
        dmWW.addColumn("Посадка");

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM flightdata WHERE Incoming_number='" + str + "'";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                //получаем значения
                String incomingNumber = rs.getString(2);
                String dateOfProcessing = rs.getString(3);
                String dateOfFlight = rs.getString(4);
                String flightNumber = rs.getString(5);
                String departure = rs.getString(6);
                String arrival = rs.getString(7);
                String tailNumber = rs.getString(8);
                dmWW.addRow(new Object[]{incomingNumber, dateOfProcessing, dateOfFlight,
                        tailNumber, flightNumber, departure, arrival});
            }
            return dmWW;
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

    public Boolean update(String id, String kvs, String vp, String pf, String ae, String nesAct, String control,
                          Date dateProc) throws ParseException {
        //сначала необходимо распарсить дату полета и дату обработки в норм формат из JCalendar      
        String stringDateCorActD = DateFormat.getDateInstance().format(dateProc);

        Connection con = null;
        Statement s = null;
        String sql = "UPDATE flightdata SET KVS = '" + kvs + "', VP = '" + vp + "',"
                + " PF ='" + pf + "', AE = '" + ae + "', Necessary_things = '" + nesAct + "',"
                + " Control = '" + control + "',   Deadline_cor_act = '" + stringDateCorActD + "'  WHERE Incoming_number ='" + id + "'";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
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

    public Boolean update2page(String id, String infoFromGlazkov,
                               int glazRisk, String corActAccept) throws ParseException {

        String sql = "UPDATE flightdata SET Glazkov = ?,  Risk_index  = ?,"
                + " Cor_act_accepted ='" + corActAccept + "'  WHERE Incoming_number ='" + id + "'";
        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, infoFromGlazkov);
            s.setInt(2, glazRisk);
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

    public Boolean update2pageWithClosure(String id, String infoFromGlazkov,
                                          int glazRisk, String corActAccept, String talonClosure) throws ParseException {

        String sql = "UPDATE flightdata SET Glazkov = ?,  Risk_index  = ?,"
                + " Cor_act_accepted ='" + corActAccept + "', Talon_closure = '" + talonClosure + "' WHERE Incoming_number ='" + id + "'";
        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, infoFromGlazkov);
            s.setInt(2, glazRisk);
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

    public Boolean update3page(String id, int finalRisk, String talonClosure) throws ParseException {
        String sql = "UPDATE flightdata SET Risk_index  = ?, "
                + " Talon_closure ='" + talonClosure + "'  WHERE Incoming_number ='" + id + "'";
        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setInt(1, finalRisk);
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

    public Boolean updateAnalysis(String id, String analysis, String corrAct) throws ParseException {

        Connection con = null;
        PreparedStatement s = null;
        String sql = "UPDATE flightdata SET Analysis = ?, Corrective_action = ?"
                + " WHERE Incoming_number ='" + id + "'";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr,
                    Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, analysis);
            s.setString(2, corrAct);
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
}
