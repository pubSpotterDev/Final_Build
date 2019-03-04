<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  <%--Have information on page go to the device width --%> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">   <%--Using bootstraps css file --%> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  <%--Using bootstraps css file --%> 
<title>Vehicles</title> <%-- Title --%>
<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v"%>>  <%-- Tag Library --%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 class = "text-center"><img src="images/editbanner.png" style ="align:center; vertical-align:middle"></h1>  <%--Header--%> 
		
<form method="post" >
ID: <input type="number" name="id" value="${vehicle.getVehicle_id()}" readonly> <br> 
Make: <input type="text" name="make" value="${vehicle.getMake()}"> <br> 
Model: <input type="text" name="model" value="${vehicle.getModel()}"> <br>
Year: <input type="number" name="year" value="${vehicle.getYear()}"> <br>
Price: <input type="number" name="price" value="${vehicle.getPrice()}"> <br>
License Number: <input type="text" name="license_number" value="${vehicle.getLicense_number()}"><br>
Colour: <input type="text" name="colour" value="${vehicle.getColour()}"> <br>
Number of Doors: <input type="number" name="number_doors" value="${vehicle.getNumber_doors()}"> <br>
Transmission: <input type = "text" name="transmission" value="${vehicle.getTransmission()}"><br>
Mileage: <input type="number" name="mileage" value="${vehicle.getMileage()}"> <br>
Fuel Type: <input type="text" name="fuel_type" value="${vehicle.getFuel_type()}"> <br>
Engine Size: <input type="number" name="engine_size" value="${vehicle.getEngine_size()}"> <br>
Body Style: <input type="text" name="body_style" value="${vehicle.getBody_style()}"> <br>
Condition: <input type="text" name="condition" value="${vehicle.getCondition()}"> <br>
Notes: <input type="text" name="notes" value="${vehicle.getNotes()}"> <br>
<input type="submit" value="Update Vehicle!">
</form>
</body>
</html>
