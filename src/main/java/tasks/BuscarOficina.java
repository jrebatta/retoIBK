package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static ui.ConsuladoPage.*;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarOficina implements Task {

    private String ciudad;
    public BuscarOficina(String ciudad){
        this.ciudad = ciudad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(ciudad).into(INPUT_BUSCAR_OFICINA),
                Click.on(BUTTON_BUSCAR_OFICINA)
        );

    }

    public static Performable conCiudad(String ciudad) {
        return instrumented(BuscarOficina.class, ciudad);
    }


}
