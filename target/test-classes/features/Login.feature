Feature: Login Funtionality For Hotel Reservation Application

  @test1
  Scenario: Verify login functionality with valid credentials
    
    Given  user should launch the application
    
    And user should be on "LoginPage"
      
    When user enters the username in the username filed "username" "pradeep264"
    
    And user enters the password in the password field "password" "pradeep264"
    
    When user should click on button "loginButton"
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Search Hotel"
    

    
    
    
 