package com.accenture.screenplaybancolombia.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class Write implements Task {
	private Target target;
	private String value;
	public Write(Target target,String value) {
		this.target = target;
		this.value=value;
	}

	@Override
	@Step("{0} escribe en #target")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(value).into(target).thenHit(Keys.ENTER));

	}

	public static Write on(Target target,String value) {
		return instrumented(Write.class,target,value);
	}

}
