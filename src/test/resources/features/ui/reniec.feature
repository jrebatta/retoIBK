#language: en

@TESTSRENIEC @ALLTESTS
Feature: Verificar la lista de consulados en el portal de RENIEC

@TESTRENIEC
  Scenario Outline: Buscar consulados en la web de RENIEC
    Given Ingresa a la página principal de RENIEC
    When Ingresa a la opción Peruanos en el Extranjero
    And Despliega la opción Consulados en el mundo
    And Ingresa a la opción Lista de Consulados en el mundo
    And Se abre una nueva pestaña de Consulados en el mundo
    And Realiza la búsqueda de la "<ciudad>" y se verifica el resultado de la búsqueda
    Then Regresa a la pestaña original
    Examples:
      |ciudad|
      |Cuenca |
