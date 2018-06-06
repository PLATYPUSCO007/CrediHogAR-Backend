Feature: Como usuario quiero buscar un cliente por su DNI 

  Scenario: Buscar un cliente por su DNI
    Given iniciar sesion
    When busco un cliente por su DNI
    Then imprime el DNI en pantalla
