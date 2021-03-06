<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/ocescalade.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script></head>
<body>
<div class="jumbotron text-left">

	<form:form name="form"
		action="${pageContext.request.contextPath}/insertTopoView">
		<h1>D&eacutetail du topo</h1>

		<c:if test="${dispoperso ne 'PRETE'}">
			<table border="0">
				<tr>
					<th>Contenu du topo</th>
				</tr>
				<tr>

								<textarea name="textarea" rows="5" cols="40">${textarea}</textarea>
                                <input type="text" name="lieu" size="10" >
								<select name="choixdispo">
														<option value="OUI">Oui</option>
														<option value="REFUS">Non</option>
						

						
						<input type="hidden" name="user_id" value="${user_id}"> <input
						type="hidden" name="identifiant" value="${identifiant}">
						</select>
				</tr>
			</table>
		</c:if>
		<c:if test="${dispoperso eq 'PRETE'}">
	Le Topo a &eacutet&eacute pr&ecirct&eacute
	</c:if>
		<p>


			<c:if test="${e.nomtopo ne ''}">
			<c:if test="${not empty ret}">
			<b>Topos qui ont ete prete
				<table border="1">

					<tr>
						<th>nomtopo</th>
						<th>nom</th>
						<th>prenom</th>
						<th>dispo</th>
						<th>contenu</th>
					</tr>
					<c:forEach items="${ret}" var="e">
						<tr>
							<td>${e.nomtopo}</td>
							<td>${e.nom}</td>
							<td>${e.prenom}</td>
							<td>${e.dispo}</td>
							<td>${e.textarea}</td>
							<td></td>
						</tr>
					</c:forEach>
				</table>
				
			</c:if>	
			</c:if>
<p>


					<button type="submit">Modifier le topo</button>

	</form:form>

	<form:form name="form" action="${pageContext.request.contextPath}/openlistTopofromtopo">
		<c:if test="${user_idtopo ne user_id}">
			<c:if test="${user_id ne identifiant}">
				<c:if test="${identifiantpret != 0}">
					<button type="submit">Demande de pr&ecirct de Topo</button>
				</c:if>
			</c:if>
		</c:if>
		<input type="hidden" name="user_id" value="${user_id}">
		<input type="hidden" name="identifiant" value="${identifiant}">
	</form:form>

	<form:form name="form"
		action="${pageContext.request.contextPath}/openlistTopofromtopo">
		<c:if test="${user_id ne identifiant}">
			<c:if test="${identifiantpret == 0 && identifiant !=0}">
				<button type="submit">Demande de pret de Topo</button>
			</c:if>
		</c:if>
		<input type="hidden" name="user_id" value="${user_id}">
		<input type="hidden" name="identifiant" value="${identifiant}">
	</form:form>
	
	<form:form name="form" action="${pageContext.request.contextPath}/ajoutTopo">
		<button type="submit">Ajout de Topo</button>
		<input type="hidden" name="user_id" value="${user_id}">
		<input type="hidden" name="identifiant" value="${identifiant}">
		<input type="hidden" name="choixdispo" value="${dispoperso}">
	</form:form>

	<form:form name="form"
		action="${pageContext.request.contextPath}/insertTopoView">

		<input type="hidden" name="user_id" value="${user_id}">
		<input type="hidden" name="identifiant" value="${identifiant}">
		<input type="hidden" name="choixdispo" value="${dispoperso}">
	</form:form>

	<form:form name="formulaire2" modelAttribute="parcours"
		action="${pageContext.request.contextPath}/openParcoursRechercheView">
		<input type="hidden" name="user_id" value="${user_id}">
		<button class="button" type="submit">Recherche site</button>

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