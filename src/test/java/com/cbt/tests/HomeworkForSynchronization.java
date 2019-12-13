package com.cbt.tests;

import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.Driver;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HomeworkForSynchronization {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.name("_username")).sendKeys("storemanager85");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.name("_submit")).click();

    }

    @Test(description = "Verify that page subtitle 'Options' is displayed")
    public void test1() {
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//*[normalize-space()='Activities' and @class='title title-level-1']")).click();
        driver.findElement(By.xpath("//*[normalize-space()='Calendar Events' and @class='title title-level-2']")).click();
        BrowserUtils.wait(5);
        WebElement options = driver.findElement(By.xpath("//div[@href='#']"));
        String text = driver.findElement(By.xpath("//div[@href='#']")).getText();
        if (options.isDisplayed()) {
            System.out.println("Passed " + text + " is displayed!");
        } else {
            System.out.println("Failed");
        }
    }

    @Test(description = "Verify that page subtitle 'Options' is displayed")
    public void test2() {
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//*[normalize-space()='Activities' and @class='title title-level-1']")).click();
        driver.findElement(By.xpath("//*[normalize-space()='Calendar Events' and @class='title title-level-2']")).click();
        BrowserUtils.wait(5);
        String expectedResult = "1";
        String actualResult = driver.findElement(By.xpath("//input[@value= \"1\"]")).getAttribute("value");
        StringUtility.verifyEquals(expectedResult, actualResult);
    }

    @Test(description = "Verify that page subtitle 'Options' is displayed")
    public void test3() {
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//*[normalize-space()='Activities' and @class='title title-level-1']")).click();
        driver.findElement(By.xpath("//*[normalize-space()='Calendar Events' and @class='title title-level-2']")).click();
        BrowserUtils.wait(5);
        String expectedResult = "25";
        String actualResult = driver.findElement(By.xpath("//button[contains(text(),\"25\"]")).getText();
        StringUtility.verifyEquals(expectedResult, actualResult);
        Assert.assertEquals(expectedResult, actualResult);
        // or this metod
        //StringUtility.verifyEquals(expectedResult, actualResult);
    }


    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4() {
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//*[normalize-space()='Activities' and @class='title title-level-1']")).click();
        driver.findElement(By.xpath("//*[normalize-space()='Calendar Events' and @class='title title-level-2']")).click();
        BrowserUtils.wait(3);
        List<WebElement> list = driver.findElements(By.xpath("//table[@class=\"grid table-hover table table-bordered table-condensed\"]/tbody/tr"));
        String rows = "" + list.size();   //24
        String records = driver.findElement(By.xpath("//label[text()=\"Total of 24 records\"]")).getText(); //
        if (records.contains(rows)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }

    @Test(description = "Verify that all calendar events were selected")
    public void test5() {
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//*[normalize-space()='Activities' and @class='title title-level-1']")).click();
        driver.findElement(By.xpath("//*[normalize-space()='Calendar Events' and @class='title title-level-2']")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//div[@class=\"btn-group dropdown\"]/button/input")).click();
        BrowserUtils.wait(1);
        List<WebElement> checkboxes = driver.findElements(By.xpath("//td[@data-column-label=\"Selected Rows\"]/input"));
        //div[@class="]/row-fluid form-horizontal
    }

    @Test(description = "Verify that following data is displayed:")
    public void test6(){
        BrowserUtils.wait(5);
        driver.findElement(By.xpath("//*[normalize-space()='Activities' and @class='title title-level-1']")).click();
        driver.findElement(By.xpath("//*[normalize-space()='Calendar Events' and @class='title title-level-2']")).click();
        BrowserUtils.wait(5);
        driver.findElement(By.cssSelector("[class='grid-row row-click-action']:nth-of-type(15)")).click();
        BrowserUtils.wait(2);
        List<WebElement> labels = driver.findElements(By.xpath("//label[@class=\"control-label\"]"));
        List<WebElement> divs = driver.findElements(By.xpath("//div[@class=\"control-label\"]"));
        divs.add(driver.findElement(By.xpath("//p[text()=\"This is a a weekly testers meeting\"]")));
        // BrowserUtils.wait(10);
        for(WebElement label: labels){
            if(label.isDisplayed()){
                System.out.println("Passed "+ label.getText());
            }
        }
        for (WebElement div: divs){
            if(div.isDisplayed()){
                System.out.println("Passed "+div.getText());
            }
        }
    }

        @AfterMethod
        public void teardown () {
            driver.quit();
        }
    }




