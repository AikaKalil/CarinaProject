package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.CartPageAbstract;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageAbstract.class)
public class CartPage extends CartPageAbstract {
    @FindBy(xpath = "//h1[contains(text(), 'Your cart is empty.')]")
    private ExtendedWebElement emptyCartMsg;
    @FindBy(xpath = "//a[@rel='remove']")
    private ExtendedWebElement removeBtn;



    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void clickOnRemove(){
        removeBtn.click();
    }
    public String getEmptyCartMsg(){
        return emptyCartMsg.getText();
    }



}
