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
    public void testSuccessfulLogin() {
        loginPage.navigate();
        assertEquals(page.innerText("h2"), "Login Page",
                "Heading does not match the expected text");
        loginPage.login();
        assertTrue(loginPage.getAlertText().contains("You logged into a secure area!"),
                "Alert text does not contain the expected message");
    }
}
