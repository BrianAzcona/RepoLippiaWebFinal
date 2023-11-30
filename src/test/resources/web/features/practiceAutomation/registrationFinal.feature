@Registro
Feature: Registrar cuenta
  Background:
    Given el usuario se dirige a la pagina automationTesting
    When haga clic en el menú "My Account"

  @RegistroFallido
  Scenario Outline: Registro fallido por "<motivo>"
    And ingresa un correo "<correo>" y contrasena "<contrasena>" vacia
    And haga clic en "register"
    Then se verifica que el registo falla con un mensaje "<mensaje>"
    @RegistroFallido4
    Examples:
      | motivo           | correo                  | contrasena | mensaje                                                                        |
      | contrasena vacia | brianazcona25@gmail.com |            | Error: An account is already registered with your email address. Please login. |
    @RegistroFallido5
    Examples:
      | motivo                    | correo | contrasena | mensaje                                      |
      | correo y contrasena vacia |        |            | Error: Please provide a valid email address. |