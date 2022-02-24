package gym_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {

    public static void main(String[] args) {

        String url = "jdbc:mysql://sql107.epizy.com:3306/epiz_31145145_data";
        String userName = "epiz_31145145";
        String password = "iqSQClOfgl";
        String q = "select * from member";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
