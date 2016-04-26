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
 * Servlet implementation class SaveAccountInformationServlet
 */
@WebServlet("/SaveAccountInformationServlet")
public class SaveAccountInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String EDITACCOUNTFORM = "/WEB-INF/jsp/account/EditAccountForm.jsp";
	private String repeatedPassword;
	private String password;
	private String username;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAccountInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		password = request.getParameter("password");
		repeatedPassword = request.getParameter("repeatedPassword");
		
		if(password.equals(repeatedPassword)){
			HttpSession session =request.getSession();
			Account account = null;
			account = (Account) session.getAttribute("account");
			
			username = account.getUsername();		
			AccountService accountService = new AccountService();
			  account.setEmail(request.getParameter("email"));
			  account.setFirstName(request.getParameter("firstName"));
			  account.setLastName(request.getParameter("lastName"));
			  account.setPassword(password);
			  account.setAddress1(request.getParameter("address1"));
			  account.setAddress2(request.getParameter("address2"));
			  account.setCity(request.getParameter("city"));
			  account.setState(request.getParameter("state"));
			  account.setStatus("ok");
			  account.setZip(request.getParameter("zip"));
			  account.setCountry(request.getParameter("country"));
			  account.setPhone(request.getParameter("phone"));
			  account.setLanguagePreference(request.getParameter("languagePreference"));
			  account.setFavouriteCategoryId(request.getParameter("favouriteCategoryId"));
			  account.setListOption(request.getParameter("listOption")=="on"?true:false);
			  account.setBannerOption(request.getParameter("bannerOption")=="on"?true:false);
			  accountService.updateAccount(account);	
			  session.setAttribute("account",account);
			  session.setAttribute("updateInfo", "successUpdate");
			  request.getRequestDispatcher(EDITACCOUNTFORM).forward(request,response);
			  session.removeAttribute("updateInfo");
		
		}else{
			HttpSession session =request.getSession();
			session.setAttribute("updateInfo", "The two passwords are not the same");
			request.getRequestDispatcher(EDITACCOUNTFORM).forward(request,response);
			session.removeAttribute("UpdateInfo");
			
		}
		
		}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
