package com.cbt.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com/", "https://wayfair.com/", "https://walmart.com",
                "https://westelm.com/");

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

      for (String url: urls){
          driver.get(url);
          BrowserUtils.wait(3);
          if (url.contains(driver.getTitle().toLowerCase().replace(" ", ""))){

              System.out.println("passed " + url );
              System.out.println(driver.getTitle().toLowerCase().replace(" ", ""));

          }else{
              System.out.println("failed " + url);
              System.out.println(driver.getTitle().toLowerCase().replace(" ", ""));
          }
      }
           driver.close();
    }
}




