package shopinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shopinfo.db.DB;
import shopinfo.model.Suppier;

public class SuppierDAO {
	private DB db=new DB();
	public ArrayList<Suppier>select(){
		ArrayList<Suppier> list=new ArrayList<>();
		try {
			Connection con=db.getCon();
			String sql="select * from Suppier";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Suppier s=new Suppier();
				s.setSup_id(rs.getInt("Sup_id"));
				s.setName(rs.getString("Name"));
				s.setSup_name(rs.getString("Sup_name"));
				s.setTel(rs.getString("Tel"));
				s.setAddress(rs.getString("Address"));
				list.add(s);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<Suppier>select1(int Sup_id){
		ArrayList<Suppier> list1=new ArrayList<>();
		try {
			Connection con=db.getCon();
			String sql="select * from Suppier where Sup_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Sup_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Suppier s=new Suppier();
				s.setSup_id(rs.getInt("Sup_id"));
				s.setName(rs.getString("Name"));
				s.setSup_name(rs.getString("Sup_name"));
				s.setTel(rs.getString("Tel"));
				s.setAddress(rs.getString("Address"));
				list1.add(s);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}
	
	public int delete(int Sup_id) {
		int res=0;
		try {
			Connection con=db.getCon();
			String sql="delete from Suppier where Sup_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Sup_id);
			res=ps.executeUpdate();
			ps.close();
			db.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int update(int Sup_id,String Sup_name,String Name,String Tel,String Address) {
		int up=0;
		try {
			Connection con=db.getCon();
			String sql="update suppier set Sup_name=?,Name=?,Tel=?,Address=? where Sup_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,Sup_name);
			ps.setString(2, Name);
			ps.setString(3, Tel);
			ps.setString(4, Address);
			ps.setInt(5, Sup_id);
			up=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			}
		
		return up;
		
	}
}
