Feature: Como usuario quiero buscar un cliente por su nombre 

  Scenario: Buscar un cliente por su nombre
    Given inicio de sesion
    When busco un cliente por su nombre
    Then imprime su nombre en pantalla
