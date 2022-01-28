Feature: user can order product

  Scenario Outline: We can find and buy product with catalog
    Given We on main page
    When We move mouse to the catalog
    When We choose <catalog> in catalog
    When We choose <sub catalog> in sub catalog
    When We click on first product
    When We click on buy button
    Then We see <product> in basket

    Examples:
      | catalog     | sub catalog | product               |
      | 'Смартфони' | 'Apple'     | 'iPhone'              |
      | 'Аудіо'     | 'Samsung'   | 'Samsung Galaxy Buds' |


  Scenario: We can find and buy product with search
    Given We on main page
    When We send 'Iphone' in top search field
    When  We click on search button
    When We click on product with 'iPhone' name
    When We click on buy button
    Then We see 'iPhone' in basket


  Scenario: We can add product to wish lists
    Given We on main page
    When We move mouse to the catalog
    When We choose 'Смартфони' in catalog
    When We choose 'Apple' in sub catalog
    When We click on first product
    When We click on sign in button
    When We click on register button
    When We send name in name field
    When We send phone number in number field
    When We send email in email field
    When We send password in password field
    When We send register new user button
    When We click on add to wish list button
    Then We should see product in basket

