package com.solvd.gui.ios;

import com.solvd.gui.common.HomePageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass= HomePageCommon.class)
public class HomePageIOS extends HomePageCommon {
    public HomePageIOS(WebDriver driver){
        super(driver);
    }
}
