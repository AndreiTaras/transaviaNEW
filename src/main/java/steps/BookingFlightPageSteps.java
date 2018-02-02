package steps;

import org.openqa.selenium.WebDriver;
import pages.BookingFlightPage;

public class BookingFlightPageSteps extends AbstractSteps {

    private BookingFlightPage bookingFlightPage;

    public BookingFlightPageSteps(WebDriver driver) {
        super(driver);
        bookingFlightPage = new BookingFlightPage(driver);
    }

    public boolean  isErrorMessageContainsText(String text){

        return bookingFlightPage.getErrorMessageText().contains(text);

    }

    public BookingFlightPageSteps selectNearWeek(){

        bookingFlightPage.clickNextDaysButton();
        return this;
    }

    public boolean isAvailableFlightPresent(){

        return bookingFlightPage.getAvailableFlightCount() > 0;
    }

    public FarePageSteps chooseFirstFlights(){
        bookingFlightPage.selectFirstOutboundFlight();
        bookingFlightPage.selectFirstInboundFlight();
        bookingFlightPage.clickNextButton();
        return new FarePageSteps(driver);
    }

}
