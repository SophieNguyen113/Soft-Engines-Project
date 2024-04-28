package employee;

import java.sql.*;
import java.util.Random;

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
            System.out.println("Report 4: SSN column added to the Employees table successfully.");

            Random random = new Random();
            String updateQuery = "UPDATE employees SET SSN = ? WHERE empid = ?";
            PreparedStatement pstmt = myConn.prepareStatement(updateQuery);

            ResultSet employeesRS = myStmt.executeQuery("SELECT empid FROM employees");
            while (employeesRS.next()) {
                int empid = employeesRS.getInt("empid");
                int fakeSSN = random.nextInt(900000000) + 100000000; 
                pstmt.setInt(1, fakeSSN);
                pstmt.setInt(2, empid);
                pstmt.executeUpdate();
            }

            System.out.println("SSN data inserted successfully.");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}