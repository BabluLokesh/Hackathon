package bookShelves;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ExcelUtilis.UtilisFile;
import Factory.BaseClass;
import ExcelUtilis.UtilisFile;
import pageObjectmodel.ScrollToElement;
import pageObjectmodel.giftcardPage;
import pageObjectmodel.homePage;
import pageObjectmodel.livingPage;

public class BookShelveS extends testNGbase
{
  //public  WebDriver driver;
  public  homePage hp;
  public  livingPage lp;
  public giftcardPage gf;
  public ScrollToElement sc;
  public JavascriptExecutor je;
  List<String> price=new ArrayList<String>();
  List<String> name=new ArrayList<String>();
  List<String> items=new ArrayList<String>();
  
 
  @Test(priority=1, groups= {"smoke"})
  public void open_BookShelves()
  {
	  hp= new homePage(driver);
	  logger.info("Bookshelves is opened");

	  hp.SearchBookshelves();
	  hp.Clicksearch();
  }
  @Test(priority=2,groups= {"smoke"})
  public void close_popup()
  {
	  try 
	  {
		  hp=new homePage(driver);
		  hp.Closepopup();
		  logger.info("Close the pop-up");
	  }
	  catch (Exception e )
	  {
			System.out.println("Website Opened");
	  }
  }
  @Test(priority=3,groups= {"regression"})
  public void  open_category() throws InterruptedException
  {   hp= new homePage(driver);
	  hp.Opencategory();
	  hp.Clickbookshelves();
	  logger.info("Moves over to opencategory and clicks on bookshelves");
  }
  @Test(priority=4,groups= {"regression "},dependsOnGroups= {"smoke"})
  public void price_selection() throws InterruptedException
  {
	  
	  Thread.sleep(5000);
	  hp.Clickprice();
	  logger.info("Moves over to price and keeps the price slider at 15000");
	  //slider 
	  hp.Dragpriceslider();
  }
  @Test(priority=5,groups= {"smoke"})
  public void Click_Excludeoutof_stock() throws InterruptedException
  {
	  
	  hp.ClickExcludeoutofstock();
	  logger.info("Clicks on Exclude out of stock");
	  Thread.sleep(2000);
  }
  @Test(priority=6,groups= {"regression"})
  public void Select_recommended() throws InterruptedException
  {   hp=new homePage(driver);
	  hp.Clickrecommended();
	  logger.info("Moves on to recommnede filter and clicks on price from high to low ");
      Thread.sleep(5000);
      hp.Selectprice();
      
  }
  @Test(priority=7,groups= {"regression"})
  public void Collect_Displayed_Namesofitems() throws FileNotFoundException
  {
	  hp. Collectitemnames();
	  logger.info("Collects the first three products names  after giving all filters");
  }
  @Test(priority=8,groups= {"regression"})
  public void Collect_Displayed_Pricesofitems() throws FileNotFoundException
  {
	  hp.Collectitemsprices();
	  logger.info("Collects the first three products prices  after giving all filters");
  }
  @Test(priority=9,groups= {"smoke"})
  public void open_Living() 
  {
	  lp= new livingPage(driver);
	  lp.Clickliving();
	  logger.info("Clicks on Living page");
  }
  
  @Test(priority=10, groups= {"smoke"})
  public void Select_SeatingandChairs()
  {
	  
	  lp.ClickSeatingandchairs();
	  logger.info("Moves on to Seating and chairs");
	  
  }
  @Test(priority=11, groups= {"regression"})
  public void Collect_listeditems_ofSeatingandchairs() throws IOException, InterruptedException
  {  
      Thread.sleep(2000);
      lp.Collectdisplayeditems();
      logger.info("Collect the items under seating and chairs");
     
	        
	}
    @Test(priority=12,groups= {"smoke"})
    public void go_to_giftcards()
    {
    	
    	lp.gotogiftcard();
    	logger.info("Move on to the giftcards present in the main page and clicks on it");
    	
    }
    @Test(priority=13, groups= {"smoke"})
    public void Scroll_Toheading() throws InterruptedException
    {
    	gf= new giftcardPage(driver);
    	sc=new ScrollToElement(driver);
    	Thread.sleep(5000);
    	gf.scrollheading();
    	logger.info("Scroll down to the Fill the gift cards");
    	
    }
    
    @Test(priority=14, groups= {"smoke"})
    public void  Select_Annivesary()
    {
    	gf=new giftcardPage(driver);
    	gf.Clickanniversary();
    	logger.info("Moves on to the Anniversary giftcard and clicks on it ");
    }
    
    @Test(priority=15, groups= {"smoke"})
    public void coustmize_giftcard()
    {
    	gf= new giftcardPage(driver);
    	gf.Amountselection();
    	logger.info("Select the Amount value of gift");
    }
    @Test(priority=16, groups= {"regression"})
    public void Select_date() throws InterruptedException
    {   
        gf.SelectMonth();
        gf.SelectDate();
        logger.info("Selects the Month and date ");
        Thread.sleep(2000);
    	gf.ClickNext();
    }
    
    @Test(priority=17, groups= {"regression"})
    public void fill_the_form() throws InterruptedException
    {
    	gf= new giftcardPage(driver);
    	gf.RecepientName();
    	gf.SenderName();
    	gf.RecepientEmail();
    	gf.SenderEmail();
    	gf.EroorMessage();
    	gf.RecepientNo();
    	gf.SenderNo();
    	gf.RecepientsAddress();
    	gf.Pincode();
    	Thread.sleep(2000);
    	logger.info("Enters all the details of (Who is the lucky person) with invalid mail address ");
    	
    }
    
    @Test(priority=18, groups= {"smoke"})
    public void Click_confirm() throws InterruptedException, IOException 
    {   
    	gf=new giftcardPage(driver);
    	Thread.sleep(2000);
    	gf.Clickconfirm();
    	logger.info("Clicks on confirm and capture the screenshot of Error message from mail address box");
    }
    
    @Test(priority=19, groups= {"regression"})
    public void Refill_details() throws InterruptedException
    {
        driver.navigate().refresh();
        gf.Scrolltop();
        gf.scrollheading();
        gf.Clickanniversary();
        gf.Amountselection();
        Thread.sleep(2000);
        gf.SelectMonth();
        gf.SelectDate();
    	
    	gf.ClickNext();
    }
    	
        
   @Test(priority=20, groups= {"regression"})
   public void valid_details() throws InterruptedException
   {
    	gf.RecepientName();
    	gf.SenderName();
    	gf.RecepientEmail();
    	gf.Validsender();
        gf.EroorMessage();
    	gf.RecepientNo();
    	gf. SenderNo();
    	gf.RecepientsAddress();
    	gf.Pincode();
    	Thread.sleep(2000);
    	
    }
   
   @Test(priority=21, groups= {"smoke"})
   public void click_confirm() throws InterruptedException
   {
	
	       
	    	gf=new giftcardPage(driver);
	    	Thread.sleep(2000);
	    	gf.clickconfirm();
	    	logger.info("Now agains fills all the details of (who is lucky person) with all valid details");
	          
	    
   }
    
  
  
//  @AfterClass
//  public void tear_down()
//  {
//	  driver.quit();
//	  logger.info("Website closes");
//  }
}
