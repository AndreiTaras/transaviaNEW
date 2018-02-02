package steps;

import org.openqa.selenium.WebDriver;
import pages.MultipleDestinationsPage;

public class MultipleDestinationsPageSteps  extends AbstractSteps{

    private MultipleDestinationsPage multipleDestinationsPage;
    public MultipleDestinationsPageSteps(WebDriver driver) {
        super(driver);
        multipleDestinationsPage = new MultipleDestinationsPage(driver);
    }

    public MultipleDestinationsPageSteps fillingBookingForm(String outboundCityFrom, String outboundCityTo , String outboundDate,
                                                            String inboundCityFrom, String inboundCityTo, String inboundDate){

        multipleDestinationsPage.setOutboundFlightFrom(outboundCityFrom);
        multipleDestinationsPage.setOutboundFlightTo(outboundCityTo);
        multipleDestinationsPage.setOutboundFlightDate(outboundDate);

        multipleDestinationsPage.setInboundFlightFrom(inboundCityFrom);
        multipleDestinationsPage.setInboundFlightTo(inboundCityTo);
        multipleDestinationsPage.setInboundFlightDate(inboundDate);

        multipleDestinationsPage.clickSearchButton();

        return this;
    }

    public MultipleDestinationsPageSteps selectFlights(){
        multipleDestinationsPage.clickOutboundFlightSelectButton();
        multipleDestinationsPage.clickInboundFlightSelectButton();

        return this;
    }

    public boolean compareTicketsCost(){
        return multipleDestinationsPage.getTotalAmount() ==
                multipleDestinationsPage.getOutboundFlightPrice() + multipleDestinationsPage.getInboundFlightPrice();
    }
    public double getTotalAmount(){ return multipleDestinationsPage.getTotalAmount();}
}
