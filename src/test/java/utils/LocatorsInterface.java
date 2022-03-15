package utils;

import org.openqa.selenium.By;

public interface LocatorsInterface {
    String url_interface = "http://opencart.abstracta.us/index.php?route=common/home";
    By lSearchInput_interface = By.cssSelector("input[name='search']");
    By lSearchButton_interface = By.cssSelector("#search button");
}
