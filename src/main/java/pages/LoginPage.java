package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;
import wrapper.CustomElement;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "retrieveBookingByLastname_RecordLocator")
    private WebElement bookingNumberTextbox;
    @FindBy(id = "retrieveBookingByLastname_LastName")
    private WebElement lastNameTextbox;
    @FindBy(id = "retrieveBookingByLastname_FlightDate-datepicker")
    private WebElement flightDateTextbox;
    @FindBy(xpath = "//button[contains(@class,'button-primary')]")
    private WebElement viewBookingButton;
    @FindBy(css = ".datepicker-trigger")
    private WebElement calendarIcon;

    public void setBookingNumber(String number){
        waiter.waitForPageLoaded(driver, TIMEOUT);
        waiter.waitForjQuery();
        CustomElement bookingNumberTextbox = new CustomElement(this.bookingNumberTextbox);
        waiter.waitForElementIsClickable(bookingNumberTextbox);
        bookingNumberTextbox.sendKeys(number);
        logger.info("set booking number : " +number);
    }
    public void setLastName(String lastName){
        CustomElement lastNameTextbox = new CustomElement(this.lastNameTextbox);
        waiter.waitForElementIsClickable(lastNameTextbox);
        lastNameTextbox.sendKeys(lastName);
        logger.info("set last name : " +lastName);
    }

    public void setFlightDate(String date){
        CustomElement flightDateTextbox = new CustomElement(this.flightDateTextbox);
        waiter.waitForElementIsClickable(flightDateTextbox);
        flightDateTextbox.sendKeys(date);
        calendarIcon.click();
        logger.info("set flight date : " +date);
    }

    public void clickViewBookingButton(){

        CustomElement viewBookingButton = new CustomElement(this.viewBookingButton);
        waiter.waitForElementIsClickable(viewBookingButton);
        Waiter.pause(700);
        viewBookingButton.click();
        logger.info("click view booking button");
    }
}
