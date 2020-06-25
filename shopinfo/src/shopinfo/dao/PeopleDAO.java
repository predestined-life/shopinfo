package shopinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shopinfo.db.DB;
import shopinfo.model.People;

public class PeopleDAO {
	private DB db=new DB();
	public int delete(int People_id) {
		int res=0;
		try {
			Connection con=db.getCon();
			String sql="delete from people where People_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, People_id);
			res=ps.executeUpdate();
			ps.close();
			db.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public ArrayList<People>select(){
		ArrayList<People> list=new ArrayList<>();
		try {
			Connection con=db.getCon();
			String sql="select * from people ";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				People p=new People();
				p.setName(rs.getString("Name"));
				p.setPass(rs.getString("Pass"));
				p.setPeople_id(rs.getInt("People_id"));
				p.setPeople_job(rs.getString("People_job"));
				p.setPeople_name(rs.getString("People_name"));
				p.setPeople_sex(rs.getString("People_sex"));
				p.setPeople_tel(rs.getInt("People_tel"));
				list.add(p);
			}
			}catch (Exception e) {
				e.printStackTrace();
	}
		return list;
	
	
	
	
	
	
	}
	public ArrayList<People>select1(int People_id){
		ArrayList<People> list1=new ArrayList<>();
		try {
			Connection con=db.getCon();
			String sql="select * from people where People_id=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, People_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				People p=new People();
				p.setPeople_id(rs.getInt("People_id"));
				p.setPeople_name(rs.getString("People_name"));
				p.setPeople_sex(rs.getString("People_sex"));
				p.setPeople_tel(rs.getInt("People_tel"));
				p.setPeople_job(rs.getString("People_job"));
				p.setName(rs.getString("Name"));
				p.setPass(rs.getString("Pass"));
				list1.add(p);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}
	public int update(int People_id,String People_name,String People_sex,int People_tel,String People_job,String Name, String Pass) {
		int up=0;
		try {
			Connection con=db.getCon();
			String sql="update people set People_name=?,People_sex=?,People_tel=?,People_job=?,Name=?,Pass=? where People_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,People_name);
			ps.setString(2, People_sex);
			ps.setInt(3, People_tel);
			ps.setString(4, People_job);
			ps.setString(5, Name);
			ps.setString(6, Pass);
			ps.setInt(7, People_id);
			up=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			}
		
		return up;
		
	}
	public int insert(String People_name,String People_sex,int People_tel,String People_job,String Name, String Pass) {
		int res=0;
		try {
				Connection con=db.getCon();
				String sql="insert into goods(People_name,People_sex,People_tel,People_job,Name,Pass)value(?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,People_name);
				ps.setString(2, People_sex);
				ps.setInt(3, People_tel);
				ps.setString(4, People_job);
				ps.setString(5, Name);
				ps.setString(6, Pass);
				res=ps.executeUpdate();
				ps.close();
				db.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	public People select2(String On_name,String On_pass,String job) {
		ArrayList<People> list1=new ArrayList<>();
		People p=null;
		try {
			Connection con=db.getCon();
			String sql="select * from people where Name=? and Pass=? and People_job=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, On_name);
			ps.setString(2, On_pass);
			ps.setString(3, job);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				 p=new People();
				p.setName(rs.getString("On_name"));
				p.setPass(rs.getString("On_pass"));
				p.setPeople_job(rs.getString("job"));
			}
			db.close();
			ps.close();
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return p;
		
		
	}
}
