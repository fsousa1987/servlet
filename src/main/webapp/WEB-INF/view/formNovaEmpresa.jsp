<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <c:import url="logout-parcial.jsp" />
    <form action="${linkEntradaServlet}" method="post">
        <label>
            Nome:
            <input type="text" name="nome"/>
        </label>
        <label>
            Data abertura:
            <input type="text" name="data"/>
        </label>
        <label>
            <input type="hidden" name="acao" value="NovaEmpresa"/>
        </label>
        <input type="submit">
    </form>
</body>
</html>