package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageAbstract extends AbstractPage {
    public ProductPageAbstract(WebDriver driver) {
        super(driver);
    }

    protected abstract void clickAllFilters();

    protected abstract void selectOnSale();

    protected abstract void clickApplyBtn();

    protected abstract String getOnSaleText();

}
