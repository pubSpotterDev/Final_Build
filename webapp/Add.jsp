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
	<h1 class = "text-center"><img src="images/addbanner.png" style ="align:center; vertical-align:middle"></h1>  <%--Header--%> 
	
	<form method="post" >
	ID: <input type="number" name="id"> <br> 
	Make: <input type="text" name="make"> <br> 
	Model: <input type="text" name="model"> <br>
	Year: <input type="number" name="year"> <br>
	Price: <input type="number" name="price"> <br>
	
	License Number: <input type="text" name="license_number" pattern=".{7,}" title="Use format DG75VJO">  <br>
	
	Colour: <input type="text" name="colour"> <br>
	
	Number Of Doors: <select name = "number_doors">
	<option value = "2"> 2</option>
	<option value = "3"> 3</option>
	<option value = "4"> 4</option>
	<option value = "5"> 5</option>
	</select><br>
	
	Transmission: <select name = "transmission">
	<option value = "Manual"> Manual</option>
	<option value = "Automatic"> Automatic</option></select><br>
	
	Mileage: <input type="number" name="mileage"> <br>
	
	Fuel Type: <select name = "fuel_type">
	<option value = "Diesel"> Diesel</option>
	<option value = "Petrol"> Petrol</option></select><br>
	
	
	
	Engine Size: <input type="number" name="engine_size"> <br>
	Body Style: <input type="text" name="bosy_style"> <br>
	
	Condition: <select name = "condition">
	<option value = "Excellent"> Excellent</option>
	<option value = "New"> New</option>
	<option value = "Poor"> Poor</option>
	<option value = "Used"> Used</option>
	<option value = "Passable"> Passable</option>
	</select><br>
	
	Notes: <input type="text" name="notes"> <br>
	<input type="submit" value="Add Vehicle!">
	</form>

</body></html>
