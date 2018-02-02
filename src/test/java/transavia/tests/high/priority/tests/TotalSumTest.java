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
public class TotalSumTest extends TestBase {

    String airportsCSV = "airports4.csv";
    String datesCSV = "dates.csv";

    @Test(groups = "checkTotalSum"  ,description = "Check tickets total sum for 2 adults and 1 children",enabled = false)
    public void ticketsTotalSumCheckTest() throws IOException {

        String cityFrom =  CSVReaderClass.getFirstValueFromCSV(airportsCSV);
        String cityTo = CSVReaderClass.getSecondValueFromCSV(airportsCSV);
        String date = CSVReaderClass.getFirstValueFromCSV(datesCSV);
        String returnDate = CSVReaderClass.getSecondValueFromCSV(datesCSV);
        boolean isReturnOn = true;
        String adultsNumber = PropertyProvider.getProperty("adults");
        String childrenNumber = PropertyProvider.getProperty("children");


       Assert.assertTrue( homePageSteps.fillingFlyingForm(cityFrom,cityTo,isReturnOn,date,returnDate,adultsNumber,childrenNumber).
                      chooseFirstFlights().
                      selectFarePlus().
                      compareTicketsPrice());

    }
}
