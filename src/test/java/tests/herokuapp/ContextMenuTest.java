package tests.herokuapp;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.ContextMenuPage;
import pages.herokuapp.FloatingMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest{
    private ContextMenuPage contextMenuPage;
    private static final String PAGE_TITLE = "Floating Menu";

    @BeforeMethod
    public void setUp() {
        super.setUp();
        contextMenuPage = new ContextMenuPage(page);
    }
    @Test
    public void verifyContextMenuPageTitleIsCorrect(){
        assertEquals(contextMenuPage.getTitle(), PAGE_TITLE, "Page title does " +
                "not match the expected text");
    }
    @Test
    public void verifyJSAlertMessageAppearsOnRightClick() {
        String alertMessage = contextMenuPage.getJSAlertMessage();

        String expectedAlertText = "You selected a context menu";
        Assert.assertEquals(alertMessage, expectedAlertText, "Alert text does not match the expected value.");
    }

    @Test
    public void verifyJSAlertIsTriggered() {
        boolean isAlertTriggered = contextMenuPage.isJSAlertTriggered();
        Assert.assertTrue(isAlertTriggered, "The JS alert was not triggered.");
    }
}
