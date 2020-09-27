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
	<form:form  name="form" method="POST" action = "${pageContext.request.contextPath}/detail">
	<h1>Resultats des recherches</h1>
	<table border = "1">
		<tr>
			<th>nom</th>
			<th>longueur</th>
			<th>cotation</th>
			<th>lieu</th>			
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
		    <c:if test="${admin eq 'AD'}">
				<td><a href = "${pageContext.request.contextPath}/deleteparcours/${e.parcours_id}">Supprimer</a>
                </td>
			</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</form:form>

<form:form  name="formulaire" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openParcoursRechercheView">
<input type ="hidden" name="user_id" value="${user_id}">
<button class="button" type="submit">Recherche parcours</button>
</form:form>
<form:form  name="formulaire" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openAccueilViewFrom">
<input type ="hidden" name="user_id" value="${user_id}">
<button class="button" type="submit">Accueil</button>
</form:form>
	<form:form name="formulaire6" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/DeconnexionView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button class="button" type="submit">Deconnexion</button>
	</form:form>
</body>
</html>