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

public class Test1 {

    Random random = new Random();
    int liczba = random.nextInt(500)+250;

    private WebDriver wd;
    private String url = "http://automationpractice.com/index.php";
    private String userLogin = "kowalskiJan"+liczba+"@gmail.com" ;
    private String userPassword = "Jan123";
    private String name;
    private String surname;
    private int time;
    private String adres;
    private String miasto;
    private String postcode;
    private String mobile;



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chrome.driver",
                "C:/Users/Piotr/Desktop/Drivers/DOBRY/chromedriver_win32/chromedriver.exe");

        wd = new ChromeDriver();
        name = "Jan";
        surname = "Kowalski";
        time = 5;
        adres ="Zabiniec";
        miasto = "Miami";
        postcode = "66666";
        mobile = "666 666 666";
    }

    @Test
    public void createAccount(){
        wd.get(url);
        wd.manage().window().maximize();
        wd.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        JavascriptExecutor js = (JavascriptExecutor)wd;
        js.executeScript("window.scrollTo(0,500)");

        WebElement emailAddress = wd.findElement(By.xpath("//*[@id=\"email_create\"]"));
        emailAddress.clear();
        emailAddress.sendKeys(userLogin);

        wd.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        wd.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();


        WebElement firstName = wd.findElement(By.xpath("//*[@id='customer_firstname']"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys(name);

        WebElement lastName = wd.findElement(By.xpath("//*[@id=\"customer_lastname\"]"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys(surname);

        WebElement password = wd.findElement(By.xpath("//*[@id=\"passwd\"]"));
        password.click();
        password.clear();
        password.sendKeys(userPassword);

        //WebElement day = wd.findElement(By.xpath("//*[@id=\"days\"]"));
        //day.click();
        //wd.findElement(By.xpath("//*[@id=\"days\"]/option[4]")).click();

        WebElement address = wd.findElement(By.xpath("//*[@id=\"address1\"]"));
        address.click();
        address.clear();
        address.sendKeys(adres);

        WebElement city = wd.findElement(By.xpath("//*[@id=\"city\"]"));
        city.click();
        city.clear();
        city.sendKeys(miasto);

        Select state = new Select(wd.findElement(By.xpath("//*[@id=\"id_state\"]")));
        state.selectByVisibleText("Florida");

        WebElement postCode = wd.findElement(By.xpath("//*[@id=\"postcode\"]"));
        postCode.click();
        postCode.clear();
        postCode.sendKeys(postcode);

        WebElement mobileNumber = wd.findElement(By.xpath("//*[@id=\"phone_mobile\"]"));
        mobileNumber.click();
        mobileNumber.clear();
        mobileNumber.sendKeys(mobile);

        WebElement assign = wd.findElement(By.xpath("//*[@id=\"alias\"]"));
        assign.click();
        assign.clear();
        assign.sendKeys(adres);

        wd.findElement(By.xpath("//*[@id=\"submitAccount\"]")).click();

    }

    @AfterClass
    public void teardown() {
        wd.quit();
    }

}