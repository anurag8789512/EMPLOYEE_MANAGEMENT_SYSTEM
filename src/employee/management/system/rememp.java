
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class rememp extends JFrame implements ActionListener{
    
    Choice cempid;
    JTextField jta;
    JButton sear1,del1,back;
    JLabel name,phno,email;
    rememp(){
        getContentPane().setBackground(Color.WHITE);
        setTitle("REMOVE EMPLOYEE");
        setLayout(null);
        
        JLabel title=new JLabel("Remove Employee Details");
        title.setBounds(600,20,300,30);
        title.setFont(new Font("serif",Font.BOLD,25));
        add(title);
        
        JLabel sear=new JLabel("Search with");
        sear.setBounds(50,50,100,30);
        add(sear);
        
        cempid=new Choice();
        cempid.setBounds(150,50,150,30);
        cempid.add("Employee ID");
        cempid.add("Name");
        cempid.add("Aadhar No");
        add(cempid);
        
        jta=new JTextField();
        jta.setBounds(50, 110, 250, 30);
        add(jta);
        
        sear1=new JButton("SEARCH");
        sear1.setBounds(330,110,100,30);
        sear1.addActionListener(this);
        add(sear1);
        
        JLabel name1=new JLabel("Name: ");
        name1.setBounds(50,150,100,30);
        add(name1);
        
        name=new JLabel();
        name.setBounds(150,150,100,30);
        add(name);
        
        JLabel phno1=new JLabel("Phone: ");
       phno1.setBounds(50,200,100,30);
        add(phno1);
        
        phno=new JLabel();
       phno.setBounds(150,200,100,30);
        add(phno);
        
        JLabel email1=new JLabel("Email: ");
        email1.setBounds(50,250,100,30);
        add(email1);
        
        email=new JLabel();
        email.setBounds(150,250,100,30);
        add(email);
        
                
        del1=new JButton("DELETE");
        del1.setBounds(150,300,100,30);
        del1.addActionListener(this);
        del1.setForeground(Color.WHITE);
        del1.setBackground(Color.BLACK);
        add(del1);
        del1.setVisible(false);
        
        back=new JButton("BACK");
        back.setBounds(120,400,150,40);
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        add(back);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image img2=img1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(350,100,600,400);
        add(image);
        
        
        setSize(1000,600);
        setLocation(300,150);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==sear1){
            name.setText("");
            phno.setText("");
            email.setText("");
            del1.setVisible(false);
            try{
            Conn c=new Conn();
            String str=jta.getText();
            String str1=str.trim();
            if(cempid.getSelectedItem()=="Employee ID"){
                String query="select * from emp_detail where empid='"+str1+"'";
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    name.setText(rs.getString("name"));
                    phno.setText(rs.getString("phno"));
                    email.setText(rs.getString("email"));
                    del1.setVisible(true);
                }
                    
            }else if(cempid.getSelectedItem()=="Name"){
                String query1="select * from emp_detail where name='"+str1+"'";
                ResultSet rs1=c.s.executeQuery(query1);
                while(rs1.next()){
                    name.setText(rs1.getString("name"));
                    phno.setText(rs1.getString("phno"));
                    email.setText(rs1.getString("email"));
                    del1.setVisible(true);
                }
            }else{
                String query2="select * from emp_detail where adhno='"+str1+"'";
                ResultSet rs2=c.s.executeQuery(query2);
                while(rs2.next()){
                    name.setText(rs2.getString("name"));
                    phno.setText(rs2.getString("phno"));
                    email.setText(rs2.getString("email"));
                    del1.setVisible(true);
                
            }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }else if(ae.getSource()==del1){
          
            if(cempid.getSelectedItem()=="Employee ID"){
                try{
                Conn c=new Conn();
                String str2=jta.getText();
                String str3=str2.trim();
                String query="delete from emp_detail where empid='"+str3+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details removed successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
            }
            else if(cempid.getSelectedItem()=="Name"){
                try{
                Conn c=new Conn();
                String str2=jta.getText();
                String str3=str2.trim();
                String query="delete from emp_detail where name='"+str3+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details removed successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
            }
            else if(cempid.getSelectedItem()=="Aadhar No"){
                try{
                Conn c=new Conn();
                String str2=jta.getText();
                String str3=str2.trim();
                String query="delete from emp_detail where adhno='"+str3+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details removed successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Home();
        }
        
    }
    public static void main(String[] args) {
        new rememp();
    }
}
