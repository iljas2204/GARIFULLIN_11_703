<html>
<head>
    <title>Profile</title>
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
    <#if (cookie)??>
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group mr-2" role group><a href="/edit" class="btn btn-outline-info">Edit profile</a>
        </div>
    </div>
    </#if>
</nav>
<div class="card text-center">
    <div class="card-header">
        Profile
    </div>
    <div class="card-body">
            <#if (user.get().getLogin())??>
            <h5 class="card-title">Login: ${user.get().getLogin()}
            </#if>
    </h5>
            <#if (user.get().getEmail())??>
            <h5 class="card-title">Email: ${user.get().getEmail()}
            </h5></#if>
            <#if (user.get().getFirstName())??>
            <h5 class="card-title">First Name: ${user.get().getFirstName()}
            </h5></#if>
            <#if (user.get().getLastName())??>
            <h5 class="card-title">Last Name: ${user.get().getLastName()}
            </h5></#if>
            <#if (user.get().getGit())??>
            <h5 class="card-title">GitHub: ${user.get().getGit()}
            </h5></#if>
    </div>
</div>
<br>
<div class="container">
    <div class="row">
        <div class="card-columns" id="cardColumns">
                <#list products as product>
                    <div class="card text-center border-info mb-3" style="max-width: 21rem; min-width: 21rem">
                        <div class="card-header" style="align-content: center"><h4><a
                                href="/project?productId=${product.getId()}">${product.getName()}
                        </a></h4></div>
                        <div class="card-body text-info">
                            <p class="card-title">${product.getSmallInfo()}
                            </p>
                        </div>
                    </div>
                </#list>
        </div>
    </div>
</div>
</body>
</html>