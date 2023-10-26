
package employee.management.system;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;


public class Start extends JFrame implements ActionListener{
    
        JButton click,reg,ex;
        Start(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel title= new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        title.setForeground(Color.red);
        title.setBounds(80,30,1200,60);
        title.setFont(new Font("serif",Font.PLAIN,60));
        add(title);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image img2=img1.getImage().getScaledInstance(1100,700, Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        
        JLabel image=new JLabel(img3);
        image.setBounds(50,100,1050,500);
        add(image);
        
        click=new JButton("LOG IN");
        click.setBounds(60,50,300,70);
        click.setBackground(Color.BLACK);
        click.setForeground(Color.WHITE);
        click.addActionListener(this);
        image.add(click);
        
        reg=new JButton("New User!\n Sign up");
        reg.setBounds(60,140,300,70);
        reg.setBackground(Color.BLACK);
        reg.setForeground(Color.WHITE);
        reg.addActionListener(this);
        image.add(reg);
        
        ex=new JButton("EXIT");
        ex.setBounds(50,450,100,30);
        ex.setBackground(Color.BLACK);
        ex.setForeground(Color.WHITE);
        ex.addActionListener(this);
        image.add(ex);
        
        setSize(1170,650);
        setLocation(200,50);
        setTitle("EMPLOYEE MANAGEMENT SYSTEM");
        setVisible(true);
        
        /*    title.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){  
            }
            title.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){  
            }
            
        }
        
    }*/
        
        }
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==click){
           setVisible(false);
           new Logging(); 
        }
        else if(ae.getSource()==reg){
            new register();
            setVisible(false);
        }
        else
        {
            setVisible(false);
            System.exit(0);
        }
        
    }
    
    public static void main(String []args){
        new Start();
    }
}
