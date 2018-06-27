
Feature: como usuario quiero Crear un credito asignado a un cliente
				
  Scenario: Cracion de un credito
    Given pantalla inicial de un sistema 
    When cargo los datos de un credito
    And asigno un cliente
    And doy guardar
    Then el credito se guarda en la base de datos del sistema 
    
