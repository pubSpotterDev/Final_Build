package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import Models.Pub;
import Models.PubDAO;

public class API extends HttpServlet{
	
	private static final long serialVersionUID =1L;
	
	PubDAO dao = new PubDAO();
	Gson gson = new Gson();
	PrintWriter writer;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		ArrayList<Pub> allPubs = dao.getAllPubs();
		resp.setContentType("application/json");
		writer = resp.getWriter();
		String pubJSON = gson.toJson(allPubs);
		writer.write(pubJSON);
		writer.close();
	}
}	

