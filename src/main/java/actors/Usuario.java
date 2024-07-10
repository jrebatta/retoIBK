package actors;

import net.serenitybdd.screenplay.Actor;

public class Usuario extends Actor {

    public Usuario(String nombre) {
        super(nombre);
    }

    public static Usuario llamado(String nombre) {
        return new Usuario(nombre);
    }
}