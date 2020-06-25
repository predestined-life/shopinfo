package shopinfo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopinfo.dao.PeopleDAO;
import shopinfo.dao.UserDAO;
import shopinfo.model.User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String On_name=request.getParameter("On_name");
		String On_pass=request.getParameter("On_pass");
		String job=request.getParameter("job");
       HttpSession session=request.getSession();
       session.setAttribute("On_name", On_name);
       HttpSession session1=request.getSession();
       session1.setAttribute("job", job);
       if("管理员".equals(job)) {	
    	   UserDAO dao=new UserDAO();
   		User w=dao.select(On_name, On_pass, job);
   		if(w==null){
   			request.setAttribute("msg", "登录失败");
   			request.getRequestDispatcher("login.jsp").forward(request, response);
   		}else {
   			request.getSession().setAttribute("w","w" );
   			request.getRequestDispatcher("WEB-INF/admin/index.jsp").forward(request,response);
   		}
   	}
           
   		if("销售员".equals(job)){
   			PeopleDAO dao=new PeopleDAO();
   			shopinfo.model.People x=dao.select2(On_name, On_pass, job);
   			if(x==null){
   				request.setAttribute("msg", "登录失败!");
   				request.getRequestDispatcher("login.jsp").forward(request, response);
   			}else{
   				request.getRequestDispatcher("WEB-INF/xsy/xsindex.jsp").forward(request, response);
   			}
   			
   	}
   		if("采购员".equals(job)) {
   			PeopleDAO dao=new PeopleDAO();
   			shopinfo.model.People c=dao.select2(On_name, On_pass, job);
   			
   			if(c==null){
   				request.setAttribute("msg", "登录失败!");
   				request.getRequestDispatcher("login.jsp").forward(request, response);
   			}else{
   				request.getRequestDispatcher("WEB-INF/cgy/cgindex.jsp").forward(request, response);
   			}
   	}
   		if("库管员".equals(job)) {
   			PeopleDAO dao=new PeopleDAO();
   			shopinfo.model.People c=dao.select2(On_name, On_pass, job);
   			
   			if(c==null){
   				request.setAttribute("msg", "登录失败!");
   				request.getRequestDispatcher("login.jsp").forward(request, response);
   			}else{
   				request.getRequestDispatcher("WEB-INF/kgy/kgindex.jsp").forward(request, response);
   			}
   	}
	}

}
