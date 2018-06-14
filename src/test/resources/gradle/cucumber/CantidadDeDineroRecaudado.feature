Feature: Como usuario quiero consultar la cantidad de dinero recaudado en un mes

  Scenario: Consultar la cantidad de dinero recaudado en un mes
    Given inicio del sistema
    When consulto el dinero recaudado en un mes
    Then obtengo la cantidad de dinero recaudado
