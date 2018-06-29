
Feature: como usuario quiero Buscar los pagos de un determinado credito
				
  Scenario: Buscar pagos de un credito
    Given pantalla de inicio 
    When cargo datos de un credito
    And asigno varios pagos
    And los almaceno en la BD
    And Busco los pagos asignados segun el codigo del credito
    Then traigo los pagos 
    
