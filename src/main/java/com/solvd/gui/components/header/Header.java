package com.solvd.gui.components.header;

import com.solvd.gui.pages.desktop.CartPage;
import com.solvd.gui.pages.desktop.ProductsListPage;
import com.solvd.gui.pages.desktop.SignInPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends HeaderAbstract {
    @FindBy(xpath = ".//li//button[contains(.,'Sign in')]")
    private ExtendedWebElement signInButtonInHP;

    @FindBy(xpath = ".//a[contains(@href,'etsy.com/cart')]")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = ".//input[@id='global-enhancements-search-query']")
    private ExtendedWebElement searchBox;

    @FindBy(xpath = ".//button[@aria-label='Search']")
    private ExtendedWebElement searchBtn;
    @FindBy(xpath = ".//span[@id='logo']")
    private ExtendedWebElement icon;


    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isPageOpened() {
        return icon.isElementPresent();
    }

    @Override
    public SignInPage clickOnSignInBtnHP() {
        signInButtonInHP.click();
        return new SignInPage(driver);
    }

    @Override
    public CartPage clickOnCartBtn() {
        cartButton.click();
        return new CartPage(driver);
    }

    @Override
    public ProductsListPage searchForProduct(String productName) {
        searchBox.click();
        searchBox.type(productName);
        searchBtn.click();
        return new ProductsListPage(driver);
    }

    @Override
    public ProductsListPage clickOnSearchBtn() {
        searchBtn.click();
        return new ProductsListPage(driver);
    }
}

