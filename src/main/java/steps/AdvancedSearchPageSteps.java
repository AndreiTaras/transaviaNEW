package steps;

import org.openqa.selenium.WebDriver;
import pages.AdvancedSearchPage;

public class AdvancedSearchPageSteps extends AbstractSteps {

    private AdvancedSearchPage advancedSearchPage;

    public AdvancedSearchPageSteps(WebDriver driver) {
        super(driver);
        advancedSearchPage = new AdvancedSearchPage(driver);
    }

    public AdvancedSearchPageSteps findCheapestTicket(String departure, String destination, String month){

        advancedSearchPage.setDepartureAirport(departure);
        advancedSearchPage.setDestinationAirport(destination);
        advancedSearchPage.clickWhenWillYouBeTakingOffDropDown();
        advancedSearchPage.selectSingleFlightType();
        advancedSearchPage.selectSingleFlightMonth(month);
        advancedSearchPage.clickSearchButton();
        return this;
    }

    public AdvancedSearchPageSteps searchBudgetFlight(String departure, String budget, String month){
        advancedSearchPage.setDepartureAirport(departure);
        advancedSearchPage.clickWhatIsYourBudgetPerPersonDropDown();
        advancedSearchPage.setBudgetTextbox(budget);

        advancedSearchPage.clickWhenWillYouBeTakingOffDropDown();
        advancedSearchPage.selectSingleFlightType();
        advancedSearchPage.selectSingleFlightMonth(month);

        advancedSearchPage.clickSearchButton();
        return this;
    }

    public AdvancedSearchPageSteps setDepartureAirport(String departure){
        advancedSearchPage.setDepartureAirport(departure);
        return this;
    }

    public AdvancedSearchPageSteps setDestinationAirport(String destination){
        advancedSearchPage.setDestinationAirport(destination);
        return this;
    }

    public AdvancedSearchPageSteps setBudget(String budget){

        advancedSearchPage.clickWhatIsYourBudgetPerPersonDropDown();
        advancedSearchPage.setBudgetTextbox(budget);
        return this;
    }
    public AdvancedSearchPageSteps setFlightTypeAndMonth(){

        advancedSearchPage.clickWhenWillYouBeTakingOffDropDown();
        advancedSearchPage.selectSingleFlightType();
        return this;
    }

    public AdvancedSearchPageSteps clickSearchButton(){
        advancedSearchPage.clickSearchButton();
        return this;
    }

    public String getPriceAndCity(){
        return advancedSearchPage.getFirstRowPriceAndCity();
    }

    public boolean isFlightsExists(){

        if(advancedSearchPage.getResultListSize() > 0){
            return true;
        }

        return false;
    }
}
