@API_Test
Feature: To verify Promotion API response
@validApiKeyScenario
Scenario Outline: To verify Promotion API with Valid API Key and validate mandatory promotion attributes
Given a rest api to get promotion details with API URL
When valid api key provided<apiKey>
Then response status code should be <statusCode>
And response body attribute should contain mandatory promotion attributes

Examples:
|scenarioID|apiKey |statusCode|
|SUCCESS_1| GDMSTGExy0sVDlZMzNDdUyZ | 200|

  @InvalidApiKeyScenario
  Scenario Outline: To verify Promotion API with Invalid API Key
    Given a rest api to get promotion details with API URL
    When invalid api key provided<apiKey>
    Then response status code should be <statusCode>
    And response body attribute should contain error
      |errorCode|errorMessage|
      |<errorCode>|<errorMessage>|

    Examples:
      |scenarioID|apiKey |statusCode|errorCode|errorMessage|
      |ERROR_1| 123 | 403|   8001                       | invalid api key       |
      |ERROR_2| 1234567 | 403|   8001                       | invalid api key       |
      |ERROR_3| ABCSDE | 403|   8001                       | invalid api key       |

  @validateProgramType
  Scenario Outline: To verify Promotion API with Valid API Key and validate program Type
    Given a rest api to get promotion details with API URL
    When valid api key provided<apiKey>
    Then response status code should be <statusCode>
    And expectedProgramType for promotion properties
      |movie|
      |series|
      |episode|
      |season|
    And response body attribute should contain mandatory promotion attributes
    And response should contain valid programType
      |promotionId|orderId|promoArea|promoType|showPrice|showText|localizedTexts|properties|images|
      |<promotionId>|<orderId>|<promoArea>|<promoType>|<showPrice>|<showText>|  |          |      |

    Examples:
      |scenarioID|apiKey |statusCode|errorCode|errorMessage|promotionId  | orderId | promoArea | promoType | showPrice | showText |
      |Error_1| GDMSTGExy0sVDlZMzNDdUyZ | 200|      |            |Nurses|29|IND|SERIES|false|false|
