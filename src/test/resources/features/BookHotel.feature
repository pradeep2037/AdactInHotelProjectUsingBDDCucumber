Feature: Book a Hotel Validations

Background:
    
    Given  user should launch the application
     
    And user should be on "LoginPage"
    
    When user enters the username in the username filed "username" "pradeep264"
    
    And user enters the password in the password field "password" "pradeep264"
    
    When user should click on button "loginButton"
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Search Hotel"
    
    Given user should be on "SearchHotelPage"   
   
    When user selects hotel location as "location" "Sydney"
   
    And user selects hotel as "hotel" "Hotel Creek"
   
    And user selects hotel room type as "roomtype" "Standard"
   
    And user selects number of rooms "rooms" "2"
    
    And user enters checkIn date as "checkIn" "20/07/2025" 
   
    And user enters checkOut date as "checkOut" "22/07/2025"
   
    And user selects number of adults per room "adults" "1"
   
    And user should click on button "searchButton"
    
    
    @test9
    Scenario: Checking Logout functionality 
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Select Hotel"
    
    Given user should be on "SelectHotelPage"
    
    When user should select the hotel "selectHotel"
    
    And user should click on button "continueButton"
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Book A Hotel"
    
    Given user should be on "BookHotelPage"
    
    And user should enter the first name "firstName" "pradeep"
    
    And user should enter the last name "lastName" "levaku"
    
    And user should enter the billing address "address" "kadapa"
    
    And user should enter the credit card num "cardNum" "1234567890123456"
    
    And user should select credit card type "cardType" "VISA"
    
    And user should select expiry date "month" "5" and "year" "2016"
    
    And user should enter cvv number "cvv" "1234"
    
    And user should click on button "bookNowButton"
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Hotel Booking Confirmation"
    
    Given user should be on "BookingConfirmationPage"
    
    When user should click on button "logout"
    
    Then user should successfully logout from the application "Adactin.com - Logout"
    
    
    @test10
    Scenario: Adding 10% GST to the final price
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Select Hotel"
    
    Given user should be on "SelectHotelPage"
    
    When user should select the hotel "selectHotel"
    
    And user should click on button "continueButton"
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Book A Hotel"
    
    Given user should be on "BookHotelPage"
    
    Then final price should include 10% GST so "totalPrice" must equals to "billedPrice" 
    
    
    
    
    
    
    