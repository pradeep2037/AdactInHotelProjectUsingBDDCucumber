Feature: Hotel Search Validations
  
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
   
    And user selects number of rooms "rooms" "1"
    
    
   @test2
   Scenario: Verifying CheckOut date should be later than CheckIn date
   
   
   And user enters checkIn date as "checkIn" "2025-07-10" 
   
   And user enters checkOut date as "checkOut" "2025-07-05"
   
   And user selects number of adults per room "adults" "1"
   
   And user should click on button "searchButton"
   
   Then system should show error like "error" "Check-In Date shall be before than Check-Out Date"
   
  
   @test3
   Scenario: verifying system should throw an appropriate error if we select past CheckIn & CheckOut date
   
   
   And user enters checkIn date as "checkIn" "25/06/2025" 
   
   And user enters checkOut date as "checkOut" "26/06/2025"
   
   And user selects number of adults per room "adults" "1"
   
   And user should click on button "searchButton"
   
   Then system should show error like "error" "Check-In Date should be either Today or Later Date"
   

     
    
    
