package shopinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shopinfo.db.DB;
import shopinfo.model.Goods;

public class GoodsDAO {
		private DB db=new DB();
		public int delete(int G_id) {
			int res=0;
			try {
				Connection con=db.getCon();
				String sql="delete from goods where G_id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, G_id);
				res=ps.executeUpdate();
				ps.close();
				db.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return res;
		}
		public int insert(String G_name,float G_price,String G_class,int G_date,int G_num,float G_sum,String Sup_name,int Sup_Date,String G_on_name) {
			int res=0;
			try {
					Connection con=db.getCon();
					String sql="insert into goods(G_name,G_price,G_class,G_date,G_num,G_sum,Sup_name,Sup_Date,G_on_name)value(?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, G_name);
					ps.setFloat(2, G_price);
					ps.setString(3, G_class);
					ps.setInt(4, G_date);
					ps.setInt(5, G_num);
					ps.setFloat(6, G_sum);
					ps.setString(7, Sup_name);
					ps.setInt(8, Sup_Date);
					ps.setString(9, G_on_name);
					res=ps.executeUpdate();
					ps.close();
					db.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return res;
			
			
		}
		public ArrayList<Goods>select(){
			ArrayList<Goods> list=new ArrayList<>();
			try {
				Connection con=db.getCon();
				String sql="select * from goods ";
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Goods g=new Goods();
					g.setG_id(rs.getInt("G_id"));
					g.setG_name(rs.getString("G_name"));
					g.setG_price(rs.getFloat("G_price"));
					g.setG_class(rs.getString("G_class"));
					g.setG_date(rs.getInt("G_date"));
					list.add(g);
				}
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		public ArrayList<Goods>select(int G_id){
			ArrayList<Goods> list1=new ArrayList<>();
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
					g.setG_date(rs.getInt("G_date"));
					list1.add(g);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return list1;
		}
		
		public int update(int G_id,String G_name,float G_price,String G_class,int G_date) {
			int up=0;
			try {
				Connection con=db.getCon();
				String sql="update goods set G_name=?,G_price=?,G_class=?,G_date=? where G_id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,G_name);
				ps.setFloat(2, G_price);
				ps.setString(3, G_class);
				ps.setInt(4, G_date);
				ps.setInt(5, G_id);
				up=ps.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
				}
			
			return up;
			
		}
}
