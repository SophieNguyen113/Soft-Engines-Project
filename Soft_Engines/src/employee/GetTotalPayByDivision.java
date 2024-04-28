package employee;

import java.sql.*;
import DAO.TotalPayByDivision;

public class GetTotalPayByDivision {
    public static void generateReport3(Connection myConn) {
        StringBuilder output = new StringBuilder("");
        TotalPayByDivision payByDivision = new TotalPayByDivision();
        output.append("\nReport 3: Total pay for month by division.\n");
        output.append(payByDivision.getTotalPayByDivision(myConn));
        System.out.println(output.toString());
    }
}