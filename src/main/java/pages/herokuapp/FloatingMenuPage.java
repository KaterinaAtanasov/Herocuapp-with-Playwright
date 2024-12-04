package pages.herokuapp;

import com.microsoft.playwright.Page;

public class FloatingMenuPage extends BasePage {
    private static final String URL = "/floating_menu";
    private static final String PAGE_TITLE_SELECTOR = "h3";
    private static final String FLOATING_MENU_SELECTOR = "#menu";
    private static final String FOOTER_SELECTOR = "#page-footer";
    private static final String HOME_LINK_SELECTOR = "#menu a[href=\"#home\"]";
    private static final String NEWS_LINK_SELECTOR = "#menu a[href=\"#news\"]";
    private static final String CONTACT_LINK_SELECTOR = "#menu a[href=\"#contact\"]";
    private static final String ABOUT_LINK_SELECTOR = "#menu a[href=\"#about\"]";

    public FloatingMenuPage(Page page) {
        super(page);
        this.navigate(URL);
    }
    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }

    public void scrollIntoViewIfNeeded() {
        page.evalOnSelector(FOOTER_SELECTOR, "element => element.scrollIntoViewIfNeeded()");
    }

    public boolean isFloatingMenuVisible() {
        return page.isVisible(FLOATING_MENU_SELECTOR);
    }

    public boolean isFooterVisible() {
        return page.isVisible(FOOTER_SELECTOR);
    }

    public void clickHomeLink() {
        page.click(HOME_LINK_SELECTOR);
    }

    public void clickNewsLink() {
        page.click(NEWS_LINK_SELECTOR);
    }

    public void clickContactLink() {
        page.click(CONTACT_LINK_SELECTOR);
    }

    public void clickAboutLink() {
        page.click(ABOUT_LINK_SELECTOR);
    }

    public String getHomeUrl() {
        return "#home";
    }

    public String getNewsUrl() {
        return "#news";
    }

    public String getContactUrl() {
        return "#contact";
    }

    public String getAboutUrl() {
        return "#about";
    }
}
