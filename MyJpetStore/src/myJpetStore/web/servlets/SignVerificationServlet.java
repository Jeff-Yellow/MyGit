package myJpetStore.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myJpetStore.domain.Account;
import myJpetStore.service.AccountService;

/**
 * Servlet implementation class SignVerificationServlet
 */
@WebServlet("/SignVerificationServlet")
public class SignVerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
	private static final String SIGNONFORM = "/WEB-INF/jsp/account/SignonForm.jsp";
	
	private String password; 
	private String username;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignVerificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		username = request.getParameter("username");
		password = request.getParameter("password");
		AccountService accountService = new AccountService();
		Account account = null;
		account = accountService.getAccount(username, password);
		HttpSession session = request.getSession();
	    session.setAttribute("account",account);
		if(account == null){
			session.setAttribute("errorlogin", "Invalid username or password");
			request.getRequestDispatcher(SIGNONFORM).forward(request,response);
			session.removeAttribute("errorlogin");
			
		}else {
			request.getRequestDispatcher(MAIN).forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
