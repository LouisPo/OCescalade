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
</head>
<body class="body">

	<div id="header">
	
	</div>



	<table border="1">
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

		
	</table>





</body>
</html>