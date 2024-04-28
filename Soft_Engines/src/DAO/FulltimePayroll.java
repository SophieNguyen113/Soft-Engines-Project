package DAO;

import java.sql.*;

public class FulltimePayroll {
    public StringBuilder getPayByMonth(int empID, Connection myConn) {
        StringBuilder output = new StringBuilder("");
        String sqlcommand1 = "SELECT e.empid, p.pay_date, p.earnings, p.fed_tax, " +
                "p.fed_med,p.fed_SS,p.state_tax,p.retire_401k,p.health_care  " +
                "FROM employees e " +
                "JOIN fulltime_payroll p ON e.empid = p.empid " +
                "WHERE e.empid = " + empID + " " +
                "ORDER BY p.pay_date;";
        try {
            Statement myStmt = myConn.createStatement();

            output.append("\tEMP ID\tPAY DATE\tGROSS\tFederal\tFedMed\tFedSS\tState\t401K\tHealthCare\n");
            ResultSet myRS1 = myStmt.executeQuery(sqlcommand1);
            while (myRS1.next()) {
                output.append("\t" + myRS1.getString("e.empid") + "\t");
                output.append(myRS1.getDate("p.pay_date") + "\t" + myRS1.getDouble("p.earnings") + "\t");
                output.append(myRS1.getDouble("p.fed_tax") + "\t" + myRS1.getDouble("p.fed_med") + "\t");
                output.append(myRS1.getDouble("p.fed_SS") + "\t" + myRS1.getDouble("p.state_tax") + "\t");
                output.append(myRS1.getDouble("p.retire_401K") + "\t" + myRS1.getDouble("p.health_care")+"\n" );
            }

        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        } 

        return output;
    }
}