package com.solvd.gui.pages.common;

import com.solvd.gui.components.header.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AbstractEtsyPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='gnav-header']")
    public Header header;

    protected AbstractEtsyPage(WebDriver driver) {
        super(driver);
    }
    public Header getHeader(){
        return header;
    }
    @Override
    public void open(){
        super.open();
    }

}
