package employee;

import java.sql.*;

public class AddSSNColumn {
    public static void addSSNColumn(Connection myConn) {
        try {
            Statement myStmt = myConn.createStatement();

            // Check if the SSN column exists
            ResultSet rs = myStmt.executeQuery("SHOW COLUMNS FROM employees WHERE Field = 'SSN'");
            if (rs.next()) {
                // If the SSN column exists, drop it first
                myStmt.executeUpdate("ALTER TABLE employees DROP COLUMN SSN");
                System.out.println("Existing SSN column dropped.");
            }

            // Add the SSN column
            String sqlCommand = "ALTER TABLE employees ADD COLUMN SSN INT NOT NULL;";
            myStmt.executeUpdate(sqlCommand);
            System.out.println("Report 4: SSN column added to the employees table successfully.");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}