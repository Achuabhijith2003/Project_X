import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home_page implements ActionListener {
	
	JFrame jf;
	
	JLabel welcome;
	
	
	Home_page(){
		jf=new JFrame("Home page");
	    jf.setLayout(null);
	    jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    jf.setUndecorated(false);
	    
	    welcome= new JLabel("KMCT");
	    welcome.setBounds(20, 10, 500, 900);
	    welcome.setForeground(Color.red);
	    jf.add(welcome);
	    
	    
	    jf.setVisible(true);
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

