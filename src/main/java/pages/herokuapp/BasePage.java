package pages.herokuapp;
import com.herokuapp.playwright.Config;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    protected Page page;
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigate(String path) {
        LOGGER.info("Navigating to: {}", Config.BASE_URL + path);
        page.navigate(Config.BASE_URL + path);
    }

    public String getTitle(){
        String title = page.title();
        LOGGER.info("Page title is: {}", title);
        return title;
    }
    public void waitForLoading() {
        ElementHandle loading = page.querySelector("#loading");
        if (loading != null) {
            page.waitForFunction("(element) => !element.isConnected", loading);
        }
    }
}
