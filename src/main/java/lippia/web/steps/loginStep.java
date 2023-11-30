package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.services.AutomationPracticeService;
import lippia.web.services.LoginService;

public class loginStep extends PageSteps {
    @When("haga clic en el menú {string}")
    @And("haga clic en {string}")
    public void haceClicEn(String btn) {
        switch (btn){
            case "login": LoginService.login();
                break;
            case "logout": LoginService.cerrarSesion();
                break;
            case "register": LoginService.clickRegister();
                break;
            case "Account details": LoginService.clickDetallesCuenta();
                break;
            case "My Account": LoginService.clickMyAccount();
                break;
        }
    }

    @And("ingresa el nombre de usuario {string} y contrasena {string}")
    public void ingresaElNombreDeUsuarioYContrasena(String usuario, String contrasena) {
        LoginService.rellenarCampoLogin(usuario,contrasena);
    }

    @Then("se verifica que el nombre o contrasena son incorrectos con un {string}")
    public void seVerificaQueElNombreOContrasenaSonIncorrectosConUn(String mensajeError) {
        LoginService.verificarMensajeError(mensajeError);
    }

    @Then("se verifica que inicia sesion correctamente")
    public void seVerificaQueIniciaSesionCorrectamente() {
        LoginService.verificaLoginExitoso();
    }

    @And("presiona el boton hacia atras")
    public void presionaElBotonHaciaAtras() {
        LoginService.retroceder();
    }

    @Then("vuelve a la pagina general")
    public void vuelveALaPaginaGeneral() {
        LoginService.verificaPagGeneral();
    }

    @And("ingresa un correo {string} valido")
    public void ingresaUnCorreoValido() {

    }

    @Then("se verifica que el registo falla con un mensaje {string}")
    public void seVerificaQueElRegistoFallaConUnMensaje(String mensajeError) {
        LoginService.verificarMensajeErrorRegistro(mensajeError);
    }

    @And("ingresa un correo {string} y contrasena {string} vacia")
    public void ingresaUnCorreoYContrasenaVacia(String correo, String contrasena) {
        LoginService.rellenarCampoRegistro(correo, contrasena);
    }

    @Then("se verifica que se pueda ver los detalles de la cuenta")
    public void seVerificaQueSePuedaVerLosDetallesDeLaCuenta() {
        LoginService.verificaDetallesCuenta();
    }

    @And("se cambia la contraseña {string}")
    public void seCambiaLaContrasena(String nuevaContrasena) {

    }

    @And("se cambia la contraseña anterior {string} por una nueva {string}")
    public void seCambiaLaContrasenaAnteriorPorUnaNueva(String contrasena, String nuevaContrasena) {
        LoginService.cambioContrasena(contrasena, nuevaContrasena);
    }

    @Then("se verifica que sale del sitio de forma exitosa")
    public void seVerificaQueSaleDelSitioDeFormaExitosa() {
        LoginService.verificarCerrarSesion();
    }
}
