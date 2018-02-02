package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {
    protected WebDriver driver;
    protected Logger logger = LogManager.getRootLogger();

    public AbstractSteps(WebDriver driver){
        this.driver = driver;
    }
}
