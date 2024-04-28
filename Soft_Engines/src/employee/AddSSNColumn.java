package employee;

import java.sql.*;

public class AddSSNColumn {
    public static void addSSNColumn(Connection myConn) {
        try {
            Statement myStmt = myConn.createStatement();

            ResultSet rs = myStmt.executeQuery("SHOW COLUMNS FROM employees WHERE Field = 'SSN'");
            if (rs.next()) {
                myStmt.executeUpdate("ALTER TABLE employees DROP COLUMN SSN");
                System.out.println("Existing SSN column dropped.");
            }
            
            String sqlCommand = "ALTER TABLE employees ADD COLUMN SSN INT NOT NULL;";
            myStmt.executeUpdate(sqlCommand);
            System.out.println("Report 4: SSN column added to the employees table successfully.");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}