<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/WEB-INF/resources/component/all_css.jsp"%>

</head>
<body style="background-color: #f0f0f0">
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>


	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header text-center">
						<h1>Login Page</h1>
						<c:if test="${not empty msg}">
							<p class="text-danger">${msg}</p>
							<c:remove var="msg" scope="session" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="loginUser" method="post">
							<div class="mb-3">
								<label>Enter Email</label> <input type="text" name="email"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Enter Password</label> <input type="text" name="password"
									class="form-control">
							</div>

							<button class="btn btn-primary col-md-12">Register</button>
						</form>
					</div>

					<div class="card-footer text-center">
						don't have an account <a href="register"
							class="text-decoration-none">register</a>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>