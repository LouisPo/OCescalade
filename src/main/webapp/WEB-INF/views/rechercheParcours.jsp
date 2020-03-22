
	

	
	
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
	<h1>Recherchez votre parcours</h1>
	<form:form action = "${pageContext.request.contextPath}/resultatparcours" modelAttribute="parcours">
	<table>
	<tr><td>	Entrer le nom:    </td><td><form:input path="nom"/></td></tr>
	<tr><td>	Entrer la taille: </td><td><form:input path="taille"/></td></tr>
	<tr><td>	Entrer la difficulte: </td><td>
	<select name="difficulte">
	<option value="1">facile</option>
	<option value="2">moyen</option>
	<option value="3">difficile</option>
	
	</select></td></tr>
	<tr><td>	Entrer la localisation: </td><td><form:input path="localisation"/></td></tr>
		</table>
		<form:hidden path = "parcours_id"/>
		<button type = "submit">Recherchez</button></form:form>
</body>
</html>