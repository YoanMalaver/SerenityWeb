Feature: Adding items to the Cart
  Rule: Items added from the catalog page should appear in the cart

      @ExampleOne
      Example: Colin adds some items to his cart
        Given Colin has logged on to the application
        And he is browsing the catalog
        When he adds the following items to the card:
          | Sauce Labs Backpack      |
        #  | Sauce Labs Flecce Jacket |
          | Sauce Labs Fleece Jacket |
        Then the shopping cart count should be 2
        And the item should appear in the cart

        @ExampleTwo
        Example: Customer should see best-selling products on the catalog page
          When Candy has logged on to the Application
          Then she should be presented with the following
            | Title                 | Price  |
          | Sauce Labs Backpack   | $29.99 |
          | Sauce Labs Bike Light | $9.99 |
