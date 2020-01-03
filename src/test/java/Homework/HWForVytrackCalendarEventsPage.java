package Homework;
import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HWForVytrackCalendarEventsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        //explicit wait
        wait = new WebDriverWait(driver, 10);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize browser
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        WebElement loaderMask = null;

        if (driver.findElements(By.cssSelector("div[class='loader-mask shown']")).size() > 0) {
            loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        }

        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        activitiesElement.click();

        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();

        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }


    @Test(description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1() {
        WebElement dots = driver.findElement(By.xpath("//*/div[2]/div[2]/div[2]/div/table/tbody/tr[19]/td[9]/div/div/a"));
        System.out.println(dots.getText());
       WebElement option1 = driver.findElement(By.cssSelector("a[href$='/view/283']"));
        System.out.println(option1.getText());
      // WebElement option2 = driver.findElement(By.xpath("a[href$='/view/283']"));
       // System.out.println(option2.getText());

         BrowserUtils.wait(2);
        driver.close();
    }

    @Test(description = "Verify that “Title” column still displayed")
    public void test2() {
     driver.findElement(By.cssSelector("[title='Grid Settings']")).click();
     driver.findElement(By.cssSelector(".ui-sortable>tr+tr>td+td+td")).click();
     driver.findElement(By.cssSelector(".ui-sortable>tr+*+tr>td+td+td")).click();
     driver.findElement(By.cssSelector(".ui-sortable>tr+*+tr+tr>td+td+td")).click();
     driver.findElement(By.cssSelector(".ui-sortable>tr+tr+*+tr+tr>td+td+td")).click();
     driver.findElement(By.cssSelector(".ui-sortable>tr+tr+*+tr+tr+tr>td+td+td")).click();

     WebElement Title = driver.findElement(By.cssSelector("a>[class='grid-header-cell__label']"));
        System.out.println(Title.getText());
        if (Title.isDisplayed()){
            System.out.println("Title column still displayed");

        }else {
            System.out.println("Failed");
        }
        driver.close();
 }

      @Test(description = "Verify that “Save And Close”, “Save And New” and “Save” options are available")
      public void test3() {
        driver.findElement(By.cssSelector("div>a[href='/calendar/event/create']")).click();

      WebElement SaveAndClose = driver.findElement(By.cssSelector("div>button[class='btn btn-success action-button']"));
      BrowserUtils.wait(3);
      System.out.println(SaveAndClose.getText());

      WebElement SaveAndNew = driver.findElement(By.cssSelector("div[class='btn-group']+div"));
      driver.manage().window().maximize();
      BrowserUtils.wait(3);
      System.out.println(SaveAndNew.getText());

      WebElement Save = driver.findElement(By.cssSelector("div[class='btn-group']+div+div"));
      BrowserUtils.wait(3);
      System.out.println(Save.getText());
      driver.close();

   }
      @Test(description = "Verify that “All Calendar Events” page subtitle is displayed")
      public void test4(){
          driver.findElement(By.cssSelector("div>a[href='/calendar/event/create']")).click();
          BrowserUtils.wait(3);
          driver.findElement(By.cssSelector("div[class='btn-group']+div+div+div")).click();
          BrowserUtils.wait(3);
          WebElement Displayed = driver.findElement(By.cssSelector("div>a[href='/calendar/event/create']"));
          BrowserUtils.wait(3);
          System.out.println(Displayed.getText());
          driver.close();

      }
         @Test(description = "Verify that difference between end and start time is exactly 1 hour")
         public void Test5(){
             driver.findElement(By.cssSelector("div>a[href='/calendar/event/create']")).click();
             BrowserUtils.wait(3);


         }





    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
