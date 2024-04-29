package employee;

import java.sql.*;
import java.util.Scanner;

public class UpdateEmployee {
    public static void updateEmployee(Connection myConn) {
        Scanner scanner = new Scanner(System.in);

        try {
            Statement myStmt = myConn.createStatement();

            System.out.println();
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
                System.out.println();
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
                
                System.out.print("Enter the new email (or press Enter to keep the same): ");
                String newEmail = scanner.nextLine().trim();
                if (!newEmail.isEmpty()) {
                    myStmt.executeUpdate("UPDATE employees SET email = '" + newEmail + "' WHERE empid = " + empID + ";");
                }

                System.out.print("Enter the new hire date in YYYY-MM-DD format (or press Enter to keep the same): ");
                String newHireDateStr = scanner.nextLine().trim();
                if (!newHireDateStr.isEmpty()) {
                    java.sql.Date newHireDate = java.sql.Date.valueOf(newHireDateStr);
                    myStmt.executeUpdate("UPDATE employees SET HireDate = '" + newHireDate + "' WHERE empid = " + empID + ";");
                }

                System.out.print("Enter the new salary (or press Enter to keep the same): ");
                String newSalaryStr = scanner.nextLine().trim();
                if (!newSalaryStr.isEmpty()) {
                    double newSalary = Double.parseDouble(newSalaryStr);
                    myStmt.executeUpdate("UPDATE employees SET Salary = " + newSalary + " WHERE empid = " + empID + ";");
                }

                System.out.print("Enter the new SSN (or press Enter to keep the same): ");
                String newSSNStr = scanner.nextLine().trim();
                if (!newSSNStr.isEmpty()) {
                    int newSSN = Integer.parseInt(newSSNStr);
                    myStmt.executeUpdate("UPDATE employees SET SSN = " + newSSN + " WHERE empid = " + empID + ";");
                }

                System.out.println();
                System.out.println("Employee data updated successfully.");
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}