package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.ProductsListPageAbstract;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductsListPageAbstract.class)
public class ProductsListPage extends ProductsListPageAbstract {

    @FindBy(xpath = "//button[@id='search-filter-button']")
    private ExtendedWebElement allFiltersBtn;
    @FindBy(xpath = "//div[contains(@class, 'wt-checkbox')]/input[@id='special-offers-on-sale']")
    private ExtendedWebElement onSaleCheckBox;

    @FindBy(xpath = "//button[@aria-label='Apply']")
    private ExtendedWebElement applyBtn;
    @FindBy(xpath = "//a[contains(., 'On sale')]")
    private ExtendedWebElement sortedOnSaleIcon;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private ExtendedWebElement addToCartBtn;
    @FindBy(xpath = "//div[@id='cart-edit-panel-overlay']")
    private ExtendedWebElement wholePage;

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickAllFilters() {
        allFiltersBtn.click();
    }

    @Override
    public void selectOnSaleCheckBox() {
        onSaleCheckBox.clickByJs();
    }

    @Override
    public void clickApplyBtn() {
        applyBtn.click();
    }

    @Override
    public String getOnSaleText() {
        return sortedOnSaleIcon.getText();
    }

    @Override
    public void clickAddToCartBtn() {
        addToCartBtn.click();
    }

    public CartPage clickPage() {
        wholePage.click();
        return new CartPage(driver);
    }
}
