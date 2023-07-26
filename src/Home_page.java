import java.awt.Button;
	import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Home_page implements ActionListener {
	
	JFrame jf;	
	

	
	TextField j;
	
	JLabel welcome;
	
	JButton CSE,ai;
	
	Button date;
	boolean datecse=false,dateai=false;
	
	
	Home_page(){
		
		
		
		
		
		
		jf=new JFrame("Project_X");
	    jf.setLayout(null);
	    jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    jf.setUndecorated(false);
	    
	    
	    welcome=new JLabel("Collage_name");
	    welcome.setBounds(0, 0, 10000, 260);
	    welcome.setForeground(Color.red);
	    welcome.setBackground(Color.LIGHT_GRAY);
	    welcome.setFont(new Font("Courier", Font.BOLD, 100));
	    welcome.setOpaque(true);
	    jf.add(welcome);  
	    
	    
	    CSE=new JButton("CSE");
	    CSE.setBounds(10, 280, 75, 25);
	    CSE.addActionListener(this);
	    jf.add(CSE);
	    
	    
	    ai=new JButton("AI");
	    ai.setBounds(10, 320, 75, 25);
	    ai.addActionListener(this);
	    jf.add(ai);
	    
	    
	   
	    date=new Button("2022-2028");
	    date.addActionListener(this);
	    date.setBounds(100, 280, 75, 25);
	    jf.add(date);
	    
	    jf.setVisible(true);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==CSE) {
			System.out.println("CSE pressed");
			datecse=true;
		}
		 if(e.getSource()==ai) {
			System.out.println("AI presssed");
			dateai=true;
			
		}
		if (e.getSource()==date) {
			//System.out.println("Date Button");
			if (datecse==true) {
				System.out.println("cse Date enter");
				dateai=false;
				datecse=false;
			}
			else if (dateai==true) {
				System.out.println("Ai date enter");
				datecse=false;
				dateai=false;
			}
		}
	}

}

