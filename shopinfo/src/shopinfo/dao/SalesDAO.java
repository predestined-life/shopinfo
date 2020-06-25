package shopinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shopinfo.db.DB;
import shopinfo.model.Goods;
import shopinfo.model.Sales;

public class SalesDAO {
	private DB db=new DB();
	public int delete() {
		int res=0;
		try {
			Connection con=db.getCon();
			String sql="delete  from sale";
			PreparedStatement ps=con.prepareStatement(sql);
			res=ps.executeUpdate();
			ps.close();
			db.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
		
		
		
	
	public int delete(int Sale_id) {
		int res=0;
		try {
			Connection con=db.getCon();
			String sql="delete from sale where Sale_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Sale_id);
			res=ps.executeUpdate();
			ps.close();
			db.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	public int insert(int G_id,String G_name,int Sale_num,float G_price,float Sale_sum,String On_name) {
		int res=0;
		try {
				Connection con=db.getCon();
				String sql="insert into sale(G_id,G_name,Sale_num,G_price,Sale_sum,On_name)value(?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, G_id);
				ps.setString(2, G_name);
				ps.setInt(3, Sale_num);
				ps.setFloat(4, G_price);
				ps.setFloat(5, Sale_sum);
				ps.setString(6, On_name);;
				res=ps.executeUpdate();
				ps.close();
				db.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
		
		
	}
	public ArrayList<Sales>select(){
		ArrayList<Sales> list=new ArrayList<>();
		try {
			Connection con=db.getCon();
			String sql="select * from sale";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Sales s=new Sales();
				s.setSale_id(rs.getInt("Sale_id"));
				s.setG_id(rs.getInt("G_id"));
				s.setG_name(rs.getString("G_name"));
				s.setSale_num(rs.getInt("Sale_num"));
				s.setG_price(rs.getFloat("G_price"));
				s.setSale_sum(rs.getFloat("Sale_sum"));
				s.setOn_name(rs.getString("On_name"));
				list.add(s);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Goods>select1(){
		ArrayList<Goods> list1=new ArrayList<>();
		try {
			Connection con=db.getCon();
			String sql="select * from goods";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Goods g=new Goods();
				g.setG_id(rs.getInt("G_id"));
				g.setG_name(rs.getString("G_name"));
				g.setG_price(rs.getFloat("G_price"));
				g.setG_class(rs.getString("G_class"));
				g.setG_date(rs.getInt("G_date"));
				list1.add(g);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}
	public ArrayList<Goods>select2(int G_id){
		ArrayList<Goods> list2=new ArrayList<>();
		try {
			Connection con=db.getCon();
			String sql="select * from goods where G_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, G_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Goods g=new Goods();
				g.setG_id(rs.getInt("G_id"));
				g.setG_name(rs.getString("G_name"));
				g.setG_price(rs.getFloat("G_price"));
				g.setG_class(rs.getString("G_class"));
				list2.add(g);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}
	
}
