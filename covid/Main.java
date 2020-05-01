import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/mydb?";
        String user = "abhishek";
        String password = "password";

        String query = "select DISTINCT(StateUnionTerritory) from mytable order by StateUnionTerritory;";

        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query);
                ResultSet rs = pst.executeQuery()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int colcount = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= colcount; i++)
                    System.out.print(rs.getString(i) + " ");
                System.out.println();
            }

        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
}