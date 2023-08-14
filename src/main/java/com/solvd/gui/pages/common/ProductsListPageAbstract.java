package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductsListPageAbstract extends AbstractPage {
    public ProductsListPageAbstract(WebDriver driver) {
        super(driver);
    }

    protected abstract void clickAllFilters();

    protected abstract void selectOnSaleCheckBox();

    protected abstract void clickApplyBtn();

    protected abstract String getOnSaleText();

    protected abstract void clickAddToCartBtn();

}
