package tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.NeedsFreshDriver;

import org.apache.log4j.Logger;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by sunny_IT on 1/26/2017.
 */

@Listeners(TestListeners.class)
public class TestBase {

    static Logger logger = Logger.getLogger(TestBase.class);

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp(ITestContext context) throws Exception {
        app.init();
        context.setAttribute("app", app);
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {

        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p) throws IOException {
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));

        if (m.getAnnotation(NeedsFreshDriver.class) != null) {
                System.out.println("Restarting the browser");
                app.stop();
                app.init();
        }

    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {logger.info("Stop test " + m.getName());
    }
}
