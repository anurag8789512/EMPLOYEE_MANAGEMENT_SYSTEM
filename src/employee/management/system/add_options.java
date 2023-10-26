
package employee.management.system;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class add_options extends JFrame implements ActionListener{
    
    int c1=0,c2=0,c3=0,c4=0,c5=0;
    JButton add1,add2,add3,add4,add5,add6,add7;
    Choice ch;
    JTextField jt;
    add_options(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("ADD");
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
        Image img2=img1.getImage().getScaledInstance(1120,700, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(0,0,1120,700);
        add(image);
        
        JLabel jlb1=new JLabel("Add Employee Details");
        jlb1.setBounds(60,60,350,30);
        jlb1.setForeground(Color.CYAN);
        jlb1.setFont(new Font("serif",Font.BOLD,25));
        image.add(jlb1);
        
        add1=new JButton("ADD+");
        add1.setBackground(Color.BLACK);
        add1.setForeground(Color.WHITE);
        add1.setBounds(410,60,100,30);
        add1.addActionListener(this);
        image.add(add1);
        
        JLabel jlb2=new JLabel("Add Employee Department");
        jlb2.setBounds(60,140,350,30);
        jlb2.setForeground(Color.CYAN);
        jlb2.setFont(new Font("serif",Font.BOLD,25));
        image.add(jlb2);
        
        add2=new JButton("ADD+");
        add2.setBackground(Color.BLACK);
        add2.setForeground(Color.WHITE);
        add2.setBounds(410,140,100,30);
        add2.addActionListener(this);
        image.add(add2);
        
        JLabel jlb3=new JLabel("Add Employee Project");
        jlb3.setBounds(60,220,350,30);
        jlb3.setForeground(Color.CYAN);
        jlb3.setFont(new Font("serif",Font.BOLD,25));
        image.add(jlb3);
        
        add3=new JButton("ADD+");
        add3.setBackground(Color.BLACK);
        add3.setForeground(Color.WHITE);
        add3.setBounds(410,220,100,30);
        add3.addActionListener(this);
        image.add(add3);
        
        
        JLabel jlb4=new JLabel("Add Employee Skill");
        jlb4.setBounds(60,300,350,30);
        jlb4.setForeground(Color.CYAN);
        jlb4.setFont(new Font("serif",Font.BOLD,25));
        image.add(jlb4);
        
        add4=new JButton("ADD+");
        add4.setBackground(Color.BLACK);
        add4.setForeground(Color.WHITE);
        add4.setBounds(410,300,100,30);
        add4.addActionListener(this);
        image.add(add4);
        
        JLabel jlb5=new JLabel("Add Employee Performance");
        jlb5.setBounds(60,380,350,30);
        jlb5.setForeground(Color.CYAN);
        jlb5.setFont(new Font("serif",Font.BOLD,25));
        image.add(jlb5);
        
        add5=new JButton("ADD+");
        add5.setBackground(Color.BLACK);
        add5.setForeground(Color.WHITE);
        add5.setBounds(410,380,100,30);
        add5.addActionListener(this);
        image.add(add5);
        
        
        ch=new Choice();
        ch.setBounds(60,460,200,30);
        image.add(ch);
        ch.setVisible(false);
        
        jt=new JTextField();
        jt.setBounds(60,460,200,30);
        image.add(jt);
        jt.setVisible(false);
        

        
        add6=new JButton("ADD+");
        add6.setBackground(Color.BLACK);
        add6.setForeground(Color.WHITE);
        add6.setBounds(300,455,100,30);
        add6.addActionListener(this);
        add6.setVisible(false);
        image.add(add6);
        
        
        add7=new JButton("BACK");
        add7.setBackground(Color.BLACK);
        add7.setForeground(Color.WHITE);
        add7.setBounds(330,600,100,30);
        add7.addActionListener(this);
        image.add(add7);
        
        
        setSize(800, 700);
        setLocation(350,50);
        setVisible(true);
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae){
        Conn c=new Conn();
        
        if(ae.getSource()==add1){
            setVisible(false);
            new addemp();
        }
        else if(ae.getSource()==add7){
            setVisible(false);
            new Home();
        }
        else if(ae.getSource()==add2){
            ch.removeAll();
            jt.setVisible(false);
            c1++;
            try{
            
            String query=" select empid from emp_detail where NOT EXISTS (select empid from dept where emp_detail.empid=dept.empid);";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                ch.add(rs.getString("empid"));
            }
            }catch(Exception e){
                    e.printStackTrace();
                    }
            ch.setVisible(true);
            add6.setVisible(true);
            
        }
        else if(ae.getSource()==add3){
            ch.removeAll();
            jt.setVisible(false);
            c2++;
            try{
            
            String query="select empid from emp_detail;";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                ch.add(rs.getString("empid"));
            }
            }catch(Exception e){
                    e.printStackTrace();
                    }
            ch.setVisible(true);
            add6.setVisible(true);
            
        }
        else if(ae.getSource()==add4){
            ch.removeAll();
            jt.setVisible(false);
            c3++;
            try{
            
            String query=" select empid from emp_detail where NOT EXISTS (select empid from skills where emp_detail.empid=skills.empid);";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                ch.add(rs.getString("empid"));
            }
            }catch(Exception e){
                    e.printStackTrace();
                    }
            
            ch.setVisible(true);
            add6.setVisible(true);
            
        }
        else if(ae.getSource()==add5){
            c4++;
            ch.setVisible(false);
            jt.setVisible(true);
            add6.setVisible(true);
        }
        else if(ae.getSource()==add6){
            if(c1>c2 && c1>c3 && c1>c4){
                setVisible(false);
                new addempdept(ch.getSelectedItem());
            }
            else if(c2>c1 && c2>c3 && c2>c4){
                setVisible(false);
                new addempproj(ch.getSelectedItem());
            }
            else if(c3>c1 && c3>c2 && c3>c4){
                setVisible(false);
                new addempskill(ch.getSelectedItem());
            }
            else if(c4>c1 && c4>c3 && c4>c2){
                setVisible(false);
                new addempperfor(jt.getText().trim());
            }
        }
    }
    
    public static void main(String[] args) {
        new add_options();
    }
    
}
