<%@ page import="ru.itis.project.services.UsersService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <script>
        $( '.button' ).click(function() {
            $( "cardColumns" ).load( "jsp/main.jsp  #cardColumns >*" );
        });
    </script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
</head>
<body style="background-color:#f8f9fa">
<!--

NAVBAR

-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="home">Home</a>
            <a class="nav-item nav-link" href="main">Look Projects</a>
        </div>
    </div>
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
    <div id="withOutSignIn" class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group mr-2" role="group" aria-label="First group">
            <a href="signIn" class="btn btn-outline-info">Sign In</a>
        </div>
        <div class="btn-group mr-2" role="group" aria-label="Second group">
            <a href="signUp" class="btn btn-outline-info">Sign Up</a>
        </div>
    </div>
    <% } else {%>
    <div class="dropdown show">
        <a class="btn btn-outline-info dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <%=usersService.Login(cookie).get().getEmail()%>
        </a>

        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="dropdown-item" href="#">Profile</a>
            <a class="dropdown-item" href="/exit">Log out</a>
        </div>
    </div>
    <% }%>
</nav>
<br>
<div class="container">
    <div class="row">
        <div class="card-columns" id="cardColumns">
            <%
                for (int i = 0; i < usersService.forTable().size()  ; i++) {
            %>
            <div class="card border-info mb-3" style="max-width: 21rem;">
                <div class="card-header">Header</div>
                <div class="card-body text-info">
                    <h5 class="card-title"><%=usersService.forTable().get(i).getId()%>
                        and <%=usersService.forTable().get(i).getUserId()%>
                    </h5>
                    <p class="card-text">фимпфффффффффффффффффффффффффффффффффффффффффффффффффффффффф</p>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
