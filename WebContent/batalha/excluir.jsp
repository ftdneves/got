<!DOCTYPE html>
<%@page import="br.edu.unifei.ecoe18.got.modelo.Batalha"%>
<%@page import="br.edu.unifei.ecoe18.got.modelo.FonteDados"%>
<%@page import="javax.persistence.EntityManager"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/main-page.css">
<link rel="shortcut icon" type="image/x-icon" href="../img/logo.ico" />
<title>Game of Thrones JSP CRUD</title>
</head>
<body>
<img src="../img/got-map.jpg" class="bg">
<div id="wrapper">
<div id="page-wrap">
<P>
<button class="button" 
	onclick="window.location.href='../main-page.html'">Home</button>		
</P>
<P>
<button class="button" 
	onclick="window.location.href='../create-db.jsp'">Criar Banco</button>		
</P>
<div class="dropdown">
<button class="button" 
	onclick="window.location.href='menu.html'">Batalha</button>		
	<div class="dropdown-content">
    	<a href="inserir-form.html">Inserir</a>
    	<a href="alterar-busca.html">Alterar</a>
    	<a href="excluir-busca.html">Excluir</a>
    	<a href="consultar-busca.html">Consultar</a>
  	</div>
</div>

</div>

<div id="page-content">
<%
	EntityManager em = FonteDados.createEntityManager();
	Batalha b = (Batalha) em.find(Batalha.class, request.getParameter("data"));
	b.setLocal(request.getParameter("local"));
	b.setResultado(request.getParameter("resultado"));
	em.getTransaction().begin();
	em.remove(b);
	em.getTransaction().commit();
	out.println("<div class=\"box\"> <a class=\"main-form\">Batalha excluida!!</a> </div>");
%>
</div>
</div>
</body>
</html>