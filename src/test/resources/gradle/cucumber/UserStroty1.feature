Feature: Crear un cliente en el sistema con sus datos personales

  Scenario: Crear im cliente en el sistema con sus datos personales
    Given un inicio de sesion
    When creo un cliente con sus datos personales
    Then valido su creacion
