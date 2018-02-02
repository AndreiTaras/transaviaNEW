package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.CustomElement;

public class BookingDetailsPage extends AbstractPage {

    public BookingDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='front']")
    private WebElement totalSum;
    @FindBy(xpath = "//*[contains(text(),'Transaction overview')]/following-sibling::div//*[@class='amount']")
    private WebElement paymentAmount;

    public String getTotalSum(){
        CustomElement totalSum = new CustomElement(this.totalSum);
        logger.info("get total sum");
        return totalSum.getText();
    }

    public String getPaymentAmount(){
        CustomElement paymentAmount = new CustomElement(this.paymentAmount);
        logger.info("get payment amount");
        return paymentAmount.getText();
    }
}
