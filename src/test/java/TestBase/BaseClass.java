package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    public Properties p;
    
    @BeforeClass(groups = {"sanity", "regression"})
    @Parameters({"browser","os"})
    public void setup(String br,String os) throws IOException {  // ✅ FIX: @Optional added

        // Loading Config .properties file
        FileReader pfile = new FileReader(".//src//test//resources//config.properties");
        p = new Properties();
        p.load(pfile);
        logger = LogManager.getLogger(this.getClass());
        if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
        	DesiredCapabilities capabilities = new DesiredCapabilities();
         //os
        	if(os.equalsIgnoreCase("windows"))
        	{
        		capabilities.setPlatform(Platform.WIN11);
        		        		
        	}
        	
        	else if(os.equalsIgnoreCase("mac"))
        	{
        		capabilities.setPlatform(Platform.MAC);
        		        		
        	}
        	else if(os.equalsIgnoreCase("linux"))
        	{
        		capabilities.setPlatform(Platform.LINUX);
        		        		
        	}
        	else {
        		System.out.println("No OS is selected");
        		
        	}
        	                    	//browser 
        	switch (br.toLowerCase())
        	{
        	case "chrome" :capabilities.setBrowserName("chrome"); break;
        	case "edge" :capabilities.setBrowserName("MicrosoftEdge");break;
        	default: System.out.print("No browser found");return;
        	
        	}
        	
        	 driver=new RemoteWebDriver(new URL ("http://192.168.0.105:4444/wd/hub"),capabilities);
        	
        }

   
        else if(p.getProperty("execution_env").equalsIgnoreCase("local")) 
        {
        switch (br.toLowerCase()) {
            case "chrome": driver = new ChromeDriver(); break;
            case "edge":   driver = new EdgeDriver();   break;
            default:
                System.out.println("Invalid Browser Name: " + br);
                return;
        }}

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        // ✅ FIX: Create screenshots folder if it doesn't exist
        targetFile.getParentFile().mkdirs();
        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }

    @AfterClass(groups = {"sanity", "regression"})
    public void tearDown() {
      driver.quit();
        logger.info("Test End and Browser closed");
    }

    public String randomString(String name) {
        String randomEmail = name + new Random().nextInt(10000) + "@gmail.com";
        return randomEmail;
    }
}