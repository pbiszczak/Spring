package com.knowledgerepository.back.model;

import org.springframework.stereotype.Component;

@Component
public class ListProductsForm {

    private Integer formProductCount;

    public Integer getFormProductCount() {
        return formProductCount;
    }

    public void setFormProductCount(Integer formProductCount) {
        this.formProductCount = formProductCount;
    }
}
