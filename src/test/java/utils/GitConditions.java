package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

/**
 * Created by sunny_IT on 1/26/2017.
 */
public class GitConditions {

    public static ExpectedCondition<Boolean> personalAccountFieldIsValidated(final WebDriver wd, By locator) {

        return webDriver -> webDriver.findElement(locator).getAttribute("class").equals("form-control is-autocheck-successful");
    }

    public static ExpectedCondition<Boolean> stepIsPassed(final WebDriver wd, int step) {

        return webDriver -> webDriver.findElements(By.cssSelector("ol.steps li.complete")).size() == step;
    }

    public static ExpectedCondition<Boolean> registrationComplete(final WebDriver wd) {

        return webDriver -> webDriver.findElement(By.cssSelector("h2.shelf-title"))
                .getText()
                .equals("Learn Git and GitHub without any code!");
    }
    public static ExpectedCondition<Boolean> errorCaptionIsDisplayed(final WebDriver wd, By locator, String errorText) {

        return webDriver -> webDriver.findElement(locator).getText().equals(errorText);
    }

    public static ExpectedCondition<Boolean> errorMessageFound(final WebDriver wd, By locator, String errorText) {


        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(locator);

                for(WebElement el : elements) {
                    if(el.getText().equals(errorText)) return true;

                }
                return false;
            }
        };

    }

    public static ExpectedCondition<Boolean> errorsAreDisplayed() {

        return webDriver -> webDriver.findElements(By.cssSelector("form#signup-form dl.form-group.errored dd.error")).size() > 0;
    }


}
