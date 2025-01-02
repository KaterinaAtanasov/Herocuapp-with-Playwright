package tests.herokuapp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.DynamicControlsPage;

import static org.testng.Assert.*;

public class DynamicControlsTest extends BaseTest {

    private DynamicControlsPage dynamicControlsPage;
    private static final String PAGE_TITLE = "Dynamic Controls";
    private static final String CHECKBOX_EXAMPLE_HEADING = "Remove/add";
    private static final String INPUT_EXAMPLE_HEADING = "Enable/disable";
    private static final String BUTTON_TEXT_REMOVE = "Remove";
    private static final String BUTTON_TEXT_ADD = "Add";
    private static final String BUTTON_TEXT_ENABLE = "Enable";
    private static final String BUTTON_TEXT_DISABLE = "Disable";
    private static final String CHECKBOX_GONE_MESSAGE = "It's gone!";
    private static final String CHECKBOX_BACK_MESSAGE = "It's back!";
    private static final String INPUT_ENABLED_MESSAGE = "It's enabled!";
    private static final String INPUT_DISABLED_MESSAGE ="It's disabled!";

    @BeforeMethod
    public void setUp() {
        super.setUp();
        dynamicControlsPage = new DynamicControlsPage(page);
    }

    @Test
    public void verifyDynamicControlsPageTitleIsCorrect() {
        assertEquals(dynamicControlsPage.getTitle(), PAGE_TITLE, "Page title" +
                " does not match the expected text");
    }

    @Test
    public void verifyCorrectTitleForCheckboxExample() {
        assertEquals(dynamicControlsPage.getCheckboxExampleHeading(),CHECKBOX_EXAMPLE_HEADING,"Checkbox title " +
                "does not match the expected text.");
    }

    @Test
    public void verifyCorrectTitleForInputExample() {
        assertEquals(dynamicControlsPage.getInputExampleHeading(), INPUT_EXAMPLE_HEADING,"Input title does not " +
                "match the expected text.");
    }

    @Test
    public void verifyCanRemoveCheckboxByClickOnTheRemoveBtn() {
        dynamicControlsPage.clickCheckboxButton();
        dynamicControlsPage.waitForState(dynamicControlsPage.getCheckboxExampleLoader(), "HIDDEN");
        assertTrue(dynamicControlsPage.isCheckboxPresent(),"Checkbox input is still visible");
        assertEquals(dynamicControlsPage.getCheckboxMessageText(), CHECKBOX_GONE_MESSAGE,"Checkbox message text is not" +
                " as expected.");
    }

    @Test
    public void verifyCorrectBtnTextInCheckboxExampleSectionWhenCheckboxIsVisible() {
        assertEquals(dynamicControlsPage.getCheckboxButtonText(), BUTTON_TEXT_REMOVE,"Checkbox example text does" +
                " not match the expected text.");
    }

    @Test
    public void verifyCorrectBtnTextInCheckboxExampleSectionWhenCheckboxIsNotVisible() {
        dynamicControlsPage.clickCheckboxButton();
        dynamicControlsPage.waitForState(dynamicControlsPage.getCheckboxExampleLoader(), "HIDDEN");
        assertEquals(dynamicControlsPage.getCheckboxMessageText(), CHECKBOX_GONE_MESSAGE,"Checkbox message text is not" +
                " as expected.");
        assertEquals(dynamicControlsPage.getCheckboxButtonText(), BUTTON_TEXT_ADD,"Checkbox example text does not" +
                " match teh expected text");
    }

    @Test
    public void verifyCanAddCheckboxByClickOnAddBtn() {
        dynamicControlsPage.clickCheckboxButton();
        dynamicControlsPage.waitForState(dynamicControlsPage.getCheckboxExampleLoader(), "HIDDEN");
        assertEquals(dynamicControlsPage.getCheckboxMessageText(), CHECKBOX_GONE_MESSAGE,"Checkbox example text does not " +
                "match teh expected text");

        dynamicControlsPage.clickCheckboxButton();
        dynamicControlsPage.waitForState(dynamicControlsPage.getCheckboxExampleLoader(), "HIDDEN");
        assertEquals(dynamicControlsPage.getCheckboxMessageText(), CHECKBOX_BACK_MESSAGE,"Checkbox example text does not " +
                "match teh expected text");
        assertFalse(dynamicControlsPage.isCheckboxPresent(),"Checkbox input is still visible");
    }

    @Test
    public void verifyCanEnableInputFieldByClickOnEnableBtn() {
        dynamicControlsPage.clickInputButton();
        dynamicControlsPage.waitForState(dynamicControlsPage.getInputExampleLoader(), "HIDDEN");
        assertEquals(dynamicControlsPage.getInputButtonText(), BUTTON_TEXT_ENABLE,"Input example text does not" +
                " match the expected text");
        assertTrue(dynamicControlsPage.isInputEnabled(),"Input field is not enabled");

    }

    @Test
    public void verifyCorrectBtnTextInTheInputExampleSectionWhenInputIsDisabled() {
        dynamicControlsPage.clickInputButton();
        dynamicControlsPage.waitForState(dynamicControlsPage.getInputExampleLoader(), "HIDDEN");
        assertEquals(dynamicControlsPage.getInputMessageText(),INPUT_ENABLED_MESSAGE,"Input message text does not match the expected text.");
        assertEquals(dynamicControlsPage.getInputButtonText(), BUTTON_TEXT_DISABLE,"Input message text does not match the expected text.");
    }

    @Test
    public void verifyCanDisableTheTextFieldByClickOnTheDisableBtn() {
        dynamicControlsPage.clickInputButton();
        dynamicControlsPage.waitForState(dynamicControlsPage.getInputExampleLoader(), "HIDDEN");
        assertEquals(dynamicControlsPage.getInputMessageText(),INPUT_ENABLED_MESSAGE,"Input message text does not match the expected text.");
        assertTrue(dynamicControlsPage.isInputEnabled(),"Input field is not enabled");

        dynamicControlsPage.clickInputButton();
        dynamicControlsPage.waitForState(dynamicControlsPage.getInputExampleLoader(), "HIDDEN");
        assertEquals(dynamicControlsPage.getInputMessageText(),INPUT_DISABLED_MESSAGE,"Input message text does not match the expected text.");
        assertTrue(dynamicControlsPage.isElementDisabled(), "Input field is not disabled");
    }
}
