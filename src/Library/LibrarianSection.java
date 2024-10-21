package Library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LibrarianSection extends JFrame implements ActionListener{
    
    
    JLabel l1;
    JButton bt1;
    JPanel p1,p2;
    Font f,f1;
      LibrarianSection()
      {
         super("LibrarianSection Login Page");
        setLocation(0,0);
        setSize(1500,800);
        f = new Font("Arial",Font.BOLD,25);
        f1 = new Font("Arial",Font.BOLD,20);
      
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("Library//icon//ps2.jpg"));
        Image img = ic.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        l1 = new JLabel(ic1);
    
        JMenuBar m1 = new JMenuBar();
        JMenu mem1 = new JMenu("Add Info");
        JMenuItem memt1 = new JMenuItem("Add Book");
        
        JMenu mem2 = new JMenu("View Info");
        JMenuItem memt2 = new JMenuItem("view Book");
        JMenuItem memt3 = new JMenuItem("view Issue Book");
        
        JMenu mem3 = new JMenu("Issue Info");
        JMenuItem memt4 = new JMenuItem("Issue Book");
        
        JMenu mem4 = new JMenu("Return");
        JMenuItem memt5 = new JMenuItem("Return Book");
        
        JMenu mem5 = new JMenu("Exit");
        JMenuItem memt6 = new JMenuItem("Logout");
        
        mem1.add(memt1);
        mem2.add(memt2);
        mem2.add(memt3);
        mem3.add(memt4);
        mem4.add(memt5);
        mem5.add(memt6);
        
        m1.add(mem1);
        m1.add(mem2);
        m1.add(mem3);
        m1.add(mem4);
        m1.add(mem5);
        
        mem1.setFont(f);
        mem2.setFont(f);
        mem3.setFont(f);
        mem4.setFont(f);
        mem5.setFont(f);
        
        memt1.setFont(f1);
        memt2.setFont(f1);
        memt3.setFont(f1);
        memt4.setFont(f1);
        memt5.setFont(f1);
        memt6.setFont(f1);
        
        memt1.addActionListener(this);
        memt2.addActionListener(this);
        memt3.addActionListener(this);
        memt4.addActionListener(this);
        memt5.addActionListener(this);
        memt6.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
       }
    
     public void actionPerformed(ActionEvent e)
       {
           String comd = e.getActionCommand();
           if(comd.equals("Add Book"))
           {
//               System.out.println("Add Book");
               new AddBook().setVisible(true);
           }
           
           if(comd.equals("view Book"))
           {
//               System.out.println("view Book");
               new viewBook().setVisible(true);
           }
           
           if(comd.equals("view Issue Book"))
           {
//               System.out.println("view Issue book");
               new viewIssueBook().setVisible(true);
           }
           
           if(comd.equals("Issue Book"))
           {
//               System.out.println("Issue book");
               new IssueBook().setVisible(true);
           }
           if(comd.equals("Return Book"))
           {
//               System.out.println("return book");
               new returnBook().setVisible(true);
           }
             
           if(comd.equals("Logout"))
           {
               System.exit(0);
//               System.out.println("Logout");
//               new logout().setVisible(true);
           }
           
           
       }

 public static void main(String[] args)
   {
   new LibrarianSection().setVisible(true);    
   }
    
}
