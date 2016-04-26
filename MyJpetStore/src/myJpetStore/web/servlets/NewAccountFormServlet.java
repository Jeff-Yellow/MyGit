package myJpetStore.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewAccountFormServlet
 */
@WebServlet("/NewAccountFormServlet")
public class NewAccountFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NEWACCOUNTFORM = "/WEB-INF/jsp/account/NewAccountForm.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccountFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(NEWACCOUNTFORM).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
