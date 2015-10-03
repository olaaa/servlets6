<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello page</title>
</head>
<body>
    <br/>Hello, ${name}!
    
    <c:if test="${name == 'stranger'}">
    <form method="GET" action="hello.do">
        <input type="text" name="name" size="20" value="I'm not stranger">
        <input type="submit">
    </form>
    </c:if>
</body>
</html>
