/*
 * контролер подключение к ДБ WorkingWindow 2
 */
package secure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class DBUpdaterWorkingWindow extends JFrame {

    Connection con = null;
    Statement stm = null;

    public String getNewRow() {
        String rowString = "";
        // выборка последней записи

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT Incoming_number FROM flightdata ORDER BY flightdata_id DESC LIMIT 1";

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            rs.last();
            String incomingNumber = rs.getString(1);
            return incomingNumber;
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
        return rowString;
    }

    public Object[] getData(String str) {

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM flightdata WHERE Incoming_number='" + str + "'";

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);

            while (rs.next()) {
                String incomingNumber = rs.getString(2);
                String processingDate = rs.getString(3);
                String dateOfFlight = rs.getString(4);
                String flightNumber = rs.getString(5);
                String departure = rs.getString(6);
                String arrival = rs.getString(7);
                String tailNumber = rs.getString(8);
                Object airFASE1 = rs.getObject(23);
                Object airFASE2 = rs.getObject(26);
                Object airFASE3 = rs.getObject(29);
                Object airFASE4 = rs.getObject(32);
                Object Class1 = rs.getObject(22);
                Object Class2 = rs.getObject(25);
                Object Class3 = rs.getObject(28);
                Object Class4 = rs.getObject(31);
                Object Assess1 = rs.getObject(24);
                Object Assess2 = rs.getObject(27);
                Object Assess3 = rs.getObject(30);
                Object Assess4 = rs.getObject(33);
                String processedGOPI = rs.getString(35);
                String prim = rs.getString(34);

                Object data[] = {incomingNumber, processingDate, dateOfFlight, flightNumber, departure,
                        arrival, tailNumber, airFASE1, airFASE2, airFASE3, airFASE4, Class1, Class2, Class3, Class4,
                        Assess1, Assess2, Assess3, Assess4, processedGOPI, prim};
                return data;
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

    //   update data 
    public Boolean update(String id, Date dateProc, Date dateFlight, String tailNbr, String flightNbr, String txtDep, String txtArrival,
                          String eventClass1, String eventClass2, String eventClass3, String eventClass4, String airFASE1, String airFASE2, String airFASE3,
                          String airFASE4, String ass1, String ass2, String ass3, String ass4, String prim, String procBy) throws ParseException {

        //сначала необходимо распарсить дату полета и дату обработки в норм формат из JCalendar
        String stringDatePr = DateFormat.getDateInstance().format(dateProc);
        String stringDateFl = DateFormat.getDateInstance().format(dateFlight);
        // SQL statement
        String sql = "UPDATE flightdata SET Date_processing = '" + stringDatePr + "', Date_of_flight = '" + stringDateFl + "',"
                + " Tail_number = ?, Flight_number = ?, Departure = ?,"
                + " Arrival = ?, Event_class_1 = ?, Event_class_2 = ?,"
                + " Event_class_3 = ?, Event_class_4 = ?, Event_AirFASE_1 = ?,"
                + " Event_AirFASE_2 = ?, Event_AirFASE_3 = ?, Event_AirFASE_4 = ?,"
                + " Risk_ass_1 = ?, Risk_ass_2 = ?, Risk_ass_3 = ?, Risk_ass_4 = ?,"
                + " Primechanie = ?, Processed_by_gopi = ?  WHERE Incoming_number ='" + id + "'";

        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, tailNbr);
            s.setString(2, flightNbr);
            s.setString(3, txtDep);
            s.setString(4, txtArrival);
            s.setString(5, eventClass1);
            s.setString(6, eventClass2);
            s.setString(7, eventClass3);
            s.setString(8, eventClass4);
            s.setString(9, airFASE1);
            s.setString(10, airFASE2);
            s.setString(11, airFASE3);
            s.setString(12, airFASE4);
            s.setString(13, ass1);
            s.setString(14, ass2);
            s.setString(15, ass3);
            s.setString(16, ass4);
            s.setString(17, prim);
            s.setString(18, procBy);
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

    // вставить в базу новое сообщение   
    public boolean add(String id, Date dateProc, Date dateFlight, String tailNbr, String flightNbr, String txtDep, String txtArrival,
                       String eventClass1, String eventClass2, String eventClass3, String eventClass4, String airFASE1, String airFASE2, String airFASE3,
                       String airFASE4, String ass1, String ass2, String ass3, String ass4, String prim, String procBy) {

        //сначала необходимо распарсить дату полета и дату обработки в норм формат из JCalendar
        String stringDatePr = DateFormat.getDateInstance().format(dateProc);
        String stringDateFl = DateFormat.getDateInstance().format(dateFlight);

        String sql = "INSERT INTO flightdata(Incoming_number, Date_processing, Date_of_flight, "
                + "Tail_number, Flight_number, Departure, Arrival, Event_class_1, Event_class_2, Event_class_3, Event_class_4,"
                + " Event_AirFASE_1, Event_AirFASE_2, Event_AirFASE_3, Event_AirFASE_4, Risk_ass_1, Risk_ass_2, Risk_ass_3, "
                + "Risk_ass_4, Primechanie, Processed_by_gopi) "
                + "VALUES(?, '" + stringDatePr + "','" + stringDateFl + "', '" + tailNbr + "', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '" + ass1 + "', '" + ass2 + "', '" + ass3 + "', '" + ass4 + "', ?,'" + procBy + "')";

        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, id);
            s.setString(2, flightNbr);
            s.setString(3, txtDep);
            s.setString(4, txtArrival);
            s.setString(5, eventClass1);
            s.setString(6, eventClass2);
            s.setString(7, eventClass3);
            s.setString(8, eventClass4);
            s.setString(9, airFASE1);
            s.setString(10, airFASE2);
            s.setString(11, airFASE3);
            s.setString(12, airFASE4);
            s.setString(13, prim);
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

    public Object[] getFleet() {

        Object[] fleet;
        ArrayList fleetList = new ArrayList();
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM fleet order by tail";

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);

            fleetList.add("");
            while (rs.next()) {
                fleetList.add(rs.getObject(2));
            }
            fleet = fleetList.toArray();
            return fleet;
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

    public Object[] getPersonal() {

        Object[] personal;
        ArrayList personalList = new ArrayList();
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM gopi order by name";

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);

            personalList.add("");
            while (rs.next()) {
                personalList.add(rs.getObject(2));
            }
            personal = personalList.toArray();
            return personal;
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


    // заполняем Jtree
    @SuppressWarnings("CallToThreadDumpStack")
    public final DefaultTreeModel pop_tree() throws SQLException {

        ResultSet rs = null;

        try {
            try {
                con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
                stm = con.createStatement();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            ArrayList list = new ArrayList();
            list.add("Этап полета");
            String sql = "SELECT * from category";

            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Object value[] = {rs.getString(1), rs.getString(2)};
                list.add(value);
            }
            rs.close(); //уже добавил
            Object hierarchy[] = list.toArray();
            DefaultMutableTreeNode root = processHierarchy(hierarchy);

            DefaultTreeModel treeModel = new DefaultTreeModel(root);
            return treeModel;
        } catch (Exception e) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            ;
            try {
                if (stm != null) {
                    stm.close();
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

    @SuppressWarnings("CallToThreadDumpStack")
    public DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
        try {
            int ctrow = 0;
            int i = 0;
            try {

                try {
                    con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
                    stm = con.createStatement();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                String sql = "SELECT catid, catname from category";
                ResultSet rs = stm.executeQuery(sql);

                while (rs.next()) {
                    ctrow = rs.getRow();
                }
                String L1Nam[] = new String[ctrow];
                String L1Id[] = new String[ctrow];
                ResultSet rs1 = stm.executeQuery(sql);
                while (rs1.next()) {
                    L1Nam[i] = rs1.getString("catname");
                    L1Id[i] = rs1.getString("catid");
                    i++;
                }
                DefaultMutableTreeNode child, grandchild;
                for (int childIndex = 0; childIndex < L1Nam.length; childIndex++) {
                    child = new DefaultMutableTreeNode(L1Nam[childIndex]);
                    node.add(child);//add each created child to root
                    String sql2 = "SELECT scatname from subcategory where catid= '" + L1Id[childIndex] + "' ";
                    ResultSet rs3 = stm.executeQuery(sql2);
                    while (rs3.next()) {
                        grandchild = new DefaultMutableTreeNode(rs3.getString("scatname"));
                        child.add(grandchild);//add each grandchild to each child
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
        }

        return (node);
    }

    public boolean checkAccess(String str) {

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM flightdata WHERE Incoming_number='" + str + "'";
        boolean accessGranted = false;

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);

            while (rs.next()) {
                String acceptedByGopi = rs.getString(36);
                if (acceptedByGopi != null) {
                    accessGranted = false;
                } else {
                    accessGranted = true;
                }
            }
            return accessGranted;
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
        return accessGranted;
    }

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

    public DefaultTableModel getLookData(String str) {
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
}
