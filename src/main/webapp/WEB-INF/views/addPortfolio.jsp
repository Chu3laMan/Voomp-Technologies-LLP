<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Add new Portfolio</h3>
    <hr />
    <form:form method="POST" modelAttribute="newPortfolio">
    <div>
    <label>Ticker Symbol</label>
    <form:input path="name" />
    </div>
    
    <div>
    <label>Price</label>
    <form:input path="unitPrice" />
    </div>
    
    <div>
    <label>Share</label>
    <form:input path="share" />
    </div>
    <button>Add</button>
    </form:form>
    
    

</body>
</html>