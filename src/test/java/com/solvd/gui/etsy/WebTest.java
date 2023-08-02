package com.solvd.gui.etsy;

import com.solvd.gui.ios.HomePage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.CarinaDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    @MethodOwner(owner="akalil")
    public void validateLandingPage() {
        HomePage homePage=new HomePage(getDriver());
        homePage.open();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle =getDriver().getTitle();

        String expectedURL = "https://www.etsy.com/?ref=lgo";
        String actualURL = getDriver().getCurrentUrl();

        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertEquals(expectedURL, actualURL);

    }

}
