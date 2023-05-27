import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

 class forgot implements ActionListener{
	
	JFrame jfforgot;
	JLabel collagecode,emailid,username,password,repassword,alert;
	TextField collage_code,email_id,user_name,pass_word,repass_word;
	Button submit,change;
	
	
	forgot(){
		jfforgot=new JFrame("Create an Account");
		jfforgot.setLayout(null);  
		jfforgot. setSize(500, 250);  
		jfforgot. setLocation(500, 25);
	    
		
		
		username=new JLabel("Enter the username");
		username.setBounds(10, 30, 200, 20);
		jfforgot.add(username);
		
		
		user_name=new TextField();
		user_name.setBounds(10, 50, 200, 20);
		jfforgot.add(user_name);
		
		
		
        collagecode=new JLabel("Enter the collage code");
        collagecode.setBounds(10, 70, 200, 20);
        jfforgot.add(collagecode);
        
        
        collage_code= new TextField();
        collage_code.setBounds(10, 90, 200, 20);
        jfforgot.add(collage_code);
        
        
        emailid= new JLabel("Enter the Email ID");
        emailid.setBounds(10, 110, 200, 20);
        jfforgot.add(emailid);
        
        
        email_id= new TextField();
        email_id.setBounds(10, 130, 200, 20);	
        jfforgot.add(email_id);
        
        
        
        submit=new Button("Submit");
        submit.setBounds(80, 160, 40, 20);
        submit.addActionListener(this);
        jfforgot.add(submit);
        
        
        password=new JLabel();
        password.setBounds(250, 30, 200, 20);
        jfforgot.add(password);
        
        
        pass_word=new TextField();
        pass_word.setBounds(250, 50, 200, 20);
       
        
        
        repassword= new JLabel();
        repassword.setBounds(250, 70, 200, 20);
        
        
        
        
        repass_word=new TextField();
        repass_word.setBounds(250, 90, 200, 20);
        
        
        change=new Button("Change the password");
        change.setBounds(270, 120, 150, 20);
        
        
        alert=new JLabel();
        alert.setBounds(225, 170, 230, 20);
        alert.setForeground(Color.red);
        jfforgot.add(alert);

        
        
        jfforgot.add(pass_word);
		jfforgot.add(repassword);
		jfforgot.add(repass_word);
		jfforgot.add(change);
        
        
	       
		jfforgot.setVisible(true);
		jfforgot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String username=user_name.getText();
		String collagecode=collage_code.getText();
		String emailid=email_id.getText();
		
		boolean done=true;
		
		Connection connection;
		
		if (e.getSource()==submit) {
			alert.setText("");
			if(username.equals("")||collagecode.equals("")||emailid.equals("")) {
				
				alert.setText("Complete the field");
				done=false;
				
			}
			if(done==true) {
			
			
			try {
				
				
				// below two lines are used for connectivity.
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Collage",
					"root", "");

				// Collage is database
				// root is name of database
				// "" is password of database
				
				
				//Statement stmt = connection.createStatement();
				
				
				
				
				//String qury="INSERT INTO "+Username+" (password,Firstname,Secondname,Email_id,Collage_name,Collage_code)VALUES('"+Password+"','"+firstname+"','"+secondname+"','"+Emailid+"','"+collagename+"','"+collagecode+"')";
				//stmt.executeUpdate(qury);
				
				// inserting data into the sql
				
				
				String qury1="select*from "+username;
						    
				PreparedStatement ps = connection.prepareStatement(qury1); 
				ResultSet rs = ps.executeQuery(); {

			        while (rs.next()) {
			        	System.out.println("___________________________");
			          String sqlemailid=rs.getString("Email_id");
			          String sqlcollagecode=rs.getString("collage_code");
			          
			          
			          System.out.println("___________________________");
			          System.out.println("\nEmail: "+sqlemailid+"\nCollage code: "+sqlcollagecode);
			          System.out.println("___________________________");
			          if(emailid.equals(sqlemailid)||collagecode.equals(sqlcollagecode)) {
			        	  password.setText("Enter new Password");
			        	  repassword.setText("Re Enter the Password");
			        	  this.username.setText("");
			        	  this.emailid.setText("");
			        	  this.collagecode.setText("");
			          }else {
			        	  alert.setText("Emailid or Collage code is not matched");
			          }
			          
			          

			            // do something with the extracted data...
			        }
			} 
				}
				
			catch (Exception exception) {
				System.out.println(exception);
						
			}
			}
			
			
			
		}
		// TODO Auto-generated method stub
		
	}
	
}


