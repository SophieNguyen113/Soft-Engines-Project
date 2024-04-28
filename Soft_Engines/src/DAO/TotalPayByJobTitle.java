package DAO;

import java.sql.*;
import java.text.DecimalFormat;

public class TotalPayByJobTitle {
    private static final DecimalFormat FORMATTER = new DecimalFormat("#,###.00");

    public StringBuilder getTotalPayByJobTitle(Connection myConn) {
        StringBuilder output = new StringBuilder("");
        String sqlCommand = "SELECT jt.job_title, SUM(p.earnings) AS total_earnings, SUM(p.fed_tax) AS total_fed_tax, " +
                "SUM(p.fed_med) AS total_fed_med, SUM(p.fed_SS) AS total_fed_ss, SUM(p.state_tax) AS total_state_tax, " +
                "SUM(p.retire_401k) AS total_retire_401k, SUM(p.health_care) AS total_health_care " +
                "FROM employees e " +
                "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
                "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id " +
                "JOIN fulltime_payroll p ON e.empid = p.empid " +
                "GROUP BY jt.job_title " +
                "ORDER BY total_earnings DESC;";

        try {
            Statement myStmt = myConn.createStatement();
            output.append(String.format("%-25s%-25s%-25s%-25s%-20s%-20s%-20s%-20s\n", "Job Title", "Total Earnings", "Federal", "FedMed", "FedSS", "State", "401K", "HealthCare"));
            output.append(String.format("%-25s%-25s%-25s%-25s%-20s%-20s%-20s%-20s\n", "---------", "--------------", "-------", "------", "------", "-----", "----", "----------"));

            ResultSet myRS = myStmt.executeQuery(sqlCommand);

            while (myRS.next()) {
                output.append(String.format("%-25s%-25s%-25s%-25s%-20s%-20s%-20s%-20s\n",
                        myRS.getString("jt.job_title"),
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