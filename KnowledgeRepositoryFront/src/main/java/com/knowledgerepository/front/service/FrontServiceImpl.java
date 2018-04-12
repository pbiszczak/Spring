package com.knowledgerepository.front.service;

import com.knowledgerepository.back.dao.ProductDAO;
import com.knowledgerepository.back.entity.Product;
import com.knowledgerepository.back.model.BasketItemModel;
import com.knowledgerepository.back.model.BasketModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Service
public class FrontServiceImpl implements FrontService {

    private final HttpSession httpSession;
    private final ProductDAO productDAO;

    @Autowired
    public FrontServiceImpl(HttpSession httpSession, ProductDAO productDAO) {
        this.httpSession = httpSession;
        this.productDAO = productDAO;
    }

    @Override
    public BasketModel getBasketModel() {

        BasketModel basketModel = (BasketModel) httpSession.getAttribute(getBasketModelAttributeName());
        if (basketModel == null) {
            basketModel = new BasketModel();
        }

        return basketModel;
    }

    @Transactional
    public BasketModel addItemToBasketModel(int productId) {
        BasketModel basketModel = getBasketModel();
        BasketItemModel basketItemModel = new BasketItemModel();
        Product product = productDAO.findProductById(productId);

        basketItemModel.setProduct(product);
        basketItemModel.setProductCount(product.getQuantity());
        basketItemModel.setPrice(product.getPrice());
        basketItemModel.updateTotalPayment();

        basketModel.addItemToBasketItems(basketItemModel);
        basketModel.updateTotalPayment();
        return basketModel;
    }

    @Override
    public String getBasketModelAttributeName() {
        return "basket";
    }
}
