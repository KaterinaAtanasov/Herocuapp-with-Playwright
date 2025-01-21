package tests.herokuapp;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.JavaScriptAlertsPage;

import static org.testng.Assert.assertEquals;

public class JavaScriptAlertsTest extends BaseTest{
    private static final String PAGE_TITLE= "JavaScript Alerts";

    private JavaScriptAlertsPage javaScriptAlertsPage;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        javaScriptAlertsPage = new JavaScriptAlertsPage(page);
    }
    @Test
    public void verifyJsAlertsPageTitleIsCorrect(){
        assertEquals(javaScriptAlertsPage.getTitle(), PAGE_TITLE, "Page title does " +
                "not match the expected text");
    }
    @Test
    public void verifyResulTextAfterJSAlertAccept() {
        javaScriptAlertsPage.acceptDialog();

        javaScriptAlertsPage.clickJsAlertButton();

        String alertMessage = javaScriptAlertsPage.getLastDialogMessage();
        Assert.assertEquals(alertMessage, "I am a JS Alert", "Alert message does not match.");

        String resultText = javaScriptAlertsPage.getResultText();
        Assert.assertEquals(resultText, "You successfully clicked an alert", "Result text does not match" +
                " after JS Alert.");
    }
    @Test
    public void verifyResulTextAfterJsAlertConfirm() {

        javaScriptAlertsPage.acceptDialog();

        javaScriptAlertsPage.clickJsConfirmButton();

        String confirmMessage = javaScriptAlertsPage.getLastDialogMessage();
        Assert.assertEquals(confirmMessage, "I am a JS Confirm", "Confirm message does not match.");

        String resultText = javaScriptAlertsPage.getResultText();
        Assert.assertEquals(resultText, "You clicked: Ok", "Result text does not match after accepting JS Confirm.");
    }

    @Test
    public void verifyResultTextAfterJsAlertDismiss() {

        javaScriptAlertsPage.dismissDialog();

        javaScriptAlertsPage.clickJsConfirmButton();

        String confirmMessage = javaScriptAlertsPage.getLastDialogMessage();
        Assert.assertEquals(confirmMessage, "I am a JS Confirm", "Confirm message does not match.");

        String resultText = javaScriptAlertsPage.getResultText();
        Assert.assertEquals(resultText, "You clicked: Cancel", "Result text does not match after dismissing JS Confirm.");
    }

    @Test
    public void verifyResultTextAfterJSPromptAcceptWithInput() {

        String inputText = "Test Input";

        javaScriptAlertsPage.acceptPromptDialog(inputText);

        javaScriptAlertsPage.clickJsPromptButton();

        String promptMessage = javaScriptAlertsPage.getLastDialogMessage();
        Assert.assertEquals(promptMessage, "I am a JS prompt", "Prompt message does not match.");

        String resultText = javaScriptAlertsPage.getResultText();
        Assert.assertEquals(resultText, "You entered: " + inputText, "Result text does not match after accepting JS Prompt with input.");
    }

    @Test
    public void verifyResultTextAfterJSPromptDismiss() {

        javaScriptAlertsPage.dismissDialog();

        javaScriptAlertsPage.clickJsPromptButton();

        String promptMessage = javaScriptAlertsPage.getLastDialogMessage();
        Assert.assertEquals(promptMessage, "I am a JS prompt", "Prompt message does not match.");

        String resultText = javaScriptAlertsPage.getResultText();
        Assert.assertEquals(resultText, "You entered: null", "Result text does not match after dismissing JS Prompt.");
    }
}
