package ua.ithillel.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ua.ithillel.ui.browser.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.testng.Assert.assertEquals;

public class BeseUITest {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeTest
    public void start(){
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    @Test
    public void test(){
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElements(By.name("btnK")).get(1).click();
        Assert.assertEquals(driver.getTitle(),"webdriver - Пошук Google");

    }
    @AfterTest
    public void stop(){
        driver.close();
        driver.quit();

    }
}
