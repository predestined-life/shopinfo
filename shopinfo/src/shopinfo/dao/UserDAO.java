package shopinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import shopinfo.db.DB;
import shopinfo.model.User;

public class UserDAO {
	private DB db=new DB();
	public User select(String On_name,String On_pass,String job) {
		User u=null;
			try {
				Connection con=db.getCon();
				String sql="select * from User where On_name=? and On_pass=? and On_job=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, On_name);
				ps.setString(2, On_pass);
				ps.setString(3, job);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					u=new User();
					u.setOn_name(rs.getString("On_name"));
					u.setOn_pass(rs.getString("On_pass"));
					u.setOn_job(rs.getString("job"));
				}
				db.close();
				ps.close();
				rs.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		return u;
	}
}
