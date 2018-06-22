Feature: Como usuario quiero buscar un cliente por su ID

  Scenario: Buscar un cliente por su ID
    Given iniciar una sesion
    When busco un cliente por su ID
    Then imprime el ID en pantalla
