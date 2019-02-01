@Caracteristica1
Feature: Simulacion de un ahorro en Bancolombia para adquirir una moto
COMO un usuario Bancolombia Alejandro Cardenas
QUIERO validar que el formulario de simulador de ahorro este funcionando correctamente
PARA saber mi plan de ahorro e inversion

Background: Abrir el navegador en la pagina web Bancolombia y desde personas acceder al formulario simulador de ahorro
Given que Accenture	Testing abrio el navegador en la pagina de bancolombia persona y accede al formulario simulador de ahorro

@Esc1
Scenario: Prueba a realizar - Validar que cada campo vacio sea obligatorio
When Accenture Testing quiere enviar el formulario vacio con todos sus campos vacios 
Then Accenture Testing espera  que todas las alertas esten presentes con cada campo del formulario


@Esc2
Scenario: Prueba a realizar - Validar que en el campo Para que quieres ahorrar coincida con el archivo excel
When Accenture Testing quiere comparar  las opciones que tiene el select coincidan con el archivo excel
Then Accenture Testing espera que cada el numero de opciones y el nombre de cada elemento coincida con el archivo excel


@Esc3
Scenario: Prueba a realizar - Validar que el campo meses para alcanzar la meta funcione correctamente
When Accenture Testing quiere validar que uno de los campos valide al ingresar un valor
Then Accenture Testing espera que la alerta del campo desaparezca


@Esc4
Scenario: Prueba a realizar - Validar que el campo meses para alcanzar la meta valide el valor maximo correctamente
When Accenture Testing quiere validar el valor maximo del campo En cuantos meses te gustaria alanzar tu meta
Then Accenture Testing espera que la alerta del campo En cuantos meses te gustaria alanzar tu meta se haga visible

@Esc5
Scenario: Prueba a realizar - Validar que el campo cuanto dinero te falta para lograr tu meta genere una alerta que erronea
When Accenture Testing quiere ingresar un dato invalido
Then Accenture Testing espera poder ver una alerta que esta mal escrita

@Esc6
Scenario: Prueba a realizar - Generar una excepcion
When Accenture Testing quiere dar click en un boton inhabilitado


