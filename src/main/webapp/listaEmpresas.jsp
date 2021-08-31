<%@ page import="com.francisco.gerenciador.servlet.Empresa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Lista de empresas: <br />
<ul>
    <%
        List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
        for (Empresa empresa : lista) {
    %>
        <li><%= empresa.getNome() %></li>
    <%
        }
    %>
</ul>
</body>
</html>
