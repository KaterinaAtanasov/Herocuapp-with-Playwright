package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.FloatingMenuPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FloatingMenuTest extends BaseTest{
    private FloatingMenuPage floatingMenuPage;
    private static final String PAGE_TITLE = "Floating Menu";

    @BeforeMethod
    public void setUp() {
        super.setUp();
        floatingMenuPage = new FloatingMenuPage(page);
    }
    @Test
    public void verifyFloatingMenuPageTitleIsCorrect(){
        assertEquals(floatingMenuPage.getTitle(), PAGE_TITLE, "Page title does " +
                "not match the expected text");
    }

    @Test
    public void verifyFloatingMenuAndFooterVisibility() {
        floatingMenuPage.scrollIntoViewIfNeeded();

        assertTrue(floatingMenuPage.isFloatingMenuVisible(), "Floating menu is not" +
                " visible");
        assertTrue(floatingMenuPage.isFooterVisible(), "Footer is not visible");
    }

    @Test
    public void verifyNavigationAfterClickingMenuItems() {
        floatingMenuPage.scrollIntoViewIfNeeded();

        floatingMenuPage.clickHomeLink();
        assertUrlEndsWith(floatingMenuPage.getHomeUrl());

        floatingMenuPage.clickNewsLink();
        assertUrlEndsWith(floatingMenuPage.getNewsUrl());

        floatingMenuPage.clickContactLink();
        assertUrlEndsWith(floatingMenuPage.getContactUrl());

        floatingMenuPage.clickAboutLink();
        assertUrlEndsWith(floatingMenuPage.getAboutUrl());
    }

    private void assertUrlEndsWith(String expectedUrlEnding) {
        assertTrue(page.url().endsWith(expectedUrlEnding),
                "URL does not end with expected value: " + expectedUrlEnding);
    }
}
