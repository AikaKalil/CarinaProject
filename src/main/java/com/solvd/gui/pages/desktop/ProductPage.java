package com.solvd.gui.pages.desktop;
import com.solvd.gui.pages.common.ProductPageAbstract;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass= ProductPageAbstract.class)
public class ProductPage extends ProductPageAbstract {
    @FindBy(xpath="//h3[contains(text(), 'Most Loved')]")
    private ExtendedWebElement mostLoved;
    @FindBy(xpath="(//li[contains(@class, 'wt-grid__item-xs-6')])[2]")
    private ExtendedWebElement chooseSecondProduct;
    @FindBy(xpath="//select[@id='variation-selector-0']/option[position() > 1][1]]")
    private ExtendedWebElement selectAnOptionBtn;
    @FindBy(xpath="(//div[@class='search-half-unit-mt']//button[@type = 'submit'])[2]")
    private ExtendedWebElement addToCartBtn;
    @FindBy(xpath="//a[@href='/cart' and contains(@class, 'wt-btn--filled')]")
    private ExtendedWebElement popUpGoToCartBtn;

    public ProductPage(WebDriver driver){
        super(driver);
    }
    public void clickOnMostLoved(){
        mostLoved.click();
    }
    public void clickOnSecondItem(){
        chooseSecondProduct.click();
    }
    public void addToCart(){
        addToCartBtn.click();
    }

    public CartPage cartPage(){
        popUpGoToCartBtn.click();
        return new CartPage(driver);
    }

}
