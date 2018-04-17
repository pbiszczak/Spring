<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container" style="margin-top: 80px">

    <ol class="breadcrumb">
        <li class="breadcrumb-item active">Checkout</li>
    </ol>

    <div class="row">


        <div class="col-sm-12 col-md-4 order-md-2">

            <c:url var="finalizeCheckout" value="/finalizeCheckout">
            </c:url>
            <form:form modelAttribute="checkoutModel.checkoutForm"
                       action="${finalizeCheckout}" method="get">

            <ul class="list-group">
                <c:forEach var="item" items="${checkoutModel.basketModel.basketItems}">


                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        <b class="text-warning">${item.productCount} x</b> ${item.product.name}
                        <span class="badge badge-primary badge-pill">${item.price} $</span>
                    </li>


                </c:forEach>
                <li class="list-group-item d-flex justify-content-between align-items-center active">
                    Total items
                    <span class="badge badge-primary badge-pill"><b
                            class="text-success">${checkoutModel.basketModel.numberOfItems}</b></span>
                </li>

                <li class="list-group-item d-flex justify-content-between align-items-center active">
                    Total price
                    <span class="badge badge-primary badge-pill"><b
                            class="text-success">${checkoutModel.basketModel.totalPayment} $</b></span>
                </li>

            </ul>
        </div>


        <div class="col-sm-12 col-md-8 order-md-1">


            <div class="card text-white bg-success mb-3" style="max-width: 95%;">
                <div class="card-header">Client</div>
                <div class="card-body">
                    <h4 class="card-title">Client Info</h4>
                    <p class="card-text">
                    <div class="form-group row">
                        <label for="userfirstName" class="col-sm-2 col-form-label">First Name</label>
                        <div class="col-sm-10">
                            <input type="text" readonly="" class="form-control-plaintext" id="userfirstName"
                                   value="${checkoutModel.user.firstName}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="userlastName" class="col-sm-2 col-form-label">Last Name</label>
                        <div class="col-sm-10">
                            <input type="text" readonly="" class="form-control-plaintext" id="userlastName"
                                   value="${checkoutModel.user.lastName}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="userEmail" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="text" readonly="" class="form-control-plaintext" id="userEmail"
                                   value="${checkoutModel.user.email}">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="userContactNumber" class="col-sm-2 col-form-label">Contact Number</label>
                        <div class="col-sm-10">
                            <input type="text" readonly="" class="form-control-plaintext" id="userContactNumber"
                                   value="${checkoutModel.user.contactNumber}">
                        </div>
                    </div>


                    </p>
                </div>
            </div>


            <div class="card text-white bg-success mb-3" style="max-width: 95%;">
                <div class="card-header">Addresses</div>
                <fieldset class="card-body">
                    <h4 class="card-title">Billing & Shipping Address</h4>
                    <p class="card-text">


                    <div class="col-lg-6">

                        <legend>Billing Address</legend>


                        <fieldset class="form-group">

                            <c:forEach var="address" items="${checkoutModel.checkoutForm.userAddresses}">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <form:radiobutton class="form-check-input" path="selectedBillingAddress"
                                                          value="${address.id}"/>
                                            ${address}
                                    </label>
                                </div>

                            </c:forEach>

                        </fieldset>


                    </div>
                    <div class="col-lg-6">

                        <legend>Shipping Address</legend>


                        <fieldset class="form-group">

                            <c:forEach var="address" items="${checkoutModel.checkoutForm.userAddresses}">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <form:radiobutton class="form-check-input" path="selectedShippingAddress"
                                                          value="${address.id}"/>
                                            ${address}
                                    </label>
                                </div>
                            </c:forEach>
                        </fieldset>


                    </div>
                </fieldset>
            </div>


            <div class="card text-white bg-success mb-3" style="max-width: 95%;">
                <div class="card-header">Payment</div>
                <div class="card-body">
                    <h4 class="card-title">Select payment method</h4>
                    <p class="card-text">

                        <form:select path="selectedPaymentMethod">
                            <c:forEach var="method" items="${checkoutModel.checkoutForm.paymentMethods}">
                                <form:option value="${method}">${method}</form:option>
                            </c:forEach>
                        </form:select>

                        <button type="submit" class="btn btn-primary">Finalize Checkout</button>

                    </p>
                </div>
            </div>

        </div>


        </form:form>

    </div>
</div>

