<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/http; charset=ISO-8859-1"/>
    <title>Incert title here</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../bookStyle.css"/>
</head>
<body>
<script>
    $(document).ready(function () {
        <sec:authorize url="/book/add.as">
        $("#addBookSubmitBtn").click(function () {
            var book = {
                title: $("#bookTitle").val(),
                description: $("#bookDescription").val(),
                isbm: $("#bookIsbm").val()
            };
            $.ajax({
                url: "add.as",
                contentType: 'application/json',
                data: JSON.stringify(book),
                type: 'POST',
                success: function (data) {
                    location.reload();
                },
                error: function (xhr, status, errorThrown) {
                    alert('adding book failed with status: ' + status + '. ' + errorThrown);
                }
            });
        });
        </sec:authorize>
    });
</script>
<div >
    <a href="../logout">Logout</a>
</div>
<br/>
<a href="hello.as">Hello Wofld</a> <br/>
<a id="List">List Book</a> <br/>
<table class="bookTable">
    <thead>
    <tr id="Title">
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>ISBM</th>
    </tr>
    </thead>
    <thead>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.description}</td>
            <td>
                <sec:authorize access="hasRole('ADMIN')">
                    ${book.isbm}
                </sec:authorize>
            </td>
        </tr>
    </c:forEach>
    </thead>
</table>

<h3><sec:authorize access="hasRole('USER')">IT IS USER</sec:authorize></h3>
<sec:authorize url="/book/add.as">
    <form  action="" method="POST">
        <label for="bookTitle">Title</label>
        <input type="text" name="title" id="bookTitle" class="input"/> <br/><br/>
        <label for="bookDescription">Description</label>
        <textarea id="bookDescription" name="description" class="input"></textarea> <br/><br/>
        <label for="bookIsbm">Isbm</label>
        <input type="text" name="isbm" id="bookIsbm" class="input"/> <br/> <br/>
        <input type="button" id="addBookSubmitBtn" class="button" value="Submit"/>
    </form>
</sec:authorize>
</body>
</html>
