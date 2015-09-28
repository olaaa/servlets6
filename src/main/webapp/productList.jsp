<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProductAll</title>
</head>
<body>
<br/>List of all products:

<c:forEach var="product" items="${productList}">
    <br/><a href="productDao.do?id=${product.id}">${product.name}</a>
</c:forEach>

</body>
</html>