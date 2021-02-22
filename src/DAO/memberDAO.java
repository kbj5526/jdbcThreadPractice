package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.ConnectionManager;
import vo.Member;

public class memberDAO {
	Connection conn=null;
	PreparedStatement pst=null;
	String sql=null;
	int result=0;
	ArrayList<Member> list=new ArrayList<>();
	ResultSet rs;
	Member mb=null;
	public int insert(Member mb) throws SQLException{
		
			conn=ConnectionManager.getConnection();
			sql="insert into UserInfo values (?,?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, mb.getUserID());
			pst.setString(2, mb.getPW());
			pst.setString(3, mb.getUserName());
			pst.setString(4, mb.getPhonenumber());
			result=pst.executeUpdate();
			ConnectionManager.close(conn);
			if(pst!=null) pst.close();
	
		return result;
	}
	
	public ArrayList<Member> select(){
		try {
			conn=ConnectionManager.getConnection();
			sql="select * from Member order by no";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				String ID=rs.getString(1);
				String Psw=rs.getString(2);
				String Name=rs.getString(3);
				String pNum=rs.getString(4);
				Member bv=new Member(ID,Psw,Name,pNum);
				list.add(bv);		
			}
			ConnectionManager.close(conn);
			if(pst!=null) pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;	
	}
	

	
}
