package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps extends AbstractSteps {

    private HomePage homePage;
    public HomePageSteps(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
    }

    public BookingFlightPageSteps fillingFlyingForm(String cityFrom, String cityTo , boolean isReturnOn,
                                                    String date, String returnDate, String adultsNumber, String childrenNumber){
        homePage.setAirports(cityFrom,cityTo);
        homePage.setDates(isReturnOn,date,returnDate);
        homePage.setPassengersNumber(adultsNumber,childrenNumber);
        homePage.clickSearchButton();

        return new BookingFlightPageSteps(driver);

    }

   public LoginPageSteps navigateToLoginPage(){

        homePage.clickManageYourBooking();
        homePage.clickViewYourBooking();
        return new LoginPageSteps(driver);
   }

   public MultipleDestinationsPageSteps navigateToMultipleDestinationsPage(){

       homePage.clickAddMultipleDestinationsLink();
       return new MultipleDestinationsPageSteps(driver);
   }

    public HandLuggagePageSteps navigateToHandLuggagePage(){

        homePage.clickServiceDropDownMenu();
        homePage.clickHandLuggageDropDownItem();
        return new HandLuggagePageSteps(driver);
    }

    public AdvancedSearchPageSteps navigateToAdvancedSearchPage(){

        homePage.clickPlanAndBookDropDownMenu();
        homePage.clickAdvancedSearchDropDownItem();
        return new AdvancedSearchPageSteps(driver);
    }

    public DestinationsPageSteps navigateToDestinationsPage(){

        homePage.clickDestinationsLink();
        return new DestinationsPageSteps(driver);
    }


    public HomePageSteps clickOutboundDatePicker(){
        homePage.clickOutboundDatePicker();
        return this;
    }

}
