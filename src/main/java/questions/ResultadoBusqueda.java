package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static ui.ConsuladoPage.*;

public class ResultadoBusqueda implements Question<Boolean> {

    private String ciudad;

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String ciudadEncontrada = BUTTON_OFICINA_ENCONTRADA.resolveFor(actor).getText();
        if (ciudad.equals(ciudadEncontrada)) {
            result = true;
        }else {
            result = false;
        }
        return result;
    }

}
