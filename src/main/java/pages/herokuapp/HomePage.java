package pages.herokuapp;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    private static final String RELATIVE_URL = "";
    private static final String WELCOME_HEADING_SELECTOR = "h1";
    private static final String EXAMPLES_HEADING_SELECTOR = "h2";

    public HomePage(Page page) {
        super(page);
        this.navigate(RELATIVE_URL);
    }

    public String getWelcomeHeadingText() {
        return page.querySelector(WELCOME_HEADING_SELECTOR).innerText();
    }

    public String getExamplesHeadingText() {
        return page.querySelector(EXAMPLES_HEADING_SELECTOR).innerText();
    }
}
