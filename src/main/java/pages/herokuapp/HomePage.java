package pages.herokuapp;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {
    private static final String RELATIVE_URL = "";

    public HomePage(Page page) {
        super(page);
        this.navigate(RELATIVE_URL);
    }

    public String getInnerText(String selector) {
        return page.querySelector(selector).innerText();
    }
}
