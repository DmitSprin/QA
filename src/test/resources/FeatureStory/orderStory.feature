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