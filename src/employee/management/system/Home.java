package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    
    JButton addemp,viewemp,rememp1,updemp,logout;
    Home(){
        
        setLayout(null);
        
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image img2=img1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel title= new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        title.setBounds(610,20,500,40);
        title.setFont(new Font("TAHOMA",Font.BOLD,25));
        image.add(title);
        
        addemp=new JButton("Add Employee");
        addemp.setBounds(650,80,150,40);
        addemp.setBackground(Color.BLUE);
        addemp.setForeground(Color.WHITE);
        addemp.addActionListener(this);
        image.add(addemp);
        
        viewemp=new JButton("View Employee");
        viewemp.setBounds(850,80,150,40);
        viewemp.setBackground(Color.BLUE);
        viewemp.setForeground(Color.WHITE);
        viewemp.addActionListener(this);
        image.add(viewemp);
        
        updemp=new JButton("Update Employee");
        updemp.setBounds(650,130,150,40);
        updemp.setBackground(Color.BLUE);
        updemp.setForeground(Color.WHITE);
        updemp.addActionListener(this);
        image.add(updemp);
        
        rememp1=new JButton("Remove Employee");
        rememp1.setBounds(850,130,150,40);
        rememp1.setBackground(Color.BLUE);
        rememp1.setForeground(Color.WHITE);
        rememp1.addActionListener(this);
        image.add(rememp1);
        
        
        logout=new JButton("LOG OUT");
        logout.setBounds(30,530,150,40);
        logout.setBackground(Color.BLUE);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);
        logout.setVisible(true);
        image.add(logout);

        setSize(1120,630);
        setLocation(250,100);
        setTitle("HOME");
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addemp){
            new add_options();
            setVisible(false);
    }else if(ae.getSource()==viewemp){
        setVisible(false);
        new viewemp();
    }
    else if(ae.getSource()==updemp){
        setVisible(false);
        new viewemp();
        
    }
    else if(ae.getSource()==rememp1){
            setVisible(false);
            new rememp();
        
    }
    else if(ae.getSource()==logout){
            setVisible(false);
            new Start();
    }
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
