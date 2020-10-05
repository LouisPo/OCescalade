<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/ocescalade.css" />
<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script>
	function check() {
		var name = document.frm.nom.value;
		var difficulte = document.frm.difficulte.value;
		var localisation = document.frm.localisation.value;
		var nbr = document.frm.taille.value;

		if (isNaN(nbr)) {
			alert("Veuillez rentrez une valeur numérique pour la longueur");
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
<div class="jumbotron text-left">

	<h1>Recherchez votre site</h1>

	<form:form modelAttribute="parcours" name="frm">
		<table>
			<tr>
				<td>Entrer le nom:</td>
				<td><form:input path="nom" /></td>
			</tr>
			<tr>
				<td>Entrer la longueur:</td>
				<td><form:input path="taille" /></td>
			</tr>
			<tr>
				<td>Entrer la cotation:</td>
				<td><select name="difficulte">

						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>

						<input type="hidden" name="user_id" value="${user_id}">
				</select></td>
				<td><select name="difficultelettre">
						<option value=" "> </option>
						<option value="a">a</option>
						<option value="b">b</option>
						<option value="c">c</option>
				</select></td>
			</tr>
			<tr>
				<td>Entrer le lieu:</td>
				<td><form:input path="localisation" /></td>
			</tr>
		</table>
		<form:hidden path="parcours_id" />
		<button class="button" type="submit" onclick="javascript:check()">Recherchez</button>
	</form:form>
	<form:form name="formulaire5" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/openAccueilViewFrom">
		<input type="hidden" name="user_id" value="${user_id}">
		<button class="button" type="submit">Accueil</button>
	</form:form>
	<form:form name="formulaire6" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/DeconnexionView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button class="button" type="submit">Deconnexion</button>
	</form:form>
	</div>
</body>
</html>