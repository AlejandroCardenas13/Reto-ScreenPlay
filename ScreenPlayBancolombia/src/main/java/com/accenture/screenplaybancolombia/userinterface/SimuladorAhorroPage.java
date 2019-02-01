package com.accenture.screenplaybancolombia.userinterface;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

public class SimuladorAhorroPage extends PageObject {
	// public static String opcion="";

	public static final Target SELECT_AHORAR = Target.the("Para que quieres Ahorar")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[2]/select");
	public static final Target INPUT_MESES = Target.the("En cuantos meses")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[3]/input");
	public static final Target SELECT_PRODUCTO = Target.the("Seleccionar tipo de cuenta")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[4]/select");
	public static final Target INPUT_META = Target.the("Cuanto te falta para alcanzar tu meta")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[5]/input");
	public static final Target BTN_AGREGAR = Target.the("Agregar al plan de ahorros")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[8]/button");

	public static final Target ALERT_SELECT_AHORAR = Target.the("Alerta de Ahorrar")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[2]/div");
	public static final Target ALERT_INPUT_MESES = Target.the("Alerta de meses")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[3]/div");
	public static final Target ALERT_SELECT_PRODUCTO = Target.the("Alerta tipo de cuenta")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[4]/div");
	public static final Target ALERT_INPUT_META = Target.the("Alerta de tu meta")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[5]/div");
	
	
	
	public static final Target OPCION_SELECT_AHORRAR = Target.the("Opcion seleccionar tipo para que quieres ahorrar")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[2]/select/option[3]");
	public static final Target OPCION_SELECT_PRODUCTO = Target.the("Opcion seleccionar tipo de cuenta")
			.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[4]/select/option[1]");

	public Target opcion(String opc) {

		Target OPTIONS_SELECT_AHORAR = Target.the("Opciones Para que quieres Ahorar")
				.locatedBy("//*[@id='browser-Off']/div/div/div[1]/form/div[2]/select/option[text() ='" + opc + "']");
		return OPTIONS_SELECT_AHORAR;
	}

//Más adelante
	public List<WebElementFacade> listaOpciones() {
		List<WebElementFacade> listaOpc = findAll(
				By.xpath("//*[@id='browser-Off']/div/div/div[1]/form/div[2]/select/option"));
		return listaOpc;
	}
}
