package client;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import vo.Member;
import client.MenuUI;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Login extends JFrame implements ActionListener {

	private JTextField textid;
	private JPasswordField textpsw;
	private JButton okButt;
	private JButton regButt;
	private JPanel panel;
	private ClientManager cm=new ClientManager(null);
	Member mb=null;
	private JLabel label_1;
	public String taNum;
	
	public Login(String taNum) {
		this.taNum=taNum;
		setTitle("로그인");
		setSize(312, 272);
		setResizable(false);
		panel = new JPanel();
		setLocation(600, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// getContentPane().add(panel, BorderLayout.CENTER);

		loginPanel(panel);

		getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("\u2190");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new join(taNum);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 16));
		btnNewButton.setBounds(0, 0, 49, 23);
		panel.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setBounds(0, 0, 306, 244);
		panel.add(label);
		
		label_1 = new JLabel("New label");
		label_1.setIcon(new ImageIcon("src/img/login.png"));
		label_1.setBounds(0, 0, 306, 244);
		panel.add(label_1);

		setVisible(true);
	}

	public void loginPanel(JPanel panel) {
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uB85C \uADF8 \uC778");
		lblNewLabel.setForeground(new Color(255, 102, 102));
		lblNewLabel.setFont(new Font("한컴 소망 M", Font.BOLD, 20));
		lblNewLabel.setBounds(114, 28, 109, 35);
		panel.add(lblNewLabel);

		textid = new JTextField();
		textid.setBounds(107, 84, 116, 21);
		panel.add(textid);
		textid.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
		lblNewLabel_1.setForeground(new Color(255, 140, 0));
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(29, 87, 57, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_2.setForeground(new Color(255, 140, 0));
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(29, 134, 57, 15);
		panel.add(lblNewLabel_2);

		okButt = new JButton("\uB85C\uADF8\uC778");
		okButt.setBounds(37, 189, 97, 23);
		panel.add(okButt);

		regButt = new JButton("\uD68C\uC6D0\uAC00\uC785");
		regButt.setBounds(170, 189, 97, 23);
		panel.add(regButt);

		textpsw = new JPasswordField();
		textpsw.setBounds(107, 131, 116, 21);
		panel.add(textpsw);

		regButt.addActionListener(this);
		okButt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object select = e.getSource();
		String butt;
		if (select instanceof JButton) {
			butt = ((JButton) select).getActionCommand();
			if (butt.equals("회원가입")) {
				dispose();
				new Regist(taNum);
			} else if(butt.equals("로그인")) {
				String id=textid.getText();
				String psw=textpsw.getText();
				mb=new Member(id, psw);
				if(cm.loginuser(mb)){
					
					JOptionPane.showMessageDialog(this, "어서오세요");
					new MenuUI(id,taNum);
					dispose();
				}else{
					JOptionPane.showMessageDialog(this, "입력하신정보가 틀렸습니다");
				}
						
			}

		}
	}
}
