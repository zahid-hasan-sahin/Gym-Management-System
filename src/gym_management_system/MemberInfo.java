package gym_management_system;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberInfo {
    
    Member mem = new Member();
    
    void addMember(String gmail) throws IOException {
        mem.setGmail(gmail);
    }
    
    void deleteMember(String gmail) throws FileNotFoundException, IOException {
        ConnectionDb.deleteMember(gmail);
    }
    
    boolean isExistMember(String gmail) throws FileNotFoundException {
        
        return ConnectionDb.isExistMember(gmail);
        
    }
    
    void setName(String gmail, String name) throws IOException {
        mem.setName(name);
    }
    
    String getName(String gmail) throws IOException {
        return ConnectionDb.getName(gmail);
        
    }
    
    void setPhone(String gmail, String phone) throws IOException {
        mem.setPhone(phone);
    }
    
    String getPhone(String gmail) throws IOException {
        return ConnectionDb.getPhone(gmail);
        
    }
    
    void setAge(String gmail, String age) throws IOException {
        mem.setAge(age);
    }
    
    String getAge(String gmail) throws IOException {
        return ConnectionDb.getAge(gmail);
        
    }
    
    void setGender(String gmail, String gender) throws IOException {
        mem.setGender(gender);
    }
    
    String getGender(String gmail) throws IOException {
        return ConnectionDb.getGender(gmail);
        
    }
    
    void setTime(String gmail, String time) throws IOException {
        mem.setTime(time);
    }
    
    String getTime(String gmail) throws IOException {
        return ConnectionDb.getTime(gmail);
        
    }
    
    void setAmount(String gmail, String amount) throws IOException {
        mem.setAmount(amount);
    }
    
    String getAmount(String gmail) throws IOException {
        return ConnectionDb.getAmount(gmail);
        
    }
    
    void setPayment(String gmail, String amount, String date) throws IOException {
        
        FileWriter fw = new FileWriter("member_Details//" + gmail + "//payment.txt", true);
        fw.write(amount + " " + date + "\r\n");
        fw.close();
    }
    
    ArrayList<String> getPayment(String gmail) throws IOException {
        try {
            File fw = new File("member_Details//" + gmail + "//payment.txt");
            Scanner scan = new Scanner(fw);
            ArrayList<String> pay = new ArrayList<String>();
            while (scan.hasNext()) {
                pay.add(scan.next() + " " + scan.next());
            }
            
            return pay;
        } catch (Exception E) {
            FileWriter fw = new FileWriter("member_Details//" + gmail + "//payment.txt");
            fw.close();
            return new ArrayList<String>();
        }
        
    }
    
    ArrayList<String> getAllMembersGmail() throws FileNotFoundException {
        
        ArrayList<String> members = ConnectionDb.getGmailList();
        
        return members;
    }
    
    void addToDb() {
        ConnectionDb.addMember(mem);
    }
    
}
