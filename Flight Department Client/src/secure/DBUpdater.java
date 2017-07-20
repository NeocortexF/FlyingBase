package secure;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class DBUpdater extends JFrame {

    ImageIcon iconOK = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/OK.png")));
    ImageIcon iconError = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Error.png")));
    ImageIcon iconYellow = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/yellow 16x32.png")));
    ImageIcon iconRed = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/red 16x32.png")));
    ImageIcon iconGreen = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/green 16x32.png")));
    ImageIcon iconOrange = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/orange 16x32.png")));
    ImageIcon iconWhite = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/clear.png")));

    public void testDataFromSQL() {
        //метод ТЕСТирования получаемых данных из БД
        //кнопка вызова - "обновить" в классе Welcome
        String sql = "select * from flightdata where Incoming_number = '16-756' limit 3000";
        String corActAccept;
        String talonClosure;

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                corActAccept = rs.getString(20);
                talonClosure = rs.getString(21);
                System.out.println("corActAccept = " + corActAccept + "\n" + "talonClosure = " + talonClosure);
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
    }

    public DefaultTableModel getData(int sqlFlag) {
        String AF1 = "";
        String aviaEscadraNumber = "";
        Object sigma = "";
        Object correctiveIsAccepted = "";
        String deadlineParsed = "";
        Object talonIsClosed = "";
        DefaultTableModel dm = new DefaultTableModel() {

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
        dm.addColumn("AirFASE 1");
        dm.addColumn("Номер АЭ");
        dm.addColumn("Исх. риск");
        dm.addColumn("Срок КД");
        dm.addColumn("КД одобрены");
        dm.addColumn("Риск");
        dm.addColumn("Талон закрыт");
        dm.addColumn("Ан");
        dm.addColumn("Кд");

        String sql = "";
        //флаги (для работы фильтров по радиокнопке): 
        //1 - показать все сообщения
        //2 - без низкого риска
        //3 - не закрытые
        //4 - не одобренные
        if (sqlFlag == 1) {
            sql = "select * from flightdata where Accepted_by_gopi is not null order by flightdata_id desc limit 3000";
        } else if (sqlFlag == 2) {
            sql = "select * from flightdata where Accepted_by_gopi is not null and Risk_index>19 order by flightdata_id desc limit 3000";
        } else if (sqlFlag == 3) {
            sql = "select * from flightdata where Accepted_by_gopi is not null and (Talon_closure = '' or ' ' or Talon_closure is null) order by flightdata_id desc limit 3000";
        } else if (sqlFlag == 4) {
            sql = "select * from flightdata where Accepted_by_gopi is not null and (Cor_act_accepted = '' or ' ' or Cor_act_accepted is null) order by flightdata_id desc limit 3000";
        }
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
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
                String airFASE1 = rs.getString(23);
                Object ae = rs.getObject(12);
                String sigmaRiskNesThing = rs.getString(17);
                String deadline = rs.getString(19);
                String corActAccept = rs.getString(20);
                String talonClosure = rs.getString(21);
                String finalRisk = rs.getString(38);
                String acceptedGOPI = rs.getString(36);
                Object analysis = rs.getObject(14);
                Object corAct = rs.getObject(15);
                //проверка на null номеров AirFASE
                if (airFASE1 == null) {
                    AF1 = "";
                } else {
                    AF1 = airFASE1.toString();
                }
                if (ae == null) {
                    aviaEscadraNumber = "";
                } else {
                    aviaEscadraNumber = ae.toString();
                }
                // замена рисков на картинки
                if (sigmaRiskNesThing == null || sigmaRiskNesThing.equals(" ") || sigmaRiskNesThing.equals("  ")) {
                    sigma = iconWhite;
                } else {
                    if (sigmaRiskNesThing.contains("8DFF41")) {
                        sigma = iconGreen;
                    } else if (sigmaRiskNesThing.contains("FFAC05")) {
                        sigma = iconOrange;
                    } else if (sigmaRiskNesThing.contains("EBFF14")) {
                        sigma = iconYellow;
                    } else if (sigmaRiskNesThing.contains("ПРАПИ")) {
                        sigma = iconRed;
                    } else {
                        sigma = iconWhite;
                    }
                }

                if (deadline == null || deadline.equals("") || deadline.equals(" ") || deadline.equals("  ") || deadline.equals("null")) {
                    deadline = deadlineParsed;
                }
                //корректирующие действия приняты
                if (corActAccept == null || corActAccept.equals("") || corActAccept.equals(" ") || corActAccept.equals("  ") || corActAccept.equals("null")) {
                    correctiveIsAccepted = iconError;
                } else {
                    correctiveIsAccepted = iconOK;
                }
                //талон закрыт
                if (talonClosure == null || talonClosure.equals("") || talonClosure.equals(" ") || talonClosure.equals("  ") || talonClosure.equals("null")) {
                    talonIsClosed = iconError;
                } else {
                    talonIsClosed = iconOK;
                }
                //финальная оценка риска
                if (acceptedGOPI == null || acceptedGOPI.equals(" ") || acceptedGOPI.equals("  ")) {
                } else {
                    dm.addRow(new Object[]{incomingNumber, dateOfFlight, flightNumber, departure, arrival, tailNumber,
                            AF1, aviaEscadraNumber, sigma, deadline, correctiveIsAccepted, finalRisk, talonIsClosed, analysis, corAct});
                }
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
        return dm;
    }

    public DefaultTableModel getDataFilterPilot(int pilotID) {
        String AF1 = "";
        String aviaEscadraNumber = "";
        Object sigma = "";
        Object correctiveIsAccepted = "";
        String deadlineParsed = "";
        Object talonIsClosed = "";
        DefaultTableModel dm = new DefaultTableModel() {

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
        dm.addColumn("AirFASE 1");
        dm.addColumn("Номер АЭ");
        dm.addColumn("Исх. риск");
        dm.addColumn("Срок КД");
        dm.addColumn("КД одобрены");
        dm.addColumn("Риск");
        dm.addColumn("Талон закрыт");
        dm.addColumn("Ан");
        dm.addColumn("Кд");

        String sql = "SELECT * FROM flightdata where kvs='" + pilotID + "' or VP = '" + pilotID + "' order by flightdata_id desc";

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
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
                String airFASE1 = rs.getString(23);
                Object ae = rs.getObject(12);
                String sigmaRiskNesThing = rs.getString(17);
                String deadline = rs.getString(19);
                String corActAccept = rs.getString(20);
                String talonClosure = rs.getString(21);
                String finalRisk = rs.getString(38);
                String acceptedGOPI = rs.getString(36);
                Object analysis = rs.getObject(14);
                Object corAct = rs.getObject(15);
                //проверка на null номеров AirFASE
                if (airFASE1 == null) {
                    AF1 = "";
                } else {
                    AF1 = airFASE1.toString();
                }
                if (ae == null) {
                    aviaEscadraNumber = "";
                } else {
                    aviaEscadraNumber = ae.toString();
                }
                // замена рисков на картинки
                if (sigmaRiskNesThing == null || sigmaRiskNesThing.equals(" ") || sigmaRiskNesThing.equals("  ")) {
                    sigma = iconWhite;
                } else {
                    if (sigmaRiskNesThing.contains("8DFF41")) {
                        sigma = iconGreen;
                    } else if (sigmaRiskNesThing.contains("FFAC05")) {
                        sigma = iconOrange;
                    } else if (sigmaRiskNesThing.contains("EBFF14")) {
                        sigma = iconYellow;
                    } else if (sigmaRiskNesThing.contains("ПРАПИ")) {
                        sigma = iconRed;
                    } else {
                        sigma = iconWhite;
                    }
                }

                if (deadline == null || deadline.equals("") || deadline.equals(" ") || deadline.equals("  ") || deadline.equals("null")) {
                    deadline = deadlineParsed;
                }
                //корректирующие действия приняты
                if (corActAccept == null || corActAccept.equals("") || corActAccept.equals(" ") || corActAccept.equals("  ") || corActAccept.equals("null")) {
                    correctiveIsAccepted = iconError;
                } else {
                    correctiveIsAccepted = iconOK;
                }
                //талон закрыт
                if (talonClosure == null || talonClosure.equals("") || talonClosure.equals(" ") || talonClosure.equals("  ") || talonClosure.equals("null")) {
                    talonIsClosed = iconError;
                } else {
                    talonIsClosed = iconOK;
                }
                //финальная оценка риска
                if (acceptedGOPI == null || acceptedGOPI.equals(" ") || acceptedGOPI.equals("  ")) {
                } else {
                    dm.addRow(new Object[]{incomingNumber, dateOfFlight, flightNumber, departure, arrival, tailNumber,
                            AF1, aviaEscadraNumber, sigma, deadline, correctiveIsAccepted, finalRisk, talonIsClosed, analysis, corAct});
                }
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
        return dm;
    }

    public DefaultTableModel getDataFilterEvent(int eventID) {
        String AF1 = "";
        String aviaEscadraNumber = "";
        Object sigma = "";
        Object correctiveIsAccepted = "";
        String deadlineParsed = "";
        Object talonIsClosed = "";
        DefaultTableModel dm = new DefaultTableModel() {

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
        dm.addColumn("AirFASE 1");
        dm.addColumn("Номер АЭ");
        dm.addColumn("Исх. риск");
        dm.addColumn("Срок КД");
        dm.addColumn("КД одобрены");
        dm.addColumn("Риск");
        dm.addColumn("Талон закрыт");
        dm.addColumn("Ан");
        dm.addColumn("Кд");

        String sql = "SELECT * FROM flightdata where Event_AirFASE_1='" + eventID + "' or Event_AirFASE_2='" + eventID + "' or Event_AirFASE_3='" + eventID + "' or Event_AirFASE_4='" + eventID + "' order by flightdata_id desc";

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
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
                String airFASE1 = rs.getString(23);
                Object ae = rs.getObject(12);
                String sigmaRiskNesThing = rs.getString(17);
                String deadline = rs.getString(19);
                String corActAccept = rs.getString(20);
                String talonClosure = rs.getString(21);
                String finalRisk = rs.getString(38);
                String acceptedGOPI = rs.getString(36);
                Object analysis = rs.getObject(14);
                Object corAct = rs.getObject(15);
                //проверка на null номеров AirFASE
                if (airFASE1 == null) {
                    AF1 = "";
                } else {
                    AF1 = airFASE1.toString();
                }
                if (ae == null) {
                    aviaEscadraNumber = "";
                } else {
                    aviaEscadraNumber = ae.toString();
                }
                // замена рисков на картинки
                if (sigmaRiskNesThing == null || sigmaRiskNesThing.equals(" ") || sigmaRiskNesThing.equals("  ")) {
                    sigma = iconWhite;
                } else {
                    if (sigmaRiskNesThing.contains("8DFF41")) {
                        sigma = iconGreen;
                    } else if (sigmaRiskNesThing.contains("FFAC05")) {
                        sigma = iconOrange;
                    } else if (sigmaRiskNesThing.contains("EBFF14")) {
                        sigma = iconYellow;
                    } else if (sigmaRiskNesThing.contains("ПРАПИ")) {
                        sigma = iconRed;
                    } else {
                        sigma = iconWhite;
                    }
                }

                if (deadline == null || deadline.equals("") || deadline.equals(" ") || deadline.equals("  ") || deadline.equals("null")) {
                    deadline = deadlineParsed;
                }
                //корректирующие действия приняты
                if (corActAccept == null || corActAccept.equals("") || corActAccept.equals(" ") || corActAccept.equals("  ") || corActAccept.equals("null")) {
                    correctiveIsAccepted = iconError;
                } else {
                    correctiveIsAccepted = iconOK;
                }
                //талон закрыт
                if (talonClosure == null || talonClosure.equals("") || talonClosure.equals(" ") || talonClosure.equals("  ") || talonClosure.equals("null")) {
                    talonIsClosed = iconError;
                } else {
                    talonIsClosed = iconOK;
                }
                //финальная оценка риска
                if (acceptedGOPI == null || acceptedGOPI.equals(" ") || acceptedGOPI.equals("  ")) {
                } else {
                    dm.addRow(new Object[]{incomingNumber, dateOfFlight, flightNumber, departure, arrival, tailNumber,
                            AF1, aviaEscadraNumber, sigma, deadline, correctiveIsAccepted, finalRisk, talonIsClosed, analysis, corAct});
                }
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
        return dm;
    }

    public DefaultTableModel getDataFilterDeparture(String codeICAO) {
        String AF1 = "";
        String aviaEscadraNumber = "";
        Object sigma = "";
        Object correctiveIsAccepted = "";
        String deadlineParsed = "";
        Object talonIsClosed = "";
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
        dm.addColumn("AirFASE 1");
        dm.addColumn("Номер АЭ");
        dm.addColumn("Исх. риск");
        dm.addColumn("Срок КД");
        dm.addColumn("КД одобрены");
        dm.addColumn("Риск");
        dm.addColumn("Талон закрыт");
        dm.addColumn("Ан");
        dm.addColumn("Кд");

        String sql = "SELECT * FROM flightdata where Departure='" + codeICAO + "' order by flightdata_id desc";

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
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
                String airFASE1 = rs.getString(23);
                Object ae = rs.getObject(12);
                String sigmaRiskNesThing = rs.getString(17);
                String deadline = rs.getString(19);
                String corActAccept = rs.getString(20);
                String talonClosure = rs.getString(21);
                String finalRisk = rs.getString(38);
                String acceptedGOPI = rs.getString(36);
                Object analysis = rs.getObject(14);
                Object corAct = rs.getObject(15);
                //проверка на null номеров AirFASE
                if (airFASE1 == null) {
                    AF1 = "";
                } else {
                    AF1 = airFASE1.toString();
                }
                if (ae == null) {
                    aviaEscadraNumber = "";
                } else {
                    aviaEscadraNumber = ae.toString();
                }
                // замена рисков на картинки
                if (sigmaRiskNesThing == null || sigmaRiskNesThing.equals(" ") || sigmaRiskNesThing.equals("  ")) {
                    sigma = iconWhite;
                } else {
                    if (sigmaRiskNesThing.contains("8DFF41")) {
                        sigma = iconGreen;
                    } else if (sigmaRiskNesThing.contains("FFAC05")) {
                        sigma = iconOrange;
                    } else if (sigmaRiskNesThing.contains("EBFF14")) {
                        sigma = iconYellow;
                    } else if (sigmaRiskNesThing.contains("ПРАПИ")) {
                        sigma = iconRed;
                    } else {
                        sigma = iconWhite;
                    }
                }

                if (deadline == null || deadline.equals("") || deadline.equals(" ") || deadline.equals("  ") || deadline.equals("null")) {
                    deadline = deadlineParsed;
                }
                //корректирующие действия приняты
                if (corActAccept == null || corActAccept.equals("") || corActAccept.equals(" ") || corActAccept.equals("  ") || corActAccept.equals("null")) {
                    correctiveIsAccepted = iconError;
                } else {
                    correctiveIsAccepted = iconOK;
                }
                //талон закрыт
                if (talonClosure == null || talonClosure.equals("") || talonClosure.equals(" ") || talonClosure.equals("  ") || talonClosure.equals("null")) {
                    talonIsClosed = iconError;
                } else {
                    talonIsClosed = iconOK;
                }
                //финальная оценка риска
                if (acceptedGOPI == null || acceptedGOPI.equals(" ") || acceptedGOPI.equals("  ")) {
                } else {
                    dm.addRow(new Object[]{incomingNumber, dateOfFlight, flightNumber, departure, arrival, tailNumber,
                            AF1, aviaEscadraNumber, sigma, deadline, correctiveIsAccepted, finalRisk, talonIsClosed, analysis, corAct});
                }
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
        return dm;
    }

    public DefaultTableModel getDataFilterArrival(String codeICAO) {
        String AF1 = "";
        String aviaEscadraNumber = "";
        Object sigma = "";
        Object correctiveIsAccepted = "";
        String deadlineParsed = "";
        Object talonIsClosed = "";
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
        dm.addColumn("AirFASE 1");
        dm.addColumn("Номер АЭ");
        dm.addColumn("Исх. риск");
        dm.addColumn("Срок КД");
        dm.addColumn("КД одобрены");
        dm.addColumn("Риск");
        dm.addColumn("Талон закрыт");
        dm.addColumn("Ан");
        dm.addColumn("Кд");

        String sql = "SELECT * FROM flightdata where Arrival='" + codeICAO + "' order by flightdata_id desc";

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
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
                String airFASE1 = rs.getString(23);
                Object ae = rs.getObject(12);
                String sigmaRiskNesThing = rs.getString(17);
                String deadline = rs.getString(19);
                String corActAccept = rs.getString(20);
                String talonClosure = rs.getString(21);
                String finalRisk = rs.getString(38);
                String acceptedGOPI = rs.getString(36);
                Object analysis = rs.getObject(14);
                Object corAct = rs.getObject(15);
                //проверка на null номеров AirFASE
                if (airFASE1 == null) {
                    AF1 = "";
                } else {
                    AF1 = airFASE1.toString();
                }
                if (ae == null) {
                    aviaEscadraNumber = "";
                } else {
                    aviaEscadraNumber = ae.toString();
                }
                // замена рисков на картинки
                if (sigmaRiskNesThing == null || sigmaRiskNesThing.equals(" ") || sigmaRiskNesThing.equals("  ")) {
                    sigma = iconWhite;
                } else {
                    if (sigmaRiskNesThing.contains("8DFF41")) {
                        sigma = iconGreen;
                    } else if (sigmaRiskNesThing.contains("FFAC05")) {
                        sigma = iconOrange;
                    } else if (sigmaRiskNesThing.contains("EBFF14")) {
                        sigma = iconYellow;
                    } else if (sigmaRiskNesThing.contains("ПРАПИ")) {
                        sigma = iconRed;
                    } else {
                        sigma = iconWhite;
                    }
                }

                if (deadline == null || deadline.equals("") || deadline.equals(" ") || deadline.equals("  ") || deadline.equals("null")) {
                    deadline = deadlineParsed;
                }
                //корректирующие действия приняты
                if (corActAccept == null || corActAccept.equals("") || corActAccept.equals(" ") || corActAccept.equals("  ") || corActAccept.equals("null")) {
                    correctiveIsAccepted = iconError;
                } else {
                    correctiveIsAccepted = iconOK;
                }
                //талон закрыт
                if (talonClosure == null || talonClosure.equals("") || talonClosure.equals(" ") || talonClosure.equals("  ") || talonClosure.equals("null")) {
                    talonIsClosed = iconError;
                } else {
                    talonIsClosed = iconOK;
                }
                //финальная оценка риска
                if (acceptedGOPI == null || acceptedGOPI.equals(" ") || acceptedGOPI.equals("  ")) {
                } else {
                    dm.addRow(new Object[]{incomingNumber, dateOfFlight, flightNumber, departure, arrival, tailNumber,
                            AF1, aviaEscadraNumber, sigma, deadline, correctiveIsAccepted, finalRisk, talonIsClosed, analysis, corAct});
                }
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
        return dm;
    }

    public DefaultTableModel getDataFilterTail(String tailNumberOfAc) {
        String AF1 = "";
        String aviaEscadraNumber = "";
        Object sigma = "";
        Object correctiveIsAccepted = "";
        String deadlineParsed = "";
        Object talonIsClosed = "";
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
        dm.addColumn("AirFASE 1");
        dm.addColumn("Номер АЭ");
        dm.addColumn("Исх. риск");
        dm.addColumn("Срок КД");
        dm.addColumn("КД одобрены");
        dm.addColumn("Риск");
        dm.addColumn("Талон закрыт");
        dm.addColumn("Ан");
        dm.addColumn("Кд");

        String sql = "SELECT * FROM flightdata where Tail_number='" + tailNumberOfAc + "' order by flightdata_id desc";

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
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
                String airFASE1 = rs.getString(23);
                Object ae = rs.getObject(12);
                String sigmaRiskNesThing = rs.getString(17);
                String deadline = rs.getString(19);
                String corActAccept = rs.getString(20);
                String talonClosure = rs.getString(21);
                String finalRisk = rs.getString(38);
                String acceptedGOPI = rs.getString(36);
                Object analysis = rs.getObject(14);
                Object corAct = rs.getObject(15);
                //проверка на null номеров AirFASE
                if (airFASE1 == null) {
                    AF1 = "";
                } else {
                    AF1 = airFASE1.toString();
                }
                if (ae == null) {
                    aviaEscadraNumber = "";
                } else {
                    aviaEscadraNumber = ae.toString();
                }
                // замена рисков на картинки
                if (sigmaRiskNesThing == null || sigmaRiskNesThing.equals(" ") || sigmaRiskNesThing.equals("  ")) {
                    sigma = iconWhite;
                } else {
                    if (sigmaRiskNesThing.contains("8DFF41")) {
                        sigma = iconGreen;
                    } else if (sigmaRiskNesThing.contains("FFAC05")) {
                        sigma = iconOrange;
                    } else if (sigmaRiskNesThing.contains("EBFF14")) {
                        sigma = iconYellow;
                    } else if (sigmaRiskNesThing.contains("ПРАПИ")) {
                        sigma = iconRed;
                    } else {
                        sigma = iconWhite;
                    }
                }

                if (deadline == null || deadline.equals("") || deadline.equals(" ") || deadline.equals("  ") || deadline.equals("null")) {
                    deadline = deadlineParsed;
                }
                //корректирующие действия приняты
                if (corActAccept == null || corActAccept.equals("") || corActAccept.equals(" ") || corActAccept.equals("  ") || corActAccept.equals("null")) {
                    correctiveIsAccepted = iconError;
                } else {
                    correctiveIsAccepted = iconOK;
                }
                //талон закрыт
                if (talonClosure == null || talonClosure.equals("") || talonClosure.equals(" ") || talonClosure.equals("  ") || talonClosure.equals("null")) {
                    talonIsClosed = iconError;
                } else {
                    talonIsClosed = iconOK;
                }
                //финальная оценка риска
                if (acceptedGOPI == null || acceptedGOPI.equals(" ") || acceptedGOPI.equals("  ")) {
                } else {
                    dm.addRow(new Object[]{incomingNumber, dateOfFlight, flightNumber, departure, arrival, tailNumber,
                            AF1, aviaEscadraNumber, sigma, deadline, correctiveIsAccepted, finalRisk, talonIsClosed, analysis, corAct});
                }
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
        return dm;
    }

    public DefaultTableModel getDataForAnalysis(String date) {

        DefaultTableModel dm = new DefaultTableModel() {

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

        String sql = "select * from flightdata where Risk_index>19 and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + date + "' order by flightdata_id desc";

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            while (rs.next()) {
                //получаем значения
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

    public Object[] getTextToFileForAnalysis(String date) {

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        Object[] events = null;

        String sql = "select * from flightdata where Risk_index>19 and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + date + "'";

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList eventList = new ArrayList();
            String textForFile = null;
            while (rs.next()) {
                //получаем значения

                String dateOfFlight = rs.getString(4);
                String flightNumber = rs.getString(5);
                String departure = rs.getString(6);
                String arrival = rs.getString(7);
                String tailNumber = rs.getString(8);
                String correctiveAction = rs.getString(15);
                String EventClass1 = rs.getString(22);
                String EventClass2 = rs.getString(25);
                String EventClass3 = rs.getString(28);
                String EventClass4 = rs.getString(31);
                String EventAirF1 = rs.getString(23);
                String EventAirF2 = rs.getString(26);
                String EventAirF3 = rs.getString(29);
                String EventAirF4 = rs.getString(32);

                StringBuilder sb = new StringBuilder();
                sb.append(dateOfFlight);
                sb.append("г. При выполнении рейса №");
                sb.append(flightNumber);
                sb.append(" на самолёте A");
                sb.append(tailNumber);
                sb.append(" по маршруту ");
                sb.append(departure);
                sb.append(" - ");
                sb.append(arrival);
                sb.append(" программой “Air FASE” зафиксировано событие: ");
                sb.append(System.getProperty("line.separator"));
                sb.append(EventClass1);
                sb.append(" ");
                sb.append(EventAirF1);
                sb.append(" ");
                sb.append(EventClass2);
                sb.append(" ");
                sb.append(EventAirF2);
                sb.append(" ");
                sb.append(EventClass3);
                sb.append(" ");
                sb.append(EventAirF3);
                sb.append(" ");
                sb.append(EventClass4);
                sb.append(" ");
                sb.append(EventAirF4);
                sb.append(System.getProperty("line.separator"));
                sb.append("Заключение:");
                sb.append(System.getProperty("line.separator"));
                sb.append("Мероприятия:");
                sb.append(System.getProperty("line.separator"));
                sb.append(correctiveAction);
                sb.append(System.getProperty("line.separator"));
                sb.append(System.getProperty("line.separator"));

                textForFile = sb.toString();
                eventList.add(textForFile);
            }
            events = eventList.toArray();
            return events;
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
}
