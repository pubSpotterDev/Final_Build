package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import Models.Pub;
import Models.PubDAO;
import Models.User;
import Models.UserDAO;

public class Controller {
	
	private static final String password = null;

	public static void main(String[] args) throws Exception {
		
		
		System.out.println("---------------------------");
		System.out.println("Pub Spotter Programme : ");
		System.out.println("Choose one of the following options : ");
		System.out.println("---------------------------");
		System.out.println("1 : Retrieve all Pubs");
		System.out.println("2 : Search for a Pub");
		System.out.println("3 : Insert new Pub in to database");
		System.out.println("4 : Update existing Pub details");
		System.out.println("5 : Delete Pub from database");
		System.out.println("6 : Retrieve all Users");
		System.out.println("7 : Search for a User");
		System.out.println("8 : Insert new User in to database");
		System.out.println("9 : Update existing User details");
		System.out.println("10 : Delete User from database");
		System.out.println("11 : Exit");
		System.out.println("Enter Choice >");

		Scanner scan = new Scanner(System.in);
		boolean mainLoop = true;
			
		
		while (true) { //running loop with case statement for all the CRUD methods
			int choice;
			choice = scan.nextInt();
			
			switch (choice) 
		    {
			case 1:
				System.out.println("-------------------------");
				getAll();
				System.out.print("Enter next choice >");
				break;
			case 2:
				System.out.println("-------------------------");
				search();
				System.out.print("Enter next choice >");
				break;
			case 3:
				System.out.println("-------------------------");
				insert();
				System.out.print("Enter next choice >");
				break;
			case 4:
				System.out.println("-------------------------");
				update();
				System.out.print("Enter next choice >");
				break;
			case 5:
				System.out.println("-------------------------");
				delete();
				System.out.print("Enter next choice >");
				break;
			case 6:
				System.out.println("-------------------------");
				getAllUsers();
				System.out.print("Enter next choice >");
				break;
			case 7:
				System.out.println("-------------------------");
				searchUser();
				System.out.print("Enter next choice >");
				break;
			case 8:
				System.out.println("-------------------------");
				insertUser();
				System.out.print("Enter next choice >");
				break;
			case 9:
				System.out.println("-------------------------");
				updateUser();
				System.out.print("Enter next choice >");
				break;
			case 10:
				System.out.println("-------------------------");
				deleteUser();
				System.out.print("Enter next choice >");
				break;	
			case 11:
				System.exit(choice); 
		    	break;
			default:
		    	System.out.println("This is an invalid choice!");
		    	break;
		    }
		}
	}
	
	static void getAll() throws SQLException {

		PubDAO dao = new PubDAO();	
		ArrayList<Pub> allPubs = null;
		
		allPubs = dao.getAllPubs();
		
		System.out.println("Retrieving all Pubs...");
		
		for (Pub p : allPubs) {
			System.out.println("-------------------------");
			System.out.println(p);
			System.out.println("-------------------------");
		}
	}
	
	static void search() throws SQLException {
		PubDAO dao = new PubDAO();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter pub number to find: ");
		System.out.println(dao.getPubById(scan.nextInt()));
		System.out.println("-------------------------");
	}
	
	static void insert() throws SQLException {//takes values for new vehicles one at a time 

		PubDAO dao = new PubDAO();

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter details of Pub to be added...");
		int pub_id = 1; // using auto increment so dont need an id
		System.out.println("Enter Name : ");
		String name = scan.next();
		System.out.println("Enter Street Name : ");
		String streetname = scan.next();
		System.out.println("Enter Post Code : ");
		String postcode = scan.next();
		//temp pub made with the new values which are then added to database
		Pub temp = new Pub(pub_id, name, streetname, postcode);
		dao.insertPub(temp);
		System.out.println("-------------------------");
	}
	
	static void update() throws SQLException {//pick which value to be updated and then can add new description

		PubDAO dao = new PubDAO();

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter Pub ID you wish to update : ");
	    int pub_id = scan.nextInt();
	    System.out.println("Please enter Pub Name: ");
	    String name = scan.next();
	    System.out.println("Please enter Pub Street Name: ");
	    String streetname = scan.next() ;
	    System.out.println("Please enter Pub Post Code: ");
	    String postcode = scan.next();
		Pub up = new Pub(pub_id, name, streetname,postcode);					
		System.out.println(dao.updatePub(up, pub_id));
		System.out.println("-------------------------");
}
	
	static void delete() throws SQLException {

		PubDAO dao = new PubDAO();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Pub ID of Pub to be deleted : ");
		System.out.println(dao.deletePub(scan.nextInt()));
		System.out.println("-------------------------");
	}
	
	static void getAllUsers() throws SQLException {

		UserDAO dao = new UserDAO();	
		ArrayList<User> allUsers = null;

		allUsers = dao.getAllUsers();

		for (User u : allUsers) {
			System.out.println("-------------------------");
			System.out.println(u);
			System.out.println("-------------------------");
		}
	}
	
	static void searchUser() throws SQLException {
		UserDAO dao = new UserDAO();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter User number to find: ");
		System.out.println(dao.getUserById(scan.nextInt()));
		System.out.println("-------------------------");
	}
	
	static void insertUser() throws SQLException {//takes values for new vehicles one at a time 

		UserDAO dao = new UserDAO();

		Scanner scan = new Scanner(System.in);
		int user_id = 1; // using auto increment so dont need an id
		System.out.println("Enter details of User to be added...");
		System.out.println("Enter Email : ");
		String email = scan.next();
		System.out.println("Enter Name : ");
		String name = scan.next();
		System.out.println("Enter Gender : ");
		String gender = scan.next();
		System.out.println("Enter DOB : ");
		String dob = scan.next();
		int points = 10; // default amount on creation
		//temp User made with the new values which are then added to database
		User temp = new User(user_id, email, name,dob , gender, points, password);
		dao.insertUser(temp);
		System.out.println("-------------------------");
	}
	
	static void updateUser() throws SQLException {//pick which value to be updated and then can add new description

		UserDAO dao = new UserDAO();

		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter User ID you wish to update : ");
	    int id = scan.nextInt();
	    System.out.println("Enter Email : ");
		String email = scan.next();
		System.out.println("Enter Name : ");
		String name = scan.next();
		System.out.println("Enter Gender : ");
		String gender = scan.next();
		System.out.println("Enter DOB : ");
		String dob = scan.next();
		int points = 0;
		User u = new User(id, email, name, dob, gender, points, password);					
		System.out.println(dao.updateUser(u, id));
		System.out.println("-------------------------");
	}
	
	static void deleteUser() throws SQLException {

		UserDAO dao = new UserDAO();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter User ID of User to be deleted : ");
		System.out.println(dao.deleteUser(scan.nextInt()));
		System.out.println("-------------------------");
	}	
}