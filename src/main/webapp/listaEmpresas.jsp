<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="empresas" scope="request" type="java.util.List"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
Lista de empresas: <br />

<ul>
    <c:forEach items="${empresas}" var="empresa">
        <li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/></li>
    </c:forEach>
</ul>
</body>
</html>
