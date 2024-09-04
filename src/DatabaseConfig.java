import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {

    private static final String URL = "jdbc:postgresql://localhost:5432/company_db";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /*

        String sql = "SELECT * FROM departments;";
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        rs.next();
        String departments =  rs.getString(2);

        System.out.println(departments);
        con.close();

        */
}
