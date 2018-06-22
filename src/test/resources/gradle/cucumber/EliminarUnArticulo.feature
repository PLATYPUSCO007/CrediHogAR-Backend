Feature: Como usuario quiero eliminar un articulo 

  Scenario: Eliminar un articulo
    Given iniciar unn sesion
    When Guardo ell articulo
    And lo elimino del registro
    Then verifico su eliminacion
