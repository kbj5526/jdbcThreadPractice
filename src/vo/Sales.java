package vo;

public class Sales extends Menu{

	private int num;
	private String tableNum;
	private String userID;
	private int amount;
	private int acc;
	private int com;
	
	
	public Sales(int num, String menuName, int price, String tableNum, String userID, int amount, int acc, int com) {
		super(menuName, price);
		this.num = num;
		this.tableNum = tableNum;
		this.userID = userID;
		this.amount = amount;
		this.acc = acc;
		this.com = com;
	}
//	public Sales(String menuName, int price, int amount) {
//		super(menuName, price);
//		this.amount = amount;
//	}
//    
//	public Sales(String menuName, int price, int amount, String tableNum) {
//		// TODO Auto-generated constructor stub
//		super(menuName, price);
//		this.amount = amount;		
//		this.tableNum = tableNum;
//	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTableNum() {
		return tableNum;
	}

	public void setTableNum(String tableNum) {
		this.tableNum = tableNum;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public String toString() {
		return super.toString()+" [수량 : " + amount + "] [테이블번호 : "+tableNum +"]";
	}
}
