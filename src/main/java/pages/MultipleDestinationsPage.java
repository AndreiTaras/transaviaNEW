package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.CustomElement;

public class MultipleDestinationsPage extends AbstractPage {

    public MultipleDestinationsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "openJawRouteSelection_DepartureStationOutbound-input")
    private WebElement outboundFlightFromTextbox;
    @FindBy(xpath = "//*[@class='results']/li[1]")
    private WebElement autocompleteFrom;
    @FindBy(id = "openJawRouteSelection_ArrivalStationOutbound-input")
    private WebElement outboundFlightToTextbox;
    @FindBy(xpath = "//ol[@class='results']/li[contains(@class,'item')]")
    private WebElement autocompleteTo;
    @FindBy(id = "dateSelection_OutboundDate-datepicker")
    private WebElement outboundFlightDateTextbox;
    @FindBy(id = "openJawRouteSelection_DepartureStationInbound-input")
    private WebElement inboundFlightFromTextbox;
    @FindBy(id = "openJawRouteSelection_ArrivalStationInbound-input")
    private WebElement inboundFlightToTextbox;
    @FindBy(id = "dateSelection_InboundDate-datepicker")
    private WebElement inboundFlightDateTextbox;
    @FindBy(xpath = ".//*[@class='date-picker-suggestions']/li[@class='highlight']")
    private WebElement autocompleteDate;
    @FindBy(xpath = ".//*[@class='panel_section-button-container']/button[@type='submit']")
    private WebElement searchButton;
    @FindBy(xpath = ".//section[contains(@class,'outbound')]//div[@class='select']/span")
    private WebElement outboundFlightSelectButton;
    @FindBy(xpath = ".//section[contains(@class,'outbound')]//div[@class='actions']/div[1]")
    private WebElement outboundFlightPrice;
    @FindBy(xpath = ".//section[contains(@class,'inbound')]//div[@class='select']/span")
    private WebElement inboundFlightSelectButton;
    @FindBy(xpath = ".//section[contains(@class,'inbound')]//div[@class='actions']/div[1]")
    private WebElement inboundFlightPrice;
    @FindBy(xpath = "//*[@class='flipper']/div[@class='back']")
    private WebElement totalAmount;


    public void setOutboundFlightFrom(String cityFrom){
        waiter.waitForPageLoaded(driver, TIMEOUT);
        waiter.waitForjQuery();
        CustomElement outboundFlightFromTextbox = new CustomElement(this.outboundFlightFromTextbox);
        CustomElement autocompleteFrom = new CustomElement(this.autocompleteFrom);
        waiter.waitForElementIsClickable(outboundFlightFromTextbox);
        outboundFlightFromTextbox.sendKeys(cityFrom);
        waiter.waitForElementIsClickable(autocompleteFrom);
        autocompleteFrom.click();
        logger.info("set departure airport");

    }

    public void setOutboundFlightTo(String cityTo){

        CustomElement outboundFlightToTextbox = new CustomElement(this.outboundFlightToTextbox);
        CustomElement autocompleteTo = new CustomElement(this.autocompleteTo);
        waiter.waitForElementIsClickable(outboundFlightToTextbox);
        outboundFlightToTextbox.sendKeys(cityTo);
        waiter.waitForElementIsClickable(autocompleteTo);
        autocompleteTo.click();
        logger.info("set destination airport");

    }

    public void setOutboundFlightDate(String date){

        CustomElement outboundFlightDateTextbox = new CustomElement(this.outboundFlightDateTextbox);
        waiter.waitForElementIsClickable(outboundFlightDateTextbox);
        outboundFlightDateTextbox.clear();
        outboundFlightDateTextbox.sendKeys(date);
        logger.info("set outbound flight date");
    }

    public void setInboundFlightFrom(String cityFrom){

        CustomElement inboundFlightFromTextbox = new CustomElement(this.inboundFlightFromTextbox);
        CustomElement autocompleteFrom = new CustomElement(this.autocompleteFrom);
        waiter.waitForElementIsClickable(inboundFlightFromTextbox);
        inboundFlightFromTextbox.sendKeys(cityFrom);
        waiter.waitForElementIsClickable(autocompleteFrom);
        autocompleteFrom.click();
        logger.info("set departure airport ");
    }

    public void setInboundFlightTo(String cityTo){

        CustomElement inboundFlightToTextbox = new CustomElement(this.inboundFlightToTextbox);
        CustomElement autocompleteTo = new CustomElement(this.autocompleteTo);
        waiter.waitForElementIsClickable(inboundFlightToTextbox);
        inboundFlightToTextbox.sendKeys(cityTo);
        waiter.waitForElementIsClickable(autocompleteTo);
        autocompleteTo.click();
        logger.info("set destination airport");
    }

    public void setInboundFlightDate(String date){

        CustomElement inboundFlightDateTextbox = new CustomElement(this.inboundFlightDateTextbox);
        waiter.waitForElementIsClickable(inboundFlightDateTextbox);
        inboundFlightDateTextbox.clear();
        inboundFlightDateTextbox.sendKeys(date);
        inboundFlightToTextbox.click();
        logger.info("set inbound flight date");
    }

    public void clickSearchButton(){

        CustomElement searchButton = new CustomElement(this.searchButton);
        waiter.waitForElementIsClickable(searchButton);
        searchButton.click();
        logger.info("click search button");
    }

    public void clickOutboundFlightSelectButton(){

        waiter.waitForjQuery();
        CustomElement outboundFlightSelectButton = new CustomElement(this.outboundFlightSelectButton);
        waiter.waitForElementIsClickable(outboundFlightSelectButton);
        outboundFlightSelectButton.click();
        logger.info("Select outbound flight");
    }

    public void clickInboundFlightSelectButton(){

        CustomElement inboundFlightSelectButton = new CustomElement(this.inboundFlightSelectButton);
        waiter.waitForElementIsClickable(inboundFlightSelectButton);
        inboundFlightSelectButton.click();
        logger.info("Select inbound flight ");
        waiter.waitForPageLoaded(driver,TIMEOUT);
    }

    public double getOutboundFlightPrice(){

        CustomElement outboundFlightPrice = new CustomElement(this.outboundFlightPrice);
        waiter.waitForElementAppearing(outboundFlightPrice);
        String price = outboundFlightPrice.getText();
        String total = price.substring(2,price.length());
        double outboundPrice = Double.parseDouble(total);
        return outboundPrice;
    }

    public double getInboundFlightPrice(){

        CustomElement inboundFlightPrice = new CustomElement(this.inboundFlightPrice);
        waiter.waitForElementAppearing(inboundFlightPrice);
        String price = inboundFlightPrice.getText();
        String total = price.substring(2,price.length());
        double inboundPrice = Double.parseDouble(total);
        return inboundPrice;
    }


    public double getTotalAmount(){

        waiter.waitForPageLoaded(driver,TIMEOUT);
        waiter.waitForjQuery();
        CustomElement totalAmount = new CustomElement(this.totalAmount);
        waiter.waitForElementAppearing(totalAmount);
        String price = totalAmount.getText();
        String total = price.substring(2,price.length());
        double totalDouble = Double.parseDouble(total);
        System.out.println("total price = " +totalDouble);
        return totalDouble;

    }

}
