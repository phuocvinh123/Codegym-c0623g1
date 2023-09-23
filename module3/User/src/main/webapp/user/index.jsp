<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/18/2023
  Time: 9:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/toastr@2.1.4/build/toastr.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="card container px-6" style="height: 100vh">
        <h3 class="text-center">Management User</h3>
        <c:if test="${message != null}">
            <h6 class="d-none" id="message">${message}</h6>
        </c:if>
        <form class="d-grid gap-2 d-md-flex justify-content-md-end" action="/user?action=search" method="post">
            <input id="inputSearch" type="search" name="inputSearch" placeholder="Enter category" aria-label="Search" >
            <button type="submit">Search</button>
        </form>
        <div>
            <a href="user?action=create" class="btn btn-primary mb-2">Create</a>
            <a href="user?action=showRestore" class="btn btn-primary mb-2">Restore</a>
        </div>

        <table class="table table-striped">
            <tr>
                <td>
                    Id
                </td>
                <td>
                    FirstName
                </td>
                <td>
                    LastName
                </td>
                <td>
                    UserName
                </td>
                <td>
                    Email
                </td>
                <td>
                    DOB
                </td>
                <td>
                    Role
                </td>
                <td>
                    Gender
                </td>
                <td>
                    Action
                </td>
            </tr>
            <c:forEach var="user" items="${page.content}">
                <tr>
                    <td>
                            ${user.id}
                    </td>
                    <td>
                            ${user.firstName}
                    </td>
                    <td>
                            ${user.lastName}
                    </td>
                    <td>
                            ${user.userName}
                    </td>
                    <td>
                            ${user.email}
                    </td>
                    <td>
                            ${user.dob}
                    </td>
                    <td>
                            ${user.role.name}
                    </td>
                    <td>
                            ${user.gender}
                    </td>
                    <td>
                        <a href="user?action=edit&id=${user.id}" class="btn btn-warning">Edit</a>
                        <a class="btn btn-danger"  href="/user?action=delete&id=${user.id}">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <nav aria-label="...">
            <ul class="pagination">
                <li class="page-item <c:if test="${page.currentPage == 1}">disabled</c:if>">
                    <a class="page-link"  href="/user?page=${page.currentPage - 1}" tabindex="-1" aria-disabled="true">Previous</a>
                </li>
                <c:forEach var="number" begin="1" end="${page.totalPage}">
                    <c:if test="${number == page.currentPage}">
                        <li class="page-item active" aria-current="page">
                            <a class="page-link" href="/user?page=${number}">${number}</a>
                        </li>
                    </c:if>
                    <c:if test="${number != page.currentPage}">
                        <li class="page-item">
                            <a class="page-link" href="/user?page=${number}">${number}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <li class="page-item <c:if test="${page.currentPage == page.totalPage}">disabled</c:if>">
                    <a class="page-link" href="/user?page=${page.currentPage + 1}">Next</a>
                </li>
            </ul>
        </nav>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<script>

    const message = document.getElementById('message');
    if (message !== null && message.innerHTML) {
        toastr.success(message.innerHTML);
    }
</script>
</body>
</html>