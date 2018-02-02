package transavia.tests.low.priority.tests;

import businessobjects.Flight;
import businessobjects.StaticFactory;
import helpers.CSVReaderClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import transavia.tests.config.TestBase;
import utils.PropertyProvider;

import java.io.IOException;

public class FindCheapestTicketTest extends TestBase {


  String airportsCSV = "countries.csv";

    @Test(groups = "findCheapestTicket", description = "Search cheapest ticket from Netherlands to France " , enabled = false)
    public void findCheapestTicket() throws IOException {

        String price = PropertyProvider.getProperty("priceInEuro");
        String city = PropertyProvider.getProperty("city");
        String date = PropertyProvider.getProperty("dateInSelect");
        String departure = CSVReaderClass.getFirstValueFromCSV(airportsCSV);
        String destination = CSVReaderClass.getSecondValueFromCSV(airportsCSV);

        Flight flight = StaticFactory.createFlightfromAirportsAndDate(departure,destination,date);


        Assert.assertEquals(price+city, homePageSteps.navigateToAdvancedSearchPage().
                                                         findCheapestTicket(flight.getDeparture(),flight.getDestination(),flight.getDate()).
                                                         getPriceAndCity());




    }
}
