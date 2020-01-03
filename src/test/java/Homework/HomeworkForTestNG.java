package Homework;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkForTestNG {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {

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
    public void test3() {
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("v");
        driver.findElement(By.xpath("//*/div[1]/div/small[2]")).getText();

        System.out.println("first name must be more than 2 and less than 64 characters long");
        driver.close();
    }

    @Test(description = "Verify that warning message is displayed")
    public void test4() {
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("v");
        driver.findElement(By.xpath("//*/div/small[2]")).getText();

        System.out.println("first name must be more than 2 and less than 64 characters long");
        driver.close();
    }

    @Test(description = "Verify that following success message is displayed")
    public void test5() {
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mira");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Von-Rohrbach");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Seraphine");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Zhuravlik");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("941-416-5363");

        driver.findElement(By.xpath("//input[@value='female']")).click();


        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("06/26/1973");

        WebElement department = driver.findElement(By.xpath("//*/div[9]/div/select"));
        Select select = new Select(department);
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

    @Test
    public void test6() {
        driver.get("https://www.tempmailaddress.com/");
        driver.findElement(By.xpath("//*[@id=\"home\"]/div/div[3]/ul/li[1]/a")).click();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*/ul/li[43]/a")).click();
        driver.findElement(By.xpath("//*/div[1]/div/input")).sendKeys("Mira Rohrbach");
        driver.findElement(By.xpath("//*/div[2]/div/input")).sendKeys("cardin.advit@opka.org");
        driver.findElement(By.xpath("//*/button")).click();
        driver.findElement(By.xpath("//*/div/h3")).getText();
        driver.navigate().to("https://www.tempmailaddress.com/");
        driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]")).click();

        WebElement display = driver.findElement(By.xpath("//*[@id=\"odesilatel\"]"));
        System.out.println(display.getText());

        WebElement dispay2 = driver.findElement(By.xpath("//*[@id=\"predmet\"]"));
        System.out.println(dispay2.getText());
        driver.close();

    }
    @Test
    public void test7()throws Exception{
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();

       driver.findElement(By.xpath("//*[@id='file-submit']")).click();
       System.out.println("File Uploaded!");


        driver.close();

    }
    @Test
    public void test8(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.xpath("//*[@id=\"myCountry\"]")).sendKeys("United States of America");
        driver.findElement(By.xpath("//*/div/form/input")).click();
        WebElement displayedMessage = driver.findElement(By.xpath("//*[@id=\"result\"]"));
        System.out.println(displayedMessage.getText());

        driver.close();

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    }


