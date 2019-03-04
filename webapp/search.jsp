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
	<h1 class = "text-center"><img src="images/searchbanner.png" style ="align:center; vertical-align:middle"></h1>  <%--Header--%>
	
	<%-- Button --%>
	<button type="button" class="btn btn-danger" style="float:left" class="text-white"><i class="glyphicon glyphicon-log-in"></i> <a href="./home" class="text-white">Home</a> </button>
	<%-- Button --%>
	<button type="button" class="btn btn-danger" style="float:right" class="text-white"><i class="glyphicon glyphicon-log-in"></i> <a href="./login.jsp" class="text-white">Log In</a> </button>	
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
		</tr>
				<tr>
				<%-- Get Variables --%>
					<td>${vehicle.getVehicle_id()}</td>
					<td>${vehicle.getMake()}</td>
					<td>${vehicle.getModel()}</td>
					<td>${vehicle.getYear()}</td>
					<td>${vehicle.getPrice()}</td>
					<td>${vehicle.getLicense_number()}</td>
					<td>${vehicle.getColour()}</td>
					<td>${vehicle.getNumber_doors()}</td>
					<td>${vehicle.getTransmission()}</td>
					<td>${vehicle.getMileage()}</td>
					<td>${vehicle.getFuel_type()}</td>
					<td>${vehicle.getEngine_size()}</td>
					<td>${vehicle.getBody_style()}</td>
					<td>${vehicle.getCondition()}</td>
					<td>${vehicle.getNotes()}</td>
	</table> <%-- End of table --%>
	<br> <%-- Break (Space) --%>
</body> <%-- End of body tag --%>
</html> <%-- End of HTML tag --%>