package ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class ConsuladoPage extends PageObject {

    public static final Target INPUT_BUSCAR_OFICINA = Target.the("Escribir Oficina").locatedBy("//*[@id=\"txtSearch\"]");
    public static final Target BUTTON_BUSCAR_OFICINA = Target.the("Buscar Oficina").locatedBy("//*[@id=\"ctl00_PlaceHolderMain_g_f7685c60_a054_442d_bbdf_c5b4207b1300_ctl00_divCuerpo\"]/div[1]/div[3]/table/tbody/tr/td/a");
    public static final Target BUTTON_OFICINA_ENCONTRADA = Target.the("Seleccionar Oficina").locatedBy("//*[@id=\"WebPartctl00_m_g_159ad82d_45f3_4973_aaac_343f3efe3a22\"]/div/div[2]/ol/li/a");



}
