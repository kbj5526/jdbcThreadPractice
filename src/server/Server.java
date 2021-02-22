package server;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import vo.Member;
import vo.Menu;
import vo.Sales;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class Server extends JFrame implements ActionListener, MouseListener {

	// static ArrayList<ObjectOutputStream> oList = new ArrayList<>();

	public JButton table_1;
	public JButton table_2;
	public JButton table_3;
	public JButton table_4;
	public JButton table_5;
	public JButton table_6;
	public JButton table_7;
	public JButton table_8;
	public JButton table_9;
	public JButton table_10;
	public JButton table_11;
	public JButton table_12;
	public JButton table_13;
	public JButton table_14;
	public JButton table_15;
	public JButton table_16;
	public JButton newMenuCom;
	public JList list;
	public ArrayList<Sales> sList;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ServerSocket ss;
	private Socket socket;
	private ServerManager sm = new ServerManager();
	public ArrayList<Sales> salesListAll;
	public ArrayList<Sales> salesList;
	public ArrayList<Sales> newSales = new ArrayList<>();
	static ArrayList<ObjectOutputStream> oosList = new ArrayList<>();
	public ArrayList<Sales> salesTable = new ArrayList<>();
	private int listIndex = -1;
	public ArrayList<JButton> btnList = new ArrayList<>();
	private ServerThread st;
	private int tn = -1;
	public JTextArea textArea;
	private JList showList;
	private JPanel showPanel;
	public JTextField accText;
	public JScrollPane scrollPane;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}

	public Server() {
		getContentPane().setBackground(new Color(102, 153, 255));
		// TODO Auto-generated constructor stub

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(621, 495);
		getContentPane().setLayout(null);
		setResizable(false);
		setLocation(600, 250);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 358, 581, 94);
		getContentPane().add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);

		JLabel lblNewLabel = new JLabel("\uC694\uAD6C\uC0AC\uD56D");
		scrollPane.setColumnHeaderView(lblNewLabel);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 188, 468, 153);
		getContentPane().add(scrollPane_1);

		list = new JList();
		scrollPane_1.setViewportView(list);
		list.addMouseListener(this);

		JLabel lblNewLabel_1 = new JLabel("\uC0C8\uB85C\uC6B4 \uC8FC\uBB38 \uB0B4\uC5ED");
		scrollPane_1.setColumnHeaderView(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(12, 10, 581, 168);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 4, 4, 2));

		table_1 = new JButton("1");
		table_1.setFont(new Font("굴림", Font.BOLD, 12));
		table_1.setForeground(Color.WHITE);
		table_1.setBackground(new Color(51, 51, 0));
		panel.add(table_1);
		table_1.addActionListener(this);
		btnList.add(table_1);

		table_2 = new JButton("2");
		table_2.setFont(new Font("굴림", Font.BOLD, 12));
		table_2.setForeground(Color.WHITE);
		table_2.setBackground(new Color(51, 51, 0));
		panel.add(table_2);
		table_2.addActionListener(this);
		btnList.add(table_2);

		table_3 = new JButton("3");
		table_3.setFont(new Font("굴림", Font.BOLD, 12));
		table_3.setForeground(Color.WHITE);
		table_3.setBackground(new Color(51, 51, 0));
		panel.add(table_3);
		table_3.addActionListener(this);
		btnList.add(table_3);

		table_4 = new JButton("4");
		table_4.setFont(new Font("굴림", Font.BOLD, 12));
		table_4.setForeground(Color.WHITE);
		table_4.setBackground(new Color(51, 51, 0));
		panel.add(table_4);
		table_4.addActionListener(this);
		btnList.add(table_4);

		table_5 = new JButton("5");
		table_5.setFont(new Font("굴림", Font.BOLD, 12));
		table_5.setForeground(Color.WHITE);
		table_5.setBackground(new Color(51, 51, 0));
		panel.add(table_5);
		table_5.addActionListener(this);
		btnList.add(table_5);

		table_6 = new JButton("6");
		table_6.setFont(new Font("굴림", Font.BOLD, 12));
		table_6.setForeground(Color.WHITE);
		table_6.setBackground(new Color(51, 51, 0));
		panel.add(table_6);
		table_6.addActionListener(this);
		btnList.add(table_6);

		table_7 = new JButton("7");
		table_7.setFont(new Font("굴림", Font.BOLD, 12));
		table_7.setForeground(Color.WHITE);
		table_7.setBackground(new Color(51, 51, 0));
		panel.add(table_7);
		table_7.addActionListener(this);
		btnList.add(table_7);

		table_8 = new JButton("8");
		table_8.setFont(new Font("굴림", Font.BOLD, 12));
		table_8.setForeground(Color.WHITE);
		table_8.setBackground(new Color(51, 51, 0));
		panel.add(table_8);
		table_8.addActionListener(this);
		btnList.add(table_8);

		table_9 = new JButton("9");
		table_9.setFont(new Font("굴림", Font.BOLD, 12));
		table_9.setForeground(Color.WHITE);
		table_9.setBackground(new Color(51, 51, 0));
		panel.add(table_9);
		table_9.addActionListener(this);
		btnList.add(table_9);

		table_10 = new JButton("10");
		table_10.setFont(new Font("굴림", Font.BOLD, 12));
		table_10.setForeground(Color.WHITE);
		table_10.setBackground(new Color(51, 51, 0));
		panel.add(table_10);
		table_10.addActionListener(this);
		btnList.add(table_10);

		table_11 = new JButton("11");
		table_11.setFont(new Font("굴림", Font.BOLD, 12));
		table_11.setForeground(Color.WHITE);
		table_11.setBackground(new Color(51, 51, 0));
		panel.add(table_11);
		table_11.addActionListener(this);
		btnList.add(table_11);

		table_12 = new JButton("12");
		table_12.setFont(new Font("굴림", Font.BOLD, 12));
		table_12.setForeground(Color.WHITE);
		table_12.setBackground(new Color(51, 51, 0));
		panel.add(table_12);
		table_12.addActionListener(this);
		btnList.add(table_12);

		table_13 = new JButton("13");
		table_13.setFont(new Font("굴림", Font.BOLD, 12));
		table_13.setForeground(Color.WHITE);
		table_13.setBackground(new Color(51, 51, 0));
		panel.add(table_13);
		table_13.addActionListener(this);
		btnList.add(table_13);

		table_14 = new JButton("14");
		table_14.setFont(new Font("굴림", Font.BOLD, 12));
		table_14.setForeground(Color.WHITE);
		table_14.setBackground(new Color(51, 51, 0));
		panel.add(table_14);
		table_14.addActionListener(this);
		btnList.add(table_14);

		table_15 = new JButton("15");
		table_15.setFont(new Font("굴림", Font.BOLD, 12));
		table_15.setForeground(Color.WHITE);
		table_15.setBackground(new Color(51, 51, 0));
		panel.add(table_15);
		table_15.addActionListener(this);
		btnList.add(table_15);

		table_16 = new JButton("16");
		table_16.setFont(new Font("굴림", Font.BOLD, 12));
		table_16.setForeground(Color.WHITE);
		table_16.setBackground(new Color(51, 51, 0));
		panel.add(table_16);
		table_16.addActionListener(this);
		btnList.add(table_16);

		showPanel = new JPanel();
		showPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_3 = new JScrollPane();
		showPanel.add(scrollPane_3, BorderLayout.CENTER);

		showList = new JList();
		scrollPane_3.setViewportView(showList);

		accText = new JTextField();
		showPanel.add(accText, BorderLayout.SOUTH);
		accText.setColumns(30);
		accText.setEditable(false);

		newSales = sm.salesListAll();
		list.setListData(newSales.toArray());

		/*
		 * for (int j = 0; j < newSales.size(); j++) {
		 * newSales.get(j).getTableNum(); }
		 */

		newMenuCom = new JButton("\uC644\uB8CC");
		newMenuCom.setFont(new Font("굴림", Font.BOLD, 12));
		newMenuCom.setForeground(Color.WHITE);
		newMenuCom.setBackground(new Color(51, 51, 0));
		newMenuCom.setBounds(505, 205, 88, 44);
		getContentPane().add(newMenuCom);
		newMenuCom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (sm.complete(((Sales) list.getSelectedValue()).getNum())) {
					newSales = sm.salesListAll();
					list.setListData(newSales.toArray());
					for (int i = 0; i < btnList.size(); i++) {
						salesList = sm.salesList(String.valueOf(i + 1));
						if (salesList.size()!=0) {
							st.btnSetText(String.valueOf(i + 1));
						}
					}
				} else {
					JOptionPane.showConfirmDialog(null, "선택하세요");
				}
			}
		});

		JButton button = new JButton("\uCDE8\uC18C");
		button.setFont(new Font("굴림", Font.BOLD, 12));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(51, 51, 0));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sm.delete(((Sales) list.getSelectedValue()).getNum())) {
					newSales = sm.salesListAll();
					list.setListData(newSales.toArray());
					for (int i = 0; i < btnList.size(); i++) {
						salesList = sm.salesList(String.valueOf(i + 1));
						if (salesList != null) {
							st.btnSetText(String.valueOf(i + 1));
						}
					}
				} else {
					JOptionPane.showConfirmDialog(null, "선택하세요");
				}
			}
		});
		button.setBounds(505, 262, 88, 44);
		getContentPane().add(button);

		setVisible(true);
		connect();

		for (int i = 0; i < btnList.size(); i++) {
			salesList = sm.salesList(String.valueOf(i + 1));
			if (salesList != null) {
				st.btnSetText(String.valueOf(i + 1));
			}
		}
		// for (int i = 1; i < 17; i++) {
		// System.out.println("11");
		// salesTable = sm.salesList(String.valueOf(i));
		// System.out.println(salesTable.get(i).getMenuName());
		// st.btnSetText(String.valueOf(i),salesTable);
		// }

	}

	public void connect() {
		try {
			ss = new ServerSocket(8900);

			while (true) {
				socket = ss.accept();
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
				oosList.add(oos);
				st = new ServerThread(this, ois, oos, oosList);
				Thread t = new Thread(st);
				t.start();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == table_1) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("1");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("1");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("1")) {
					table_1.setText("1");
					// st.btn(true);
					// }else{
					// st.btn(false);
				}

			}
		} else if (e.getSource() == table_2) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("2");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("2");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("2")) {
					table_2.setText("2");
					// st.btn(true);
					// }else{
					// st.btn(false);
				}
			}
		} else if (e.getSource() == table_3) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("3");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("3");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("3")) {
					table_3.setText("3");
					// st.btn(true);
					// }else{
					// st.btn(false);
				}
			}
		} else if (e.getSource() == table_4) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("4");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("4");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("4")) {
					table_4.setText("4");
					// st.btn(true);
					// }else{
					// st.btn(false);
				}
			}
		} else if (e.getSource() == table_5) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("5");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("5");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("5")) {
					table_5.setText("5");
					// st.btn(true);
					// }else{
					// st.btn(false);
				}
			}
		} else if (e.getSource() == table_6) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("6");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("6");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("6")) {
					table_6.setText("6");
				}
			}
		} else if (e.getSource() == table_7) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("7");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("7");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("7")) {
					table_7.setText("7");
				}
			}
		} else if (e.getSource() == table_8) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("8");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("8");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("8")) {
					table_8.setText("8");
				}
			}
		} else if (e.getSource() == table_9) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("9");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("9");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("9")) {
					table_9.setText("9");
				}
			}
		} else if (e.getSource() == table_10) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("10");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("10");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("10")) {
					table_10.setText("10");
				}
			}
		} else if (e.getSource() == table_11) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("11");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("11");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("11")) {
					table_11.setText("11");
				}
			}
		} else if (e.getSource() == table_12) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("12");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("12");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("12")) {
					table_12.setText("12");
				}
			}
		} else if (e.getSource() == table_13) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("13");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("13");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("13")) {
					table_13.setText("13");
				}
			}
		} else if (e.getSource() == table_14) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("14");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("14");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("14")) {
					table_14.setText("14");
				}
			}
		} else if (e.getSource() == table_15) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("15");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("15");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("15")) {
					table_15.setText("15");
				}
			}
		} else if (e.getSource() == table_16) {
			ArrayList<Sales> accSalesList = new ArrayList<>();
			accSalesList = sm.accSalesList("16");
			showList.setListData(accSalesList.toArray());
			int sum = st.btnSetText2("16");
			if (accSalesList.size() != 0) {
				if (accSalesList.get(0).getUserID().equals("guest")){
					accText.setText(sum + " 원 입니다. 계산하겠습니까?");
				}else{
					accText.setText(sum + " 원 입니다. 계산하겠습니까? (회원 할인 10%)");
				}
			}
			int num = JOptionPane.showConfirmDialog(null, showPanel, null, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (num == 0) {
				if (sm.pay("16")) {
					table_16.setText("16");
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		listIndex = list.getSelectedIndex();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
