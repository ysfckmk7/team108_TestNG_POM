package tests.practice.JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q22 {
    WebDriver driver;

    @Test
    public void test01() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropdown);
        select.selectByIndex(1);


        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select=new Select(dropdown);
        select.selectByValue("2");
        System.out.println(dropdown.getText());

        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select=new Select(dropdown);
        select.selectByVisibleText("Option 1");

        //Tüm dropdown değerleri(value) yazdırın
        System.out.println(dropdown.getText());
        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

        List<WebElement> dropdownlist=driver.findElements(By.xpath("//option"));
        int dropBoyut=dropdownlist.size();
        System.out.println(dropBoyut);
        if (dropBoyut==4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }







    }
}
