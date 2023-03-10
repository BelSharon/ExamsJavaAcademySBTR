<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar libro nuevo</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Mi pequeña biblioteca</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar libro</h3>
	
		<form:form action="saveLibro" modelAttribute="libro" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Título:</label></td>
						<td><form:input path="titulo" /></td>
					</tr>
				
					<tr>
						<td><label>Autor:</label></td>
						<td><form:input path="autor" /></td>
					</tr>

					<tr>
						<td><label>Editorial:</label></td>
						<td><form:input path="editorial" /></td>
					</tr>
					
					<tr>
						<td><label>Disponible:</label></td>
						<td><form:input path="disponible" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/libro/list">Regresar a la lista</a>
		</p>
	
	</div>

</body>

</html>










