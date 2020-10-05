<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<link rel="stylesheet" type="text/css" href="/css/ocescalade.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>page d'index</title>
<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-left">
      
<table border="0">
		<tr><td><h1><a href="#">Accueil</a></h1></td>
		<td width=80%></td>
			<td>
				<button class="button"
					onclick="window.location.href='${pageContext.request.contextPath}/openConnexionView'">Connexion</button>
			</td>
			<td><form:form name="form"
					action="${pageContext.request.contextPath}/openEmployeeView">
					<input type="hidden" name="user_id" value="">

					<button class="button" type="submit">inscription</button>

				</form:form></td>
		</tr>
<tr><td></td><td>Pour les non-initi&eacute;s, voici quelques &eacute;l&eacute;ments du vocabulaire du grimpeur :<br><br>

    Un site ou spot, c'est un lieu o&ugrave; il est possible de grimper.<br>
    Les sites peuvent être d&eacute;coup&eacute;s en plusieurs secteurs qui regroupent un ensemble de voies.<br>
    « Lao Tzeu l'a dit : il faut trouver la voie » : c'est le chemin &agrave; emprunter par le grimpeur pour arriver &agrave; destination : le haut de la voie.<br>
    si la voie est d&eacute;coup&eacute;e en plusieurs « parties » &agrave; grimper les unes apr&egrave;s les autres, ces parties s'appellent des longueurs et on trouve un relai en haut de chaque longueur.<br>
    Quand le grimpeur arrive en haut de la longueur, c'est &agrave; ce relai qu'il se vache, c'est &agrave; dire qu'il s'y accroche, &agrave; l'aide de sa vache ou longe (corde nou&eacute;e sur le baudrier du grimpeur et &eacute;quip&eacute;e d'un mousqueton &agrave; verrouillage).<br>
    Les points ou spits sont des ancrages fixes que l'on trouve dans les voies dites « &eacute;quip&eacute;es » et qui permettent au grimpeur de s'assurer au fur et &agrave; mesure de sa progression, &agrave; l'aide de d&eacute;gaines<br>
    La cotation d'une longueur ou d'une voie, repr&eacute;sente sa difficult&eacute;. En France, le syst&egrave;me de cotation va, en gros, par ordre croissant de difficult&eacute;, de 3 &agrave; 9c. Le chiffre est en quelque sorte, l'unit&eacute; principale et la lettre une sous-unit&eacute; (de « a » &agrave; « c »)<br>
    Un topo est un recueil contenant toutes les informations utiles sur les sites d'escalade d'une r&eacute;gion (les secteurs, les voies, leur hauteur, leur cotation, le nombre de points...). Une bible quoi !<br><br>

Une envie de vacances ?<br><br>

Pourquoi ne pas partir sur l'&icirc;le de la R&eacute;union ?<br>
Cet endroit paradisiaque est &eacute;galement propice &agrave; l'escalade ! Les fans de blocs seront ravis des nombreux spots qu'offrent l'&egrave;le et pour les autres... ce sera l'occasion de d&eacute;couvrir ce type d'escalade ;). Notez justement qu'il existe des voies pour tous les niveaux, que vous soyez d&eacute;butants ou confirm&eacute;s.
</td></tr>		
	</table>



</div>

</body>
</html>