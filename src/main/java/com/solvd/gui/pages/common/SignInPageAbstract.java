package com.solvd.gui.pages.common;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
public abstract class SignInPageAbstract extends AbstractPage {
    public SignInPageAbstract(WebDriver driver){
        super(driver);
    }

    protected abstract void signIn(String email,String password);

    protected abstract String getErrorText();
    protected abstract String getWelcomeBackMessage();
    protected abstract void clickSignInBtn();
    protected abstract void clickOnPopUpWindowSignInBtn();


}
