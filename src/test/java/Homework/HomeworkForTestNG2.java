package Homework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkForTestNG2 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();


    }

    @Test
    public void test9() {
        driver.findElement(By.xpath("//*/div/ul/li[1]/a")).click();
        driver.findElement(By.tagName("p")).getText();
        System.out.println("This page returned a 200 status code.");
        driver.close();
    }
    @Test
    public void test10() {
        driver.findElement(By.xpath("//*/div/ul/li[2]/a")).click();
        driver.findElement(By.tagName("p")).getText();
        System.out.println("This page returned a 301 status code.");
        driver.close();

    }
    @Test
    public void test11() {
        driver.findElement(By.xpath("//*/div/ul/li[3]/a")).click();
        driver.findElement(By.tagName("p")).getText();
        System.out.println("This page returned a 404 status code.");
        driver.close();
       }
       @Test
    public void test12() {
        driver.findElement(By.xpath("//*/div/ul/li[4]/a")).click();
           driver.findElement(By.tagName("p")).getText();
        System.out.println("This page returned a 500 status code.");
        driver.close();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}


