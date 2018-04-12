package com.knowledgerepository.front.service;

import com.knowledgerepository.back.model.BasketModel;

public interface FrontService {
    BasketModel getBasketModel();

    BasketModel addItemToBasketModel(int productId);

    String getBasketModelAttributeName();
}
