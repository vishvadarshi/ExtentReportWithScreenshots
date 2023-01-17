package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    By loginButton = By.id("nav-login");
    By homeText = By.xpath("//h1[text()='Jupiter Toys']");

    public BasePage(WebDriver driver){

        this.driver = driver;
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String homepageText(){
        String homepageParaTitle = driver.findElement(homeText).getText();
        return homepageParaTitle;
    }

}
