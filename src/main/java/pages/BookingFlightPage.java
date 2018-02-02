package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import utils.Waiter;
import wrapper.CustomElement;

import java.util.List;

public class BookingFlightPage extends AbstractPage {

    public BookingFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'notification-error')]/p")
    private WebElement errorMessage;
    @FindBy(css = ".nav-days-after")
    private WebElement nextDaysButton;
    @FindBys(@FindBy(xpath = "//*[@class='current-view']//ol/li//span[@class='price']"))
    private List<WebElement> availableFlightsList;
    @FindBys(@FindBy(xpath = "//section[contains(@class,'outbound')]//div[@class='select']/span"))
    private List<WebElement> outboundSelectList;
    @FindBys(@FindBy(xpath = "//section[contains(@class,'inbound')]//div[@class='select']/span"))
    private List<WebElement> inboundSelectList;
    @FindBy(xpath = "//section[contains(@class,'inbound')]//div[@class='select']/span[@class='status-selected']")
    private WebElement firstInboundFlightSelectedStatus;
    @FindBy(css = ".panel-total button")
    private WebElement nextButton;

    public String getErrorMessageText(){
        CustomElement errorMessage = new CustomElement(this.errorMessage);
        return errorMessage.getText();
    }

    public void clickNextDaysButton(){
        CustomElement nextDaysButton = new CustomElement(this.nextDaysButton);
        waiter.waitForElementIsClickable(nextDaysButton);
        logger.info("click next days button");
        nextDaysButton.click();
    }

    public int getAvailableFlightCount(){

        return availableFlightsList.size();
    }

    public void selectFirstOutboundFlight(){
        System.out.println(" outbound size = "+outboundSelectList.size());
        waiter.waitForElementIsClickable(outboundSelectList.get(0));
        outboundSelectList.get(0).click();
        logger.info("select first outbound flight");

    }

    public void selectFirstInboundFlight(){

        String coordinates = inboundSelectList.get(0).getLocation().toString();
        String jsScript = "window.scroll" + coordinates;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript(jsScript);
        Waiter.pause(1000);
        waiter.waitForElementIsClickable(inboundSelectList.get(0));
        inboundSelectList.get(0).click();
        Waiter.pause(700);
        while (!firstInboundFlightSelectedStatus.getText().equals("Selected")){
            Waiter.pause(800);
        }
        logger.info("select first inbound flight");

    }

    public void clickNextButton(){

        CustomElement nextButton = new CustomElement(this.nextButton);
        waiter.waitForElementIsClickable(nextButton);
        nextButton.click();
        logger.info("click next button");
    }


}
