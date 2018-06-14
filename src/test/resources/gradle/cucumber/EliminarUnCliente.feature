Feature: Como usuario quiero eliminar un cliente

  Scenario: Eliminar un Cliente del sistema
    Given en inicio del sistema
    When guardo un usuario
    And  lo elimino
    Then se borra su registro