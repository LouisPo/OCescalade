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
	<h1>liste des topos</h1>
	<table border = "1">
		<tr>
		<input type ="hidden" name="user_id" value="${user_id}">
			<th>nomtopo</th>
			<th>nom</th>
			<th>prenom</th>
			<th>dispo</th>	
			<th>textarea</th>					
		</tr>
		<c:forEach items="${ret}" var="e">
			<tr>
				<td>${e.nomtopo}</td>
				<td><a href = "${pageContext.request.contextPath}/openProfilHrefView?&identifiant=${user_id}&user_id=${e.user_id}"   onclick="document.getElementById("form").submit();">${e.nom}</a></td>
				<td>${e.prenom}</td>
				<td>${e.dispo}</td>		
				<td>${e.textarea}</td>						
				<td>
					
					
				</td>
			</tr>
			
		</c:forEach>
	</table>
</form:form>

<form:form  name="formulaire" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openParcoursRechercheView">
<input type ="hidden" name="user_id" value="${user_id}">
<button type="submit">recherche parcours</button>
</form:form>
</body>
</html>