package pages.herokuapp;
import com.microsoft.playwright.Page;

public class AddRemoveElementsPage extends BasePage{
    private static final String URL = "/add_remove_elements/";
    private static final String ADD_BUTTON = "button:has-text('Add Element')";
    private static final String DELETE_BUTTON= "button:has-text('Delete')";

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
}
