package transavia.tests.high.priority.tests;


import helpers.CSVReaderClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import transavia.tests.config.TestBase;
import utils.ScreenshotExecutor;

import java.io.IOException;

@Listeners(ScreenshotExecutor.class)
public class ComplicateRouteTest extends TestBase{

    String airportsCSV = "airports.csv";
    String airports2CSV = "airports2.csv";
    String datesCSV = "dates.csv";


    @Test(groups = "checkComplicateRoute" , description = "Check that it's possible to book a complicate route flight " , enabled = false)
    public void complicateRouteTest() throws IOException {

        String outboundCityFrom = CSVReaderClass.getFirstValueFromCSV(airportsCSV);
        String outboundCityTo = CSVReaderClass.getSecondValueFromCSV(airportsCSV);
        String outboundDate = CSVReaderClass.getFirstValueFromCSV(datesCSV);

        String inboundCityFrom = CSVReaderClass.getFirstValueFromCSV(airports2CSV);
        String inboundCityTo = CSVReaderClass.getSecondValueFromCSV(airports2CSV);
        String inboundDate = CSVReaderClass.getSecondValueFromCSV(datesCSV);

       Assert.assertTrue( homePageSteps.navigateToMultipleDestinationsPage().
                                        fillingBookingForm(outboundCityFrom,outboundCityTo,outboundDate, inboundCityFrom,inboundCityTo,inboundDate).
                                        selectFlights().
                                        compareTicketsCost());

    }
}
