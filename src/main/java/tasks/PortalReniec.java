package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PortalReniec implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
    }

    public static Performable peruanosExtranjero() {
        return instrumented(PortalReniec.class);
    }


}
