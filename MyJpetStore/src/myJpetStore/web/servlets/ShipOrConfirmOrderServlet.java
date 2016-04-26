package myJpetStore.web.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myJpetStore.domain.Order;

/**
 * Servlet implementation class ShipOrConfirmOrderServlet
 */
@WebServlet("/ShipOrConfirmOrderServlet")
public class ShipOrConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SHIPPINGFORM = "/WEB-INF/jsp/order/ShippingForm.jsp";
	private static final String CONFIRMORDER = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private String cardType;  
    private String creditCard;
    private String expiryDate;
    private String shippingAddressRequired;
    private String billToFirstName;
    private String billToLastName;
    private String billAddress1;
    private String billAddress2;
    private String billCity;
    private String billState;
    private String billZip;
    private String billCountry;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShipOrConfirmOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cardType = request.getParameter("cardType");
		creditCard = request.getParameter("creditCard");
		expiryDate = request.getParameter("expiryDate");
		billToFirstName = request.getParameter("billToFirstName");
		billToLastName = request.getParameter("billToLastName");
		billAddress1 = request.getParameter("billAddress1");
		billAddress2 = request.getParameter("billAddress2");
		billCity = request.getParameter("billCity");
		billState = request.getParameter("billState");
		billZip = request.getParameter("billZip");
		billCountry = request.getParameter("billCountry");
		Order order = new Order();
		order.setBillAddress1(billAddress1);
		order.setBillAddress2(billAddress2);
		order.setBillCity(billCity);
		order.setBillCountry(billCountry);
		order.setBillState(billState);
		order.setBillToFirstName(billToFirstName);
		order.setBillToLastName(billToLastName);
		order.setBillZip(billZip);
		
		order.setShipAddress1(billAddress1);
		order.setShipAddress2(billAddress2);
		order.setShipCity(billCity);
		order.setShipCountry(billCountry);
		order.setShipState(billState);
		order.setShipToFirstName(billToFirstName);
		order.setShipToLastName(billToLastName);
		order.setShipZip(billZip);
		order.setOrderDate(new Date());
		order.setCardType(cardType);
		order.setCreditCard(creditCard);
		order.setExpiryDate(expiryDate);
		HttpSession session = request.getSession();
		session.setAttribute("order", order);
		
		shippingAddressRequired = request.getParameter("shippingAddressRequired");
		if(shippingAddressRequired != null){
			request.getRequestDispatcher(SHIPPINGFORM).forward(request,response);
			
		}else{
			
			request.getRequestDispatcher(CONFIRMORDER).forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
