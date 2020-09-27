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
	<h1>Cr&eacuteez votre compte</h1>
	<form:form action="${pageContext.request.contextPath}/save"
		modelAttribute="employee">
		<table>
			<tr>
				<td>Entrer le nom:</td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td>Entrer le prenom:</td>
				<td><form:input path="prenom" /></td>
			</tr>
			<tr>
				<td>Entrer le mail:</td>
				<td><form:input path="mail" /></td>
			</tr>
			<tr>
				<td>Entrer le telephone:</td>
				<td><form:input path="tel" /></td>
			</tr>
			<tr>
				<td>Entrer le mot de passe:</td>
				<td><form:input path="mdp" /></td>
			</tr>
		</table>
		<input type ="hidden" name="user_id" value="${user_id}">
		<button class="button"  type="submit">Enregistrer</button>
	</form:form>
	<form:form  name="formulaire" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openAccueilViewFrom">
<input type ="hidden" name="user_id" value="${user_id}">
<button class="button"  type="submit">Accueil</button>
</form:form>
	<form:form name="formulaire6" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/DeconnexionView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button class="button"  type="submit">Deconnexion</button>
	</form:form>
</body>
</html>