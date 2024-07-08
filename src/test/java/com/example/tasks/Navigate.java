package com.example.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate implements Task {

    private String url;

    public Navigate(String url) {
        this.url = url;
    }

    public static Navigate toLoginPage() {
        return new Navigate("/login.html");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}
