package pages.herokuapp;
import com.microsoft.playwright.Page;

public class AddRemoveElementsPage extends BasePage {
    private static final String URL = "/add_remove_elements/";
    private static final String ADD_BUTTON = "button:has-text('Add Element')";
    private static final String DELETE_BUTTON = "button:has-text('Delete')";
    private static final String PAGE_TITLE_SELECTOR = "h3";

    public AddRemoveElementsPage(Page page) {
        super(page);
        this.navigate(URL);
    }

    public void addElements(int number) {
        for (int i = 0; i < number; i++) {
            page.click(ADD_BUTTON);
        }
    }

    public void removeElements(int number) {
        for (int i = 0; i < number; i++) {
            page.click(DELETE_BUTTON);
        }
    }

    public int getNumberOfDeleteButtons() {
        return page.querySelectorAll(DELETE_BUTTON).size();
    }

    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }
}
