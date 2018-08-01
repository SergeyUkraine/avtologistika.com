package test.dataproviders;

import org.testng.annotations.DataProvider;

public class CreateDriverData {

    @DataProvider
    public static Object[][] validDriverData() {
        return new Object[][]{
                {"Шолонько", "Евгений", "Sholonko", "Evgen", "Russian"}
        };
    }
}
