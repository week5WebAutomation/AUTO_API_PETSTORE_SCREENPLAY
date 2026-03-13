Feature: Registro de usuario

  Scenario: Registro exitoso de un usuario
    Given el usuario está en la página de registro
    When el usuario ingresa sus datos válidos
    Then el sistema muestra un mensaje de registro exitoso