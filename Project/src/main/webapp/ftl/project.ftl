<html>
<head>
    <title>Project</title>
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
            <a class="nav-item nav-link active" href="/home">Home</a>
            <a class="nav-item nav-link active" href="/main">Look Projects</a>
        </div>
    </div>
</nav>
<div class="jumbotron text-center" style="margin-bottom: 0px">
    <h1 class="display-4" style="text-align: center">${product.get().getName()}
    </h1>
    <p class="lead" style="text-align: center">${product.get().getSmallInfo()}
    </p>
    <hr class="my-4">
    <p>${product.get().getFullInfo()}
    </p>
    <p class="lead" style="text-align: center">
        <a href="/main" style="text-align: center" class="btn btn-info btn-lg">Back to projects</a> <a
            style="text-align: center" class="btn btn-info btn-lg"
            href="/profile?userId=${product.get().getUserId()}"
            role="button">See user's profile</a>
    </p>
</div>
</body>
</html>
