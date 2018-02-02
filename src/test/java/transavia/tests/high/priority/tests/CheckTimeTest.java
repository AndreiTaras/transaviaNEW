package transavia.tests.high.priority.tests;


import helpers.CSVReaderClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import transavia.tests.config.TestBase;
import utils.PropertyProvider;
import utils.ScreenshotExecutor;

import java.io.IOException;

@Listeners(ScreenshotExecutor.class)
public class CheckTimeTest  extends TestBase {

    String bookingDataCSV = "bookingData.csv";
    String datesCSV = "bookingDate.csv";

    @Test(groups = "checkTicketTime" , description = "Check that expected time equals actual" , enabled = false)
    public void checkTimeTest() throws IOException {

        String number = CSVReaderClass.getFirstValueFromCSV(bookingDataCSV);
        String lastname = CSVReaderClass.getSecondValueFromCSV(bookingDataCSV);
        String date = CSVReaderClass.getFirstValueFromCSV(datesCSV);
        String bookingFlightDate = PropertyProvider.getProperty("bookingFlightDate");
        String bookingData = number + " " + bookingFlightDate;



       Assert.assertEquals(bookingData, homePageSteps.navigateToLoginPage().
                                                      fillingBookingData(number,lastname,date).
                                                      getBookingData());

    }
}
