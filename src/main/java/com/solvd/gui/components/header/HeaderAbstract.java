package com.solvd.gui.components.header;

import com.solvd.gui.pages.desktop.CartPage;
import com.solvd.gui.pages.desktop.ProductsListPage;
import com.solvd.gui.pages.desktop.SignInPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderAbstract extends AbstractUIObject implements ICustomTypePageFactory {
    public HeaderAbstract(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public HeaderAbstract(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPageOpened();

    protected abstract SignInPage clickOnSignInBtnHP();

    protected abstract CartPage clickOnCartBtn();

    protected abstract ProductsListPage searchForProduct(String productName);

    protected abstract ProductsListPage clickOnSearchBtn();
}
