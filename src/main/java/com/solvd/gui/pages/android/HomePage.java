package com.solvd.gui.pages.android;

import com.solvd.gui.pages.common.HomePageAbstract;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageAbstract.class)
public class HomePage extends HomePageAbstract {
    @FindBy(xpath = "//header[@id='gnav-header-inner']")
    public ExtendedWebElement header;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(header);
    }
}