package client;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class pay extends JFrame {
	private ClientManager cm = new ClientManager(null);
	private JPanel panel;
	public pay(String taNum) {
		
	
		setSize(416, 153);
	
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\uACC4\uC0B0\uC911...");
		label.setFont(new Font("±Ã¼­Ã¼", Font.PLAIN, 60));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 400, 115);
		panel.add(label);
		setLocation(600, 250);
		

		setVisible(true);
		
		
		dispose();
		
		
	}
	
	
}
