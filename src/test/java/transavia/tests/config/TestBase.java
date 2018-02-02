package transavia.tests.config;

import drivermanager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.HomePageSteps;
import utils.PropertyProvider;

import java.net.MalformedURLException;

public abstract class TestBase {

    protected WebDriver driver;
    protected HomePageSteps homePageSteps;
    DriverFactory driverFactory = new DriverFactory();


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        driver = driverFactory.getInstance();
        driver.get(PropertyProvider.getProperty("url"));
        homePageSteps = new HomePageSteps(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void teardown(){
       // DriverFactory.closeDriver();
//        driverFactory.closeDriver();
        driver = null;
    }
}
