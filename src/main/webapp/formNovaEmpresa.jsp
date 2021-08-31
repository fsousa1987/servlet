<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

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
        <input type="text" name="nome"/>
    </label>
  <input type="submit">
</form>
</body>
</html>