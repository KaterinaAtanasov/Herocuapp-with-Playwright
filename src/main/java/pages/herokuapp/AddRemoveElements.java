package pages.herokuapp;
import com.herokuapp.playwright.Config;
import com.microsoft.playwright.Page;

public class AddRemoveElements extends BasePage{
    private static final String URL = Config.BASE_URL + "/add_remove_elements/";

    public AddRemoveElements(Page page){
        super(page);
    }

    public void navigate() {
        super.navigate(URL);
    }

    public void addElements(int number) {
        for (int i = 0; i < number; i++) {
            page.click("button:has-text('Add Element')");
        }
    }

    public void removeElements(int number) {
        for (int i = 0; i < number; i++) {
            page.click("button:has-text('Delete')");
        }
    }

    public int getNumberOfDeleteButtons() {
        return page.querySelectorAll("button:has-text('Delete')").size();
    }
}
