package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import vo.Member;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Regist extends JFrame implements ActionListener {



	private JPanel panel;
	private JTextField textID;
	private JTextField textName;
	private JTextField textpNum;
	private JButton entButt;
	private JButton backButt;
	private JPasswordField textPsw;
	ClientManager cm=new ClientManager(null);
	private String taNum;
	private JLabel label;
	
	public Regist(String taNum) {
		this.taNum=taNum;
		setTitle("회원가입");
		setSize(314, 406);
		setResizable(false);
		panel = new JPanel();
		setLocation(600, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		registPanel(panel);

		getContentPane().add(panel);

		textID = new JTextField();
		textID.setBounds(157, 112, 116, 21);
		panel.add(textID);
		textID.setColumns(10);

		textName = new JTextField();
		textName.setBounds(157, 208, 116, 21);
		panel.add(textName);
		textName.setColumns(10);

		textpNum = new JTextField(); 
		textpNum.setBounds(157, 256, 116, 21);
		panel.add(textpNum);
		textpNum.setColumns(10);

		entButt = new JButton("\uB4F1    \uB85D");
		entButt.setFont(new Font("서울한강체 B", Font.BOLD, 14));
		entButt.setForeground(Color.WHITE);
		entButt.setBackground(new Color(0, 153, 102));
		entButt.setBounds(34, 324, 97, 23);
		panel.add(entButt);

		backButt = new JButton("\uCDE8    \uC18C");
		backButt.setFont(new Font("서울한강체 B", Font.BOLD, 14));
		backButt.setForeground(Color.WHITE);
		backButt.setBackground(new Color(0, 153, 102));
		backButt.setBounds(157, 324, 97, 23);
		panel.add(backButt);

		textPsw = new JPasswordField();
		textPsw.setBounds(157, 161, 116, 21);
		panel.add(textPsw);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\05-18\\Desktop\\img\\reg.png"));
		label.setBounds(0, 0, 310, 380);
		panel.add(label);

		setVisible(true);
		entButt.addActionListener(this);
		backButt.addActionListener(this);

	}

	public void registPanel(JPanel panel) {

		panel.setLayout(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object select = e.getSource();
		Member mb=null;
		
		
		if (select instanceof JButton) {
			String butt = ((JButton) select).getActionCommand();
			if (butt.equals("취    소")) {
				dispose();
				new Login(taNum);
			} else if (butt.equals("등    록")) {
				String ID=textID.getText();
				String psw=textPsw.getText();
				String name=textName.getText();
				String pNum=textpNum.getText();
				mb=new Member(ID, psw, name, pNum);
				if(cm.adduser(mb)){
					dispose();
					JOptionPane.showMessageDialog(this, "등록 되었습니다");
					new Login(taNum);
				}else{
					JOptionPane.showMessageDialog(this, "등록실패");
				}
				
			}
		}
	}

}
