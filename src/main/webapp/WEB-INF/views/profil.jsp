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
	<h1>Profil</h1>
	<table border = "1">
		<tr>
			<th>nom</th>
			<th>prenom</th>
			<th>mail</th>
			<th>telephone</th>			
		</tr>
		
			<tr>
				
				<input type ="hidden" name="user_id" value="${user_id}">
				<input type ="hidden" name="identifiant" value="${identifiant}">
				<td>"${nom}"</td>
				<td>"${prenom}"</td>
				<td>"${mail}"</td>		
				<td>"${telephone}"</td>			
				
			</tr>
		
	</table>

</form:form>

       
<c:if test="${ empty nomdemandeur}">
               		<c:if test="${nomdemandeur ne ' ' }">
               
	<h1>Votre Demande en cours</h1>
	<table border = "1">
		<tr>
			<th>nom</th>
			<th>prenom</th>
			<th>mail</th>
			<th></th>			
		</tr>
		<c:if test="${nomdemandeur ne ' ' }">
			<tr>
				<td>"${nomdemandeur}"</td>
				<td>"${prenomdemandeur}"</td>
				<td>"${maildemandeur}"</td>		
				<td>   
				<form:form  name="form" action = "${pageContext.request.contextPath}/acceptPretTopo">
                 <c:if test = "${user_id ne identifiant}"><button type="submit">accepter</button></c:if> 
			     <input type ="hidden" name="user_id" value="${user_id}">
			     <input type ="hidden" name="identifiant" value="${identifiant}">
                 </form:form>
                 </td>			
				<td>   
				<form:form  name="form" action = "${pageContext.request.contextPath}/topoDispoRefuse">
                 <c:if test = "${user_id ne identifiant}"><button type="submit">Refuser</button></c:if> 
			     <input type ="hidden" name="user_id" value="${user_id}">
			     <input type ="hidden" name="identifiant" value="${identifiant}">
                 </form:form>
                 </td>
			</tr>
		</c:if>
	</table>
</c:if>
   </c:if>  



<form:form  name="formulaire" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openParcoursRechercheView">
<input type ="hidden" name="user_id" value="${user_id}">
<button type="submit">Recherche parcours</button>
</form:form>


<form:form  name="form" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openTopoView">
<input type ="hidden" name="user_id" value="${user_id}">
<input type ="hidden" name="identifiant" value="${identifiant}">
<button type="submit">Consulter le topo</button>
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