Feature: Como usuario quiero editar un articulo

  Scenario: Editar un articulo
    Given iniciar a sesion
    When Guardo un articulo
    And lo edito
    Then imprime el nuevo campo editado
