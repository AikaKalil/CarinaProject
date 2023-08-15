package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.CartPageAbstract;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageAbstract.class)
public class CartPage extends CartPageAbstract {
    @FindBy(xpath = "//h1[contains(text(), 'Your cart is empty.')]")
    private ExtendedWebElement emptyCartMsg;
    @FindBy(xpath = "//a[@rel='remove']")
    private ExtendedWebElement removeBtn;
    @FindBy(xpath = "//h1[text() = '1 item in your cart']")
    private ExtendedWebElement itemsInCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRemoveBtn() {
        removeBtn.click();
    }

    public String getEmptyCartText() {
        return emptyCartMsg.getText();
    }

    public String getItemsInCartText() {
        return itemsInCart.getText();
    }

}
