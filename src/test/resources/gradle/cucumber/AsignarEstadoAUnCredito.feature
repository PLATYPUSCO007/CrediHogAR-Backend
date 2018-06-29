Feature: Como usuario quiero asignar un estado a un credito determinado

  Scenario: Asignar un estado a un credito ya existente 
    Given un credito Existente
    When le asigno un estado 
    Then el estado se guarda en la bd con el credito 

