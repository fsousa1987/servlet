<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="${linkEntradaServlet}" method="post">
    <label>
        Login:
        <input type="text" name="login"/>
    </label>
    <label>
        Senha:
        <input type="password" name="senha"/>
    </label>
    <label>
        <input type="hidden" name="acao" value="Login"/>
    </label>
  <input type="submit">
</form>
</body>
</html>