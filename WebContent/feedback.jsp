<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;
}
legend { 
  display: block;
  padding-left: 2px;
  padding-right: 2px;
  border: none;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <center><bold><h1 style = "color : red;">Welcome on Board Mr. ${firstname} ${lastname}!</h1></bold></center>
 <center>
<fieldset>
<legend>Employee Details:</legend>
<table style="width:50%">
  <tr>
    <th>First Name : </th>
   	<td>${firstname}</td>
  </tr>
  <tr>
    <th>Last Name : </th>
    <td>${lastname}</td>
  </tr>
  <tr>
    <th>SSN : </th>
    <td>${ssn} </td>
  </tr>
  <tr>
    <th>D.O.B : </th>
    <td>${dob} </td>
  </tr>
  <tr>
    <th>Address : </th>
    <td>${address} </td>
  </tr>
  <tr>
    <th>Gender : </th>
    <td>${sex} </td>
  </tr>
  <tr>
    <th>Salary : </th>
    <td>$ ${salary} </td>
  </tr>
  <tr>
    <th>Supervisor SSN : </th>
    <td>${superssn} </td>
  </tr>
  <tr>
    <th>email : </th>
    <td>${email} </td>
  </tr>
  
</table></fieldset></center>


<c:if test = "${checkboxvalue != null}">
 <center>
<fieldset>
<legend>Dependent Details:</legend>
<table style="width:50%">
  <tr>
    <th>Dependent Name:</th>
    <td>${dependentname}</td>
  </tr>
  <tr>
    <th>Dependent Gender:</th>
    <td>${dependentgender}</td>
  </tr>
  <tr>
    <th>Dependent D.O.B:</th>
    <td>${dependentdob}</td>
  </tr>
  <tr>
    <th>Dependent Relation :</th>
    <td>${dependentrelation} </td>
  </tr>
</table></fieldset></center>
</c:if>





 <center>
<fieldset>
<legend>Project Details:</legend>


<table style="width:50%">
  <tr>
    <th>Project Number</th>
    <th>Hours Worked</th>
    
  </tr>
  <tr>
    <td>${project1}</td>
    <td>${hours1}</td>
  </tr>
  <tr>
    <td>${project2}</td>
    <td>${hours2}</td>
  </tr>
  <tr>
    <td>${project3}</td>
    <td>${hours3}</td>
  </tr>
</table>


</fieldset></center>
 
<button onclick="window.location.href='manager.jsp' ">ADD EMPLOYEE</button>
</body>
</html>