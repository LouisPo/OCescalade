<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/ocescalade.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-left">

	<h1>Rentrez votre identifiant et votre mot de passe </h1>
	<h1><c:out value="${message}" /></h1>
	</div>
	
	
	
	<div class="container">
	<div class="row">
	<div class="col-sm-4">
	
	<form:form action = "${pageContext.request.contextPath}/resultatconnexion" modelAttribute="employee">
	<table>
	<tr><td>	Entrer l' identifiant:    </td><td><form:input path="nom"/></td></tr>
	<tr><td>	Entrer le mot de passe: </td><td><form:input path="mdp" type="password"/></td></tr>
		</table>
		<button class="button" type = "submit">Connexion</button>
	</form:form>
	</div>
	</div>
	</div>
</body>
</html>