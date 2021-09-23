<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="parts/meta.jsp"%>
<%@ include file="parts/header.jsp"%>
<title>Get Cliente</title>
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
				<form:form action="searchById/data" method="POST">
					<div class="row my-3">
						<label for="inputId" class="form-label my-2">Id</label>
						<input
							type="number" id="inputId" name="id" tabindex="1"
							placeholder="Introduce aquí el Id del cliente"
							class="form-control fw-light" min="1" >
					</div>
					<div class="d-flex justify-content-center mt-5">
						<input type="submit" id="actionSubmit" class="btn btn-warning" value="Search" tabindex="4">
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!--------------------------- BODY --------------------------->
	<%@ include file="parts/footer.jsp"%>
</body>
</html>