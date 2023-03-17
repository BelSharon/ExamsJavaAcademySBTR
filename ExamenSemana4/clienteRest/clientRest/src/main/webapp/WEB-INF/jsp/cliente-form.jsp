<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Nuevo Cliente</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/agregar-cliente-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Cliente Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Cliente</h3>
	
		<form:form action="guardarCliente" modelAttribute="cliente" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Apellido:</label></td>
						<td><form:input path="apellido" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><form:input path="correo" /></td>
					</tr>
					
					<tr>
						<td><label>Saldo de Préstamo:</label></td>
						<td><form:input path="saldoPrestamo" /></td>
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
			<a href="${pageContext.request.contextPath}/cliente/list">Regresar a la Lista</a>
		</p>
	
	</div>

</body>

</html>










