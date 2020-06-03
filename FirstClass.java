package selenium.uj.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstClass

{
    private WebDriver driver;

    @BeforeClass
    public void setup()
    {
        //zdefiniowanie scieżki dla zewnętrznego drivera przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver", "C:/Users/Piotr/Desktop/Drivers/chromedriver_win32/chromedriver.exe");

        driver = new ChromeDriver(); // utworzenie obiektu i inicjalizacja
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //ustawienie czasu oczekiwania na elementy
        driver.manage().window().maximize();// maksymalizacja okna

        driver.get("https://testerzy.pl/");
    }
    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
    @Test
    public void test1()
    {
        Assert.assertEquals(driver.getTitle(),"testerzy.pl - Lepsza jakość testowania");
    }
    @Test
    public void test2()
    {
        driver.findElement(By.xpath("//html/body/nav/div/ul[1]/li[1]/a")).click();
        Assert.assertEquals(driver.getTitle(),"testerzy.pl - Lepsza jakość testowania");
    }
    @Test
    public void test3()
    {
        //Uzupełnij formulaż
        //-temat
        //Imie i Nazwisko
        //-email
        //-telefon
        //-wiadomosc
        //-zgoda

        //Klikam wyslij
        //-przycisk wyślij

        //Sprawdzam czy wysłano
        // nieprwawidłowy kod
    }

}


