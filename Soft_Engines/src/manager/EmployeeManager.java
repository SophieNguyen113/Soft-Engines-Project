package manager;

import java.sql.*;

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
            GetFulltimePayroll.generateReport1(myConn);
            GetTotalPayByJobTitle.generateReport2(myConn);
            GetTotalPayByDivision.generateReport3(myConn);
            AddSSNColumn.addSSNColumn(myConn);
            SearchEmployee.searchEmployee(myConn);
            UpdateEmployee.updateEmployee(myConn);
            UpdateEmployeeSalary.updateEmployeeSalary(myConn);

            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}