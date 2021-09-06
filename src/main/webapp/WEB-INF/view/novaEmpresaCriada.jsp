<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="empresa" class="java.lang.String" scope="request"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
    <c:if test="${ not empty empresa }">
        Empresa ${ empresa } cadastrada com sucesso!
    </c:if>

    <c:if test="${ empty empresa }">
        Nenhuma empresa cadastrada!
    </c:if>
</body>
</html>
