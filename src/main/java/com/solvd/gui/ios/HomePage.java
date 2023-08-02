package com.solvd.gui.ios;

import com.solvd.gui.common.CandlePageCommon;
import com.solvd.gui.common.HomePageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass= HomePageCommon.class)
public class HomePage extends HomePageCommon {
    public HomePage(WebDriver driver){
        super(driver);
    }
}
