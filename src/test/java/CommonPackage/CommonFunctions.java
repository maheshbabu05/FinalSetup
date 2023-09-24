package CommonPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	public static WebDriver driver=null;
	public static Properties properties=null;
	
	public Properties loadpropertyfile() throws IOException {
		FileInputStream fileinputStream = new FileInputStream ("Config.properties");
		Properties properties = new Properties();
		properties.load(fileinputStream);
		return properties;
		
		
	}
	
	
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		loadpropertyfile();
		String browser = properties.getProperty("browser");
		String url= properties.getProperty("url");
		String driverlocation=properties.getProperty("./Driver/chromedriver.exe");
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", driverlocation);
			driver= new ChromeDriver();
			
			
		}
		else if (browser.equalsIgnoreCase("Firefox"))
			System.setProperty("webdriver.gecko.driver", driverlocation);
		    driver= new FirefoxDriver();
		    
		    driver.manage().window().maximize();
		    driver.get(url);
		    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		    
			
		{
			
		}
		
	}
	
	
	
	
	
	@AfterSuite
	public void teardown() {
	//	driver.quit();
		
	}

}
