package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import employee.AddSSNColumn;
import employee.GetFulltimePayroll;
import employee.GetTotalPayByDivision;
import employee.GetTotalPayByJobTitle;
import employee.SearchEmployee;
import employee.UpdateEmployee;
import employee.UpdateEmployeeSalary;

public class EmployeeManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "@Duyen123456";

        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("Employee Manager");
                System.out.println("1. Get Fulltime Payroll");
                System.out.println("2. Get Total Pay by Job Title");
                System.out.println("3. Get Total Pay by Division");
                System.out.println("4. Add SSN Column");
                System.out.println("5. Search Employee");
                System.out.println("6. Update Employee");
                System.out.println("7. Update Employee Salary");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        GetFulltimePayroll.generateReport1(myConn);
                        break;
                    case 2:
                        GetTotalPayByJobTitle.generateReport2(myConn);
                        break;
                    case 3:
                        GetTotalPayByDivision.generateReport3(myConn);
                        break;
                    case 4:
                        AddSSNColumn.addSSNColumn(myConn);
                        break;
                    case 5:
                        SearchEmployee.searchEmployee(myConn);
                        break;
                    case 6:
                        UpdateEmployee.updateEmployee(myConn);
                        break;
                    case 7:
                        UpdateEmployeeSalary.updateEmployeeSalary(myConn);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}