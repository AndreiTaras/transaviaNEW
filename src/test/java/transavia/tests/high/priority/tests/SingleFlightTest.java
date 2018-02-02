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
public class SingleFlightTest extends TestBase {

    String airportsCSV = "airports4.csv";
    String datesCSV = "dates.csv";

    @Test(groups = "checkSingleFlight" , description = "Check single flight for one person in one direction")
    public void singleFlightTest() throws IOException {

        String cityFrom =  CSVReaderClass.getFirstValueFromCSV(airportsCSV);
        String cityTo = CSVReaderClass.getSecondValueFromCSV(airportsCSV);
        String date = CSVReaderClass.getFirstValueFromCSV(datesCSV);
        boolean isReturnOn = false;
        String adultsNumber = PropertyProvider.getProperty("adults");
        String childrenNumber = PropertyProvider.getProperty("children");

      Assert.assertTrue( homePageSteps.fillingFlyingForm(cityFrom,cityTo,isReturnOn,date,date,adultsNumber,childrenNumber).
                                       selectNearWeek().
                                       isAvailableFlightPresent());

    }


}
