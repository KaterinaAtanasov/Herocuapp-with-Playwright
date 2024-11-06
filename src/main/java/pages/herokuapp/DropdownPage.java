package pages.herokuapp;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class DropdownPage extends BasePage {
    private static final String URL = "/dropdown";
    private static final String DROPDOWN_SELECTOR = "#dropdown";
    private static final String DEFAULT_OPTION = "Please select an option";
    private static final String OPTION_ONE = "Option 1";
    private static final String OPTION_TWO = "Option 2";
    private static final String PAGE_TITLE_SELECTOR = "h3";

    public DropdownPage(Page page) {
        super(page);
        this.navigate(URL);
    }

    public void selectOption(String value) {
        page.selectOption(DROPDOWN_SELECTOR, new SelectOption().setValue(value));
    }

    public String getSelectedOptionValue() {
        return page.getAttribute(DROPDOWN_SELECTOR + " option[selected]", "value");
    }

    public String getSelectedOptionText() {
        return (String) page.evaluate("(dropdown) => dropdown.options[dropdown.selectedIndex].innerText",
                page.querySelector(DROPDOWN_SELECTOR));
    }

    public String getDefaultOption() {
        return DEFAULT_OPTION;
    }

    public String getOptionOne() {
        return OPTION_ONE;
    }

    public String getOptionTwo() {
        return OPTION_TWO;
    }
    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }
}
