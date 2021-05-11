package com.intigral.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * @author bajpaip
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ar",
        "en"
})
public class LocalizedTexts {
    @JsonProperty("ar")
    private List<String> ar;

    @JsonProperty("en")
    private List<String> en;

    public List<String> getAr() {
        return ar;
    }

    public void setAr(List<String> ar) {
        this.ar = ar;
    }

    public List<String> getEn() {
        return en;
    }

    public void setEn(List<String> en) {
        this.en = en;
    }
}
