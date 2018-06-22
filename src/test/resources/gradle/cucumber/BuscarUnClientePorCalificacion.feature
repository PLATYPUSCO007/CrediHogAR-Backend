Feature: Como usuario quiero buscar un cliente por su calificacion

  Scenario: Buscar un cliente por su calificacion
    Given inicia el sistema
    When Guardo cliente
    And Busco el cliente por su calificacion
    Then devuelve sus datos
