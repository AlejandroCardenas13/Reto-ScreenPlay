package com.accenture.screenplaybancolombia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarAlerta implements Question<Boolean> {

	private final Target target;

	
	public ValidarAlerta(Target target) {
		this.target=target;

	}
	
	@Override
	public Boolean answeredBy(Actor actor) {

		System.out.println(Visibility.of(target).viewedBy(actor).asBoolean());
		return Visibility.of(target).viewedBy(actor).asBoolean();
	}
	
	public static ValidarAlerta on(Target target) {		
		return new ValidarAlerta(target);
	}
	
}
