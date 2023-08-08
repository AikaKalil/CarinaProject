package com.solvd.gui.pages.common;
import com.solvd.gui.components.header.Header;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageAbstract extends AbstractPage {

    @FindBy(xpath = "//header[@id='gnav-header-inner']")
    private Header header;
public HomePageAbstract(WebDriver driver){
    super(driver);
    setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
}
public Header getHeader() {
        return header;
    }
}
