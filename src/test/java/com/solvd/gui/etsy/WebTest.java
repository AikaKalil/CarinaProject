package com.solvd.gui.etsy;

import com.nordstrom.automation.testng.DataProviders;
import com.solvd.gui.common.HomePageCommon;
import com.solvd.gui.desktop.CandlePage;
import com.solvd.gui.desktop.CartPage;
import com.solvd.gui.desktop.HomePage;
import com.solvd.gui.desktop.SignInPage;
import com.solvd.gui.ios.HomePageIOS;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class WebTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "akalil")
    public void validateHomePage() {
        HomePageIOS homePage = (HomePageIOS) initPage(getDriver(), HomePageCommon.class);
        homePage.open();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isPageOpened(),"Home page is not opened");
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = getDriver().getTitle();
        String expectedURL = "https://www.etsy.com/?ref=lgo";
        String actualURL = getDriver().getCurrentUrl();
        assertEquals(expectedTitle, actualTitle);
        assertEquals(expectedURL, actualURL);
    }
    @Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
    @MethodOwner(owner = "akalil")
    public void negativeTestCaseSignIn(String email, String password){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnSignInBtn();
        SignInPage signInPage=homePage.clickOnSignInBtn();
        signInPage.signInFeature("m.aijamal@gmail.com","Akalil1234");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(signInPage.getErrorText(),"Email address is invalid.");
        softAssert.assertAll();
    }

    @Test
    @MethodOwner(owner = "akalil")
    public void testSearchItem(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        CandlePage candlePage=homePage.searchItem("candle");
        candlePage.clickOnMostLoved();
        candlePage.clickOnSecondItem();
        candlePage.goToFirstOption();
        candlePage.addToCart();
        CartPage cartPage = candlePage.cartPage();
        SoftAssert softAssert=new SoftAssert();
        //here this one need to check also something
    }
    @Test
    @MethodOwner(owner = "akalil")
    public void testCartPage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        CartPage cartPage = homePage.clickOnCartBtn();
        cartPage.clickOnRemove();
        //this one needs to check empty message
    }



}
