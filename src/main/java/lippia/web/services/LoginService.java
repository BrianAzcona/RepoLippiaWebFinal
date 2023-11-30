package lippia.web.services;
import com.crowdar.core.actions.ActionManager;
import org.openqa.selenium.*;
import org.testng.Assert;
import static com.crowdar.driver.DriverManager.getDriverInstance;
import static lippia.web.constants.LoginConstans.*;
import static lippia.web.constants.ShopConstans.OBJ_OPCION_PAGO_LOCATOR;

public class LoginService extends ActionManager {
    public static void clickMyAccount() {
        click(BOTON_CUENTA_LOCATOR);

    }
    public static void rellenarCampoLogin(String usuario, String contrasena) {
        WebDriver driver = getDriverInstance();
        waitVisibility(BOTON_LOGIN_LOCATOR);

        WebElement campoUser = driver.findElement(By.xpath(VEC_CAMPO_LOGIN_LOCATOR[0]));
        campoUser.sendKeys(usuario);
        WebElement campoPassword = driver.findElement(By.xpath(VEC_CAMPO_LOGIN_LOCATOR[1]));
        campoPassword.sendKeys(contrasena);
    }

    public static void login() {
        click(BOTON_LOGIN_LOCATOR);
    }
    public static void verificarMensajeError(String pMensajeError) {
        WebDriver driver = getDriverInstance();
        WebElement mensajeErrorElemento = driver.findElement(By.xpath(OBJ_MENSAJE_ERROR_LOCATOR));
        String mensajeError = mensajeErrorElemento.getText();
        assert mensajeError.equals(pMensajeError): "El mensaje de error no es el esperado. Mensaje actual: "+ pMensajeError;
    }
    public static void verificaLoginExitoso() {
        boolean esVisible = isVisible(OBJ_PAG_INICIO_LOCATOR);
        Assert.assertTrue(esVisible, "El elemento no es visible");
    }
    public static void cerrarSesion() {
        click(BOTON_CERRAR_SESION_LOCATOR);
    }
    public static void retroceder() {
        WebDriver driver = getDriverInstance();
        for (int i = 0; i < 3; i++) {
            driver.navigate().back();
        }
    }
    public static void verificaPagGeneral() {
        boolean esVisible = isVisible(OBJ_PAG_GENERAL_LOCATOR);
        Assert.assertTrue(esVisible, "El elemento no es visible");
    }
    public static void clickRegister() {
        click(BOTON_REGISTER_LOCATOR);
    }
    public static void rellenarCampoRegistro(String correo, String contrasena) {
        WebDriver driver = getDriverInstance();

        waitVisibility(BOTON_REGISTER_LOCATOR);
        WebElement campoCorreo = driver.findElement(By.xpath(VEC_CAMPO_REGISTRO_LOCATOR[0]));
        campoCorreo.sendKeys(correo);
        WebElement campoContrasena = driver.findElement(By.xpath(VEC_CAMPO_REGISTRO_LOCATOR[1]));
        campoContrasena.sendKeys(contrasena);
    }
    public static void verificarMensajeErrorRegistro(String pMensajeError){
        WebDriver driver = getDriverInstance();
        WebElement mensajeErrorElemento = driver.findElement(By.xpath(OBJ_MENSAJE_REGISTRO_LOCATOR));
        String mensajeError = mensajeErrorElemento.getText();
        assert mensajeError.equals(pMensajeError): "El mensaje de error no es el esperado. Mensaje actual: "+ pMensajeError;

    }
    public static void clickDetallesCuenta() {
        click(BOTON_DETALLES_CUENTA_LOCATOR);
    }
    public static void verificaDetallesCuenta() {
        boolean esVisible = isVisible(OBJ_DETALLES_CUENTA_LOCATOR);
        Assert.assertTrue(esVisible, "El elemento no es visible");
    }
    public static void cambioContrasena(String contrasena,String nuevaContrasena){
        WebDriver driver = getDriverInstance();

        WebElement oldPassword = driver.findElement(By.xpath(VEC_CAMPO_NUEVA_CONTRASENA_LOCATOR[0]));
        oldPassword.sendKeys(contrasena);

        WebElement newPassword = driver.findElement(By.xpath(VEC_CAMPO_NUEVA_CONTRASENA_LOCATOR[1]));
        newPassword.sendKeys(nuevaContrasena);

        WebElement newConfirmPassword = driver.findElement(By.xpath(VEC_CAMPO_NUEVA_CONTRASENA_LOCATOR[2]));
        newConfirmPassword.sendKeys(nuevaContrasena);

        WebElement botonGuardar = driver.findElement(By.xpath(OBJ_GUARDAR_CAMBIOS_LOCATOR));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonGuardar);
        click(BOTON_GUARDAR_CAMBIOS_LOCATOR);

    }
    public static void verificarCerrarSesion(){
            boolean esVisible = isVisible(OBJ_PAG_LOGIN_LOCATOR);
            Assert.assertTrue(esVisible, "El elemento no es visible");
    }
}
