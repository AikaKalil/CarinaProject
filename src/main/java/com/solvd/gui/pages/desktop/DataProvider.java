package com.solvd.gui.pages.desktop;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{{"akalil.laba@solvd.com", "AikaK07"}
                , {"akalil.laba@solvd.com", "0987654321"},
                {"qwert][poiu", "    98   "}};


    }
}
