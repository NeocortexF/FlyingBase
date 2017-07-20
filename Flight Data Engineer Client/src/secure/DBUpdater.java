/*
 * класс подключение к ДБ
 * контролер для окна выбора. 
 */
package secure;


import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class DBUpdater extends JFrame {

    ImageIcon iconOK = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/eye2.png")));
    ImageIcon iconError = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/pencil.png")));

    //retrieve data 
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
        dm.addColumn("Принято и отправлено");

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

                if (acceptedGOPI != null) {
                    if (airFASE2 != 0) {
                        dm.addRow(new Object[]{incomingNumber, processingDate, dateOfFlight, flightNumber, departure,
                                arrival, tailNumber, airFASE1, airFASE2, processedGOPI, iconOK});
                    } else {
                        dm.addRow(new Object[]{incomingNumber, processingDate, dateOfFlight, flightNumber, departure,
                                arrival, tailNumber, airFASE1, pusto, processedGOPI, iconOK});
                    }
                } else {
                    if (airFASE2 != 0) {
                        dm.addRow(new Object[]{incomingNumber, processingDate, dateOfFlight, flightNumber, departure,
                                arrival, tailNumber, airFASE1, airFASE2, processedGOPI, iconError});
                    } else {
                        dm.addRow(new Object[]{incomingNumber, processingDate, dateOfFlight, flightNumber, departure,
                                arrival, tailNumber, airFASE1, pusto, processedGOPI, iconError});
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
}
