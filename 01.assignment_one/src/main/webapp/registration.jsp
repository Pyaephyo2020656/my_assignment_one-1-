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

   <div class="container mt-4>">
   
     <h1>My Assignment ONE</h1>
   
    <h3>Registration for ${openclass.id} ${openclass.teacher} ${openclass.course.id } </h3>
    
    <div>
      <c:url var="addNew" value="/registration-edit">
       <c:param name="classId" value="${openclass.id}"></c:param>
      </c:url>
        <a class="btn btn-primary" href="${addNew}">Add New Registration </a>
     </div>   
     
     <c:choose>
     <c:when test="${empty registration}">
       
               <div class="alert alert-warning">
                    There is no Registration for ${ openclass.course.id}. Pleas create new registration.
                 </div>
       </c:when>
       
       <c:otherwise>
         
         <table class="table table-striped">
         
            <thead>
              <tr>
              <th>Class ID</th>
              <th>Student</th>
              <th>Phone</th>
              <th>Email</th>         
              <th>Teacher</th>                             
              </tr>           
            </thead>
            
            <tbody>
            
             <c:forEach var="c" items="${registration}">
             
               <tr>
                <td>${c.id }</td>
                <td>${c.student }</td>
                <td>${c.phone }</td>
                <td>${c.email }</td> 
                <td>${openclass.teacher }</td>
                <td></td>                
                </tr>            
             </c:forEach>
            
            
            </tbody>
         
         
         </table>
       
       
       </c:otherwise>
     
     </c:choose>
     
       
   
   </div>        

</body>
</html>