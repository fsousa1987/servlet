<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="usuarioLogado" scope="session" type="com.francisco.gerenciador.modelo.Usuario"/>
<jsp:useBean id="empresa" scope="request" class="java.lang.String"/>
<jsp:useBean id="empresas" scope="request" type="java.util.ArrayList"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />

Usuario Logado: ${ usuarioLogado.login }
<br>
<br>
<br>
<c:if test="${ not empty empresa }">
    Empresa ${ empresa } cadastrada com sucesso!
</c:if>

Lista de empresas: <br />

<ul>
    <c:forEach items="${ empresas }" var="empresa">
        <li>
            ${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
            <a href="${pageContext.request.contextPath}/entrada?acao=MostraEmpresa&id=${ empresa.id }">edita</a>
            <a href="${pageContext.request.contextPath}/entrada?acao=RemoveEmpresa&id=${ empresa.id }">remove</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
