package com.accenture.screenplaybancolombia.stepdefinitions;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.containsString;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import com.accenture.screenplaybancolombia.interactions.CloseTab;
import com.accenture.screenplaybancolombia.questions.NumeroOpciones;
import com.accenture.screenplaybancolombia.questions.ValidarAlerta;
import com.accenture.screenplaybancolombia.questions.ValidarCampos;
import com.accenture.screenplaybancolombia.questions.ValidarMaximo;
import com.accenture.screenplaybancolombia.questions.ValidarSelect;
import com.accenture.screenplaybancolombia.tasks.GoTo;
import com.accenture.screenplaybancolombia.tasks.OpenTheBrowser;
import com.accenture.screenplaybancolombia.tasks.Write;
import com.accenture.screenplaybancolombia.userinterface.GrupoBancolombiaPage;
import com.accenture.screenplaybancolombia.userinterface.SimuladorAhorroPage;
import com.accenture.screenplaybancolombia.utils.Cerrar;
import com.accenture.screenplaybancolombia.utils.DatoExcel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

public class StepsDefinitions1 {

	@Managed(driver = "chrome")
	private WebDriver hisBrowser;

	private Actor alejo = Actor.named("Alejo");// Es el encargado de ejecutar tareas
	// En screenplay no se hace uso del driver directamente

	private GrupoBancolombiaPage grupoBancolombiaPage;
	private Cerrar robotkey;
	private SimuladorAhorroPage simuladorAhorroPage;

	@Before
	public void setUp() {
		// Inicializar
		alejo.can(BrowseTheWeb.with(hisBrowser));
		hisBrowser.manage().window().maximize();

	}

	@Given("^que Accenture	Testing abrio el navegador en la pagina de bancolombia persona y accede al formulario simulador de ahorro$")
	public void accederAlFormulario() throws AWTException {
		// Precondiciones
		// --> @Given wasAbleTo
		// El retorno del metodo on me retorna una instancia de la clase
		alejo.wasAbleTo(OpenTheBrowser.at(grupoBancolombiaPage), GoTo.theApp(grupoBancolombiaPage.BTN_NECESIDADES),
				GoTo.theApp(grupoBancolombiaPage.BTN_CARRO_MOTO), GoTo.theApp(grupoBancolombiaPage.BTN_SIMULAR_AHORRO),
				CloseTab.Close(hisBrowser));

	}

	// When

	@When("^Accenture Testing quiere enviar el formulario vacio con todos sus campos vacios$")
	public void camposVacios() {

		// Condiciones
		// --> @When attemptsTo
	}

	@When("^Accenture Testing quiere comparar  las opciones que tiene el select coincidan con el archivo excel$")
	public void compararConElExcel() {

		alejo.attemptsTo(GoTo.theApp(simuladorAhorroPage.SELECT_AHORAR));

	}

	@When("^Accenture Testing quiere validar que uno de los campos valide al ingresar un valor$")
	public void tiposDeDatos() {

		String value = "5";
		alejo.attemptsTo(Write.on(simuladorAhorroPage.INPUT_MESES, value));
		// Organizar esta tarea quiero que sea isVisible
	}

	@When("^Accenture Testing quiere validar el valor maximo del campo En cuantos meses te gustaria alanzar tu meta$")
	public void valorMaximo() {

		String value = "300";
		alejo.attemptsTo(Write.on(simuladorAhorroPage.INPUT_MESES, value));
	}

	@When("^Accenture Testing quiere ingresar un dato invalido$")
	public void IngresarUnDatoInvalidoEnCampoDeCuantoDineroTeFalta() {
		String valueMeta = "4500000000";

		alejo.attemptsTo(Write.on(simuladorAhorroPage.INPUT_META, valueMeta));

	}

	@When("^Accenture Testing quiere dar click en un boton inhabilitado$")
	public void GenerarExcepcion() {

		alejo.attemptsTo(GoTo.theApp(simuladorAhorroPage.BTN_AGREGAR));
		// Aqui voy a implementar la excepción
	}

	// Then

	@Then("^Accenture Testing espera  que todas las alertas esten presentes con cada campo del formulario$")
	public void validarCamposVacios() {
		// Consecuencias --> Lo que pasa Should
		alejo.should(eventually(seeThat(ValidarCampos.on(simuladorAhorroPage.ALERT_INPUT_MESES))),
				seeThat(ValidarCampos.on(simuladorAhorroPage.ALERT_SELECT_AHORAR)),
				seeThat(ValidarCampos.on(simuladorAhorroPage.ALERT_SELECT_PRODUCTO)),
				seeThat(ValidarCampos.on(simuladorAhorroPage.ALERT_INPUT_MESES))

		);

	}

	@Then("^Accenture Testing espera que cada el numero de opciones y el nombre de cada elemento coincida con el archivo excel$")
	public void validarDatosDelExcel() throws Exception {
		DatoExcel.setExcelFile(
				"C:\\Users\\a.cardenas\\eclipse-workspace\\ScreenPlayBancolombia\\src\\test\\resources\\Excel\\Datos Campo.xlsx",
				"Sheet1");
		System.out.println(DatoExcel.getCellData(3, 0));
		// alejo.should(seeThat());
		alejo.should(seeThat(ValidarSelect.on("Viaje"), containsString(DatoExcel.getCellData(0, 0))),
				seeThat(ValidarSelect.on("Educación"), containsString(DatoExcel.getCellData(1, 0))),
				seeThat(ValidarSelect.on("Vivienda"), containsString(DatoExcel.getCellData(2, 0))),
				seeThat(ValidarSelect.on("Vehículo"), containsString(DatoExcel.getCellData(3, 0))),
				seeThat(ValidarSelect.on("Entretenimiento"), containsString(DatoExcel.getCellData(4, 0))),
				seeThat(ValidarSelect.on("Retiro para la vejez"), containsString(DatoExcel.getCellData(5, 0))),
				seeThat(ValidarSelect.on("Otro"), containsString(DatoExcel.getCellData(6, 0))),
				seeThat(NumeroOpciones.on(), comparesEqualTo(8)));

	}

	@Then("^Accenture Testing espera que la alerta del campo desaparezca$")
	public void recibirValidacionDeTiposDeDatos() {
		alejo.should(seeThat(ValidarAlerta.on(simuladorAhorroPage.ALERT_INPUT_MESES), comparesEqualTo(true)));
	}

	@Then("^Accenture Testing espera que la alerta del campo En cuantos meses te gustaria alanzar tu meta se haga visible$")
	public void recibirValidacionDeValorMaximo() {
		alejo.should(seeThat(ValidarMaximo.on(simuladorAhorroPage.ALERT_INPUT_MESES),
				containsString("El campo no cumple con el valor máximo 240")));
	}

	@Then("^Accenture Testing espera poder ver una alerta que esta mal escrita$")
	public void validarCampoDeCuantoDineroTeFalta() {
		alejo.should(seeThat(ValidarMaximo.on(simuladorAhorroPage.ALERT_INPUT_META),
				containsString("El campo no cumple con el valor mínimo El campo no cumple con el valor máximo")));
	}
}
