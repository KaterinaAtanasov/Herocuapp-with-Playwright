package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.FloatingMenuPage;

import static org.testng.Assert.assertTrue;

public class FloatingMenuPageTest extends BaseTest{
    private FloatingMenuPage floatingMenuPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        floatingMenuPage = new FloatingMenuPage(page);
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
