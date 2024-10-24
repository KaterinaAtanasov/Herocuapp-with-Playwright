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
    public void loginWithCredentials(boolean isValidUser) {
        String username = isValidUser ? Config.USERNAME : Config.INVALID_USERNAME;
        String password = isValidUser ? Config.PASSWORD : Config.INVALID_PASSWORD;
        page.fill("#username", username);
        page.fill("#password", password);
        page.click(".radius");
    }

    public String getAlertText() {
        return page.innerText("#flash");
    }
    public String getWelcomeMessageText() {
        return page.innerText(".subheader");
    }

    public String getSecureAreaHeaderText() {
        return page.innerText("h2");
    }

    public String getLogoutButtonText() {
        return page.innerText(".button.secondary.radius");
    }

    public void logout() {
        page.click(".button.secondary.radius");
    }

    public String getErrorMessage() {
        return page.innerText("#flash");
    }
}
