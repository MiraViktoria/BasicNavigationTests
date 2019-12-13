package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    public static WebDriver getDriver(String browser){
        String sName=System.getProperty("s.name");
        System.out.println(sName);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }  else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.chromedriver().setup();
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            return null;
        }
        return null;
    }

}
