package employee;

import java.sql.*;

import DAO.FulltimePayroll;

public class GetFulltimePayroll {
    public static void generateReport1(Connection myConn) {
        StringBuilder output = new StringBuilder("");
        FulltimePayroll payroll = new FulltimePayroll();
        output.append("\nReport 1: Full-time employee information with pay statement history.\n");
        output.append(payroll.getFulltimePayroll(myConn));
        System.out.println(output.toString());
    }
}