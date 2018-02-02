package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;
import utils.Waiter;
import wrapper.CustomElement;

import java.util.List;

public class AdvancedSearchPage extends AbstractPage {


    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "countryStationSelection_Origin-input")
    private WebElement countryFromTextbox;
    @FindBy(id = "countryStationSelection_Destination-input")
    private WebElement countryToTextbox;
    @FindBy(css = ".item")
    private WebElement autocompleteResult;
    @FindBy(xpath = "//*[text()[contains(.,'What is your budget')]]")
    private WebElement whatIsyourBudgetPerPersonDropDown;
    @FindBy(xpath = "//*[text()[contains(.,'When will you')]]")
    private WebElement whenWillyouBeTakingOffDropDown;
    @FindBy(id = "timeFrameSelection_SingleFlight_SpecificMonth")
    private WebElement singleFlightMonthSelect;
    @FindBy(xpath = "//select[@id='data-flight-type']")
    private WebElement flightTypeSelect;

    @FindBy(xpath = "//label[text()[contains(.,'Specific date')]]")
    private WebElement specificDateRadiobutton;
    @FindBy(xpath = "//*[@class='radiofield-wrapper']/label[text()[contains(.,'Specific month')]]")
    private WebElement specificMonthRadiobutton;


    @FindBy(id = "budgetSelection_EurosBudget")
    private WebElement budgetTextbox;
    @FindBy(css = ".text-align-center .button-primary")
    private WebElement searchButton;

    @FindBy(xpath = "//ol[contains(@class,'AS-destinations-list')]/li[1]//*[@class='integer']")
    private WebElement firstRowTableItemPrice;
    @FindBy(xpath = "//ol[contains(@class,'AS-destinations-list')]/li[1]//*[@class='panel']/div/div[2]/h2")
    private WebElement firstRowTableItemCity;
    @FindBys(@FindBy(xpath = "//ol[contains(@class,'AS-destinations-list')]/li"))
    private List<WebElement> listOfResults;



    public void setDepartureAirport(String departure){
        Waiter.pause(3000);
        waiter.waitForPageLoaded(driver,TIMEOUT);
        waiter.waitForjQuery();
        CustomElement countryFromTextbox = new CustomElement(this.countryFromTextbox);
        waiter.waitForElementIsClickable(countryFromTextbox);
        countryFromTextbox.clear();
        countryFromTextbox.sendKeys(departure);
        autocompleteResult.click();
        logger.info("input departure airport : "+departure);

    }

    public void setDestinationAirport(String destination){

        waiter.waitForPageLoaded(driver,TIMEOUT);
        waiter.waitForjQuery();
        CustomElement countryToTextbox = new CustomElement(this.countryToTextbox);
        waiter.waitForElementIsClickable(countryToTextbox);
        countryToTextbox.clear();
        countryToTextbox.sendKeys(destination);
        autocompleteResult.click();
        logger.info("input destination airport :"+destination);

    }

    public void clickWhatIsYourBudgetPerPersonDropDown(){
        waiter.waitForPageLoaded(driver,TIMEOUT);
        waiter.waitForjQuery();
        CustomElement whatIsyourBudgetPerPersonDropDown = new CustomElement(this.whatIsyourBudgetPerPersonDropDown);
        waiter.waitForElementIsClickable(whatIsyourBudgetPerPersonDropDown);
        whatIsyourBudgetPerPersonDropDown.click();
        logger.info("click 'What is your budget per person ?' drop down");
    }

    public void setBudgetTextbox(String budget){

        CustomElement budgetTextbox = new CustomElement(this.budgetTextbox);
        waiter.waitForElementIsClickable(budgetTextbox);
        budgetTextbox.sendKeys(budget);
        logger.info("set budget : € " +budget);
    }

    public void clickWhenWillYouBeTakingOffDropDown(){
        waiter.waitForPageLoaded(driver,TIMEOUT);
        waiter.waitForjQuery();
        CustomElement whenWillyouBeTakingOffDropDown = new CustomElement(this.whenWillyouBeTakingOffDropDown);
        waiter.waitForElementIsClickable(whenWillyouBeTakingOffDropDown);
        String coordinates = whenWillyouBeTakingOffDropDown.getLocation().toString();
        String jsScript = "window.scroll" + coordinates;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript(jsScript);
        whenWillyouBeTakingOffDropDown.click();
        Waiter.pause(1000);
        logger.info("click 'When will you be taking off ?' drop down");
    }

    public void selectSingleFlightType(){

        CustomElement flightTypeSelect = new CustomElement(this.flightTypeSelect);
        select = new Select(flightTypeSelect);
        select.selectByValue("Single");
        logger.info("Select single flight type ");
    }

    public void selectSingleFlightMonth(String month){

        CustomElement singleFlightMonthSelect = new CustomElement(this.singleFlightMonthSelect);
        select = new Select(singleFlightMonthSelect);
        select.selectByValue(month);
        logger.info("Select single flight month ");
    }


    public void clickSearchButton(){

        CustomElement searchButton = new CustomElement(this.searchButton);
        waiter.waitForElementIsClickable(searchButton);
        searchButton.click();
        logger.info("click 'Search' button");
    }

    public String getFirstRowPriceAndCity(){
        CustomElement firstRowTableItemPrice = new CustomElement(this.firstRowTableItemPrice);
        CustomElement firstRowTableItemCity = new CustomElement(this.firstRowTableItemCity);
        String firstRowItemPrice = firstRowTableItemPrice.getText();
        String firstRowItemCity = firstRowTableItemCity.getText();
        logger.info("get table first row results (price , city )" +firstRowItemPrice + firstRowItemCity );
        return firstRowItemPrice + firstRowItemCity;

    }

    public int getResultListSize(){
        logger.info("get size of result list");
        return listOfResults.size();
    }

}
