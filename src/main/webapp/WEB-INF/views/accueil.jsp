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
	<h1>accueil user et password rentre OK</h1>
	
	<table>
<tr><td><form:form  name="form" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openParcoursRechercheView">
<input type ="hidden" name="user_id" value="${user_id}">
<button type="submit">recherche parcours</button>
</form:form></td>

<td><form:form  name="form" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openProfilView">
<input type ="hidden" name="user_id" value="${user_id}">
<button type="submit">Consultation profil</button>
</form:form></td></tr>


	<tr><td><form:form  name="form" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openlistTopo">
<input type ="hidden" name="user_id" value="${user_id}">
<button type="submit">liste des topos</button>
</form:form></td>

<c:if test = "${admin eq 'AD'}">
	<td><form:form  name="form" modelAttribute="parcours" action = "${pageContext.request.contextPath}/listinscrit">
	<input type ="hidden" name="user_id" value="${user_id}">
	<button type="submit">liste des inscrits</button>
	</form:form></td>
</c:if>  

</tr>


		</table>
		

			<form:form  name="form8" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openParcoursView">
	<input type ="hidden" name="user_id" value="${user_id}">
	<button type="submit">Creation parcours</button>
	</form:form>
	
	
	
</body>
</html>