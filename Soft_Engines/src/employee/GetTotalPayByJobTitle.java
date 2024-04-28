package employee;

import java.sql.*;

import DAO.TotalPayByJobTitle;

public class GetTotalPayByJobTitle {
    public static void generateReport2(Connection myConn) {
        StringBuilder output = new StringBuilder("");
        TotalPayByJobTitle payByJobTitle = new TotalPayByJobTitle();
        output.append("\nReport 2: Total pay for month by job title.\n");
        output.append(payByJobTitle.getTotalPayByJobTitle(myConn));
        System.out.println(output.toString());
    }
}