package pages.herokuapp;
import com.herokuapp.playwright.Config;
import com.microsoft.playwright.Page;
public class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void navigate(String path) {
        page.navigate(Config.BASE_URL + path);
    }

    public String getTitle(){
        return page.title();
    }
}
