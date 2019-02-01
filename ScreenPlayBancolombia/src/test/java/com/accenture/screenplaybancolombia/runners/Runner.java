package com.accenture.screenplaybancolombia.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/features", 
		glue= {"com.accenture.screenplaybancolombia.stepdefinitions"},
		tags= {"@Caracteristica1","~@Esc2"},
		snippets=SnippetType.CAMELCASE,
		monochrome=true,
		dryRun=false,
		plugin= {"json:reportJson/cucumber.json"}
		)
public class Runner {

}