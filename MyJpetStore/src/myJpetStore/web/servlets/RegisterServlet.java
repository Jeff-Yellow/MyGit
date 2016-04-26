package myJpetStore.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myJpetStore.domain.Account;
import myJpetStore.service.AccountService;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Account  account; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	            AccountService accountService = new AccountService();
	            account = new Account();
	            account.setUsername(request.getParameter("username"));
	            account.setPassword(request.getParameter("password"));

	            if(account.getUsername().equals("") || account.getPassword().equals("")){
	                request.getRequestDispatcher("/WEB-INF/jsp/account/NewAccountForm.jsp").forward(request,response);
	            }else if(!account.getPassword().equals(request.getParameter("repeatedPassword"))){
	                request.getRequestDispatcher("/WEB-INF/jsp/account/NewAccountForm.jsp").forward(request,response);
	            }else if(accountService.getAccount(account.getUsername()) == null){
	                try{
	                    account.setFirstName(request.getParameter("firstName"));
	                    account.setLastName(request.getParameter("lastName"));
	                    account.setEmail(request.getParameter("email"));
	                    account.setPhone(request.getParameter("phone"));
	                    account.setAddress1(request.getParameter("address1"));
	                    account.setAddress2(request.getParameter("address2"));
	                    account.setCity(request.getParameter("city"));
	                    account.setState(request.getParameter("state"));
	                    account.setZip("zip");
	                    account.setCountry("country");
	                    account.setLanguagePreference(request.getParameter("languagePreference"));
	                    account.setFavouriteCategoryId(request.getParameter("favouriteCategoryId"));
	                    account.setListOption(request.getParameter("listOption") != null);
	                    account.setBannerOption(request.getParameter("bannerOption") != null);
	                    accountService.insertAccount(account);
	                }catch (Exception e){
	                    e.printStackTrace();
	                }
	                request.getRequestDispatcher("/WEB-INF/jsp/catalog/Main.jsp").forward(request, response);
	            }
	            else{
	            request.getRequestDispatcher("/WEB-INF/jsp/account/NewAccountForm.jsp").forward(request,response);
	            }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
