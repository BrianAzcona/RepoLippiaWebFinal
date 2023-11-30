Feature: My Account
  Background:
    Given el usuario se dirige a la pagina automationTesting
    When haga clic en el menú "My Account"
@MyAccountCase7
  Scenario Outline: Ver detalles de la cuenta
    And ingresa el nombre de usuario "<Usuario>" y contrasena "<Contrasena>"
    And haga clic en "login"
    Then se verifica que inicia sesion correctamente
    And haga clic en "Account details"
    Then se verifica que se pueda ver los detalles de la cuenta
    And se cambia la contraseña anterior "<Contrasena>" por una nueva "<NuevaContrasena>"

    Examples:
      | Usuario       | Contrasena     | NuevaContrasena |
      | brianazcona25 | Corrientes2528 | Corrientes1025  |

  @MyAccountCase8
  Scenario Outline: iniciar y cerrar sesion correctamente
    And ingresa el nombre de usuario "<Usuario>" y contrasena "<Contrasena>"
    And haga clic en "login"
    Then se verifica que inicia sesion correctamente
    And haga clic en "logout"
    Then se verifica que sale del sitio de forma exitosa
    Examples:
      | Usuario       | Contrasena     |
      | brianazcona25 | Corrientes2528 |
