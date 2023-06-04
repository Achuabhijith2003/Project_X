import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home_page implements ActionListener {
	
	JFrame jf;
	
	JLabel welcome;
	
	JPanel wel;
	
	
	Home_page(){
		jf=new JFrame("Home page");
	    jf.setLayout(null);
	    jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    jf.setUndecorated(false);
	    
	
	    
	    
	    
	    jf.setVisible(true);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

