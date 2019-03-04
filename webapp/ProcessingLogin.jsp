<html>
<head>
<meta charset="ISO-8859-1"> <%-- default character set for HTML 4.--%>
<meta charset="UTF-8"> <%-- number set --%>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  <%--Have information on page go to the device width --%> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">   <%--Using bootstraps css file --%> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  <%--Using bootstraps css file --%> 
<title>Vehicles</title> <%-- Title --%>
<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v"%>>  <%-- Tag Library --%>
</head>
<body>
	<h1 class = "text-center"><img src="images/adminbanner.png" style ="align:center; vertical-align:middle"></h1>  <%--Header--%>
	
	<%-- Button --%>
	<form method = "get" action="./add"> <%-- Form ./new as a method get --%>
	<button class="btn btn-primary" style="float:left"><i class="glyphicon glyphicon-plus"></i> New Vehicle</button> <%-- Button called new vehicle --%>
	</form> <%-- End of form --%>
	<%-- Button --%>
	<button type="button" class="btn btn-danger" style="float:right" class="text-white"><i class="glyphicon glyphicon-log-in"></i> <a href="./home" class="text-white">Log Out</a> </button>	
	<%--Search Bar --%>
	<form method = "get" action="./search" >
	<input type ="text" placeholder="Search by ID..." name = "search" value = "${v.getVehicle_id()}"><input type="submit" value="Search!"></form>
	<%-- Table --%>
	<table class = "table table-striped">
	<%-- Table Header --%>
	<thead class = "thead-dark" style ="align:center; vertical-align:middle">	
	<%-- Table Row --%>	
		<tr>
		<%-- Table Header --%>
			<th>ID</th>
			<th>Make</th>
			<th>Model</th>
			<th>Year</th>
			<th>Price</th>
			<th>License Number</th>
			<th>Colour</th>
			<th>Number Of Doors</th>
			<th>Transmission</th>
			<th>Mileage</th>
			<th>Fuel Type</th>
			<th>Engine Size</th>
			<th>Body Style</th>
			<th>Condition</th>
			<th>Notes</th>
			<th> </th>
		</tr>
			<v:forEach items="${AllVehicles}" var="v">
				<tr>
				<%-- Get Variables --%>
					<td>${v.getVehicle_id()}</td>
					<td>${v.getMake()}</td>
					<td>${v.getModel()}</td>
					<td>${v.getYear()}</td>
					<td>${v.getPrice()}</td>
					<td>${v.getLicense_number()}</td>
					<td>${v.getColour()}</td>
					<td>${v.getNumber_doors()}</td>
					<td>${v.getTransmission()}</td>
					<td>${v.getMileage()}</td>
					<td>${v.getFuel_type()}</td>
					<td>${v.getEngine_size()}</td>
					<td>${v.getBody_style()}</td>
					<td>${v.getCondition()}</td>
					<td>${v.getNotes()}</td>
			
			<td>
			<form method = "get" action="./delete">	 <%--Form method get for the action ./delete --%>	
					<%-- Button --%>
					 		<button class="btn btn-danger" name = "delete" value = "${v.getVehicle_id()}"><i class="glyphicon glyphicon-trash"></i></button>	
						</form> <%-- Form --%>
					
			<form method = "get" action="./edit">	 <%--Form method get for the action ./delete --%>		
					<%-- Button --%>
						<button class="btn btn-info" name = "edit" value = "${v.getVehicle_id()}"><i class="glyphicon glyphicon-pencil">				
						</i></button>
						</form> <%-- Form --%>
						 			
			</td>
			</tr>
			</v:forEach>
			
			
	</table> <%-- End of table --%>
	<br> <%-- Break (Space) --%>
</body> <%-- End of body tag --%>
</html> <%-- End of HTML tag --%>