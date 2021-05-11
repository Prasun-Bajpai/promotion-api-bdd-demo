package com.intigral.api.steps;

import com.intigral.api.pojo.Promotion;
import com.intigral.api.pojo.PromotionAPIExpectedErrorResponse;
import com.intigral.api.pojo.Promotions;
import com.intigral.api.pojo.Properties;
import com.intigral.api.utils.PromotionAPIHelper;
import com.intigral.api.utils.PromotionConstant;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static com.intigral.api.utils.PromotionAPIHelper.getPromotionObjects;

/**
 * @author bajpaip
 *
 */
public class PromotionAPISteps {


    private static final String PROMOTION_API_URI = "promotions";
    List<String> propertiesProgramType = new ArrayList<>();

    public List<String> getPropertiesProgramType() {
        return propertiesProgramType;
    }

    public void setPropertiesProgramType(List<String> propertiesProgramType) {
        this.propertiesProgramType = propertiesProgramType;
    }

    Response response;

    @Given("^a rest api to get promotion details with API URL$")
    public void givenPromotionAPIUrl() {
    }

    @When("^valid api key provided(.*)")
    public void givenValidAPIKey(String apiKey) {
        response = PromotionAPIHelper.getAPIResponse(PromotionConstant.API_KEY, apiKey, PromotionConstant.BASE_URI, PROMOTION_API_URI);
    }

    @When("^invalid api key provided(.*)")
    public void givenInValidAPIKey(String apiKey) {
        response = PromotionAPIHelper.getAPIResponse(PromotionConstant.API_KEY, apiKey, PromotionConstant.BASE_URI, PROMOTION_API_URI);
    }

    @Then("response status code should be (\\d+)")
    public void validateResponseCode(int statusCode) {
        Assert.assertEquals("HTTP Status Code should be valid", statusCode, response.getStatusCode());
    }

    @And("^response body attribute should contain mandatory promotion attributes$")
    public void validateResponseBody() throws Exception {
        Promotions allPromotions = getPromotionObjects(response);
        Assert.assertNotNull("No promotions found ..!!!", allPromotions);
        for (Promotion promotion : allPromotions.getPromotions()) {

            Assert.assertFalse("Promotion Id does not exists...!!!", promotion.getPromotionId().isEmpty());
            Assert.assertNotNull("Order Id does not exists...!!!", promotion.getOrderId());
            Assert.assertFalse("Promo Area does not exists...!!!", promotion.getPromoArea().isEmpty());
            Assert.assertFalse("Promo Type does not exists...!!!", promotion.getPromoType().isEmpty());
            Assert.assertTrue("Show Prices does not have a valid value. It can be either true or false...!!!", promotion.isShowPrice() == true || promotion.isShowPrice() == false);
            Assert.assertEquals("Show Text does not have a valid value. It can be either true or false...!!!", promotion.isShowText() == true || promotion.isShowText() == false, true || false);
            Assert.assertNotNull("Localized Text does not exist...!!!", promotion.getLocalizedTexts());
            Assert.assertFalse("Localized Text - ar does not exist...!!!", promotion.getLocalizedTexts().getAr().isEmpty());
            Assert.assertFalse("Localized Text - en does not exist...!!!", promotion.getLocalizedTexts().getEn().isEmpty());
        }
    }

    @And("^expectedProgramType for promotion properties$")
    public void populatePropertiesForPromotion(List<String> propertiesProgramType)  {
        setPropertiesProgramType(propertiesProgramType);
    }

    @And("^response should contain valid programType$")
    public void validatePromotionAttributes(List<Promotion> expectedPromotions) {

        List<String> expectedPropertiesProgramType = getPropertiesProgramType();
        Promotions allPromotions = getPromotionObjects(response);
        for (Promotion promotion : allPromotions.getPromotions()) {
            Assert.assertTrue("Promotion Id is not a string", Pattern.matches("[a-zA-Z\\s\\.]+", promotion.getPromotionId()));
            for (Properties properties : promotion.getProperties()) {
                Assert.assertTrue("Program Type does not contain valid value for Promotion Id : "+promotion.getPromotionId(), expectedPropertiesProgramType.contains(properties.getProgramType()));
            }
        }
    }

    @And("^response body attribute should contain error$")
    public void validateErrorResponseBody(List<PromotionAPIExpectedErrorResponse> expectedResponse)  {
        Promotions allPromotions = getPromotionObjects(response);
        Assert.assertNotNull("No promotions found ..!!!", allPromotions);
        for (PromotionAPIExpectedErrorResponse promotionAPIExpectedResponse : expectedResponse) {
            Assert.assertNotNull("Request Id should not be null...!!!",allPromotions.getError().getRequestId());
            Assert.assertEquals("Code should be 8001...!!!",allPromotions.getError().getCode(), promotionAPIExpectedResponse.getErrorCode() );
            Assert.assertEquals("Message should be - invalid api key...!!!",allPromotions.getError().getMessage(), promotionAPIExpectedResponse.getErrorMessage());
        }
    }
}
