
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class viewempproj extends JFrame implements ActionListener{
    
    JTable jt;
    Choice cempid;
    JButton sear,prin,back,update,det,dept,skill,perfor;
    JTextField jta;
    
    viewempproj(){
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("VIEW EMPLYEE PROJECT");
        setLayout(null);
        
        JLabel search=new JLabel("Search with ");
        search.setBounds(20,10,70,20);
        add(search);
        
        cempid=new Choice();
        cempid.setBounds(100,10,150,20);
        cempid.add("ALL");
        cempid.add("Employee ID");
        cempid.add("Name");
        cempid.add("Aadhar No");
        cempid.add("PROJECT ID");
        cempid.add("QUERY");
        add(cempid);
        
        sear=new JButton("SEARCH");
        sear.setBounds(20,95,100,20);
        sear.addActionListener(this);
        add(sear);
        
        prin=new JButton("PRINT");
        prin.setBounds(140,95,100,20);
        prin.addActionListener(this);
        add(prin);
        
        update=new JButton("UPDATE");
        update.setBounds(260,95,100,20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("BACK");
        back.setBounds(380,95,100,20);
        back.addActionListener(this);
        add(back);
        
        det=new JButton("DETAILS");
        det.setBounds(620,10,110,20);
        det.addActionListener(this);
        add(det);
        
        dept=new JButton("DEPARTMENT");
        dept.setBounds(750,10,130,20);
        dept.addActionListener(this);
        add(dept);
        
        skill=new JButton("SKILL");
        skill.setBounds(900,10,100,20);
        skill.addActionListener(this);
        add(skill);
        
        perfor=new JButton("PERFORMANCE"); 
        perfor.setBounds(1020,10,140,20);
        perfor.addActionListener(this);
        add(perfor);
        
        
        jta=new JTextField();
        jta.setBounds(20,60,250,20);
        add(jta);
        
        
        jt=new JTable();
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select b.name,a.* from emp_detail b,project a where a.empid=b.empid");
            jt.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane jsp=new JScrollPane(jt);
        jsp.setBounds(0,135,1200,700);
        add(jsp);
        
        setSize(1200,800);
        setLocation(200,20);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==sear){
            String query1="select * from emp_detail where empid ='"+cempid.getSelectedItem()+"'";
            try{
                
                Conn c=new Conn();
                ResultSet rs1= c.s.executeQuery(query1);
                jt.setModel(DbUtils.resultSetToTableModel(rs1));
                if(cempid.getSelectedItem()=="ALL"){
                    ResultSet rs=c.s.executeQuery("select b.name,a.* from project a,emp_detail b where a.empid=b.empid");
                    jt.setModel(DbUtils.resultSetToTableModel(rs));
            
                }
                else if(cempid.getSelectedItem()=="Employee ID")
                {
                    String str=jta.getText().trim();
                    ResultSet rs2=c.s.executeQuery("select b.name,a.* from emp_detail b,project a where a.empid=b.empid and a.empid='"+str+"'");
                    jt.setModel(DbUtils.resultSetToTableModel(rs2));
                }
                else if(cempid.getSelectedItem()=="Name")
                {
                    String str=jta.getText().trim();
                    ResultSet rs2=c.s.executeQuery("select b.name,a.* from emp_detail b,project a where a.empid=b.empid and b.name='"+str+"'");
                    jt.setModel(DbUtils.resultSetToTableModel(rs2));
                }
                else if(cempid.getSelectedItem()=="Aadhar No")
                {
                    String str=jta.getText().trim();
                    ResultSet rs2=c.s.executeQuery("select b.name,a.* from project a,emp_detail b where a.empid=b.empid and b.adhno='"+str+"'");
                    jt.setModel(DbUtils.resultSetToTableModel(rs2));
                }
                else if(cempid.getSelectedItem()=="Aadhar No")
{
                    String str=jta.getText().trim();
                    ResultSet rs2=c.s.executeQuery(str);
                   jt.setModel(DbUtils.resultSetToTableModel(rs2));
}
                else
                {
                    String str=jta.getText().trim();
                    ResultSet rs2=c.s.executeQuery("select b.name,a.* from project a,emp_detail b where a.empid=b.empid and a.PROJECT_ID='"+str+"'");
                    jt.setModel(DbUtils.resultSetToTableModel(rs2));
                }

                
 
            }catch(Exception e){
                
                
            }
        }else if(ae.getSource()==prin){
           try{ 
           jt.print();
           }catch(Exception e){
               e.printStackTrace();
           }
            
        }else if(ae.getSource()==update){

                    setVisible(false);
                    new Updateempproj(jta.getText().trim());
            
        }else if(ae.getSource()==back)
        {
            setVisible(false);
            new Home();
        }
        else if(ae.getSource()==det)
        {
            setVisible(false);
            new viewemp();
        }
        else if(ae.getSource()==skill)
        {
            setVisible(false);
            new viewempskill();
        }
        else if(ae.getSource()==dept)
        {
            setVisible(false);
            new viewempdept();
        }
        else if(ae.getSource()==perfor)
        {
            setVisible(false);
            new viewempperfor();
        }
        
        
        
    } 
    
    public static void main(String[] args) {
        new viewempproj();
    }
    
}

