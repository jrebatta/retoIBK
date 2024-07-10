#language: en

@TESTSAPI @ALLTESTS
Feature:Happy Paths PetStore

  @CREAR_MASCOTA
  Scenario Outline: Crear nueva mascota
    Given crear nueva mascota con datos "<categoryID>", "<categoryName>", "<PetName>", "<photoUrls>", "<tagID>", "<tagName>" y "<status>"
    When se valida el codigo de respuesta "<statusCode>"
    Then se obtiene el ID de la nueva mascota y se guarda el response
    Examples:
      |categoryID  |categoryName |PetName |photoUrls |tagID |tagName |status| statusCode |
      |1           |Perro        |Kovu    |url       |2     |Macho   |vivo  | 200        |

  @BUSCAR_MASCOTA
  Scenario Outline: Consultar mascota creada
    Given consultar el ID de la mascota creada
    When se valida el codigo de respuesta "<statusCode>"
    Then se obtiene el response de la mascota y se compara
    Examples:
      | statusCode   |
      | 200          |

  @ACTUALIZAR_MASCOTA
  Scenario Outline: Modificar nombre de mascota creada
    Given actualizar "<PetName>" de la mascota creada
    When se valida el codigo de respuesta "<statusCode>"
    Then se obtiene el response de la mascota y se valida el "<PetName>"
    Examples:
     |PetName |statusCode |
     | Fido   |200        |

  @ELIMINAR_MASCOTA
  Scenario Outline: Eliminar mascota creada
    Given consultar el ID de la mascota a eliminar
    When se valida el codigo de respuesta "<statusCode>"
    Then se obtiene el response de la mascota eliminada y se valida el ID
    Examples:
      |statusCode   |
      |200          |