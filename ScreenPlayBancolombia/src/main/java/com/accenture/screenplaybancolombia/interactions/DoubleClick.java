package com.accenture.screenplaybancolombia.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

/**
 * Custom Action using a low-level WebDriver API
 */
public class DoubleClick implements Interaction{
	
    private final Target target;

    public DoubleClick(Target target) {
        this.target = target;
    }
    
    @Step("{0} double-clicks on #target")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(DoubleClick.on(target));

        
    }

    public static DoubleClick on(Target target) {
        return instrumented(DoubleClick.class, target);
    }






}
