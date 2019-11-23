<%@page import="java.util.Properties"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/main-page.css">
<link rel="shortcut icon" type="image/x-icon" href="img/logo.ico" />
<title>Game of Thrones JSP CRUD</title>
</head>
<body>
<img src="img/got-map.jpg" class="bg">
<div id="wrapper">
<div id="page-wrap">
<P>
<button class="button" 
	onclick="window.location.href='main-page.html'">Home</button>		
</P>
<P>
<button class="button" 
	onclick="window.location.href='create-db.jsp'">Criar Banco</button>		
</P>
<p>
<P>
<button class="button" 
	onclick="window.location.href='batalha/menu.html'">Batalha</button>		
</P>
</div>

<div id="page-content">
	<%
		Properties properties = new Properties();
		properties.setProperty("javax.persistence.schema-generation.database.action", "create");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gotPU", properties);
		out.println("<div class=\"box\"> <a class=\"main-form\">Banco de Dados criado!!</a> </div>");
	%>
</div>

</div>
</body>
</html>
