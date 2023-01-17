package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    By userName = By.id("loginUserName");
    By password = By.id("loginPassword");
    By loginbutton = By.xpath("//button[text()= 'Login']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void loginToSite(String uName, String pword){
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(uName);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pword);
        driver.findElement(loginbutton).click();
    }
}
