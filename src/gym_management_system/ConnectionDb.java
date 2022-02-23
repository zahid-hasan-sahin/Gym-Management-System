package gym_management_system;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConnectionDb {

    static void addMember(Member mem) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "insert into member values(?,?,?,?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(q);
            st.setString(1, mem.getGmail());
            st.setString(2, mem.getName());
            st.setString(3, mem.getGender());
            st.setString(4, mem.getAge());
            st.setString(5, mem.getPhone());
            st.setString(6, mem.getTime());
            st.setString(7, mem.getAmount());
            st.executeUpdate();
        } catch (Exception e) {

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

    public static ArrayList<String> getGmailList() {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select gmail from member;";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);

            ArrayList<String> ar = new ArrayList<String>();
            while (res.next()) {
                ar.add(res.getString("gmail"));
            }

            return ar;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getName(String gmail) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select name from member where gmail='" + gmail + "'";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("name");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getPhone(String gmail) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select phone from member where gmail='" + gmail + "'";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("phone");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getAge(String gmail) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select age from member where gmail='" + gmail + "'";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("age");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getGender(String gmail) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select gender from member where gmail='" + gmail + "'";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("gender");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getTime(String gmail) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select time from member where gmail='" + gmail + "'";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("time");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getAmount(String gmail) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select amount from member where gmail='" + gmail + "'";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("amount");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    public static void deleteMember(String gmail) {

        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";

        String q = "delete from member where gmail='" + gmail + "'";
        String q2 = "delete from payment where gmail='" + gmail + "'";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            st.executeUpdate(q);
            st.executeUpdate(q2);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error With Database");

        }

    }

    static void updateMember(Member mem) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "UPDATE member SET gmail = ? ,name =?,gender=?,age=?,"
                + "phone=?,time=?,amount=? WHERE gmail =?;";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);

            PreparedStatement st = con.prepareStatement(q);

            st.setString(1, mem.getGmail());

            st.setString(2, mem.getName());
            st.setString(3, mem.getGender());
            st.setString(4, mem.getAge());
            st.setString(5, mem.getPhone());
            st.setString(6, mem.getTime());
            st.setString(7, mem.getAmount());
            st.setString(8, mem.getGmail());
            st.executeUpdate();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error in database");
        }

    }

    static void addPayment(String gmail, String amount, String date) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "insert into payment values(?,?,?)";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st = con.prepareStatement(q);
            st.setString(1, gmail);
            st.setString(2, amount);
            st.setString(3, date);
            st.executeUpdate();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error in database");
        }
    }

    static ArrayList<String> getPayment(String gmail) {
        String url = "jdbc:mysql://localhost:3306/gym_management_system";
        String userName = "root";
        String password = "";
        String q = "select amount,date from payment where gmail='" + gmail + "'";
        try {
            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            ArrayList<String> pay = new ArrayList<String>();
            while (res.next()) {
                pay.add(res.getString("amount") + " " + res.getString("date"));
            }
            return pay;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }
}
