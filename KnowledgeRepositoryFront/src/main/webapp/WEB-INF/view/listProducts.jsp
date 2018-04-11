<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" style="margin-top: 80px">

    <div class="row">

        <div class="col-lg-3" style="padding-top: 20px">

            <jsp:include page="shared/sidebar.jsp"/>

        </div>

        <div class="col-lg-9">

            <div class="col-lg-12">

                <c:if test="${userClickAllProducts == true}">


                    <ol class="breadcrumb">

                        <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                        <li class="breadcrumb-item active">All Products</li>





                    </ol>


                </c:if>

                <c:if test="${userClickCategoryProducts == true}">


                    <ol class="breadcrumb">

                        <li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
                        <li class="breadcrumb-item">Category</li>
                        <li class="breadcrumb-item active">${category.name}</li>

                    </ol>


                </c:if>

                <div class="bs-component">
                    <jsp:include page="shared/pagination.jsp"/>

                </div>
                <div class="card card-outline-secondary my-4">
                    <div class="card-header">
                        ${category.name}
                    </div>


                    <div class="card-body">


                        <table class="table table-hover">


                            <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Brand</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>

                                <c:if test="${not empty pageContext.request.userPrincipal}">

                                    <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                                        <th scope="col">

                                        </th>
                                    </c:if>

                                </c:if>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="product" items="${products}">
                                <c:url var="deleteProductLink" value="/delete/product/${product.id}">
                                    <c:param name="urlPath" value="${urlPath}1"/>
                                </c:url>

                                <tr>
                                    <td>${product.id}</td>
                                    <td>${product.name}</td>
                                    <td>${product.brand}</td>
                                    <td>${product.price}</td>
                                    <td>${product.quantity}</td>

                                    <c:if test="${not empty pageContext.request.userPrincipal}">

                                        <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                                            <th scope="col">
                                                <a href="${deleteProductLink}" class="btn btn-danger" role="button"
                                                   onclick="if (!(confirm('Are your sure?'))) return false">Delete</a>
                                            </th>
                                        </c:if>

                                    </c:if>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>


                    </div>


                </div>

            </div>
        </div>
    </div>
</div>
