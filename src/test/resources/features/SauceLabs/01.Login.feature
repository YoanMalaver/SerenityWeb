Feature: Login

  Rule: Customer need to provide valid credentials to access the product catalog
      @test
      Scenario: Colin log in with valid credentials
        Given Colin is on the login page
        When Colin logs in with valid credentials
        Then she should be presented with the product catalog

