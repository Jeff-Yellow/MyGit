package myJpetStore.web.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myJpetStore.domain.Order;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
@WebServlet("/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONFIRMORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
		Order order;
	  private String firstName;
	  private String lastName;
	  private String shipAddress1;
	  private String shipAddress2;
	  private String shipCity;
	  private String shipState;
	  private String shipZip;
	  private String shipCountry;
	 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		firstName = request.getParameter("shipToFirstName");
		lastName = request.getParameter("shipToLastName");
		shipAddress1 = request.getParameter("shipAddress1");
		shipAddress2 = request.getParameter("shipAddress2");
		shipCity =request.getParameter("shipCity");
		shipState = request.getParameter("shipState");
		shipZip = request.getParameter("shipZip");
		shipCountry = request.getParameter("shipCountry");
		order = (Order) request.getAttribute("order");
		order.setShipToFirstName(firstName);
		order.setShipToLastName(lastName);
		order.setShipAddress1(shipAddress1);
		order.setShipAddress2(shipAddress2);
		order.setShipCity(shipCity);
		order.setShipState(shipState);
		order.setShipZip(shipZip);
		order.setShipCountry(shipCountry);
		order.setOrderDate(new Date());
		request.getRequestDispatcher(CONFIRMORDER).forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
