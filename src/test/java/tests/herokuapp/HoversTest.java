package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.HoversPage;
import static org.testng.Assert.assertEquals;
public class HoversTest extends BaseTest{

    private HoversPage hoversPage;
    private static final String PAGE_TITLE_TEXT = "Hovers";
    private static final String PAGE_SUBTITLE_TEXT = "Hover over the image for additional information";

    @BeforeMethod
    public void setUp() {
        super.setUp();
        hoversPage = new HoversPage(page);
    }

    @Test
    public void validateHoversPageTitleTextIsCorrect() {
        assertEquals(hoversPage.getTitle(), PAGE_TITLE_TEXT, "Page title does not match the " +
                "expected text");
    }

    @Test
    public void validateHoversPageSubTitleTextIsCorrect() {
        assertEquals(hoversPage.getPageSubTitleText(), PAGE_SUBTITLE_TEXT, "Page sub-title does not match the" +
                " expected text");
    }

    @Test
    public void validateHoverTexts() {
        for (int i = 1; i <= 3; i++) {
            hoversPage.hoverOnFigure(i);
            String hoverText = hoversPage.getHoverText(i);
            assertEquals(hoverText, "name: user" + i, "Hover text for figure " + i + " does not match " +
                    "the expected text");
        }
    }
    @Test
    public void validateProfileLinkTexts() {
        for (int i = 1; i <= 3; i++) {
            hoversPage.hoverOnFigure(i);
            String linkText = hoversPage.getProfileLinkText(i);
            assertEquals(linkText, "View profile", "Profile link text for figure " + i + " does " +
                    "not match the expected text");
        }
    }

}
