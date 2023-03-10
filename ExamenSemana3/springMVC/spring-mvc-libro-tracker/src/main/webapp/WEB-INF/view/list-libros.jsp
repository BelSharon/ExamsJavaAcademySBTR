<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de libros</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Mi pequeña biblioteca</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Libro"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Título</th>
					<th>Autor</th>
					<th>Editorial</th>
					<th>Disponibilidad</th>
					<th>Acción</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tmpLibro" items="${libros}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/libro/showFormForUpdate">
						<c:param name="libroId" value="${tmpLibro.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/libro/delete">
						<c:param name="libroId" value="${tmpLibro.id}" />
					</c:url>					
					
					<tr>
						<td> ${tmpLibro.titulo} </td>
						<td> ${tmpLibro.autor} </td>
						<td> ${tmpLibro.editorial} </td>
						<td> ${tmpLibro.disponible} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Seguro de eliminar el Libro?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









