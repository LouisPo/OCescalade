<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Rentrez votre identifiant et votre mot de passe </h1>
	<h1><c:out value="${message}" /></h1>
	<form:form action = "${pageContext.request.contextPath}/resultatconnexion" modelAttribute="employee">
	<table>
	<tr><td>	Entrer l' identifiant:    </td><td><form:input path="nom"/></td></tr>
	<tr><td>	Entrer le mot de passe: </td><td><form:input path="mdp"/></td></tr>
		</table>
		<button type = "submit">Connexion</button>
	</form:form>
</body>
</html>