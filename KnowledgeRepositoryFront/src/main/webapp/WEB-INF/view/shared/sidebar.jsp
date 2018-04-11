<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="my-4">Shop Name</h1>


<div class="list-group">

    <c:forEach var="category" items="${categories}">
        <a href="${contextRoot}/products/category/${category.id}/page/1" class="list-group-item" id="a_${category.name}">${category.name}</a>
    </c:forEach>


</div>
