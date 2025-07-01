Feature: Select Hotel Validations

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
    
     
       
    @test4
    Scenario: Location selected in the search hotel form should be the same as the location displayed in select hotel 
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Select Hotel" 
    
    And user should be on "SelectHotelPage"
    
    Then Location displayed in Select Hotel should be the same as location selected in search hotel form "location"
    
    
    @test5
    Scenario: Selected CheckIn date and CheckOut in the search hotel form should be the same as the location displayed in select hotel 
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Select Hotel" 

    And user should be on "SelectHotelPage"
    
    Then CheckIn displayed in Select Hotel should be the same as location selected in search hotel form "checkInDate"
    
    Then CheckOut displayed in Select Hotel should be the same as location selected in search hotel form "checkOutDate"
    
    
    @test6 
    Scenario: Number of rooms selected in search hotel page should be same as the number of rooms displayed in select hotel page  
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Select Hotel" 

    And user should be on "SelectHotelPage"
    
    Then selected rooms in search hotel page should be same as the rooms displayed in select hotel page "numOfRooms"
    
    
    @test7
    Scenario: RoomType selected in the search hotel form should be the same as the RoomType displayed in select hotel
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Select Hotel" 

    And user should be on "SelectHotelPage"
    
    Then selected RoomType in search hotel page should be same as the RoomType displayed in select hotel page "roomType"
    
    
    @test8
    Scenario: Total price should be equals to no.of romms * no. of days * room price per night
    
    Then user should navigate to the search hotel page successfully "Adactin.com - Select Hotel" 
    
    And user should be on "SelectHotelPage" 
    
    Then Total price must equals to no. of days * room per night * room price per night "totalPrice"
    
    