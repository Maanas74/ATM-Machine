package atm;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class splash_screen extends JFrame
{
	  JLabel l1,l2,l3,l4;
	    ImageIcon img1;
	    JTextField f1;
	   public splash_screen()
	    {
	        setLayout(null);
	        setSize(1920,1080);
	        setLocationRelativeTo(this);
	        setUndecorated(true);
	        l2=new JLabel("WELCOMES YOU");
	        l2.setForeground(Color.RED);
	        l2.setFont(new Font("Arial", Font.ITALIC,80));
	        l2.setBounds(200,200,1000,1000);
	        add(l2);
	        l3= new JLabel("ABC BANK");
	        l3.setForeground(Color.RED);
	        l3.setFont(new Font("Arial", Font.ITALIC, 80));
	        l3.setBounds(1000,10,1000,500);
	        add(l3);
	        l4= new JLabel("ATM");
	        l4.setForeground(Color.RED);
	        l4.setFont(new Font("Arial", Font.ITALIC, 80));
	        l4.setBounds(1100,10,1000,700);
	        add(l4);
	        img1=new ImageIcon("src/images/atm_splash.jpg");
	        l1=new JLabel(img1);
	        add(l1);
	       l1.setBounds(0,0,1920,1080);
	       l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));

	        setVisible(true);
	        try
	        {
	            Thread.sleep(3000);
	            new digit();
	            dispose();
	 
	        }catch(InterruptedException e){
	         System.out.println(e);
	        }
	        
	    }
}

class digit extends JFrame implements ActionListener
{
	JTextField t1;
	JLabel l1,l2,l3,l4,l5;
	  ImageIcon img1;
	  JButton b1,b2;
	public digit()
	{
		 setLayout(null);
	        setSize(1920,1080);
	        setLocationRelativeTo(this);
	        setUndecorated(true);
	        l5= new JLabel("ABC BANK");
	        l5.setForeground(Color.RED);
	        l5.setFont(new Font("Arial", Font.ITALIC, 80));
	        l5.setBounds(700,10,1000,200);
	        add(l5);
	        l2= new JLabel("ATM");
	        l2.setForeground(Color.RED);
	        l2.setFont(new Font("Arial", Font.ITALIC, 80));
	        l2.setBounds(800,10,1000,400);
	        add(l2);
		l3=new JLabel("Enter the number between 10 and 99 ");
		l4=new JLabel("For example:- 25");
		t1=new JTextField();
		l3.setBounds(100,600,1960,70);
		t1.setBounds(800,800,50,50);
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Arial", Font.ITALIC, 80));
		l4.setBounds(500,700,1000,70);
		l4.setForeground(Color.BLUE);
		l4.setFont(new Font("Arial", Font.ITALIC, 80));
		Font font1 = new Font("Arial", Font.BOLD, 30);
		t1.setFont(font1);
		add(l3);
		add(l4);
		add(t1);
		b1=new JButton("Enter");
		b1.setBounds(720,870,100,50);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.setBounds(830,870,100,50);
		add(b2);
		b2.addActionListener(this);
		  img1=new ImageIcon("src/images/atm_splash.jpg");
	        l1=new JLabel(img1);
	        add(l1);
	       l1.setBounds(0,0,1920,1080);
	       l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));
           
	        setVisible(true);
	}
	        public void actionPerformed(ActionEvent e){  
		   		String S=t1.getText();
		   		int n=0;
	        	if (e.getSource() == b1)
		   		 {
	        		if(S.isEmpty()==true)
		   			 {
		   				 JOptionPane.showMessageDialog(null,"Please Enter the number between 10 and 99");
		   			 }
	        		else
	        		{
	        			try {
	        			 n=Integer.parseInt(S);
	        			 if(n>=10 && n<=99)
			   		        {
	        				 new pin();
	        				 dispose();
			   		        }
	        			 else
	        			 {
	        				 JOptionPane.showMessageDialog(null,"Please Enter the number between 10 and 99");
	        			 }
	        			}catch (Exception ex) {
	        				
	        			}
	        			}
	        			
		   		 }
	        	else if(e.getSource() == b2)
	        	{
	        		System.exit(0);
	        	}
}
}

class database
{
	 public Connection con,con1;
		public database()
		    {
		        try{
		          
		            Class.forName("com.mysql.jdbc.Driver");
		            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
		            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","");
		        }
		        catch(Exception e)
		        {
		        	JOptionPane.showMessageDialog(null,"Server is down. Please retry after some time");
		        	System.exit(0);
		        }
		    }
		    
}

class pin extends JFrame implements ActionListener
{
	JPasswordField t1;
	JLabel l1,l2,l3,l4;
	  ImageIcon img1;
	  JButton b1,b2;
	  database db=new database();
	  int z=0;
	public pin()
	{
		setLayout(null);
        setSize(1920,1080);
        setLocationRelativeTo(this);
        setUndecorated(true);
	  l1= new JLabel("ABC BANK");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Arial", Font.ITALIC, 80));
        l1.setBounds(700,10,1000,200);
        add(l1);
        l2= new JLabel("ATM");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Arial", Font.ITALIC, 80));
        l2.setBounds(800,10,1000,400);
        add(l2);
       l4=new JLabel("Enter Your 4-digit PIN ");
   	l4.setForeground(Color.BLUE);
	l4.setFont(new Font("Arial", Font.ITALIC, 80));
	l4.setBounds(500,600,1960,85);
	add(l4);
	t1=new JPasswordField();
    t1.setEchoChar('*');
	t1.setBounds(800,700,100,50);
	Font font1 = new Font("Arial", Font.BOLD, 30);
	t1.setFont(font1);
	add(t1);
	b1=new JButton("Enter");
	b1.setBounds(750,770,100,50);
	add(b1);
	b1.addActionListener(this);
	b2=new JButton("Exit");
	b2.setBounds(860,770,100,50);
	add(b2);
	b2.addActionListener(this);
    img1=new ImageIcon("src/images/atm_splash.jpg");
    l3=new JLabel(img1);
    add(l3);
   l3.setBounds(0,0,1920,1080);
   l3.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(),Image.SCALE_AREA_AVERAGING)));
   
	setVisible(true);
	}
	public void actionPerformed(ActionEvent e){  
		String S=t1.getText();
   		int n=0;
    	if (e.getSource() == b1)
   		 {
    		if(S.isEmpty()==true)
   			 {
   				 JOptionPane.showMessageDialog(null,"Please Enter Your 4-digit PIN");
   			 }
    		else
    		{
    			try {
    			 n=Integer.parseInt(S);
    			 Statement stmt=db.con.createStatement();  
    			 ResultSet rs=stmt.executeQuery("select * from details");  
    			 while(rs.next())
    			 {
    				 if(rs.getInt("PIN") == n)
    				 {
    				 break;
    				 }
    			 }
    			 if(rs.getInt("PIN") == n)
				 {
				 new choices(rs.getInt("PIN"));
				 dispose();
				 }
    			 else
    			 {
    				 JOptionPane.showMessageDialog(null,"Please Enter A Valid PIN");
    			 }
    			 }catch(Exception ae){ 
    				 JOptionPane.showMessageDialog(null,"Please Enter A Valid PIN");
    			 }
    			}
    			
   		 }
    	else if(e.getSource() == b2)
    	{
    		System.exit(0);
    	}
   		 }
}

class choices extends JFrame implements ActionListener
{ 
	JLabel l1,l2;
    ImageIcon img1;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int z;
	public choices(int a)
	{
		 setLayout(null);
	        setSize(1920,1080);
	        setLocationRelativeTo(this);
	        setUndecorated(true);
	        l1= new JLabel("ABC BANK");
	        l1.setForeground(Color.RED);
	        l1.setFont(new Font("Arial", Font.ITALIC, 80));
	        l1.setBounds(700,10,1000,200);
	        add(l1);
	        l2= new JLabel("ATM");
	        l2.setForeground(Color.RED);
	        l2.setFont(new Font("Arial", Font.ITALIC, 80));
	        l2.setBounds(800,10,1000,400);
	        add(l2);
	        b1=new JButton("Transfer Money");
	        b2=new JButton("Fast Cash");
	        b3=new JButton("Deposit");
	        b4=new JButton("Withdraw");
	        b5=new JButton("Phone NO. Update");
	        b6=new JButton("Balance Enquiry");
	        b7=new JButton("Pin Change");
	        b8=new JButton("Mini Statement");
	        b9=new JButton("Exit");
	        b1.setBounds(50,400,200,100);
	        b2.setBounds(1500,400,200,100);
	        b3.setBounds(50,510,200,100);
	        b4.setBounds(1500,510,200,100);
	        b5.setBounds(50,620,200,100);
	        b6.setBounds(1500,620,200,100);
	        b7.setBounds(50,730,200,100);
	        b8.setBounds(1500,730,200,100);
	        b9.setBounds(820,900,100,70);
	        add(b1);
	        add(b2);
	        add(b3);
	        add(b4);
	        add(b5);
	        add(b6);
	        add(b7);
	        add(b8);
	        add(b9);
	        b1.addActionListener(this);
	        b2.addActionListener(this);
	        b3.addActionListener(this);
	        b4.addActionListener(this);
	        b5.addActionListener(this);
	        b6.addActionListener(this);
	        b7.addActionListener(this);
	        b8.addActionListener(this);
	        b9.addActionListener(this);
	        img1=new ImageIcon("src/images/atm_splash.jpg");
	        l1=new JLabel(img1);
	        add(l1);
	       l1.setBounds(0,0,1920,1080);
	       l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));

	        setVisible(true);
	        z=a;
	}
	public void actionPerformed(ActionEvent e){  
		if(e.getSource() == b1)
		{
			new sav_cur(z,1);
			dispose();
		}
		else if(e.getSource() == b2)
		{
			new sav_cur(z,2);
			dispose();
		}
	else if (e.getSource() == b3)
		 {
		new sav_cur(z,3);
			 dispose();
		 }
		 else if (e.getSource() == b4)
		 {
			 new sav_cur(z,4);
			 dispose();
		 }
		 else if(e.getSource() == b5)
		 {
			 new Phone_Registration(z);
			 dispose();
		 }
	else if (e.getSource() == b6)
		 {
		new sav_cur(z,5);
			 dispose();
		 }
		 else if (e.getSource() == b7)
		 {
			 new Pin_Change(z);
			 dispose();
		 }
		 else if(e.getSource() == b8)
			{
			 new sav_cur(z,6);
				dispose();
			}
		 else if(e.getSource() == b9)
		 {
			 System.exit(0);
		 }
}  
}

class sav_cur extends JFrame implements ActionListener
{
	JLabel l1,l2;
    ImageIcon img1;
    JButton b1,b2,b3;
    int z,y;
	public sav_cur(int a,int b)
	{
		 setLayout(null);
	        setSize(1920,1080);
	        setLocationRelativeTo(this);
	        setUndecorated(true);
	        l1= new JLabel("ABC BANK");
	        l1.setForeground(Color.RED);
	        l1.setFont(new Font("Arial", Font.ITALIC, 80));
	        l1.setBounds(700,10,1000,200);
	        add(l1);
	        l2= new JLabel("ATM");
	        l2.setForeground(Color.RED);
	        l2.setFont(new Font("Arial", Font.ITALIC, 80));
	        l2.setBounds(800,10,1000,400);
	        add(l2);
	        b1=new JButton("Current Acc.");
	        b2=new JButton("Savings Acc.");
	        b3=new JButton("Exit");
	        b1.setBounds(1500,620,200,100);
	        b2.setBounds(1500,730,200,100);
	        b3.setBounds(820,900,100,70);
	        add(b1);
	        add(b2);
	        add(b3);
	        b1.addActionListener(this);
	        b2.addActionListener(this);
	        b3.addActionListener(this);
	        img1=new ImageIcon("src/images/atm_splash.jpg");
	        l1=new JLabel(img1);
	        add(l1);
	       l1.setBounds(0,0,1920,1080);
	       l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));

	        setVisible(true);
	        z=a;
	        y=b;
	}
public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1)
		{
			switch(y)
			{
			case 1:
				new Transfer_Money(z);
				dispose();
				break;
			case 2:
				new Fast_Cash(z);
				dispose();
				break;
			case 3:
				new Deposit(z);
				 dispose();
				break;
			case 4:
				 new withdraw(z);
				 dispose();
				break;
			case 5:
				  new balance(z);
					 dispose();
				break;
			case 6:
				new Mini_Statement(z);
				dispose();
				break;
			}
		}
		else if(e.getSource()==b2)
		{
			switch(y)
			{
			case 1:
				new Transfer_Money(z);
				dispose();
				break;
			case 2:
				new Fast_Cash(z);
				dispose();
				break;
			case 3:
				new Deposit(z);
				 dispose();
				break;
			case 4:
				 new withdraw(z);
				 dispose();
				break;
			case 5:
				  new balance(z);
					 dispose();
				break;
			case 6:
				new Mini_Statement(z);
				dispose();
				break;
			}
		}
		else if(e.getSource()==b3)
		{
			System.exit(0);
		}
	}
}
class Transfer_Money extends JFrame implements ActionListener
{
	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	  ImageIcon img1;
	  JButton b1,b2;
	  database db=new database();
	  int z;
	public Transfer_Money(int a)
	{
		setLayout(null);
        setSize(1920,1080);
        setLocationRelativeTo(this);
        setUndecorated(true);
	  l1= new JLabel("ABC BANK");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Arial", Font.ITALIC, 80));
        l1.setBounds(700,10,1000,200);
        add(l1);
        l2= new JLabel("ATM");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Arial", Font.ITALIC, 80));
        l2.setBounds(800,10,1000,400);
        add(l2);
        l4=new JLabel("Name of Person ");
       	l4.setForeground(Color.RED);
    	l4.setFont(new Font("Arial", Font.ITALIC, 50));
    	l4.setBounds(50,400,500,70);
    	add(l4);
    	t1=new JTextField();
		t1.setBounds(510,400,400,70);
		Font font1 = new Font("Arial", Font.BOLD, 40);
		t1.setFont(font1);
		add(t1);
		l5=new JLabel("Name of Bank");
       	l5.setForeground(Color.RED);
    	l5.setFont(new Font("Arial", Font.ITALIC, 50));
    	l5.setBounds(50,480,500,70);
    	add(l5);
    	t2=new JTextField();
		t2.setBounds(510,480,400,70);
		t2.setFont(font1);
		add(t2);
		l6=new JLabel("Account Number ");
       	l6.setForeground(Color.RED);
    	l6.setFont(new Font("Arial", Font.ITALIC, 50));
    	l6.setBounds(50,560,500,70);
    	add(l6);
    	t3=new JTextField();
		t3.setBounds(510,560,400,70);
		t3.setFont(font1);
		add(t3);
		l7=new JLabel("IFSC code ");
       	l7.setForeground(Color.RED);
    	l7.setFont(new Font("Arial", Font.ITALIC, 50));
    	l7.setBounds(50,640,500,70);
    	add(l7);
    	t4=new JTextField();
		t4.setBounds(510,640,400,70);
		t4.setFont(font1);
		add(t4);
		l8=new JLabel("Amount ");
       	l8.setForeground(Color.RED);
    	l8.setFont(new Font("Arial", Font.ITALIC, 50));
    	l8.setBounds(50,720,500,70);
    	add(l8);
    	t5=new JTextField();
		t5.setBounds(510,720,400,70);
		t5.setFont(font1);
		add(t5);
		b1=new JButton("Enter");
		b1.setBounds(750,870,100,50);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.setBounds(860,870,100,50);
		add(b2);
		b2.addActionListener(this);
        img1=new ImageIcon("src/images/atm_splash.jpg");
	    l3=new JLabel(img1);
	    add(l3);
	   l3.setBounds(0,0,1920,1080);
	   l3.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(),Image.SCALE_AREA_AVERAGING)));
	   
		setVisible(true);
		z=a;
	}
	public void actionPerformed(ActionEvent e){
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t3.getText();
		String s4=t4.getText();
		String s5=t5.getText();
		int n=0,m=0;
    	if (e.getSource() == b1)
   		 {
    		if(s1.isEmpty()==true || s2.isEmpty()==true || s3.isEmpty()==true || s4.isEmpty()==true || s5.isEmpty()==true )
 			 {
 				 JOptionPane.showMessageDialog(null,"Please Enter the Values");
 			 }
  		else{
  			try
  			{
  				int i=0,j=0,l=0;
  				m=Integer.parseInt(s3);
  				Statement stmt=db.con.createStatement();  
  				Statement stmt1=db.con.createStatement();  
  				 ResultSet rs=stmt.executeQuery("select * from details "+ ";");
  				ResultSet rt=stmt1.executeQuery("select * from details WHERE PIN = "+ z + ";");
  				while(rs.next())
  				{
  					if(s1.equals(rs.getString("Username")) && s2.equals(rs.getString("Bank_Name")) && m==rs.getInt("Account_no.") && s4.equals(rs.getString("IFSC_code")))
  					{
  						while(rt.next())
  						{
  						n=Integer.parseInt(s5);
  						if(n>=500 && n<=30000)
  						{
  						if(rt.getInt("Amount")>=n)
  						{
  						i=rs.getInt("Amount")+n;
  						String w= "UPDATE details SET Amount = " + i + " WHERE Username = " + "'" + s1 + "'" + ";";
  							j=rt.getInt("Amount")-n;
  							String h= "UPDATE details SET Amount = " + j + " WHERE PIN = " + z + ";";
  							String r="INSERT INTO statement("+"Username,"+"PIN,"+"Amount,"+"Deb_Cre)"+" VALUES(?,?,?,?)";
  	 			        	PreparedStatement ps = db.con.prepareStatement(r);
  	 			            	String ht= rt.getString("Username");
                                String q="DR";
  	 			                ps.setString(1, ht);
  	 			                ps.setInt(2, z);
  	 			                ps.setInt(3, n);
  	 			                ps.setString(4, q);
  	 			                ps.executeUpdate();
  							stmt.executeUpdate(w);
  							stmt1.executeUpdate(h);
  						JOptionPane.showMessageDialog(null,"Transfer is done");
					     JOptionPane.showMessageDialog(null,"Your Account Balance is " + j );
					     new end();
  					     dispose();
  						}
  						else
  						{
  							JOptionPane.showMessageDialog(null,"Your Account Does not have Enough Balance");
  						}
  						}
  						else
  						{
  							JOptionPane.showMessageDialog(null,"You can transfer min:- 500 and max:- 30000");
  							l++;
  						}
  						}
  					}	
  				}
  				if(l>=1)
  				{
  					
  				}
  				else
					{
						JOptionPane.showMessageDialog(null,"Values are not matched. Please check it and enter again");
					}
  			}catch(Exception ae){ 
  				
  			 }
  		}
   		 }
    	else if(e.getSource() == b2)
    	{
    		System.exit(0);
    	}
		
	}
}

class Fast_Cash extends JFrame implements ActionListener
{
	JTextField t1;
	JLabel l1,l2,l3,l4;
	  ImageIcon img1;
	  JButton b1,b2;
	  database db=new database();
	  int z;
	public Fast_Cash(int a)
	{
		setLayout(null);
        setSize(1920,1080);
        setLocationRelativeTo(this);
        setUndecorated(true);
	  l1= new JLabel("ABC BANK");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Arial", Font.ITALIC, 80));
        l1.setBounds(700,10,1000,200);
        add(l1);
        l2= new JLabel("ATM");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Arial", Font.ITALIC, 80));
        l2.setBounds(800,10,1000,400);
        add(l2);
        l4=new JLabel("Enter Only 500, 2000, 5000 or 10000 as a Amount  ");
       	l4.setForeground(Color.BLUE);
    	l4.setFont(new Font("Arial", Font.ITALIC, 80));
    	l4.setBounds(50,600,1960,70);
    	add(l4);
    	t1=new JTextField();
		t1.setBounds(780,700,150,50);
		Font font1 = new Font("Arial", Font.BOLD, 30);
		t1.setFont(font1);
		add(t1);
		b1=new JButton("Enter");
		b1.setBounds(750,770,100,50);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.setBounds(860,770,100,50);
		add(b2);
		b2.addActionListener(this);
        img1=new ImageIcon("src/images/atm_splash.jpg");
	    l3=new JLabel(img1);
	    add(l3);
	   l3.setBounds(0,0,1920,1080);
	   l3.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(),Image.SCALE_AREA_AVERAGING)));
	   
		setVisible(true);
		z=a;
	}
	public void actionPerformed(ActionEvent e){
		String S=t1.getText();
		int n=0;
    	if (e.getSource() == b1)
   		 {
    		if(S.isEmpty()==true)
 			 {
 				 JOptionPane.showMessageDialog(null,"Please Enter the Amount");
 			 }
  		else{
  			try {
  		
				int i=0;
 			 n=Integer.parseInt(S);
 			Statement stmt=db.con.createStatement();  
			 ResultSet rs=stmt.executeQuery("select * from details where PIN= " + z);
			 while(rs.next())
			 {
 			         if(rs.getInt("Amount")<n)
 			         {
 			        	JOptionPane.showMessageDialog(null,"Your Account Does not have Enough Balance");
 			         }
 			         else if(n==500 || n==2000 || n==5000 || n==10000)
 			         {
 			        	 i=rs.getInt("Amount")-n;
 			        	String w= "UPDATE details SET Amount = " + i + " WHERE PIN = " + z;
 			        	String rt="INSERT INTO statement("+"Username,"+"PIN,"+"Amount,"+"Deb_Cre)"+" VALUES(?,?,?,?)";
 			        	PreparedStatement ps = db.con.prepareStatement(rt);
 			            	String h= rs.getString("Username");
 			            	 String q="DR";
 			                ps.setString(1, h);
 			                ps.setInt(2, z);
 			                ps.setInt(3, n);
 			               ps.setString(4, q);
 			                ps.executeUpdate();
 					     stmt.executeUpdate(w);
 					     JOptionPane.showMessageDialog(null,"Transaction is done");
 					     JOptionPane.showMessageDialog(null,"Your Account Balance is " + i );
 					    new end();
 					     dispose();
 			         }
 			         else
 			         {
 			        	JOptionPane.showMessageDialog(null,"Please Enter Only 500, 2000, 5000 or 10000 as a Amount ");
 			         }
 			 }
  		}catch(Exception ae){ 			 
		 }
  		}
   		 }
    	else if(e.getSource() == b2)
    	{
    		System.exit(0);
    	}
	}
}

class Deposit extends JFrame implements ActionListener
{
	JTextField t1;
	JLabel l1,l2,l3,l4;
	  ImageIcon img1;
	  JButton b1,b2;
	  database db=new database();
	  int z;
	public Deposit(int a)
	{
		setLayout(null);
        setSize(1920,1080);
        setLocationRelativeTo(this);
        setUndecorated(true);
	  l1= new JLabel("ABC BANK");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Arial", Font.ITALIC, 80));
        l1.setBounds(700,10,1000,200);
        add(l1);
        l2= new JLabel("ATM");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Arial", Font.ITALIC, 80));
        l2.setBounds(800,10,1000,400);
        add(l2);
        l4=new JLabel("Enter the Amount You want to Deposit");
       	l4.setForeground(Color.BLUE);
    	l4.setFont(new Font("Arial", Font.ITALIC, 80));
    	l4.setBounds(150,600,1960,70);
    	add(l4);
    	t1=new JTextField();
		t1.setBounds(780,700,150,50);
		Font font1 = new Font("Arial", Font.BOLD, 30);
		t1.setFont(font1);
		add(t1);
		b1=new JButton("Enter");
		b1.setBounds(750,770,100,50);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.setBounds(860,770,100,50);
		add(b2);
		b2.addActionListener(this);
        img1=new ImageIcon("src/images/atm_splash.jpg");
	    l3=new JLabel(img1);
	    add(l3);
	   l3.setBounds(0,0,1920,1080);
	   l3.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(),Image.SCALE_AREA_AVERAGING)));
	   
		setVisible(true);
		z=a;	
	}
	public void actionPerformed(ActionEvent e){
		String S=t1.getText();
   		int n=0;
		if (e.getSource() == b1)
  		 {
   		if(S.isEmpty()==true)
  			 {
  				 JOptionPane.showMessageDialog(null,"Please Enter the Amount");
  			 }
   		else {
   			try {
   				int i=0;
      			 n=Integer.parseInt(S);
      			Statement stmt=db.con.createStatement();  
    			 ResultSet rs=stmt.executeQuery("select * from details where PIN= " + z);
    			 while(rs.next())
    			 {
    				 if(n>=100 && n<=20000)
    			   		{
      			         i=rs.getInt("Amount")+n;
      			       String w= "UPDATE details SET Amount = " + i + " WHERE PIN = " + z;
      			     String rt="INSERT INTO statement("+"Username,"+"PIN,"+"Amount,"+"Deb_Cre)"+" VALUES(?,?,?,?)";
			        	PreparedStatement ps = db.con.prepareStatement(rt);
			            	String h= rs.getString("Username");
			            	String q="CR";
			                ps.setString(1, h);
			                ps.setInt(2, z);
			                ps.setInt(3, n);
			                ps.setString(4, q);
			                ps.executeUpdate();
  				     stmt.executeUpdate(w);
  				     JOptionPane.showMessageDialog(null,"Amount is Deposited");
  				     JOptionPane.showMessageDialog(null,"Your Account Balance is " + i );
  				   new end();
				     dispose();
    			   		}
    				 else
    			   		{
    			   			JOptionPane.showMessageDialog(null,"You can deposit Min:- 100 and Max:- 20000");
    			   		}
      			 }
   			}catch(Exception ae){ 
      		
      			 }
	}
   		
}
		else if (e.getSource() == b2)
		{
			System.exit(0);
		}
	}
}
class withdraw extends JFrame implements ActionListener
{
	JTextField t1;
	JLabel l1,l2,l3,l4;
	  ImageIcon img1;
	  JButton b1,b2;
	  database db=new database();
	  int z;
	public withdraw(int a)
	{
		setLayout(null);
        setSize(1920,1080);
        setLocationRelativeTo(this);
        setUndecorated(true);
	  l1= new JLabel("ABC BANK");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Arial", Font.ITALIC, 80));
        l1.setBounds(700,10,1000,200);
        add(l1);
        l2= new JLabel("ATM");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Arial", Font.ITALIC, 80));
        l2.setBounds(800,10,1000,400);
        add(l2);
       l4=new JLabel("Enter the Amount you want to Withdraw ");
   	l4.setForeground(Color.BLUE);
	l4.setFont(new Font("Arial", Font.ITALIC, 80));
	l4.setBounds(150,600,1960,70);
	add(l4);
		t1=new JTextField();
		t1.setBounds(790,700,120,50);
		Font font1 = new Font("Arial", Font.BOLD, 30);
		t1.setFont(font1);
		add(t1);
		b1=new JButton("Enter");
		b1.setBounds(750,770,100,50);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.setBounds(860,770,100,50);
		add(b2);
		b2.addActionListener(this);
	    img1=new ImageIcon("src/images/atm_splash.jpg");
	    l3=new JLabel(img1);
	    add(l3);
	   l3.setBounds(0,0,1920,1080);
	   l3.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(),Image.SCALE_AREA_AVERAGING)));
	   
		setVisible(true);
		z=a;
	}
	 public void actionPerformed(ActionEvent e){ 
		 String S=t1.getText();
	   		int n=0;
			if (e.getSource() == b1)
	  		 {
	   		if(S.isEmpty()==true)
	  			 {
	  				 JOptionPane.showMessageDialog(null,"Please Enter the Amount");
	  			 }
	   		else{
	   			try {
	   		
   				int i=0;
      			 n=Integer.parseInt(S);
      			Statement stmt=db.con.createStatement();  
    			 ResultSet rs=stmt.executeQuery("select * from details where PIN= " + z);
    			 while(rs.next())
    			 {
      			         if(rs.getInt("Amount")<n)
      			         {
      			        	JOptionPane.showMessageDialog(null,"Your Account Does not have Enough Balance");
      			         }
      			         else if(n>=100 && n<=20000)
      			         {
      			        	 i=rs.getInt("Amount")-n;
      			        	String w= "UPDATE details SET Amount = " + i + " WHERE PIN = " + z;
      			        	 String rt="INSERT INTO statement("+"Username,"+"PIN,"+"Amount,"+"Deb_Cre)"+" VALUES(?,?,?,?)";
     			        	PreparedStatement ps = db.con.prepareStatement(rt);
     			            	String h= rs.getString("Username");
     			            	String q="DR";
     			                ps.setString(1, h);
     			                ps.setInt(2, z);
     			                ps.setInt(3, n);
     			               ps.setString(4, q);
     			                ps.executeUpdate();
      					     stmt.executeUpdate(w);
      					     JOptionPane.showMessageDialog(null,"Transaction is done");
      					     JOptionPane.showMessageDialog(null,"Your Account Balance is " + i );
      					     new end();
      					     dispose();
      			         }
      			         else
      			         {
      			        	JOptionPane.showMessageDialog(null,"You can Transact Min :- 100 and Max :- 20000");
      			         }
      			 }
	   		}catch(Exception ae){ 
 			 }
	   		} 
	}
			else if (e.getSource() == b2)
			{
				System.exit(0);
			}
		}
   		 }


class Phone_Registration extends JFrame implements ActionListener
{
	JTextField t1;
	JLabel l1,l2,l3,l4;
	  ImageIcon img1;
	  JButton b1,b2;
	  database db=new database();
	  int z;
	public Phone_Registration(int a)
	{
		setLayout(null);
        setSize(1920,1080);
        setLocationRelativeTo(this);
        setUndecorated(true);
	  l1= new JLabel("ABC BANK");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Arial", Font.ITALIC, 80));
        l1.setBounds(700,10,1000,200);
        add(l1);
        l2= new JLabel("ATM");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Arial", Font.ITALIC, 80));
        l2.setBounds(800,10,1000,400);
        add(l2);
       l4=new JLabel("Enter the Phone No. ");
   	l4.setForeground(Color.BLUE);
	l4.setFont(new Font("Arial", Font.ITALIC, 80));
	l4.setBounds(500,600,1960,70);
	add(l4);
		t1=new JTextField();
		t1.setBounds(760,700,200,50);
		Font font1 = new Font("Arial", Font.BOLD, 30);
		t1.setFont(font1);
		add(t1);
		b1=new JButton("Enter");
		b1.setBounds(740,770,110,50);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.setBounds(870,770,110,50);
		add(b2);
		b2.addActionListener(this);
	    img1=new ImageIcon("src/images/atm_splash.jpg");
	    l3=new JLabel(img1);
	    add(l3);
	   l3.setBounds(0,0,1920,1080);
	   l3.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(),Image.SCALE_AREA_AVERAGING)));
	   
		setVisible(true);
		z=a;
	}
	public void actionPerformed(ActionEvent e){
		String S=t1.getText();
		if (e.getSource() == b1)
 		 {
  		if(S.isEmpty()==true)
 			 {
 				 JOptionPane.showMessageDialog(null,"Please Enter the Phone_No.");
 			 }
  		else
  		{
  			try {
  				Long n=0l;
  				n=Long.parseLong(S);
     			Statement stmt=db.con.createStatement();  
   			 ResultSet rs=stmt.executeQuery("select * from details where PIN= " + z);
   			if(n>=1000000000l && n<=9999999999l)
   	  		{
   			 String w= "UPDATE details SET Phone_No = " + n + " WHERE PIN = " + z;
				     stmt.executeUpdate(w);
				     JOptionPane.showMessageDialog(null,"Phone_No. is Changed");
				     JOptionPane.showMessageDialog(null,"Your Updated Phone No. is " + n );
				     new end();
				     dispose();
   	  		}
   			else
     		 {
     			JOptionPane.showMessageDialog(null,"The Phone_No. Should be of 10 Digits");
     		 }
  			}catch(Exception ae){ 	 
     			 }
	}
}
		else if (e.getSource() == b2)
		{
			System.exit(0);
		}
	}
		 }

class Pin_Change extends JFrame implements ActionListener
{
	JTextField t1;
	JLabel l1,l2,l3,l4;
	  ImageIcon img1;
	  JButton b1,b2;
	  database db=new database();
	  int z;
	public Pin_Change(int a)
	{
		setLayout(null);
        setSize(1920,1080);
        setLocationRelativeTo(this);
        setUndecorated(true);
	  l1= new JLabel("ABC BANK");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Arial", Font.ITALIC, 80));
        l1.setBounds(700,10,1000,200);
        add(l1);
        l2= new JLabel("ATM");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Arial", Font.ITALIC, 80));
        l2.setBounds(800,10,1000,400);
        add(l2);
       l4=new JLabel("Enter the New PIN ");
   	l4.setForeground(Color.BLUE);
	l4.setFont(new Font("Arial", Font.ITALIC, 80));
	l4.setBounds(500,600,1960,70);
	add(l4);
		t1=new JTextField();
		t1.setBounds(790,700,120,50);
		Font font1 = new Font("Arial", Font.BOLD, 30);
		t1.setFont(font1);
		add(t1);
		b1=new JButton("Enter");
		b1.setBounds(750,770,100,50);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.setBounds(860,770,100,50);
		add(b2);
		b2.addActionListener(this);
	    img1=new ImageIcon("src/images/atm_splash.jpg");
	    l3=new JLabel(img1);
	    add(l3);
	   l3.setBounds(0,0,1920,1080);
	   l3.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(),Image.SCALE_AREA_AVERAGING)));
	   
		setVisible(true);
		z=a;
	}
	public void actionPerformed(ActionEvent e){
		String S=t1.getText();
		int n=0;
		if (e.getSource() == b1)
 		 {
  		if(S.isEmpty()==true)
 			 {
 				 JOptionPane.showMessageDialog(null,"Please Enter the 4-digit PIN");
 			 }
  		else
  		{
  			try {
  				n=Integer.parseInt(S);
     			Statement stmt=db.con.createStatement();  
   			 ResultSet rs=stmt.executeQuery("select * from details where PIN= " + z);
   			if(n>=1000 && n<=9999)
   	  		{
   			 String w= "UPDATE details SET PIN = " + n + " WHERE PIN = " + z;
				     stmt.executeUpdate(w);
				     JOptionPane.showMessageDialog(null,"PIN is Changed");
				     JOptionPane.showMessageDialog(null,"Your New PIN is " + n );
				     new end();
				     dispose();
   	  		}
   			else
     		 {
     			JOptionPane.showMessageDialog(null,"The PIN Should be of 4 Digits");
     		 }
  			}catch(Exception ae){ 
     			 }
	}
}
		else if (e.getSource() == b2)
		{
			System.exit(0);
		}
	}
}

class Mini_Statement extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7;
	  ImageIcon img1;
	  JButton b1,b2;
	  database db=new database();
	  int y=350;
	public Mini_Statement(int a)
	{
		setLayout(null);
        setSize(1920,1080);
        setLocationRelativeTo(this);
        setUndecorated(true);
	  l1= new JLabel("ABC BANK");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Arial", Font.ITALIC, 80));
        l1.setBounds(700,10,1000,200);
        add(l1);
        l2= new JLabel("ATM");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Arial", Font.ITALIC, 80));
        l2.setBounds(800,10,1000,400);
        add(l2);
        try
        {
        Statement stmt=db.con.createStatement();  
        Statement stmt1=db.con.createStatement();
	    ResultSet rs=stmt.executeQuery("select * from statement where PIN= " + a +" ORDER BY S_No DESC LIMIT 5");
	    ResultSet rt=stmt1.executeQuery("select * from details where PIN= " + a);
	    while(rs.next())
	    {
	    l3= new JLabel(rs.getString("Date"));
	    l4=new JLabel(rs.getString("Deb_Cre"));
	    String t=String.valueOf(rs.getInt("Amount"));
	    l5=new JLabel(t);
	    l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Arial", Font.ITALIC, 50));
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("Arial", Font.ITALIC, 50));
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Arial", Font.ITALIC, 50));
	    l3.setBounds(250,y,300,100);
        l4.setBounds(600,y,200,100);
        l5.setBounds(1200,y,200,100);
        while(rt.next())
        {
        	l6=new JLabel("EFF AVAIL BAL :-  INR");
        	 l6.setForeground(Color.BLUE);
             l6.setFont(new Font("Arial", Font.ITALIC, 50));
             l6.setBounds(350,850,600,100);
             String y=String.valueOf(rt.getInt("Amount"));
             l7=new JLabel(y);
             l7.setForeground(Color.BLUE);
             l7.setFont(new Font("Arial", Font.ITALIC, 50));
             l7.setBounds(890,850,300,100);
             add(l6);
             add(l7);
        }
        add(l3);
        add(l4);
        add(l5);
        y=y+100;
	    }
        }catch(Exception ae) {
        	JOptionPane.showMessageDialog(null,"Something went wrong");
        }
        b1=new JButton("OK");
		b1.setBounds(750,970,100,50);
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Exit");
		b2.setBounds(860,970,100,50);
		add(b2);
		b2.addActionListener(this);
        img1=new ImageIcon("src/images/atm_splash.jpg");
	    l3=new JLabel(img1);
	    add(l3);
	   l3.setBounds(0,0,1920,1080);
	   l3.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(),Image.SCALE_AREA_AVERAGING)));
	   
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1)
		{
			new end();
			dispose();
		}
		else if(e.getSource()==b2)
		{
			System.exit(0);
		}
	}
}

class balance extends JFrame implements ActionListener
{
	JTextField t1;
	JLabel l1,l2,l3,l4,l5;
	  ImageIcon img1;
	  JButton b1;
	  database db=new database();
	public balance(int a)
	{
		setLayout(null);
        setSize(1920,1080);
        setLocationRelativeTo(this);
        setUndecorated(true);
	  l1= new JLabel("ABC BANK");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Arial", Font.ITALIC, 80));
        l1.setBounds(700,10,1000,200);
        add(l1);
        l2= new JLabel("ATM");
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Arial", Font.ITALIC, 80));
        l2.setBounds(800,10,1000,400);
        add(l2);
       l4=new JLabel("AVAILABLE BALANCE:- ");
   	l4.setForeground(Color.BLUE);
	l4.setFont(new Font("Arial", Font.ITALIC, 80));
	l4.setBounds(500,600,1960,70);
	add(l4);
	try {
		int i=0;
		String z=String.valueOf(a); 
		 Statement stmt=db.con.createStatement(); 
		 String v="SELECT * FROM details" + " WHERE PIN = " + z;
		 ResultSet ws=stmt.executeQuery(v);
		 while(ws.next())
		 {
		 i= ws.getInt("Amount");
		 }
		 String x=String.valueOf(i);
		 l5=new JLabel(x);
		   	l5.setForeground(Color.RED);
			l5.setFont(new Font("Arial", Font.ITALIC, 80));
			l5.setBounds(750,700,1960,70);
			add(l5);
		 }catch(Exception ae){ 
			
		 }
	b1=new JButton("ok");
	b1.setBounds(800,790,100,50);
	add(b1);
	b1.addActionListener(this);
	
	    img1=new ImageIcon("src/images/atm_splash.jpg");
	    l3=new JLabel(img1);
	    add(l3);
	   l3.setBounds(0,0,1920,1080);
	   l3.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(),Image.SCALE_AREA_AVERAGING)));
	   
		setVisible(true);
	}
		public void actionPerformed(ActionEvent e){
             if(e.getSource() == b1)
             { 
            	 new end();
            	 dispose();
             }
		}
	}
	

class end extends JFrame 
{
	Timer timer = new Timer();
	TimerTask exitApp = new TimerTask(){
		public void run() {
		    System.exit(0);
		    }}; 
	 JLabel l1,l2,l3,l4;
	    ImageIcon img1;
	    JTextField f1;
	    database db=new database();
	   public end()
	    {
	        setLayout(null);
	        setSize(1920,1080);
	        setLocationRelativeTo(this);
	        setUndecorated(true);
	        l2=new JLabel("THANK YOU!");
	        l2.setForeground(Color.RED);
	        l2.setFont(new Font("Arial", Font.ITALIC,80));
	        l2.setBounds(200,200,1000,1000);
	        add(l2);
	        l3= new JLabel("ABC BANK");
	        l3.setForeground(Color.RED);
	        l3.setFont(new Font("Arial", Font.ITALIC, 80));
	        l3.setBounds(1000,10,1000,500);
	        add(l3);
	        l4= new JLabel("ATM");
	        l4.setForeground(Color.RED);
	        l4.setFont(new Font("Arial", Font.ITALIC, 80));
	        l4.setBounds(1100,10,1000,700);
	        add(l4);
	        img1=new ImageIcon("src/images/atm_splash.jpg");
	        l1=new JLabel(img1);
	       l1.setBounds(0,0,1920,1080);
	       l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));
	       add(l1);
            setVisible(true);
            timer.schedule(exitApp, new Date(System.currentTimeMillis()+3*1000));
		   }
		   
	    }


public class ATM_MACHINE extends JFrame {
    public static void main(String []args)
{
new splash_screen();
}
}
    



