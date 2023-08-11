package com.solvd.gui.etsy;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.common.HomePageAbstract;
import com.solvd.gui.pages.desktop.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTest implements IAbstractTest {

//    @Test
//    @MethodOwner(owner = "akalil")
//    public void invalidEmailTestSignIn() {
//        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
//        homePage.open();
//        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
//        Header header = homePage.getHeader();
//        SignInPage signInPage = header.clickOnSignInBtnHP();
//        signInPage.typeCredentials("akalil@gmail.com", "343r43");
//        signInPage.clickOnPopUpWindowSignInBtn();
//        assertEquals(signInPage.getErrorText(), "Email address is invalid.", "Actual text doesn't match expected text!");
//    }
//
//    @Test
//    @MethodOwner(owner = "akalil")
//    public void validEmailTestSignIn() {
//        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
//        homePage.open();
//        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
//        Header header = homePage.getHeader();
//        SignInPage signIn = header.clickOnSignInBtnHP();
//        signIn.typeCredentials("m.aijamal07@icloud.com", "AikaK07");
//        signIn.clickOnPopUpWindowSignInBtn();
//        assertEquals(signIn.getWelcomeBackMessage(), "Welcome to Etsy, Aika!", "Actual text doesn't match expected text!");
//    }

    @Test(dataProvider = "testData", dataProviderClass = DataProvider.class)
    @MethodOwner(owner = "akalil")
    public void testSignIn(String email, String password) {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header = homePage.getHeader();
        SignInPage signIn = header.clickOnSignInBtnHP();
        signIn.typeCredentials(email, password);
        signIn.clickOnPopUpWindowSignInBtn();
        if (email.equals("akalil.laba@solvd.com") && password.equals("AikaK07")) {
            assertEquals(signIn.getWelcomeBackMessage(), "Welcome to Etsy, Aika!", "Actual text doesn't match expected text!");
        } else if (email.equals("akalil.laba@solvd.com") && password.equals("0987654321")) {
            assertEquals(signIn.errorMsgIncorrectPass(), "Password was incorrect", "Actual text doesn't match expected text!");
        } else if (email.equals("qwert][poiu") && password.equals("98")) {
            assertEquals(signIn.errorMsgIncorrectEmail(), "Username is invalid", "Actual text doesn't match expected text!");

        }
    }

    @Test
    @MethodOwner(owner = "akalil")
    public void testCartPage() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header = homePage.getHeader();
        CartPage cartPage = header.clickOnCartBtn();
        assertEquals(cartPage.getEmptyCartText(), "Your cart is empty.", "Actual text doesn't match expected text");
    }

    @Test
    @MethodOwner(owner = "akalil")
    public void testSearchItem() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header = homePage.getHeader();
        ProductPage productPage = header.searchForProduct("candle");
        productPage.clickAllFilters();
        productPage.selectOnSale();
        productPage.clickApplyBtn();
        assertEquals(productPage.getOnSaleText(), "On Sale", "Actual text doesn't match expected!");

    }
    @Test
    @MethodOwner(owner = "akalil")
    public void testAddToCart() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header = homePage.getHeader();
        ProductPage productPage = header.searchForProduct("candle");
        productPage.clickAddToCartBtn(4);
        CartPage cartPage=productPage.clickPage();
        assertEquals(cartPage.getItemsInCartText(),"1 item in your cart","Actual text is different than expected text!");
        cartPage.clickOnRemoveBtn();
        assertEquals(cartPage.getEmptyCartText(),"Your cart is empty.","Actual text is different than expected text!");

    }

    @Test
    @MethodOwner(owner = "akalil")
    public void testRegisterWithExistingAccount() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header = homePage.getHeader();
        SignInPage signIn = header.clickOnSignInBtnHP();
        signIn.clickOnPopUpWindowRegisterBtn();
        signIn.typeCredentials("m.aijamal07@icloud.com", "AikaK07");
        assertEquals(signIn.getRegisterErrorText(), "Sorry,the email you have entered is already in use.", "Actual text doesn't match expected text!");

    }

}
