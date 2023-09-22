<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MSI GAMING
  Date: 18/09/2023
  Time: 10:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table>
            <tr>
                <td>
                    id
                </td>
                <td>
                    name
                </td>
                <td>
                    age
                </td>
            </tr>
        </table>
    <c:forEach var="student" items="${students}">
    <table>
        <tr>
            <td>
                ${student.id}
            </td>
            <td>
                    ${student.name}
            </td>
            <td>
                    ${student.age}
            </td>
        </tr>
    </c:forEach>
</body>
</html>
