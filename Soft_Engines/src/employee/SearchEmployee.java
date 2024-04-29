package employee;

import java.sql.*;
import java.util.Scanner;

public class SearchEmployee {
    public static void searchEmployee(Connection myConn) {
        Scanner scanner = new Scanner(System.in);

        try {
            Statement myStmt = myConn.createStatement();

            System.out.println();
            System.out.print("Enter SSN or employee ID: ");
            String searchTerm = scanner.nextLine();

            String sqlCommand = "SELECT e.empid, e.Fname, e.Lname, e.email, e.HireDate, e.Salary, e.SSN, jt.job_title " +
                    "FROM employees e " +
                    "JOIN employee_job_titles ejt ON e.empid = ejt.empid " +
                    "JOIN job_titles jt ON ejt.job_title_id = jt.job_title_id " +
                    "WHERE e.Fname LIKE '%" + searchTerm + "%' OR e.Lname LIKE '%" + searchTerm + "%' OR e.SSN = " + searchTerm + " OR e.empid = " + searchTerm + ";";

            ResultSet myRS = myStmt.executeQuery(sqlCommand);

            System.out.println("\nReport 5: Employee Search Results");

            if (!myRS.isBeforeFirst()) {
                System.out.println("No employees found matching the search term: " + searchTerm);
            } else {
                while (myRS.next()) {
                    System.out.println("Employee ID: " + myRS.getInt("e.empid"));
                    System.out.println("Name: " + myRS.getString("e.Fname") + " " + myRS.getString("e.Lname"));
                    System.out.println("Email: " + myRS.getString("e.email"));
                    System.out.println("Hire Date: " + myRS.getDate("e.HireDate"));
                    System.out.println("Salary: " + myRS.getDouble("e.Salary"));
                    System.out.println("SSN: " + myRS.getInt("e.SSN"));
                    System.out.println("Job Title: " + myRS.getString("jt.job_title"));
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}