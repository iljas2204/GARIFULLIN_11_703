<%@ page import="ru.itis.project.services.UsersService" %>
<%@ page import="static sun.misc.MessageUtils.out" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    String cookie = "";
    Cookie[] cookies = request.getCookies();
    ServletContext context = config.getServletContext();
    UsersService usersService = (UsersService) context.getAttribute("usersService");
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {

            if (cookies[i].getName().equals("auth")) {
                cookie = cookies[i].getValue();
            }
        }
    }
    if (cookie.equals("")) {
%>
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