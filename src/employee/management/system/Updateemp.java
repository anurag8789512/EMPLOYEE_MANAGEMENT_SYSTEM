
package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Updateemp extends JFrame implements ActionListener{
    
    JTextField hename,faname1,address1,salary1,phno1,email1,adhno1;
    JLabel empid,adhnol1;
    JButton det,back;
    String empid1;
    Updateemp(String empid1){
        this.empid1=empid1;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image img2=img1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel title=new JLabel("Update Employee Details");
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
        
        
        JLabel faname=new JLabel("Father's Name");
        faname.setBounds(50,180,180,30);
        faname.setFont(new Font("serif",Font.BOLD,25));
        image.add(faname);
        
        faname1=new JTextField();
        faname1.setBounds(230,180,200,30);
        image.add(faname1);
        
        JLabel dob=new JLabel("Date of Birth");
        dob.setBounds(550,110,200,30);
        dob.setFont(new Font("serif",Font.BOLD,25));
        image.add(dob);
        
        JLabel dcdobl=new JLabel();
        dcdobl.setBounds(750,110,150,30);
        image.add(dcdobl);
        
        
        JLabel address=new JLabel("Address");
        address.setBounds(550,180,200,30);
        address.setFont(new Font("serif",Font.BOLD,25));
        image.add(address);
        
        address1=new JTextField();
        address1.setBounds(750,180,150,30);
        image.add(address1);
        
        JLabel salary=new JLabel("Salary");
        salary.setBounds(50,250,180,30);
        salary.setFont(new Font("serif",Font.BOLD,25));
        image.add(salary);
        
        salary1=new JTextField();
        salary1.setBounds(230,250,200,30);
        image.add(salary1);
        
        JLabel phno=new JLabel("Phone number");
        phno.setBounds(550,250,180,30);
        phno.setFont(new Font("serif",Font.BOLD,25));
        image.add(phno);
        
        phno1=new JTextField();
        phno1.setBounds(750,250,200,30);
        image.add(phno1);
        
        
        JLabel email=new JLabel("Email address");
        email.setBounds(50,320,180,30);
        email.setFont(new Font("serif",Font.BOLD,25));
        image.add(email);
        
        email1=new JTextField();
        email1.setBounds(230,320,200,30);
        image.add(email1);
        
        
        JLabel he=new JLabel("Highest Education");
        he.setBounds(550,320,360,30);
        he.setFont(new Font("serif",Font.BOLD,25));
        image.add(he);
        
        
        hename=new JTextField();
        hename.setBackground(Color.WHITE);
        hename.setBounds(750,320,200,30);
        image.add(hename);
        
        
        JLabel adhno=new JLabel("Aadhar number");
        adhno.setBounds(50,390,180,30);
        adhno.setFont(new Font("serif",Font.BOLD,25));
        image.add(adhno);
        
        adhnol1=new JLabel();
        adhnol1.setBounds(230,390,200,30);
        image.add(adhnol1);
        
        
        
        JLabel empids=new JLabel("Employee ID :   ");
        empids.setBounds(50,460,220,30);
        empids.setFont(new Font("serif",Font.BOLD,25));
        image.add(empids);
        
        
        
        empid=new JLabel();
        empid.setBounds(230,460,280,30);
        empid.setFont(new Font("serif",Font.BOLD,25));
        image.add(empid);
        
        Conn c= new Conn();
        try{
            String query="select * from emp_detail where empid= '"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("name"));
                faname1.setText(rs.getString("faname"));
                dcdobl.setText(rs.getString("dob"));
                salary1.setText(rs.getString("salary"));
                address1.setText(rs.getString("address"));
                phno1.setText(rs.getString("phno"));
                email1.setText(rs.getString("email"));
                hename.setText(rs.getString("education"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String query="select * from emp_detail where name= '"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("name"));
                faname1.setText(rs.getString("faname"));
                dcdobl.setText(rs.getString("dob"));
                salary1.setText(rs.getString("salary"));
                address1.setText(rs.getString("address"));
                phno1.setText(rs.getString("phno"));
                email1.setText(rs.getString("email"));
                hename.setText(rs.getString("education"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String query="select * from emp_detail where adhno= '"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("name"));
                faname1.setText(rs.getString("faname"));
                dcdobl.setText(rs.getString("dob"));
                salary1.setText(rs.getString("salary"));
                address1.setText(rs.getString("address"));
                phno1.setText(rs.getString("phno"));
                email1.setText(rs.getString("email"));
                hename.setText(rs.getString("education"));
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
        setTitle("UPDATE EMPLOYEE");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==det){
            
            String faname2=faname1.getText();
            String salary2=salary1.getText();
            String address2=address1.getText();
            String phno2=phno1.getText();
            String email2=email1.getText();
            String he2=hename.getText();
            Conn conn= new Conn();
            try{
                String query="update emp_detail set faname='"+faname2+"',salary='"+salary2+"',address='"+address2+"',phno='"+phno2+"',email='"+email2+"',education='"+he2+"' where empid='"+empid1+"'";
                conn.s.executeUpdate(query);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            try{
                String query="update emp_detail set faname='"+faname2+"',salary='"+salary2+"',address='"+address2+"',phno='"+phno2+"',email='"+email2+"',education='"+he2+"' where adhno='"+empid1+"'";
                conn.s.executeUpdate(query);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            try{
                String query="update emp_detail set faname='"+faname2+"',salary='"+salary2+"',address='"+address2+"',phno='"+phno2+"',email='"+email2+"',education='"+he2+"' where name='"+empid1+"'";
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
        
        new Updateemp("");
    }
}
