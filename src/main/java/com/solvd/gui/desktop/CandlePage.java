package com.solvd.gui.desktop;
import com.solvd.gui.common.CandlePageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass= CandlePageCommon.class)
public class CandlePage extends CandlePageCommon {
    @FindBy(xpath="//h3[contains(text(), 'Most Loved')]")
    private ExtendedWebElement mostLoved;
    @FindBy(xpath="(//li[contains(@class, 'wt-grid__item-xs-6')])[2]")
    private ExtendedWebElement chooseSecondProduct;
    @FindBy(xpath="//select[@id='variation-selector-0']/option[position() > 1][1]]")
    private ExtendedWebElement selectAnOptionBtn;
    @FindBy(xpath="//div[@class='wt-width-full']//button[@class='wt-btn wt-btn--filled wt-width-full']")
    private ExtendedWebElement addToCartBtn;
    @FindBy(xpath="//a[@href='/cart' and contains(@class, 'wt-btn--filled')]")
    private ExtendedWebElement popUpGoToCartBtn;
    public CandlePage(WebDriver driver){
        super(driver);
    }
    public void clickOnMostLoved(){
        mostLoved.click();
    }
    public void clickOnSecondItem(){
        chooseSecondProduct.click();
    }
    public void goToFirstOption() {
        selectAnOptionBtn.hover();
        selectAnOptionBtn.click();
    }

    public void addToCart(){
        addToCartBtn.click();
    }

    public CartPage cartPage(){
        popUpGoToCartBtn.click();
        return new CartPage(driver);
    }



}
