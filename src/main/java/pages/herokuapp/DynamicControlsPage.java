package pages.herokuapp;
import com.microsoft.playwright.Page;


public class DynamicControlsPage extends BasePage {

    private static final String URL = "/dynamic_controls";
    private static final String PAGE_TITLE_SELECTOR = "h4";
    private static final String CHECKBOX_EXAMPLE_HEADING_SELECTOR = "h4:nth-child(3)";
    private static final String INPUT_EXAMPLE_HEADING_SELECTOR = "h4:nth-child(8)";
    private static final String CHECKBOX_SELECTOR = "#checkbox-example input";
    private static final String CHECKBOX_BUTTON_SELECTOR = "#checkbox-example button";
    private static final String INPUT_SELECTOR = "#input-example input";
    private static final String INPUT_BUTTON_SELECTOR = "#input-example button";
    private static final String MESSAGE_CHECKBOX_TEXT_SELECTOR = "#checkbox-example #message";
    private static final String MESSAGE_INPUT_TEXT_SELECTOR = "#input-example #message";
    private static final String CHECKBOX_LOADER = "#checkbox-example #loading:nth-child(3)";
    private static final String INPUT_LOADER = "#checkbox-example #loading:nth-child(4)";

    public DynamicControlsPage(Page page) {
        super(page);
        this.navigate(URL);
    }

    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }

    public String getCheckboxExampleHeading() {
        return page.innerText(CHECKBOX_EXAMPLE_HEADING_SELECTOR);
    }

    public String getInputExampleHeading() {
        return page.innerText(INPUT_EXAMPLE_HEADING_SELECTOR);
    }

    public void clickCheckboxButton() {
        page.click(CHECKBOX_BUTTON_SELECTOR);
    }
    public boolean isCheckboxPresent() {
        return page.isHidden(CHECKBOX_SELECTOR);
    }

    public String getCheckboxButtonText() {
        return page.innerText(CHECKBOX_BUTTON_SELECTOR);
    }

    public String getCheckboxExampleLoader() {
        return CHECKBOX_LOADER;
    }
    public String getInputExampleLoader() {
        return INPUT_LOADER;
    }
    public boolean isInputEnabled() {
        return page.getAttribute(INPUT_SELECTOR, "disabled") == null;
    }

    public boolean isElementDisabled() {
        return page.getAttribute(INPUT_SELECTOR, "disabled") != null;
    }
    public void clickInputButton() {
        page.click(INPUT_BUTTON_SELECTOR);
    }

    public void waitForState(String selector, String state) {
        switch (state.toUpperCase()) {
            case "ATTACHED":
                page.waitForSelector(selector);
                break;
            case "DETACHED":
                page.waitForFunction("(element) => !element.isConnected", page.querySelector(selector));
                break;
            case "VISIBLE":
                while (!page.isVisible(selector)) {
                }
                break;
            case "HIDDEN":
                while (!page.isHidden(selector)) {
                }
                break;
            default:
                System.out.println("Invalid state");
                break;
        }
    }

    public String getInputButtonText() {
        return page.innerText(INPUT_BUTTON_SELECTOR);
    }

    public String getCheckboxMessageText() {
        return page.innerText(MESSAGE_CHECKBOX_TEXT_SELECTOR);
    }

    public String getInputMessageText() {
        return page.innerText(MESSAGE_INPUT_TEXT_SELECTOR);
    }

}
