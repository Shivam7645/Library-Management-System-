package Library;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminSection extends JFrame implements ActionListener{
    
    
    JLabel l1;
    JButton bt1;
    JPanel p1,p2;
    Font f,f1;
      AdminSection()
      {
          super("AdminSection Login Page");
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
        JMenuItem memt1 = new JMenuItem("Add Librarian");
        
        JMenu mem2 = new JMenu("View Info");
        JMenuItem memt2 = new JMenuItem("view Librarian");
        
        JMenu mem3 = new JMenu("Delete Info");
        JMenuItem memt3 = new JMenuItem("Delete Librarian");
        
        JMenu mem4 = new JMenu("Exit");
        JMenuItem memt4 = new JMenuItem("Logout");
        
        mem1.add(memt1);
        mem2.add(memt2);
        mem3.add(memt3);
        mem4.add(memt4);
        
        m1.add(mem1);
        m1.add(mem2);
        m1.add(mem3);
        m1.add(mem4);
        
        mem1.setFont(f);
        mem2.setFont(f);
        mem3.setFont(f);
        mem4.setFont(f);
        
        memt1.setFont(f1);
        memt2.setFont(f1);
        memt3.setFont(f1);
        memt4.setFont(f1);
        
        memt1.addActionListener(this);
        memt2.addActionListener(this);
        memt3.addActionListener(this);
        memt4.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
       }
    
     public void actionPerformed(ActionEvent e)
       {
           String comd = e.getActionCommand();
           if(comd.equals("Add Librarian"))
           {
//               System.out.println("Add Librarian");
               new AddLibrarian().setVisible(true);
           }
           
           if(comd.equals("view Librarian"))
           {
//               System.out.println("view Librarian");
               new viewLibrarian().setVisible(true);
           }
           
           if(comd.equals("Delete Librarian"))
           {
               System.out.println("delete Librarian");
               new DeleteLibrarian().setVisible(true);
           }
           
           if(comd.equals("Logout"))
           {
               System.exit(0);
//               System.out.println("Logout");
//               new AddLibrarian().setVisible(true);
           }
           
           
       }

 public static void main(String[] args)
   {
   new AdminSection().setVisible(true);    
   }
    
}


