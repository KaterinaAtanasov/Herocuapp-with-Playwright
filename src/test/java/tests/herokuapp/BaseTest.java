package tests.herokuapp;
import com.herokuapp.playwright.Config;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
        protected Browser browser;
        protected Page page;

        @BeforeMethod
        public void setUp() {
            BrowserType browserType;
            switch (Config.BROWSER_TYPE.toLowerCase()) {
                case "firefox":
                    browserType = Playwright.create().firefox();
                    break;
                case "chromium":
                    browserType = Playwright.create().chromium();
                    break;
                case "webkit":
                    browserType = Playwright.create().webkit();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser type: " + Config.BROWSER_TYPE);
            }
            browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(Config.HEADLESS));
            page = browser.newPage();
        }

        @AfterMethod
        public void tearDown() {
            browser.close();
        }
    }

