<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<spring:url var="css" value="/resources/css/"/>
<spring:url var="js" value="/resources/js/"/>
<spring:url var="images" value="/resources/images/"/>

<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Knowledge Repository - ${title} -Books, tutorials, courses  </title>

    <script>
        window.menu= '${title}';
    </script>

    <link type="text/css"
          rel="stylesheet"
          href="${css}bootstrap.min.css">

    <link type="text/css"
          rel="stylesheet"
          href="${css}bootstrap.css">

    <link type="text/css"
          rel="stylesheet"
          href="${css}custom.css">


</head>
<body>
<div class="container fill">
<!-- Navigation -->
    <jsp:include page="shared/navbar.jsp"/>

<!-- Page Content -->
<c:if test="${userClickHome == true}">
        <jsp:include page="home.jsp"/>
</c:if>

<c:if test="${userClickAbout == true}">
    <jsp:include page="about.jsp"/>
</c:if>

<c:if test="${userClickContact == true}">
    <jsp:include page="contact.jsp"/>
</c:if>

<c:if test="${userClickAllProducts == true or userClickCategoryProducts}">
    <jsp:include page="listProducts.jsp"/>
</c:if>



<!-- Footer -->
    <jsp:include page="shared/footer.jsp"/>

<!-- Bootstrap core JavaScript -->
<script src="${js}bootstrap.min.js"></script>
<script src="${js}jquery.min.js"></script>
<script src="${js}popper.min.js"></script>
<script src="${js}custom.js"></script>

    </div>
</div>
</body>

</html>