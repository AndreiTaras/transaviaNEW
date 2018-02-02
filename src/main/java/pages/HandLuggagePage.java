package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrapper.CustomElement;

public class HandLuggagePage extends AbstractPage {

    public HandLuggagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".content-text-color iframe")
    private WebElement video;

    @FindBy(xpath = "//iframe[@src='//www.youtube.com/embed/fQMuhniqWAg']")
    private WebElement videoIframe;
    @FindBy(css = ".ytp-large-play-button")
    private WebElement playButton;
    @FindBy(xpath = "//div[@class='content-text-color']/h2[text()[contains(.,'Video')]]")
    private WebElement videoDescription;
    @FindBy(xpath = "//div[@class='ytp-right-controls']/a[@href='https://www.youtube.com/watch?v=fQMuhniqWAg']")
    private WebElement youtubeVideoLink;

    public String getVideoLink(){
        CustomElement video = new CustomElement(this.video);
        scrollToElement(video);
        waiter.waitForElementIsClickable(video);
        logger.info("get link");
        return video.getAttribute("scr");
    }

    public void openVideo(){

        CustomElement playButton = new CustomElement(this.playButton);
        CustomElement youtubeVideoLink = new CustomElement(this.youtubeVideoLink);
        scrollToElement(video);
        driver.switchTo().frame(videoIframe);
        waiter.waitForElementIsClickable(playButton);
        playButton.click();
        waiter.waitForElementIsClickable(youtubeVideoLink);
        youtubeVideoLink.click();
        logger.info("open youtube link");
        switchToNewTab();

    }
}
