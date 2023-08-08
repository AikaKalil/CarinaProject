package com.solvd.gui.pages.desktop;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][]{{"akalil@gmail.com", "123456789"}
                , {"kobe@gmail.com", "0987654321"},
                  {"qwert][poiu", "    98   "}};


    }
}
