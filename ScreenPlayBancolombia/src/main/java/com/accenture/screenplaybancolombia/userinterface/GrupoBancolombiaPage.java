package com.accenture.screenplaybancolombia.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.grupobancolombia.com/wps/portal/personas")
public class GrupoBancolombiaPage extends PageObject {
	public static final Target BTN_NECESIDADES = Target.the("Necesidades").locatedBy("//*[@id='main-menu']/div[2]/ul[1]/li[2]/a");
	public static final Target BTN_CARRO_MOTO= Target.the("Carro o Moto").locatedBy("//*[@id='necesidadesPersonas']/div/div[1]/div[1]/div/div[7]/div/a");
	public static final Target BTN_SIMULAR_AHORRO= Target.the("Simulador de Ahorro").locatedBy("//*[@id='wizard1']/div/div[1]/div/div/div[1]/p[2]/strong/a");
}
