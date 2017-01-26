package appmanager;

import model.AccountData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.util.ArrayList;
import java.util.List;

import static utils.GitConditions.*;


public class AccountHelper  extends HelperBase {

    By username;
    By email;
    By password;


    public AccountHelper(WebDriver wd) {
        this(wd, 0);

    }
    public AccountHelper(WebDriver wd, int waitTime) {
        super(wd, waitTime);

        username = new By.ById("user_login");
        email = new By.ById("user_email");
        password = new By.ById("user_password");

    }

    public AccountHelper fillAccountForm(AccountData accountData) {

        SoftAssert checkFieldsAreValid = new SoftAssert();


        type(username, accountData.getUserName());
        checkFieldsAreValid.assertTrue(wait.until(personalAccountFieldIsValidated(current(), username)),
                              "Username validation failed.");

        type(email, accountData.getEmailAddress());
        checkFieldsAreValid.assertTrue(wait.until(personalAccountFieldIsValidated(current(), email)),
                "Email Address validation failed.");


        type(password, accountData.getPassword());
        checkFieldsAreValid.assertTrue(wait.until(personalAccountFieldIsValidated(current(), password)),
                "Password validation failed.");

        checkFieldsAreValid.assertAll();

        return this;


    }
    public AccountHelper fillAccountFormWithInvalidData(String username, String email, String password) {

        type(this.username, username);
        type(this.email, email);
        type(this.password, password);

        return this;

    }

    public AccountHelper fillAccountFormWithEmptyData() {

        String empty = "";

        type(username, empty);
        type(email, empty);
        type(password,empty);

        return this;
    }


    public AccountHelper choosePersonalPlan() {
        click(By.cssSelector("input[name=plan][value=free]"));
        return this;
    }

    public AccountHelper checkUseGitHubFor() {
        click(By.id("answers_99_choice_464")); //Development option
        click(By.id("answers_99_choice_467")); //Research option
        return this;
    }


    public AccountHelper submitAccountCreation() {
        click(By.id("signup_button"));
        Assert.assertTrue(wait.until(stepIsPassed(current(), 1)),
                "Personal data submit failed");
        return this;
    }

    public AccountHelper submitEmptyAccountCreation() {

        click(By.id("signup_button"));
        SoftAssert sa = new SoftAssert();

        sa.assertTrue(wait.until(errorCaptionIsDisplayed(current(),
                new By.ByCssSelector("div.flash.flash-error.my-3"),
                "There were problems creating your account.")),
                "'There were problems creating your account' message was not displayed.");

        Assert.assertTrue(wait.until(errorMessageFound(current(),
                new By.ByCssSelector("dd.error"),
                "Login can't be blank")),
                "'Login can't be blank' message was not displayed.");

        sa.assertTrue(wait.until(errorMessageFound(current(),
                new By.ByCssSelector("dd.error"),
                "Email can't be blank")),
                "'Email can't be blank' message was not displayed.");
        sa.assertTrue(wait.until(errorMessageFound(current(),
                new By.ByCssSelector("dd.error"),
                "Password can't be blank and is too short (minimum is 7 characters)")),
                "'Password can't be blank and is too short (minimum is 7 characters)' message was not displayed.");

        sa.assertAll();
        return this;
    }

    public AccountHelper submitPlanSelection() {

        click(By.cssSelector("button.btn.btn-primary.js-choose-plan-submit[type=submit]"));
        Assert.assertTrue(wait.until(stepIsPassed(current(), 2)),
                "Personal plan submit failed");
        return this;
    }

    public AccountHelper submitFinal() {

        click(By.name("commit"));
        Assert.assertTrue(wait.until(registrationComplete(current())),
                "Personal plan submit failed");
        return this;
    }


    public List<String> submitInvalidAccountCreation(String reason) {
        click(By.id("signup_button"));

        wait.until(errorsAreDisplayed());

        List<WebElement> elements = wd.findElements(By.cssSelector("form#signup-form dl.form-group.errored dd.error"));
        Assert.assertTrue(elements.size() > 0, "No error displayed though " + reason + " is incorrect");

        List<String> res = new ArrayList<>();
        for(WebElement el : elements) {
            res.add(el.getText());
        }

        return res;


    }
}