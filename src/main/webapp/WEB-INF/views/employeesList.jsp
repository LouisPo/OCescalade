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
	<h1>Liste des inscrits</h1>
	<table border = "1">
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
			<!--  <a href = "${pageContext.request.contextPath}/employee/${e.user_id}">Ajouter</a>-->
					
					<a href = "${pageContext.request.contextPath}/delete/${e.user_id}">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="window.location.href='${pageContext.request.contextPath}/openEmployeeView'">Ajouter utilisateur</button>
	<button onclick="window.location.href='${pageContext.request.contextPath}/openParcoursView'">liste des parcours</button>
	

</body>
</html>