<%@ page import="ru.itis.project.services.UsersService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
          integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
</head>

<body style="background-color:#EEEFF0">
<!--

NAVBAR

-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="/home">Home</a>
            <a class="nav-item nav-link" href="/main">Look Projects</a>
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
            <%=usersService.Login(cookie).get().getLogin()%>
        </a>

        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="dropdown-item" href="/profile">Profile</a>
            <a class="dropdown-item" href="/exit">Log out</a>
        </div>
    </div>
    <% } %>
</nav>
<!--

CAROUSEL

-->
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100"
                 src="https://i1.wp.com/www.synthtopia.com/wp-content/uploads/2016/10/surface-studio-tilted.jpg"
                 alt="First slide">
            <div class="carousel-caption d-none d-md-block">
                <h1>Просмотр всех проектов без смс и регистрации</h1>
            </div>
        </div>
        <div class="carousel-item">
            <img class="d-block w-100"
                 src="https://mygeneral.org/wp-content/uploads/2017/06/computer-and-info-sciences-1.gif"
                 alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
                <h1>Быстрое размещение своего проекта</h1>
            </div>
        </div>
        <div class="carousel-item">
            <img class="d-block w-100"
                 src="https://4.bp.blogspot.com/-E5UdL9Atlq8/WdNVSfgjGTI/AAAAAAAABgo/8VBHbQ0fzT8359LGvW26KGUgg0bLgrcOgCLcBGAs/s1600/Easus-Free-Data-Recovery-Software-Review-1.jpg"
                 alt="Third slide">
            <div class="carousel-caption d-none d-md-block">
                <h1>Не дайте своему проекту пропасть</h1>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!--

JUMBOTRON

-->
<div class="jumbotron" style="margin-bottom: 0px">
    <h1 class="display-4" style="text-align: center">Приветствую тебя, мой новый друг</h1>
    <p class="lead" style="text-align: center">На данном ресурсе вы можете разместить идею своего проекта</p>
    <hr class="my-4">
    <p class="lead" style="text-align: center">
        <a style="text-align: center" class="btn btn-info btn-lg" href="/main" role="button">Просмотреть размещенные
            проекты</a>
    </p>
</div>
</body>
</html>