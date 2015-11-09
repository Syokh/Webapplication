<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<form action="login" method="post">
    <input type="hidden" name="j_spring_security_check" value="true">

    <p id="loginPage">Login Page</p>

    <p>
        <label for="username">User Name:</label>
        <input type="text" id="username" name="username"/>
    </p>

    <p>
        <label for="password">Password:  </label>
        <input type="password" id="password" name="password"/>
    </p>

    <p>
        <input type="submit" value="Login" id="loginButton"/>
    </p>

    <span class="login-box-options">
New User?  <a href="register.jsp" style="margin-left:30px;">Register Here</a>
    </span>
</form>
<p class="loginError">
    <c:if test="${param.error=='invalidLoginPassword'}">
        Invalid login or password. Please check and try again.
    </c:if>
</p>

<p style="color:blue">
    <c:if test="${param.error=='loginRequired'}">
        You are currently logged off. Please log in
    </c:if>
</p>
</body>
</html>
