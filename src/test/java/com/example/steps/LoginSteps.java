package com.example.steps;

import com.example.abilities.User;
import com.example.questions.LoginStatus;
import com.example.tasks.Login;
import com.example.tasks.Navigate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import static org.hamcrest.Matchers.is;

public class LoginSteps {

    private Actor juan = Actor.named("Juan");

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        juan = User.named("Juan"); // Inicializa el Actor usando User.named(actorName)
        juan.attemptsTo(Navigate.toLoginPage());
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        String username = "tu_usuario"; // Ajusta el nombre de usuario según tu prueba
        String password = "tu_contraseña"; // Ajusta la contraseña según tu prueba
        juan.attemptsTo(Login.withCredentials(username, password));
    }

    @Then("the user should be logged in")
    public void theUserShouldBeLoggedIn() {
        juan.should(
                GivenWhenThen.seeThat("The user should be logged in", LoginStatus.isLogged(), is(true))
        );
    }
}
