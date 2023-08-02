package com.solvd.gui.desktop;
import com.solvd.gui.common.CandlePageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass= CandlePageCommon.class)
public class CandlePage extends CandlePageCommon {
    @FindBy(xpath="//h3[@class='wt-text-title-02 wt-text-truncate']")
    private ExtendedWebElement mostLoved;
    @FindBy(xpath="//a[@data-listing-id='1297751238']")
    private ExtendedWebElement firstCandle;

    public CandlePage(WebDriver driver){
        super(driver);
    }

    public CandlePage clickOnMostLovedBtn(){
        mostLoved.click();
        firstCandle.click();
        return new CandlePage(driver);//should be fixed
    }



}
