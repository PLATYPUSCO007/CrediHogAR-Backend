Feature: Como usuario quiero crear un articulo con precio y detalle en el sistema 

  Scenario: un sistema en estado inicial
    Given un sistema iniciado
    When Creo un articulo con nombre y detalle y lo guardo
    Then queda registrado en el sistema

