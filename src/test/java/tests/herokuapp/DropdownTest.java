package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.DropdownPage;
import static org.testng.Assert.assertEquals;

public class DropdownTest extends BaseTest {
    private DropdownPage dropdownPage;
    private static final String PAGE_TITLE = "Dropdown List";
    @BeforeMethod
    public void setUp() {
        super.setUp();
        dropdownPage = new DropdownPage(page);
    }

    @Test
    public void verifyDropdownPageTitleIsCorrect() {
        assertEquals(dropdownPage.getTitle(), PAGE_TITLE,
                "Heading does not match the expected text");
    }

    @Test
    public void verifyDefaultOptionOfTheDropdownIsSelected() {
        assertEquals(dropdownPage.getSelectedOptionValue(), "", "Initially no option should be selected");
        assertEquals(dropdownPage.getSelectedOptionText(), dropdownPage.getDefaultOption(), "The default " +
                "option text is not as expected");

    }

    @Test
    public void verifySelectedOptionInTheDropdown(){
        dropdownPage.selectOption("1");
        assertEquals(dropdownPage.getSelectedOptionValue(), "1", "The selected option value is not" +
                " as expected");
        assertEquals(dropdownPage.getSelectedOptionText(), dropdownPage.getOptionOne(), "The selected option " +
                "text is not as expected");

        dropdownPage.selectOption("2");
        assertEquals(dropdownPage.getSelectedOptionValue(), "2", "The selected option value is not " +
                "as expected");
        assertEquals(dropdownPage.getSelectedOptionText(), dropdownPage.getOptionTwo(), "The selected option " +
                "text is not as expected");
    }
}

