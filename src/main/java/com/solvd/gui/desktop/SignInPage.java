package com.solvd.gui.desktop;
import com.solvd.gui.common.SignInPageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass= SignInPageCommon.class)
public class SignInPage extends SignInPageCommon {

    @FindBy(xpath = "//input[@id='join_neu_email_field']")
    WebElement emailInputField;
    @FindBy(xpath = "//input[@id='join_neu_password_field']")
    WebElement passwordField;
    @FindBy(xpath = "//div[@class='wt-validation']//button[@type='submit']")
    WebElement signInBtn;
    @FindBy(xpath = "//div[@id='aria-join_neu_email_field-error']")
    private ExtendedWebElement errorMsg;

    public SignInPage(WebDriver driver){
        super(driver);
    }
    public void signInFeature(String email, String password){
        emailInputField.sendKeys(email);
        passwordField.sendKeys(password);
        signInBtn.click();
    }
    public String getErrorText(){
        return errorMsg.getText();
    }


}
