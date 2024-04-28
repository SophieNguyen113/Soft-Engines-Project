package employee;

import java.sql.*;
import java.util.Scanner;

public class UpdateEmployeeSalary {
    public static void updateEmployeeSalary(Connection myConn) {
        Scanner scanner = new Scanner(System.in);

        try {
            Statement myStmt = myConn.createStatement();

            System.out.print("Enter the minimum salary for the range: ");
            double minSalary = scanner.nextDouble();

            System.out.print("Enter the maximum salary for the range: ");
            double maxSalary = scanner.nextDouble();

            System.out.print("Enter the percentage increase (e.g., 3.2): ");
            double percentageIncrease = scanner.nextDouble();

            String sqlCommand = "UPDATE employees " +
                    "SET Salary = Salary + (Salary * " + percentageIncrease + " / 100) " +
                    "WHERE Salary >= " + minSalary + " AND Salary < " + maxSalary + ";";

            int rowsAffected = myStmt.executeUpdate(sqlCommand);

            System.out.println("\nReport 7: Update Employee Salary");
            System.out.println("Salary updated for " + rowsAffected + " employee(s) with salaries between $" + minSalary + " and $" + maxSalary);
            System.out.println("Percentage increase applied: " + percentageIncrease + "%");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}