
Feature: como usuario quiero Crear un pago para un credito
				
  Scenario: Crear un pago para un credito
    Given pantalla de inicio del sistema 
    When cargo los datos del credito
    And asigno un pago
    And lo guardo en la BD
    Then traigo el valor del pago 
    
