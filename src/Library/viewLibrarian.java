package Library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
public class viewLibrarian extends JFrame{
 String x[] = {"id","name","password","email","contact","address","city"};
 JButton bt;
 String y[][] = new String[20][7];
 int  i =0,j=0;

 JTable t;
 Font f;
 viewLibrarian()
 {
     super("Librarian Information");
     setLocation(1,1);
     setSize(1000,450);
     f = new Font("Arial",Font.BOLD,15);
     try{
          ConnectionClass obj = new ConnectionClass();
          String q  = "select *from librarian";
          ResultSet rs = obj.stm.executeQuery(q);
          while(rs.next())
          {
              y[i][j++] = rs.getString("id");
              y[i][j++] = rs.getString("name");
              y[i][j++] = rs.getString("password");
              y[i][j++] = rs.getString("email");
              y[i][j++] = rs.getString("contact");
              y[i][j++] = rs.getString("address");
              y[i][j++] = rs.getString("city");
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
   new viewLibrarian().setVisible(true); 
 }   
}
