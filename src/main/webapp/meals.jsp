<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<table border="1">
    <tr>
        <th>dateTime</th>
        <th>description</th>
        <th>calories</th>
    </tr>
    <c:forEach items="${mealWithExceedList}" var="mealWithExceed">
        <%--<c:choose>--%>
            <%--<c:when test="${mealWithExceed.isExceed()}">--%>
                <%--<tr bgcolor="red">--%>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
                <%--<tr bgcolor="green">--%>
            <%--</c:otherwise>--%>
        <%--</c:choose>--%>
        <tr bgcolor=${mealWithExceed.isExceed() ? "red" : "green"}>
            <td>${mealWithExceed.getDateTime()}</td>
            <td>${mealWithExceed.getDescription()}</td>
            <td>${mealWithExceed.getCalories()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>