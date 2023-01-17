package Tests;

import Pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{

    //Pass test
    @Test
    public void homeTitle(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Jupiter Toys");
    }

    //Fail test
    @Test
    public void verifyHomepageParaText(){
        BasePage bp = new BasePage(driver);
        String text = bp.homepageText();
        Assert.assertEquals(text, "Jupiter");
    }

}
