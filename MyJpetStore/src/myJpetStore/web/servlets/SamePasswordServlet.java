package myJpetStore.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SamePasswordServlet
 */
@WebServlet("/SamePasswordServlet")
public class SamePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SamePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(repeatedPassword.equals(password)){
			out.println("<msg>Yes</msg>");
		}else{
			out.println("<msg>No</msg>");
		}
		out.flush();
		out.close();
	}
	
	public void init() throws ServletException{
		
	}
	
	public void destroy(){
		super.destroy();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
