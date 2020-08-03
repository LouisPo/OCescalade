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
	<form:form  name="form" method="POST" action = "${pageContext.request.contextPath}/detail">
	<h1>resultat des recherche</h1>
	<table border = "1">
		<tr>
			<th>nom</th>
			<th>taille</th>
			<th>difficulte</th>
			<th>localisation</th>			
		</tr>
		<c:forEach items="${list}" var="e">
			<tr>
				<td><a href = "${pageContext.request.contextPath}/detail?parcoursidentifiant=${e.parcours_id}&user_id=${user_id}&nom=${e.nom}&taille=${e.taille}&difficulte=${e.difficulte}&localisation=${e.localisation}"   onclick="document.getElementById("form").submit();">${e.nom}</a></td>
				
				<input type ="hidden" name="user_id" value="${user_id}">
				<input type ="hidden" name="parcoursidentifiant" value="${e.parcours_id}">
				<td>${e.taille}</td>
				<td>${e.difficulte}</td>
				<td>${e.localisation}</td>				
				<td>
					
					<a href = "${pageContext.request.contextPath}/deleteparcours/${e.parcours_id}">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</form:form>

<form:form  name="formulaire" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openParcoursRechercheView">
<input type ="hidden" name="user_id" value="${user_id}">
<button type="submit">recherche parcours</button>
</form:form>
<form:form  name="formulaire" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openAccueilViewFrom">
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