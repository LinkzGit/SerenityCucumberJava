Feature: Form Submission


  Scenario: Fill and submit the form
    Given I navigate to DemoQA
    Then I can click on the Forms option
    And Fill out the form
    And Submit
    Then I can check that it worked with no errors

  #Scenario: Fill Login
  #  Given I go to Swag Landing Page
   # And I try to login
    #Then I can see the products
