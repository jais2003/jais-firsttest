import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class ChromeDriverManger extends DriverManager{
	private ChromeDriverService chService;

	@Override
	protected void startServices() {
		// TODO Auto-generated method stub
        if (chService == null)
        {
        	//Not sure if we can use WebDriverManager.chromedriver().setup();
            try{
                chService = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\chromedriver.exe"))
                        .usingAnyFreePort().build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

	@Override
	protected void stopServices() {
		// TODO Auto-generated method stub
		 if(chService.isRunning())
	            chService.stop();
	}

	@Override
	protected void createDriver() {
		// TODO Auto-generated method stub
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        driver=new ChromeDriver(options);
	}

}
