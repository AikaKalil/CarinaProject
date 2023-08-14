package com.solvd.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SignInPageAbstract extends AbstractPage {
    public SignInPageAbstract(WebDriver driver) {
        super(driver);
    }

    protected abstract void typeCredentials(String email, String password);

    protected abstract void registerCredentials(String email, String name, String password);

    protected abstract String getErrorText();

    protected abstract String getWelcomeBackMessage();

    protected abstract void clickOnPopUpWindowSignInBtn();

    protected abstract void clickOnPopUpWindowRegisterBtn();

    protected abstract void clickRegisterBtn();

    protected abstract String getRegisterErrorText();

    protected abstract String errorMsgIncorrectPass();

    protected abstract String errorMsgIncorrectEmail();
}
