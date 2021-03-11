<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<style>

.myclass 
	{
	 padding: 5px 15px; 
  text-align: center;
  cursor: pointer;
  outline: none;
  color: black;
  border: none;
  border-radius: 10px;
  
	
	}
 .myclass: hover {background-color: green}
.button {
  background-color: #008CBA;
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius: 4px;
}
.buttonC {
  border: none;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius: 4px;
}
.myclass: active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px); 
  }

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

    label {
        display: inline-block;
        width: 200px;
        margin: 5px;
        text-align: left;
    }
    input[type=text], select {
        width: 200px;  
    }
    
    input[type=checkbox] {
        display: inline-block;
        margin-right: 190px;
    }  
     
    button {
        padding: 10px;
        margin: 10px;
    }
    .error{
    color: #cc0033;
    display: inline-block;
    font-size: 12px;
    line-height: 15px;
    }
</style>
<h2 align="center"><font style="FONT-FAMILY:Algerian;">Employee Management Portal</font></h2>
<hr size=2px ></hr>

</head>

<body>
<h3 align="center"><font style="FONT-FAMILY:Algerian;">Add/Edit Employee</font></h3>
<div>
			
        <form:form action="saveEmployee" method="post" modelAttribute="employee">
        	
            <form:label path="first_name">Firstname :</form:label>
            <form:input path="first_name"/>
            <form:errors path="first_name" cssClass="error"/>
            
            <form:label path="last_name">Lastname :</form:label>
            <form:input path="last_name"/>
            <form:errors path="last_name" cssClass="error"/>
            <br/><br/>
 			
 			
            <form:label path="dob">Date of Birth :</form:label>
            <form:input path="dob"/>
            <form:errors path="dob" cssClass="error"/>
            
            <form:label path="gender">Gender :</form:label>
             <form:select path="gender">
             	<form:option value="">Select</form:option>
             	<form:option value="M">Male</form:option>
             	<form:option value="F">Female</form:option>
             	<form:option value="ND">ND</form:option>
             </form:select>
             <form:errors path="gender" cssClass="error"/>
             <br><br/>
            
            <form:label path="mobile_num">Mobile Number :</form:label>
            <form:input path="mobile_num"/>
            <form:errors path="mobile_num" cssClass="error"/>
             
            <form:label path="email_id">Email(personal) :</form:label>
            <form:input path="email_id"/>
            <form:errors path="email_id" cssClass="error"/><br/><br/>
            
            <form:label path="office_mail">Office mail(*) :</form:label>
            <form:input path="office_mail"/>
            <form:errors path="office_mail" cssClass="error"/><br>

             
            <form:label path="doj">Date of Joining :</form:label>
            <form:input path="doj"/>
            <form:errors path="doj" cssClass="error"/>
                     
            <form:label path="emp_level">Employee Level :</form:label>
			<form:select path="emp_level">
             	<form:option value="">Select</form:option>
             	<form:option value="7">7</form:option>
             	<form:option value="8">8</form:option>
             	<form:option value="9">9</form:option>
             	<form:option value="10">10</form:option>
             	<form:option value="11">11</form:option>
             	<form:option value="12">12</form:option>
             	<form:option value="13">13</form:option>
             </form:select>            
             <form:errors path="emp_level" cssClass="error"/><br/><br/>
            
            <form:label path="post_name">Employee Post :</form:label>
            <form:input path="post_name"/>
            <form:errors path="post_name" cssClass="error"/>
            
            <form:label path="blood_group">Blood group :</form:label>
            <form:select path="blood_group">
             	<form:option value="">Select</form:option>
             	<form:option value="A+ve">A+ve</form:option>
             	<form:option value="A-ve">A-ve</form:option>
             	<form:option value="B+ve">B+ve</form:option>
             	<form:option value="B-ve">B-ve</form:option>
             	<form:option value="AB+ve">AB+ve</form:option>
             	<form:option value="AB-ve">AB-ve</form:option>
             	<form:option value="O+ve">O+ve</form:option>
             	<form:option value="O-ve">O-ve</form:option>
             	<form:option value="Unknown">Unknown</form:option>
             </form:select>
             <form:errors path="blood_group" cssClass="error"/>
             <br/><br/>
            
            <form:label path="basic_pay">Basic pay :</form:label>
            <form:input path="basic_pay"/>
            <form:errors path="basic_pay" cssClass="error"/>
            
            <form:label path="house_allowance">House allowances :</form:label>
            <form:input path="house_allowance"/>
            <form:errors path="house_allowance" cssClass="error"/><br/><br/>
            
            <form:label path="pan_num">Pancard no :</form:label>
            <form:input path="pan_num"/>
            <form:errors path="pan_num" cssClass="error"/>
            
            <form:label path="adhar_num">Adharcard no :</form:label>
            <form:input path="adhar_num"/>
            <form:errors path="adhar_num" cssClass="error"/><br/><br/>
             
            <form:label path="permanent_address">Permanent Address :</form:label>
            <form:textarea path="permanent_address" cols="25" rows="5"/>
            <form:errors path="permanent_address" cssClass="error"/>
            
            <form:label path="present_address">Present Address :</form:label>
            <form:textarea path="present_address" cols="25" rows="5"/><br/><br/>
            <form:errors path="present_address" cssClass="error"/>     
            <div align="center"><form:button type="submit" name="save" class="button">Submit</form:button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <form:button type="submit" name="cancel" class="buttonC" >Cancle</form:button></div>
        </form:form>
</div> 
</body>
</html>