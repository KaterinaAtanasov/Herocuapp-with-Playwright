package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.HomePage;
import static org.testng.Assert.assertEquals;

public class HomeTest extends BaseTest {
    private HomePage homePage;
    private static final String TITLE = "The Internet";
    private static final String WELCOME_HEADING = "Welcome to the-internet";
    private static final String EXAMPLES_HEADING = "Available Examples";

    @BeforeMethod
    public void setUp() {
        super.setUp();
        homePage = new HomePage(page);
    }

    @Test
    public void verifyHomePageTitleIsCorrect() {
        assertEquals(homePage.getTitle(), TITLE, "The title does not match the expected text");
    }

    @Test
    public void verifyHomePageDisplaysCorrectText() {
        assertEquals(homePage.getWelcomeHeadingText(), WELCOME_HEADING, "Welcome heading does not match the" +
                " expected text");
        assertEquals(homePage.getExamplesHeadingText(), EXAMPLES_HEADING, "Examples heading does not match the" +
                " expected text");
    }
}
