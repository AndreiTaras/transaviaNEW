package steps;

import org.openqa.selenium.WebDriver;
import pages.DestinationsPage;

public class DestinationsPageSteps extends AbstractSteps {

    private DestinationsPage destinationsPage;
    public DestinationsPageSteps(WebDriver driver) {
        super(driver);
        destinationsPage = new DestinationsPage(driver);
    }


    public AdvancedSearchPageSteps navigateToAdvancedSearchPage(){

        destinationsPage.clickFindThePerfectDestinationButton();

        return new AdvancedSearchPageSteps(driver);
    }
}
