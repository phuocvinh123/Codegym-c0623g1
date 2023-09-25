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
        <div class="d-flex justify-content-between">
            <c:if test="${!isShowRestore}">
                <div>
                    <a href="/user?action=create" class="btn btn-primary mb-2">Create</a>
                    <a href="/user?action=restore" class="btn btn-primary mb-2">Restore</a>
                </div>

                    <form action="/user?page=${page.currentPage}">
                        <input type="text" id="searchBook" value="${search}" name="search" class="d-grid gap-2 d-md-flex justify-content-md-end" style="width: 85%" placeholder="Search User Title">
                        <button id="searchButton" class="btn btn-primary">Search</button>
                    </form>



            </c:if>
            <c:if test="${isShowRestore}">
            <form action="/user?action=restore" method="post">

                <div>
                    <a href="/user" class="btn btn-primary mb-2">Home</a>
                    <button type="submit" class="btn btn-primary mb-2">Restore All</button>
                </div>
                </c:if>

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
                <td id="selectAllCheckbox">
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
                    <c:if test="${!isShowRestore}">
                    <td>
                        <a href="user?action=edit&id=${user.id}" class="btn btn-warning">Edit</a>
                        <a class="btn btn-danger"  href="/user?action=delete&id=${user.id}">
                            Delete
                        </a>
                    </td>
                    </c:if>
                    <c:if test="${isShowRestore}">
                    <td>
                        <a href="user?action=restore&id=${user.id}" class="btn btn-danger">Restore</a>
                        <input type="checkbox" name="restore" value="${user.id}" class="form-check-input checkbox"  />
                    </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${isShowRestore}">
            </form>
        </c:if>
        <nav aria-label="...">
            <c:set var="url" value="/user?page="/>
            <c:if test="${isShowRestore}">
                <c:set var="url" value="/user?action=restore&page="/>
            </c:if>
            <ul class="pagination">
                <li class="page-item <c:if test="${page.currentPage == 1}">disabled</c:if>">
                    <a class="page-link" href="${url}${(page.currentPage - 1)}" tabindex="-1"
                       aria-disabled="true">Previous</a>
                </li>
                <c:forEach var="number" begin="1" end="${page.totalPage}">
                    <c:if test="${number == page.currentPage}">
                        <li class="page-item active" aria-current="page">
                            <a class="page-link" href="${url}${number}">${number}</a>
                        </li>
                    </c:if>
                    <c:if test="${number != page.currentPage}">
                        <li class="page-item">
                            <a class="page-link" href="${url}${number}">${number}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <li class="page-item <c:if test="${page.currentPage == page.totalPage}">disabled</c:if>">
                    <a class="page-link" href="${url}${(page.currentPage + 1)}">Next</a>
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

    const selectAllCheckbox = document.getElementById('selectAllCheckbox');
    const checkboxes = document.getElementsByClassName('checkbox');
    let checked = true;
    selectAllCheckbox.addEventListener('click', function () {
        Array.from(checkboxes).forEach(function (checkbox) {
            checkbox.checked = checked;

        });
        checked = !checked;
    });
</script>
</body>
</html>