package lippia.web.services;

import com.crowdar.core.actions.ActionManager;
import lippia.web.constants.GoogleConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static com.crowdar.driver.DriverManager.getDriverInstance;
import static lippia.web.constants.ShopConstans.*;



public class AutomationPracticeService extends ActionManager {
    public static WebDriver driver = getDriverInstance();
    public static void scrollObjElement(String pElemet){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(pElemet));
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }
    public static WebElement scrollObjElementInput(String pElemet){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(pElemet));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;

    }
    public static void navegarWeb() {

        navigateTo("https://practice.automationtesting.in/");

    }

    public static void clickStore() {
        click(SHOP_LOCATOR);
    }

    public static void clickHome() {
        waitVisibility(BOTON_MENU_LOCATOR);
        click(BOTON_MENU_LOCATOR);

    }

    public static void clickAdd() {
        click(ADD_LOCATOR);
    }

    public static void clickArrival() {
        click(ARRIVAL_LOCATOR);
    }
    public static void arrivalsVisibles() {
        boolean esVisible = isVisible(ARRIVALS_LOCATOR);
        Assert.assertTrue(esVisible, "El elemento no es visible");
    }
    public static void paginaLibroVisible() {
        boolean esVisible = isVisible(PAGINA_LIBRO_LOCATOR);
        Assert.assertTrue(esVisible, "El elemento no es visible");
    }

    public static void elementoCompradoVisible() {
        boolean esVisible = isVisible(ELEMENTO_COMPRADO_LOCATOR);
        Assert.assertTrue(esVisible, "El elemento no es visible");
    }

    public static void clickCesta() {
        click(CESTA_LOCATOR);
    }

    public static void totalesVisibles() {
        waitVisibility(TOTALES_LOCATOR);
        boolean esVisible = isVisible(TOTALES_LOCATOR);
        Assert.assertTrue(esVisible, "El elemento no es visible");
    }

    public static void clickCajaPago() {
        scrollObjElement(OBJ_CAJA_PAGO_LOCATOR);
        click(CAJA_PAGO_LOCATOR);
    }

    public static void datosFacturaVisible() {
        scrollObjElement(INFO_PAGO_SCROLL_LOCATOR[0]);
        boolean detallesFactura = isVisible(INFO_PAGO_ASSERT_LOCATOR[0]);
        Assert.assertTrue(detallesFactura, "El elemento no es visible");

        scrollObjElement(INFO_PAGO_SCROLL_LOCATOR[1]);
        boolean infoAdicional = isVisible(INFO_PAGO_ASSERT_LOCATOR[1]);
        Assert.assertTrue(infoAdicional, "El elemento no es visible");

        scrollObjElement(INFO_PAGO_SCROLL_LOCATOR[2]);
        boolean pedido = isVisible(INFO_PAGO_ASSERT_LOCATOR[2]);
        Assert.assertTrue(pedido, "El elemento no es visible");

    }

    public static void rellenarCampoFormulario(String Nombre, String Apellido, String Correo, String Telefono, String Direccion, String Pais, String Ciudad, String Estado, String CodigoPostal) {
        scrollObjElementInput(CAMPOS_FORMULARIO_LOCATORS[0]).sendKeys(Nombre);

        scrollObjElementInput(CAMPOS_FORMULARIO_LOCATORS[1]).sendKeys(Apellido);

        scrollObjElementInput(CAMPOS_FORMULARIO_LOCATORS[2]).sendKeys(Correo);

        scrollObjElementInput(CAMPOS_FORMULARIO_LOCATORS[3]).sendKeys(Telefono);

        click(MENU_DESPLEGABLE_FORMULARIO_LOCATORS[0]);
        scrollObjElementInput(CAMPOS_FORMULARIO_LOCATORS[4]).sendKeys(Pais, Keys.ENTER);

        scrollObjElementInput(CAMPOS_FORMULARIO_LOCATORS[5]).sendKeys(Direccion);

        scrollObjElementInput(CAMPOS_FORMULARIO_LOCATORS[6]).sendKeys(Ciudad);

        click(MENU_DESPLEGABLE_FORMULARIO_LOCATORS[1]);
        WebElement campoEstado = driver.findElement(By.xpath(CAMPOS_FORMULARIO_LOCATORS[7]));
        campoEstado.sendKeys(Estado, Keys.ENTER);

        scrollObjElementInput(CAMPOS_FORMULARIO_LOCATORS[8]).sendKeys(CodigoPostal);
    }
    public static void clickOpcionPago() {
        click(OPCION_PAGO_LOCATOR);
    }
    public static void agregarCuponVisible() {
        scrollObjElement(OBJ_OPCION_PAGO_LOCATOR);
        boolean esVisible = isVisible(CUPON_LOCATOR);
        Assert.assertTrue(esVisible, "El elemento no es visible");
    }
    public static void clickRealizarPedido() {
        scrollObjElement(OBJ_REALIZAR_PAGO_LOCATOR);
        click(BOTON_REALIZAR_PAGO_LOCATOR);
    }
    public static void clickAgregarLibro() {
        waitVisibility(PAG_NAVEGACION_LOCATOR);
        scrollObjElement(OBJ_LIBRO_SHOP_LOCATOR);
        click(LIBRO_SHOP_LOCATOR);
    }
    public static void verificarPagDetallesCompra() {
        scrollObjElement(OBJ_PAG_DETALLES_PAGO_LOCATOR);
        boolean esVisible = isVisible(PAG_DETALLES_PAGO_LOCATOR);
        Assert.assertTrue(esVisible, "El elemento no es visible");
    }

}
