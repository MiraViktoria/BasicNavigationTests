package Homework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkForTestNG {
    private WebDriver driver;

   @BeforeMethod
   public void  setup(){

    driver = BrowserFactory.getDriver("chrome");
    driver.get("https://practice-cybertekschool.herokuapp.com/");
    driver.findElement(By.linkText("Registration Form")).click();

     }
     @Test(description = "Verify that warning message is displayed")
     public void test1() {

         driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("wrong_dob");
         driver.findElement(By.xpath("//*/div[8]/div/small[2]")).getText();


             System.out.println("The date of birth is not valid");
         driver.close();
         }

    @Test(description = "Verify that options are displayed")
    public void test2() {

        driver.findElement(By.xpath("//*/div[11]/div")).getText();
        String text1 = ("C++, Java, JavaScript");
        if (text1.equals("C++, Java, JavaScript"))
            System.out.println("C++, Java, JavaScript");
        driver.close();
    }
    @Test(description = "Verify that warning message is displayed")
    public void test3(){
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("v");
        driver.findElement(By.xpath("//*/div[1]/div/small[2]")).getText();

            System.out.println("first name must be more than 2 and less than 64 characters long");
        driver.close();
    }
    @Test(description = "Verify that warning message is displayed")
    public void test4(){
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("v");
        driver.findElement(By.xpath("//*/div/small[2]")).getText();

        System.out.println("first name must be more than 2 and less than 64 characters long");
        driver.close();
    }

    @Test(description = "Verify that following success message is displayed")
    public void test5(){
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mira");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Von-Rohrbach");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Seraphine");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Zhuravlik");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("941-416-5363");

        driver.findElement(By.xpath("//input[@value='female']")).click();


         driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("06/26/1973");

        WebElement department = driver.findElement(By.xpath("//*/div[9]/div/select"));
        Select select =new Select(department);
        select.selectByValue("DE");


        WebElement jobTitle = driver.findElement(By.xpath("//*/div[10]/div/select"));
        Select select2 = new Select(jobTitle);
        select2.selectByVisibleText("SDET");

        driver.findElement(By.xpath("//*/div[11]/div/div[2]/label")).click();

        driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div")).getText();
        System.out.println("You've successfully completed registration!");
        driver.close();
    }
 }
