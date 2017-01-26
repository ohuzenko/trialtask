package tests;

import dataProviders.DataProviders;
import model.AccountData;
import org.testng.annotations.Test;
import utils.NeedsFreshDriver;

import java.util.Arrays;
import java.util.List;



public class UserRegistration extends TestBase {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "getValidUserData")
    public void testAccountCreation(String user, String password, String email) {
        app.goTo().joinPage();
        app.account()
                .fillAccountForm(new AccountData().withUserName(user).withPassword(password).withEmailAddress(email))
                .submitAccountCreation()
                .choosePersonalPlan()
                .submitPlanSelection()
                .checkUseGitHubFor()
                .submitFinal();
  }

    @Test
    @NeedsFreshDriver
    public void testRegistrationWithEmptyData() {

      app.goTo().joinPage();
      app.account()
              .fillAccountFormWithEmptyData()
              .submitEmptyAccountCreation();

  }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "getInvalidUserData")
    public void testRegistrationWithInvalidData(String user, String email, String reason) {

        app.goTo().joinPage();
        List<String> result =  app.account()
                .fillAccountFormWithInvalidData(user, email, "correctpwd1")
                .submitInvalidAccountCreation(reason);

        for(String message: result) {
            logger.info("\terror message for incorrect " + reason + ": " + message);
        }
    }


}
