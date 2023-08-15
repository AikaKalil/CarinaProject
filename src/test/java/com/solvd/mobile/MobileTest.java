package com.solvd.mobile;

import com.solvd.gui.components.header.Header;
import com.solvd.gui.pages.common.HomePageAbstract;
import com.solvd.gui.pages.desktop.CartPage;
import com.solvd.gui.pages.desktop.ProductsListPage;
import com.solvd.gui.pages.desktop.SignInPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MobileTest implements IAbstractTest, IMobileUtils {

    @Test
    @MethodOwner(owner = "akalil")
    public void invalidEmailTestSignIn() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header = homePage.getHeader();
        SignInPage signInPage = header.clickOnSignInBtnHP();
        signInPage.typeCredentials("akalil@gmail.com", "343r43");
        signInPage.clickOnPopUpWindowSignInBtn();
        assertEquals(signInPage.getErrorText(), "Email address is invalid.", "Actual text doesn't match expected text!");
    }

    @Test
    @MethodOwner(owner = "akalil")
    public void validEmailTestSignIn() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header = homePage.getHeader();
        SignInPage signIn = header.clickOnSignInBtnHP();
        signIn.typeCredentials("m.aijamal07@icloud.com", "AikaK07");
        signIn.clickOnPopUpWindowSignInBtn();
        assertEquals(signIn.getWelcomeBackMessage(), "Welcome to Etsy, Aika!", "Actual text doesn't match expected text!");
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
        ProductsListPage productsListPage = header.searchForProduct("candle");
        productsListPage.clickAllFilters();
        productsListPage.selectOnSaleCheckBox();
        productsListPage.clickApplyBtn();
        assertEquals(productsListPage.getOnSaleText(), "On sale", "Actual text doesn't match expected!");

    }

    @Test
    @MethodOwner(owner = "akalil")
    public void testAddToCart() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header = homePage.getHeader();
        ProductsListPage productsListPage = header.searchForProduct("candle");
        productsListPage.clickAddToCartBtn();
        CartPage cartPage = productsListPage.clickPage();
        assertEquals(cartPage.getItemsInCartText(), "1 item in your cart", "Actual text is different than expected text!");
        cartPage.clickOnRemoveBtn();
        assertEquals(cartPage.getEmptyCartText(), "Your cart is empty.", "Actual text is different than expected text!");

    }

    @Test
    @MethodOwner(owner = "akalil")
    public void testRegisterWithExistingAccount() {
        HomePageAbstract homePage = initPage(getDriver(), HomePageAbstract.class);
        homePage.open();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened!");
        Header header = homePage.getHeader();
        SignInPage signIn = header.clickOnSignInBtnHP();
        signIn.clickRegisterBtn();
        signIn.registerCredentials("m.aijamal07@icloud.com", "Aika", "Aika07Kalil@E");
        signIn.clickOnPopUpWindowRegisterBtn();
        assertEquals(signIn.getRegisterErrorText(), "Sorry, the email you have entered is already in use.", "Actual text doesn't match expected text!");

    }


}
