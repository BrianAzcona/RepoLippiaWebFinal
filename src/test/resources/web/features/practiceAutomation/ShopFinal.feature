@Shop
Feature: Shop

  Background:
    Given el usuario se dirige a la pagina automationTesting
    When hace clic en "Shop"

  Scenario Outline: compra a traves de enlace
    And hace clic en Add to Basket de algun libro
    Then se verifica que el elemento sea visible en el menu con el precio
    And hace clic en "Item"
    Then se verifica que se puedan ver los totales y subtotales
    And hace clic en "Proceed to Checkout"
    Then se verifica que se puedan ver los detalles de facturación, los detalles del pedido, los detalles adicionales y los detalles de la pasarela de pago
    And se rellenan los campos "<Nombre>", "<Apellido>", "<Correo>", "<Telefono>", "<Direccion>", "<Pais>", "<Ciudad>","<Estado>",  "<Codigo Postal>"
    And elije una forma de pago
    And hace clic en "Place Order"
    Then se verifica que se navega a la siguiente pagina con los detalles de la compra
  @Shop11
  Examples:
    | Nombre    | Apellido | Correo                  | Telefono   | Direccion      | Pais      | Ciudad     | Estado     | Codigo Postal |
    | Alexander | Perez    | brianazcona25@gmail.com | 3794451252 | Corrientes1025 | Argentina | Corrientes | Corrientes | 3400          |
