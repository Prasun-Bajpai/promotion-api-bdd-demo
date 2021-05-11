package com.intigral.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intigral.api.pojo.Promotions;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * @author bajpaip
 *
 */
public class PromotionAPIHelper {

    public static Response getAPIResponse(String apiKey, String apiKeyParameter, String baseUri, String apiUri) {
        return given().param(apiKey, apiKeyParameter).
                when().get(baseUri + apiUri).
                then().extract().response();
    }

    public static Promotions getPromotionObjects(Response response) {
        Promotions allPromotions = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            allPromotions = objectMapper.readValue(response.asString(), Promotions.class);
        } catch (Exception e) {
        }
        return allPromotions;
    }

}
