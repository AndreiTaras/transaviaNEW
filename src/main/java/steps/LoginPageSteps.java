package steps;


import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginPageSteps extends AbstractSteps {

    private LoginPage loginPage;
    public LoginPageSteps(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public BookingOverviewPageSteps fillingBookingData(String number, String lastName, String date){

        loginPage.setBookingNumber(number);
        loginPage.setLastName(lastName);
        loginPage.setFlightDate(date);
        loginPage.clickViewBookingButton();
        return new BookingOverviewPageSteps(driver);
    }
}
