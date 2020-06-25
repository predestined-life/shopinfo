package shopinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shopinfo.db.DB;
import shopinfo.model.Stock;

public class StockDAO {
	private DB db=new DB();
	
	public ArrayList<Stock>select(){
		ArrayList<Stock> list=new ArrayList<>();
		try {
			Connection con=db.getCon();
			String sql="select * from stock ";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Stock s=new Stock();
				s.setStock_id(rs.getInt("Stock_id"));
				s.setStore_id(rs.getInt("Store_id"));
				s.setG_id(rs.getInt("G_id"));
				s.setStock_num(rs.getInt("Stock_num"));
				list.add(s);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Stock>select1(int Stock_id){
		ArrayList<Stock> list1=new ArrayList<>();
		try {
			Connection con=db.getCon();
			String sql="select * from stock where Stock_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Stock_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Stock s=new Stock();
				s.setStock_id(rs.getInt("Stock_id"));
				s.setStore_id(rs.getInt("Store_id"));
				s.setG_id(rs.getInt("G_id"));
				s.setStock_num(rs.getInt("Stock_num"));
				list1.add(s);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}
	public int insert(int Store_id,int G_id,int Stock_num) {
		int res=0;
		try {
				Connection con=db.getCon();
				String sql="insert into stock(Store_id,G_id,Stock_num)value(?,?,?)";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, Store_id);
				ps.setInt(2, G_id);
				ps.setInt(3, Stock_num);
				res=ps.executeUpdate();
				ps.close();
				db.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public int delete(int Stock_id) {
		int res=0;
		try {
			Connection con=db.getCon();
			String sql="delete from stock where Stock_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Stock_id);
			res=ps.executeUpdate();
			ps.close();
			db.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int update(int Stock_id,int Store_id,int G_id,int Stock_num) {
		int up=0;
		try {
			Connection con=db.getCon();
			String sql="update stock set Store_id=?,G_id=?,Stock_num=? where Stock_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Store_id);
			ps.setInt(2, G_id);
			ps.setInt(3, Stock_num);
			ps.setInt(4, Stock_id);
			up=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			}
		
		return up;
		
	}
}
