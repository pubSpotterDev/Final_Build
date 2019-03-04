//Amy Blackburn - 18058336
package Controller;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.Configuration.ClassList;

public class ControllerServer 
{
	public static void main(String[] args) throws Exception
	{
		Server server = new Server(8010); //Set server to port 8005
		WebAppContext ctx = new WebAppContext();
		ctx.setResourceBase("webapp"); //Using the webapp folder 
		ctx.setContextPath("/pubspotter");
		
		//config
		ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/[^/]*jstl.*\\.jar$");
		ClassList classlist = ClassList.setServerDefault(server);
		classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
		
		//Mappings
		ctx.addServlet("Servlets.ServletHome","/home"); // Display All Vehicle - Landing Page
//		ctx.addServlet("servlets.ServletLogin", "/login"); //Display Login Page
//		ctx.addServlet("servlets.ServletEdit", "/edit");  //Display EditForm Page
//		ctx.addServlet("servlets.ServletDelete", "/delete"); //Use /delete after servlet ServletDelete has been run
//		ctx.addServlet("servlets.ServletAdd", "/add"); //Display new vehicle page
//		ctx.addServlet("servlets.ServletSearch", "/search"); //Display vehicle by ID
		ctx.addServlet("Servlets.API" , "/api"); //API
		
	//Setting the handler and starting the Server
		server.setHandler(ctx); //Set the handler to the new web app context ctx variable
		server.start(); //Start the server
		server.join(); //Join the server
	}
}