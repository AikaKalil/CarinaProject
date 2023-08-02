package com.solvd.gui.common;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
public class HomePageCommon extends AbstractPage {
public HomePageCommon(WebDriver driver){
    super(driver);
    setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
}
}
