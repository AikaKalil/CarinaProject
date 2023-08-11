package com.solvd.gui.pages.common;

import com.solvd.gui.pages.desktop.CartPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartPageAbstract extends AbstractPage {
    public CartPageAbstract(WebDriver driver) {
        super(driver);
    }

    protected abstract void clickOnRemoveBtn();

    protected abstract String getEmptyCartText();

    protected abstract String getItemsInCartText();
}
