package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAO.ConnectionManager;
import vo.Menu;
import vo.Sales;
import vo.Member;

public class ServerManager {

	private ArrayList<Menu> menuList = new ArrayList<>();
	private ArrayList<Sales> salesList;
	private ArrayList<Sales> salesListAll;
	// private ArrayList<Sales> newSales;

	public boolean addUser(Object[] obj) {
		Member user = (Member) obj[1];

		Connection con = ConnectionManager.getConnection();
		String sql = "insert into UserInfo values(?,?,?,?)";
		try {
			/* con.setAutoCommit(false); */
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getPW());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPhonenumber());
			pstmt.executeQuery();

			/*
			 * con.commit(); con.setAutoCommit(true);
			 */
			con.commit();
			ConnectionManager.close(con);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ConnectionManager.close(con);
			return false;
		}
	}

	public boolean newSales(ArrayList<Sales> newsales) {
		// TODO Auto-generated method stub
		// newSales = new ArrayList<>();
		ArrayList<Sales> newSales2 = new ArrayList<>();
		// String menuName = null;
		// int price = 0;
		// String tableNum = null;
		// String userID = null;
		// int amount = 0;
		// int acc = 0;
		// Sales sales = new Sales(menuName, price, tableNum, userID, amount,
		// acc);
		// newSales = (ArrayList<Sales>) obj[1];
		Connection con = ConnectionManager.getConnection();
		String sql = "insert into sales values(SalesNumber_SEQ.NEXTVAL,?,?,?,?,?,0)";
		//
		// System.out.println(newsales.get(0).getAcc());
		// System.out.println(newsales.get(0).getAmount());
		// System.out.println(newsales.get(0).getMenuName());
		// System.out.println(newsales.get(0).getPrice());
		// System.out.println(newsales.get(0).getTableNum());
		// System.out.println(newsales.get(0).getUserID());
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			for (int i = 0; i < newsales.size(); i++) {
				pstmt.setString(1, newsales.get(i).getTableNum());
				pstmt.setString(2, newsales.get(i).getMenuName());
				pstmt.setString(3, newsales.get(i).getUserID());
				pstmt.setInt(4, newsales.get(i).getAcc());
				pstmt.setInt(5, newsales.get(i).getAmount());
				pstmt.executeQuery();
				// System.out.println(newsales.get(i).getAmount());

			}

			// Object[] obj2 = { "newSales", newSales };
			con.commit();
			ConnectionManager.close(con);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ConnectionManager.close(con);
		}
		return false;
	}

	public ArrayList<Sales> newSalesSelect() {
		ArrayList<Sales> newSalesSelect = new ArrayList<>();
		Connection con = ConnectionManager.getConnection();
		String sql1 = "select m.menuName, m.price, s.tablenumber, s.userid, s.amount, s.complete, s.salesnumber from menu m, sales s where m.menuName = s.menuName and AccountNum=0 order by salesnumber";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String menuName = rs.getString(1);
				int price = rs.getInt(2);
				String tableNum = rs.getString(3);
				String userID = rs.getString(4);
				int amount = rs.getInt(5);
				int com = rs.getInt(6);
				int num = rs.getInt(7);
				Sales sales2 = new Sales(num, menuName, price, tableNum, userID, amount, 0, com);
				newSalesSelect.add(sales2);
			}
			return newSalesSelect;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionManager.close(con);
		return null;

	}

	public ArrayList<Sales> salesList(String tableNum) {
		// TODO Auto-generated method stub
		salesList = new ArrayList<>();
		Connection con = ConnectionManager.getConnection();
		String sql1 = "select m.menuName, m.price, s.userid, s.accountNum, s.tablenumber, a.total from menu m,"
				+ " (select MENUNAME, tablenumber, sum(AMOUNT) total from sales"
				+ " group by MENUNAME, tablenumber, accountNum having TABLENUMBER=? and accountNum=0) a,"
				+ " (select menuname, userid, accountnum,tablenumber from sales group by userid, accountnum, menuname,tablenumber) s"
				+ " where m.menuname = a.menuname and s.menuname = a.menuname and s.accountNum=0 and s.tablenumber=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, tableNum);
			pstmt.setString(2, tableNum);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String menuName = rs.getString(1);
				int price = rs.getInt(2);
				// tableNum = rs.getString(3);
				String userID = rs.getString(3);
				int acc = rs.getInt(4);
				String tNum = rs.getString(5);
				int amount = rs.getInt(6);
				// int num = rs.getInt(6);
				if (tNum.equals(tableNum)) {
					Sales sales2 = new Sales(0, menuName, price, tableNum, userID, amount, acc, 0);
					salesList.add(sales2);
				}
				// Object[] salesListObj = {"salesList",salesList};
				// return salesListObj;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionManager.close(con);

		return salesList;
	}
	
	public ArrayList<Sales> accSalesList(String tableNum) {
		// TODO Auto-generated method stub
		salesList = new ArrayList<>();
		Connection con = ConnectionManager.getConnection();
		String sql1 = "select m.menuName, m.price, s.userid, s.accountNum, s.tablenumber, a.total,s.complete from menu m,"
				+ " (select MENUNAME, tablenumber, sum(AMOUNT) total from sales"
				+ " group by MENUNAME, tablenumber, accountNum, complete having TABLENUMBER=? and accountNum=0 and complete=1) a,"
				+ " (select menuname, userid, accountnum,tablenumber,complete from sales group by userid, accountnum, menuname,tablenumber,complete) s"
				+ " where m.menuname = a.menuname and s.menuname = a.menuname and s.accountNum=0 and s.tablenumber=? and complete=1";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, tableNum);
			pstmt.setString(2, tableNum);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String menuName = rs.getString(1);
				int price = rs.getInt(2);
				// tableNum = rs.getString(3);
				String userID = rs.getString(3);
				int acc = rs.getInt(4);
				String tNum = rs.getString(5);
				int amount = rs.getInt(6);
				int com = rs.getInt(7);
				// int num = rs.getInt(6);
				if (tNum.equals(tableNum)) {
					Sales sales2 = new Sales(0, menuName, price, tableNum, userID, amount, acc, com);
					salesList.add(sales2);
				}
				// Object[] salesListObj = {"salesList",salesList};
				// return salesListObj;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionManager.close(con);

		return salesList;
	}

	public boolean pay(String tableNum) {
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getConnection();
		try {
			String sql2 = "update sales set AccountNum=1 where tableNumber=? and complete=1";

			PreparedStatement pstmt = con.prepareStatement(sql2);

			// pstmt.setInt(1, a);
			// System.out.println(a + "====a");
			pstmt.setString(1, tableNum);
			// System.out.println(tableNum + "====tableNum");

			int result = pstmt.executeUpdate();
			// System.out.println("result" + result);
			// System.out.println("-----");
			con.commit();
			ConnectionManager.close(con);
			System.out.println("계산완료");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
			return false;
		}

	}

	public ArrayList<Menu> loadMenu() {
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getConnection();
		String sql1 = "select gubun, menuName, price from menu";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String gubun = rs.getString(1);
				String menuName = rs.getString(2);
				int price = rs.getInt(3);
				Menu menu = new Menu(gubun, menuName, price);
				
				menuList.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionManager.close(con);
		
		return menuList;
	}

	public ArrayList<Sales> salesListAll() {
		// TODO Auto-generated method stub
		salesListAll = new ArrayList<>();
		Connection con = ConnectionManager.getConnection();
		String sql1 = "select m.menuName, m.price, s.tableNumber, s.amount, s.userID, s.complete, s.salesnumber from menu m, sales s where m.menuName = s.menuName and accountnum=0 and complete=0 order by salesnumber";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String menuName = rs.getString(1);
				int price = rs.getInt(2);
				String tableNum = rs.getString(3);
				int amount = rs.getInt(4);
				String userid = rs.getString(5);
				int com = rs.getInt(6);
				int num = rs.getInt(7);
				Sales sales2 = new Sales(num, menuName, price, tableNum, userid, amount, 0, com);
				salesListAll.add(sales2);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnectionManager.close(con);
		return salesListAll;
	}

	public boolean loginuser(Object[] obj) {
		Member mb1 = (Member) obj[1];
		Connection con = ConnectionManager.getConnection();
		String sql1 = "select userid, password from userinfo where userid=? and password=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, mb1.getUserID());
			pstmt.setString(2, mb1.getPW());
			int rs = pstmt.executeUpdate();
			if (rs == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectionManager.close(con);

		return false;
	}

	public boolean complete(int salesnumber) {
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getConnection();
		try {
			String sql2 = "update sales set complete=1 where salesNumber=?";
			PreparedStatement pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, salesnumber);
			pstmt.executeUpdate();
			con.commit();
			ConnectionManager.close(con);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
			return false;
		}

	}

	public boolean delete(int salesnumber) {
		// TODO Auto-generated method stub
		Connection con = ConnectionManager.getConnection();
		try {
			String sql2 = "delete sales where salesNumber=?";
			PreparedStatement pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, salesnumber);
			pstmt.executeUpdate();
			con.commit();
			ConnectionManager.close(con);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
			return false;
		}

	}

}
