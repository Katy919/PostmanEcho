package ru.netology.rest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostmanEchoTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

        driver.get("http://localhost:9999");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldSubmitReq() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Екатерина Голубева");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79811234567");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @Test
    void shouldSubmitReq2() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Екатерина-Ольга Голубева");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79811234567");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @Test
    void shouldSubmitReq3() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Василий Ильин");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79811234567");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
        assertEquals("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @Test
    void shouldSubmitReq4() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Алёна Ильина");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79811234567");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }
}

