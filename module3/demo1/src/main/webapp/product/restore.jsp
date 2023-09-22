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
        <h3 class="text-center">Delete Product</h3>
        <c:if test="${message != null}">
            <h6 class="d-none" id="message">${message}</h6>
        </c:if>
        <div>
            <a href="/product" class="btn btn-primary mb-2">Back</a>
        </div>
        <table class="table table-striped">
            <tr>
                <td>
                    Id
                </td>
                <td>
                    Name
                </td>
                <td>
                    Price
                </td>
                <td>
                    Description
                </td>
                <td>
                    Category
                </td>
                <td>
                    Action
                </td>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>
                            ${product.id}
                    </td>
                    <td>
                            ${product.name}
                    </td>
                    <td>
                            ${product.price}
                    </td>
                    <td>
                            ${product.description}
                    </td>
                    <td>
                            ${product.category.name}
                    </td>

                    <td>
                    <div class="form-check">
                        <label for="select${product.id}"></label>
                        <input class="form-check-input" type="checkbox" value="${product.id}" id="${product.id}" name="${product.id}">
                    </div>
                    </td>
                </tr>
            </c:forEach>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <a class="btn btn-danger" onclick="restoreProduct()">Restore</a>
            </div>
        </table>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script>
    function restoreProduct() {
        var checked = document.querySelectorAll(".form-check-input");
        var checkedIds = [];
        for (var i = 0; i < checked.length; i++) {
            if (checked[i].checked) {
                checkedIds.push(checked[i].id);
            }
        }
        var checkedIdsString = checkedIds.join(",");
        if(checkedIdsString.length === 0){
            window.location.href = "product?action=showRestore"
        }
        window.location.href = "product?action=restore&id=" + checkedIdsString
    }
</script>
<script>
    const message = document.getElementById('message');
    if (message !== null && message.innerHTML) {
        toastr.success(message.innerHTML);
    }
</script>
</body>
</html>