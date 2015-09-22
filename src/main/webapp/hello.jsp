<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello page</title>
</head>
<body>
    <br/>Hello, <%=request.getParameter("name")%>!
    <br/>Hello, ${name}!
</body>
</html>
