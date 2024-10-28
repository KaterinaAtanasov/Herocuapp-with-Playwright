package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.LoginPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(page);
    }

    @Test
    public void verifyLoginWithValidCredentialsRedirectsToSecureArea() {
        loginPage.login(true);
        assertTrue(loginPage.getAlertText().contains("You logged into a secure area!"),
                "Alert text does not contain expected message");
        assertEquals(loginPage.getSecureAreaHeaderText(), "Secure Area",
                "Header does not match the expected text");
        assertEquals(loginPage.getWelcomeMessageText(),
                "Welcome to the Secure Area. When you are done click logout below.",
                "Welcome message does not match the expected text");
        assertEquals(loginPage.getLogoutButtonText(), "Logout",
                "Logout button text does not match the expected text");
    }

    @Test
    public void verifyLoginAttemptWithInvalidCredentialsDisplaysErrorMessage() {
        loginPage.login(false);
        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Your username is invalid!") ||
                        errorMessage.contains("Your password is invalid!"),
                "Error message does not contain the expected text");
    }
}
