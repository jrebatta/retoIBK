package com.example.abilities;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class User {

    public static Actor named(String actorName) {
        // Especificar la ubicación del Chromedriver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        // Configurar opciones del ChromeDriver si es necesario
        ChromeOptions options = new ChromeOptions();
        // Por ejemplo, para deshabilitar las extensiones del navegador
        options.addArguments("disable-extensions");

        WebDriver driver = new ChromeDriver(options);
        Actor actor = Actor.named(actorName);
        actor.can(BrowseTheWeb.with(driver));
        return actor;
    }
}
