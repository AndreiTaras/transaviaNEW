package steps;

import org.openqa.selenium.WebDriver;
import pages.YoutubePage;

public class YoutubePageSteps extends AbstractSteps {

    private YoutubePage youtubePage;
    public YoutubePageSteps(WebDriver driver) {
        super(driver);
        youtubePage = new YoutubePage(driver);
    }

    public String getVideoTitleAndOwnersName(){

       return youtubePage.getVideoTitleAndOwner();
    }
}
