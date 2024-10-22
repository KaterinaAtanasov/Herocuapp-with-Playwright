package pages.herokuapp;
import com.herokuapp.playwright.Config;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage{

    private static final String URL = Config.BASE_URL;

    public HomePage(Page page) {
        super(page);
    }

    public void navigate() {
        super.navigate(URL);
    }

    public String getInnerText(String selector) {
        return page.querySelector(selector).innerText();
    }
}
