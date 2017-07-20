package secure;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUpdater extends JFrame {

    ImageIcon iconOK = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/OK.png")));
    ImageIcon iconError = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Error.png")));
    ImageIcon iconYellow = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/yellow 16x32.png")));
    ImageIcon iconRed = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/red 16x32.png")));
    ImageIcon iconGreen = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/green 16x32.png")));
    ImageIcon iconOrange = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/orange 16x32.png")));
    ImageIcon iconWhite = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/white 16x32.png")));

    public DefaultTableModel getData(int sqlFlag, int aviaEscNbr) {
        DefaultTableModel dm = new DefaultTableModel() {

            //блокировка возможности редактирования ячеек таблицы
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dm.addColumn("№");
        dm.addColumn("Дата полета");
        dm.addColumn("Рейс");
        dm.addColumn("Вылет");
        dm.addColumn("Прибытие");
        dm.addColumn("Борт. номер");
        dm.addColumn("КВС ID");
        dm.addColumn("ВП ID");
        dm.addColumn("Исх. риск");
        dm.addColumn("Срок КД");
        dm.addColumn("КД одобрены");
        dm.addColumn("Риск");
        dm.addColumn("Закрыто");

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        Object necessaryThingsIcon = "";
        Object corActAcceptedIcon = "";
        Object talonClosureIcon = "";

        String sql = "";
        //флаги (для работы фильтров по радиокнопке): 
        //1 - показать все сообщения
        //2 - без низкого риска
        //3 - не закрытые
        //4 - не одобренные
        if (sqlFlag == 1) {
            sql = "SELECT * FROM flightdata WHERE AE='" + aviaEscNbr + "' and Accepted_by_gopi is not null order by flightdata_id desc limit 3000";
        } else if (sqlFlag == 2) {
            sql = "SELECT * FROM flightdata WHERE AE='" + aviaEscNbr + "' and Risk_index>19 and Accepted_by_gopi is not null order by flightdata_id desc limit 3000";
        } else if (sqlFlag == 3) {
            sql = "SELECT * FROM flightdata WHERE AE='" + aviaEscNbr + "' and (Talon_closure = '' or ' ' or Talon_closure is null) and Accepted_by_gopi is not null order by flightdata_id desc limit 3000";
        } else if (sqlFlag == 4) {
            sql = "SELECT * FROM flightdata WHERE AE='" + aviaEscNbr + "' and (Cor_act_accepted = '' or ' ' or Cor_act_accepted is null) and Accepted_by_gopi is not null order by flightdata_id desc limit 3000";
        }
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
                String necessaryThings = rs.getString(17);
                String deadlineCorAction = rs.getString(19);
                String corActAccepted = rs.getString(20);
                String finalRisk = rs.getString(38);
                String talonClosure = rs.getString(21);

                if (necessaryThings != null) {
                    if (necessaryThings.contains("8DFF41")) {
                        necessaryThingsIcon = iconGreen;
                    } else if (necessaryThings.contains("FFAC05")) {
                        necessaryThingsIcon = iconOrange;
                    } else if (necessaryThings.contains("EBFF14")) {
                        necessaryThingsIcon = iconYellow;
                    } else if (necessaryThings.contains("ПРАПИ")) {
                        necessaryThingsIcon = iconRed;
                    } else {
                        necessaryThingsIcon = iconWhite;
                    }
                } else {
                    necessaryThingsIcon = iconWhite;
                }

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

                dm.addRow(new Object[]{incomingNumber, dateOfFlight, flightNumber, departure,
                        arrival, tailNumber, kvs, vp, necessaryThingsIcon, deadlineCorAction, corActAcceptedIcon, finalRisk, talonClosureIcon});
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
}