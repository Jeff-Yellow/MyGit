package myJpetStore.web.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myJpetStore.domain.Account;
import myJpetStore.domain.Cart;
import myJpetStore.domain.CartItem;
import myJpetStore.domain.Order;
import myJpetStore.service.OrderService;

/**
 * Servlet implementation class ConfirmedOrderServlet
 */
@WebServlet("/ConfirmedOrderServlet")
public class ConfirmedOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEWORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";
	private Order order;
    private Cart cart;
    private Account account;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmedOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession httpSession = request.getSession();
	        OrderService orderService = new OrderService();
	        order = (Order)httpSession.getAttribute("order");
	        cart = (Cart)httpSession.getAttribute("cart");
	        account = (Account)httpSession.getAttribute("account");
	        for(CartItem item : cart.getCartItemList()) {
	            order.addLineItem(item);
	        }
	        order.setUsername(account.getUsername());
	        order.setTotalPrice(cart.getSubTotal());
	        order.setOrderDate(new Date());
	        order.setCourier("UPS");
	        order.setStatus("P");
	        order.setLocale(" ");
	        orderService.insertOrder(order);
	        httpSession.removeAttribute("cart");
	        request.getRequestDispatcher(VIEWORDER).forward(request,response);
		
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
