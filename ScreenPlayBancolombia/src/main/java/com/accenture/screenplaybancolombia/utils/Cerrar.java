package com.accenture.screenplaybancolombia.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Cerrar {
	
	public static String on(WebDriver driver, String windowTitle) {
		  Set<String> handles = driver.getWindowHandles();
		  String currentHandle = driver.getWindowHandle();
		  for (String handle : handles) {
		    driver.switchTo().window(handle);
		    if (windowTitle.equalsIgnoreCase(driver.getTitle())) {
		      break;
		    }
		  }

		  return currentHandle;
		}


		// How to use method


}
