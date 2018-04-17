package com.knowledgerepository.back.model;

import com.knowledgerepository.back.entity.Address;
import com.knowledgerepository.back.entity.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CheckoutModel {

    private UserModel user;
    private OrderDetail orderDetail;
    private BasketModel basketModel;
    private CheckoutForm checkoutForm;


    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }


    public void setupBasicOrderDetails() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setDate(getLocalDate());

        orderDetail.setItemCount(basketModel.getNumberOfItems());
        orderDetail.setTotalPayment(basketModel.getTotalPayment());

        this.orderDetail = orderDetail;


    }

    public BasketModel getBasketModel() {
        return basketModel;
    }

    public void setBasketModel(BasketModel basketModel) {
        this.basketModel = basketModel;
    }

    public CheckoutForm getCheckoutForm() {
        return checkoutForm;
    }

    public void setCheckoutForm(CheckoutForm checkoutForm) {
        this.checkoutForm = checkoutForm;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public void setupCheckoutForm() {
        CheckoutForm checkoutForm = new CheckoutForm();
        checkoutForm.setupUserAddresses();
        checkoutForm.setupPaymentMethods();

        this.checkoutForm = checkoutForm;
    }


    public Date getLocalDate() {
        return new Date();
    }

    public class CheckoutForm {

        private List<Address> userAddresses;
        private List<String> paymentMethods;
        private Address selectedBillingAddress;
        private Address selectedShippingAddress;
        private String selectedPaymentMethod;

        private CheckoutForm() {
            this.userAddresses = new ArrayList<>();
            this.paymentMethods = new ArrayList<>();
        }


        private void setupPaymentMethods() {
            this.paymentMethods.add("Credit Card");
            this.paymentMethods.add("PayPal");
            this.paymentMethods.add("Skrill");
        }

        private void setupUserAddresses() {
            this.userAddresses = CheckoutModel.this.user.getAddresses();
        }

        public Address getSelectedBillingAddress() {
            return selectedBillingAddress;
        }

        public void setSelectedBillingAddress(Address selectedBillingAddress) {
            this.selectedBillingAddress = selectedBillingAddress;
        }

        public Address getSelectedShippingAddress() {
            return selectedShippingAddress;
        }

        public void setSelectedShippingAddress(Address selectedShippingAddress) {
            this.selectedShippingAddress = selectedShippingAddress;
        }

        public List<String> getPaymentMethods() {
            return paymentMethods;
        }

        public void setPaymentMethods(List<String> paymentMethods) {
            this.paymentMethods = paymentMethods;
        }

        public String getSelectedPaymentMethod() {
            return selectedPaymentMethod;
        }

        public void setSelectedPaymentMethod(String selectedPaymentMethod) {
            this.selectedPaymentMethod = selectedPaymentMethod;
        }

        public List<Address> getUserAddresses() {
            return userAddresses;
        }

        public void setUserAddresses(List<Address> userAddresses) {
            this.userAddresses = userAddresses;
        }
    }
}
