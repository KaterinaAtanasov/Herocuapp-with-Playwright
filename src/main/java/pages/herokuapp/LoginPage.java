package pages.herokuapp;
import com.herokuapp.playwright.Config;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private static final String URL = "/login";
    private static final String USERNAME_FIELD = "#username";
    private static final String PASSWORD_FIELD = "#password";
    private static final String SUBMIT_BUTTON = ".radius";
    private static final String ALLERT_TEXT = "#flash";
    private static final String SECURE_AREA_HEADER = "h2";
    private static final String WELCOME_MESSAGE = ".subheader";
    private static final String LOGOUT_BUTTON = ".button.secondary.radius";

    public LoginPage(Page page) {
        super(page);
        this.navigate(URL);
    }

    public void login(boolean isValidUser) {
        String username = isValidUser ? Config.USERNAME : Config.INVALID_USERNAME;
        String password = isValidUser ? Config.PASSWORD : Config.INVALID_PASSWORD;
        page.fill(USERNAME_FIELD, username);
        page.fill(PASSWORD_FIELD, password);
        page.click(SUBMIT_BUTTON);
    }

    public String getAlertText() {
        return page.innerText(ALLERT_TEXT);
    }

    public String getWelcomeMessageText() {
        return page.innerText(WELCOME_MESSAGE);
    }

    public String getSecureAreaHeaderText() {
        return page.innerText(SECURE_AREA_HEADER);
    }

    public String getLogoutButtonText() {
        return page.innerText(LOGOUT_BUTTON);
    }

    public void logout() {
        page.click(LOGOUT_BUTTON);
    }

    public String getErrorMessage() {
        return page.innerText(ALLERT_TEXT);
    }
}
