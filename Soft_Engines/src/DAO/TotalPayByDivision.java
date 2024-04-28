package DAO;

import java.sql.*;
import java.text.DecimalFormat;

public class TotalPayByDivision {
    private static final DecimalFormat FORMATTER = new DecimalFormat("#,###.00");

    public StringBuilder getTotalPayByDivision(Connection myConn) {
        StringBuilder output = new StringBuilder("");
        String sqlCommand = "SELECT d.Name AS division, SUM(p.earnings) AS total_earnings, SUM(p.fed_tax) AS total_fed_tax, " +
                "SUM(p.fed_med) AS total_fed_med, SUM(p.fed_SS) AS total_fed_ss, SUM(p.state_tax) AS total_state_tax, " +
                "SUM(p.retire_401k) AS total_retire_401k, SUM(p.health_care) AS total_health_care " +
                "FROM employees e " +
                "JOIN employee_division ed ON e.empid = ed.empid " +
                "JOIN division d ON ed.div_ID = d.ID " +
                "JOIN fulltime_payroll p ON e.empid = p.empid " +
                "GROUP BY d.Name " +
                "ORDER BY total_earnings DESC;";

        try {
            Statement myStmt = myConn.createStatement();
            output.append(String.format("%-25s%-25s%-25s%-25s%-20s%-20s%-20s%-20s\n", "Division", "Total Earnings", "Federal", "FedMed", "FedSS", "State", "401K", "HealthCare"));
            output.append(String.format("%-25s%-25s%-25s%-25s%-20s%-20s%-20s%-20s\n", "--------", "--------------", "-------", "------", "------", "-----", "----", "----------"));

            ResultSet myRS = myStmt.executeQuery(sqlCommand);

            while (myRS.next()) {
                output.append(String.format("%-25s%-25s%-25s%-25s%-20s%-20s%-20s%-20s\n",
                        myRS.getString("division"),
                        FORMATTER.format(myRS.getDouble("total_earnings")),
                        FORMATTER.format(myRS.getDouble("total_fed_tax")),
                        FORMATTER.format(myRS.getDouble("total_fed_med")),
                        FORMATTER.format(myRS.getDouble("total_fed_ss")),
                        FORMATTER.format(myRS.getDouble("total_state_tax")),
                        FORMATTER.format(myRS.getDouble("total_retire_401k")),
                        FORMATTER.format(myRS.getDouble("total_health_care"))));
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }

        return output;
    }
}