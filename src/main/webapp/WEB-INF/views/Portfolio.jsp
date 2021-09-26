
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    <h1>Portfolio List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Ticker symbol</th><th>Average Buy Price</th><th>Shares</th><th>Cumulative</th></tr>  
   <c:forEach var="portfolio" items="${portfolios}">   
   <tr>  
   
   <td>${portfolio.name}</td>  
   <td>${portfolio.unitPrice}</td>  
   <td>${portfolio.share}</td>
   <td>${portfolio.cumulative}</td>  
    <td><a href="edit?id=${portfolio.portfolioId}">Edit</a></td>  
   <td><a href="delete/${portfolio.portfolioId}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="addPortfolio">Add New Portfolio</a>  
  </body>
</html>
