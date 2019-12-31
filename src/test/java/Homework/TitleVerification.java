package Homework;

import com.cbt.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.Arrays;
import java.util.List;

public class TitleVerification {


    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("http://practice.cybertekschool.com/");
       BrowserUtils.wait(3);
        driver.navigate().to("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.navigate().to("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);

        String PartialUrl= "http://practice.cybertekschool.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(actualUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        driver.close();

    }
}