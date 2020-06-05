package selenium.uj.project;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test3 {

    private WebDriver wd;
    private String login = "kowalskiJan@gmail.com";


    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Piotr/Desktop/Drivers/DOBRY/chromedriver_win32/chromedriver.exe");

    }

    @Test
    public void logInLogOut() {

        Test1 Test3 = new Test1();
        wd = new ChromeDriver();
        wd.get(Test3.getUrl());
        wd.manage().window().maximize();
        wd.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        JavascriptExecutor js = (JavascriptExecutor)wd;
        js.executeScript("window.scrollTo(0,500)");

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement emailAddress = wd.findElement(By.xpath("//*[@id=\"email\"]"));
        emailAddress.clear();
        emailAddress.sendKeys(login);

        WebElement password = wd.findElement(By.xpath("//*[@id=\"passwd\"]"));
        password.click();
        password.clear();
        password.sendKeys(Test3.getUserPassword());

        wd.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();

        wd.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).click();

        wd.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")).click();

        wd.findElement(By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]")).click();

        WebElement size = wd.findElement(By.xpath("//*[@id=\"uniform-group_1\"]"));
        size.click();
        wd.findElement(By.xpath("//*[@id=\"group_1\"]/option[3]")).click();

        wd.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();

        wd.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")).click();

        wd.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();

        js.executeScript("window.scrollTo(0,800)");

        wd.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();

        js.executeScript("window.scrollTo(0,700)");

        wd.findElement(By.xpath("//*[@id=\"cgv\"]")).click();

        wd.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();

        wd.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();

        js.executeScript("window.scrollTo(0,800)");

        wd.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();

        wd.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();


    }


    @AfterClass
    public void teardown() {
    wd.quit();
    }


}
