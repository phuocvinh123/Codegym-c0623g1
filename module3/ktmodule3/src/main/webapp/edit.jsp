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
            <h3 class="text-center">Edit Teacher</h3>
            <form action="/teacher?action=edit&id=${teacher.id}" method="post">
                <div class="mb-3">
                    <label for="Name" class="form-label">Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${teacher.name}">
                </div>
                <div class="mb-3">
                    <label for="date" class="form-label">Date of Birth</label>
                    <input type="Date" class="form-control" id="date" name="date" value="${teacher.date}">
                </div>
                <div class="mb-3">
                    <label for="hobbie" class="form-label">Hobbie</label>
                    <input type="text" class="form-control" id="hobbie" name="hobbie" value="${teacher.hobbie}">
                </div>
                <div class="mb-3">
                    <label for="gender" class="form-label">Gender</label>
                    <select class="form-control" id="gender" name="gender">
                        <option value="MALE" ${teacher.gender == 'MALE' ? 'selected' : ''}>MALE</option>
                        <option value="FEMALE" ${teacher.gender == 'FEMALE' ? 'selected' : ''}>FEMALE</option>
                        <option value="OTHER" ${teacher.gender == 'OTHER' ? 'selected' : ''}>OTHER</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="degrees" class="form-label">Degrees</label>
                    <select class="form-control" name="degrees" id="degrees">
                        <c:forEach var="degrees" items="${degrees}">
                            <option value="${degrees.id}"
                                    <c:if test="${degrees.id == teacher.degrees.id}">
                                        selected
                                    </c:if>
                            >${degrees.name}</option>
                        </c:forEach>
                    </select>
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
