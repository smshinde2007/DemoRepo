package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase
{

	public static WebDriver driver;
	public static Properties prop;
	
	//constructor of Base class
	public TestBase()
	{
		try
		{
			prop= new Properties();
			FileInputStream fis= new FileInputStream("C:/Users/Nitin/eclipse-workspace/amazonDemo/src/main/java/config/config.properties");
			prop.load(fis);	
		}
		catch(IOException e)
		{
			e.getMessage();		}
	}
	
	public static void initilization()
	{
		String browerName=prop.getProperty("browser");
		
		if(browerName.equals("Chrome"))
		{
			String projectPath= System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.river", projectPath+"src/test/resources/driver/chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browerName.equals("IE"))
		{
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Right track");
		driver.get(prop.getProperty("url"));
			
		
	}
}
