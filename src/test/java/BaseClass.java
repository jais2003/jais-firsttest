import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  
{
	DriverManager driverManger;
	WebDriver driver ;
	
@BeforeTest  //Runs before first tag with @test
public void beforeTest() throws InterruptedException {
	System.out.println("Hello I ran before the first @test");
	 driverManger  = DriverManagerFactory.getManger(DriverType.CHROME) ;
	 driver = driverManger.getDriver();
	 driver.get("https://www.google.com");
	 ActionHelper.FluentWaitForElement(driver, By.id("APjFqb"));  
}


@BeforeMethod  //Runs before each tag with @test
public void beforeMethod()
{
	System.out.println("Hello I ran before the each @test");

}

@AfterMethod
public void afterMethod() throws InterruptedException
{
	System.out.println("Hello I ran after each @test");
	driverManger.stopServices();
    Thread.sleep(2000);
}

@AfterSuite
public void AfterSuite() {
	System.out.println("Hello I ran after your suite");
	driverManger.quitDriver();
}

	
}
