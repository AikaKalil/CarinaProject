package com.solvd.gui.desktop;
import com.solvd.gui.common.HomePageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass= HomePageCommon.class)
public class HomePage extends HomePageCommon {
    @FindBy(xpath = "//li//button[contains(.,'Sign in')]")
    private ExtendedWebElement signInButtonInHP;

    @FindBy(xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full']")
    private ExtendedWebElement popUpSignInBtn;
    @FindBy(xpath = "//a[contains(@href,'etsy.com/cart')]")
    private ExtendedWebElement cartButton;

    @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
    private ExtendedWebElement searchBox;

    @FindBy(xpath = "//button[@aria-label='Search']")
    private ExtendedWebElement searchBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public SignInPage clickOnSignInBtn() {
        popUpSignInBtn.click();
        return new SignInPage(driver);
    }
    public CartPage clickOnCartBtn() {
        cartButton.click();
        return new CartPage(driver);
    }
    public CandlePage searchItem(String text) {
        searchBox.click();
        searchBox.type(text);
        searchBtn.click();
        return new CandlePage(driver);
    }
    }
