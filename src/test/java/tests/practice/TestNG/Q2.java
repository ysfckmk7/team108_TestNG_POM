package tests.practice.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Q2 {


    @Test
    public void test01(){

        // https://www.youtube.com adresine gidin
        Driver.getDriver().get("https://www.youtube.com");
        // Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
        // titleTest => Sayfa başlığının “youTube” oldugunu test edin
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("youtube"));
        // imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement imageyoutube=Driver.getDriver().findElement(By.xpath("//yt-icon[@id='logo-icon']"));
        Assert.assertTrue(imageyoutube.isDisplayed());
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox=Driver.getDriver().findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
        // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(Driver.getDriver().getTitle().contains("youtube"));





    }
}
