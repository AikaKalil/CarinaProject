package com.solvd.gui.desktop;
import com.solvd.gui.common.CartPageCommon;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass= CartPageCommon.class)
public class CartPage extends CartPageCommon {


    public CartPage(WebDriver driver){
        super(driver);
    }


}
