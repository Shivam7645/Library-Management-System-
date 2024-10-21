package Library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
public class viewIssueBook extends JFrame{
 String x[] = {"id","bookid","bookno","bookname","studentid","studentname","studentcontact","+date"};
 JButton bt;
 String y[][] = new String[20][8];
 int  i =0,j=0;

 JTable t;
 Font f;
 viewIssueBook()
 {
     super("IssueBook Information");
     setLocation(1,1);
     setSize(1000,450);
     f = new Font("Arial",Font.BOLD,15);
     try{
          ConnectionClass obj = new ConnectionClass();
          String q  = "select *from issuebook";
          ResultSet rs = obj.stm.executeQuery(q);
          while(rs.next())
          {
              y[i][j++] = rs.getString("id");
              y[i][j++] = rs.getString("bookid");
              y[i][j++] = rs.getString("bookno");
              y[i][j++] = rs.getString("bookname");
              y[i][j++] = rs.getString("studentid");
              y[i][j++] = rs.getString("studentname");
              y[i][j++] = rs.getString("studentcontact");
              y[i][j++] = rs.getString("date");
              i++;
              j=0;
          }
          t = new JTable(y,x);
          t.setFont(f);
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
     JScrollPane sp = new  JScrollPane(t);
     add(sp);
 

}
 
 public static void main(String[] args)
 {
   new viewIssueBook().setVisible(true); 
 }   
}