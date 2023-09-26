
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<!-- Navbar starts -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">&nbsp;&nbsp;<i class="fa-solid fa-mug-hot"></i>&nbsp;&nbsp; ENotes</a>&nbsp;
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active" 
					aria-current="page" href="${pageContext.request.contextPath}/home"><i
						class="fa-solid fa-house-crack"></i> Home</a></li>
						
						
						<c:if test="${not empty userObj }">
				<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/user/addNotes"><i class="fa-solid fa-note-sticky"></i>&nbsp;Add
						Notes</a></li>
				<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/user/viewNotes"><i class="fa-regular fa-eye"></i>&nbsp;View
						Notes</a></li>
						</c:if>

			</ul>
			<form class="d-flex">
				<c:if test="${empty userObj }">

					<a href="login" class="btn btn-outline-success" type="submit"><i class="fa-solid fa-arrow-right-to-bracket"></i>&nbsp;Login</a> &nbsp;
    			    <a href="register" class="btn btn-outline-warning" type="submit"><i class="fa-solid fa-plus"></i> Register</a>
				</c:if>
				<c:if test="${not empty userObj }">



					<a href="#" class="btn btn-outline-danger" type="submit"><i class="fa-regular fa-user"></i>&nbsp;Welcome ${userObj.fullName}</a>&nbsp;&nbsp;
    			    <a href="${pageContext.request.contextPath}/user/logout" class="btn btn-outline-warning" type="submit"><i class="fa-solid fa-arrow-right-from-bracket"></i> Logout</a>
				</c:if>
			</form>
		</div>
	</div>
</nav>
<!-- navbar Ends -->
