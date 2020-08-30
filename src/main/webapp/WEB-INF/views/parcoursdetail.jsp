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
<link rel="stylesheet" type="text/css" href="/css/ocescalade.css"/>
<title>Insert title here</title>
</head>
<body>

	<form:form name="form" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/ajoutCommentView">
		<h1>D&eacutetail du parcours</h1>
		
			Parcours actuel
	<p>
		
		
		<table border="1">
			<tr>
				<th>nom</th>
				<th>longueur</th>
				<th>cotation</th>
				<th>lieu</th>

			</tr>

			<tr>
				<td>${nom}</td>
				<td>${taille}</td>
				<td>${difficulte}</td>
				<td>${localisation}</td>

			</tr>



			<input type="hidden" name="nom" value="${nom}">
			<input type="hidden" name="taille" value="${taille}">
			<input type="hidden" name="difficulte" value="${difficulte}">
			<input type="hidden" name="localisation" value="${localisation}">
			<input type="hidden" name="parcoursidentifiant" value="${parcoursidentifiant}">
			<input type="hidden" name="user_id" value="${user_id}">
		</table>
		
		<p>
		
		
		<table border="1">
			<tr>
				<th>Votre commentaire</th>
			</tr>
			<tr>
				<th><textarea name="textarea" rows="5" cols="33">${textarea}</textarea></th>
                <input type="hidden" name="textareaNomodif" value="">
	
		
			</tr>
		</table>
		
		<button
			onclick="window.location.href='${pageContext.request.contextPath}/ajoutCommentView'">envoyer
			commentaire</button>
		</form:form>
		
		
		<p>
		Commentaires autres utilisateurs
		<p>
		
		<table border="1">
		<tr>
			<th>Date</th>
			<th>Commentateur</th>
			<th>Commentaires</th>
			

		</tr>
		<c:forEach items="${list}" var="e">
			<tr>
				<td>${e.date}</td>
				<td>${e.identite}</td>
				<form:form name="formulaire45" modelAttribute="parcours" action="${pageContext.request.contextPath}/modifiezcomment">
				<td>
				   <c:if test="${fn:substring(prenom, 0, 2) ne 'AD'}">
						<textarea name="textarea" readonly="readonly" rows="5" cols="33">${e.textarea}</textarea>
				   </c:if>	
				   
				   <c:if test="${fn:substring(prenom, 0, 2) eq 'AD'}">
						<textarea name="textarea"  rows="5" cols="33">${e.textarea}</textarea>
				   </c:if>		
				   	
				</td>
		
				<td>
		              <input type="hidden" name="identifiantusermodif" value="${e.user}">
		              <input type="hidden" name="user_id" value="${user_id}">
						<input type="hidden" name="nom" value="${nom}">
						<input type="hidden" name="taille" value="${taille}">
						<input type="hidden" name="difficulte" value="${difficulte}">
						<input type="hidden" name="localisation" value="${localisation}">
						<input type="hidden" name="parcoursidentifiant" value="${parcoursidentifiant}">
                      <c:if test="${fn:substring(prenom, 0, 2) eq 'AD'}">
		                  <button type="submit">Modifiez le </button>
		               </c:if>		
	                 </form:form>
	             </td>
				<td></td>

			</tr>
		</c:forEach>
	</table>
		
	<p>
<p>
	<c:if test = "${passage eq ''}">		

			<form:form name="formulaire6" modelAttribute="parcours"
			action="${pageContext.request.contextPath}/ValiderView">
			<input type="hidden" name="user_id" value="${user_id}">
			<input type="hidden" name="vue" value="${passage}">	
			<input type="hidden" name="nom" value="${nom}">
			<input type="hidden" name="taille" value="${taille}">
			<input type="hidden" name="difficulte" value="${difficulte}">
			<input type="hidden" name="localisation" value="${localisation}">
			<input type="hidden" name="parcoursidentifiant" value="${parcoursidentifiant}">
			<input type="hidden" name="user_id" value="${user_id}">	
			<button class="button"  type="submit">Valider parcours</button>
		</form:form>
     </c:if>

	<form:form name="formulaire2" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/openParcoursRechercheView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button class="button"  type="submit">Recherche parcours</button>
	</form:form>
	<form:form name="formulaire5" modelAttribute="parcours"
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