Feature: ProductDetails

Scenario Outline: Verify Contact Details functionality with valid data
   Given chrome is opened and magicbricks app is opened
   When User enters "Kolkata" in AddMore field
   And User clicks on Location
   Then User navigates to ProductList page
   When User clicks on any product
   Then User navigates to ProductDetails page
   Then ProductDetails fields are visible to user
   Then User is able to click on Download brochure button
   And User enters Name "<name>" Email "<email>" Mobile "<mobile>"
   Then User clicks on Get submit button

Examples:
          |name    |      email                 |     mobile    |
          |Bharathi| barumoonstone@gmail.com    |  8825744851   |
          
          
Scenario Outline: Verify Contact Details functionality with invalid data
   Given chrome is opened and magicbricks app is opened
   When User enters "Kolkata" in AddMore field
   And User clicks on Location
   Then User navigates to ProductList page
   When User clicks on any product
   Then User navigates to ProductDetails page
   Then ProductDetails fields are visible to user
   Then User is able to click on Download brochure button
   And User enters Name "<name>" Email "<email>" Mobile "<mobile>"
   Then User gets invalid data message
Examples:
          |name    |      email                 |     mobile    |
          |Bharathi| $$$$$$$$$$$$$$$$$$$        |  8825744851   |

          

          
          
          
          