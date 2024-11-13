package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.herokuapp.KeyPressesPage;

import static org.testng.Assert.assertEquals;

public class KeyPressesTest extends BaseTest {

    private KeyPressesPage keyPressesPage;

    private static final String PAGE_TITLE_TEXT = "Key Presses";
    private static final String PAGE_SUBTITLE_TEXT = "Key presses are often used to interact with a website (e.g., tab " +
            "order, enter, escape, etc.). Press a key and see what you inputted.";

    @BeforeMethod
    public void setUp() {
        super.setUp();
        keyPressesPage = new KeyPressesPage(page);
    }

    @Test
    public void validateKeyPressesPageTitleIsCorrect() {
        assertEquals(keyPressesPage.getTitle(), PAGE_TITLE_TEXT, "Page title does not match the expected text");
    }

    @Test
    public void validateKeyPressesPageSubtitleIsCorrect() {
        assertEquals(keyPressesPage.getPageSubTitleText(), PAGE_SUBTITLE_TEXT, "Page sub-title does not match " +
                "the expected text");
    }

    @DataProvider(name = "keys-provider")
    public Object[][] provideData() {
        return new Object[][] {
                { "A", "A" },
                { "1", "1" },
                { "Space", "SPACE" },
                { "Enter", "ENTER" },
                { "Tab", "TAB" },
                { "Comma", "COMMA" }};
    }

    @Test(dataProvider = "keys-provider")
    public void validateKeyPressed(String key, String expectedKey) {
        keyPressesPage.pressKey(key);
        assertEquals(keyPressesPage.getPressedKeyResult(), "You entered: " + expectedKey,
                "The key press result is not as expected");
    }
}
