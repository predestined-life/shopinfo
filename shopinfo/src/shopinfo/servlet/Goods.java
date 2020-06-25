package shopinfo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopinfo.dao.GoodsDAO;
@WebServlet("/Goods")
public class Goods extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Goods() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String k=request.getParameter("k");
		GoodsDAO dao=new GoodsDAO();
		if(k==null) {
			request.getRequestDispatcher("WEB-INF/admin/index.jsp").forward(request, response);
		}
		else if("kg".equals(k)) {
			request.getRequestDispatcher("WEB-INF/kgy/kgindex.jsp").forward(request, response);
		}
		else if("xs".equals(k)) {
			request.getRequestDispatcher("WEB-INF/xsy/xsindex.jsp").forward(request, response);
		}
		else if("cg".equals(k)) {
			request.getRequestDispatcher("WEB-INF/cgy/cgindex.jsp").forward(request, response);
		}
		
		else if("GoodsAdd".equals(k)) {
			request.getRequestDispatcher("WEB-INF/admin/goodsAdd.jsp").forward(request, response);
		}
		else if("cgGoodsAdd".equals(k)) {
			request.getRequestDispatcher("WEB-INF/cgy/cggoodsAdd.jsp").forward(request, response);
		}
		else if("GoodsGl".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/admin/goodsGl.jsp").forward(request, response);
		}
		else if("cgGoodsGl".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/cgy/cggoodsGl.jsp").forward(request, response);
		}
		else if("updategoods".equals(k)) {
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			request.setAttribute("list1", dao.select(G_id));
			request.getRequestDispatcher("WEB-INF/admin/goodsUpdate.jsp").forward(request, response);
		}
		else if("cgupdategoods".equals(k)) {
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			request.setAttribute("list1", dao.select(G_id));
			request.getRequestDispatcher("WEB-INF/cgy/cggoodsUpdate.jsp").forward(request, response);
		}
		else if("deletegoods".equals(k)) {
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			if(dao.delete(G_id)>0) {
				request.setAttribute("msg","删除成功");
			}else {
				request.setAttribute("msg", "删除失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		else if("cgdeletegoods".equals(k)) {
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			if(dao.delete(G_id)>0) {
				request.setAttribute("msg","删除成功");
			}else {
				request.setAttribute("msg", "删除失败");
			}
			request.getRequestDispatcher("WEB-INF/cgy/cgresult.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String k=request.getParameter("k");
		if("goodsAdddo".equals(k)) {
			try {
				request.setCharacterEncoding("utf-8");
			}catch (UnsupportedOperationException e) {
				e.printStackTrace();
			}
			String G_name=request.getParameter("G_name");
			float G_price=Float.parseFloat(request.getParameter("G_price"));
			String G_class=request.getParameter("G_class");
			int G_date=Integer.parseInt(request.getParameter("G_date"));
			int G_num=Integer.parseInt(request.getParameter("G_num"));
			float G_sum=Float.parseFloat(request.getParameter("G_sum"));
			String Sup_name=request.getParameter("Sup_name");
			int Sup_Date=Integer.parseInt(request.getParameter("Sup_date"));
			String G_on_name=request.getParameter("G_on_name");
			GoodsDAO dao=new GoodsDAO();
			if(dao.insert(G_name, G_price, G_class, G_date, G_num, G_sum, Sup_name, Sup_Date, G_on_name)>0) {
				request.setAttribute("msg", "上新成功");
			}else {
				request.setAttribute("msg", "上新失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		if("cggoodsAdddo".equals(k)) {
			try {
				request.setCharacterEncoding("utf-8");
			}catch (UnsupportedOperationException e) {
				e.printStackTrace();
			}
			String G_name=request.getParameter("G_name");
			float G_price=Float.parseFloat(request.getParameter("G_price"));
			String G_class=request.getParameter("G_class");
			int G_date=Integer.parseInt(request.getParameter("G_date"));
			int G_num=Integer.parseInt(request.getParameter("G_num"));
			float G_sum=Float.parseFloat(request.getParameter("G_sum"));
			String Sup_name=request.getParameter("Sup_name");
			int Sup_Date=Integer.parseInt(request.getParameter("Sup_date"));
			String G_on_name=request.getParameter("G_on_name");
			GoodsDAO dao=new GoodsDAO();
			if(dao.insert(G_name, G_price, G_class, G_date, G_num, G_sum, Sup_name, Sup_Date, G_on_name)>0) {
				request.setAttribute("msg", "上新成功");
			}else {
				request.setAttribute("msg", "上新失败");
			}
			request.getRequestDispatcher("WEB-INF/cgy/cgresult.jsp").forward(request, response);
		}
	if ("goodsUpdatedo".equals(k)) {
		int G_id=Integer.parseInt(request.getParameter("g_id"));
		String G_name=request.getParameter("g_name");
		float G_price=Float.parseFloat(request.getParameter("g_price"));
		String G_class=request.getParameter("g_class");
		int G_date=Integer.parseInt(request.getParameter("g_date"));
		GoodsDAO dao=new GoodsDAO();
		if(dao.update(G_id, G_name,  G_price, G_class, G_date)>0) {
			request.setAttribute("msg", "修改成功");
		}else {
			request.setAttribute("msg", "修改失败");
		}
		request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
	}
	if ("cggoodsUpdatedo".equals(k)) {
		int G_id=Integer.parseInt(request.getParameter("g_id"));
		String G_name=request.getParameter("g_name");
		float G_price=Float.parseFloat(request.getParameter("g_price"));
		String G_class=request.getParameter("g_class");
		int G_date=Integer.parseInt(request.getParameter("g_date"));
		GoodsDAO dao=new GoodsDAO();
		if(dao.update(G_id, G_name,  G_price, G_class, G_date)>0) {
			request.setAttribute("msg", "修改成功");
		}else {
			request.setAttribute("msg", "修改失败");
		}
		request.getRequestDispatcher("WEB-INF/cgy/cgresult.jsp").forward(request, response);
	}
	
	
	}

}
