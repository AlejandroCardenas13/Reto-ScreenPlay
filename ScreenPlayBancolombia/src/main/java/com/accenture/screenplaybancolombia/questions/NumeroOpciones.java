package com.accenture.screenplaybancolombia.questions;

import com.accenture.screenplaybancolombia.userinterface.SimuladorAhorroPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class NumeroOpciones implements Question<Integer> {
	private SimuladorAhorroPage simuladorAhorroPage;
	
	public NumeroOpciones() {

	}

	@Override
	
	public Integer answeredBy(Actor actor) {
		System.out.println(simuladorAhorroPage.listaOpciones().size());
		return simuladorAhorroPage.listaOpciones().size();
	}

	public static NumeroOpciones on() {
		return new NumeroOpciones();
	}

}
