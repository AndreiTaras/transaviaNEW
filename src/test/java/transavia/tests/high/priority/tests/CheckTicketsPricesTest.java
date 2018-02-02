package transavia.tests.high.priority.tests;


import businessobjects.Flight;
import businessobjects.StaticFactory;
import helpers.CSVReaderClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import transavia.tests.config.TestBase;
import utils.ScreenshotExecutor;

import java.io.IOException;

@Listeners(ScreenshotExecutor.class)
public class CheckTicketsPricesTest extends TestBase {

    String bookingDataCSV = "bookingData.csv";
    String datesCSV = "bookingDate.csv";



    @Test(groups = "checkTicketPrice" , description = "Check that ticket price equals booking price" ,enabled = false)
    public void checkTicketsPriceTest() throws IOException {

        String number = CSVReaderClass.getFirstValueFromCSV(bookingDataCSV);
        String lastname = CSVReaderClass.getSecondValueFromCSV(bookingDataCSV);
        String date = CSVReaderClass.getFirstValueFromCSV(datesCSV);

        Flight flight = StaticFactory.createFlightFromBookingData(number,lastname,date);

        Assert.assertTrue(homePageSteps.navigateToLoginPage().
                fillingBookingData(flight.getBookingNumber(),flight.getLastname(),flight.getDate()).
                navigateToBookingDetailsPage().
                isTotalSumEqualsPaymentAmount());

    }
}
