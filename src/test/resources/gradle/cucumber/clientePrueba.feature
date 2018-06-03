Feature: cargar un cliente en el sistema

  Scenario: Cargar un cliente en la bd y traer su id
    Given un sistema
    When cargo un cliente al sistema
    Then deberia traer su id
