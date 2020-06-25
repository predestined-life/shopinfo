package shopinfo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopinfo.dao.GoodsDAO;
import shopinfo.dao.PeopleDAO;

@WebServlet("/People")
public class People extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public People() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String k=request.getParameter("k");
		PeopleDAO dao=new PeopleDAO();
		if(k==null) {
			request.getRequestDispatcher("WEB-INF/admin/index.jsp").forward(request, response);
		}
		else if("selpeople".equals(k)) {
			request.setAttribute("list",dao.select());
			request.getRequestDispatcher("WEB-INF/admin/peoplecx.jsp").forward(request, response);
			
		}
		else if("deletepeople".equals(k)){
			int People_id=Integer.parseInt(request.getParameter("id"));
			if(dao.delete(People_id)>0) {
				request.setAttribute("msg","删除成功");
			}else {
				request.setAttribute("msg", "删除失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		else if("updatepeople".equals(k)) {
			int People_id=Integer.parseInt(request.getParameter("id"));
			request.setAttribute("list1", dao.select1(People_id));
			request.getRequestDispatcher("WEB-INF/admin/peoplexg.jsp").forward(request, response);
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String k=request.getParameter("k");
		PeopleDAO dao=new PeopleDAO();
		if ("peoplexgdo".equals(k)) {
			
			int People_id=Integer.parseInt(request.getParameter("people_id"));
			String People_name=request.getParameter("people_name");
			People_name = new String(People_name.getBytes("ISO-8859-1"),"utf-8");
			String People_sex=request.getParameter("people_sex");
			People_sex = new String(People_sex.getBytes("ISO-8859-1"),"utf-8");
			int People_tel=Integer.parseInt(request.getParameter("people_tel"));
			String People_job=request.getParameter("people_tel");
			String Name=request.getParameter("name");
			String Pass=request.getParameter("pass");
			if(dao.update(People_id, People_name, People_sex, People_tel, People_job, Name, Pass)>0) {
				request.setAttribute("msg", "修改成功");
			}else {
				request.setAttribute("msg", "修改失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

}
