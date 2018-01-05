package kata5P2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5P2.model.Mail;

public class MailListReaderDDBB {
    
    public static List<Mail> read(String fileName) throws ClassNotFoundException, SQLException {
        List<Mail> mailList = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        Connection connect = DriverManager.getConnection("jdbc:sqlite:" + fileName); 
        
        Statement st = connect.createStatement();
        
        String query = "SELECT * FROM MAIL";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()) {
            mailList.add(new Mail(rs.getString(2)));
        }
        
        rs.close();
        st.close();
        connect.close();
       
        return mailList;
    }
}
