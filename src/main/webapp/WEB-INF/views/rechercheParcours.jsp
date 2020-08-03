<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	function check() {
		var name = document.frm.nom.value;
		var difficulte = document.frm.difficulte.value;
		var localisation = document.frm.localisation.value;
		var nbr = document.frm.taille.value;

		if (isNaN(nbr)) {
			alert("Veuillez rentrez une valeur numérique pour la taille");
			alert(name);

			//probleme arrive pas a garder le champ nom en memoire si il y a une erreur sur la taille
			document.frm.nom.value = name;
			document.frm.getElementById('nom').value = name;

			//document.getElementById("taille").innerHTML="Entrez uniquement une valeur numérique";
			document.frm.action = "${pageContext.request.contextPath}/openParcoursRechercheView";
			// document.getElementById("taille").focus();
			//document.frm.submit();
			return false;
		} else {
			document.frm.action = "${pageContext.request.contextPath}/resultatparcours";
			return true;
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Recherchez votre parcours</h1>

	<form:form modelAttribute="parcours" name="frm">
		<table>
			<tr>
				<td>Entrer le nom:</td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td>Entrer la taille:</td>
				<td><form:input path="taille" /></td>
			</tr>
			<tr>
				<td>Entrer la difficulte:</td>
				<td><select name="difficulte">
						<option value="1">facile</option>
						<option value="2">moyen</option>
						<option value="3">difficile</option>
						<input type="hidden" name="user_id" value="${user_id}">
				</select></td>
			</tr>
			<tr>
				<td>Entrer la localisation:</td>
				<td><form:input path="localisation" /></td>
			</tr>
		</table>
		<form:hidden path="parcours_id" />
		<button type="submit" onclick="javascript:check()">Recherchez</button>
	</form:form>
	<form:form name="formulaire5" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/openAccueilViewFrom">
		<input type="hidden" name="user_id" value="${user_id}">
		<button type="submit">Accueil</button>
	</form:form>
	<form:form name="formulaire6" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/DeconnexionView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button type="submit">Deconnexion</button>
	</form:form>
</body>
</html>