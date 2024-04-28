package employee;

import java.sql.*;
import java.util.Scanner;

public class UpdateEmployee {
    public static void updateEmployee(Connection myConn) {
        Scanner scanner = new Scanner(System.in);

        try {
            Statement myStmt = myConn.createStatement();

            System.out.print("Enter the employee ID of the employee you want to update: ");
            int empID = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String sqlCommand = "SELECT e.empid, e.Fname, e.Lname, e.email, e.HireDate, e.Salary, e.SSN, jt.job_title " +
                    "FROM employees e " +
                    "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
                    "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id " +
                    "WHERE e.empid = " + empID + ";";

            ResultSet myRS = myStmt.executeQuery(sqlCommand);

            if (!myRS.isBeforeFirst()) {
                System.out.println("No employee found with ID: " + empID);
            } else {
                myRS.next();
                System.out.println("\nReport 6: Update Employee Data");
                System.out.println("Current Employee Information:");
                System.out.println("Employee ID: " + myRS.getInt("e.empid"));
                System.out.println("Name: " + myRS.getString("e.Fname") + " " + myRS.getString("e.Lname"));
                System.out.println("Email: " + myRS.getString("e.email"));
                System.out.println("Hire Date: " + myRS.getDate("e.HireDate"));
                System.out.println("Salary: " + myRS.getDouble("e.Salary"));
                System.out.println("SSN: " + myRS.getInt("e.SSN"));
                System.out.println("Job Title: " + myRS.getString("jt.job_title"));

                System.out.print("\nEnter the new first name (or press Enter to keep the same): ");
                String newFname = scanner.nextLine().trim();
                if (!newFname.isEmpty()) {
                    myStmt.executeUpdate("UPDATE employees SET Fname = '" + newFname + "' WHERE empid = " + empID + ";");
                }

                System.out.print("Enter the new last name (or press Enter to keep the same): ");
                String newLname = scanner.nextLine().trim();
                if (!newLname.isEmpty()) {
                    myStmt.executeUpdate("UPDATE employees SET Lname = '" + newLname + "' WHERE empid = " + empID + ";");
                }

                // Add code to update other fields as needed (email, HireDate, Salary, SSN)

                System.out.println("Employee data updated successfully.");
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}