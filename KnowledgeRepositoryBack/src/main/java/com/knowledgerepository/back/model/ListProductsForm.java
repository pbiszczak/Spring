package com.knowledgerepository.back.model;

import org.springframework.stereotype.Component;

@Component
public class ListProductsForm {

    private Integer selectedProductCountValue;

    public Integer getSelectedProductCountValue() {
        return selectedProductCountValue;
    }

    public void setSelectedProductCountValue(Integer selectedProductCountValue) {
        this.selectedProductCountValue = selectedProductCountValue;
    }
}
