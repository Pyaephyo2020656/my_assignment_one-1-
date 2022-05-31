<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IOC Container</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
   <h1>Hello IOC Container</h1>
   
    <h3>Add New Class for ${course.name}</h3>
    
    <div class="row">
    
       <div class="col-4">
       
       <c:url var="saveclass" value="/classes"></c:url>
       <form action="${saveclass }" method="post">
       
       <div class="mb-3">  
       <label class="form-label">Course ID</label>
       <input type="text" readonly="readonly" name="course_id" value="${course.id }" />              
       </div>
       
       <div class="mb-3">
       
       <label class="form-label">Course Name</label>
       <input type="text" readonly="readonly" name="course_name" value="${course.name }" />
              
       </div>
       
       <div class="mb-3">       
        <label class="form-label">Start Date</label>
        <input type="Date" name="start_date" placeholder="Enter Start Date" required="required" class="form-control"  autocomplete="off"/>
       </div>
       
       <div class="mb-3">       
        <label class="form-label">Teacher</label>
        <input type="text" name="teacher" placeholder="Enter Teacher Name" required="required" class="form-control"  autocomplete="off"/>
       </div>
       
        <div class="mb-3">        
        <input type="submit" value="Save" class="btn btn-primary" />        
        </div>      
       </form>      
       </div>    
    </div>         
</body>
</html>