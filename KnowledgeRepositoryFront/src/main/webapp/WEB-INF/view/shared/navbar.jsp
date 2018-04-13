<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Knowledge Repository</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item" id="home">
                    <a class="nav-link" href="${contextRoot}/home">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item" id="about">
                    <a class="nav-link" href="${contextRoot}/about">About</a>
                </li>
                <li class="nav-item" id="allProducts">
                    <a class="nav-link" href="${contextRoot}/products/all/page/1">View Products</a>
                </li>
                <li class="nav-item" id="contact">
                    <a class="nav-link" href="${contextRoot}/contact">Contact</a>
                </li>

                <c:if test="${pageContext.request.isUserInRole('USER')}">
                    <li class="nav-item" id="basket">
                        <span class="badge badge-warning"><a class="nav-link" href="${contextRoot}/basket">
                            <span class="glyphicon glyphicon-shopping-cart"></span><span style="padding: 0 8px;">Basket Items:</span><b>${basket.numberOfItems}</b></a>
                        </span>
                    </li>
                </c:if>

                <li class="nav-item" id="login">
                    <c:choose>
                        <c:when test="${not empty pageContext.request.userPrincipal}">
                            <a class="nav-link" href="#">Welcome <b>${pageContext.request.userPrincipal.name}</b>!</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="${contextRoot}/login">Login</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
    </div>
</nav>