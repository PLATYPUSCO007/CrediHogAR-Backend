
Feature: Asigno un articulo a un credito
  Scenario: Al Crear un credito se asigna un articulo
    Given una pantalla de crear credito
    And un articulo 
    When asigno el articulo al credito
    And guardo el credito
    Then el credito se guarda en la bd con todos sus datos correspondientes
    

