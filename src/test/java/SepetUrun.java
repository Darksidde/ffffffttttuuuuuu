import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.time.Duration;




public class SepetUrun {

    JavascriptExecutor js = (JavascriptExecutor) cdriver;
    static WebDriver cdriver;

    @BeforeClass
    public static void SetUp() {


        cdriver = new ChromeDriver();
        cdriver.manage().window().maximize();
        cdriver.get("https://www.amazon.com.tr/ref=nav_logo");
    }

    @AfterClass public static void tearDown() {

        if (cdriver != null) {
            cdriver.quit();


        }

    }


   @Test
    void test01() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(cdriver, Duration.ofSeconds(3));
        WebElement kullanici = cdriver.findElement(By.cssSelector("#nav-hamburger-menu"));
        kullanici.click();
        WebDriverWait asda = new WebDriverWait(cdriver, Duration.ofSeconds(3));


        WebElement element = cdriver.findElement(By.linkText("Çok Satanlar"));
        element.click();


        WebDriverWait da = new WebDriverWait(cdriver, Duration.ofSeconds(2));


        WebElement bilgisayar = cdriver.findElement(By.linkText("Bilgisayar"));
        bilgisayar.click();

        WebDriverWait dc = new WebDriverWait(cdriver, Duration.ofSeconds(2));


        WebElement XboxKol = cdriver.findElement(By.linkText("Xbox Wrls.(Gen9) Cntrllr Indas"));
        WebDriverWait grr = new WebDriverWait(cdriver, Duration.ofSeconds(1));
        WebElement Accept = cdriver.findElement(By.id("sp-cc-accept"));
        Accept.click();
        WebDriverWait ge = new WebDriverWait(cdriver, Duration.ofSeconds(1));
        XboxKol.click();

        WebDriverWait cdd = new WebDriverWait(cdriver, Duration.ofSeconds(2));

        WebElement selectElement = cdriver.findElement(By.id("quantity")); // veya diğer bir seçici ile
        Select select = new Select(selectElement);
        select.selectByIndex(1); // İndeks numarasına göre seçim yapabilirsin, 0'dan başlar


        WebDriverWait dg = new WebDriverWait(cdriver, Duration.ofSeconds(2));

        WebElement AddCart = cdriver.findElement(By.cssSelector("#add-to-cart-button"));
        AddCart.click();


    }





}
