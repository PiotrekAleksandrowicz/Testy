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

public class Test2 {

    private WebDriver wd;
    private String login = "kowalskiJan@gmail.com";


    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Piotr/Desktop/Drivers/DOBRY/chromedriver_win32/chromedriver.exe");

    }

    @Test
    public void logInLogOut() {

        Test1 Test2 = new Test1();
        wd = new ChromeDriver();
        wd.get(Test2.getUrl());
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
        password.sendKeys(Test2.getUserPassword());

        wd.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();

        wd.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    //@AfterClass
    //public void teardown() {
    //wd.quit();
    //}


}
