package tests.herokuapp;

import com.herokuapp.playwright.Config;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected Page page;
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setUpClass() {
        BrowserType browserType;
        switch (Config.BROWSER_TYPE.toLowerCase()) {
            case "firefox":
                playwright = Playwright.create();
                browserType = playwright.firefox();
                break;
            case "chromium":
                playwright = Playwright.create();
                browserType = playwright.chromium();
                break;
            case "webkit":
                playwright = Playwright.create();
                browserType = playwright.webkit();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + Config.BROWSER_TYPE);
        }
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(Config.HEADLESS));
        LOGGER.info("{} driver is initialized.", Config.BROWSER_TYPE);
    }

    @BeforeMethod
    public void setUp() {
        page = browser.newPage();
        LOGGER.info("New page is created");
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        LOGGER.info("Page is closed");
    }

    @AfterClass
    public void tearDownClass() {
        browser.close();
        playwright.close();
        LOGGER.info("Browser and Playwright are closed");
    }
}
