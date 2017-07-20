package secure;

import javax.swing.table.DefaultTableModel;

public class DBUpdaterWorkingWindow extends JFrame {

    ImageIcon iconOK = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/OK.png")));
    ImageIcon iconError = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Error.png")));
    ImageIcon iconYellow = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/yellow 16x32.png")));
    ImageIcon iconRed = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/red 16x32.png")));
    ImageIcon iconGreen = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/green 16x32.png")));
    ImageIcon iconOrange = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/orange 16x32.png")));
    ImageIcon iconWhite = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/white 16x32.png")));

    public DefaultTableModel getData(String str) {
        DefaultTableModel dmWW = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dmWW.addColumn("№");
        dmWW.addColumn("Дата полета");
        dmWW.addColumn("Рейс");
        dmWW.addColumn("Вылет");
        dmWW.addColumn("Прибытие");
        dmWW.addColumn("Борт. номер");
        dmWW.addColumn("КВС ID");
        dmWW.addColumn("ВП ID");
        dmWW.addColumn("PF");
        dmWW.addColumn("Необходимые мероприятия");
        dmWW.addColumn("Срок КД");
        dmWW.addColumn("КД одобрены");
        dmWW.addColumn("Закрыто");

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;

        Object corActAcceptedIcon = "";
        Object talonClosureIcon = "";

        String sql = "SELECT * FROM flightdata WHERE Incoming_number='" + str + "'";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);

            while (rs.next()) {

                String incomingNumber = rs.getString(2);
                String dateOfFlight = rs.getString(4);
                String flightNumber = rs.getString(5);
                String departure = rs.getString(6);
                String arrival = rs.getString(7);
                String tailNumber = rs.getString(8);
                String kvs = rs.getString(9);
                String vp = rs.getString(10);
                String pf = rs.getString(11);
                String necessaryThings = rs.getString(17);
                String deadlineCorAction = rs.getString(19);
                String corActAccepted = rs.getString(20);
                String talonClosure = rs.getString(21);

                if (corActAccepted == null || corActAccepted.equals("") || corActAccepted.equals(" ") || corActAccepted.equals("  ")) {
                    corActAcceptedIcon = iconError;
                } else {
                    corActAcceptedIcon = iconOK;
                }

                if (talonClosure == null || talonClosure.equals("") || talonClosure.equals(" ") || talonClosure.equals("  ")) {
                    talonClosureIcon = iconError;
                } else {
                    talonClosureIcon = iconOK;
                }

                dmWW.addRow(new Object[]{incomingNumber, dateOfFlight, flightNumber, departure,
                        arrival, tailNumber, kvs, vp, pf, necessaryThings, deadlineCorAction, corActAcceptedIcon, talonClosureIcon});
            }
            return dmWW;
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

    public Object[] getLowerData(String str) {
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM flightdata WHERE Incoming_number='" + str + "'";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                String prim = rs.getString(34);
                String commander = rs.getString(13);
                String corAct = rs.getString(15);
                String analysis = rs.getString(14);
                String glaz = rs.getString(37);
                Object[] lowerData = {prim, commander, corAct, analysis, glaz};
                return lowerData;
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

    public Boolean update(String id, String analysis, String correctiveAction, String CommanderOrZam) {
        String sql = "UPDATE flightdata SET Analysis = ?, Corrective_action = ?, Commander_or_zam_ae = ?, Analysis_date = date_format(current_timestamp(), '%d.%m.%Y %T') WHERE Incoming_number ='" + id + "'";
        Connection con = null;
        PreparedStatement s = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            s.setString(1, analysis);
            s.setString(2, correctiveAction);
            s.setString(3, CommanderOrZam);
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
}
