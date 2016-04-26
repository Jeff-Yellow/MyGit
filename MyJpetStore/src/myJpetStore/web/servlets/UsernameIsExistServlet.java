package myJpetStore.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myJpetStore.domain.Account;
import myJpetStore.service.AccountService;

/**
 * Servlet implementation class UsernameIsExistServlet
 */
@WebServlet("/UsernameIsExistServlet")
public class UsernameIsExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsernameIsExistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		//System.out.println("ok");
		AccountService service = new AccountService();
		Account account = service.getAccount(username);
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(account != null){
			
			out.println("<info>Exist</info>");
		}else{
			
			out.println("<info>NotExist</info>");
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
