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
   
    <h3>Add New Course</h3>
    
    <div class="row">
    
       <div class="col-4">
       <c:url var="save" value="/courses"></c:url>
      <form action="${save}" method="post">
      
        <div class="mb-3" >
           <label  class="form-label">Name</label>
           <input type="text"  name="name" placeholder="Enter Course Name" required="required" class="form-control" />
          
        </div>
        
         <div class="mb-3" >
           <label  class="form-label">Duration</label>
           <input type="number" name="duration" placeholder="Enter Course Duration" required="required" class="form-control" />
          
        </div>
        
         <div  class="mb-3">
           <label  class="form-label">Fees</label>
           <input type="number" name="fees" placeholder="Enter Course Fees" required="required" class="form-control" />
          
        </div>
      
      	 <div  class="mb-3">
           <label  class="form-label">Description</label>
            <textarea rows="4" name="description" cols="40" class="form-control"></textarea>          
        </div>
        
        <input type="submit" value="Save Course" class="btn btn-primary" />
      
      
      </form>
       
       
       </div>
     
    </div>
    
    
     

</body>
</html>