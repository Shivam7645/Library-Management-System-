package Library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
public class viewBook extends JFrame{
 String x[] = {"id","bookno","bookname","Author","Publisher","Quantity","Date"};
 JButton bt;
 String y[][] = new String[20][7];
 int  i =0,j=0;

 JTable t;
 Font f;
 viewBook()
 {
     super("Book Information");
     setLocation(1,1);
     setSize(1000,450);
     f = new Font("Arial",Font.BOLD,15);
     try{
          ConnectionClass obj = new ConnectionClass();
          String q  = "select *from addbooke";
          ResultSet rs = obj.stm.executeQuery(q);
          while(rs.next())
          {
              y[i][j++] = rs.getString("id");
              y[i][j++] = rs.getString("bookno");
              y[i][j++] = rs.getString("bookname");
              y[i][j++] = rs.getString("author");
              y[i][j++] = rs.getString("publisher");
              y[i][j++] = rs.getString("quantity");
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
   new viewBook().setVisible(true); 
 }   
}