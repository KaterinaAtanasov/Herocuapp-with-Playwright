package tests.herokuapp;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import pages.herokuapp.AddRemoveElements;
import static org.testng.Assert.assertEquals;
public class AddRemoveElementsTest extends BaseTest{

    private AddRemoveElements addRemoveElements;
    @BeforeMethod
    public void setUp() {
        super.setUp();
        addRemoveElements = new AddRemoveElements(page);
    }
    @Test
    public void testAddRemoveElements() {
        int elementCount = 5;

        addRemoveElements.navigate();
        assertEquals(page.innerText("h3"), "Add/Remove Elements",
                "Heading does not match the expected text");
        addRemoveElements.addElements(elementCount);

       assertEquals(addRemoveElements.getNumberOfDeleteButtons(), elementCount,
                "The number of delete buttons is not as expected after adding elements");

        addRemoveElements.removeElements(elementCount);
        assertEquals(addRemoveElements.getNumberOfDeleteButtons(), 0,
                "The number of delete buttons is not as expected after removing elements");
    }
}
