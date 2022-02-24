package gym_management_system;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ConnectionDb {

    static Connection con;

    static {

        try {
            String url = "jdbc:mysql://remotemysql.com:3306/2fhbvFLq6w";
            String userName = "2fhbvFLq6w";
            String password = "EFNHu76cru";
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void addMember(Member mem) {

        String q = "insert into member values(?,?,?,?,?,?,?)";
        try {

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
            System.out.println(e);
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in database");
        }
    }

    public static boolean isExistMember(String gmail) {

        String q = "select * from member where gmail ='" + gmail + "'";
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            return res.next();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return false;
    }

    public static ArrayList<String> getGmailList() {

        String q = "select gmail from member;";
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);

            ArrayList<String> ar = new ArrayList<String>();
            while (res.next()) {
                ar.add(res.getString("gmail"));
            }
            System.out.println(ar);
            return ar;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getName(String gmail) {

        String q = "select name from member where gmail='" + gmail + "'";
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("name");
        } catch (Exception e) {

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getPhone(String gmail) {

        String q = "select phone from member where gmail='" + gmail + "'";
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("phone");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getAge(String gmail) {

        String q = "select age from member where gmail='" + gmail + "'";
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("age");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getGender(String gmail) {

        String q = "select gender from member where gmail='" + gmail + "'";
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("gender");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getTime(String gmail) {

        String q = "select time from member where gmail='" + gmail + "'";
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("time");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    static String getAmount(String gmail) {

        String q = "select amount from member where gmail='" + gmail + "'";
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            res.next();
            return res.getString("amount");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }

    public static void deleteMember(String gmail) {

        String q = "delete from member where gmail='" + gmail + "'";
        String q2 = "delete from payment where gmail='" + gmail + "'";
        try {

            Statement st = con.createStatement();
            st.executeUpdate(q);
            st.executeUpdate(q2);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }

    }

    static void updateMember(Member mem) {

        String q = "UPDATE member SET gmail = ? ,name =?,gender=?,age=?,"
                + "phone=?,time=?,amount=? WHERE gmail =?;";
        try {

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
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in database");
        }

    }

    static void addPayment(String gmail, String amount, String date) {

        String q = "insert into payment values(?,?,?)";
        try {

            PreparedStatement st = con.prepareStatement(q);
            st.setString(1, gmail);
            st.setString(2, amount);
            st.setString(3, date);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error in database");
        }
    }

    static ArrayList<String> getPayment(String gmail) {

        String q = "select amount,date from payment where gmail='" + gmail + "'";
        try {

            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(q);
            ArrayList<String> pay = new ArrayList<String>();
            while (res.next()) {
                pay.add(res.getString("amount") + " " + res.getString("date"));
            }
            return pay;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error With Database");

        }
        return null;

    }
}
