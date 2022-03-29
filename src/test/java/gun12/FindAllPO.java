package gun12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindAllPO {

    public FindAllPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='search']")
    private WebElement searchText;

    @FindBy(css = "#search button")
    private WebElement searchButton;

    @FindBy(css = ".caption h4")
    private List<WebElement> products;

    @FindBy(css = "ul.breadcrumb")
    private WebElement siteMap;

    @FindAll({
            @FindBy(css = "#content h1"),
            @FindBy(css = ".caption h4"),
            @FindBy(css = "div.caption p.price")
    })
    private List<WebElement> isimveFiyat;

    @FindBys({
            @FindBy(xpath = "(//div[@class='product-thumb'])[2]"),  // Parent selector
            @FindBy(css = "h4")                                     // child selector
    })
    WebElement findBys;

    public WebElement getSearchText() {
        return searchText;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getSiteMap() {
        return siteMap;
    }

    public List<WebElement> getIsimveFiyat() {
        return isimveFiyat;
    }

    public WebElement getFindBys() {
        return findBys;
    }
}
