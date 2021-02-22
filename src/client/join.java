package client;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import vo.Member;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;

public class join extends JFrame implements ActionListener {
	private JButton mberButt;
	private JButton nonButt;
	private JPanel panel;
	private JButton btnJoin;
	private JButton btnCall;
	private String taNum;
	Member mb;
	ClientManager cm=new ClientManager(null);
	private JButton button;
	public join(String taNum) {
		this.taNum=taNum;
		setTitle("주점");
		setSize(403, 298);
		setResizable(false);
		panel = new JPanel();
		setLocation(600, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// getContentPane().add(panel, BorderLayout.CENTER);

		Join(panel);

		getContentPane().add(panel);
		
		button = new JButton("\u2190");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainClient();
				dispose();
				
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 13));
		button.setBounds(0, 0, 49, 23);
		panel.add(button);

		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src/img/welcom.gif"));
		lblNewLabel.setBounds(0, 0, 387, 257);
		panel.add(lblNewLabel);
		
		
		setVisible(true);
	}

	public void Join(JPanel panel) {
		panel.setLayout(null);

		mberButt = new JButton("\uD68C\uC6D0");
		mberButt.setForeground(Color.BLACK);
		mberButt.setBackground(SystemColor.controlHighlight);
		mberButt.setBounds(58, 20, 97, 48);
		panel.add(mberButt);

		nonButt = new JButton("\uBE44\uD68C\uC6D0");
		nonButt.setForeground(Color.BLACK);
		nonButt.setBackground(SystemColor.controlHighlight);
		nonButt.setBounds(211, 20, 97, 48);
		panel.add(nonButt);
		
		btnCall = new JButton("\uD638\uCD9C");
		btnCall.setForeground(Color.BLACK);
		btnCall.setBackground(SystemColor.controlHighlight);
		btnCall.setBounds(58, 180, 97, 48);
		panel.add(btnCall);
		
		btnJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnJoin.setForeground(Color.BLACK);
		btnJoin.setBackground(SystemColor.controlHighlight);
		btnJoin.setBounds(211, 180, 97, 48);
		panel.add(btnJoin);

		
		mberButt.addActionListener(this);
		nonButt.addActionListener(this);
		btnCall.addActionListener(this);
		btnJoin.addActionListener(this);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object select = e.getSource();
		String butt;
		if (select instanceof JButton) {
			butt = ((JButton) select).getActionCommand();
			if (butt.equals("회원")) {
				dispose();
				new Login(taNum);
			}else if (butt.equals("비회원")) {
				String id="guest";
				String pwd="guest";
				mb=new Member(id,pwd);
				dispose();
				JOptionPane.showMessageDialog(this, "어서오세요");
				new MenuUI(id,taNum);
			}else if(butt.equals("회원가입")){
				dispose();
				new Regist(taNum);
			}else if(butt.equals("호출")){
				cm.call(taNum);
				JOptionPane.showMessageDialog(null, "호출 되었습니다 잠시만 기다려 주세요");
			}
			
		}
	}
}
