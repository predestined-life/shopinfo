package shopinfo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Zhuxiao")
public class Zhuxiao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Zhuxiao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String k=request.getParameter("k");
		if("zx".equals(k)) {
			request.getSession().invalidate();
			response.sendRedirect("Login");
			//request.getRequestDispatcher("WEB-INF/admin/salesCx.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
