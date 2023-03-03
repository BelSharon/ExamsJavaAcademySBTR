<!DOCTYPE html>
<html>

<head>
	<title>Agregar estudiante</title>

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
		<h3>Agregar estudiante</h3>
		
		<form action=EstudianteControllerServlet method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr>

					<tr>
						<td><label>Apellido:</label></td>
						<td><input type="text" name="lastName" /></td>
					</tr>

					<tr>
						<td><label>Casa:</label></td>
						<td>
							<select name="casa" class="form">
							  <option selected>Selecciona una casa</option>
							  <option value="Hufflepuff">Hufflepuff</option>
							  <option value="Griffindor">Griffindor</option>
							  <option value="Slytherin">Slytherin</option>
							  <option value="Revenclaw">Revenclaw</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<td><label>Mascota:</label></td>
						<td><input type="text" name="mascota" /></td>
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
			<a href="EstudianteControllerServlet">Regresar</a>
		</p>
	</div>
</body>

</html>











