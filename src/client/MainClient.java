package client;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vo.Sales;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Color;

public class MainClient extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
	private JButton btn11, btn12, btn13, btn14, btn15, btn16;
	private Sales tNum;
	static String taNum = null;
	private JLabel lblL;

	// private ArrayList<JButton> btnTableNum = new ArrayList<>();

	/*
	 * public RoomNum(int tNum){
	 * 
	 * }
	 */
	
	public static void main(String[] args) {
		new MainClient();
	}

	public MainClient() {

		setTitle("Å×ÀÌºí ¼±ÅÃ");
		setSize(571, 601);
		setResizable(false);
		panel = new JPanel();
		setLocation(600, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// getContentPane().add(panel, BorderLayout.CENTER);

		RoomNumpanel(panel);

		getContentPane().add(panel);
		
		lblL = new JLabel("l");
		lblL.setForeground(Color.WHITE);
		lblL.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblL.setIcon(new ImageIcon("src/img/table.png"));
		lblL.setBounds(0, 0, 555, 563);
		panel.add(lblL);

		setVisible(true);

	}

	public void RoomNumpanel(JPanel panel) {

		panel.setLayout(null);

		btn1 = new JButton("1\uBC88 \uD14C\uC774\uBE14");
		btn1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn1.setForeground(Color.WHITE);
		btn1.setBounds(35, 171, 107, 79);
		panel.add(btn1);
		// btnTableNum.add(btn1);

		btn2 = new JButton("2\uBC88 \uD14C\uC774\uBE14");
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn2.setBounds(160, 171, 107, 79);
		panel.add(btn2);
		// btnTableNum.add(btn2);

		btn3 = new JButton("3\uBC88 \uD14C\uC774\uBE14");
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn3.setBounds(284, 171, 107, 79);
		panel.add(btn3);
		// btnTableNum.add(btn3);

		btn4 = new JButton("4\uBC88 \uD14C\uC774\uBE14");
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn4.setBounds(410, 171, 107, 79);
		panel.add(btn4);
		// btnTableNum.add(btn3);

		btn5 = new JButton("5\uBC88 \uD14C\uC774\uBE14");
		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn5.setBounds(35, 262, 107, 79);
		panel.add(btn5);
		// btnTableNum.add(btn3);

		btn6 = new JButton("6\uBC88 \uD14C\uC774\uBE14");
		btn6.setForeground(Color.WHITE);
		btn6.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn6.setBounds(160, 262, 107, 79);
		panel.add(btn6);
		// btnTableNum.add(btn3);

		btn7 = new JButton("7\uBC88 \uD14C\uC774\uBE14");
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn7.setBounds(284, 262, 107, 79);
		panel.add(btn7);
		// btnTableNum.add(btn3);

		btn8 = new JButton("8\uBC88 \uD14C\uC774\uBE14");
		btn8.setForeground(Color.WHITE);
		btn8.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn8.setBounds(410, 262, 107, 79);
		panel.add(btn8);
		// btnTableNum.add(btn3);

		btn9 = new JButton("9\uBC88 \uD14C\uC774\uBE14");
		btn9.setForeground(Color.WHITE);
		btn9.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn9.setBounds(35, 353, 107, 79);
		panel.add(btn9);
		// btnTableNum.add(btn3);

		btn10 = new JButton("10\uBC88 \uD14C\uC774\uBE14");
		btn10.setForeground(Color.WHITE);
		btn10.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn10.setBounds(160, 353, 107, 79);
		panel.add(btn10);
		// btnTableNum.add(btn10);

		btn11 = new JButton("11\uBC88 \uD14C\uC774\uBE14");
		btn11.setForeground(Color.WHITE);
		btn11.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn11.setBounds(284, 353, 107, 79);
		panel.add(btn11);
		// btnTableNum.add(btn11);

		btn12 = new JButton("12\uBC88 \uD14C\uC774\uBE14");
		btn12.setForeground(Color.WHITE);
		btn12.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn12.setBounds(410, 353, 107, 79);
		panel.add(btn12);
		// btnTableNum.add(btn12);

		btn13 = new JButton("13\uBC88 \uD14C\uC774\uBE14");
		btn13.setForeground(Color.WHITE);
		btn13.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn13.setBounds(35, 444, 107, 79);
		panel.add(btn13);
		// btnTableNum.add(btn13);

		btn14 = new JButton("14\uBC88 \uD14C\uC774\uBE14");
		btn14.setForeground(Color.WHITE);
		btn14.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn14.setBounds(160, 444, 107, 79);
		panel.add(btn14);
		// btnTableNum.add(btn14);

		btn15 = new JButton("15\uBC88 \uD14C\uC774\uBE14");
		btn15.setForeground(Color.WHITE);
		btn15.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn15.setBounds(284, 444, 107, 79);
		panel.add(btn15);
		// btnTableNum.add(btn15);

		btn16 = new JButton("16\uBC88 \uD14C\uC774\uBE14");
		btn16.setForeground(Color.WHITE);
		btn16.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btn16.setBounds(410, 444, 107, 79);
		panel.add(btn16);
		// btnTableNum.add(btn16);
		
		btn1.setBorderPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setFocusPainted(false);
		
		btn2.setBorderPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setFocusPainted(false);
		
		btn3.setBorderPainted(false);
		btn3.setContentAreaFilled(false);
		btn3.setFocusPainted(false);
		
		btn4.setBorderPainted(false);
		btn4.setContentAreaFilled(false);
		btn4.setFocusPainted(false);
		
		btn5.setBorderPainted(false);
		btn5.setContentAreaFilled(false);
		btn5.setFocusPainted(false);
	
		btn6.setBorderPainted(false);
		btn6.setContentAreaFilled(false);
		btn6.setFocusPainted(false);
	
		btn7.setBorderPainted(false);
		btn7.setContentAreaFilled(false);
		btn7.setFocusPainted(false);
		
		btn8.setBorderPainted(false);
		btn8.setContentAreaFilled(false);
		btn8.setFocusPainted(false);
		
		btn9.setBorderPainted(false);
		btn9.setContentAreaFilled(false);
		btn9.setFocusPainted(false);
		
		btn10.setBorderPainted(false);
		btn10.setContentAreaFilled(false);
		btn10.setFocusPainted(false);
		
		btn11.setBorderPainted(false);
		btn11.setContentAreaFilled(false);
		btn11.setFocusPainted(false);
		
		btn12.setBorderPainted(false);
		btn12.setContentAreaFilled(false);
		btn12.setFocusPainted(false);
		
		btn13.setBorderPainted(false);
		btn13.setContentAreaFilled(false);
		btn13.setFocusPainted(false);
		
		btn14.setBorderPainted(false);
		btn14.setContentAreaFilled(false);
		btn14.setFocusPainted(false);
		
		btn15.setBorderPainted(false);
		btn15.setContentAreaFilled(false);
		btn15.setFocusPainted(false);
		
		btn16.setBorderPainted(false);
		btn16.setContentAreaFilled(false);
		btn16.setFocusPainted(false);
		
		btn1.setBorderPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setFocusPainted(false);
				
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn13.addActionListener(this);
		btn14.addActionListener(this);
		btn15.addActionListener(this);
		btn16.addActionListener(this);

	}

	public void Join(String taNum) {
		new join(taNum);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object select = e.getSource();

		Sales tNum;

		if (select == btn1) {
			taNum = "1";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn2) {
			taNum = "2";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn3) {
			taNum = "3";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn4) {
			taNum = "4";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn5) {
			taNum = "5";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn6) {
			taNum = "6";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn7) {
			taNum = "7";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn8) {
			taNum = "8";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn9) {
			taNum = "9";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn10) {
			taNum = "10";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn11) {
			taNum = "11";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn12) {
			taNum = "12";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn13) {
			taNum = "13";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn14) {
			taNum = "14";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn15) {
			taNum = "15";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		} else if (select == btn16) {
			taNum = "16";
			// tNum = new Sales(null, 0, 0, tableNum);
			Join(taNum);
			dispose();
		}

	}

	// public void selectTable(String tableNum) {
	// for (int i = 0; i < btnTableNum.size(); i++) {
	// if (btnTableNum.get(i).getText().equals(tableNum)) {
	// new join("16");
	// }
	// }
	// }

}
