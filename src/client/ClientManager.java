package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


import vo.Member;
import vo.Menu;
import vo.Sales;



public class ClientManager  {
	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ObjectOutputStream oos2;
	public ClientManager(MenuUI mainmenu){
		try{
			socket = new Socket("localhost", 8900);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean sendMessage(String tableNum, String message){
		Object[] obj={"sendMessage", tableNum,message}; 
		return (boolean)sendRequest(obj);
		
	}
	
	public boolean adduser(Member member) {
		// TODO Auto-generated method stub
		boolean result = false;
		Object [] obj = {"addUser",member};
		result = (boolean) sendRequest(obj);
		return result;
	}

	public boolean loginuser(Member member) {
		// TODO Auto-generated method stub
		
		Object [] obj = {"login",member};
		return  (boolean)sendRequest(obj);
		
	}
	public boolean getSalesAll(String tableNum) {
		// TODO Auto-generated method stub
		Object[] obj = {"salesListAll",tableNum};
		return (boolean)sendRequest(obj);
		
	}
	public ArrayList<Menu> getMenulist(){
		Object[]obj={"loadMenu"};
		return (ArrayList<Menu>) sendRequest(obj);
	}
	public boolean newSales(ArrayList<Sales> sendList) {
		Object[]obj2={"newSales",sendList};
		System.out.println(sendList.get(0).toString());
		return (boolean) sendRequest(obj2);
	}
	
	public Object[] salesList(String tableNum) {
		Object[] obj ={"salesList",tableNum};
		return (Object[]) sendRequest(obj);
		
	}
	
	public Object sendRequest(Object[] obj){
		Object result = null;
		try{
			oos.writeObject(obj);
			result = ois.readObject();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public void acc(String tableNum){
		Object[] obj = {"acc",tableNum};
		sendRequest(obj);
	}
	public boolean call(String tableNum){
		Object[] obj={"call",tableNum};
		return (boolean)sendRequest(obj);
	}


}
	

