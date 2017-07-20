package secure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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

    public DefaultTableModel getData() {
        DefaultTableModel dm = new DefaultTableModel() {
            //блокировка возможности редактирования ячеек таблицы
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dm.addColumn("№");
        dm.addColumn("Дата обработки");
        dm.addColumn("Дата полета");
        dm.addColumn("Рейс");
        dm.addColumn("Вылет");
        dm.addColumn("Прибытие");
        dm.addColumn("Борт. номер");
        dm.addColumn("AirFASE 1");
        dm.addColumn("AirFASE 2");
        dm.addColumn("Обработал(а)");
        dm.addColumn("Доступно для ЛО");

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM flightdata order by flightdata_id desc limit 3000";
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
                String airFASE1 = rs.getString(23);
                Integer airFASE2 = rs.getInt(26);
                String processedGOPI = rs.getString(35);
                String acceptedGOPI = rs.getString(36); // значком
                String pusto = "";

                if (acceptedGOPI == null || acceptedGOPI.equals(" ") || acceptedGOPI.equals("  ")) {
                    if (airFASE2 != 0) {
                        dm.addRow(new Object[]{incomingNumber, processingDate, dateOfFlight, flightNumber, departure,
                                arrival, tailNumber, airFASE1, airFASE2, processedGOPI, iconError});
                    } else {
                        dm.addRow(new Object[]{incomingNumber, processingDate, dateOfFlight, flightNumber, departure,
                                arrival, tailNumber, airFASE1, pusto, processedGOPI, iconError});
                    }
                } else {
                    if (airFASE2 != 0) {
                        dm.addRow(new Object[]{incomingNumber, processingDate, dateOfFlight, flightNumber, departure,
                                arrival, tailNumber, airFASE1, airFASE2, processedGOPI, iconOK});
                    } else {
                        dm.addRow(new Object[]{incomingNumber, processingDate, dateOfFlight, flightNumber, departure,
                                arrival, tailNumber, airFASE1, pusto, processedGOPI, iconOK});
                    }
                }
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

    //delete data                             
    public Boolean delete(String id) {
        Connection con = null;
        Statement s = null;
        String sql = "DELETE FROM flightdata WHERE Incoming_number = '" + id + "'";
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
}
