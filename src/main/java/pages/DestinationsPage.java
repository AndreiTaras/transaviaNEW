package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;
import wrapper.CustomElement;

public class DestinationsPage extends AbstractPage {

    public DestinationsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".button-primary.button-call-to-action")
    private WebElement findThePerfectDestinationButton;


    public void clickFindThePerfectDestinationButton(){

        waiter.waitForPageLoaded(driver,TIMEOUT);
        Waiter.pause(3500);
        waiter.waitForjQuery();
        CustomElement findThePerfectDestinationButton = new CustomElement(this.findThePerfectDestinationButton);
        waiter.waitForElementIsClickable(findThePerfectDestinationButton);
        findThePerfectDestinationButton.click();
        logger.info("click 'Find The Perfect Destination' button");
    }
}
