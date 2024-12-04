package pages.herokuapp;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;

public class ExitIntentPage extends BasePage{

    private static final String URL = "/exit_intent";
    private static final String PAGE_TITLE_SELECTOR = "h3";
    private static final String POPUP_SELECTOR = "#ouibounce-modal";
    private static final String POPUP_CLOSE_SELECTOR = ".modal-footer > p";
    private static final String POPUP_TITLE_SELECTOR = "#ouibounce-modal h3";

    public ExitIntentPage(Page page) {
        super(page);
        this.navigate(URL);
    }

    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }

    public boolean isPopupVisible() {
            return page.isVisible(POPUP_SELECTOR);
    }
    public void triggerExitIntent() {
        page.dispatchEvent("html", "mouseleave");
    }

    public void closePopup() {
        ElementHandle closeButton = page.querySelector(POPUP_CLOSE_SELECTOR);
        closeButton.click();
    }

    public String getPopupTitle() {
        return page.querySelector(POPUP_TITLE_SELECTOR).innerText();
    }
}
