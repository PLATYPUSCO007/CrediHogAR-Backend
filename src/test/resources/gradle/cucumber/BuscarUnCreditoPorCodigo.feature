Feature: Buscar un Creditopor codigo en el sistema

  Scenario: Buscar por codigo un Credito Que existe en la base de datos 
    Given una Ventana inicial y un credito guardo en la bd  
    When busco el credito por codigo 
    Then me devuelve todos losdatos del credito

