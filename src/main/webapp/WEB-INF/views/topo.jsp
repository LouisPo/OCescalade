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

	<form:form  name="form" action = "${pageContext.request.contextPath}/insertTopoView">
	<h1>Detail du topo</h1>

	<c:if test = "${dispoperso ne 'PRETE'}">
		<table border = "0">
		<tr>
			<th>contenu du topo</th>
	   </tr>
		<tr>
		
			<th>
			<c:if test = "${user_id eq identifiant}">
			    <c:if test = "${identifiantpret == 0}"><textarea  name="textarea" rows="5" cols="40">${textarea}</textarea>
                </c:if> 
            </c:if>  
               
            <c:if test = "${user_id ne identifiant}">
			    <c:if test = "${identifiantpret != 0}"><textarea  name="textarea" readonly="readonly" rows="5" cols="40">${textarea}</textarea>
                </c:if> 
            </c:if>  
               
               
            <c:if test = "${user_id ne identifiant}">
			    <c:if test = "${identifiantpret == 0 && identifiant !=0}"><textarea  name="textarea" readonly="readonly"  rows="5" cols="40">${textarea}</textarea>
                </c:if> 
            </c:if>  
            <c:if test = "${user_id ne identifiant}">
			    <c:if test = "${identifiant == 0}"><textarea  name="textarea"   rows="5" cols="40">${textarea}</textarea>
                </c:if> 
            </c:if>  
			<input type ="hidden" name="user_id" value="${user_id}">
			<input type ="hidden" name="identifiant" value="${identifiant}">
	   </tr>
	</table>
	</c:if>
		<c:if test = "${dispoperso eq 'PRETE'}">
	Le Topo a ete prete
	</c:if>
<p>
		
		
	<c:if test = "${e.nomtopo eq ''}">
	<table border = "0">		<tr>
			<th>Topos qui ont ete pretes</th>					
		</tr>
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
	
	
	 <c:if test = "${user_id ne identifiant}">
			    <c:if test = "${identifiant == 0}"><button type="submit">Modifier le topo</button>
                </c:if> 
            </c:if> 
	
	<c:if test = "${user_id eq identifiant}">
       <c:if test = "${identifiantpret == 0}"><button type="submit">modifier votre topo</button></c:if> 
    </c:if>   
   </form:form>
   
   <form:form  name="form" action = "${pageContext.request.contextPath}/openlistTopofromtopo">
   
   <c:if test = "${user_id ne identifiant}"> 
   		<c:if test = "${identifiantpret != 0}"><button type="submit">demande de pret de Topo</button>
   		</c:if> 
   </c:if>
			<input type ="hidden" name="user_id" value="${user_id}">
			<input type ="hidden" name="identifiant" value="${identifiant}">
   </form:form>
   
   <form:form  name="form" action = "${pageContext.request.contextPath}/openlistTopofromtopo">
		    <c:if test = "${user_id ne identifiant}">
			    <c:if test = "${identifiantpret == 0 && identifiant !=0}"><button type="submit">demande de pret de Topo</button>
                </c:if> 
            </c:if>  
			<input type ="hidden" name="user_id" value="${user_id}">
			<input type ="hidden" name="identifiant" value="${identifiant}">
   </form:form>
	
   <form:form  name="form" action = "${pageContext.request.contextPath}/insertTopoView">
		    
			<input type ="hidden" name="user_id" value="${user_id}">
			<input type ="hidden" name="identifiant" value="${identifiant}">
   </form:form>

<form:form  name="formulaire2" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openParcoursRechercheView">
<input type ="hidden" name="user_id" value="${user_id}">
<button type="submit">recherche parcours</button>

</form:form>
<form:form  name="formulaire5" modelAttribute="parcours" action = "${pageContext.request.contextPath}/openAccueilViewFrom">
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