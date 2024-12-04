package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;
import dev.failsafe.internal.util.Assert;


public class TestCases {
    ChromeDriver driver;

    @Test
    public void testCase01() throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Boolean status ;
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));
        waits.until(ExpectedConditions.urlContains("forms"));
        Thread.sleep(5000);
        

        WebElement NameBar = driver.findElement(By.xpath("//*[@id=\'mG61Hd\']/div[2]/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div/div[1]/input"));
        NameBar.sendKeys("Crio Learner");
        Thread.sleep(2000);

        WebElement WhyAutomation = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
        long epochLong = System.currentTimeMillis();
        String epoch = String.valueOf(epochLong);
        WhyAutomation.sendKeys("I want to be the best QA Engineer!"+epoch);
        System.out.println("epoch is"+epoch);
        Thread.sleep(3000);


        WebElement radioBtn = driver.findElement(By.xpath("//*[@id=\'i22\']/div[3]/div"));
        radioBtn.click();
        System.out.println("Selected the Radio Button");
        Thread.sleep(2000);


        WebElement Javabtn = driver.findElement(By.xpath("//*[@id=\"i34\"]"));
        WebElement  seleniumbtn = driver.findElement(By.xpath("//*[@id=\"i37\"]/div[2]"));
        WebElement testngbtn = driver.findElement(By.xpath("//*[@id=\"i43\"]/div[2]"));
        Javabtn.click();
        seleniumbtn.click();
        testngbtn.click();
        Thread.sleep(2000);


        WebElement Address = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[1]/div[1]"));
        Address.click();
        WebElement MrBtn = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[5]/div/div/div[2]/div/div[2]/div[3]/span"));
        MrBtn.click();
        Thread.sleep(2000);


        WebElement calendarBtn = driver.findElement(By.xpath("//input[@type='date']"));
        LocalDateTime date = LocalDateTime.now();
        LocalDateTime updatedDated = date.minusDays(7);
        DateTimeFormatter formated = DateTimeFormatter.ofPattern("ddmmyyyy");
        String formattedDate = updatedDated.format(formated);

        calendarBtn.sendKeys(formattedDate);
        calendarBtn.click();
        Thread.sleep(3000);


        WebElement hours = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/input"));
        WebElement mins = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[2]/div[7]/div/div/div[2]/div/div[3]/div/div[1]/div/div[1]/input"));
        hours.sendKeys("07");
        mins.sendKeys("30");
        Thread.sleep(2000);


        WebElement SubmitBtn = driver.findElement(By.xpath("//*[@id=\"mG61Hd\"]/div[2]/div/div[3]/div[1]/div[1]/div/span"));
        SubmitBtn.click();
        Thread.sleep(4000);

        WebElement SucessNote = driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));
        String success = SucessNote.getText();
        System.out.println(success);
        Thread.sleep(1000);
    }

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}

