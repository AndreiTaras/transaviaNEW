package transavia.tests.low.priority.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import transavia.tests.config.TestBase;
import utils.PropertyProvider;

public class CheckVideoTitleAndAuthorTest extends TestBase {


    @Test(groups = "checkVideoLink" , description = "Check video link")
    public void checkVideo(){

        String videoTitle = PropertyProvider.getProperty("videoTitle");
        String videoAuthor = PropertyProvider.getProperty("videoAuthor");

        Assert.assertEquals(videoTitle+videoAuthor , homePageSteps.navigateToHandLuggagePage().
                                                                      openVideoOnYoutube().
                                                                      getVideoTitleAndOwnersName() );

    }
}
