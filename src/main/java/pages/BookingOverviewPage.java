package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.CustomElement;

public class BookingOverviewPage extends AbstractPage {

    public BookingOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='footnote-paragraph']")
    private WebElement bookingNumber;
    @FindBy(xpath = "//p[@class='flight-info_value']/time")
    private WebElement departureDate;
    @FindBy(css = ".panel .icon-left-side")
    private WebElement bookingDetailsButton;

    public String getBookingNumber(){
        CustomElement bookingNumber = new CustomElement(this.bookingNumber);
        logger.info("get booking number");
        return bookingNumber.getText();
    }

    public String getDepartureDate(){

        CustomElement departureDate = new CustomElement(this.departureDate);
        logger.info("get departure date");
        return departureDate.getText();
    }

    public void clickBookingDetailsButton(){
        CustomElement bookingDetailsButton = new CustomElement(this.bookingDetailsButton);
        waiter.waitForElementIsClickable(bookingDetailsButton);
        logger.info("click 'Booking details' button");
        bookingDetailsButton.click();
    }
}
