Feature: Como usuario quiero asignar una calificacion a un cliente

  Scenario: Asignar una calificacion a un cliente
    Given inicia sesion
    When Guardo un cliente
    And le asigno una calificacion
    Then imprime la calificacion
