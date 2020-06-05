#Author: michell.soares@outlook.com
@americanas
Feature: Americanas

  @busca
  Scenario: Validar Busca
    Given que acessei o site pela url "https://www.americanas.com.br"
    When realizar a busca pelo produto "Mouse"
    Then valido que a busca retornou o produto "Mouse" corretamente no site.

  @carrinho @compras
  Scenario Outline: Validar carrinho de compras
    Given que acessei o site pela url "https://www.americanas.com.br"
    When realizar a busca pelo produto "<produto>"
    And clicar no produto "<produto>"
    And adicionar o produto ao carrinho
    Then valido que o produto foi adicionado corretamente ao carrinho de compras.

    Examples: 
      | produto |
      | mouse   |
      | teclado |
