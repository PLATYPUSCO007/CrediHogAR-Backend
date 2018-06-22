Feature: Como usuario quiero editar la calificacion de un cliente

  Scenario: Editar la calificacion de un cliente
    Given inicia una sesion
    When Guardo el cliente
    And edito la calificacion
    Then imprime la nueva calificacion
