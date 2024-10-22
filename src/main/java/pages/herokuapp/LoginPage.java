package pages.herokuapp;
import com.herokuapp.playwright.Config;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage{

    private static final String URL = Config.BASE_URL + "/login";

    public LoginPage(Page page) {
        super(page);
    }

    public void navigate() {
        super.navigate(URL);
    }
    public void login() {
        page.fill("#username", Config.USERNAME);
        page.fill("#password", Config.PASSWORD);
        page.click(".radius");
    }

    public String getAlertText() {
        return page.innerText("#flash");
    }
}
