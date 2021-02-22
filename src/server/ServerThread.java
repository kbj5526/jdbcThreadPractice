package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

import vo.Menu;
import vo.Sales;

public class ServerThread implements Runnable {

	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;
	private ServerSocket ss;
	static ArrayList<ObjectOutputStream> oosList = new ArrayList<>();
	private ServerManager sm = new ServerManager();
	private Server server;
	ArrayList<Sales> salesAll = new ArrayList<>();
	ArrayList<Sales> newSales = new ArrayList<>();
	static ArrayList<Sales> newSales2 = new ArrayList<>();
	ArrayList<Sales> newSales3 = new ArrayList<>();
	ArrayList<Sales> salesTable = new ArrayList<>();
	ArrayList<Sales> salesTable2 = new ArrayList<>();
	// boolean result2;
	int sum = 0;
	int sum1 = 0;

	public ServerThread(Server server, ObjectInputStream ois, ObjectOutputStream oos,
			ArrayList<ObjectOutputStream> oosList) {
		// TODO Auto-generated constructor stub
		this.server = server;
		this.ois = ois;
		this.oos = oos;
		this.oosList = oosList;
		// this.oosList = oosList;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		boolean exit = true;
		while (exit) {
			try {
				Object[] obj = (Object[]) ois.readObject();
				String protocol = (String) obj[0];
				switch (protocol) {
				case "login":
					// Object[] logObj = sm.loginuser(obj);
					// if(logObj[1]!=null){
					// oos.writeObject(logObj);
					if (sm.loginuser(obj)) {
						oos.writeObject(true);

					} else {
						oos.writeObject(false);
					}
					break;
				case "addUser":
					boolean result = (boolean) sm.addUser(obj);
					oos.writeObject(result);
					break;
				case "loadMenu":
					ArrayList<Menu> menuList = sm.loadMenu();
					oos.writeObject(menuList);
					break;
				case "newSales":
					newSales = (ArrayList<Sales>) obj[1];
					if (sm.newSales(newSales)) {
						newSales3 = sm.newSalesSelect();
					}
					newSales2.addAll(newSales3);
					// server.newSales.addAll(newSales2);
					if (newSales3.size() != 0) {
						oos.writeObject(true);
						// server.list.setListData(newSales2.toArray());
					} else {
						oos.writeObject(false);
					}
					break;
				case "salesListAll":
					String tableNo = (String) obj[1];
					salesAll = sm.salesListAll();

					if (salesAll != null) {
						server.list.setListData(salesAll.toArray());
						oos.writeObject(true);
					} else {
						oos.writeObject(false);
					}
					break;
				case "salesList":
					String tNum = (String) obj[1];
					btnSetText(tNum);
					Object[] listObj = { sum1, salesTable };
					oos.writeObject(listObj);

					break;
				case "acc":
					tNum = (String) obj[1];
					int num = Integer.parseInt(tNum);
					server.btnList.get(num - 1).doClick();
					// oos.writeObject(result2);
					oos.writeObject(null);
					break;
				case "sendMessage":
					server.textArea.append((String) obj[1] + "번 테이블 : " + (String) obj[2] + "\n");
					server.scrollPane.getVerticalScrollBar().setValue(server.scrollPane.getVerticalScrollBar().getMaximum());
					oos.writeObject(true);
					break;
				case "call":
					server.textArea.append((String) obj[1] + "번 테이블 에서 호출 되었습니다\n");
					server.scrollPane.getVerticalScrollBar().setValue(server.scrollPane.getVerticalScrollBar().getMaximum());
					oos.writeObject(true);
					break;

				// case "salesListAll":
				// case "accSalesList":
				// tNum = (String) obj[1];
				// salesTable2 = sm.accSalesList(tNum);
				// int sum2 = btnSetText2(tNum);
				// if (salesTable2.size()==0) {
				// oos.writeObject(null);
				// } else {
				// Object[] listObj = { sum1, salesTable2 };
				// oos.writeObject(listObj);
				// }
				// break;
				//
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				exit = false;
			} catch (IOException e) {
				e.printStackTrace();
				exit = false;
			}
		}

	}

	public void btnSetText(String tableNum) {
		sum = 0;
		sum1 = 0;
		salesTable = sm.salesList(tableNum);
		if (salesTable.size() != 0) {
			for (int i = 0; i < salesTable.size(); i++) {
				if (salesTable.get(i).getTableNum().equals(tableNum)) {
					if (salesTable.get(i).getUserID().equals("guest")) {
						sum = salesTable.get(i).getPrice() * salesTable.get(i).getAmount();
						sum1 = sum1 + sum;
					} else {
						sum = salesTable.get(i).getPrice() * salesTable.get(i).getAmount();
						sum1 = sum1 + (int) (sum * 0.9);
					}

				}

			}
			server.btnList.get(Integer.parseInt(tableNum) - 1).setText(String.valueOf(sum1));
		}
	}

	public int btnSetText2(String tableNum) {
		sum = 0;
		sum1 = 0;
		salesTable2 = sm.accSalesList(tableNum);
		if (salesTable2.size() != 0) {
			for (int i = 0; i < salesTable2.size(); i++) {
				if (salesTable2.get(i).getTableNum().equals(tableNum)) {
					if (salesTable2.get(i).getUserID().equals("guest")) {
						sum = salesTable2.get(i).getPrice() * salesTable2.get(i).getAmount();
						sum1 = sum1 + sum;
					} else {
						sum = salesTable2.get(i).getPrice() * salesTable2.get(i).getAmount();
						sum1 = sum1 + (int) (sum * 0.9);
					}

				}

			}
		}
		return sum1;
	}

	// public void btn(boolean b) {
	// result2 = b;
	// }

}