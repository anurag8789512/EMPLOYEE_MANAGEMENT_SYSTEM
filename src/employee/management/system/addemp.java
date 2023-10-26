package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.sql.*;



public class addemp extends JFrame implements ActionListener{
    
    JTextField name1,faname1,address1,salary1,phno1,email1,adhno1;
    JDateChooser dcdob;
    JComboBox he1;
    JLabel empid;
    JButton det,back;
    Random ran = new Random();
    int empid1=ran.nextInt(9999999);
    addemp(){
        setLayout(null);
        setTitle("ADD EMPLOYEE");
        getContentPane().setBackground(Color.WHITE);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        Image img2=img1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel title=new JLabel("Add Employee Details");
        title.setBounds(810,20,500,40);
        title.setFont(new Font("THOMA",Font.BOLD,25));
        image.add(title);
        
        JLabel name=new JLabel("Name");
        name.setBounds(50,110,150,30);
        name.setFont(new Font("serif",Font.BOLD,25));
        image.add(name);
        
        name1=new JTextField();
        name1.setBounds(230,110,200,30);
        image.add(name1);
        
        
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
        
        dcdob=new JDateChooser();
        dcdob.setBounds(750,110,150,30);
        image.add(dcdob);
        
        
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
        
        String courses[]={"BBA","MBA","BCA","BA","MA","BE","B.Tech","M.Tech","BSc","MSc","B.Com","M.Com","PHD","Research"};
        he1=new JComboBox(courses);
        he1.setBackground(Color.WHITE);
        he1.setBounds(750,320,200,30);
        image.add(he1);
        
        
        JLabel adhno=new JLabel("Aadhar number");
        adhno.setBounds(50,390,180,30);
        adhno.setFont(new Font("serif",Font.BOLD,25));
        image.add(adhno);
        
        adhno1=new JTextField();
        adhno1.setBounds(230,390,200,30);
        image.add(adhno1);
        
        
        
        JLabel empids=new JLabel("Employee ID :   ");
        empids.setBounds(50,460,220,30);
        empids.setFont(new Font("serif",Font.BOLD,25));
        image.add(empids);
        
        
        
        empid=new JLabel(""+ empid1);
        empid.setBounds(230,460,280,30);
        empid.setFont(new Font("serif",Font.BOLD,25));
        image.add(empid);
        
        
        det=new JButton("Add Details");
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
            
            String name2=name1.getText();
            String faname2=faname1.getText();
            String dcdob2=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary2=salary1.getText();
            String address2=address1.getText();
            String phno2=phno1.getText();
            String email2=email1.getText();
            String he2=(String)he1.getSelectedItem();
            String adhno2=adhno1.getText();
            String empid2=empid.getText();
            
            try{
                Conn conn= new Conn();
                String query="insert into emp_detail values('"+name2+"','"+faname2+"','"+dcdob2+"','"+salary2+"','"+address2+"','"+phno2+"','"+email2+"','"+he2+"','"+adhno2+"','"+empid2+"')";
                conn.s.executeUpdate(query);
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
        
        new addemp();
    }
}
