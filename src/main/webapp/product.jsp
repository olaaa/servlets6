<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product DAO example</title>
</head>
<body>
    <br/>Product info:
    <ul>
        <li/>id: ${product.id}
        <li/>Name: ${product.name}
        <li/>Weight: ${product.weight}
        <li/>Cost: ${product.cost}
    </ul>
    <br/><a href="productAddToBucket.do?id=${product.id}">add to bucket</a>
    <br/>
    <br/>Products in the bucket:
    <ul>
    <c:forEach var="entry" items="${bucket}">
        <li><a href="product.do?id=${entry.key.id}">${entry.key.name}</a> : ${entry.value}</li>
    </c:forEach>
    </ul>
</body>
</html>