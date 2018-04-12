<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container" style="margin-top: 80px">

    <div class="row">

        <div class="col-lg-12">

            <div class="card-body">


                <table class="table table-hover">


                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Count</th>
                        <th scope="col">Total Payment For Item</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${basketItems}">

                        <tr>
                            <td>${item.product.name}</td>
                            <td>${item.price}</td>
                            <td>${item.productCount}</td>
                            <td>${item.totalPayment}</td>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>


            </div>
            <h1>Total Payment For All Products: <b>${basket.totalPayment}</b></h1>
        </div>
    </div>
</div>
