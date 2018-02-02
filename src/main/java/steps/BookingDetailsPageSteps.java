package steps;


import org.openqa.selenium.WebDriver;
import pages.BookingDetailsPage;

public class BookingDetailsPageSteps extends  AbstractSteps{

    private BookingDetailsPage bookingDetailsPage;
    public BookingDetailsPageSteps(WebDriver driver) {
        super(driver);
        bookingDetailsPage = new BookingDetailsPage(driver);
    }

    public boolean isTotalSumEqualsPaymentAmount(){

        return bookingDetailsPage.getTotalSum().equals(bookingDetailsPage.getPaymentAmount());
    }
}
