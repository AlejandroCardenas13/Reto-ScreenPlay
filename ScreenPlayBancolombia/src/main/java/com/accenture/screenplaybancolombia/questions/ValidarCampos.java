package com.accenture.screenplaybancolombia.questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentlyEnabled;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class ValidarCampos implements Question<Boolean> {
	
	private final Target target;

	
	public ValidarCampos(Target target) {
		this.target=target;

	}
		
	@Override
	@Step("{0} valida #target sea visible")
	public Boolean  answeredBy(Actor actor) {
		//System.out.println(target.getName());
		//System.out.println(CurrentlyEnabled.of(target).viewedBy(actor).asBoolean());
		if(CurrentlyEnabled.of(target).viewedBy(actor).asBoolean()==true) {
			System.out.println("La alerta "+target.getName()+" está visible");
		}
		else {
			System.out.println("La alerta "+target.getName()+ " no está visible");
		}
		return (CurrentlyEnabled.of(target).viewedBy(actor).asBoolean());
		
	}
	
	public static ValidarCampos on(Target target) {		
		return new ValidarCampos(target);
	}

}
