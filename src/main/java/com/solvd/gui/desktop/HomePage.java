package com.solvd.gui.desktop;
import com.solvd.gui.common.HomePageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass= HomePageCommon.class)
public class HomePage extends HomePageCommon{


    @FindBy(xpath = "//a[contains(.,'Facebook')]")
    WebElement metaLogo;

    @FindBy(xpath = "//a[contains(.,'Instagram')]")
    WebElement instagramLogo;

    @FindBy(xpath = "//a[contains(.,'Twitter')]")
    WebElement twitterLogo;

    @FindBy(xpath = "//a[contains(.,'Pinterest')]")
    WebElement pinterestLogo;

    @FindBy(xpath = "//a[contains(.,'Youtube')]")
    WebElement youTubeLogo;

    @FindBy(css = "input[id='email-list-signup-email-input']")
    WebElement inputFieldSubscribe;

    @FindBy(xpath = "//button[contains(.,'Subscribe')]")
    WebElement subscribeBtn;

    @FindBy(xpath = "//div[contains(.,'successfully signed up!')]")
    List<WebElement> allTexts;

    @FindBy(xpath = "//li//button[contains(.,'Sign in')]")
    private ExtendedWebElement signInButton;
    @FindBy(xpath="//a[contains(@href,'etsy.com/cart')]")
    private ExtendedWebElement cartButton;

    @FindBy(xpath ="//input[@id='global-enhancements-search-query']")
    private ExtendedWebElement searchBox;

    @FindBy(xpath ="//button[@aria-label='Search']")
    private ExtendedWebElement searchBtn;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public SignInPage clickOnSignInBtn(){
        signInButton.click();
        return new SignInPage(driver);
    }
    public CartPage clickOnCartBtn(){
        cartButton.click();
        return new CartPage(driver);
    }
    public CandlePage searchItem(String text){
        searchBox.click();
        searchBox.type(text);
        searchBtn.click();
        return new CandlePage(driver);
    }
    public void subscribe(String email){
        inputFieldSubscribe.sendKeys(email);
        subscribeBtn.click();
    }


}
