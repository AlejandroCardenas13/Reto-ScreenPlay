package com.accenture.screenplaybancolombia.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class CloseTab implements Interaction {
	
	private WebDriver webdriver;
	
	public CloseTab(WebDriver webdriver) {
		this.webdriver=webdriver;
	}
	
	@Override
	public <T extends Actor> void performAs(T actor) {
        String parent=webdriver.getWindowHandle(); // It will return the parent window name as a String
        Set<String>s1=webdriver.getWindowHandles();// This will return the number of windows opened by Webdriver and will return Set of St//rings
        Iterator<String> I1= s1.iterator(); // Now we will iterate using Iterator
        

        while(I1.hasNext())
        {
        
           String child_window=I1.next();
        
        // Here we will compare if parent window is not equal to child window then we            will close
        
        if(!parent.equals(child_window))
        {
                        webdriver.switchTo().window(child_window);
        
                        System.out.println(webdriver.switchTo().window(child_window).getTitle());
        
                        //browser.close();
        }
        
        }
        // once all pop up closed now switch to parent window
//    browser.switchTo().window(parent);

	}
	
	public static CloseTab Close(WebDriver webDriver) {		
		return instrumented(CloseTab.class,webDriver );
	}

}
