package com.solvd.gui.ios;

import com.solvd.gui.common.SignInPageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass = SignInPageCommon.class)
public class SignInPageIOS extends SignInPageCommon{
    public SignInPageIOS(WebDriver driver){
        super(driver);
    }
}
