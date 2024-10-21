package Library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.sql.*;

public class IssueBook extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    Font f,f1;
    Choice ch;
    
       IssueBook()
       {
        super("IssueBook Page");
        setLocation(0,0);
        setSize(650,400);
        f = new Font("Arial",Font.BOLD,25);
       f1 = new Font("Arial",Font.BOLD,20);
       
       l1 = new JLabel("Issue Book");
       l2 = new JLabel("Book Id");
       l3 = new JLabel("Book No");
       l4 = new JLabel("Book Name");
       l5 = new JLabel("Student Id");
       l6 = new JLabel("Student Name");
       l7 = new JLabel("Student Contact");
       l8 = new JLabel("Book Quantity");
       
       l1.setForeground(Color.white);
       l1.setHorizontalAlignment(JLabel.CENTER);
       
       tf1 = new JTextField();
       tf2 = new JTextField();
       tf3 = new JTextField();
       tf4 = new JTextField();
       tf5 = new JTextField();
       tf6 = new JTextField();
       
       bt1 = new JButton("Issue Book");
       bt2 = new JButton("Cancel");
     
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       
       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       l4.setFont(f1);
       l5.setFont(f1);
       l6.setFont(f1);
       l7.setFont(f1);
       l8.setFont(f1);
       
       tf1.setFont(f1);
       tf2.setFont(f1);
       tf3.setFont(f1);
       tf4.setFont(f1);
       tf5.setFont(f1);
       tf6.setFont(f1);
       tf6.setEditable(false);
       tf6.setForeground(Color.RED);
       
        bt1.setFont(f1);
        bt2.setFont(f1);
      
       ch = new Choice();
       
       try {
                   ConnectionClass obj = new ConnectionClass();
                   String q = "select id from addbooke";
                   ResultSet rs = obj.stm.executeQuery(q);
              while(rs.next())
               {
                        ch.add(rs.getString("id"));
               }
       }
           catch(Exception ea)
              {
                  ea.printStackTrace();
              }
       
       ch.setFont(f1);
       
       p1 = new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       p1.setBackground(Color.BLUE);
       
       p2 = new JPanel();
       p2.setLayout(new GridLayout(8,2,10,10));
       p2.add(l2);
       p2.add(ch);
       p2.add(l3);
       p2.add(tf1);
       p2.add(l4);
       p2.add(tf2);
       p2.add(l5);
       p2.add(tf3);
       p2.add(l6);
       p2.add(tf4);
       p2.add(l7);
       p2.add(tf5);
       p2.add(l8);
       p2.add(tf6);
       p2.add(bt1);
       p2.add(bt2);
       
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
          
       
       ch.addMouseListener(new MouseAdapter()
       {
         @Override 
         public void mouseClicked(MouseEvent arg0)
         {
              try {
                   ConnectionClass obj2 = new ConnectionClass();
                    int id = Integer.parseInt(ch.getSelectedItem());
                   String q1 = "select *from addbooke where id = '"+id+"'";
                   ResultSet rs1 = obj2.stm.executeQuery(q1);
              while(rs1.next())
               {
                        tf1.setText(rs1.getString("BookNo"));
                        tf2.setText(rs1.getString("Bookname"));
                        tf6.setText(rs1.getString("quantity"));
               }
       }
           catch(Exception eae)
              {
                  eae.printStackTrace();
              }
             
         }
                 
       });
   }
   
    @Override
     public void actionPerformed(ActionEvent e)
     {
           if(e.getSource()==bt1)
            {
                int qnt =0;
                int id = Integer.parseInt(ch.getSelectedItem());
                String BookNo = tf1.getText();
                String bookname = tf2.getText();
                String stuid = tf3.getText();
                String stuname = tf4.getText();
                String stucont = tf5.getText();
                String date = new java.util.Date().toString();
                try {
                   ConnectionClass obj3 = new ConnectionClass();
                   String q0 = "select quantity from addbooke where id = "+id+"";
                   ResultSet rs0 = obj3.stm.executeQuery(q0);
                   
                   while(rs0.next()){
                       qnt = Integer.parseInt(rs0.getString(1));
                   }
                   if(qnt<=0)
                   {
                       JOptionPane.showMessageDialog(null,"Book quantity is less ! can't issue");
                       this.setVisible(false);
                   }
                   else{
                       String q2 = "insert into issuebook(bookid,bookno,bookname,studentid,studentname,studentcontact,date) values("+id+",'"+BookNo+"','"+bookname+"','"+stuid+"','"+stuname+"','"+stucont+"','"+date+"');";
                       String q3 = "update addbooke set issuebook=issuebook+1 where id = "+id+"";
                       String q4 = "update addbooke set quantity=quantity-1 where id = "+id+"";
                       int aa=obj3.stm.executeUpdate(q2);
                       int aaa = obj3.stm.executeUpdate(q3);
                       int aaaa = obj3.stm.executeUpdate(q4);
                       if( aa ==1)
                       {
                           if(aaa ==1)
                           {
                               if(aaaa == 1)
                               {
                                   JOptionPane.showMessageDialog(null,"Your data successfully updated");
                                   this.setVisible(false);
                               }
                               else{
                                   JOptionPane.showMessageDialog(null,"Please ! Fill all detail carefully");
                               }
                           } 
                           else{
                               JOptionPane.showMessageDialog(null,"Please ! Fill all detail carefully");
                           }
                       }
                   }
               }
              catch (Exception eee) {
                   eee.getMessage();
               }
               
           }
           if(e.getSource()==bt2)
           {
               this.setVisible(false);
           }
       }
    
    
   public static void main(String[] args)
    {
            new IssueBook().setVisible(true);
    }
    
}