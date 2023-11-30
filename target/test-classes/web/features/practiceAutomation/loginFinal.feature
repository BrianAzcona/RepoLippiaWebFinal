@login
Feature: Iniciar sesión a la cuenta
  Background:
    Given el usuario se dirige a la pagina automationTesting
    When haga clic en el menú "My Account"

  @loginFallido
  Scenario Outline: Login fallido por "<motivo>"
    And ingresa el nombre de usuario "<Usuario>" y contrasena "<Password>"
    And haga clic en "login"
    Then se verifica que el nombre o contrasena son incorrectos con un "<mensaje>"
    @UserError
    Examples:
      | motivo             | Usuario     | Password       | mensaje                                                                                                                             |
      | usuario incorrecto | alexperez25 | Corrientes1025 | Error: The username alexperez25 is not registered on this site. If you are unsure of your username, try your email address instead. |
    @PasswordError
    Examples:
      | motivo                | Usuario       | Password  | mensaje                                                                                          |
      | contrasena incorrecta | brianazcona25 | Chaco1025 | Error: The password you entered for the username brianazcona25 is incorrect. Lost your password? |
    @UserPasswordError
    Examples:
      | motivo                           | Usuario   | Password  | mensaje                                                                                                                           |
      | usuario y contrasena incorrectos | agustin32 | Mision123 | Error: The username agustin32 is not registered on this site. If you are unsure of your username, try your email address instead. |

  @loginExitoso
  Scenario Outline: Login exitoso
    And ingresa el nombre de usuario "<Usuario>" y contrasena "<Password>"
    And haga clic en "login"
    Then se verifica que inicia sesion correctamente
    And haga clic en "logout"
    And presiona el boton hacia atras
    Then vuelve a la pagina general
    Examples:
      | Usuario       | Password       |
      | brianazcona25 | Corrientes1025 |
