<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de Clientes</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Cliente Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Cliente"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Correo</th>
					<th>Saldo de Préstamo</th>
					<th>Acción</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCliente" items="${clientes}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/cliente/showFormForUpdate">
						<c:param name="clienteId" value="${tempCliente.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/cliente/eliminar">
						<c:param name="clienteId" value="${tempCliente.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempCliente.nombre} </td>
						<td> ${tempCliente.apellido} </td>
						<td> ${tempCliente.correo} </td>
						<td> ${tempCliente.saldoPrestamo} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Seguro de eliminar el cliente?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









