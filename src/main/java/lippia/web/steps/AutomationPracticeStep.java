package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.AutomationPracticeService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import javax.swing.*;
import java.util.Scanner;
import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static com.crowdar.driver.DriverManager.getDriverInstance;


public class AutomationPracticeStep extends PageSteps {
    @Given("el usuario se dirige a la pagina automationTesting")
    public void elUsuarioSeDirigeALaPaginaAutomationTesting() {
        AutomationPracticeService.navegarWeb();
    }

    @When("hace clic en el menu {string}")
    public void haceClicEnElMenu(String btn) {
        if (btn.equals("Shop")) {
                AutomationPracticeService.clickStore();
            WebDriver driver = getDriverInstance();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement elementoPublicitario = driver.findElement(By.xpath("//*[@id=\"card\"]"));
            js.executeScript("arguments[0].style.display='none';", elementoPublicitario);
        }
    }

    @And("hace clic en {string}")
    public void haceClicEn(String btn) {
        switch (btn){
            case "Home": AutomationPracticeService.clickHome();
                break;
            case "Shop": AutomationPracticeService.clickStore();
                break;
            case "Add to Basket": AutomationPracticeService.clickAdd();
                break;
            case "Item": AutomationPracticeService.clickCesta();
                break;
            case "Proceed to Checkout": AutomationPracticeService.clickCajaPago();
                break;
            case "Place Order": AutomationPracticeService.clickRealizarPedido();
                break;


        }
    }




    @When("hace clic en Shop")
    public void haceClicEnShop() {

    }

    @And("el usuario hace Scroll hasta ver los Arrivals")
    public void elUsuarioHaceScrollHastaVerLosArrivals() {
        WebDriver driver = getDriverInstance();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 750)");

    }

    @And("hace clic sobre una imagen")
    public void haceClicSobreUnArrival() {
        AutomationPracticeService.clickArrival();
    }

    @Then("se verifica que haya tres Arrivals")
    public void seVerificaQueHayaTresArrivals() {
        AutomationPracticeService.arrivalsVisibles();
    }

    @Then("se verifica que se navega a la pagina del libro seleccionado")
    public void seVerificaQueSeNavegaALaPaginaDelLibroSeleccionado() {
        AutomationPracticeService.paginaLibroVisible();
    }

    @Then("se verifica que el elemento sea visible en el menu con el precio")
    public void seVerificaQueElElementoSeaVisibleEnElMenuConElPrecio() {
        AutomationPracticeService.elementoCompradoVisible();
    }

    @Then("se verifica que se puedan ver los totales y subtotales")
    public void seVerificaQueSePuedanVerLosTotalesYSubtotales() {
        AutomationPracticeService.totalesVisibles();
    }

    @Then("se verifica que se puedan ver los detalles de facturación, los detalles del pedido, los detalles adicionales y los detalles de la pasarela de pago")
    public void seVerificaQueSePuedanVerLosDetallesDelPago() {
        AutomationPracticeService.datosFacturaVisible();
    }

    @And("se rellenan los campos {string}, {string}, {string}, {string}, {string}, {string}, {string},{string},  {string}")
    public void seRellenanLosCampos(String Nombre, String Apellido, String Correo, String Telefono, String Direccion,String Pais, String Ciudad,String Estado, String  CodigoPostal) {
        AutomationPracticeService.rellenarCampoFormulario(Nombre, Apellido, Correo, Telefono, Direccion, Pais, Ciudad, Estado, CodigoPostal);
    }

    @And("elije una forma de pago")
    public void elijeUnaFormaDePago() {
        AutomationPracticeService.clickOpcionPago();
    }

    @Then("se verifica de que se pueda agregar un cupon")
    public void seVerificaDeQueSePuedaAgregarUnCupon() {
        AutomationPracticeService.agregarCuponVisible();
    }

    @And("hace clic en Add to Basket de algun libro")
    public void haceClicAddtoBasketEnDeAlgunLibro() {
        AutomationPracticeService.clickAgregarLibro();
    }

    @Then("se verifica que se navega a la siguiente pagina con los detalles de la compra")
    public void seVerificaQueSeNavegaALaSiguientePaginaConLosDetallesDeLaCompra() {
        AutomationPracticeService.verificarPagDetallesCompra();
    }
}
