Feature: Como usuario quiero buscar un articulo por su nombre

  Scenario: Buscar un articulo por su nombre
    Given iniciar un sesion
    When Guardo el articulo
    And lo busco por su nombre
    Then imprime el campo buscado
