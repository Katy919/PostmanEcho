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

public class PostmanEchoNegativTest {
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
    void shouldSubmitNegativeReq() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("                 ");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79811234567");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", text.trim());
    }

    @Test
    void shouldSubmitNegativeReq3() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Kate Golubeva");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79811234567");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }

    @Test
    void shouldSubmitNegativeReq4() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("111111111111");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79811234567");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }

    @Test
    void shouldSubmitNegativeReq5() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("$#@@#%^^^");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79811234567");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='name'].input_invalid .input__sub")).getText();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", text.trim());
    }

    @Test
    void shouldSubmitNegativeReq6() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Екатерина Голубева");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("         ");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Поле обязательно для заполнения", text.trim());
    }

    @Test
    void shouldSubmitNegativeReq7() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Екатерина Голубева");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+7111111111111111111111");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }

    @Test
    void shouldSubmitNegativeReq8() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Екатерина Голубева");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("89117115611");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }

    @Test
    void shouldSubmitNegativeReq9() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Екатерина Голубева");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+7(911)711-56-11");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }

    @Test
    void shouldSubmitNegativeReq10() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Екатерина Голубева");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("%#$#$#%#%%");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }

    @Test
    void shouldSubmitNegativeReq11() {
        //   WebElement form = driver.findElement(By.cssSelector("[data-test-id='callback-form']"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Екатерина Голубева");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+7911");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String text = driver.findElement(By.cssSelector("[data-test-id='phone'].input_invalid .input__sub")).getText();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }
}
