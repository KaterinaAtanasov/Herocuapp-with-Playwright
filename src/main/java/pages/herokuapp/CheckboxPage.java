package pages.herokuapp;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.ElementHandle;

public class CheckboxPage extends BasePage {
    private static final String URL = "/checkboxes";
    private static final String PAGE_TITLE_SELECTOR = "h3";
    private static final String CHECKBOX_SELECTOR = "input[type='checkbox']";

    public CheckboxPage(Page page) {
        super(page);
        this.navigate(URL);
    }

    public void checkCheckbox(int index) {
        ElementHandle checkbox = page.querySelectorAll(CHECKBOX_SELECTOR).get(index);
        if(!checkbox.isChecked())
            checkbox.check();
    }

    public void uncheckCheckbox(int index) {
        ElementHandle checkbox = page.querySelectorAll(CHECKBOX_SELECTOR).get(index);
        if(checkbox.isChecked())
            checkbox.uncheck();
    }

    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }

    public boolean isCheckboxChecked(int index) {
        return page.querySelectorAll(CHECKBOX_SELECTOR).get(index).isChecked();
    }
}
