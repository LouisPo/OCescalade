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
	
	<h1>Liste des parcours</h1>
	<table border = "1">
		<tr>
			<th>nom</th>
			<th>taille</th>
			<th>difficulte</th>
			<th>localisation</th>
			
		</tr>
		<c:forEach items="${list}" var="e">
			<tr>
				<td>${e.nom}</td>
				<td>${e.taille}</td>
				<td>${e.difficulte}</td>
				<td>${e.localisation}</td>				
				<td>
					
					<a href = "${pageContext.request.contextPath}/deleteparcours/${e.parcours_id}">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="window.location.href='${pageContext.request.contextPath}/openParcoursView'">Ajouter parcours</button>
	<button onclick="window.location.href='${pageContext.request.contextPath}/openParcoursRechercheView'">recherche parcours</button>
<form:form  name="formulaire5" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openAccueilViewFrom">
<input type ="hidden" name="user_id" value="${user_id}">
<button type="submit">Accueil</button>
</form:form>
	<form:form name="formulaire6" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/DeconnexionView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button type="submit">Deconnexion</button>
	</form:form>
</body>
</html>