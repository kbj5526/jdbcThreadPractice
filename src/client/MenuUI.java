package client;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

import vo.Menu;
import vo.Sales;

import java.awt.Color;
import javax.swing.ImageIcon;

public class MenuUI extends JFrame implements ActionListener {
	JPanel panel, base, pa1, pa2, pa3, pa4;
	CardLayout card = new CardLayout();
	JButton bt1, bt2, bt3, bt4;
	JLabel l1, l2, l3, l4;
	JButton btn1, btn2, btn3, btn4, btn5, btn6;
	JButton btf1, btf2, btf3, btf4, btf5, btf6;
	JButton btb1, btb2, btb3, btb4, btb5, btb6;
	JButton btd1, btd2, btd3, btd4, btd5, btd6;

	private String menuName, tableNum, id, taNum;
	private int price, amount;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JList listAll;
	private ArrayList<Sales> salesList = new ArrayList<>();
	private JButton btnCall;
	private JScrollPane scrollPane_2;
	private JList listBasket;
	private JLabel lblNewLabel_1;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;
	private JButton btnOrder, btnacc;
	private ArrayList<Sales> blist = new ArrayList<>();
	private ArrayList<Menu> Menulist = new ArrayList<>();
	private ClientManager cm = new ClientManager(this);
	boolean flag = false;
	private JLabel label, lblNewLabel;
	private JButton btncancel;
	private int listIndex = -1;
	private JTextField textSum;
	private Object[] listObj;
	private JLabel laldrink1,laldrink2,laldrink3,laldrink4,laldrink5,laldrink6;
	private JLabel lalkushi1,lalkushi2,lalkushi3,lalkushi4,lalkushi5,lalkushi6;
	private JLabel lalfri1,lalfri2,lalfri3,lalfri4,lalfri5,lalfri6;
	private JLabel lalkai1,lalkai2,lalkai3,lalkai4,lalkai5,lalkai6; 
	private JLabel label_11, label_12, label_13,label_14,label_15,label_16;
	private JLabel label_21, label_22, label_23,label_24,label_25,label_26;
	private JLabel label_31, label_32, label_33,label_34,label_35,label_36;
	private JLabel label_41, label_42, label_43,label_44,label_45,label_46;
	private JLabel label_pa1,label_pa2,label_pa3,label_pa4;
	// static String taNum;

	public MenuUI(String id, String taNum) {
		this.id = id;
		this.taNum = taNum;
		System.out.println(this.id + "  " + taNum);
		Menulist = cm.getMenulist();
		setSize(804, 654);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		mainpanel();

		setVisible(true);
	}

	public void mainpanel() {

		textSum = new JTextField();
		textSum.setBounds(496, 560, 163, 35);
		getContentPane().add(textSum);
		textSum.setColumns(20);
		setResizable(false);
		textSum.setEditable(false);

		base = new JPanel();
		base.setBounds(12, 94, 472, 310);
		base.setBackground(new Color(255, 0, 0, 0));
		getContentPane().add(base);
		base.setLayout(card);

		pa1 = new JPanel();
		
		pa1.setBounds(35, 150, 390, 162);

		pa2 = new JPanel();
		
		pa2.setBounds(35, 150, 390, 162);

		pa3 = new JPanel();
		
		pa3.setBounds(35, 150, 390, 162);

		pa4 = new JPanel();
		
		pa4.setBounds(35, 150, 390, 162);

		base.add(pa1, "pa1");
		pa1.setLayout(null);
		
		btn1 = new JButton();
		btn1.addActionListener(this);
		btn1.setBounds(0, 0, 149, 119);
		pa1.add(btn1);

		btn2 = new JButton();
		btn2.addActionListener(this);
		btn2.setBounds(161, 0, 149, 119);
		pa1.add(btn2);

		btn3 = new JButton();
		btn3.addActionListener(this);
		btn3.setBounds(322, 0, 149, 119);
		pa1.add(btn3);

		btn4 = new JButton();
		btn4.addActionListener(this);
		btn4.setBounds(0, 156, 149, 119);
		pa1.add(btn4);

		btn5 = new JButton();
		btn5.addActionListener(this);
		btn5.setBounds(161, 156, 149, 119);
		pa1.add(btn5);

		btn6 = new JButton();
		btn6.addActionListener(this);
		
		lalkushi1 = new JLabel("");
		lalkushi1.setIcon(new ImageIcon("src/drink/레바쿠시.png"));
		lalkushi1.setBounds(0, 0, 149, 119);
		pa1.add(lalkushi1);
		btn6.setBounds(322, 156, 149, 119);
		pa1.add(btn6);

		base.add(pa2, "pa2");
		pa2.setLayout(null);
		btf1 = new JButton();
		btf1.addActionListener(this);
		btf1.setBounds(0, 0, 149, 119);
		pa2.add(btf1);

		btf2 = new JButton();
		btf2.addActionListener(this);
		btf2.setBounds(161, 0, 149, 119);
		pa2.add(btf2);

		btf3 = new JButton();
		btf3.addActionListener(this);
		btf3.setBounds(322, 0, 149, 119);
		pa2.add(btf3);

		btf4 = new JButton();
		btf4.addActionListener(this);
		btf4.setBounds(0, 156, 149, 119);
		pa2.add(btf4);

		btf5 = new JButton();
		btf5.addActionListener(this);
		btf5.setBounds(161, 156, 149, 119);
		pa2.add(btf5);

		btf6 = new JButton();
		btf6.addActionListener(this);
		btf6.setBounds(322, 156, 149, 119);
		pa2.add(btf6);

		base.add(pa3, "pa3");
		pa3.setLayout(null);
		btb1 = new JButton();
		btb1.addActionListener(this);
		btb1.setBounds(0, 0, 149, 119);
		pa3.add(btb1);

		btb2 = new JButton();
		btb2.addActionListener(this);
		btb2.setBounds(161, 0, 149, 119);
		pa3.add(btb2);

		btb3 = new JButton();
		btb3.addActionListener(this);
		btb3.setBounds(322, 0, 149, 119);
		pa3.add(btb3);

		btb4 = new JButton();
		btb4.addActionListener(this);
		btb4.setBounds(0, 156, 149, 119);
		pa3.add(btb4);

		btb5 = new JButton();
		btb5.addActionListener(this);
		btb5.setBounds(161, 156, 149, 119);
		pa3.add(btb5);

		btb6 = new JButton();
		btb6.addActionListener(this);
		btb6.setBounds(322, 156, 149, 119);
		pa3.add(btb6);

		base.add(pa4, "pa4");
		pa4.setLayout(null);
		btd1 = new JButton();
		btd1.addActionListener(this);				
		btd1.setBounds(0, 0, 149, 119);
		pa4.add(btd1);
		
		base.setBackground(new Color(255, 0, 0, 0));	
		
		btd2 = new JButton();
		btd2.addActionListener(this);
		btd2.setBounds(161, 0, 149, 119);
		pa4.add(btd2);
		 
		btd3 = new JButton();
		btd3.addActionListener(this);
		btd3.setBounds(322, 0, 149, 119);
		pa4.add(btd3); 
		
		btd4 = new JButton();
		btd4.addActionListener(this);
		btd4.setBounds(0, 156, 149, 119);
		pa4.add(btd4);
		  
		btd5 = new JButton();
		btd5.addActionListener(this);
		btd5.setBounds(161, 156, 149, 119);
		pa4.add(btd5); 
		
		btd6 = new JButton();
		btd6.addActionListener(this);
		
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
		
		btf1.setBorderPainted(false);
		btf1.setContentAreaFilled(false);
		btf1.setFocusPainted(false);
		
		btf2.setBorderPainted(false);
		btf2.setContentAreaFilled(false);
		btf2.setFocusPainted(false);
		
		btf3.setBorderPainted(false);
		btf3.setContentAreaFilled(false);
		btf3.setFocusPainted(false);
		
		btf4.setBorderPainted(false);
		btf4.setContentAreaFilled(false);
		btf4.setFocusPainted(false);
		
		btf5.setBorderPainted(false);
		btf5.setContentAreaFilled(false);
		btf5.setFocusPainted(false);
		
		btf6.setBorderPainted(false);
		btf6.setContentAreaFilled(false);
		btf6.setFocusPainted(false);
		
		btb1.setBorderPainted(false);
		btb1.setContentAreaFilled(false);
		btb1.setFocusPainted(false);
		
		btb2.setBorderPainted(false);
		btb2.setContentAreaFilled(false);
		btb2.setFocusPainted(false);
		
		btb3.setBorderPainted(false);
		btb3.setContentAreaFilled(false);
		btb3.setFocusPainted(false);
		
		btb4.setBorderPainted(false);
		btb4.setContentAreaFilled(false);
		btb4.setFocusPainted(false);
		
		btb5.setBorderPainted(false);
		btb5.setContentAreaFilled(false);
		btb5.setFocusPainted(false);
	
		btb6.setBorderPainted(false);
		btb6.setContentAreaFilled(false);
		btb6.setFocusPainted(false);
		
		btd1.setBorderPainted(false);
		btd1.setContentAreaFilled(false);
		btd1.setFocusPainted(false);
		
		btd2.setBorderPainted(false);
		btd2.setContentAreaFilled(false);
		btd2.setFocusPainted(false);
		
		btd3.setBorderPainted(false);
		btd3.setContentAreaFilled(false);
		btd3.setFocusPainted(false);
		
		btd4.setBorderPainted(false);
		btd4.setContentAreaFilled(false);
		btd4.setFocusPainted(false);
		
		btd5.setBorderPainted(false);
		btd5.setContentAreaFilled(false);
		btd5.setFocusPainted(false);
		
		btd6.setBorderPainted(false);
		btd6.setContentAreaFilled(false);
		btd6.setFocusPainted(false);
		
		lalkushi1 = new JLabel("");
		lalkushi1.setIcon(new ImageIcon("src/kushi/레바쿠시.png"));
		lalkushi1.setBounds(0, 0, 149, 119);
		pa1.add(lalkushi1);
		
		lalkushi2 = new JLabel("");
		lalkushi2.setBounds(161, 0, 149, 119);
		lalkushi2.setIcon(new ImageIcon("src/kushi/모모쿠시.png"));
		pa1.add(lalkushi2);
		
		lalkushi3 = new JLabel("");
		lalkushi3.setIcon(new ImageIcon("src/kushi/스나기모쿠시.png"));
		lalkushi3.setBounds(322, 0, 149, 119);
		pa1.add(lalkushi3); 
		
		lalkushi4 = new JLabel("");
		lalkushi4.setIcon(new ImageIcon("src/kushi/츠쿠네.png"));
		lalkushi4.setBounds(0, 156, 149, 119);
		pa1.add(lalkushi4);
		
		lalkushi5 = new JLabel("");
		lalkushi5.setIcon(new ImageIcon("src/kushi/츠쿠네치즈.png"));
		lalkushi5.setBounds(161, 156, 149, 119);
		pa1.add(lalkushi5);  
		
		lalkushi6 = new JLabel("");
		lalkushi6.setIcon(new ImageIcon("src/kushi/쿠시모리아와세.png"));
		lalkushi6.setBounds(322, 156, 149, 119);
		pa1.add(lalkushi6);
		
		label_11 = new JLabel(Menulist.get(0).getMenuName());
		label_11.setOpaque(true);
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(0, 129, 149, 21);
		pa1.add(label_11);
		
		label_12 = new JLabel(Menulist.get(1).getMenuName());
		label_12.setOpaque(true);
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(161, 129, 149, 21);
		pa1.add(label_12);
		
		label_13 = new JLabel(Menulist.get(2).getMenuName());
		label_13.setOpaque(true);
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(322, 129, 149, 21);
		pa1.add(label_13);
		
		label_14 = new JLabel(Menulist.get(3).getMenuName());
		label_14.setOpaque(true);
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(0, 285, 149, 21);
		pa1.add(label_14);
		
		label_15 = new JLabel(Menulist.get(4).getMenuName());
		label_15.setOpaque(true);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(161, 285, 149, 21);
		pa1.add(label_15);
		
		label_16 = new JLabel(Menulist.get(5).getMenuName());
		label_16.setOpaque(true);
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setBounds(322, 285, 149, 21);
		pa1.add(label_16);
		
		lalkai1 = new JLabel("");
		lalkai1.setIcon(new ImageIcon("src/kaisen/타코와사비.png"));
		lalkai1.setBounds(0, 0, 149, 119);
		pa2.add(lalkai1);
		
		lalkai2 = new JLabel("");
		lalkai2.setBounds(161, 0, 149, 119);
		lalkai2.setIcon(new ImageIcon("src/kaisen/츠브가이.png"));
		pa2.add(lalkai2);
		
		lalkai3 = new JLabel("");
		lalkai3.setIcon(new ImageIcon("src/kaisen/사몬.png"));
		lalkai3.setBounds(322, 0, 149, 119);
		pa2.add(lalkai3); 
		
		lalkai4 = new JLabel("");
		lalkai4.setIcon(new ImageIcon("src/kaisen/마구로.png"));
		lalkai4.setBounds(0, 156, 149, 119);
		pa2.add(lalkai4);
		
		lalkai5 = new JLabel("");
		lalkai5.setIcon(new ImageIcon("src/kaisen/칸파치.png"));
		lalkai5.setBounds(161, 156, 149, 119);
		pa2.add(lalkai5);  
		
		lalkai6 = new JLabel("");
		lalkai6.setIcon(new ImageIcon("src/kaisen/스시모리아와세.png"));
		lalkai6.setBounds(322, 156, 149, 119);
		pa2.add(lalkai6);
		
		label_21 = new JLabel(Menulist.get(6).getMenuName());
		label_21.setOpaque(true);
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setBounds(0, 129, 149, 21);
		pa2.add(label_21);
		
		label_22 = new JLabel(Menulist.get(7).getMenuName());
		label_22.setOpaque(true);
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBounds(161, 129, 149, 21);
		pa2.add(label_22);
		
		label_23 = new JLabel(Menulist.get(8).getMenuName());
		label_23.setOpaque(true);
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBounds(322, 129, 149, 21);
		pa2.add(label_23);
		
		label_24 = new JLabel(Menulist.get(9).getMenuName());
		label_24.setOpaque(true);
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setBounds(0, 285, 149, 21);
		pa2.add(label_24);
		
		label_25 = new JLabel(Menulist.get(10).getMenuName());
		label_25.setOpaque(true);
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setBounds(161, 285, 149, 21);
		pa2.add(label_25);
		
		label_26 = new JLabel(Menulist.get(11).getMenuName());
		label_26.setOpaque(true);
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setBounds(322, 285, 149, 21);
		pa2.add(label_26);
		
		lalfri1 = new JLabel("");
		lalfri1.setIcon(new ImageIcon("src/fri/소바노카리카리.png"));
		lalfri1.setBounds(0, 0, 149, 119);
		pa3.add(lalfri1);
		
		lalfri2 = new JLabel("");
		lalfri2.setBounds(161, 0, 149, 119);
		lalfri2.setIcon(new ImageIcon("src/fri/포테토.png"));
		pa3.add(lalfri2);
		
		lalfri3 = new JLabel("");
		lalfri3.setIcon(new ImageIcon("src/fri/고로케.png"));
		lalfri3.setBounds(322, 0, 149, 119);
		pa3.add(lalfri3); 
		
		lalfri4 = new JLabel("");
		lalfri4.setIcon(new ImageIcon("src/fri/난코츠.png"));
		lalfri4.setBounds(0, 156, 149, 119);
		pa3.add(lalfri4);
		
		lalfri5 = new JLabel("");
		lalfri5.setIcon(new ImageIcon("src/fri/테바사키.png"));
		lalfri5.setBounds(161, 156, 149, 119);
		pa3.add(lalfri5);  
		
		label_31 = new JLabel(Menulist.get(12).getMenuName());
		label_31.setOpaque(true);
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setBounds(0, 129, 149, 21);
		pa3.add(label_31);
		
		lalfri6 = new JLabel("");
		lalfri6.setIcon(new ImageIcon("src/fri/카라아게.png"));
		lalfri6.setBounds(322, 156, 149, 119);
		pa3.add(lalfri6);
		
		label_32 = new JLabel(Menulist.get(13).getMenuName());
		label_32.setOpaque(true);
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setBounds(161, 129, 149, 21);
		pa3.add(label_32);
		
		label_33 = new JLabel(Menulist.get(14).getMenuName());
		label_33.setOpaque(true);
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setBounds(322, 129, 149, 21);
		pa3.add(label_33);
		
		label_34 = new JLabel(Menulist.get(15).getMenuName());
		label_34.setOpaque(true);
		label_34.setHorizontalAlignment(SwingConstants.CENTER);
		label_34.setBounds(0, 285, 149, 21);
		pa3.add(label_34);
		
		label_35 = new JLabel(Menulist.get(16).getMenuName());
		label_35.setOpaque(true);
		label_35.setHorizontalAlignment(SwingConstants.CENTER);
		label_35.setBounds(161, 285, 149, 21);
		pa3.add(label_35);
		
		label_36 = new JLabel(Menulist.get(17).getMenuName());
		label_36.setOpaque(true);
		label_36.setHorizontalAlignment(SwingConstants.CENTER);
		label_36.setBounds(322, 285, 149, 21);
		pa3.add(label_36);
		
		laldrink1 = new JLabel("");
		laldrink1.setIcon(new ImageIcon("src/drink/나마비루.png"));
		laldrink1.setBounds(0, 0, 149, 119);
		pa4.add(laldrink1);
		
		laldrink2 = new JLabel("New label");
		laldrink2.setBounds(161, 0, 149, 119);
		laldrink2.setIcon(new ImageIcon("src/drink/우롱하이.png"));
		pa4.add(laldrink2);
		
		laldrink3 = new JLabel("");
		laldrink3.setIcon(new ImageIcon("src/drink/레몬사와.png"));
		laldrink3.setBounds(322, 0, 149, 119);
		pa4.add(laldrink3);
		
		
		laldrink4 = new JLabel("");
		laldrink4.setIcon(new ImageIcon("src/drink/카시스오렌지.png"));
		laldrink4.setBounds(0, 156, 149, 119);
		pa4.add(laldrink4);
		
		laldrink5 = new JLabel("");
		laldrink5.setIcon(new ImageIcon("src/drink/하이보루.png"));
		laldrink5.setBounds(161, 156, 149, 119);
		pa4.add(laldrink5);
		
		
		laldrink6 = new JLabel("");
		laldrink6.setIcon(new ImageIcon("src/drink/까루아밀크.png"));
		laldrink6.setBounds(322, 156, 149, 119);
		pa4.add(laldrink6);
		
		label_41 = new JLabel(Menulist.get(18).getMenuName());
		label_41.setOpaque(true);
		label_41.setHorizontalAlignment(SwingConstants.CENTER);
		label_41.setBounds(0, 129, 149, 21);
		pa4.add(label_41);
		
		label_42 = new JLabel(Menulist.get(19).getMenuName());
		label_42.setOpaque(true);
		label_42.setHorizontalAlignment(SwingConstants.CENTER);
		label_42.setBounds(161, 129, 149, 21);
		pa4.add(label_42);
		
		label_43 = new JLabel(Menulist.get(20).getMenuName());
		label_43.setOpaque(true);
		label_43.setHorizontalAlignment(SwingConstants.CENTER);
		label_43.setBounds(322, 129, 149, 21);
		pa4.add(label_43);
		
		label_44 = new JLabel(Menulist.get(21).getMenuName());
		label_44.setOpaque(true);
		label_44.setHorizontalAlignment(SwingConstants.CENTER);
		label_44.setBounds(0, 285, 149, 21);
		pa4.add(label_44);
		
		label_45 = new JLabel(Menulist.get(22).getMenuName());
		label_45.setOpaque(true);
		label_45.setHorizontalAlignment(SwingConstants.CENTER);
		label_45.setBounds(161, 285, 149, 21);
		pa4.add(label_45);
		
		label_46 = new JLabel(Menulist.get(23).getMenuName());
		label_46.setOpaque(true);
		label_46.setHorizontalAlignment(SwingConstants.CENTER);
		label_46.setBounds(322, 285, 149, 21);
		pa4.add(label_46);
		
		btd6.setBounds(322, 156, 149, 119);
		pa4.add(btd6);
		 

		panel = new JPanel(new GridLayout(0, 4, 10, 0));
		panel.setBounds(0, 15, 484, 50);
		getContentPane().add(panel);
		panel.setBackground(new Color(255, 0, 0, 0));
		bt1 = new JButton("쿠시");
		bt1.addActionListener(this);
		panel.add(bt1);

		bt2 = new JButton("카이센");
		bt2.addActionListener(this);
		panel.add(bt2);

		bt3 = new JButton("아게모노");
		bt3.addActionListener(this);
		panel.add(bt3);

		bt4 = new JButton("노미모노");
		bt4.addActionListener(this);
		panel.add(bt4);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(496, 318, 261, 232);
		getContentPane().add(scrollPane);

		listAll = new JList();
		/* listAll.setListData(salesList.toArray()); */
		scrollPane.setViewportView(listAll);

		lblNewLabel = new JLabel("[\uC8FC\uBB38\uB0B4\uC5ED]");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(12, 571, 472, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(this);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 472, 472, 101);
		getContentPane().add(scrollPane_1);

		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		textArea.setEditable(false);
		scrollPane_1.getVerticalScrollBar().setValue(scrollPane_1.getVerticalScrollBar().getMaximum());

		btnOrder = new JButton("\uC8FC\uBB38");
		btnOrder.addActionListener(this);
		btnOrder.setBounds(496, 273, 75, 35);
		getContentPane().add(btnOrder);

		btnCall = new JButton("\uD638\uCD9C");
		btnCall.setBounds(668, 273, 75, 35);
		getContentPane().add(btnCall);
		btnCall.addActionListener(this);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(499, 15, 258, 248);
		getContentPane().add(scrollPane_2);

		listBasket = new JList();
		scrollPane_2.setViewportView(listBasket);

		lblNewLabel_1 = new JLabel("[\uC7A5\uBC14\uAD6C\uB2C8]");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_2.setColumnHeaderView(lblNewLabel_1);

		btnacc = new JButton("\uACC4\uC0B0");
		btnacc.addActionListener(this);
		btnacc.setBounds(671, 560, 75, 35);
		getContentPane().add(btnacc);

		btncancel = new JButton("\uCDE8\uC18C");
		btncancel.setBounds(583, 273, 75, 35);
		getContentPane().add(btncancel);
		btncancel.addActionListener(this);

		/*
		 * if (sm.complete(((Sales) list.getSelectedValue()).getNum())) {
		 * newSales = sm.salesListAll(); list.setListData(newSales.toArray()); }
		 * else { JOptionPane.showConfirmDialog(null, "선택하세요");
		 */

		/*
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * for (int i = 0; i < blist.size(); i++) {
		 * if(selectedValue.getMenuName().equals(blist.get(i).getMenuName())){
		 * blist.remove(i); }else{ JOptionPane.showMessageDialog(null,
		 * "먼저 삭제할 메뉴를 선택하세요"); }
		 * 
		 * }
		 * 
		 * 
		 * for (int i = 0; i < blist.size(); i++) {
		 * if(blist.get(i).getMenuName().equals(listBasket.getSelectedValue())){
		 * blist.remove(i); }else{ JOptionPane.showMessageDialog(null,
		 * "먼저 삭제할 메뉴를 선택하세요"); } }
		 * 
		 * } });
		 */
		
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("src/img/mainbase.png"));
		label.setBounds(0, 0, 788, 616);
		getContentPane().add(label);
		
		label_pa3 = new JLabel("");
		label_pa3.setIcon(new ImageIcon("src/img/mainbase.png"));
		label_pa3.setBounds(0, 0, 788, 616);
		pa3.add(label_pa3);
		
		label_pa4 = new JLabel("");
		label_pa4.setIcon(new ImageIcon("src/img/mainbase.png"));
		label_pa4.setBounds(0, 0, 788, 616);
		pa4.add(label_pa4);
		
		label_pa1 = new JLabel("");
		label_pa1.setBounds(0, 0, 788, 616);
		pa1.add(label_pa1);
		label_pa1.setIcon(new ImageIcon("src/img/mainbase.png"));
		
		label_pa2 = new JLabel("");
		label_pa2.setBounds(0, 0, 788, 616);
		pa2.add(label_pa2);
		label_pa2.setIcon(new ImageIcon("src/img/mainbase.png"));
		
		

		getsalesList();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object select = e.getSource();

		if (select == bt1) {
			card.show(base, "pa1");
		} else if (select == bt2) {
			card.show(base, "pa2");
		} else if (select == bt3) {
			card.show(base, "pa3");
		} else if (select == btnCall) {
			cm.call(taNum);
			JOptionPane.showMessageDialog(null, "호출 되었습니다 잠시만 기다려 주세요");
		} else if (select == bt4) {
			card.show(base, "pa4");
		}
		if (select == btn1) { // 김치찌개
			btn(0);
		} else if (select == btn2) { // 부대찌개
			btn(1);
		} else if (select == btn3) { // 오뎅탕
			btn(2);
		} else if (select == btn4) { // 알탕
			btn(3);
		} else if (select == btn5) { // 홍합탕
			btn(4);
		} else if (select == btn6) { // 짬뽕탕
			btn(5);
		}
		if (select == btf1) { // 감자튀김
			btn(6);
		} else if (select == btf2) { // 오징어 튀김
			btn(7);
		} else if (select == btf3) { // 새우튀김
			btn(8);
		} else if (select == btf4) { // 모듬튀김
			btn(9);
		} else if (select == btf5) { // 후라이드 치킨
			btn(10);
		} else if (select == btf6) { // 양념치킨
			btn(11);
		}
		if (select == btb1) { // 닭똥집
			btn(12);
		} else if (select == btb2) { // 제육 볶음
			btn(13);
		} else if (select == btb3) {
			btn(14);
		} else if (select == btb4) {
			btn(15);
		} else if (select == btb5) {
			btn(16);
		} else if (select == btb6) {
			btn(17);
		}
		if (select == btd1) {
			btn(18);
		} else if (select == btd2) {
			btn(19);
		} else if (select == btd3) {
			btn(20);
		} else if (select == btd4) {
			btn(21);
		} else if (select == btd5) {
			btn(22);
		} else if (select == btd6) {
			btn(23);
		} else if (select == btnacc) {///////////////// 계산 버튼
			// new pay(taNum);
			cm.acc(taNum);
			getsalesList();
			if (salesList.size() == 0) {
				dispose();
				new join(taNum);
			}
		} else if (select == btncancel) {////////////// 주문 취소 버튼
			listIndex = listBasket.getSelectedIndex();
			blist.remove(listIndex);
			listBasket.setListData(blist.toArray());

		} else if (select == btnOrder) {/////////////////// 주문 버튼

			int check = 0;
			ArrayList<Sales> sendList = new ArrayList<>();

			for (int j = 0; j < blist.size(); j++) {
				for (int i = 0; i < salesList.size(); i++) {
					if (salesList.get(i).getMenuName().equals(blist.get(j).getMenuName())) {

						salesList.get(i).setAmount(salesList.get(i).getAmount() + blist.get(j).getAmount());
						check = 1;

					}

				}
				Sales send = new Sales(blist.get(j).getNum(), blist.get(j).getMenuName(), blist.get(j).getPrice(),
						taNum, id, blist.get(j).getAmount(), 0, 0);
				System.out.println(send.getMenuName() + send.getPrice() + send.getTableNum() + send.getUserID()
						+ send.getAmount());

				sendList.add(send);

				if (check == 0) {
					salesList.add(blist.get(j));
				}
			}
			if (salesList.size() == 0) {
				salesList.addAll(blist);

			}

			if (cm.newSales(sendList)) {
				if (cm.getSalesAll(taNum)) {
					getsalesList();
					// listAll.setListData(salesList.toArray());
					blist.clear();
					JOptionPane.showMessageDialog(null, "주문 완료");
					ArrayList<Sales> salesLista = new ArrayList();// Jlist 비우기
																	// 위한
																	// arraylist

					listBasket.setListData(salesLista.toArray());
				}
			}

		} else if (select == textField) {
			if (cm.sendMessage(taNum, textField.getText())) {
				JOptionPane.showMessageDialog(null, "요구사항 전송 완료");
				textArea.append(taNum + "번 테이블 : " + textField.getText() + "\n");
				textField.setText("");
			}
		}

	}

	public void btn(int tableNum) {
		for (int i = 0; i < blist.size(); i++) {
			if (Menulist.get(tableNum).getMenuName().equals(blist.get(i).getMenuName())) {
				flag = true;

			}
		}
		if (flag) {
			for (int i = 0; i < blist.size(); i++) {
				if (Menulist.get(tableNum).getMenuName().equals(blist.get(i).getMenuName())) {
					int amount = blist.get(i).getAmount();
					amount++;
					blist.get(i).setAmount(amount);
				}
			}
		} else {
			Sales menu = new Sales(-1, Menulist.get(tableNum).getMenuName(), Menulist.get(tableNum).getPrice(), taNum,
					id, 1, 0, 0);
			blist.add(menu);
		}

		listBasket.setListData(blist.toArray());

		flag = false;
	}

	public void accountSum(String taNum) {
		int sum = 0;
		int sum1 = 0;
		for (int i = 0; i < salesList.size(); i++) {
			if (taNum.equals(salesList.get(i).getTableNum())) {
				sum1 = salesList.get(i).getPrice() * salesList.get(i).getAmount();

				sum = sum + sum1;
				textSum.setText("합계 :" + sum);
			}
		}
	}

	public void getsalesList() {

		listObj = cm.salesList(taNum);
		salesList = (ArrayList<Sales>) listObj[1];
		if (salesList.size() != 0) {
			if (salesList.get(0).getUserID().equals("guest")) {
				textSum.setText("합계 :" + listObj[0]);
			} else {
				textSum.setText("합계 :" + listObj[0] + " (회원 할인 10%)");

			}
		}
		// getList.addAll(cm.salesList(taNum));
		listAll.setListData(salesList.toArray());
	}
}
