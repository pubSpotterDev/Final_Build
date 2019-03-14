package Models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PubDAO {

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
	
	public ArrayList<Pub> getAllPubs()
	{
			Connection con= null;
			PreparedStatement GetAllPubs = null;
			ResultSet rs = null;
			String SelectAll = "SELECT * FROM Pubs" ; 
			
			ArrayList<Pub> list =new ArrayList<Pub>();
			
			try
			{
				con = PubDAO.getDBConnection();
				GetAllPubs = con.prepareStatement(SelectAll);
				rs = GetAllPubs.executeQuery();
				
			while(rs.next())
			{
				Pub p=new Pub(0, SelectAll, SelectAll, SelectAll);
					p.setPub_id(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setStreetName(rs.getString(3));
					p.setPostCode(rs.getString(4));
					
				list.add(p);
			}
			con.close();
		}catch(Exception p){p.printStackTrace();}		
		return list;
	}	
	
	public Pub getPubById(int ID) {
		Pub p=new Pub(ID, null, null, null);
		
		try{
			Connection con= PubDAO.getDBConnection();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM Pubs WHERE pub_ID =?;");
			ps.setInt(1,ID);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				p.setPub_id(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setStreetName(rs.getString(3));
				p.setPostCode(rs.getString(4));			
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return p;
	}
	
	public Boolean deletePub(int pub_id)
		
		{
			Connection dbConnection = null;
			PreparedStatement DeletePubID= null;
			int result = 0; //result is default false
			String DeletePub = "DELETE FROM Pubs WHERE pub_id = " + pub_id + ";" ; //Delete from pubs where the pub id is _ variable entered
			try
			{
				dbConnection = getDBConnection();
				try 
				{
					DeletePubID = dbConnection.prepareStatement(DeletePub); //prepare statement using SQL query
				} 
				catch (SQLException e) 
				{
					e.getMessage(); //If error print message
				}
				System.out.println(DeletePub); //Print SQL query as text
				try 
				{
					result = DeletePubID.executeUpdate(); //execute the SQL query
					System.out.println("Pub Deleted!");
				} 
				catch (SQLException e) 
				{
					e.getMessage(); //if error print message
				}
			}
			finally
			{
				if(DeletePubID!=null)  //if delete pub id is not equal to null
				{ 
					try 
					{
						DeletePubID.close(); //close the SQL prepared statement
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
			
	public Boolean updatePub(Pub p, int b) throws SQLException{

		System.out.println("Updating Pub...");

		boolean update = false;

		Connection dbConnection = null;
		PreparedStatement Update = null;

		String UpdatePub = "UPDATE pubs "+ 

				"SET name ="+"\""+p.getName()+"\","+
				"street_name ="+"\""+p.getStreetName()+"\","+
				"postcode = "+ "\""+p.getPostCode()+"\" "+
				"WHERE pub_id ="+b+";";
		try 
		{
			dbConnection = getDBConnection(); //get database connection
			Update = dbConnection.prepareStatement(UpdatePub); //prepare statement update pub variable
			System.out.println(UpdatePub); //print out as message sql statement
			System.out.println("Pub "  + b + " Has Been Updated!");
			Update.executeUpdate(); //execute sql update
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage()); //if error print message
			return false; //return false
		}
		return true;
	}

	public Boolean insertPub(Pub p) throws SQLException{

		System.out.println("Inserting Pub....");
		boolean insert = false;
		Connection dbConnection = null;
		Statement statement = null;		

		String query = "INSERT INTO Pubs ('name', 'street_name', 'postcode') "

				+ "VALUES("+

				"\"" + p.getName()+"\","+

				"\""+p.getStreetName()+"\","+

				"\""+p.getPostCode()+"\");";

		try {
			System.out.println(query);
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

	
	