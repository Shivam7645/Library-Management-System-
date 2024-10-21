package Library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AddBook extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5;
    Font f,f1;
    
       AddBook()
       {
        super("AddBook Login Page");
        setLocation(450,400);
        setSize(650,400);
        f = new Font("Arial",Font.BOLD,25);
       f1 = new Font("Arial",Font.BOLD,20);
       
       l1 = new JLabel("Add Book");
       l2 = new JLabel("Book No");
       l3 = new JLabel("Book Name");
       l4 = new JLabel("Author");
       l5 = new JLabel("Publisher");
       l6 = new JLabel("Quantity");
       
       l1.setForeground(Color.white);
       l1.setHorizontalAlignment(JLabel.CENTER);
       
       tf1 = new JTextField();
       tf2 = new JTextField();
       tf3 = new JTextField();
       tf4 = new JTextField();
       tf5 = new JTextField();
       
       bt1 = new JButton("AddBook");
       bt2 = new JButton("Cancel");
       
       bt1.setFont(f1);
       bt2.setFont(f1);

       bt1.addActionListener(this);
       bt2.addActionListener(this);
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       l4.setFont(f1);
       l5.setFont(f1);
       l6.setFont(f1);
       
       tf1.setFont(f1);
       tf2.setFont(f1);
       tf3.setFont(f1);
       tf4.setFont(f1);
       tf5.setFont(f1);
       
       p1 = new JPanel();
       p1.setLayout(new GridLayout(1,1,0,0));
       p1.add(l1);
       p1.setBackground(Color.blue);
       
       p2 = new JPanel();
       p2.setLayout(new GridLayout(6,2,10,10));
       p2.add(l2);
       p2.add(tf1);
       p2.add(l3);
       p2.add(tf2);
       p2.add(l4);
       p2.add(tf3);
       p2.add(l5);
       p2.add(tf4);
       p2.add(l6);
       p2.add(tf5);
       p2.add(bt1);
       p2.add(bt2);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
          
       }
    
    
     public void actionPerformed(ActionEvent e)
       {
           String bookno = tf1.getText();
           String bookname = tf2.getText();
           String author = tf3.getText();
           String publisher = tf4.getText();
           String quantity = tf5.getText();
           String date = new java.util.Date().toString();
           
           if(e.getSource()==bt1)
           {
               try {
                   ConnectionClass obj = new ConnectionClass();
                   String q = "insert into addbooke(Bookno,bookname,author,publisher,quantity,date) values('"+bookno+"','"+bookname+"','"+author+"','"+publisher+"','"+quantity+"','"+date+"')";
                   int aa=obj.stm.executeUpdate(q);
                   if(aa==1)
                   {
                       JOptionPane.showMessageDialog(null,"your data inserted successfully");
                       this.setVisible(false);
                   }
                   else{
                       JOptionPane.showMessageDialog(null,"Please! fill the details correctly");
                       this.setVisible(true);
                   }
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }
               
           }
           if(e.getSource()==bt2)
           {
               this.setVisible(false);
           }
       }
    
    
   public static void main(String[] args)
    {
            new AddBook().setVisible(true);
    }
    
}
