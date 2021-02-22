package vo;

import java.io.Serializable;

public class Menu implements Serializable{

	public String gubun;
	public String menuName;
	public int price;
	
	public static final String drink = "��";
	public static final String soup = "��";
	public static final String fry = "Ƣ��";
	public static final String bogg = "����";
	
	public Menu(String gubun, String menuName, int price) {
		this.gubun = gubun;
		this.menuName = menuName;
		this.price = price;
	}
	
	public Menu(String menuName, int price) {
		super();
		this.menuName = menuName;
		this.price = price;
	}

	public String getGubun() {
		return gubun;
	}



	public void setGubun(String gubun) {
		this.gubun = gubun;
	}



	public String getMenuName() {
		return menuName;
	}



	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "[�޴� : " + menuName + "] [���� :" + price + "]";
	}
	//[���� : " + gubun + "] 
	
}
