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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="card container px-6" style="height: 100vh">
        <h3 class="text-center">Edit Book</h3>
        <form action="/book?action=edit&id=${book.id}" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Title</label>
                <input type="text" class="form-control" id="name" name="title" value="${book.title}">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <input type="text" class="form-control" id="description" name="description" value="${book.description}">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <input type="number" class="form-control" name="price" id="price" value="${book.price}">
            </div>
            <div class="mb-3">
                <label for="publishDate" class="form-label">PublishDate</label>
                <input type="date" class="form-control" name="publishDate" id="publishDate" value="${book.publishDate}">
            </div>
            <div class="mb-3">
                <label for="category" class="form-label">Category</label>
                <select class="form-control" name="category" id="category" >
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.id}" ${category.id==book.category.id?'selected':""}>${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">

                <label class="form-label">Author </label>


                    <c:forEach var="author" items="${authors}">
                        <div class="form-check form-check-inline">
                            <input
                                    <c:forEach var="bauthor" items="${book.bookAuthors}" >
                                        <c:if test="${bauthor.author.id == author.id}">
                                            ' checked '
                                        </c:if>
                                    </c:forEach>
                                    class="form-check-input checkbox" name="author" type="checkbox" id="inlineCheckbox${author.id}" value="${author.id}">
                            <label class="form-check-label" for="inlineCheckbox${author.id}">${author.name}</label>
                        </div>
                    </c:forEach>


            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>