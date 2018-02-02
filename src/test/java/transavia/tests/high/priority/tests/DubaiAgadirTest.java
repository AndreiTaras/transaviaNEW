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
public class DubaiAgadirTest extends TestBase {

    String airportsCSV = "airports3.csv";
    String datesCSV = "dates.csv";

    @Test(groups = "checkDubaiAgadirFlight" , description = "Check that transavia don't fly from Dubai to Agadir")
    public void flightFromDubaiToAgadir() throws IOException {

        String cityFrom =  CSVReaderClass.getFirstValueFromCSV(airportsCSV);
        String cityTo = CSVReaderClass.getSecondValueFromCSV(airportsCSV);
        String date = CSVReaderClass.getFirstValueFromCSV(datesCSV);
        boolean isReturnOn = false;
        String message = PropertyProvider.getProperty("errorMessage");
        String adultsNumber = PropertyProvider.getProperty("adults");
        String childrenNumber = PropertyProvider.getProperty("children");


        Assert.assertTrue(homePageSteps.fillingFlyingForm(cityFrom,cityTo,isReturnOn,date,date,adultsNumber,childrenNumber).
                                        isErrorMessageContainsText(message));

    }


}
