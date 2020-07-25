<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function check() {

		alert("toto");
		document.getElementById("form").action = "${pageContext.request.contextPath}/ajoutCommentView";
		//document.getElementById("myForm").action = "/action_page.php";
		//document.frm.action="${pageContext.request.contextPath}/openParcoursRechercheView";
		document.getElementById("form").submit();
		return true;
	}
	function seek() {
		alert("titi");

		document.getElementById("form").action = "${pageContext.request.contextPath}/ajoutCommentView";
		document.getElementById("form").submit();

		return true;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form name="form" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/ajoutCommentView">
		<h1>Detail du parcours</h1>
		<table border="0">
			<tr>
				<th>laissez votre commentaire</th>
				<th>Commentaires autres utilisateurs</th>
			</tr>
			<tr>
				<th><textarea name="textarea" rows="5" cols="33">${textarea}</textarea></th>
				<th>
				   <c:if test="${fn:substring(prenom, 0, 2) ne 'AD'}">
						<textarea name="textareaNomodif" readonly="readonly" rows="15" cols="33">${textareaNomodif}</textarea>
				   </c:if>	
				   
				   <c:if test="${fn:substring(prenom, 0, 2) eq 'AD'}">
						<textarea name="textareaNomodif"  rows="15" cols="33">${textareaNomodif}</textarea>
				   </c:if>		
				   	
				</th>
			</tr>
		</table>
		<table border="1">
			<tr>
				<th>nom</th>
				<th>taille</th>
				<th>difficulte</th>
				<th>localisation</th>

			</tr>

			<tr>
				<td>${nom}</td>
				<td>${taille}</td>
				<td>${difficulte}</td>
				<td>${localisation}</td>

				<td><a
					href="${pageContext.request.contextPath}/deleteparcours/${parcours.parcours_id}">Supprimer</a>
				</td>
			</tr>



			<input type="hidden" name="nom" value="${nom}">
			<input type="hidden" name="taille" value="${taille}">
			<input type="hidden" name="difficulte" value="${difficulte}">
			<input type="hidden" name="localisation" value="${localisation}">
			<input type="hidden" name="parcoursidentifiant"
				value="${parcoursidentifiant}">
			<input type="hidden" name="user_id" value="${user_id}">
		</table>


		<button
			onclick="window.location.href='${pageContext.request.contextPath}/ajoutCommentView'">envoyer
			commentaire</button>

	</form:form>



	<form:form name="formulaire2" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/openParcoursRechercheView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button type="submit">recherche parcours</button>
	</form:form>
	<form:form name="formulaire5" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/openAccueilViewFrom">
		<input type="hidden" name="user_id" value="${user_id}">
		<button type="submit">Accueil</button>
	</form:form>
</body>
</html>