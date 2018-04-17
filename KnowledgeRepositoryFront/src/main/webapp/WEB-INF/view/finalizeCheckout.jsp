<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container" style="margin-top: 80px">

    <ol class="breadcrumb">
        <li class="breadcrumb-item active">Your order has been received.</li>
    </ol>

    <div class="row">


        <div class="col-sm-12 col-xl-12">

            <c:url var="finalizeCheckout" value="/finalizeCheckout">
            </c:url>
            <form>

                <div class="card text-white bg-success mb-3" style="max-width: 95%;">
                    <div class="card-header">Order</div>
                    <div class="card-body">
                        <h4 class="card-title">Order summary</h4>
                        <p class="card-text">


                        <div class="form-group row">
                            <label for="totalItems" class="col-sm-2 col-form-label">Total items</label>
                            <div class="col-sm-10">
                                <input type="text" readonly="" class="form-control-plaintext" id="totalItems"
                                       value="${checkoutModel.basketModel.numberOfItems}">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="totalPayment" class="col-sm-2 col-form-label">Total price</label>
                            <div class="col-sm-10">
                                <input type="text" readonly="" class="form-control-plaintext" id="totalPayment"
                                       value="${checkoutModel.basketModel.totalPayment} $">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="paymentMethod" class="col-sm-2 col-form-label">Payment method</label>
                            <div class="col-sm-10">
                                <input type="text" readonly="" class="form-control-plaintext" id="paymentMethod"
                                       value="${checkoutModel.checkoutForm.selectedPaymentMethod}">
                            </div>
                        </div>


                        </p>
                    </div>
                </div>


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
                                       value=" ${checkoutModel.user.contactNumber}">
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

                            <div class="form-group row">
                                <label for="billingAddress" class="col-sm-2 col-form-label">Address</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly="" class="form-control-plaintext" id="billingAddress"
                                           value="${checkoutModel.checkoutForm.selectedBillingAddress}">
                                </div>
                            </div>


                        </div>
                        <div class="col-lg-6">

                            <legend>Shipping Address</legend>

                            <div class="form-group row">
                                <label for="shippingAddress" class="col-sm-2 col-form-label">Address</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly="" class="form-control-plaintext" id="shippingAddress"
                                           value="${checkoutModel.checkoutForm.selectedShippingAddress}">
                                </div>
                            </div>

                        </div>
                    </fieldset>
                </div>


            </form>
        </div>

    </div>
</div>

