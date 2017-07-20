package secure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StatisticDBUpdater {

    public int[] getDataForEvents(String dateStart, String dateFinish) {
        //Выбор статистики. Складывает кол-во повторений индексов риска. Создает массив
        //нулевой элемент - индекс риска, первый элемент его кол-во
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        int[] arrayOfCalulatedRisks = new int[3];
        int greenRiskQuantity = 0;
        int yellowRiskQuantity = 0;
        int redRiskQuantity = 0;

        String sql = "SELECT Risk_index, COUNT(*) FROM flightdata where"
                + " date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')"
                + " >= '" + dateStart + "' and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')"
                + " < '" + dateFinish + "' GROUP BY Risk_index";

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);

            while (rs.next()) {
                int riskIndex = rs.getInt(1);
                int calculation = rs.getInt(2);

                if (riskIndex != 0) {
                    if (riskIndex <= 19) {
                        greenRiskQuantity = greenRiskQuantity + calculation;
                    } else if (riskIndex >= 20 && riskIndex < 100) {
                        yellowRiskQuantity = yellowRiskQuantity + calculation;
                    } else if (riskIndex >= 100) {
                        redRiskQuantity = redRiskQuantity + calculation;
                    }
                }
            }
            arrayOfCalulatedRisks[0] = greenRiskQuantity;
            arrayOfCalulatedRisks[1] = yellowRiskQuantity;
            arrayOfCalulatedRisks[2] = redRiskQuantity;

            return arrayOfCalulatedRisks;
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

    public Object[] getDataHighRiskTrend(String dateStart, String dateFinish) {
        //Выбор статистики. Складывает кол-во повторений индексов риска. Создает массив
        //нулевой элемент - индекс риска, первый элемент его кол-во
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT Risk_index, COUNT(Risk_index), Date_of_flight FROM flightdata where"
                + " (date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')"
                + " >= '" + dateStart + "' and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')"
                + " < '" + dateFinish + "') and Risk_index > 99 GROUP BY month(Date_of_flight) "
                + "ORDER BY date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList list = new ArrayList();
            while (rs.next()) {
                Object riskAccountedInSQL = rs.getObject(2);
                Object dateFromSQLForParsing = rs.getObject(3);
                list.add(riskAccountedInSQL);
                list.add(dateFromSQLForParsing);
            }
            Object calculatedHighRisk[] = list.toArray();

            return calculatedHighRisk;
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

    public Object[] getDataLowRiskTrend(String dateStart, String dateFinish) {
        //Выбор статистики. Складывает кол-во повторений индексов риска. Создает массив
        //нулевой элемент - индекс риска, первый элемент его кол-во
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT Risk_index, COUNT(Risk_index), Date_of_flight FROM flightdata where"
                + " (date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')"
                + " >= '" + dateStart + "' and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')"
                + " < '" + dateFinish + "') and (Risk_index > 0 and Risk_index < 20) GROUP BY month(Date_of_flight)"
                + "ORDER BY date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList list = new ArrayList();
            while (rs.next()) {
                Object riskAccountedInSQL = rs.getObject(2);
                Object dateFromSQLForParsing = rs.getObject(3);
                list.add(riskAccountedInSQL);
                list.add(dateFromSQLForParsing);
            }
            Object calculatedHighRisk[] = list.toArray();

            return calculatedHighRisk;
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

    public Object[] getDataMidRiskTrend(String dateStart, String dateFinish) {
        //Выбор статистики. Складывает кол-во повторений индексов риска. Создает массив
        //нулевой элемент - индекс риска, первый элемент его кол-во
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT Risk_index, COUNT(Risk_index), Date_of_flight FROM flightdata where"
                + " (date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')"
                + " >= '" + dateStart + "' and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')"
                + " < '" + dateFinish + "') and (Risk_index > 19 and Risk_index < 99) GROUP BY month(Date_of_flight)"
                + "ORDER BY date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d')";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList list = new ArrayList();
            while (rs.next()) {
                Object riskAccountedInSQL = rs.getObject(2);
                Object dateFromSQLForParsing = rs.getObject(3);
                list.add(riskAccountedInSQL);
                list.add(dateFromSQLForParsing);
            }
            Object calculatedHighRisk[] = list.toArray();

            return calculatedHighRisk;
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

    public String getFirstRow() {

        String rowString = "";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT Date_of_flight FROM flightdata ORDER BY flightdata_id LIMIT 1";

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            rs.last();
            String dateOfFlight = rs.getString(1);
            return dateOfFlight;
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

    public String getLastRow() {

        String rowString = "";
        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT Date_of_flight FROM flightdata ORDER BY flightdata_id DESC LIMIT 1";

        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            rs.last();
            String dateOfFlight = rs.getString(1);
            return dateOfFlight;
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

    public Object[] getDataMoreOften(String dateStart, String dateFinish) {

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "select test_column, COUNT(test_column) From "
                + "(SELECT Event_AirFASE_1 as test_column FROM flightdata where "
                + "(date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "') "
                + "union all "
                + "SELECT Event_AirFASE_2 FROM flightdata where "
                + "(date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "') "
                + "union all "
                + "SELECT Event_AirFASE_3 FROM flightdata where "
                + "(date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "') "
                + "union all "
                + "SELECT Event_AirFASE_4 FROM flightdata where "
                + "(date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "')"
                + ") sq "
                + "group by test_column order by count(test_column) desc;";


        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList list = new ArrayList();
            while (rs.next()) {
                Object riskAccountedInSQL = rs.getObject(1);
                Object dateFromSQLForParsing = rs.getObject(2);
                list.add(riskAccountedInSQL);
                list.add(dateFromSQLForParsing);
            }
            Object calculatedHighRisk[] = list.toArray();

            return calculatedHighRisk;
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

    public Object[] getDataPilotsSummary(String dateStart, String dateFinish) {

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT test_column, COUNT(test_column) "
                + "FROM (SELECT KVS AS test_column FROM flightdata "
                + "WHERE (DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "AND DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "') UNION ALL SELECT "
                + "VP FROM flightdata "
                + "WHERE (DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' AND "
                + "DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "')) sq "
                + "GROUP BY test_column ORDER BY COUNT(test_column) DESC;";


        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList list = new ArrayList();
            while (rs.next()) {
                Object riskAccountedInSQL = rs.getObject(1);
                Object dateFromSQLForParsing = rs.getObject(2);
                list.add(riskAccountedInSQL);
                list.add(dateFromSQLForParsing);
            }
            Object calculatedHighRisk[] = list.toArray();

            return calculatedHighRisk;
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

    public Object[] getDataCaptainPF(String dateStart, String dateFinish, String eventId) {

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT KVS, COUNT(KVS) FROM flightdata WHERE PF = 'КВС' "
                + "AND (Event_AirFASE_1 = '" + eventId + "' "
                + "OR Event_AirFASE_2 = '" + eventId + "' "
                + "OR Event_AirFASE_3 = '" + eventId + "' "
                + "OR Event_AirFASE_4 = '" + eventId + "') "
                + "AND (DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "AND DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "') "
                + "GROUP BY KVS ORDER BY COUNT(KVS) DESC;";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList list = new ArrayList();
            while (rs.next()) {
                Object kvsID = rs.getObject(1);
                Object quantityOfEvents = rs.getObject(2);
                list.add(kvsID);
                list.add(quantityOfEvents);
            }
            Object calculatedHighRisk[] = list.toArray();

            return calculatedHighRisk;
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

    public Object[] getDataFirstOfficerPF(String dateStart, String dateFinish, String eventId) {

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT VP, COUNT(VP) FROM flightdata WHERE PF = '2П' "
                + "AND (Event_AirFASE_1 = '" + eventId + "' "
                + "OR Event_AirFASE_2 = '" + eventId + "' "
                + "OR Event_AirFASE_3 = '" + eventId + "' "
                + "OR Event_AirFASE_4 = '" + eventId + "') "
                + "AND (DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "AND DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "') "
                + "GROUP BY VP ORDER BY COUNT(VP) DESC;";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList list = new ArrayList();
            while (rs.next()) {
                Object kvsID = rs.getObject(1);
                Object quantityOfEvents = rs.getObject(2);
                list.add(kvsID);
                list.add(quantityOfEvents);
            }
            Object calculatedHighRisk[] = list.toArray();

            return calculatedHighRisk;
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

    public Object[] getDataCaptainCrew(String dateStart, String dateFinish, String eventId) {

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "SELECT KVS, COUNT(KVS) FROM flightdata WHERE "
                + "(Event_AirFASE_1 = '" + eventId + "' "
                + "OR Event_AirFASE_2 = '" + eventId + "' "
                + "OR Event_AirFASE_3 = '" + eventId + "' "
                + "OR Event_AirFASE_4 = '" + eventId + "') "
                + "AND (DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "AND DATE_FORMAT(STR_TO_DATE(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "') "
                + "GROUP BY KVS ORDER BY COUNT(KVS) DESC;";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList list = new ArrayList();
            while (rs.next()) {
                Object kvsID = rs.getObject(1);
                Object quantityOfEvents = rs.getObject(2);
                list.add(kvsID);
                list.add(quantityOfEvents);
            }
            Object calculatedHighRisk[] = list.toArray();

            return calculatedHighRisk;
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

    public Object[] getDataIndividual(String dateStart, String dateFinish, String pilotId) {

        Connection con = null;
        Statement s = null;
        ResultSet rs = null;
        String sql = "select test_column, COUNT(test_column) From "
                + "(SELECT Event_AirFASE_1 as test_column FROM flightdata "
                + "where (date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "' and KVS = '" + pilotId + "')"
                + "union all "
                + "SELECT Event_AirFASE_2 FROM flightdata "
                + "where (date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "' and KVS = '" + pilotId + "')"
                + "union all "
                + "SELECT Event_AirFASE_3 FROM flightdata "
                + "where (date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "' and KVS = '" + pilotId + "') "
                + "union all "
                + "SELECT Event_AirFASE_4 FROM flightdata "
                + "where (date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') >= '" + dateStart + "' "
                + "and date_format(str_to_date(Date_of_flight, '%d.%m.%Y'), '%Y-%m-%d') < '" + dateFinish + "' and KVS = '" + pilotId + "'))sq "
                + "group by test_column order by count(test_column) desc;";
        try {
            con = DriverManager.getConnection(Main.conIninialiazedStr, Main.username, Main.password);
            s = con.prepareStatement(sql);
            rs = s.executeQuery(sql);
            ArrayList list = new ArrayList();
            while (rs.next()) {
                Object eventID = rs.getObject(1);
                Object quantityOfEvents = rs.getObject(2);
                list.add(eventID);
                list.add(quantityOfEvents);
            }
            Object calculatedHighRisk[] = list.toArray();

            return calculatedHighRisk;
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
