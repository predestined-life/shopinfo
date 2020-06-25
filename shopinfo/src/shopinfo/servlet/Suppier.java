package shopinfo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopinfo.dao.GoodsDAO;
import shopinfo.dao.SuppierDAO;

@WebServlet("/Suppier")
public class Suppier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Suppier() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String k=request.getParameter("k");
		SuppierDAO dao=new SuppierDAO();
		if(k==null) {
			request.getRequestDispatcher("WEB-INF/admin/index.jsp").forward(request, response);
		}
		else if("supcx".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/admin/supcx.jsp").forward(request, response);
		}
		else if("cgsupcx".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/cgy/cgsupcx.jsp").forward(request, response);
		}
		else if("xgsup".equals(k)) {
			int sup_id=Integer.parseInt(request.getParameter("sup_id"));
			request.setAttribute("list1", dao.select1(sup_id));
			request.getRequestDispatcher("WEB-INF/admin/supxg.jsp").forward(request, response);
		}
		else if("cgxgsup".equals(k)) {
			int sup_id=Integer.parseInt(request.getParameter("sup_id"));
			request.setAttribute("list1", dao.select1(sup_id));
			request.getRequestDispatcher("WEB-INF/cgy/cgsupxg.jsp").forward(request, response);
		}
		else if("delsup".equals(k)) {
			int sup_id=Integer.parseInt(request.getParameter("sup_id"));
			if(dao.delete(sup_id)>0) {
				request.setAttribute("msg","删除成功");
			}else {
				request.setAttribute("msg", "删除失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		else if("cgdelsup".equals(k)) {
			int sup_id=Integer.parseInt(request.getParameter("sup_id"));
			if(dao.delete(sup_id)>0) {
				request.setAttribute("msg","删除成功");
			}else {
				request.setAttribute("msg", "删除失败");
			}
			request.getRequestDispatcher("WEB-INF/cgy/cgresult.jsp").forward(request, response);
		}
		else if("supkc".equals(k)) {
			request.getRequestDispatcher("WEB-INF/admin/supkc.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String k=request.getParameter("k");
		if ("supxgdo".equals(k)) {
			System.out.println(k);
			int Sup_id=Integer.parseInt(request.getParameter("sup_id"));
			String Sup_name=request.getParameter("sup_name");
			String Name=request.getParameter("name");
			String Tel=request.getParameter("tel");
			String Add=request.getParameter("add");
			System.out.println(Sup_id);
			System.out.println(Name);
			System.out.println(Tel);
			System.out.println(Add);
			SuppierDAO dao=new SuppierDAO();
			if(dao.update(Sup_id, Sup_name, Name, Tel, Add)>0) {
				request.setAttribute("msg", "修改成功");
			}else {
				request.setAttribute("msg", "修改失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		if ("cgsupxgdo".equals(k)) {
			System.out.println(k);
			int Sup_id=Integer.parseInt(request.getParameter("sup_id"));
			String Sup_name=request.getParameter("sup_name");
			String Name=request.getParameter("name");
			String Tel=request.getParameter("tel");
			String Add=request.getParameter("add");
			System.out.println(Sup_id);
			System.out.println(Name);
			System.out.println(Tel);
			System.out.println(Add);
			SuppierDAO dao=new SuppierDAO();
			if(dao.update(Sup_id, Sup_name, Name, Tel, Add)>0) {
				request.setAttribute("msg", "修改成功");
			}else {
				request.setAttribute("msg", "修改失败");
			}
			request.getRequestDispatcher("WEB-INF/cgy/cgresult.jsp").forward(request, response);
		}
	
	}

}
