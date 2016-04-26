package myJpetStore.web.servlets;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myJpetStore.domain.Account;

/**
 * Servlet implementation class EditAccountFormServlet
 */
@WebServlet("/EditAccountFormServlet")
public class EditAccountFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EDITACCOUNTFORM = "/WEB-INF/jsp/account/EditAccountForm.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccountFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher(EDITACCOUNTFORM).forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
