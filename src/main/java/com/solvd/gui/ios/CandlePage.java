package com.solvd.gui.ios;

import com.solvd.gui.common.CandlePageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass= CandlePageCommon.class)
public class CandlePage extends CandlePageCommon{
    public CandlePage(WebDriver driver){
        super(driver);
    }
}
