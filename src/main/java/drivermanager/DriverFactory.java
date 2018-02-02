package drivermanager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;
import utils.PropertyProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private  BrowserType browserType;
    private  WebDriver driver;
    private  final static String CHROMEDRIVER = "webdriver.chrome.driver";
    private  final static String CHROMEDRIVER_PATH = ".\\chromedriver\\chromedriver.exe";
    private  final static String GECKODRIVER = "webdriver.gecko.driver";
    private  final static String GECKODRIVER_PATH = ".\\geckodriver\\geckodriver.exe";
    private DesiredCapabilities capabilities;



    private  WebDriver getDriver() throws MalformedURLException {

        browserType = BrowserType.valueOf(PropertyProvider.getProperty("browser"));

        switch (browserType) {

            case CHROME:
                driver = createChromeDriver();
                break;

            case FIREFOX:
                driver = createFirefoxDriver();
                break;

            case ANDROID_CHROME:
                driver = createAndroidChromeDriver();
                break;

            case REMOTEDRIVER:
                break;

            default:
                driver = createChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public  WebDriver getInstance() throws MalformedURLException {
        if(driver == null){
            getDriver();
        }
        return driver;
    }

    public  void closeDriver(){
        driver.quit();
        driver = null;

    }


    private  WebDriver createFirefoxDriver(){

        System.setProperty(GECKODRIVER,GECKODRIVER_PATH);
        return new FirefoxDriver();
    }

    private  WebDriver createChromeDriver(){

        System.setProperty(CHROMEDRIVER,CHROMEDRIVER_PATH);
        return new ChromeDriver();
    }

    private WebDriver createAndroidChromeDriver() throws MalformedURLException {

        capabilities = DesiredCapabilities.android();

        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, org.openqa.selenium.remote.BrowserType.CHROME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"022AQQ7N39129966");
        capabilities.setCapability(MobileCapabilityType.VERSION,"4.4.2");
        capabilities.setCapability("noRest", true);

         driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        return driver;

    }



}
