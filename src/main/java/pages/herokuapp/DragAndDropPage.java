package pages.herokuapp;
import com.microsoft.playwright.Page;

public class DragAndDropPage extends BasePage{

        private static final String URL = "/drag_and_drop";
        private static final String BOX_A = "#column-a";
        private static final String BOX_B = "#column-b";
        private static final String PAGE_TITLE_SELECTOR = "h3";

        public DragAndDropPage(Page page) {
            super(page);
            this.navigate(URL);
        }

        public void dragAndDropAtoB(){
            page.dragAndDrop(BOX_A, BOX_B);
        }

        public void dragAndDropBtoA(){
            page.dragAndDrop(BOX_B, BOX_A);
        }

        public String getBoxAText() {
            return page.innerText(BOX_A);
        }

        public String getBoxBText() {
            return page.innerText(BOX_B);
        }

    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }
}

