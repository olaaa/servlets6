<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product DAO example</title>
</head>
<body>
    <br/><a href="productList.do">product list</a>

    <ul>
        <br/>Product info:
        <li/>id: ${product.id}
        <li/>Name: ${product.name}
        <li/>Weight: ${product.weight}
        <li/>Cost: ${product.cost}
        <br/><a href="productAddToBucket.do?id=${product.id}">add to bucket</a>
    </ul>

    <ul>
        <br/>Products in the bucket:
    <c:forEach var="entry" items="${bucket}">
        <li><a href="product.do?id=${entry.key.id}">${entry.key.name}</a> : ${entry.value} <button onclick="productRemoveFromBucket(${entry.key.id})">remove 1</button></li>
    </c:forEach>
    </ul>
</body>

<script>
    function productRemoveFromBucket(id) {
        var xhttp;

        if (window.XMLHttpRequest) {
            xhttp = new XMLHttpRequest();
        } else {
        // code for IE6, IE5
            xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        xhttp.open("GET", "productRemoveFromBucket.do?id=" + id, true);
        xhttp.send();
        xhttp.onreadystatechange = function() {
            location.reload(true);
        }
    }
</script>
</html>