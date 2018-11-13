<%@ page import="ru.itis.project.services.UsersService" %>
<%@ page import="static sun.misc.MessageUtils.out" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div id="signInForm">
    <form method="post">
        <input name="email" placeholder="Your name">
        <br>
        <input type="password" name="password" placeholder="Your Password">
        <br>
        <input type="submit" value="signIn">
    </form>
</div>
<% } else {%>
<div id="afterSignIn">
    <p><%=usersService.Login(cookie).get().getEmail()%></p>
</div>
<% } %>
</body>
</html>