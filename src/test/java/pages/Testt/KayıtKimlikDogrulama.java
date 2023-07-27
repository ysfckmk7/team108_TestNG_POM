package pages.Testt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KayıtKimlikDogrulama {
    public KayıtKimlikDogrulama(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[@id='email']")
    public WebElement kayıtemail;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement odemeYap;

    @FindBy (xpath = "//div[@class='go06b0']")
    public WebElement kayitUcretsizYazisi;




}

