<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <script>
         function check(){

        	 alert("toto");
        	     document.getElementById("form").action = "${pageContext.request.contextPath}/ajoutCommentView"; 
        	     //document.frm.action="${pageContext.request.contextPath}/openParcoursRechercheView";
            	 document.getElementById("form").submit(); 
                 return true;
             }
         function seek(){
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

	<form:form  name="form" modelAttribute="parcours" action = "${pageContext.request.contextPath}/ajoutCommentView">
	<h1>Detail du parcours</h1>
	<table border = "1">
		<tr>
			<th>nom</th>
			<th>taille</th>
			<th>difficulte</th>
			<th>localisation</th>
			
		</tr>
		
			<tr>
				<td>${parcours.nom}</td>
				<td>${parcours.taille}</td>
				<td>${parcours.difficulte}</td>
				<td>${parcours.localisation}</td>				
				<td>
					
					<a href = "${pageContext.request.contextPath}/deleteparcours/${parcours.parcours_id}">Supprimer</a>
				</td>
			</tr>
			commentaire sur le parcours
		<textarea  name="textarea" rows="5" cols="33"></textarea>
	    <input type ="hidden" name="user" value="${parcours.parcours_id}">
	</table>

	<button type="submit">recherche parcours</button>
	<button>envoyer commentaire</button>

</form:form>
</body>
</html>