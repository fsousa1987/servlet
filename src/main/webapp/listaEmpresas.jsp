<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${ not empty empresa }">
    Empresa ${ empresa } cadastrada com sucesso!
</c:if>

Lista de empresas: <br />

<ul>
    <c:forEach items="${ empresas }" var="empresa">
        <li>
            ${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
            <a href="/gerenciador/mostraEmpresa?id=${ empresa.id }">edita</a>
            <a href="/gerenciador/removeEmpresa?id=${ empresa.id }">remove</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
