package pages.Testt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OnlineEgitimlerPage {
    public OnlineEgitimlerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//select[@class='border-0 focus:ring-0 py-2 pl-3 pr-10 bg-primary text-white text-sm rounded-lg']")
    public WebElement siralamaOptions;

}

