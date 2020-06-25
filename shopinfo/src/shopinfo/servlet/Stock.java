package shopinfo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopinfo.dao.GoodsDAO;
import shopinfo.dao.StockDAO;

@WebServlet("/Stock")
public class Stock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Stock() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String k=request.getParameter("k");
		StockDAO dao=new StockDAO();
		if(k==null) {
			request.getRequestDispatcher("WEB-INF/admin/index.jsp").forward(request, response);
		}
		else if("stockkc".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/admin/stockcx.jsp").forward(request, response);
		}
		else if("kgstockkc".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/kgy/kgstockcx.jsp").forward(request, response);
		}
		else if("stockadd".equals(k)) {
			request.getRequestDispatcher("WEB-INF/admin/stockadd.jsp").forward(request, response);
		}
		else if("kgstockadd".equals(k)) {
			request.getRequestDispatcher("WEB-INF/kgy/kgstockadd.jsp").forward(request, response);
		}
		else if("deletestock".equals(k)) {
			int stock_id=Integer.parseInt(request.getParameter("stock_id"));
			if(dao.delete(stock_id)>0) {
				request.setAttribute("msg","删除成功");
			}else {
				request.setAttribute("msg", "删除失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		else if("kgdeletestock".equals(k)) {
			int stock_id=Integer.parseInt(request.getParameter("stock_id"));
			if(dao.delete(stock_id)>0) {
				request.setAttribute("msg","删除成功");
			}else {
				request.setAttribute("msg", "删除失败");
			}
			request.getRequestDispatcher("WEB-INF/kgy/kgresult.jsp").forward(request, response);
		}
		else if("updatestock".equals(k)) {
			int stock_id=Integer.parseInt(request.getParameter("stock_id"));
			request.setAttribute("list1",dao.select1(stock_id));
			request.getRequestDispatcher("WEB-INF/admin/stockupdate.jsp").forward(request, response);
		}
		else if("kgupdatestock".equals(k)) {
			int stock_id=Integer.parseInt(request.getParameter("stock_id"));
			request.setAttribute("list1",dao.select1(stock_id));
			request.getRequestDispatcher("WEB-INF/kgy/kgstockupdate.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String k=request.getParameter("k");
		if("stockAdddo".equals(k)) {
			int Store_id=Integer.parseInt(request.getParameter("Store_id"));
			int G_id=Integer.parseInt(request.getParameter("G_id"));
			int Stock_num=Integer.parseInt(request.getParameter("Stock_num"));
			StockDAO dao=new StockDAO();
			if(dao.insert(Store_id, G_id, Stock_num)>0) {
				request.setAttribute("msg", "插入成功");
			}else {
				request.setAttribute("msg", "插入失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		if("kgstockAdddo".equals(k)) {
			int Store_id=Integer.parseInt(request.getParameter("Store_id"));
			int G_id=Integer.parseInt(request.getParameter("G_id"));
			int Stock_num=Integer.parseInt(request.getParameter("Stock_num"));
			StockDAO dao=new StockDAO();
			if(dao.insert(Store_id, G_id, Stock_num)>0) {
				request.setAttribute("msg", "插入成功");
			}else {
				request.setAttribute("msg", "插入失败");
			}
			request.getRequestDispatcher("WEB-INF/kgy/kgresult.jsp").forward(request, response);
		}
		if ("stockUpdatedo".equals(k)) {
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			int Stock_id=Integer.parseInt(request.getParameter("stock_id"));
			int Store_id=Integer.parseInt(request.getParameter("store_id"));
			int Stock_num=Integer.parseInt(request.getParameter("stock_num"));
			StockDAO dao=new StockDAO();
			if(dao.update(Stock_id, Store_id, G_id, Stock_num)>0) {
				request.setAttribute("msg", "修改成功");
			}else {
				request.setAttribute("msg", "修改失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		if ("kgstockUpdatedo".equals(k)) {
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			int Stock_id=Integer.parseInt(request.getParameter("stock_id"));
			int Store_id=Integer.parseInt(request.getParameter("store_id"));
			int Stock_num=Integer.parseInt(request.getParameter("stock_num"));
			StockDAO dao=new StockDAO();
			if(dao.update(Stock_id, Store_id, G_id, Stock_num)>0) {
				request.setAttribute("msg", "修改成功");
			}else {
				request.setAttribute("msg", "修改失败");
			}
			request.getRequestDispatcher("WEB-INF/kgy/kgresult.jsp").forward(request, response);
		}
		
		
	}

}
