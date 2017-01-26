package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void joinPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Join GitHub")
                && isElementPresent(By.id("signup_button"))) {
            return;
        }
        click(By.cssSelector("a.btn btn-primary site-header-actions-btn"));
    }


}
