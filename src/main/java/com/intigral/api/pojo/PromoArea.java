package com.intigral.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bajpaip
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "home"
})

public class PromoArea {
    @JsonProperty("home")
    private Map<String,String> promoArea=new HashMap<>();

    public Map<String, String> getPromoArea() {
        return promoArea;
    }

    public void setPromoArea(Map<String, String> promoArea) {
        this.promoArea = promoArea;
    }
}
