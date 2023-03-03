<%@ page import="java.util.*, com.exam.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Student Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
// get the students from the request object (sent by servlet)
	List<Estudiante> theStudents = 
			(List<Estudiante>) request.getAttribute("STUDENT_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Colegio Hogwarts</h2>
			<h4>de Magia y Hechicería</h4>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Casa</th>
					<th>Mascota</th>
				</tr>
				
				<%
								for (Estudiante tempStudent : theStudents) {
								%>
				
					<tr>
						<td> <%= tempStudent.getNombre() %> </td>
						<td> <%= tempStudent.getApellido() %> </td>
						<td> <%= tempStudent.getCasa() %> </td>
						<td> <%= tempStudent.getMascota() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








