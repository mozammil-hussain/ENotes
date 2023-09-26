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

	<div class="container-fluid p-4">
		<h2 class="text-center">View All Notes</h2>

		<div class="row">
		
		
		<c:if test="${not empty updatemsg}">
				<p class="text-success text-center">${updatemsg}</p>
				<c:remove var="updatemsg" scope="session" />
			</c:if>


			<c:if test="${not empty msg}">
				<p class="text-danger text-center">${msg}</p>
				<c:remove var="msg" scope="session" />
			</c:if>


			<c:forEach items="${list }" var="n">
				<div class="col-md-10 offset-md-1 mt-2">
					<div class="card">
						<div class="card-body">
							<div class="text-center">
								<img alt="" src="<c:url value="/resources/img/OIP.jfif"/>"
									width="100px" height="80px" />
							</div>

							<p>${n.title }</p>
							<p>${n.description}</p>
							<p>Publish Date: ${n.date}</p>

							<div class="text-center">
								<a href="editNotes?id=${n.id }" class="btn btn-primary btn-sm">Edit</a> <a
									href="deleteNotes?id=${n.id}" class="btn btn-danger btn-sm">Delete</a>
							</div>
						</div>
					</div>
				</div>


			</c:forEach>


		</div>
	</div>

</body>
</html>