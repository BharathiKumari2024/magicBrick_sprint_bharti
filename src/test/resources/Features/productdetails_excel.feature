Feature: Product Details

Scenario Outline: Verify Contact Details functionality with valid data
   Given chrome is opened and magicbricks app is opened
   When User enters "Kolkata" in AddMore field
   And User clicks on Location
   Then User navigates to ProductList page
   When User clicks on any product
   Then User navigates to ProductDetails page
   Then ProductDetails fields are visible to user
   Then User is able to click on Download brochure button
   And User enters details from given sheetname "<SheetName>" and rownumber <RowNumber>
   Then User clicks on Get submit button

Examples:
           | SheetName | RowNumber |
           | Sheet1    | 0         |
           