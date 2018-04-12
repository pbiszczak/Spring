package com.knowledgerepository.back.dao;

import com.knowledgerepository.back.entity.Basket;


public interface BasketDAO {

    void saveBasket(Basket basket);

    Basket findBasketById(int id);

    void deleteBasketById(int id);
}
