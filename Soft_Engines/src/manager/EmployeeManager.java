package manager;

import java.sql.*;
import employee.GetFulltimePayroll;

public class EmployeeManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeedata";
        String user = "root";
        String password = "@Duyen123456";

        try (Connection myConn = DriverManager.getConnection(url, user, password)) {
            GetFulltimePayroll.generateReport1(myConn);
            // Report2.generateReport2(myConn);

            myConn.close();
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }
}