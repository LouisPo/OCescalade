<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/ocescalade.css"/>
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des inscrits</h1>
	
	<table border="1">
		<tr>
			<!--  	<th>user_id</th>-->
			<th>nom</th>
			<th>prenom</th>
			<th>mail</th>
			<th>tel</th>
			<th>mdp</th>

		</tr>
		<c:forEach items="${list}" var="e">
			<tr>
				<!-- <td>${e.user_id}</td>-->
				<td>${e.nom}</td>
				<td>${e.prenom}</td>
				<td>${e.mail}</td>
				<td>${e.tel}</td>
				<td>${e.mdp}</td>
				

				
				<td>
				<c:if test = "${fn:substring(e.prenom, 0, 2) ne 'AD'}">
				   <a href = "${pageContext.request.contextPath}/becomAdmin?&identifiant=${e.user_id}&user_id=${user_id}"   onclick="document.getElementById("form").submit();">nommer administrateur</a>
				</c:if> 
				</td>
				
				</td>
				<td><a href="${pageContext.request.contextPath}/delete/${e.user_id}">Supprimer</a></td>

			</tr>
		</c:forEach>
	</table>
	
	
	<form:form name="formulaire12" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/ListParcours">
		<input type="hidden" name="user_id" value="${user_id}">
<button class="button" 
		onclick="window.location.href='${pageContext.request.contextPath}/ListParcours'">liste
		des parcours</button>	</form:form>

		
	
	<form:form name="formulaire" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/openAccueilViewFrom">
		<input type="hidden" name="user_id" value="${user_id}">
		<button class="button"  type="submit">Accueil</button>
	</form:form>
		<form:form name="formulaire6" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/DeconnexionView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button class="button"  type="submit">Deconnexion</button>
	</form:form>

</body>
</html>