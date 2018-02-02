package utils;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Waiter {

    private Wait<WebDriver> wait;
    private WebDriver driverWait;

    public Waiter(WebDriver driver) {
        this.driverWait = driver;
        wait = new WebDriverWait(this.driverWait, 10).ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .withMessage("Element was not found by locator ");
    }

    public void  waitForPageLoaded(WebDriver driver , long timeout){
        new FluentWait<WebDriver>(driver).withTimeout(timeout, TimeUnit.SECONDS).pollingEvery(1000,TimeUnit.MILLISECONDS)
                .until(new Function<WebDriver, Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver ).executeScript("return document.readyState").equals("complete");
                    }
                });
    }

    public void waitForElementsIsVisible(List<WebElement> elements){
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public void waitForElementAppearing(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementIsClickable(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void waitForjQuery(){
        wait.until(ExpectedConditions.jsReturnsValue("return jQuery.active == 0;"));
    }

    public static void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
