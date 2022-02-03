Feature: User can order product

  Scenario Outline: User can find and buy product with catalog
    Given User on main page
    When User move mouse to the catalog
    When User choose <catalog> in catalog
    When User choose <sub catalog> in sub catalog
    When User click on first product
    When User click on buy button
    Then User see <product> in basket

    Examples:
      | catalog     | sub catalog | product               |
      | 'Смартфони' | 'Apple'     | 'iPhone'              |
      | 'Аудіо'     | 'Samsung'   | 'Samsung Galaxy Buds' |

  Scenario: User can find and buy product with search
    Given User on main page
    When User send 'Iphone' in top search field
    When User click on search button
    When User click on product with 'iPhone' name
    When User click on buy button
    Then User see 'iPhone' in basket

  Scenario: User can add product to wish lists
    Given User on main page
    When User move mouse to the catalog
    When User choose 'Смартфони' in catalog
    When User choose 'Apple' in sub catalog
    When User click on first product
    When User click on sign in button
    When User click on register button
    When User send name in name field
    When User send phone number in number field
    When User send email in email field
    When User send password in password field
    When User send register new user button
    When User click on add to wish list button
    Then User should see product in basket