package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.HomePage;
import static org.testng.Assert.assertEquals;

public class HomeTest extends BaseTest {
    private HomePage homePage;
    private static final String TITLE = "The Internet";
    private static final String HEADING_1 = "Welcome to the-internet";
    private static final String HEADING_2 = "Available Examples";
    private static final String H1_SELECTOR = "h1";
    private static final String H2_SELECTOR = "h2";

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
        assertEquals(homePage.getInnerText(H1_SELECTOR), HEADING_1, "Heading 1 does not match the expected text");
        assertEquals(homePage.getInnerText(H2_SELECTOR), HEADING_2, "Heading 2 does not match the expected text");
    }
}
