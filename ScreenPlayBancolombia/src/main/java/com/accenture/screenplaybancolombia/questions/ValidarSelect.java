package com.accenture.screenplaybancolombia.questions;

import com.accenture.screenplaybancolombia.userinterface.SimuladorAhorroPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Enabled;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class ValidarSelect implements Question<String> {

	private String opcion;
	private SimuladorAhorroPage simuladorAhorro;
	
	public ValidarSelect(String opcion) {
		this.opcion=opcion;
	}
	
	@Override
	@Step("{0} valida que #opcion este presente en el select")
	public String answeredBy(Actor actor) {
		Target target=simuladorAhorro.opcion(opcion);
		System.out.println(target);
		if(Enabled.of(target).viewedBy(actor).asBoolean()==true) {
			System.out.println("La opción "+opcion+" se encuentra en el campo 'Para que quieres ahorrar'");
		}
		else {
			System.out.println("La opción"+opcion+ " no se encuentra en el campo 'Para que quieres ahorrar");
		}
		return Text.of(target).viewedBy(actor).asString();
	}
	
	public static ValidarSelect on(String opcion) {		
		return new ValidarSelect (opcion);
	}
	
}
