<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="parts/meta.jsp"%>
<%@ include file="parts/header.jsp"%>
<title>Cliente Data</title>
</head>
<body>
	<!--------------------------- NAVBAR --------------------------->
	<%@ include file="parts/navbar.jsp"%>
	<!--------------------------- NAVBAR --------------------------->
	<!--------------------------- BODY --------------------------->
	<div class="container-fluid align-items-center justify-content-center"
		style="margin-top: 100px">
		<div class="row my-5 justify-content-center">
			<div class="col-8 col-sm-6 col-md-5 col-lg-4">
				<form:form action="data/actionSubmit" modelAttribute="cliente"
					method="POST">
					<div class="row my-3">
						<label for="inputClienteId" id="labelClienteId" class="form-label my-2">Id</label> <input
							type="number" id="inputClienteId" name="id" tabindex="1"
							value="${cliente.id}" class="form-control fw-light" required
							readonly="true">
					</div>
					<div class="row my-3">
						<label for="inputClienteNombre" class="form-label my-2">Nombre</label> <input
							type="text" id="inputClienteNombre" name="nombre" tabindex="2"
							value="${cliente.nombre}" class="form-control fw-light" required
							readonly="true">
					</div>
					<div class="row my-3">
						<label for="inputClienteApellido" class="form-label my-2">Apellido</label>
						<input type="text" id="inputClienteApellido" name="apellido" tabindex="3"
							value="${cliente.apellido}" class="form-control fw-light" required
							readonly="true">
					</div>
					<div class="row my-3">
						<label for="inputClienteEmail" class="form-label my-2">Email</label> <input
							type="text" id="inputClienteEmail" name="Email" tabindex="4"
							value="${cliente.email}" class="form-control fw-light" required
							readonly="true">
					</div>
					<div class="d-flex justify-content-center mt-5">
						<input type="submit" id="clienteActionSubmit" class="btn btn-warning" value="#"
							tabindex="5">
					</div>
					<script>customizeDataFormElements()</script>
				</form:form>
			</div>
		</div>
	</div>
	<!--------------------------- BODY --------------------------->
	<%@ include file="parts/footer.jsp"%>
</body>
</html>