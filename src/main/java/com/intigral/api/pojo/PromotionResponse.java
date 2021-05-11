package com.intigral.api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bajpaip
 *
 */

public class PromotionResponse {

    @JsonProperty("promotions")
    List<Promotion> promotions = new ArrayList<>();

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

}
