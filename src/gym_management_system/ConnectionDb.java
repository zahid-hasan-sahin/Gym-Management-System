package gym_management_system;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionDb {

    static void addMember(Member mem) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "insert into member values(?,?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(q);
            st.setString(1, mem.getGmail());
            st.setString(2, mem.getName());
            st.setString(3, mem.getGender());
            st.setString(4, mem.getAge());
            st.setString(5, mem.getPhone());
            st.setString(6, mem.getAmount());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in database");
        }
    }

    public static boolean isExistMember(String gmail) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select * from member where gmail ='" + gmail + "'";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            return res.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return false;
    }
}
