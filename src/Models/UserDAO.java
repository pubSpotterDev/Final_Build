package Models;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;

public class UserDAO {

	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			}
		try {
			String dbURL = "jdbc:sqlite:Pub_Spotter.sqlite";
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return dbConnection;
		}
	
	public ArrayList<User> getAllUsers()
	{
			Connection con= null;
			PreparedStatement GetAllUsers = null;
			ResultSet rs = null;
			String SelectAll = "SELECT * FROM users" ; 
			ArrayList<User> list =new ArrayList<User>();
			
			try
			{
				con = UserDAO.getDBConnection();
				GetAllUsers = con.prepareStatement(SelectAll);
				rs = GetAllUsers.executeQuery();
				
			while(rs.next())
			{
				User u=new User(0, SelectAll, SelectAll,  SelectAll, SelectAll, 0, SelectAll);
					u.setId(rs.getInt(1));
					u.setEmail(rs.getString(2));
					u.setName(rs.getString(3));
					u.setDob(rs.getString(4));
					u.setGender(rs.getString(5));
					u.setPoints(rs.getInt(6));
					u.setPassword(rs.getString(7));
					list.add(u);
			}
			con.close();
		}catch(Exception u){u.printStackTrace();}		
		return list;
	}	
	
	public Boolean checkPassword(String name, String pass) throws SQLException {
		System.out.println("Retreiving Users....");
		Connection dbConnection = null;
		Statement statement = null;
		ResultSet result = null;
		boolean correct = false;

		String query = "SELECT * FROM users;";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = " + query);
			result = statement.executeQuery(query);
			while (result.next()) {// loops through all the users to find if the password and username match any
									// from the database
				String email = result.getString("email");
				String password = result.getString("password");
				// turns the password into a hash using md5 so it can be compared to the hashed
				// password from the web front end
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(password.getBytes());
					byte[] digest = md.digest();
					String password2 = DatatypeConverter.printHexBinary(digest).toUpperCase();
					// compares the hash from the front end to the hashed version from the database
					if (email.equals(name) && password2.equals(pass)) {
						correct = true;
					}
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return correct;
	}
	
	public User getUserById(int ID) {
		User u=new User(ID, null, null, null, null, ID, null);
		
		try{
			Connection con= UserDAO.getDBConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM users WHERE ID =?;");
			ps.setInt(1,ID);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				u.setId(rs.getInt(1));
				u.setEmail(rs.getString(2));
				u.setName(rs.getString(3));
				u.setDob(rs.getString(4));
				u.setGender(rs.getString(5));
				u.setPoints(rs.getInt(6));
				u.setPassword(rs.getString(7));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		return u;
	}
	
	public Boolean deleteUser(int id)
		{
			Connection dbConnection = null;
			PreparedStatement DeleteUserID= null;
			int result = 0; //result is default false
			String DeleteUser = "DELETE FROM users WHERE id = " + id + ";" ; //Delete from users where the pub id is _ variable entered
			try
			{
				dbConnection = getDBConnection();
				try 
				{
					DeleteUserID = dbConnection.prepareStatement(DeleteUser); //prepare statement using SQL query
				} 
				catch (SQLException e) 
				{
					e.getMessage(); //If error print message
				}
				System.out.println(DeleteUser); //Print SQL query as text
				try 
				{
					result = DeleteUserID.executeUpdate(); //execute the SQL query
					System.out.println("User Deleted!");
				} 
				catch (SQLException e) 
				{
					e.getMessage(); //if error print message
				}
			}
			finally
			{
				if(DeleteUserID!=null)  //if user pub id is not equal to null
				{ 
					try 
					{
						DeleteUserID.close(); //close the SQL prepared statement
					} 
					catch (SQLException e) 
					{
						e.getMessage(); //if error print message
					} 
				}
				if(dbConnection != null)  //if connection is not null
				{ 
					try 
					{
						dbConnection.close(); //close connection
					} 
					catch (SQLException e) 
					{
						e.getMessage(); //if error print message
					} 
				}
		}
		if (result == 1) //if result is equal to 1 
		{	
			return true; //return true
		} 
		else //otherwise
		{
			return false; //return false
		}
	}	
			
	public Boolean updateUser(User u, int id) throws SQLException{

		System.out.println("Updating User...");
		boolean update = false;
		Connection dbConnection = null;
		Statement statement = null;		
		String query = "UPDATE users "+ 
				"SET email ="+"\""+u.getEmail()+"\","+
				"name ="+"\""+u.getName()+"\","+
				"gender ="+"\""+u.getGender()+"\","+
				"dob ="+"\""+u.getDob()+"\","+
				"points ="+"\""+u.getPoints()+"\""+
				"password ="+"\""+u.getPassword()+"\""+
				"WHERE id ="+id+";";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = "+query);
			update = statement.execute(query);			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			if(statement != null) {statement.close();
			}
			if(dbConnection != null) {dbConnection.close();}
		}
		return true;
	}
	
	public Boolean insertUser(User u) throws SQLException{

		System.out.println("Inserting User....");
		boolean insert = false;
		Connection dbConnection = null;
		Statement statement = null;		

		String query = "INSERT INTO users ('email', 'name', 'gender', 'dob', 'points', password') "
				+ "VALUES("+
				"\""+u.getEmail()+"\","+
				"\"" + u.getName()+"\","+
				"\""+u.getGender()+"\","+
				"\""+u.getDob()+"\","+
				"\""+u.getPoints()+"\","+
				"\""+u.getPassword()+"\");";
		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			System.out.println("DBQuery = "+query);
			insert = statement.execute(query);	
		
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally 
		{	
			if(statement != null) {statement.close();
			}
			if(dbConnection != null) {dbConnection.close();
			}
		}
		insert = true;
		return insert;
	}
}

	
	