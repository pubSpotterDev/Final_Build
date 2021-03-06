package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{
		writer = resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		
		Integer pub_id = Integer.parseInt(req.getParameter("pub_id"));
		String name = req.getParameter("name");
		String streetname = req.getParameter("streetname"); 
		String postcode = req.getParameter("postcode"); 
			
		Pub in = new Pub(pub_id,name,streetname,postcode);
		
		System.out.println(in.getPub_id() + " " + in.getName() + " " +  in.getStreetName() + " "  +  in.getPostCode());
		
		Boolean inserted = true;
		try {
			inserted = dao.insertPub(in);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(inserted)
		{
			writer.write("New Vehicle Inserted");
		}
		else
		{
			writer.write("Error");
		}
		writer.close();		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{
		int pub_id = Integer.parseInt(req.getParameter("pub_id"));
		String name = req.getParameter("name");
		String streetname =  req.getParameter("streetname");
		String postcode =  req.getParameter("postcode");
		
		PubDAO dao = new PubDAO();
		
		Pub in = new Pub(pub_id,name,streetname,postcode);
		
		System.out.println(in.getPub_id() + " " + in.getName() + " " +  in.getStreetName() + " "  +  in.getPostCode());
		
		boolean update = false;
		try {
			update = dao.updatePub(in, pub_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(update)
		{
			writer.write("Pub Updated");
		}
		else
		{
			writer.write("Error");
		}
		writer.close();		
	
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{
		Integer pub_id = Integer.parseInt(req.getParameter("delete")); //request parameter delete
		
		Boolean delete = false;
		delete = dao.deletePub(pub_id); //if boolean done is called carry out the method delete vehicle from dao class using ID
		
		if(delete)
		{
			writer.write("Pub Deleted");
		}
		else
		{
			writer.write("Error");
		}
		writer.close();	
	}
}	

