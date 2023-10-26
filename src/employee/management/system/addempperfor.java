
package employee.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class addempperfor extends JFrame implements ActionListener{
    
    JTextField salary1,address1,phno1,adhno1,var1;
    Choice desig1;
    JLabel empid,adhnol1,namel1;
    JButton det,back;
    String empid1;
    addempperfor(String empid1){
        this.empid1=empid1;
        setLayout(null);
        setTitle("ADD EMPLOYEE PERFORMANCE");
        getContentPane().setBackground(Color.WHITE);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image img2=img1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel title=new JLabel("Add Employee Performance");
        title.setBounds(750,20,500,40);
        title.setFont(new Font("serif",Font.BOLD,25));
        image.add(title);
        
        JLabel name=new JLabel("Name");
        name.setBounds(50,110,150,30);
        name.setFont(new Font("serif",Font.BOLD,25));
        image.add(name);
        
        namel1=new JLabel();
        namel1.setBounds(230,110,200,30);
        image.add(namel1);
        
        
        JLabel desig=new JLabel("Project ID");
        desig.setBounds(50,180,180,30);
        desig.setFont(new Font("serif",Font.BOLD,25));
        image.add(desig);
        
        desig1=new Choice();
        desig1.setBounds(290,180,200,30);
        image.add(desig1);
        
        
        JLabel address=new JLabel("Rating");
        address.setBounds(550,180,200,30);
        address.setFont(new Font("serif",Font.BOLD,25));
        image.add(address);
        
        address1=new JTextField();
        address1.setBounds(750,180,200,30);
        image.add(address1);
        
        
        JLabel adhno=new JLabel("Aadhar number");
        adhno.setBounds(50,270,180,30);
        adhno.setFont(new Font("serif",Font.BOLD,25));
        image.add(adhno);
        
        adhnol1=new JLabel();
        adhnol1.setBounds(230,270,200,30);
        image.add(adhnol1);
        
        
        
        JLabel empids=new JLabel("Employee ID :   ");
        empids.setBounds(50,340,220,30);
        empids.setFont(new Font("serif",Font.BOLD,25));
        image.add(empids);
        
        
        
        empid=new JLabel();
        empid.setBounds(230,340,280,30);
        empid.setFont(new Font("serif",Font.BOLD,25));
        image.add(empid);
        
        
        det=new JButton("Add Details");
        det.setBounds(380,480,150,40);
        det.setBackground(Color.BLACK);
        det.setForeground(Color.WHITE);
        det.addActionListener(this);
        image.add(det);
        
        
        back=new JButton("BACK");
        back.setBounds(600,480,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);
        
        
        
        Conn c=new Conn();
        try{
            
            String query="select a.empid,a.NAME,a.adhno,b.PROJECT_ID from emp_detail a, project b where a.empid=b.empid and a.empid='"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("NAME"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
                desig1.add(rs.getString("PROJECT_ID"));
            }

            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==det){
            
            String empid2=empid.getText().trim();
            String desig2=desig1.getSelectedItem();
            String name2=namel1.getText().trim();
            String dloc2=address1.getText().trim();
            try{
            Conn c=new Conn();
            String query="insert into performance_rating values('"+empid2+"','"+name2+"','"+dloc2+"','"+desig2+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Home();
              }catch(Exception e){
                  e.printStackTrace();
              }
        }
        else
        {
            new Home();
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args) {
        new addempperfor("");
    }
}