<!DOCTYPE html>
<html>

<head>
	<title>Actualizar información</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Colegio Hogwarts</h2>
			<h4>de Magia y Hechicería</h4>
		</div>
	</div>
	
	<div id="container">
		<h3>Actualizar información</h3>
		
		<form action="StudentControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="studentId" value="${THE_STUDENT.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="firstName" 
								   value="${THE_STUDENT.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="lastName" 
								   value="${THE_STUDENT.apellido}" /></td>
					</tr>

					<tr>
						<td><label>Casa:</label></td>
						<td>
							<select class="form-select" aria-label="Default select example">
							  <option selected value="${THE_STUDENT.casa}">Selecciona una casa</option>
							  <option value="1">Hufflepuff</option>
							  <option value="2">Griffindor</option>
							  <option value="3">Slytherin</option>
							  <option value="4">Revenclaw</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="StudentControllerServlet">Regresar</a>
		</p>
	</div>
</body>

</html>











