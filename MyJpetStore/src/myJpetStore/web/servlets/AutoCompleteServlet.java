package myJpetStore.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myJpetStore.service.CatalogService;

/**
 * Servlet implementation class AutoCompleteServlet
 */
@WebServlet("/AutoCompleteServlet")
public class AutoCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> db = new ArrayList<String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutoCompleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CatalogService service = new CatalogService();
		db = service.getProductName();
		String tag = request.getParameter("tag");
		if (tag != "") {
			String rs = "";
			for (int i = 0; i < this.db.size(); i++) {
				if (this.db.get(i).startsWith(tag)) {
					rs = rs + this.db.get(i) + ",";
				}
			}
			if (rs != "") {
				rs = rs.substring(0, rs.length() - 1);
			}
			PrintWriter pw = response.getWriter();
			pw.write(rs);
			pw.flush();
			pw.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
