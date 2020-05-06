<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 Welcome ${firstname}
  
   <table border = "1">
<tr>
<th>SNO</th>
<th>FIRSTNAME</th>
<th>LASTNAME</th>
<th>SSN</th>
<th>BDATE</th>
<th>ADDRESS</th>
<th>SEX</th>
<th>SALARY</th>
<th>SUPERSSN</th>
<th>EMAIL</th>
</tr>
<c:forEach var = "j" begin = "1" end = "${number}">
<tr>
<td>${j}</td>
<td>${fnames[j]}</td>
<td>${lnames[j]}</td>
<td align="center">${ssns[j]}</td>
<td align="center">${bdays[j]}</td>
<td align="center">${address[j]}</td>
<td align="center">${sex[j]}</td>
<td align="center">${salaries[j]}</td>
<td align="center">${superssns[j]}</td>
<td align="center">${emails[j]}</td>



</tr>
</c:forEach>
</table> 
 
<button onclick="window.location.href='manager.jsp' ">ADD EMPLOYEE</button>
</body>
<style>
/*	
	Side Navigation Menu V2, RWD
	===================
	License:
	https://goo.gl/EaUPrt
	===================
	Author: @PableraShow

 */

@charset "UTF-8";
@import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,700);

body {
  font-family: 'Open Sans', sans-serif;
  font-weight: 300;
  line-height: 1.42em;
  color:#A7A1AE;
  background-color:#1F2739;
}

h1 {
  font-size:3em; 
  font-weight: 300;
  line-height:1em;
  text-align: center;
  color: #4DC3FA;
}

h2 {
  font-size:1em; 
  font-weight: 300;
  text-align: center;
  display: block;
  line-height:1em;
  padding-bottom: 2em;
  color: #FB667A;
}

h2 a {
  font-weight: 700;
  text-transform: uppercase;
  color: #FB667A;
  text-decoration: none;
}

.blue { color: #185875; }
.yellow { color: #FFF842; }

 th h1 {
	  font-weight: bold;
	  font-size: 1em;
  text-align: left;
  color: #185875;
}

 td {
	  font-weight: normal;
	  font-size: 1em;
  -webkit-box-shadow: 0 2px 2px -2px #0E1119;
	   -moz-box-shadow: 0 2px 2px -2px #0E1119;
	        box-shadow: 0 2px 2px -2px #0E1119;
}

table {
	  text-align: left;
	  overflow: hidden;
	  width: 50%;
	  margin: 0 auto;
  display: table;
  padding: 0 0 8em 0;
}

 td, th {
	  padding-bottom: 2%;
	  padding-top: 2%;
  padding-left:2%;  
}

/* Background-color of the odd rows */
 tr:nth-child(odd) {
	  background-color: #323C50;
}

/* Background-color of the even rows */
 tr:nth-child(even) {
	  background-color: #2C3446;
}

 th {
	  background-color: #1F2739;
}

 td:first-child { color: #FB667A; }

 tr:hover {
   background-color: #464A52;
-webkit-box-shadow: 0 6px 6px -6px #0E1119;
	   -moz-box-shadow: 0 6px 6px -6px #0E1119;
	        box-shadow: 0 6px 6px -6px #0E1119;
}

 td:hover {
  background-color: #FFF842;
  color: #403E10;
  font-weight: bold;
  
  box-shadow: #7F7C21 -1px 1px, #7F7C21 -2px 2px, #7F7C21 -3px 3px, #7F7C21 -4px 4px, #7F7C21 -5px 5px, #7F7C21 -6px 6px;
  transform: translate3d(6px, -6px, 0);
  
  transition-delay: 0s;
	  transition-duration: 0.4s;
	  transition-property: all;
  transition-timing-function: line;
}

@media (max-width: 800px) {
 td:nth-child(4),
 th:nth-child(4) { display: none; }
}

</style>

</html>