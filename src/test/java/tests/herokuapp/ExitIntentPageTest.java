package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.ExitIntentPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class ExitIntentPageTest extends BaseTest{

    private ExitIntentPage exitIntentPage;
    private static final String PAGE_HEADING = "Exit Intent";
    private static final String POPUP_TITLE = "THIS IS A MODAL WINDOW";

    @BeforeMethod
    public void setUp() {
        super.setUp();
        exitIntentPage = new ExitIntentPage(page);
    }

    @Test
    public void verifyPageHeadingIsCorrect(){
        assertEquals(exitIntentPage.getTitle(), PAGE_HEADING, "Page heading does " +
                "not match the expected text");
    }

    @Test
    public void verifyPopupVisibilityAndTitle() {
        exitIntentPage.triggerExitIntent();
        assertTrue(exitIntentPage.isPopupVisible(), "Popup should be visible");

        assertEquals(exitIntentPage.getPopupTitle(), POPUP_TITLE, "Popup title does " +
                "not match the expected text");
    }

    @Test
    public void verifyPopupClosedOnClick() {
        exitIntentPage.closePopup();
        assertFalse(exitIntentPage.isPopupVisible(), "Popup should be closed " +
                "after clicking the close button");
    }
}
