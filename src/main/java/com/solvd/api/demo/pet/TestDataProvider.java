package com.solvd.api.demo.pet;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "testFindPetByStatusData")
    public static Object[][] statusProvider() {
        return new Object[][]{
                {"available"},
                {"pending"},
                {"sold"}
        };
    }

    @DataProvider(name = "testGetPetByIdData")
    public static Object[][] petDataProvider() {
        return new Object[][]{
                {"1233", "Fluffy", "available"},
                {"1122", "Buddy", "pending"},
                {"1355", "Max", "sold"}
        };
    }
}
