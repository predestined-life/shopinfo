package shopinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopinfo.dao.SalesDAO;

@WebServlet("/Sales")
public class Sales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Sales() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String k=request.getParameter("k");
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		System.out.println(k);
		SalesDAO dao=new SalesDAO();
		if(k==null){
			request.getRequestDispatcher("WEB-INF/admin/index.jsp").forward(request, response);
		}
		else if("xsSalesCX".equals(k)) {
			request.setAttribute("list1", dao.select1());
			request.getRequestDispatcher("WEB-INF/xsy/xssalesCx.jsp").forward(request, response);
		}
		else if("xsSalescar".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/xsy/xssalesCar.jsp").forward(request, response);
		}
		else if("SalesCX".equals(k)) {
			request.setAttribute("list1", dao.select1());
			request.getRequestDispatcher("WEB-INF/admin/salesCx.jsp").forward(request, response);
		}
		else if("Salescar".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/admin/salesCar.jsp").forward(request, response);
		}
		else if("delcargood".equals(k)) {
			int Sale_id=Integer.parseInt(request.getParameter("sale_id"));
			if(dao.delete(Sale_id)>0) {
				PrintWriter pw=response.getWriter();
				pw.write("<html><head><meta charset='UTF-8'></head><script language='javascript'>alert('移出成功');window.location.href='Sales?k=biaoqian'</script>");
			}else {
				PrintWriter pw=response.getWriter();
				pw.write("<html><head><meta charset='UTF-8'></head><script language='javascript'>alert('移出失败');window.location.href='Sales?k=biaoqian'</script>");
			}
			
		}
		else if("xsdelcargood".equals(k)) {
			int Sale_id=Integer.parseInt(request.getParameter("sale_id"));
			if(dao.delete(Sale_id)>0) {
				PrintWriter pw=response.getWriter();
				pw.write("<html><head><meta charset='UTF-8'></head><script language='javascript'>alert('移出成功');window.location.href='Sales?k=xsbiaoqian'</script>");
			}else {
				PrintWriter pw=response.getWriter();
				pw.write("<html><head><meta charset='UTF-8'></head><script language='javascript'>alert('移出失败');window.location.href='Sales?k=xsbiaoqian'</script>");
			}
			
		}
		else if("goodsxq".equals(k)){
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			request.setAttribute("list2", dao.select2(G_id));
			request.getRequestDispatcher("WEB-INF/admin/saleCx1.jsp").forward(request, response);
		}
		else if("xsgoodsxq".equals(k)){
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			request.setAttribute("list2", dao.select2(G_id));
			request.getRequestDispatcher("WEB-INF/xsy/xssaleCx1.jsp").forward(request, response);
		}
		else if("biaoqian".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/admin/salesCar.jsp").forward(request, response);
		}
		else if("xsbiaoqian".equals(k)) {
			request.setAttribute("list", dao.select());
			request.getRequestDispatcher("WEB-INF/xsy/xssalesCar.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
		
		
		
	

			
	
	
		String k=request.getParameter("k");
		request.setCharacterEncoding("UTF-8");
		if("addsalesdo".equals(k)) {
			try {
			request.setCharacterEncoding("utf-8");
			}catch (UnsupportedOperationException e) {
			e.printStackTrace();
			}
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			String G_name=request.getParameter("g_name");
			G_name = new String(G_name.getBytes("ISO-8859-1"),"utf-8");
			int Sale_num=Integer.parseInt(request.getParameter("Sale_num"));
			float G_price=Float.parseFloat(request.getParameter("g_price"));
			float Sale_sum=Float.parseFloat(request.getParameter("Sale_sum"));
			HttpSession session=request.getSession();
			String On_name=(String) session.getAttribute("On_name");
			SalesDAO dao=new SalesDAO();
			if(dao.insert(G_id, G_name, Sale_num, G_price, Sale_sum, On_name)>0) {
				request.setAttribute("msg", "加入成功");
			}else {
				request.setAttribute("msg", "加入失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
		}
		if("xsaddsalesdo".equals(k)) {
			try {
			request.setCharacterEncoding("utf-8");
			}catch (UnsupportedOperationException e) {
			e.printStackTrace();
			}
			int G_id=Integer.parseInt(request.getParameter("g_id"));
			String G_name=request.getParameter("g_name");
			G_name = new String(G_name.getBytes("ISO-8859-1"),"utf-8");
			int Sale_num=Integer.parseInt(request.getParameter("Sale_num"));
			float G_price=Float.parseFloat(request.getParameter("g_price"));
			float Sale_sum=Float.parseFloat(request.getParameter("Sale_sum"));
			HttpSession session=request.getSession();
			String On_name=(String) session.getAttribute("On_name");
			SalesDAO dao=new SalesDAO();
			if(dao.insert(G_id, G_name, Sale_num, G_price, Sale_sum, On_name)>0) {
				request.setAttribute("msg", "加入成功");
			}else {
				request.setAttribute("msg", "加入失败");
			}
			request.getRequestDispatcher("WEB-INF/xsy/xsresult.jsp").forward(request, response);
		}
		
		if("cleancar".equals(k)) {
			SalesDAO dao=new SalesDAO();
			if(dao.delete()>0) {
				request.setAttribute("msg", "清除成功");
			}else {
				request.setAttribute("msg", "清除失败");
			}
			request.getRequestDispatcher("WEB-INF/admin/result.jsp").forward(request, response);
			
		}
		if("xscleancar".equals(k)) {
			SalesDAO dao=new SalesDAO();
			if(dao.delete()>0) {
				request.setAttribute("msg", "清除成功");
			}else {
				request.setAttribute("msg", "清除失败");
			}
			request.getRequestDispatcher("WEB-INF/xsy/xsresult.jsp").forward(request, response);
			
		}
	}

}
