import java.awt.Button;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.plaf.metal.MetalBorders.PaletteBorder;

class forgot implements ActionListener {

	JFrame jfforgot;
	JLabel collagecode, emailid, username, password, repassword, alert;
	TextField collage_code, email_id, user_name;
	JPasswordField pass_word, repass_word;
	Button submit, change;

	forgot() {
		jfforgot = new JFrame("Create an Account");
		jfforgot.setLayout(null);
		jfforgot.setSize(500, 250);
		jfforgot.setLocation(500, 25);

		username = new JLabel("Enter the username");
		username.setBounds(10, 30, 200, 20);
		jfforgot.add(username);

		user_name = new TextField();
		user_name.setBounds(10, 50, 200, 20);
		jfforgot.add(user_name);

		collagecode = new JLabel("Enter the collage code");
		collagecode.setBounds(10, 70, 200, 20);
		jfforgot.add(collagecode);

		collage_code = new TextField();
		collage_code.setBounds(10, 90, 200, 20);
		jfforgot.add(collage_code);

		emailid = new JLabel("Enter the Email ID");
		emailid.setBounds(10, 110, 200, 20);
		jfforgot.add(emailid);

		email_id = new TextField();
		email_id.setBounds(10, 130, 200, 20);
		jfforgot.add(email_id);

		submit = new Button("Submit");
		submit.setBounds(80, 160, 40, 20);
		submit.addActionListener(this);
		jfforgot.add(submit);

		password = new JLabel();
		password.setBounds(250, 30, 200, 20);
		jfforgot.add(password);

		pass_word = new JPasswordField();
		pass_word.setBounds(250, 50, 200, 20);

		repassword = new JLabel();
		repassword.setBounds(250, 70, 200, 20);

		repass_word = new JPasswordField();
		repass_word.setBounds(250, 90, 200, 20);

		change = new Button("Change the password");
		change.addActionListener(this);
		change.setBounds(270, 120, 150, 20);

		alert = new JLabel();
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

		String username = user_name.getText();
		String collagecode = collage_code.getText();
		String emailid = email_id.getText();
		String Password = pass_word.getText();
		String Repassword = repass_word.getText();

		boolean done = true;
		// sboolean done1=true;

		Connection connection;

		if (e.getSource() == submit) {

			alert.setText("");
			if (username.equals("") || collagecode.equals("") || emailid.equals("")) {

				alert.setText("Complete the field");
				done = false;

			}
			if (done == true) {

				try {

					// below two lines are used for connectivity.
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/text_collage","Project_x", "jayakumarreena");

					// Collage is database
					// root is name of database
					// "" is password of database

					String qury1 = "select*from login_details_of_collage";

					PreparedStatement ps = connection.prepareStatement(qury1);
					ResultSet rs = ps.executeQuery();
					{

						while (rs.next()) {
							System.out.println("___________________________");
							String sqlusername=rs.getString("username");
							String sqlemailid = rs.getString("Email_id");
							String sqlcollagecode = rs.getString("collage_code");

							System.out.println("___________________________");
							System.out.println("Username : "+sqlusername+"\nEmail: " + sqlemailid + "\nCollage code: " + sqlcollagecode);
							System.out.println("___________________________");
							if (emailid.equals(sqlemailid) && collagecode.equals(sqlcollagecode) && username.equals(sqlusername)) {
								password.setText("Enter new Password");
								repassword.setText("Re Enter the Password");
								this.username.setText("");
								this.emailid.setText("");
								this.collagecode.setText("");

							} else {
								alert.setText("Emailid or Collage code is not matched");

							}
							// do something with the extracted data...

						}
					}
				}

				catch (Exception exception) {
					System.out.println(exception);
					alert.setText("Username not found");

				}
			}

		}
		if (e.getSource() == change) {
			alert.setText("");

			try {

				// below two lines are used for connectivity.
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/text_collage","Project_x", "jayakumarreena");

				// Collage is database
				// root is name of database
				// "" is password of database

				if (Password.equals(Repassword)) {
					
					String qury = "update login_details_of_collage set password='" + Password + "' where Collage_code='"
							+ collagecode + "'";
					Statement stmt = connection.createStatement();
					stmt.executeUpdate(qury);
					int num=1;
					new alert(num);
					jfforgot.setVisible(false);

				} else {
					alert.setText("Password is not Same");
					System.out.println("Password is not same");
				}
			} catch (Exception e2) {
				System.out.println(e2);
				alert.setText("Please try again");
				// TODO: handle exception
			}

		}

	}

}

class alert implements ActionListener {

	JFrame jfalert;

	JLabel message;

	
	Button go;
	

	alert(int num) {
		

		jfalert = new JFrame("Update Sucessfully");
		jfalert.setLayout(null);
		jfalert.setSize(400, 150);
		jfalert.setLocation(550, 200);
		
		if (num==1) {
			message = new JLabel("Password Changed Sucessfully");
			message.setBounds(100, 25, 200, 20);
			message.setForeground(Color.green);
			jfalert.add(message);
		}
		if(num==2) {
			message = new JLabel("Account created Sucessfully");
			message.setBounds(100, 25, 200, 20);
			message.setForeground(Color.green);
			jfalert.add(message);
		}

		

		go = new Button("Go to login page");
		go.setBounds(120, 50, 125, 20);
		go.addActionListener(this);
		jfalert.add(go);

		jfalert.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == go) {
				jfalert.setVisible(false);
			new Login_page();
			
		}

	}
}
