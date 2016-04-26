package myJpetStore.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myJpetStore.domain.Account;

/**
 * Servlet implementation class QuitLoginServlet
 */
@WebServlet("/QuitLoginServlet")
public class QuitLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuitLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = null;
	    session.setAttribute("account", account);
	    request.getRequestDispatcher(MAIN).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
