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
import Models.User;
import Models.UserDAO;


public class UserAPI extends HttpServlet{
	
	private static final long serialVersionUID =1L;
	
	UserDAO dao = new UserDAO();
	Gson gson = new Gson();
	PrintWriter writer;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		ArrayList<User> allUsers = dao.getAllUsers();
		resp.setContentType("application/json");
		writer = resp.getWriter();
		String pubJSON = gson.toJson(allUsers);
		writer.write(pubJSON);
		writer.close();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
	{
		writer = resp.getWriter();
		resp.setContentType("text/html;charset=UTF-8");
		
		
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender"); 
		String dob = req.getParameter("dob");
		Integer id = Integer.parseInt(req.getParameter("id"));
		Integer points = Integer.parseInt(req.getParameter("points"));
		String password = req.getParameter("password");
			
		User in = new User(id,name,gender,dob,email,points,password);
		
		Boolean inserted = true;
		try {
			inserted = dao.insertUser(in);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(inserted)
		{
			writer.write("New User Inserted");
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
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String gender =  req.getParameter("gender");
		String dob =  req.getParameter("dob");
		int id = Integer.parseInt(req.getParameter("id"));
		int points = Integer.parseInt(req.getParameter("points"));
		String password =  req.getParameter("password");
		
		UserDAO dao = new UserDAO();
		
		User in = new User(id,name,gender,dob,email,points,password);
		
		System.out.println(in.getId() + " " + in.getEmail() + " " +  in.getName() + " "  +  in.getGender() + in.getDob() + " " + in.getPoints()+ " " + in.getPassword());
		
		boolean update = false;
		try {
			update = dao.updateUser(in, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(update)
		{
			writer.write("User Updated");
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
		Integer id = Integer.parseInt(req.getParameter("delete")); //request parameter delete
		
		Boolean delete = false;
		delete = dao.deleteUser(id); //if boolean done is called carry out the method delete vehicle from dao class using ID
		
		if(delete)
		{
			writer.write("User Deleted");
		}
		else
		{
			writer.write("Error");
		}
		writer.close();	
	}
}	

