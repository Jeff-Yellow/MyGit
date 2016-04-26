package myJpetStore.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myJpetStore.domain.Account;
import myJpetStore.domain.Order;
import myJpetStore.service.OrderService;


/**
 * Servlet implementation class ListOrdersServlet
 */
@WebServlet("/ListOrdersServlet")
public class ListOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ListOrders = "/WEB-INF/jsp/order/ListOrders.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession();
        Account account = (Account)httpSession.getAttribute("account");
        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.getOrdersByUsername(account.getUsername());
        httpSession.setAttribute("orderList",orderList);
        request.getRequestDispatcher(ListOrders).forward(request,response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
