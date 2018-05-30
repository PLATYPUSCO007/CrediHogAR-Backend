Feature: cargar un usuario en el sistema

  Scenario: Cargar un usuario en la bd y traer su id
    Given un inicio del sistema
    When cargo un usuario al sistema
    Then deberia traer su ID
