package tests.herokuapp;

import pages.herokuapp.CheckboxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CheckboxTest extends BaseTest{
    private CheckboxPage checkboxPage;
    private static final String PAGE_TITLE = "Checkboxes";
    @BeforeMethod
    public void setUp() {
        super.setUp();
        checkboxPage = new CheckboxPage(page);
    }

    @Test
    public void verifyCheckboxIsCheckedAndUnchecked() {

        assertEquals(checkboxPage.getTitle(), PAGE_TITLE,
                "Heading does not match the expected text");
        assertTrue(checkboxPage.isCheckboxChecked(1), "Checkbox 2 should be checked");

        checkboxPage.checkCheckbox(0);
        assertTrue(checkboxPage.isCheckboxChecked(0), "Checkbox 1 should be checked");

        checkboxPage.uncheckCheckbox(0);
        checkboxPage.uncheckCheckbox(1);
        assertFalse(checkboxPage.isCheckboxChecked(0), "Checkbox 1 should be unchecked");
        assertFalse(checkboxPage.isCheckboxChecked(1), "Checkbox 2 should be unchecked");
    }
}
