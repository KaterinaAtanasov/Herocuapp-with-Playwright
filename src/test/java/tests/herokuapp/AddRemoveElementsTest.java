package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.AddRemoveElementsPage;
import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest extends BaseTest {
    private AddRemoveElementsPage addRemoveElements;
    private static final String PAGE_TITLE = "Add/Remove Elements";

    @BeforeMethod
    public void setUp() {
        super.setUp();
        addRemoveElements = new AddRemoveElementsPage(page);
    }

    @Test
    public void verifyAddRemoveElementsPageTitleIsCorrect() {
        assertEquals(addRemoveElements.getTitle(), PAGE_TITLE, "Heading does not match the expected text");
    }
    @Test
    public void verifyCorrectNumberToDeleteButtonsAfterAddAndRemoveElements() {
        int elementCount = 5;
        addRemoveElements.addElements(elementCount);
        assertEquals(addRemoveElements.getNumberOfDeleteButtons(), elementCount,
                "The number of delete buttons is not as expected after adding elements");
        addRemoveElements.removeElements(elementCount);
        assertEquals(addRemoveElements.getNumberOfDeleteButtons(), 0,
                "The number of delete buttons is not as expected after removing elements");
    }
}
