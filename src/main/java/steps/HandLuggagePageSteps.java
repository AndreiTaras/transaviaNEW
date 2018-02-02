package steps;

import org.openqa.selenium.WebDriver;
import pages.HandLuggagePage;

public class HandLuggagePageSteps extends AbstractSteps {

    private HandLuggagePage handLuggagePage;

    public HandLuggagePageSteps(WebDriver driver) {
        super(driver);
        handLuggagePage = new HandLuggagePage(driver);
    }

    public String getVideoLink(){

        return handLuggagePage.getVideoLink();
    }

    public YoutubePageSteps openVideoOnYoutube(){

        handLuggagePage.openVideo();
        return new YoutubePageSteps(driver);
    }
}
