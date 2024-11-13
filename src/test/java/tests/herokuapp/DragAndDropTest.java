package tests.herokuapp;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.herokuapp.DragAndDropPage;

import static org.testng.Assert.assertEquals;

public class DragAndDropTest extends BaseTest {

    private DragAndDropPage dragAndDropPage;
    private static final String PAGE_TITLE_TEXT = "Drag and Drop";

    @BeforeMethod
    public void setUp() {
        super.setUp();
        dragAndDropPage = new DragAndDropPage(page);
    }

    @Test
    public void validateDragAnDropPageTitleTextIsCorrect() {
        assertEquals(dragAndDropPage.getTitle(), PAGE_TITLE_TEXT, "Page title does not match the " +
                "expected text");
    }


    @Test
    public void validateDragAndDropAtoB() {
        String boxATextBefore = dragAndDropPage.getBoxAText();
        String boxBTextBefore = dragAndDropPage.getBoxBText();

        dragAndDropPage.dragAndDropAtoB();

        assertEquals(dragAndDropPage.getBoxAText(), boxBTextBefore, "Text didn't change after drag and " +
                "drop from A to B");
        assertEquals(dragAndDropPage.getBoxBText(), boxATextBefore, "Text didn't change after drag and " +
                "drop from A to B");
    }

    @Test
    public void validateDragAndDropBtoA() {
        String boxATextBefore = dragAndDropPage.getBoxAText();
        String boxBTextBefore = dragAndDropPage.getBoxBText();

        dragAndDropPage.dragAndDropBtoA();

        assertEquals(dragAndDropPage.getBoxAText(), boxBTextBefore, "Text didn't change after drag and " +
                "drop from B to A");
        assertEquals(dragAndDropPage.getBoxBText(), boxATextBefore, "Text didn't change after drag and " +
                "drop from B to A");
    }
}
