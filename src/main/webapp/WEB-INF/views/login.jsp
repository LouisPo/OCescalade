<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <link rel="stylesheet" href="/css/ocesc.css" />
    

     
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>page d'index</title>
</head>
<body>


<h1>1. Test CSS</h1>




	<h1>login</h1>
	<table border="0">
	<tr><td></td><td></td></tr>
	<tr><td></td><td></td></tr>
	<tr><td></td><td>
	</td></tr>
	<tr><td></td><td></td></tr>
		</table>
	<button onclick="window.location.href='${pageContext.request.contextPath}/openConnexionView'">Connexion</button>
	<button onclick="window.location.href='${pageContext.request.contextPath}/openEmployeeView'">Inscription</button>
</body>
</html>