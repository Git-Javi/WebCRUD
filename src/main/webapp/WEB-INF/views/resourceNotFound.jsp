<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="parts/meta.jsp"%>
<%@ include file="parts/header.jsp"%>
<title>Cliente Not Found</title>
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
				<div class="row my-3">
					<label for="inputId" class="form-label my-2">Id</label> <input
						type="text" id="inputId" name="id" tabindex="1"
						value="El Id introducido no pernece a ningun cliente..."
						class="form-control fw-light text-danger"
						readonly="true">
				</div>
				<script>
					setTimeout(function() {
						window.history.back();
					}, 3000);
				</script>
			</div>
			<!--------------------------- BODY --------------------------->
			<%@ include file="parts/footer.jsp"%>
</body>
</html>