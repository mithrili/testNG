package tests.day15_configuration_Properties_Usage;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationPropertiesUsage {
    // 1- Go to the test automation homepage
    // 2- Search for the product specified in the configuration.properties file
    // 3- Test that a product is found in the search results
    // 4- Click on the first product
    // 5- On the opened page, test that the product name contains
    //    the word specified in the configuration.properties file case-insensitively
    @Test
    public void searchTest(){
        // 1- Go to the test automation homepage
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // 2- Search for the product specified in the configuration.properties file
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.searchBox.sendKeys(ConfigReader.getProperty("toSearchWord")
                                              + Keys.ENTER);

        // 3- Test that a product is found in the search results
        int foundElementNumber = testOtomasyonuPage.foundProductsElementsList.size();
        Assert.assertTrue(foundElementNumber>0);

        // 4- Click on the first product
        testOtomasyonuPage.foundProductsElementsList.get(0).click();

        // 5- On the opened page, test that the product name contains
        //    the word specified in the configuration.properties file case-insensitively
        String actualProductName = testOtomasyonuPage.productNameAtProductPage.
                                   getText().toLowerCase();
        Assert.assertTrue(actualProductName.contains(ConfigReader.getProperty("toSearchWord")));

        Driver.quitDriver();

    }
}
