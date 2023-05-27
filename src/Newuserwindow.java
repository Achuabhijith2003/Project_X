import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


abstract class Newuserwindow implements ActionListener {
	
	String Alert;
	
	JFrame jfnewuser;
	
	JLabel welcome,firstname,secondname,username,password,repassword,Emailid,Collagename,Collagecode,alert;
	
	TextField first_name,second_name,user_name,Email_id,Collage_name,Collage_code;
	
	JPasswordField pass_word,repass_word;
	
	Button submit;
	
	
	
	
	
	
	Newuserwindow(){ 
		 jfnewuser=new JFrame("Create an Account");
		    jfnewuser.setLayout(null);  
		        jfnewuser. setSize(500, 450);  
		       jfnewuser. setLocation(500, 25);
		       
		       welcome=new JLabel("Create an Account");
		       welcome.setBounds(190, 20, 200, 20);
		       jfnewuser.add(welcome);
		       
		       
		        firstname=new JLabel("First Name");
		        firstname.setBounds(20, 60, 200, 20);
		        jfnewuser.add(firstname);
		        
		        first_name=new TextField(10);
		        first_name.setBounds(20, 80, 200, 20);
		        jfnewuser.add(first_name);
		        
		        
		        secondname=new JLabel("Second Name");
		        secondname.setBounds(20, 100, 200, 20);
		        jfnewuser.add(secondname);
		        
		        second_name=new TextField();
		        second_name.setBounds(20, 120, 200, 20);
		        jfnewuser.add(second_name);
		        
		        username=new JLabel("Username");
		        username.setBounds(20, 140, 200, 20);
		        jfnewuser.add(username);
		        
		        user_name=new TextField();
		        user_name.setBounds(20, 160, 200, 20);
		        jfnewuser.add(user_name);
		        
		        password=new JLabel("Enter the Password");
		        password.setBounds(20, 180, 200, 20);
		        jfnewuser.add(password);
		        
		        pass_word=new JPasswordField(15);
		        pass_word.setBounds(20, 200, 200, 20);
		        jfnewuser.add(pass_word);
		        
		        repassword=new JLabel("Re-enter the password");
		        repassword.setBounds(20,220,200,20);
		        jfnewuser.add(repassword);
		        
		        
		        repass_word=new JPasswordField(15);
		        repass_word.setBounds(20, 240, 200, 20);
		        jfnewuser.add(repass_word);
		        
		        
		        Emailid=new JLabel("Email id");
		        Emailid.setBounds(20, 260, 200, 20);
		        jfnewuser.add(Emailid);
		        
		        
		        Email_id=new TextField();
		        Email_id.setBounds(20, 280, 200, 20);
		        jfnewuser.add(Email_id);
		        
		        
		        Collagename=new JLabel("Collage Name");
		        Collagename.setBounds(20, 300, 200, 20);
		        jfnewuser.add(Collagename);
		        
		        
		        Collage_name=new TextField();
		        Collage_name.setBounds(20, 320, 200, 20);
		        jfnewuser.add(Collage_name);
		        
		        
		        Collagecode=new JLabel("Collage Code");
		        Collagecode.setBounds(20, 340, 200, 20);
		        jfnewuser.add(Collagecode);
		        
		        Collage_code=new TextField();
		        Collage_code.setBounds(20, 360, 200, 20);
		        jfnewuser.add(Collage_code);
		        
		        
		        alert=new JLabel("");
		        alert.setBounds(250, 240, 200, 20);
		        alert.setForeground(Color.red);
		        jfnewuser.add(alert);
		        
		        submit=new Button("Create Account");
		        submit.setBounds( 250,150, 200, 20);
		        submit.addActionListener(this);
		        jfnewuser.add(submit);
		        
		        
		        
		        jfnewuser.setVisible(true);
			    jfnewuser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        
	}
	public void actionPerformed(ActionEvent e) {
		
		Boolean done=false;
		boolean done1=false;
		boolean done2=true;
		boolean done3=true;
		
		Connection Connection=null;
		
		String Username=user_name.getText();
		String Password=pass_word.getText();
		String repasword=repass_word.getText();
		String firstname=first_name.getText();
		String secondname=second_name.getText();
		String collagename=Collage_name.getText();
		String collagecode=Collage_code.getText();
		String Emailid=Email_id.getText();
		
		if(e.getSource()==submit) {
			
			
			
			
			
			if (done==false) {
				if (Username.equals("")|| Password.equals("") || repasword.equals("") || firstname.equals("")|| secondname.equals("")|| collagecode.equals("") || collagename.equals("")|| Emailid.equals("")) {
					System.out.println("Incompete");
					alert.setText("Complete all the Fields");
					done1=true;
					done2=true;
				}
				
			}
			if (done1==false)
			{if (Password.equals(repasword)) {
				alert.setText("Password is same");
				System.out.println("------------------------\npassword is same \nPassword"+Password+"\nRepassword"+repasword+"\n---------------------------");
				done2=false;
				done2=false;
			}else {
				alert.setText("Password is not same Try again!");
				System.out.println("------------------------\npassword is same \nPassword"+Password+"\nRepassword"+repasword+"\n---------------------------");
			}
				
			} if (done2==false){
				
				
				try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage",
						"root", "");
				         Statement stmt = conn.createStatement();
				      ) {		      
					
				          String sql = "CREATE TABLE  " + Username+
				                   " (password Varchar(15), " + 
				                   " Firstname Varchar(30), " +
				                   " Secondname Varchar(30),"+
				                   " Email_id Varchar(50), " + 
				                   " Collage_name Varchar(60),"+
				                   " Collage_code Varchar(6))"; 
				          // createing table with the name of username

				         stmt.executeUpdate(sql);
				         String acountcreated="kk";
				         System.out.println("Created table in given database...");  
				         
				         alert.setText(acountcreated);
				         done3=false;
				         
				      } catch (SQLException e1) {
				         System.out.println(e1);
				         alert.setText("Try Another username it already registed");
				      } 
				
				
			}
			 {
				
			}
			 if (done3==false) {
					
				
			
				//__________________________________________________________________________
				try {
					
					
					// below two lines are used for connectivity.
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/Collage",
						"root", "");

					// Collage is database
					// root is name of database
					// "" is password of database
					
					
					Statement stmt = Connection.createStatement();
					
					
					
					
					String qury="INSERT INTO "+Username+" (password,Firstname,Secondname,Email_id,Collage_name,Collage_code)VALUES('"+Password+"','"+firstname+"','"+secondname+"','"+Emailid+"','"+collagename+"','"+collagecode+"')";
					stmt.executeUpdate(qury);
					
					// inserting data into the sql
					
					
					String qury1="select*from "+Username;
							    
					PreparedStatement ps = Connection.prepareStatement(qury1); 
					ResultSet rs = ps.executeQuery(); {

				        while (rs.next()) {
				        	System.out.println("___________________________");
				          String  sqlFirstname= rs.getString("Firstname");
				          String SqlSecondname = rs.getString("secondname");
				          String sqlpassword=rs.getString("password");
				          String sqlemailid=rs.getString("Email_id");
				          String sqlcollagename=rs.getString("collage_name");
				          String sqlcollagecode=rs.getString("collage_code");
				          
				          
				          System.out.println("___________________________");
				          System.out.println("Firstname: "+sqlFirstname+"\nSecondname: "+SqlSecondname+"\nPassword: "+sqlpassword+"\nEmail: "+sqlemailid+"\nCollage name: "+sqlcollagename+"\nCollage code: "+sqlcollagecode);
				          System.out.println("___________________________");
				          
				          new alertbox();
				          jfnewuser.setVisible(false);

				            // do something with the extracted data...
				        }
				} 
					}
					
				catch (Exception exception) {
					System.out.println(exception);
						
						
				}
				}
			
			
			
			
			
		}
		
	}
	 
}

class alertbox implements ActionListener{
	
	JFrame jfalertbox;
	JLabel message;
	
	Button go;
	
	alertbox(){
		jfalertbox=new JFrame("Create an Account");
		jfalertbox.setLayout(null);  
		jfalertbox. setSize(400, 150);  
		jfalertbox. setLocation(550, 200);
		
		message= new JLabel("Account created");
		message.setBounds(142, 25, 200, 20);
		message.setForeground(Color.green);
		jfalertbox.add(message);
		
		go=new Button("Go to login page");
		go.setBounds(120, 50, 125, 20);
		go.addActionListener(this);
		jfalertbox.add(go);
		
		
		jfalertbox.setVisible(true);
		
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==go) {
			 new Login_page();
			 jfalertbox.setVisible(false);
		}
		if (e.getSource()==go) {
			 new Newuserwindow() {
			};
		}
	}
}



