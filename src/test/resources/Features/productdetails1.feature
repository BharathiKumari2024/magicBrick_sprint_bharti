Feature: Product Details
 
  Scenario: Verify User is able to navigate to ProductDetails page
  Given chrome is opened and magicbricks app is opened
   When User enters "Kolkata" in AddMore field
   And User clicks on Location
   Then User navigates to ProductList page
   When User clicks on any product
   Then User navigates to ProductDetails page
    
   Scenario: Validate ProductDetails page UI
   Given chrome is opened and magicbricks app is opened
   When User enters "Kolkata" in AddMore field
   And User clicks on Location
   Then User navigates to ProductList page
   When User clicks on any product
   Then User navigates to ProductDetails page
   Then ProductDetails fields are visible to user
   
   Scenario: Field validation on ProductDetails page(validate button)
   Given chrome is opened and magicbricks app is opened
   When User enters "Kolkata" in AddMore field
   And User clicks on Location
   Then User navigates to ProductList page
   When User clicks on any product
   Then User navigates to ProductDetails page
   Then ProductDetails fields are visible to user
   Then User is able to click on Download brochure button
   