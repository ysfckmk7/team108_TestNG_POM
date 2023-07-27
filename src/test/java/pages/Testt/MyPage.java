package pages.Testt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyPage {
    public MyPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
        @FindBy (xpath ="//span[@class='usertext mr-1']")
        public WebElement loginverification;

    @FindBy (xpath = "(//a[@class='nav-item nav-link'])[5]")
    public WebElement egitimlerOnHeaders;

    @FindBy (xpath = "//*[text()='İlişkisel Pazarlama Eğitimi']")
    public WebElement freeEgitim;

    @FindBy (xpath = "//*[text()='Hemen Başla']")
    public WebElement egitimKayit;






}
