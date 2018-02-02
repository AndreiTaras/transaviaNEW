package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.CustomElement;

public class YoutubePage extends AbstractPage {

    public YoutubePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#container .title")
    private WebElement videoTitle;

    @FindBy(css = "#owner-container .yt-formatted-string")
    private WebElement videoOwner;


    public String getVideoTitleAndOwner(){

        waiter.waitForPageLoaded(driver,TIMEOUT);
        CustomElement videoTitle = new CustomElement(this.videoTitle);
        CustomElement videoOwner = new CustomElement(this.videoOwner);
        waiter.waitForElementAppearing(videoTitle);
        waiter.waitForElementAppearing(videoOwner);

        return videoTitle.getText() + videoOwner.getText();
    }
}
