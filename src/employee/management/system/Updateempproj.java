
package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Color.*;

public class Updateempproj extends JFrame implements ActionListener{
    
    JTextField address1,salary1,phno1,adhno1,var1,ploca1;
    JLabel empid,adhnol1,desig1;
    JButton det,back;
    String empid1;
    Updateempproj(String empid1){
        this.empid1=empid1;
        setLayout(null);
        setTitle("UPDATE EMPLOYEE PROJECT");
        getContentPane().setBackground(Color.WHITE);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image img2=img1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel title=new JLabel("Update Employee Project");
        title.setBounds(750,20,500,40);
        title.setFont(new Font("serif",Font.BOLD,25));
        image.add(title);
        
        JLabel name=new JLabel("Name");
        name.setBounds(50,110,150,30);
        name.setFont(new Font("serif",Font.BOLD,25));
        image.add(name);
        
        JLabel namel1=new JLabel();
        namel1.setBounds(230,110,200,30);
        image.add(namel1);
        
        
        JLabel desig=new JLabel("Project ID");
        desig.setBounds(50,180,180,30);
        desig.setFont(new Font("serif",Font.BOLD,25));
        image.add(desig);
        
        desig1=new JLabel();
        desig1.setBounds(290,180,200,30);
        image.add(desig1);
        
        
        JLabel address=new JLabel("Project Name");
        address.setBounds(550,180,200,30);
        address.setFont(new Font("serif",Font.BOLD,25));
        address.setForeground(Color.CYAN);
        image.add(address);
        
        address1=new JTextField();
        address1.setBounds(750,180,200,30);
        image.add(address1);
        
        
        JLabel ploca=new JLabel("Project Location");
        ploca.setBounds(50,250,180,30);
        ploca.setFont(new Font("serif",Font.BOLD,25));
        ploca.setForeground(Color.CYAN);
        image.add(ploca);
        
        ploca1=new JTextField();
        ploca1.setBounds(290,250,200,30);
        image.add(ploca1);
               
        JLabel adhno=new JLabel("Aadhar number");
        adhno.setBounds(50,330,180,30);
        adhno.setFont(new Font("serif",Font.BOLD,25));
        adhno.setForeground(Color.CYAN);
        image.add(adhno);
        
        adhnol1=new JLabel();
        adhnol1.setBounds(230,330,200,30);
        image.add(adhnol1);
        
        
        
        JLabel empids=new JLabel("Employee ID :   ");
        empids.setBounds(50,390,220,30);
        empids.setFont(new Font("serif",Font.BOLD,25));
        image.add(empids);
        
        
        
        empid=new JLabel();
        empid.setBounds(230,390,280,30);
        empid.setFont(new Font("serif",Font.BOLD,25));
        image.add(empid);
        
        Conn c=new Conn();
        try{
            String query="select b.adhno,b.name,a.* from emp_detail b,project a where a.empid=b.empid and a.empid='"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("name"));
                desig1.setText(rs.getString("PROJECT_ID"));
                address1.setText(rs.getString("PROJECT_NAME"));
                ploca1.setText(rs.getString("PROJECT_LOCATION"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
            
        }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String query="select b.adhno,b.name,a.* from emp_detail b,project a where a.empid=b.empid and b.name='"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("name"));
                desig1.setText(rs.getString("PROJECT_ID"));
                address1.setText(rs.getString("PROJECT_NAME"));
                ploca1.setText(rs.getString("PROJECT_LOCATION"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String query="select b.adhno,b.name,a.* from emp_detail b,project a where a.empid=b.empid and b.adhno='"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("name"));
                desig1.setText(rs.getString("PROJECT_ID"));
                address1.setText(rs.getString("PROJECT_NAME"));
                ploca1.setText(rs.getString("PROJECT_LOCATION"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String query="select b.adhno,b.name,a.* from emp_detail b,project a where a.empid=b.empid and a.PROJECT_ID='"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("name"));
                desig1.setText(rs.getString("PROJECT_ID"));
                address1.setText(rs.getString("PROJECT_NAME"));
                ploca1.setText(rs.getString("PROJECT_LOCATION"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
            
        }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        det=new JButton("Update Details");
        det.setBounds(380,520,150,40);
        det.setBackground(Color.BLACK);
        det.setForeground(Color.WHITE);
        det.addActionListener(this);
        image.add(det);
        
        
        back=new JButton("BACK");
        back.setBounds(600,520,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==det){
            
            String faname2=desig1.getText().trim();
            String ploca2=ploca1.getText().trim();
            String address2=address1.getText().trim();
            Conn conn= new Conn();
            try{
                String query="update project set PROJECT_NAME='"+address2+"',PROJECT_LOCATION='"+ploca2+"' where empid='"+empid1+"'";
                conn.s.executeUpdate(query);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            try{
                String query="update project set PROJECT_NAME='"+address2+"',PROJECT_LOCATION='"+ploca2+"' where PROJECT_ID='"+empid1+"'";
                conn.s.executeUpdate(query);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            try{
                
                String query1="select * from emp_detail where adhno='"+empid1+"'";
                ResultSet rs=conn.s.executeQuery(query1);
                var1=new JTextField();
                while(rs.next()){
                    var1.setText(rs.getString("empid"));
                }
                String var2=var1.getText();
                String query="update project set PROJECT_NAME='"+address2+"',PROJECT_LOCATION='"+ploca2+"' where empid='"+var2+"'";
                conn.s.executeUpdate(query);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            try{
                
                String query1="select * from emp_detail where name='"+empid1+"'";
                ResultSet rs=conn.s.executeQuery(query1);
                var1=new JTextField();
                while(rs.next()){
                    var1.setText(rs.getString("empid"));
                }
                String var2=var1.getText();
                String query="update project set PROJECT_NAME='"+address2+"',PROJECT_LOCATION='"+ploca2+"' where empid='"+var2+"'";
                conn.s.executeUpdate(query);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
                    
        }
        else
        {
            new Home();
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args) {
        
        new Updateempproj("");
    }
}



