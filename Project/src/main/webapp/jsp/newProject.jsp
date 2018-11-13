<%@ page import="ru.itis.project.services.UsersService" %>
<%@ page import="ru.itis.project.models.User" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Project</title>
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
<% String cookie = "";
    Cookie[] cookies = request.getCookies();
    ServletContext context = config.getServletContext();
    UsersService usersService = (UsersService) context.getAttribute("usersService");
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {

            if (cookies[i].getName().equals("auth")) {
                cookie = cookies[i].getValue();
            }
        }
        Optional<User> user = usersService.Login(cookie);%>
<!--

NAVBAR

-->
<nav class="navbar navbar-expand-lg navbar-light">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="/home">Home <span
                    class="sr-only">(current)</span></a>
            <a class="nav-item nav-link active" href="/main">Look Projects</a>
        </div>
    </div>
</nav>
<br>
<div class="container" align="center">
    <form method="post">
        <form-row>
            <div class="form-group col-md-6">
                <label for="name">Name</label>
                <input name="name" class="form-control" id="name" aria-describedby="emailHelp"
                       placeholder="Name of project" style="border:1px solid #17a2b8">
            </div>
            <div class="form-group col-md-6">
                <label for="smallInfo">Small info</label>
                <input name="smallInfo" class="form-control" id="smallInfo" aria-describedby="emailHelp"
                       placeholder="Enter small info" style="border:1px solid #17a2b8">
            </div>
            <div class="form-group col-md-6">
                <label for="fullInfo">Full info</label>
                <input name="fullInfo" class="form-control" id="fullInfo" aria-describedby="emailHelp"
                       placeholder="Enter full info" style="border:1px solid #17a2b8">
            </div>
            <div class="form-group col-md-6">
                <label for="userId" style="visibility: hidden">Full info</label>
                <input name="userId" style="visibility: hidden" value="<%=user.get().getId()%>" class="form-control"
                       id="userId" aria-describedby="emailHelp"
                       placeholder="Enter full info" style="border:1px solid #17a2b8">
            </div>
            <div class="form-group col-md-6">
                <a href="/main" class="btn btn-outline-info">Back to look projects</a>
                <button type="submit" class="btn btn-outline-info">Create</button>
            </div>
        </form-row>
    </form>
</div>
<%}%>
</body>
</html>
