package Models;

public class Pub {
	
	private int pub_id;
	private String name; 
	private String streetname; 
	private String postcode; 
	

	
	public Pub(int pub_id, String name, String streetname, String postcode)
	{
		this.pub_id = pub_id;
		this.name = name;
		this.streetname = streetname;
		this.postcode = postcode;	
	}
	
	public int getPub_id() {
		return pub_id;
	}

	public void setPub_id(int iD) {
		this.pub_id = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetName() {
		return streetname;
	}

	public void setStreetName(String streetname) {
		this.streetname = streetname;
	}

	public String getPostCode() {
		return postcode;
	}

	public void setPostCode(String postcode) {
		this.postcode = postcode;
	}

	//* Override to String method to get the vehicle information
	//*
		
	@Override
	public String toString() 
	{
		String s = "Pub_ID = " + pub_id + '\n' +
				"Name = " + name + '\n' +
				"Street Name = " + streetname + '\n' +
				"Post Code = " + postcode;
		return s; //Return string
	}
}
