package employee;

import java.sql.*;

import DAO.FulltimePayroll;

public class GetFulltimePayroll {
    public static void generateReport1(Connection myConn) {
        StringBuilder output = new StringBuilder("");
        String sqlCommand = "SELECT e.Fname, e.Lname, e.email, jt.job_title, e.empid " +
                            "FROM employees e " +
                            "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
                            "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id " +
                            "ORDER BY e.empid;";

        try {
            Statement myStmt = myConn.createStatement();
            output.append("\nReport 1: Full-time employee information with pay statement history.\n");
            ResultSet myRS = myStmt.executeQuery(sqlCommand);

            while (myRS.next()) {
                output.append("Name= " + myRS.getString("e.Fname") + " " + myRS.getString("e.Fname") + "\t");
                output.append("Title=" + myRS.getString("jt.job_title") + " " + myRS.getString("e.email") + "\n");
                System.out.print(output.toString());
                output.setLength(0);
                FulltimePayroll p1 = new FulltimePayroll();
                output.append(p1.getPayByMonth(myRS.getInt("e.empid"), myConn));
            }

            System.out.println(output.toString());
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}