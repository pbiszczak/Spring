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

                <div class="card card-outline-secondary my-4">
                    <div class="card-header">
                        ${category.name}
                    </div>


                    <div class="card-body">
                    </div>


                </div>

            </div>
        </div>
    </div>


</div>


</div>