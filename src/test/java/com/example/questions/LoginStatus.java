package com.example.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LoginStatus implements Question<Boolean> {

    public static Question<Boolean> isLogged() {
        return actor -> true;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return isLogged().answeredBy(actor);
    }
}
