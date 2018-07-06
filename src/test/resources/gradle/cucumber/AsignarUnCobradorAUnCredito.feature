Feature: Como usuario quiero asignar un Cobrador a un credito determinado

  Scenario: Asignar un Cobrador a un credito ya existente 
    Given un pantalla de crear credito
    When le asigno un Cobrador 
    Then y se guarda en la bd con los datos del credito 
