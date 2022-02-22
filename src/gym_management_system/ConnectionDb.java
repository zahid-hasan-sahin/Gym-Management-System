package gym_management_system;

import java.sql.*;

public class ConnectionDb {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select name from member";
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(q);
        res.next();
        System.out.println(res.getString("name"));
    }
}
