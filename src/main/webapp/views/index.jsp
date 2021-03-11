<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<style>

table, th
{
    border: 1px solid black;
    border-collapse: collapse;
    width:100%;
}

td 
{
    text-align: center;
}

img{
	border-radius: 50%;
}

</style>
</head>

<body> 
<h2 align="center"><font style="FONT-FAMILY:Algerian;">Employee Management Portal</font></h2>
<hr size=2px ></hr>
<h3 align="center"><font style="FONT-FAMILY:Algerian;">Employee Search List Screen</font></h3>
<div>
	<form action="search">
		Employee Id : <input type="text" name="emp_id">&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
		Employee Name : <input type="text" name="emp_name">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Gender : <select name="emp_gender">
             	<option value="">Select</option>
             	<option value="M">Male</option>
             	<option value="F">Female</option>
             	<option value="ND">ND</option>
             	</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Search" name="search">
	</form>
</div><br><br>

<form action="addEmployee">
<input type="submit" value="AddEmployee">
</form>
<div align="right">
<form action="downloadCSV" method="post">
	<input type="submit" value="Downlaod CSV">
</form>
</div>
	<br>

	<c:if test="${not empty responseMessage}">
		<p align="center"><font color="green">${responseMessage}</font></p>
	</c:if>
	
	<c:if test="${not empty deleteResponse}">
		<p align="center"><font color="green">${deleteResponse }</font></p>
	</c:if>


	<div>
		<b>
			<table border="2">
				<tr>
					<td>Employee</td>
					<td>Contact</td>
					<td>Level & Post</td>
					<td>Action</td>
				</tr>

				<c:if test="${not empty updateResponse}">
					<p align="center">
						<font color="green">${updateResponse }</font>
					</p>
				</c:if>
				<c:if test="${not empty employees}">
					<c:forEach var="employee" items="${employees}">
					<tr>
						<td><img src="${employee.profile_pict }" /> <br>
						<font color="blue">${employee.first_name}
								${employee.last_name}</font><br>
						<font color="red"> #${employee.emp_id}</font></td>
						<td>${employee.mobile_num}<br> ${employee.office_mail}
						</td>
						<td>${employee.emp_level}/ <br> ${employee.post_name}
						</td>
						<td><a href="${pageContext.request.contextPath }/employee-history/${employee.emp_id }">Employments</a> / <a
							href="${pageContext.request.contextPath }/employee/${employee.emp_id }">Edit</a> / <a
							href="${pageContext.request.contextPath }/delete/${employee.emp_id }"
							onclick="return confirm('Are you sure you want to delete?')">Delete</a>
						</td>
					</tr>
				</c:forEach>
				</c:if>
				
			</table>
			<c:if test="${empty employees}">
					<p align="center">
						Sorry, employee record could not be found!!
					</p>
			</c:if>
		</b>
	</div>
</body>
</html>