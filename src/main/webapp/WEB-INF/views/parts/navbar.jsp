<nav class="navbar navbar-expand-sm navbar-dark fixed-top bg-dark">
		<div class="container-fluid">
			<div class="d-flex justify-content-start align-items-center">
				<a class="navbar-brand text-warning py-0"
					href="<%=request.getContextPath()%>"> <img
					src="${pageContext.request.contextPath}/resources/img/logoDeveloper.png"
					alt="logo" width="50" height="50">
				</a> <a class="navbar-brand text-warning py-0"
					href="<%=request.getContextPath()%>">Web CRUD</a>
			</div>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
				aria-controls="navbarCollapse" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav ms-auto me-5">
					<li class="nav-item"><a class="nav-link" id="createNavLink"
						href="<%=request.getContextPath()%>/cliente/create">CREATE</a></li>
					<li class="nav-item"><a class="nav-link" id="readNavLink"
						href="<%=request.getContextPath()%>/cliente/read/searchById">READ</a></li>
					<li class="nav-item"><a class="nav-link" id="updateNavLink"
						href="<%=request.getContextPath()%>/cliente/update/searchById">UPDATE</a></li>
					<li class="nav-item"><a class="nav-link" id="deleteNavLink"
						href="<%=request.getContextPath()%>/cliente/delete/searchById">DELETE</a></li>
				</ul>
			</div>
			<script>
				addButtonFocusClass()
			</script>
		</div>
	</nav>