package com.knowledgerepository.front.controller;


import com.knowledgerepository.back.entity.User;
import com.knowledgerepository.back.model.BasketModel;
import com.knowledgerepository.back.model.CheckoutModel;
import com.knowledgerepository.back.model.UserModel;
import com.knowledgerepository.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"checkoutModel"})
public class CheckoutController {

    private final UserService userService;

    @Autowired
    public CheckoutController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/checkout")
    public String checkoutBasket(@ModelAttribute("checkoutModel") CheckoutModel checkoutModel, Model model) {

        model.addAttribute("title", "Checkout");
        model.addAttribute("checkoutForm", checkoutModel.getCheckoutForm());
        model.addAttribute("userClickCheckout", true);

        return "page";
    }

    @RequestMapping("/finalizeCheckout")
    public String finalizeCheckout(@ModelAttribute("checkoutModel") CheckoutModel checkoutModel, Model model) {

        model.addAttribute("title", "Finalize Checkout");
        model.addAttribute("userClickFinalizeCheckout", true);

        return "page";
    }

    @ModelAttribute("checkoutModel")
    public CheckoutModel buildCheckoutModel(@ModelAttribute("basket") BasketModel basketModel) {
        CheckoutModel checkoutModel = new CheckoutModel();
        checkoutModel.setBasketModel(basketModel);

        checkoutModel.setUser(buildCurrentUser());

        checkoutModel.setupBasicOrderDetails();
        checkoutModel.setupCheckoutForm();

        return checkoutModel;
    }


    public void saveOrder(@ModelAttribute("basket") BasketModel basketModel) {


        // return checkoutModel;
    }

    private UserModel buildCurrentUser() {
        org.springframework.security.core.userdetails.User sessionUser =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findUserByEmailAndFetchAddresses(sessionUser.getUsername());

        return new UserModel.Builder()
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withEmail(user.getEmail())
                .withContactNumber(user.getContactNumber())
                .withAddresses(user.getAddresses())
                .build();
    }
}
