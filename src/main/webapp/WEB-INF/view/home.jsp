<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="learnprogramming.utils.Mappings" %>
<html>
<head>
    <title>Todo List App</title>
</head>
<body>
    <div align="center">
        <c:url var="itemsLink" value="${Mappings.ITEMS}" />
        <h2><a href="${itemsLink}"> Show Todo Items </a></h2>
    </div>

</body>
</html>