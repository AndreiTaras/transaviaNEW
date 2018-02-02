package transavia.tests.low.priority.tests;

import businessobjects.Flight;
import businessobjects.StaticFactory;
import helpers.CSVReaderClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import transavia.tests.config.TestBase;
import utils.PropertyProvider;

import java.io.IOException;

public class SearchBudgetFlightsTest extends TestBase {

    String airportsCSV = "airports.csv";

    @Test(groups = "checkBudgetFlight" , description = "Search ticket with budget less 200 euro",enabled = false)
    public void searchBudgetFlights() throws IOException {


        Flight flight = StaticFactory.createFlightFromBudget(PropertyProvider.getProperty("budget"));
        String date = PropertyProvider.getProperty("dateInSelect");
        String destination = CSVReaderClass.getFirstValueFromCSV(airportsCSV);

        Assert.assertTrue(homePageSteps.navigateToDestinationsPage().
                                        navigateToAdvancedSearchPage().
                                        searchBudgetFlight(destination,flight.getBudget(),date).
                                        isFlightsExists());

    }
}
