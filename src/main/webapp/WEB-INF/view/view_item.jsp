<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="learnprogramming.utils.Mappings" %>
<%@ page import="learnprogramming.utils.AttributeNames" %>


<html>
<head>
    <title>Todo Item</title>
</head>
<body>
    <div align="center">

    <table border="1" cellpadding="5">
        <caption><h2>Todo Item </h2></caption>

        <tr>
            <td><label>ID</label></td>
            <td>
                <c:out value= "${todoItem.id}" />
            </td>
        </tr>
        <tr>
            <td><label>Tittle</label></td>
            <td>
                <c:out value= "${todoItem.title}" />
            </td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td>${todoItem.details}</td>
        </tr>
        <tr>
            <td><label>Deadline</label></td>
            <td>
                <c:out value= "${todoItem.deadline}" />
            </td>
    </table>

            <c:url var="editUrl" value="${Mappings.ADD_ITEM}">
               <c:param name="id" value="${todoItem.id}"/>
            </c:url>

    <table border="2" cellpadding="10">
        <tr>
            <th>Tittle</th>
            <th>Deadline</th>
            <th>Details</th>
            <th>Edit</th>

        </tr>
            <tr>
            <td>${todoItem.title}</td>
            <td><c:out value="${todoItem.deadline}"/></td>
            <td>${todoItem.details}</td>
            <td><a href="${editUrl}">Edit</a></td>
        </tr>
    </table>

    <c:url var="backToItems" value="${Mappings.ITEMS}" />
            <a href="${backToItems}"> back to the list </a>

    </div>

</body>
</html>