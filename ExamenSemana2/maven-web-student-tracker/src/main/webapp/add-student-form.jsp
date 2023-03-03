<!DOCTYPE html>
<html>

<head>
	<title>Agregar estudiante</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
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
		
		<form action="StudentControllerServlet" method="GET">
		
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
							<select class="form-select" aria-label="Default select example">
							  <option selected>Selecciona una casa</option>
							  <option value="1">Hufflepuff</option>
							  <option value="2">Griffindor</option>
							  <option value="3">Slytherin</option>
							  <option value="4">Revenclaw</option>
							</select>
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
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>

</html>











