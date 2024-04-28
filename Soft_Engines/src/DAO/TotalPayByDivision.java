package DAO;

import java.sql.*;

public class TotalPayByDivision {
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
            output.append("\tDivision\tTotal Earnings\tFederal\tFedMed\tFedSS\tState\t401K\tHealthCare\n");
            ResultSet myRS = myStmt.executeQuery(sqlCommand);

            while (myRS.next()) {
                output.append("\t" + myRS.getString("division") + "\t");
                output.append(myRS.getDouble("total_earnings") + "\t");
                output.append(myRS.getDouble("total_fed_tax") + "\t");
                output.append(myRS.getDouble("total_fed_med") + "\t");
                output.append(myRS.getDouble("total_fed_ss") + "\t");
                output.append(myRS.getDouble("total_state_tax") + "\t");
                output.append(myRS.getDouble("total_retire_401k") + "\t");
                output.append(myRS.getDouble("total_health_care") + "\n");
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }

        return output;
    }
}