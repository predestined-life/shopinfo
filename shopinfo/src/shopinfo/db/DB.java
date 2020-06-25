package shopinfo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/c229?useUnicode=true&characterEncoding=UTF-8";
	private String u = "root";
	private String p = "123456";
	private Connection con = null;

	public DB() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		try {
			this.con = DriverManager.getConnection(url, u, p);
		} catch (Exception e) {
		}
		return this.con;
	}

	public void close() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (this.con != null) {
				this.con = null;
			}
		}
	}
}