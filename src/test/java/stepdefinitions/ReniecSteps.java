package stepdefinitions;

import actors.Usuario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import tasks.BuscarOficina;
import ui.ReniecPage;
import java.util.Set;


public class ReniecSteps {

    @Managed(driver = "chrome")
    private WebDriver driver;
    private Usuario juan = Usuario.llamado("Juan");

    @Given("Ingresa a la página principal de RENIEC")
    public void ingresaALaPáginaPrincipalDeRENIEC() {
        juan.can(BrowseTheWeb.with(driver));
        juan.wasAbleTo(
                Open.browserOn(new ReniecPage())
        );
    }

    @When("Ingresa a la opción Peruanos en el Extranjero")
    public void ingresaALaOpciónPeruanosEnElExtranjero() {
        juan.wasAbleTo(
                Click.on(ReniecPage.PERUANOS_EXTRANJERO)
        );
    }

    @And("Despliega la opción Consulados en el mundo")
    public void despliegaLaOpciónConsuladosEnElMundo() {
        juan.wasAbleTo(
                Click.on(ReniecPage.CONSULADOS_MUNDO)
        );
    }


    @And("Ingresa a la opción Lista de Consulados en el mundo")
    public void ingresaALaOpciónListaDeConsuladosEnElMundo() {
        juan.wasAbleTo(
                Click.on(ReniecPage.LISTA_DE_CONSULADOS_MUNDO)
        );
    }


    @And("Se abre una nueva pestaña de Consulados en el mundo")
    public void seAbreUnaNuevaPestañaDeConsuladosEnElMundo() {
        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    @And("Realiza la búsqueda de la {string} y se verifica el resultado de la búsqueda")
    public void realizaLaBúsquedaDeLaYSeVerificaElResultadoDeLaBúsqueda(String ciudad) throws InterruptedException {
        juan.wasAbleTo(
                BuscarOficina.conCiudad(ciudad));
        Thread.sleep(2000);

    }


    @Then("Regresa a la pestaña original")
    public void regresaALaPestañaOriginal() throws InterruptedException {
        String originalHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                break;
            }
        }
    }



}
