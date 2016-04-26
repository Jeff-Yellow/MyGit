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
 * Servlet implementation class ProceedToCheckout
 */
@WebServlet("/ProceedToCheckout")
public class ProceedToCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SIGNONFORM = "/WEB-INF/jsp/account/SignonForm.jsp";
	private static final String NEWORDERFORM = "/WEB-INF/jsp/order/NewOrderForm.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProceedToCheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = null;
	    account  = (Account) session.getAttribute("account");
	    if(account == null){
	    	session.setAttribute("unlogin", "You must sign on before attempting to check out. Please sign on and try checking out again.");
	    	request.getRequestDispatcher(SIGNONFORM).forward(request,response);
	    	session.removeAttribute("unlogin");
	    	
	    }else{
	    	request.getRequestDispatcher(NEWORDERFORM).forward(request,response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
