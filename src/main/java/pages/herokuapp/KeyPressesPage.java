package pages.herokuapp;

import com.microsoft.playwright.Page;

public class KeyPressesPage extends BasePage {

    private static final String URL = "/key_presses";
    private static final String RESULT = "#result";
    private static final String PAGE_TITLE_SELECTOR = "h3";
    private static final String PAGE_SUBTITLE_SELECTOR = "p";

    public KeyPressesPage(Page page) {
        super(page);
        this.navigate(URL);
    }

    public void pressKey(String key){
        page.press("body", key);
    }

    public String getPressedKeyResult() {
        return page.innerText(RESULT);
    }

    public String getTitle() {
        return page.innerText("h3");
    }

    public String getPageSubTitleText() {
        return page.innerText("p");
    }
}
