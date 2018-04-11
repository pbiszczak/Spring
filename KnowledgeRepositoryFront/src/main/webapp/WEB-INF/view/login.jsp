<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container" style="margin-top: 80px">

    <div class="row">

        <div class="col-lg-12">

            <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
                <fieldset>
                    <legend>Login</legend>
                    <c:if test="${param.error != null}">
                        <div class="alert alert-dismissible alert-danger">
                            <strong>Oh snap!</strong> Sorry, password or username is incorrect!
                        </div>
                    </c:if>
                    <c:if test="${param.logout != null}">
                        <div class="alert alert-dismissible alert-success">
                            <strong>Well done!</strong> You have been logged out.
                        </div>
                    </c:if>

                    <div class="form-group">
                        <label for="inputUsername">User name</label>
                        <input type="text" name="username" class="form-control" id="inputUsername"
                               placeholder="Enter user name.">
                    </div>
                    <div class="form-group">
                        <label for="inputPassword">Password</label>
                        <input type="password" name="password" aria-describedby="passwordHelp" class="form-control"
                               id="inputPassword" placeholder="Enter your password.">
                        <small id="emailHelp" class="form-text text-muted">We'll never ask for your password.</small>
                    </div>
                    <button type="submit" class="btn btn-success">Login</button>
                </fieldset>
            </form:form>
        </div>
    </div>
</div>
