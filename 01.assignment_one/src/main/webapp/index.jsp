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
   
            
     <div class=" container mt-4">
     
        <h1>My Assignment ONE</h1>
        
        <h3>Course</h3>
     
     <div>
        <a class="btn btn-primary" href="course-edit">Add New Course</a>
     </div>
     
         <c:choose>
            <c:when test="${ empty courses}">
                 <div class="alert alert-warning">
                    There is no Course. Pleas create new Course.
                 </div>
            </c:when>
         
         
         
         <c:otherwise>
        	 <table class="table table-striped">
                   <thead>
                    <tr>
                       <th>ID</th>
                       <th>Name</th>
                       <th>Durations</th>
                        <th>Fees</th>
                       <th>Description</th>
                       <th></th>
                    </tr>                   
                   </thead>
                                  
                   <tbody>
                   	<c:forEach var="c" items="${ courses }">                    
                      <tr>
                        <td>${c.id }</td>
                        <td>${c.name }</td>
                        <td>${c.duration } Months</td>
                        <td>${c.fees }</td>
                        <td>${c.description }</td>
                        <td>
                          <c:url var="classes" value="/classes" >
                          
                           <c:param name="courseId" value="${c.id}"></c:param>
                          </c:url>
                          <a href="${classes }"> Details Classes</a> 
                        </td>
                                                                         
                      </tr>                                       
                    </c:forEach>                       
                   </tbody>
                   </table>
         </c:otherwise>
       
        </c:choose> 
     
     </div>

</body>
</html>