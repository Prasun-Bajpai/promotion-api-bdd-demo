package com.intigral.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.*;

/**
 * @author bajpaip
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "promotionId",
        "orderId",
        "promoArea",
        "promoType",
        "showPrice",
        "showText",
        "localizedTexts",
        "properties",
        "images"
})

public class Promotion {

    @JsonProperty("promotionId")
    private String promotionId;

    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty("promoArea")
    private List<String> promoArea = new ArrayList<>();

    @JsonProperty("promoType")
    private String promoType;

    @JsonProperty("showPrice")
    private boolean showPrice;

    @JsonProperty("showText")
    private boolean showText;

    @JsonProperty("localizedTexts")
    private LocalizedTexts localizedTexts;

    @JsonProperty("properties")
    private List<Properties> properties = new ArrayList<>();

    @JsonProperty("images")
    private List<Images> images = new ArrayList<>();

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<String> getPromoArea() {
        return promoArea;
    }

    public void setPromoArea(List<String> promoArea) {
        this.promoArea = promoArea;
    }

    public String getPromoType() {
        return promoType;
    }

    public void setPromoType(String promoType) {
        this.promoType = promoType;
    }

    public boolean isShowPrice() {
        return showPrice;
    }

    public void setShowPrice(boolean showPrice) {
        this.showPrice = showPrice;
    }

    public boolean isShowText() {
        return showText;
    }

    public void setShowText(boolean showText) {
        this.showText = showText;
    }

    public LocalizedTexts getLocalizedTexts() {
        return localizedTexts;
    }

    public void setLocalizedTexts(LocalizedTexts localizedTexts) {
        this.localizedTexts = localizedTexts;
    }

    public List<Properties> getProperties() {
        return properties;
    }

    public void setProperties(List<Properties> properties) {
        this.properties = properties;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getPromoAreaInString()
    {
        final StringBuilder string=new StringBuilder();
        getPromoArea().stream().forEach(s ->
        {
            string.append(s);
            string.append(" ");

        });
        return string.toString();
    }
}
