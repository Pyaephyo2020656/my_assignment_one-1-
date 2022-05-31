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
   
    <h3>Add New Registration for ${openclass.id} ${openclass.teacher} ${openclass.course.id }</h3>
    
    
    
    <div class="row">
    
    		
    
       <div class="col-4">
       
       <c:url var="saveregistration" value="/registration"></c:url>
       <form action="${saveregistration }" method="post">
       
       <div class="mb-3">
       
       <label class="form-label">Class ID</label>
       <input type="text" readonly="readonly" name="open_class_id" value="${openclass.id }" />
              
       </div>
       
       <div class="mb-3">
       
       <label class="form-label">Open Class Teacher</label>
       <input type="text" readonly="readonly" name="teacher" value="${openclass.teacher}" />
              
       </div>
       
       <div class="mb-3">
       
        <label class="form-label">Student</label>
        <input type="text" name="student" placeholder="Enter Student Name" required="required" class="form-control"  autocomplete="off"/>
       </div>
       
       <div class="mb-3">
       
        <label class="form-label">Phone</label>
        <input type="tel" name="phone" placeholder="Enter Phone Number" required="required" class="form-control"  autocomplete="off"/>
       </div>
       
        
        <div class="mb-3">
       
        <label class="form-label">Email</label>
        <input type="text" name="email" placeholder="Enter Email Address" required="required" class="form-control"  autocomplete="off"/>
       </div>
       
        <div class="mb-3">
        
        <input type="submit" value="Save" class="btn btn-primary" />
        
        </div>
       
       
       
       
       
       </form>
   
       
       
       </div>
     
    </div>
    
    
     

</body>
</html>