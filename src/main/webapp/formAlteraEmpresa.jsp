<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/alteraEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="${linkServletNovaEmpresa}" method="post">
    <label>
        Nome:
        <input type="text" name="nome" value="${ empresa.nome }"/>
    </label>
    <label>
        Data abertura:
        <input type="text" name="data" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"/>
    </label>
    <label>
        <input type="hidden" name="id" value="${ empresa.id }"/>
    </label>
  <input type="submit">
</form>
</body>
</html>