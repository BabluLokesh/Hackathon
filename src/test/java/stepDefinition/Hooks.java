package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Factory.BaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks 
{
	 public static WebDriver driver;
	 static Properties p;
     
	@BeforeAll
    public static void setup() throws IOException
    {
    	driver=BaseClass.initilizeBrowser();
    	    	
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().window().maximize();
    
    			
	}
		
    
    @AfterAll
    public static void tearDown() {
        		
       driver.quit();
       
    }
}
