package com.solvd.gui.pages.desktop;

import com.solvd.gui.pages.common.ProductPageAbstract;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductPageAbstract.class)
public class ProductPage extends ProductPageAbstract {

    @FindBy(xpath = "//button[@id='search-filter-button']")
    private ExtendedWebElement allFiltersBtn;
    @FindBy(xpath = "//input[@id='special-offers-on-sale']")
    private ExtendedWebElement onSale;

    @FindBy(xpath = "//button[@aria-label='Apply']")
    private ExtendedWebElement applyBtn;
    @FindBy(xpath = "//a[contains(., 'On sale')]")
    private ExtendedWebElement sortedOnSaleIcon;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private List<ExtendedWebElement> addToCartBtn;
    //div[@id='cart-edit-panel-overlay']
    @FindBy(xpath = "//div[@id='cart-edit-panel-overlay']")
    private ExtendedWebElement wholePage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickAllFilters() {
        allFiltersBtn.click();
    }

    @Override
    public void selectOnSale() {
        onSale.click();
    }

    @Override
    public void clickApplyBtn() {
        applyBtn.click();
    }

    @Override
    public String getOnSaleText() {
        return sortedOnSaleIcon.getText();
    }
    public void clickAddToCartBtn(int index) {
        if (index>=0 && index<addToCartBtn.size()) {
            ExtendedWebElement desiredButton = addToCartBtn.get(index);
            desiredButton.click();
        } else {
            System.out.println("Desired index is out of range.");
        }
    }
    public CartPage clickPage(){
        wholePage.click();
        return new CartPage(driver);
    }
}
