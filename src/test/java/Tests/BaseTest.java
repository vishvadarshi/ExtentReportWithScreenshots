package Tests;

import Framework.ITestListenerClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

@Listeners(ITestListenerClass.class)
public class BaseTest {

    public static WebDriver driver;

    //ExtentReportsClass er = new ExtentReportsClass();


    @BeforeMethod
    public static void setup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\107.0.5304.62\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://jupiter.cloud.planittesting.com/#/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){

            driver.quit();
        }
}
