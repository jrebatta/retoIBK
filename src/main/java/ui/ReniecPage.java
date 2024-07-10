package ui;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.reniec.gob.pe/portal/masServiciosLinea.htm")
public class ReniecPage extends PageObject {

    public static final Target PERUANOS_EXTRANJERO = Target.the("Peruanos en el extranjero").locatedBy("(//*[@id='tit_tabla_submain'])[3]");
    public static final Target CONSULADOS_MUNDO = Target.the("CONSULADOS EN EL MUNDO").locatedBy("//*[@id=\"fondo\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/h3[3]/a");
    public static final Target LISTA_DE_CONSULADOS_MUNDO = Target.the("CONSULADOS EN EL MUNDO").locatedBy("//*[@id=\"fondo\"]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/div/ul[3]/li/a");

}
