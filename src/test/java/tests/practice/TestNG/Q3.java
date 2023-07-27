package tests.practice.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Q3 {

    @Test
    public void test01(){

        //https://www.amazon.com/ adresine gidin.
        Driver.getDriver().get("https://www.amazon.com/");
        //Test : Amazon ana sayfaya gittiginizi test edin
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("amazon"));
        //Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapi ve aramanizin gerceklestigini Test edin
        WebElement aramaKutusu=Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramasonuclari=Driver.getDriver().findElement(By.xpath("//div[@class='sg-col-inner']"));
        Assert.assertTrue(aramasonuclari.getText().contains("Nutella"));
        //Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin 35.3 oldugunu test edin
        WebElement ilkurun=Driver.getDriver().findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        ilkurun.click();
        WebElement ilkurunFiyati=Driver.getDriver().findElement(By.xpath("//span[@id='productTitle']"));
        String uruntext=ilkurunFiyati.getText();
        uruntext=uruntext.replaceAll("\\D","");
        int urunInt=Integer.parseInt(uruntext);
        System.out.println(urunInt);
        Assert.assertTrue(urunInt==353);








    }
}
