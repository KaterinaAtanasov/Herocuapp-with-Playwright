package pages.herokuapp;

import com.microsoft.playwright.Page;

public class HoversPage extends BasePage{

    private static final String URL = "/hovers";
    private static final String PAGE_TITLE_SELECTOR = "h3";
    private static final String PAGE_SUBTITLE_SELECTOR = "p";
    private static final String FIGURE = ".figure";
    private static final String FIGCAPTION = ".figcaption";
    public HoversPage(Page page){
        super(page);
        this.navigate(URL);
    }
    public void hoverOnFigure(int figureNumber) {
        page.hover(".figure:nth-of-type(" + figureNumber + ")");
    }

    public String getHoverText(int figureNumber) {
        return page.innerText(".figure:nth-of-type(" + figureNumber + ") h5");
    }
    public String getProfileLinkText(int figureNumber) {
        return page.innerText(".figure:nth-of-type(" + figureNumber + ") a");
    }

    public String getTitle() {
        return page.innerText(PAGE_TITLE_SELECTOR);
    }

    public String getPageSubTitleText() {
        return page.innerText(PAGE_SUBTITLE_SELECTOR);
    }
}


