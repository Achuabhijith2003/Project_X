import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


public class Login_page implements ActionListener{
	
	JFrame jf;
	 
	 
	 JLabel user_name,Pass_word,alert;
	 TextField username;
	 JPasswordField password;
	 Button submit;
	 Button newuser;
	 Button forgot;
	
	 
	   Login_page() {
		  
		  jf=new JFrame("Loging Page");
		    jf.setLayout(null);
		    jf.setBounds(200, 500, 500, 200);
		    jf.setLocation(500, 25);
		    jf.setUndecorated(false);
		    
		    
		    user_name=new JLabel("Username");
		    user_name.setBounds(20, 10, 200, 20);
		    jf.add(user_name);
		    
		    username=new TextField("");
		    username.setBounds(20, 30, 200, 20);
		    jf.add(username);
		    
		    Pass_word=new JLabel("Password");
		    Pass_word.setBounds(20, 50, 200, 20);
		    jf.add(Pass_word);
		    
		    
		    password=new JPasswordField(15);
		    password.setBounds(20, 70, 200, 20);
		    jf.add(password);
		    
		    submit=new Button("Submit");
		    submit.setBounds(20,100,40,20);
		    submit.addActionListener(this);
		    jf.add(submit);
		    
		    newuser=new Button("New User?");
		    newuser.setBounds(295, 30, 60, 20);
		    newuser.addActionListener(this);
		    jf.add(newuser);
		    
		    
		    forgot=new Button("Forgot");
		    forgot.setBounds(300, 60, 40, 20);
		    forgot.addActionListener(this);
		    jf.add(forgot);
		    		
		    
		    alert=new JLabel("");
		    alert.setBounds(150,120,2000,20);
		    alert.setForeground(Color.red);
		    jf.add(alert);
		    
		    jf.setVisible(true);
		    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String sqlunsername = null;
		String sqlpassword =null;
		
		if (e.getSource()==submit){
			String user_name=username.getText();
			@SuppressWarnings("deprecation")
			String pass_word =password.getText();
			Connection Connection =null;
			alert.setText("");
			
			boolean go = false;
			try {
				
				
				// below two lines are used for connectivity.
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Collage",
					"root", "");

				// Collage is database
				// root is name of database
				// "" is password of database
				
				
				
				String qury1="select*from "+user_name;
						    
				PreparedStatement ps = Connection.prepareStatement(qury1); 
				ResultSet rs = ps.executeQuery(); {

			        while (rs.next()) {
			        	System.out.println("___________________________");
			         sqlpassword =rs.getString("password");
			          if (sqlpassword!=pass_word) {
			        	  go=true;
					}
			          
			          
			          System.out.println("___________________________");
			          System.out.println("\nUsername: "+user_name+"\nsqlPassword: "+sqlpassword);
			          System.out.println("___________________________");
			           
			          

			            // do something with the extracted data...
			        }
			} 
				}
				
			catch (Exception exception) {
				System.out.println(exception);
				alert.setText("Username or Password is incorrect");
			}
			
			
			if( pass_word.equals(sqlpassword)) {
				jf.setVisible(false);
				 
				new Home_page();
				
				go=false;
			}
			else if (go==true){
				alert.setText("Password incorrect");
			}
			System.out.println("-----------------------------");
			System.out.println("Username:"+user_name);
			System.out.println("Password:"+pass_word);
			System.out.println("Passwordsql:"+sqlunsername);
		}
		else if  (e.getSource()==newuser) {
			System.out.println("newuser button pressed");
			jf.setVisible(false);
			new Newuserwindow() {
		};
			
		}
			
		else if(e.getSource()==forgot) {
			System.out.println("Forgot button pressed");
			
			 new forgot();
			jf.setVisible(false);
				
		}
	}
	
		
	
	
	public static void main(String[] args) {
		new Login_page();
		 
		}
	
}
