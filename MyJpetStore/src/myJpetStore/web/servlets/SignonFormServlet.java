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
 * Servlet implementation class SignonformServlet
 */
@WebServlet("/SignonformServlet")
public class SignonFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SIGNONFORM = "/WEB-INF/jsp/account/SignonForm.jsp";
	private String username;
	private String password;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignonFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.getRequestDispatcher(SIGNONFORM).forward(request,response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
