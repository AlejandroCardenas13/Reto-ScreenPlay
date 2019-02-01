package com.accenture.screenplaybancolombia.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.accenture.screenplaybancolombia.exceptions.ButtonException;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class GoTo implements Task {
	
	private Target googleApp;
	
	public GoTo(Target googleApp) {
		this.googleApp = googleApp;
	}
	
	@Override
	@Step("{0} goes to #googleApp")
	public <T extends Actor> void performAs(T actor) {
		try {
			actor.attemptsTo(Click.on(googleApp));
		}catch (Exception e) {
			throw new ButtonException();
		}
		
	}

	public static GoTo theApp(Target googleApp) {		
		return instrumented(GoTo.class, googleApp);
	}

}
