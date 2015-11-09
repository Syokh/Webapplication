<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
    <style type="text/css">
        h3 {
            font-family: Calibri;
            font-size: 22pt;
            font-style: normal;
            font-weight: bold;
            color: SlateBlue;
            text-align: center;
            text-decoration: underline
        }

        table {
            font-family: Calibri;
            color: white;
            font-size: 11pt;
            font-style: normal;
            width: 50%;
            text-align:;
            background-color: SlateBlue;
            border-collapse: collapse;
            border: 2px solid navy
        }

        table.inner {
            border: 0px
        }
    </style>
    <meta http-equiv="Content-Type" content="text/http; charset=ISO-8859-1"/>
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
          rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

</head>

<body>
<h3> Registration Form</h3>
<script>

    function doAjaxPost() {

        var username = $("#username").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();

        $.ajax({
            url: "adduser.as",
            contentType: 'application/json',
//                data: JSON.stringify(user),
            data: "username=" + username + "&password=" + password +"&password2=" + password2,
            type: 'GET',
            success: function (response) {
                alert(response);
            },
            error: function (xhr, status, errorThrown) {
                alert('adding user failed with status: ' + status + '. ' + errorThrown);
            }
        });
    }

</script>

<a href="/login.jsp">Login page</a><br/>

<form action="" method="POST" id="formID">
    <table align="center" cellpadding="10">
        <tr>
            <td>User Name</td>
            <td><input type="text" name="username" maxlength="30" id="username"/>
                (max 30 characters a-z and A-Z)
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" maxlength="100" id="password"/></td>
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="password2" maxlength="100" id="password2"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="button" id="Submit" class="button" value="Submit" onclick="doAjaxPost();"/>
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</form>


<%--<form  action="" method="POST">--%>
<%--<label for="username">User Name:</label>--%>
<%--<input type="text" name="username" id="username" class="input"/> <br/><br/>--%>
<%--<label for="password">Password:</label>--%>
<%--<input type="text" name="password" id="password" class="input"/> <br/><br/>--%>
<%--&lt;%&ndash;<label for="password2">Confirm Password :</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;<input type="text" name="password2" id="password2" class="input"/> <br/> <br/>&ndash;%&gt;--%>
<%--<input type="button" id="Submit" class="button" value="Submit"/>--%>
<%--</form>--%>


</body>
</html>
