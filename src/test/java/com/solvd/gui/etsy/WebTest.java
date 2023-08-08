package com.solvd.gui.etsy;

import com.nordstrom.automation.testng.DataProviders;
import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.common.HomePageAbstract;
import com.solvd.gui.pages.desktop.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "akalil")
    public void validateHomePage() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home page is not opened");
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = getDriver().getTitle();
        String expectedURL = "https://www.etsy.com/?ref=lgo";
        String actualURL = getDriver().getCurrentUrl();
        assertEquals(expectedTitle, actualTitle);
        assertEquals(expectedURL, actualURL);
    }

    @Test
    @MethodOwner(owner = "akalil")
    public void invalidEmailTestSignIn() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header=homePage.getHeader();
        SignInPage signInPage=header.clickOnSignInBtn();
        signInPage.signIn("akalil@gmail.com","343r43");
        signInPage.clickOnPopUpWindowSignInBtn();
        assertEquals(signInPage.getErrorText(),"Email address is invalid.");
    }

    @Test
    @MethodOwner(owner = "akalil")
    public void validEmailTestSignIn() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header=homePage.getHeader();
        SignInPage signIn=header.clickOnSignInBtn();
        signIn.signIn("m.aijamal07@icloud.com","AikaK07");
        signIn.clickOnPopUpWindowSignInBtn();
        assertEquals(signIn.getWelcomeBackMessage(),"Welcome to Etsy, Aika!");
    }

    @Test
    @MethodOwner(owner = "akalil")
    public void testCartPage() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header=homePage.getHeader();
        CartPage cartPage=header.clickOnCartBtn();
        assertEquals(cartPage.getEmptyCartMsg(),"Your cart is empty.");
    }
    @Test
    @MethodOwner(owner = "akalil")
    public void testSearchItem() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header=homePage.getHeader();
        ProductPage productPage=header.searchForProduct("candle");
        productPage.clickOnMostLoved();
        productPage.addToCart();
        assertEquals(header.itemsInCartMsg(),"1 item in your cart");






    }


}
