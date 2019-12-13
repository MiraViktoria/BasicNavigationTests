package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static com.cbt.utilities.StringUtility.verifyEquals;

public class TitleVerification {

    public static void main(String[] args) {
       List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
               "http://practice.cybertekschool.com/dropdown",
               "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String practiceTitle=driver.getTitle();
        driver.get("http://practice.cybertekschool.com/dropdown");
        String practiceDropdown=driver.getTitle();
        driver.get("http://practice.cybertekschool.com/login");
        String practiceLogin=driver.getTitle();


        verifyEquals(practiceTitle, driver.getTitle());
        driver.navigate().forward();
        verifyEquals(practiceDropdown,driver.getTitle());
        verifyEquals(practiceLogin,driver.getTitle());
        driver.close();
    }
}
