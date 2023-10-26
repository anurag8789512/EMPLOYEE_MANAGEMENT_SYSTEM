
package employee.management.system;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Updateempskill extends JFrame implements ActionListener,ItemListener{
    
    JTextField salary1,phno1,adhno1,var1;
    JComboBox sk;
    HashMap<String,String> hm;
    JLabel empid,adhnol1,skillid1;
    JButton det,back;
    String empid1;
    Updateempskill(String empid1){
        
        setTitle("UPDATE EMPLOYEE SKILL");
        hm=new HashMap<>();
        hm.put("Java", "1s001");
        hm.put("Python", "1s002");
        hm.put("C", "1s003");
        hm.put("C++", "1s004");
        hm.put("MySQL", "1s005");
        hm.put("Ruby", "1s006");
        hm.put("R", "1s007");
        hm.put("MongoDB","1s018");
        hm.put("Linux", "1s008");
        hm.put("Presentation", "1s009");
        hm.put("Communication", "1s010");
        hm.put("Leadership", "1s011");
        hm.put("Git", "1s012");
        hm.put("GitHub", "1s013");
        hm.put("Azure", "1s014");
        hm.put("AWS", "1s015");
        hm.put("GCP", "1s016");
        hm.put("GoLang", "1s017");
        hm.put("JavaScript", "1s019");
        hm.put("ReactJs", "1s020");
        hm.put("Vue.Js", "1s021");
        hm.put("AngularJs", "1s022");
        hm.put("HTML5", "1s023");
        hm.put("CSS", "1s024");
        hm.put("TailWind CSS", "1s025");
        this.empid1=empid1;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image img2=img1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel title=new JLabel("Update Employee Skill");
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
        
        
        JLabel desig=new JLabel("Skill");
        desig.setBounds(50,180,180,30);
        desig.setFont(new Font("serif",Font.BOLD,25));
        image.add(desig);
        
        String courses[]={"Java","Python","C","C++","MySQL","Ruby","R","Linux","Presentation","Communication","Leadership","Git","GitHub","Azure","AWS","GCP","GoLang","JavaScript","ReactJs","Vue.Js","AngularJs","HTML5","CSS","TailWind CSS"};
        sk=new JComboBox(courses);
        sk.setBackground(Color.WHITE);
        sk.setBounds(290,180,200,30);
        image.add(sk);
        
        
        JLabel address=new JLabel("Skill ID");
        address.setBounds(550,180,200,30);
        address.setFont(new Font("serif",Font.BOLD,25));
        image.add(address);
        
        skillid1=new JLabel();
        skillid1.setBounds(750,180,200,30);
        image.add(skillid1);
        
        JLabel salary=new JLabel("Experience");
        salary.setBounds(50,250,250,30);
        salary.setFont(new Font("serif",Font.BOLD,25));
        image.add(salary);
        
        salary1=new JTextField();
        salary1.setBounds(295,250,200,30);
        image.add(salary1);
        
        JLabel adhno=new JLabel("Aadhar number");
        adhno.setBounds(50,320,180,30);
        adhno.setFont(new Font("serif",Font.BOLD,25));
        image.add(adhno);
        
        adhnol1=new JLabel();
        adhnol1.setBounds(230,320,200,30);
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
            
            String query="select b.adhno,b.name,a.* from emp_detail b,skills a where a.empid=b.empid and a.empid='"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("name"));
                sk.setSelectedItem(rs.getString("skill"));
                skillid1.setText(rs.getString("skillid"));
                salary1.setText(rs.getString("experience"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
                
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String query="select b.adhno,b.name,a.* from emp_detail b,skills a where a.empid=b.empid and b.name='"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
               namel1.setText(rs.getString("name"));
                sk.setSelectedItem(rs.getString("skill"));
                salary1.setText(rs.getString("experience"));
                skillid1.setText(rs.getString("skillid"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            String query="select b.adhno,b.name,a.* from emp_detail b,skills a where a.empid=b.empid and b.adhno='"+empid1+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                namel1.setText(rs.getString("name"));
                sk.setSelectedItem(rs.getString("skill"));
                skillid1.setText(rs.getString("skillid"));
                salary1.setText(rs.getString("experience"));
                adhnol1.setText(rs.getString("adhno"));
                empid.setText(rs.getString("empid"));
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        sk.addItemListener(this);
        
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
    
    public void itemStateChanged(ItemEvent e){
        if(e.getSource()==sk){
            skillid1.setText(hm.get(sk.getSelectedItem()));
        }
        
    } 
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==det){
            
            String faname2=(String)sk.getSelectedItem();
            int salary2=Integer.parseInt(salary1.getText().trim());
            String skillid2=hm.get(faname2);
            Conn conn= new Conn();
            try{
                String query="update skills set skill='"+faname2+"',experience='"+salary2+"',skillid='"+skillid2+"' where empid='"+empid1+"'";
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
                String query="update skills set skill='"+faname2+"',experience='"+salary2+"',skillid='"+skillid2+"' where empid='"+var2+"'";
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
                String query="update skills set skill='"+faname2+"',experience='"+salary2+"',skillid='"+skillid2+"' where empid='"+empid1+"'";
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
        
        new Updateempskill("");
    }
}

