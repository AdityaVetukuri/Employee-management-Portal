<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body
{
background-image : url('image.jpg');
height : 100%;

}
.button {     
    background-color: Transparent;
    background-repeat:no-repeat;
    border: none;
    cursor:pointer;
    overflow: hidden;        
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="manager.css">
</head>

<body>
<div class="container">

<center><button onclick="window.location.href='reportServlet' ">Employee Table</button></center>
<center><H1>Welcome ${managerfname} ${managerlname}!</H1></center>
<form name="employeeForm" method="post" action="employeeServlet">
  <fieldset>
   <legend>Employee Information</legend>
   <div class="row">
   <div class="col-md-6"> First Name :</div><div class="col-md-6"><input type = "text" name = "firstname"></div> <br>
   <div class="col-md-6">Middle Initial :</div><div class="col-md-6"> <input type = "text" name = "middleinitial"></div><br>
   <div class="col-md-6">Last Name : </div><div class="col-md-6"> <input type = "text" name = "lastname"></div><br>
   <div class="col-md-6">Social Security number : </div><div class="col-md-6"> <input type = "text" name ="ssn"></div><br>
   <div class="col-md-6">Date of Birth : </div><div class="col-md-6"> <input type = "date" name = "dob"></div><br>
   <div class="col-md-6">Address : </div><div class="col-md-6"> <input type ="text" name = "address"></div> <br>
   <div class="col-md-6">Gender : </div><div class="col-md-6"> <input type = "text" name = "gender"> </div><br>
   <div class="col-md-6">Salary : </div><div class="col-md-6"> <input type = "number" name = "salary"></div><br>
   <div class="col-md-6">Supervisor SSN : </div><div class="col-md-6"> <input type = "text" name = "superssn"></div><br>
   <div class="col-md-6">Department number :</div><div class="col-md-6">  <input type = "number" name = "departmentnumber"></div><br>
   <div class="col-md-6">Email : </div><div class="col-md-6"> <input type = "email" name = "email"></div><br>
   
   <div class="col-md-6">Dependent : </div> <div class="col-md-6"><input type="checkbox" name = "dependent" id="myCheck" onclick="myFunction()"></div>
</fieldset>
<p id="text" style="display:none">
	Dependent Information <br>
	
 	Name : <input type = "text" name = "depname"><br>
 	Gender : <input type = "text" name ="depgender"><br>
 	Date of Birth : <input type = "text" name = "depdob"><br>
 	Relationship : <input type = "text" name = "deprelation"><br>
 	
   
</p>
  
  
   
   
   
   
   Project Information<div>
   Project 1 Number : <input type = "number" name = "project1">Assigned Hours : <input type = "number" name ="hours1"><br>
   Project 2 Number : <input type = "number" name = "project2">Assigned Hours : <input type = "number" name = "hours2"><br>
  
   Project 3 Number : <input type = "number" name = "project3">Assigned Hours : <input type = "number" name = "hours3"><br>
   </div>
   
   
   
   <p id="insertinputs"></p>
    
   <input type="submit" value="Login">   
   
  </div>
  </div>
</form>


<script>
function myFunction() {
	  // Get the checkbox
	  var checkBox = document.getElementById("myCheck");
	  // Get the output text
	  var text = document.getElementById("text");

	  // If the checkbox is checked, display the output text
	  if (checkBox.checked == true){
	    text.style.display = "block";
	  } else {
	    text.style.display = "none";
	  }
	}
</script>
</body>
</html>

