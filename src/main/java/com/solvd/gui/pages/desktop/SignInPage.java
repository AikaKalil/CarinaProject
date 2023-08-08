package com.solvd.gui.pages.desktop;
import com.solvd.gui.pages.common.SignInPageAbstract;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass= SignInPageAbstract.class)
public class SignInPage extends SignInPageAbstract {

    @FindBy(xpath = "//input[@id='join_neu_email_field']")
    ExtendedWebElement emailInputField;
    @FindBy(xpath = "//input[@id='join_neu_password_field']")
    ExtendedWebElement passwordField;
    @FindBy(xpath = "//div[@class='wt-validation']//button[@type='submit']")
    ExtendedWebElement signInBtn;
    @FindBy(xpath = "//div[@id='aria-join_neu_email_field-error']")
    private ExtendedWebElement errorMsg;
    @FindBy(xpath = "//button[@class='wt-btn wt-btn--primary wt-width-full']")
    private ExtendedWebElement popUpSignInBtn;

    @FindBy(xpath = "//div[@data-appears-component-name='Homepage_Vesta_View_WelcomeMessage']")
    private ExtendedWebElement welcomeBackMessage;


    public SignInPage(WebDriver driver){
        super(driver);
    }
    @Override
    public void signIn(String email, String password){
        emailInputField.type(email);
        passwordField.type(password);
    }
    @Override
    public void clickOnPopUpWindowSignInBtn() {
        popUpSignInBtn.click();
    }
    @Override
    public String getErrorText(){
        return errorMsg.getText();
    }
    @Override
    protected void clickSignInBtn() {
        signInBtn.click();
    }

    @Override
    public String getWelcomeBackMessage(){
        return welcomeBackMessage.getText();
    }



}