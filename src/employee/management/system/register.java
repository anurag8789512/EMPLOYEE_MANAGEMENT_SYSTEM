package employee.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class register extends JFrame implements ActionListener {
    JButton sub,sub1;
    JTextField user1,pass1,phno1,email1;
    register(){
        
        setSize(800, 700);
        setLocation(350,50);
        getContentPane().setBackground(Color.WHITE);
        setTitle("REGISTER");
        setLayout(null);
        
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/register.jpg"));
        Image img2=img1.getImage().getScaledInstance(800,700, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(0,0,800,700);
        add(image);
        
        
        JLabel user=new JLabel("Username");
        user.setForeground(Color.RED);
        user.setBounds(40,40,100,30);
        image.add(user);
        
        user1=new JTextField();
        user1.setBounds(150,40,200,30);
        image.add(user1);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(40,120,100,30);
        pass.setForeground(Color.RED);
        image.add(pass);
        pass1=new JTextField();
        pass1.setBounds(150,120,200,30);
        image.add(pass1);
        
        
        JLabel phno=new JLabel("Phone Number");
        phno.setBounds(40,200,100,30);
        phno.setForeground(Color.RED);
        image.add(phno);
        phno1=new JTextField();
        phno1.setBounds(150,200,200,30);
        image.add(phno1);
        
        
        JLabel email=new JLabel("Email");
        email.setBounds(40,280,100,30);
        email.setForeground(Color.RED);
        image.add(email);
        email1=new JTextField();
        email1.setBounds(150,280,200,30);
        image.add(email1);
        
        sub=new JButton("SUBMIT");
        sub.setBounds(180,360,200,40);
        sub.setBackground(Color.WHITE);
        sub.setForeground(Color.BLACK);
        sub.addActionListener(this);
        image.add(sub);
        
        sub1=new JButton("BACK");
        sub1.setBounds(180,410,200,40);
        sub1.setBackground(Color.WHITE);
        sub1.setForeground(Color.BLACK);
        sub1.addActionListener(this);
        image.add(sub1);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==sub){ 
            String user2=user1.getText();
            String pass2=pass1.getText();
            String email2=email1.getText();
            String phno2=phno1.getText();
            try{
                
                Conn conn=new Conn();
                String query="insert into logins  (username,password,email,phno) values('"+user2+"','"+pass2+"','"+email2+"','"+phno2+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Logging();
            }catch(Exception e){
                e.printStackTrace();
            }
        
        }
           else
           {
               new Start();
               setVisible(false);
           }
    }
    public static void main(String[] args) {
        new register();
    }
    
}
