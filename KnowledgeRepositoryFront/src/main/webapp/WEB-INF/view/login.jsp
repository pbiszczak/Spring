<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Knowledge Repository v0.01 - Login Page</title>
    <link type="text/css"
          rel="stylesheet"
          href="https://bootswatch.com/4/darkly/bootstrap.min.css">
    <link type="text/css"
          rel="stylesheet"
          href="https://bootswatch.com/4/darkly/bootstrap.css">
    <script src="https://bootswatch.com/_vendor/jquery/dist/jquery.min.js"></script>
    <script src="https://bootswatch.com/_vendor/popper.js/dist/umd/popper.min.js"></script>

</head>
<body>
<div class="row">
    <div class="col-md-offset-2 col-sm-offset-2 col-sm-8 col-md-8">
<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
    <fieldset>
    <legend>Login</legend>
        <c:if test="${param.error != null}">
            <div class="alert alert-dismissible alert-danger">
                <strong>Oh snap!</strong>  Sorry, password or username is incorrect!
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="alert alert-dismissible alert-success">
                <strong>Well done!</strong>  You have been logged out.
            </div>
        </c:if>

    <div class="form-group">
        <label for="inputUsername">User name</label>
        <input type="text"  name="username" class="form-control" id="inputUsername" placeholder="Enter user name.">
    </div>
    <div class="form-group">
        <label for="inputPassword">Password</label>
        <input type="password"  name="password" aria-describedby="passwordHelp" class="form-control" id="inputPassword" placeholder="Enter your password.">
        <small id="emailHelp" class="form-text text-muted">We'll never ask for your password.</small>
    </div>
    <button type="submit" class="btn btn-success">Login</button>
    </fieldset>
</form:form>
    </div>
</div>

</body>

</html>