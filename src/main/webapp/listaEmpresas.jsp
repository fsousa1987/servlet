<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="empresas" scope="request" type="java.util.List"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
Lista de empresas: <br />

<ul>
    <c:forEach items="${empresas}" var="empresa">
        <li>${empresa.nome}</li>
    </c:forEach>
</ul>
</body>
</html>
