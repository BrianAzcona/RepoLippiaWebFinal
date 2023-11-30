@HomePageFinal
Feature: Compra de Libros en la Tienda


  @HomePage17
  Scenario Outline: Preparar compra de un libro en la tienda
    Given el usuario se dirige a la pagina automationTesting
    When hace clic en "Shop"
    And hace clic en "Home"
    And el usuario hace Scroll hasta ver los Arrivals
    Then se verifica que haya tres Arrivals
    And hace clic sobre una imagen
    Then se verifica que se navega a la pagina del libro seleccionado
    And hace clic en "Add to Basket"
    Then se verifica que el elemento sea visible en el menu con el precio
    And hace clic en "Item"
    Then se verifica que se puedan ver los totales y subtotales
    And hace clic en "Proceed to Checkout"
    Then se verifica que se puedan ver los detalles de facturación, los detalles del pedido, los detalles adicionales y los detalles de la pasarela de pago
    And se rellenan los campos "<Nombre>", "<Apellido>", "<Correo>", "<Telefono>", "<Direccion>", "<Pais>", "<Ciudad>","<Estado>",  "<Codigo Postal>"
    And elije una forma de pago
    Then se verifica de que se pueda agregar un cupon
    Examples:
      | Nombre    | Apellido | Correo                  | Telefono   | Direccion      | Pais      | Ciudad     | Estado     | Codigo Postal |
      | Alexander | Perez    | brianazcona25@gmail.com | 3794451252 | Corrientes1025 | Argentina | Corrientes | Corrientes | 3400          |

  @HomePage18
  Scenario Outline:Compra de un libro en la tienda en línea
    Given el usuario se dirige a la pagina automationTesting
    When hace clic en "Shop"
    And hace clic en "Home"
    And el usuario hace Scroll hasta ver los Arrivals
    Then se verifica que haya tres Arrivals
    And hace clic sobre una imagen
    Then se verifica que se navega a la pagina del libro seleccionado
    And hace clic en "Add to Basket"
    Then se verifica que el elemento sea visible en el menu con el precio
    And hace clic en "Item"
    Then se verifica que se puedan ver los totales y subtotales
    And hace clic en "Proceed to Checkout"
    Then se verifica que se puedan ver los detalles de facturación, los detalles del pedido, los detalles adicionales y los detalles de la pasarela de pago
    And se rellenan los campos "<Nombre>", "<Apellido>", "<Correo>", "<Telefono>", "<Direccion>", "<Pais>", "<Ciudad>","<Estado>",  "<Codigo Postal>"
    And elije una forma de pago
    Then se verifica de que se pueda agregar un cupon
    And hace clic en "Place Order"
    Examples:
      | Nombre    | Apellido | Correo                  | Telefono   | Direccion      | Pais      | Ciudad     | Estado     | Codigo Postal |
      | Alexander | Perez    | brianazcona25@gmail.com | 3794451252 | Corrientes1025 | Argentina | Corrientes | Corrientes | 3400          |



