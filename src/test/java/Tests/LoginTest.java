package Tests;

import Pages.BasePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    //Fail test
    @Test
    public void login(){
        BasePage bp = new BasePage(driver);
        bp.clickLoginButton();
        LoginPage lp = new LoginPage(driver);
        lp.loginToSite("Something", "letmein123");
        Assert.assertTrue(false);
    }
}
