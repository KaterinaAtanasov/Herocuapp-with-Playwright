package pages.herokuapp;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;

public class ContextMenuPage extends BasePage{

    private static final String URL = "/context_menu";
    private static final String PAGE_TITLE_SELECTOR = "h3";
    private static final String CONTEXT_MENU_SELECTOR = "#hot-spot";

    public ContextMenuPage(Page page){
        super(page);
        this.navigate(URL);
    }

    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }
    private void rightClick(String selector) {
        page.click(selector, new Page.ClickOptions().setButton(MouseButton.RIGHT));
    }
    private void waitForAlert(java.util.function.Consumer<String> alertHandler) {
        page.onceDialog(dialog -> {
            alertHandler.accept(dialog.message());
            dialog.accept();
        });
    }
    public String getJSAlertMessage() {
        final String[] alertMessage = new String[1];

        waitForAlert(message -> alertMessage[0] = message);
        rightClick(CONTEXT_MENU_SELECTOR);
        return alertMessage[0];
    }
    public boolean isJSAlertTriggered() {
        final boolean[] isPrompted = new boolean[1];
        isPrompted[0] = false;

        waitForAlert(message -> isPrompted[0] = true);
        rightClick(CONTEXT_MENU_SELECTOR);
        return isPrompted[0];
    }



}
