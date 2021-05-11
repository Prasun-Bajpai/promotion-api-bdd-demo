package com.intigral.api.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author bajpaip
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-reports"},
        features = {
                "classpath:Features/Promotion_API_Test_Scenario.feature"
        },
        glue = "com.intigral.api.steps",
        tags = {
                "@API_Test"
        })
public class PromotionAPIRunnerTest {

}
