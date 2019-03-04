//Amy Blackburn - 18058336

package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Pub;
import Models.PubDAO;

public class ServletHome extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{
		PubDAO dao = new PubDAO();
		ArrayList<Pub> AllPubs = dao.getAllPubs();
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		req.setAttribute("AllPubs", AllPubs);
		view.forward(req, resp);
	}	
}
