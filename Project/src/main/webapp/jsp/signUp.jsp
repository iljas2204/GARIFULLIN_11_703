<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <style>
        @import url("/css/style.css");
    </style>
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
                <label for="login">Login</label>
                <input name="login" type="text" class="form-control" id="login" aria-describedby="emailHelp"
                       placeholder="Enter login" style="border:1px solid #17a2b8">
            </div>
            <div class="form-group col-md-6">
                <label for="password">Password</label>
                <input name="password" type="password" class="form-control" id="password" placeholder="Password"
                       style="border:1px solid #17a2b8">
                <br>
                <a href="home" class="btn btn-outline-info">Back to home</a>
                <button type="submit" class="btn btn-outline-info">Sign Up</button>
            </div>
        </form-row>
    </form>
</div>
</body>
</html>