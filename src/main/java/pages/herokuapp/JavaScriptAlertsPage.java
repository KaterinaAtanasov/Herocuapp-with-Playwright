package pages.herokuapp;

import com.microsoft.playwright.Page;

public class JavaScriptAlertsPage extends BasePage{
    private static final String URL = "/javascript_alerts";
    private static final String PAGE_TITLE_SELECTOR = "h3";
    private static final String JS_ALERT_BUTTON = "//button[text()='Click for JS Alert']";
    private static final String JS_CONFIRM_BUTTON = "//button[text()='Click for JS Confirm']";
    private static final String JS_PROMPT_BUTTON = "//button[text()='Click for JS Prompt']";
    private static final String RESULT = "#result";
    private String lastDialogMessage;

    public JavaScriptAlertsPage(Page page){
        super(page);
        this.navigate(URL);
    }
    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }

    public void clickJsAlertButton(){
       page.click(JS_ALERT_BUTTON);
    }
    public void clickJsConfirmButton(){
        page.click(JS_CONFIRM_BUTTON);
    }
    public void clickJsPromptButton(){
        page.click(JS_PROMPT_BUTTON);
    }
    public String getResultText(){
       return page.innerText(RESULT);
    }
    public void acceptDialog() {
        page.onceDialog(dialog -> {
            lastDialogMessage = dialog.message();
            String dialogType = dialog.type();
            if ("confirm".equals(dialogType) || "alert".equals(dialogType)) {
                dialog.accept();
            }
        });
    }

    public void dismissDialog() {
        page.onceDialog(dialog -> {
            lastDialogMessage = dialog.message();
            String dialogType = dialog.type();
            if ("confirm".equals(dialogType) || "prompt".equals(dialogType)) {
                dialog.dismiss();
            }
        });
    }


    public void acceptPromptDialog(String text) {
        page.onceDialog(dialog -> {
            lastDialogMessage = dialog.message();
            if ("prompt".equals(dialog.type())) {
                dialog.accept(text);
            }
        });
    }

    public String getLastDialogMessage() {
        return lastDialogMessage;
    }
}
