package com.accenture.screenplaybancolombia.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class ValidarMaximo implements Question<String> {

	private final Target target;

	
	public ValidarMaximo(Target target) {
		this.target=target;

	}
	
	@Override
	@Step("{0} valida el maximo de #target")
	public String answeredBy(Actor actor) {
		System.out.println(Text.of(target).viewedBy(actor).asString());
		return Text.of(target).viewedBy(actor).asString();
	}

	
	public static ValidarMaximo on(Target target) {		
		return new ValidarMaximo(target);
	}
}
