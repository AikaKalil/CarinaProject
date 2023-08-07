package com.solvd.gui.ios;

import com.solvd.gui.common.CartPageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass= CartPageCommon.class)
public class CartPageIOS extends CartPageCommon{
    public CartPageIOS(WebDriver driver){
        super(driver);
    }
}
