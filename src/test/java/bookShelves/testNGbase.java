package bookShelves;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Factory.BaseClass;


public class testNGbase
{
	public static WebDriver driver;
	 static Properties p;
	 public static Logger logger;
	 @BeforeClass(groups= {"smoke","regression"})
	public  void setup() throws IOException
    {
    	driver=BaseClass.initilizeBrowser();  	
    	p=BaseClass.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().window().maximize();
    
    	logger=LogManager.getLogger(this.getClass());
	}
	
		
    
    @AfterClass(groups= {"smoke","regression"})
    public static void tearDown() {
        		
       driver.quit();
       
    }

}
