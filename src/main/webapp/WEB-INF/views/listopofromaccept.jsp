<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/ocescalade.css"/>
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

	<form:form  name="form" method="POST" action = "${pageContext.request.contextPath}/detail">
	<h1>liste des topos</h1>
	<table border = "0">
		<tr>
		<input type ="hidden" name="user_id" value="${user_id}">
		<input type ="hidden" name="ientifiant" value="${identifiant}">
			<th>nom</th>
			<th>prenom</th>
			<th>dispo</th>	
			<th>textarea</th>					
		</tr>
		<c:forEach items="${ret}" var="e">
			<tr>
				<td><a href = "${pageContext.request.contextPath}/openProfilHrefView?&identifiant=${user_id}&user_id=${e.user_id}"   onclick="document.getElementById("form").submit();">${e.nom}</a></td>
				<td>${e.prenom}</td>
				<td>${e.dispo}</td>		
				<td>${e.textarea}</td>						

			</tr>
			
		</c:forEach>
	</table>
</form:form>

<form:form  name="formulaire" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openParcoursRechercheView">
<input type ="hidden" name="user_id" value="${user_id}">
<button class="button"  type="submit">recherche parcours</button>
</form:form>

<form:form  name="formulaire" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openAccueilViewFrom">
<input type ="hidden" name="user_id" value="${user_id}">
<button class="button"  type="submit">Accueil</button>
</form:form>


	<form:form name="formulaire6" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/DeconnexionView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button class="button" type="submit">Deconnexion</button>
	</form:form>
</div>
</body>
</html>