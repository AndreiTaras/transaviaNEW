package steps;


import org.openqa.selenium.WebDriver;
import pages.BookingOverviewPage;

public class BookingOverviewPageSteps extends AbstractSteps {

    private BookingOverviewPage bookingOverviewPage;
    public BookingOverviewPageSteps(WebDriver driver) {
        super(driver);
        bookingOverviewPage = new BookingOverviewPage(driver);
    }

    public String getBookingData(){

       return bookingOverviewPage.getBookingNumber() + " " + bookingOverviewPage.getDepartureDate();
    }

    public BookingDetailsPageSteps navigateToBookingDetailsPage(){

        bookingOverviewPage.clickBookingDetailsButton();

        return new BookingDetailsPageSteps(driver);
    }
}
