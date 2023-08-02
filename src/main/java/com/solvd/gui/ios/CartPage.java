package com.solvd.gui.ios;

import com.solvd.gui.common.CandlePageCommon;
import com.solvd.gui.common.CartPageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE,parentClass= CartPageCommon.class)
public class CartPage extends CartPageCommon{
    public CartPage(WebDriver driver){
        super(driver);
    }
}
