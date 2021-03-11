<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Calendar" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
<style>
.myclass {
	padding: 5px 15px;
	text-align: center;
	cursor: pointer;
	outline: none;
	color: black;
	border: none;
	border-radius: 10px;
}

.myclass: hover {
	background-color: green
}

.myclass: active {
	background-color: #3e8e41;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}

table, th {
	border: 1px solid black;
	border-collapse: collapse;
	width: 100%;
}

td {
	text-align: center;
}

img {
	border-radius: 50%;
}
</style>
</head>

<body>
	<h1 align="center">
		<font style="FONT-FAMILY: Algerian;">Employee Management Portal</font>
	</h1>
	<hr size=2px></hr>
	<h3 align="center">
		<font style="FONT-FAMILY: Algerian;">Employee History Screen</font>
	</h3>

	<div>
		<b>
			<h3>${employee.first_name} ${employee.last_name } (<font color="red"> #${employee.emp_id}</font>)</h3>
			<table border="2">
				<tr style="background:lightgray;">
					<td>Organization</td>
					<td>Period</td>
					<td>Location</td>
					<td>Post</td>
				</tr>
				<c:if test="${not empty employeeHistory}">
					<c:forEach var="history" items="${employeeHistory}">
					<tr>
						<td> ${history.organization_name}</td>
						<td> <fmt:formatDate value="${history.from_date}" pattern="MM/YYYY" /> ~ 
						<fmt:formatDate value="${history.until_date}" pattern="MM/YYYY" />
						</td>
						<td>${history.location}(${history.country})
						</td>
						<td>${history.post}</td>
					</tr>
				</c:forEach>
				</c:if>
				
			</table>
			
			<c:if test="${empty employeeHistory}">
					<p align="center">
						Sorry, No employment history found!!
						
					</p>
				</c:if>
			<a href="${pageContext.request.contextPath }/index"> Back to List</a>
		</b>
	</div>
</body>
</html>