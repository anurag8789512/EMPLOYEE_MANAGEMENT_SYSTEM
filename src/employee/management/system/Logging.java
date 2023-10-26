
package employee.management.system;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class Logging extends JFrame implements ActionListener{

    
    JTextField user1;
    JPasswordField pass1;
    JButton log,back;
    public Logging() throws HeadlessException {
        
        setSize(600,400);
        setLocation(450,200);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        user1=new JTextField();
        user1.setBounds(110,20,200,30);
        add(user1);
        JLabel pass=new JLabel("Password");
        pass.setBounds(40,100,100,30);
        add(pass);
        pass1=new JPasswordField();
        pass1.setBounds(110,100,200,30);
        pass1.setEchoChar('*');
        add(pass1);
        
        log=new JButton("LOGIN");
        log.setBounds(110,180,200,40);
        log.setBackground(Color.BLACK);
        log.setForeground(Color.WHITE);
        log.addActionListener(this);
        add(log);
        
        back=new JButton("BACK");
        back.setBounds(110,240,200,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image img2=img1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(350,0,200,200);
        add(image);
        
        setTitle("LOG IN");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==log)
        {
        try{
        String username=user1.getText();
        String password=pass1.getText();
        
        Conn c=new Conn();
        String query="select * from logins where username='"+username+"' and password='"+password+"'";
        ResultSet rs=c.s.executeQuery(query);
        if(rs.next()){
            setVisible(false);
            new Home();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }
        else
        {
            setVisible(false);
            new Start();
        }
    }
    
    public static void main(String[] args) {
        new Logging();
    }
}
