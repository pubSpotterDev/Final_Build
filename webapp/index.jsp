<html>
<head>
<meta charset="ISO-8859-1"> <%-- default character set for HTML 4.--%>
<meta charset="UTF-8"> <%-- number set --%>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">  <%--Have information on page go to the device width --%> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">   <%--Using bootstraps css file --%> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  <%--Using bootstraps css file --%> 
<title>Pubs</title> <%-- Title --%>
<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v"%>>  <%-- Tag Library --%>
</head>
<body>
	
	<h1 class = "text-center"></h1>  <%--Header--%> 
		
	<%--Search Bar --%>
	<form method = "get" action="./search" >
	<input type ="text" placeholder="Search by ID..." name = "search" value = "${p.getPub_id()}"><input type="submit" value="Search!"></form>
	<%-- Table --%>
	<table class = "table table-striped">
	<%-- Table Header --%>
	<thead class = "thead-dark" style ="align:center; vertical-align:middle">	
	<%-- Table Row --%>	
		<tr>
		<%-- Table Header --%>
			<th>ID</th>
			<th>Name</th>
			<th>Street Name</th>
			<th>Postcode</th>
		</tr>
			<v:forEach items="${AllPubs}" var="v">
				<tr>
				<%-- Get Variables --%>
					<td>${p.getPub_id()}</td>
					<td>${p.getName()}</td>
					<td>${p.getStreetName()}</td>
					<td>${p.getPostCode()}</td>
			</v:forEach>
	</table> <%-- End of table --%>
	<br> <%-- Break (Space) --%>
</body> <%-- End of body tag --%>
</html> <%-- End of HTML tag --%>