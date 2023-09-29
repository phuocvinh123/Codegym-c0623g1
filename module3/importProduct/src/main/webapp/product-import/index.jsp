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
    <h3 class="text-center">Management Product Import</h3>
    <c:if test="${message != null}">
      <h6 class="d-none" id="message">${message}</h6>
    </c:if>



    <div >
     <c:if test="${!isShowRestore}">
        <div class="d-grid gap-2 d-md-block">
          <a href="/product-import?action=create" class="btn btn-primary mb-2">Create</a>
          <a href="/product-import?action=restore" class="btn btn-primary mb-2">Restore</a>
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
          <form action="/product-import?page=${page.currentPage}">
            <input type="text" id="searchBook" value="${search}" name="search"  placeholder="Search Book Title">
            <button id="searchButton" class="btn btn-primary">Search</button>
          </form>
        </div>
      </c:if>
      <c:if test="${isShowRestore}">
      <form action="/product-import?action=restore" method="post">

        <div>
          <a href="/product-import" class="btn btn-primary mb-2">Home</a>
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
          Code
        </td>
        <td>
          Import Date
        </td>
        <td>
          Products
        </td>
        <td>
          Total Amount
        </td>
        <td id="selectAllCheckbox">
          Action
        </td>
      </tr>
      <c:forEach var="productImport" items="${page.content}">
        <tr>
          <td>
              ${productImport.id}
          </td>
          <td>
              ${productImport.code}
          </td>
          <td>
              ${productImport.importDate}
          </td>
          <td>
              ${productImport.products}
          </td>
          <td>
              ${productImport.totalAmount}
          </td>
          <td>
            <c:if test="${!isShowRestore}">
            <a href="/product-import?action=edit&id=${productImport.id}" class="btn btn-warning">Edit</a>
            <a href="/product-import?action=delete&id=${productImport.id}" class="btn btn-danger">Delete</a>
            </c:if>
            <c:if test="${isShowRestore}">
              <input type="checkbox" name="restore" value="${productImport.id}" class="form-check-input checkbox"  />
            </c:if>
          </td>
        </tr>
      </c:forEach>
    </table>
    <c:if test="${isShowRestore}">
      </form>
    </c:if>
    <nav aria-label="...">
      <c:set var="url" value="/product-import?page="/>
      <c:if test="${isShowRestore}">
        <c:set var="url" value="/product-import?action=restore&page="/>
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