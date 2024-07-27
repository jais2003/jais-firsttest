import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.junit.ArrayAsserts;

import com.google.common.base.Predicate;
import com.google.common.base.Verify;

import java.io.File;
import java.lang.reflect.Array;
import java.sql.Time;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestNgTest extends BaseClass {
	   /* Get the class name to be printed on */  
	   private static final Logger LOGGER = Logger.getLogger(TestNgTest.class.getName());
	
	@Test
	public void factoryPattern() throws InterruptedException
	{
		System.out.println("Running Test 1");
	}
	   
	@Test
	public void pageValidation()
	{
		System.out.println("Running Test 2");
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle,"Title does not match");
	}
	   
	   
	   
    @Test
	public void testNgTestA() {
		//==================================================================================
		// Implementation of Log4J
		LOGGER.setLevel(Level.INFO);
		LOGGER.debug("Hello this is debug message");
		LOGGER.info("Hello this is info message");
		System.out.println("Running Test 3. Related to TestNG and ManageWebDriver experiment");

		
		
		//==================================================================================
	    //Understanding Selenium hierarchy. Using RemoteWebDriver vs using WebDriver
//		RemoteWebDriver driver1 = new ChromeDriver();
//		driver1.getScreenshotAs(OutputType.FILE);
//		//----------
//		WebDriver driver2 = new ChromeDriver();
//		File scrFile = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);

		//System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");  
//		System.clearProperty("webdriver.chrome.driver");
//		WebDriverManager.chromedriver().setup();
//		//Implement fluent wait
//		final WebDriver driver3 = new ChromeDriver();
//		driver3.manage().window().maximize();
//		driver3.get("https://www.google.com");
//		//0 Sec. System.out.println(driver3.manage().timeouts().getImplicitWaitTimeout().getSeconds());
//		//30 Sec. System.out.println(driver3.manage().timeouts().getScriptTimeout().getSeconds());
//		//300 Sec. System.out.println(driver3.manage().timeouts().getPageLoadTimeout().getSeconds());

	
	
//	WebElement countdown = driver3.findElement(By.id("APjFqb"));
//		FluentWait <WebElement>fluentWaitOld  =new FluentWait<WebElement>(countdown)
//	    .withTimeout(Duration.ofSeconds(10))
//        .pollingEvery(Duration.ofMillis(100))
//        .until(new Predicate<WebElement>() {
//        	public boolean apply(WebElement element) {
//                return element.getText().endsWith("04");
//            }
//        }
//        );
//		
//		driver3.quit();
		
		//==================================================================================
//        // Implementation of Webdriver in firefox. 
//		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");  
//		//System.clearProperty("webdriver.gecko.driver");
//		WebDriver drv = new FirefoxDriver();
//		drv.manage().window().maximize();
//		drv.get("https://www.google.com");
//		String expectedTitle = "Google";
//		String actualTitle = drv.getTitle();
//		Assert.assertEquals(expectedTitle, actualTitle,"Title does not match");
//		drv.switchTo().frame("callout");
//		System.out.println("Start time before finding button:"+System.currentTimeMillis());
//		try{
//		WebElement popUp = drv.findElement(By.xpath("//button[contains(@class, 'M')]"));
//		System.out.println("Clicking on Stay signed out");
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		popUp.click();
//		}
//		catch(Exception ex)
//		{
//			//No exception
//		}
//		System.out.println("Endtime before finding button:"+System.currentTimeMillis());
//
//		drv.switchTo().parentFrame();
//		WebElement textArea = drv.findElement(By.id("APjFqb"));
//		textArea.sendKeys("Javascript book");
//        //How to send enter key
//		textArea.sendKeys(Keys.RETURN);
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		System.out.println("Done with the test");
//	    drv.quit();

	  //==================================================================================
//	    // Sample code to know soft assert behavior
//	    SoftAssert soft = new SoftAssert();
//	    soft.assertEquals("a", "b");
//	    soft.assertEquals(true, false);
//	    soft.assertAll();
	}

}
