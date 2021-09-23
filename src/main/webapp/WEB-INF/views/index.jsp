<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="parts/meta.jsp"%>
<%@ include file="parts/header.jsp"%>
<title>Clientes</title>
</head>
<body>
	<!--------------------------- NAVBAR --------------------------->
	<%@ include file="parts/navbar.jsp"%>
	<!--------------------------- NAVBAR --------------------------->
	<!--------------------------- BODY --------------------------->
	<div class="container-fluid" style="margin-top: 100px">
		<div class="row align-items-center justify-content-center mt-5 mb-5">
			<div class="col-6">
				<table class="table table-striped text-center table align-middle">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Email</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cliente" items="${clientes}">
							<tr>
								<td>${cliente.id}</td>
								<td>${cliente.nombre}</td>
								<td>${cliente.apellido}</td>
								<td>${cliente.email}</td>
								<td>
								<a href="update/byId/${cliente.id}"class="btn btn-warning"><img
					src="${pageContext.request.contextPath}/resources/img/update.png"
					alt="logo" width="25" height="25"></a>
								<a href="delete/byId/${cliente.id}" class="btn btn-warning" ><img
					src="${pageContext.request.contextPath}/resources/img/delete.png"
					alt="logo" width="25" height="25"></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="parts/footer.jsp"%>
</body>
</html>