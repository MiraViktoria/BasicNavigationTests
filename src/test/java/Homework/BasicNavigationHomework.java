package Homework;

import com.cbt.utilities.BrowserFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import java.util.List;


public class BasicNavigationHomework {


    public static void main(String[] args) throws InterruptedException {


/*
TestCase #1
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on "Sign Up For Mailing List"
Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on "Sign Up" button
Expected result: Following message should be displayed:
"Thank you for signing up. Click the button below to return to the
home page." Home button should be displayed.
 */


        WebDriver driver = BrowserFactory.getDriver("chrome");
//case1
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("full_name")).sendKeys("Mira");
        driver.findElement(By.name("email")).sendKeys("seraphine1226@gmail.com");
        driver.findElement(By.className("radius")).click();
        Thread.sleep(3000);
        WebElement sub_header = driver.findElement(By.tagName("h3"));
        System.out.println(sub_header.getText());

        driver.quit();

//case2
        driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/");

        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li"));
        String rows = "" + list.size();

        System.out.println("Number of listed examples is equals to "  + list.size());

        driver.quit();

//case3
        driver = BrowserFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Buttons")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]")).click();
        System.out.println("clicked on button 1");

        driver.quit();


//case4
        driver =BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/input"));
        WebElement record = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]"));
        System.out.println("first name can only consist of alphabetical letters");

  driver.quit();


//case5

        driver =BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/input"));
        WebElement message = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]"));
        System.out.println("The last name can only consist of alphabetical letters and dash");

        driver.quit();

  //case6
        driver =BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/input"));
        WebElement warning= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/small[2]"));
        System.out.println("The username must be more than 6 and less than 30 characters long");

        driver.quit();


//case7

        driver =BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/input"));
        WebElement notvalid= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[2]"));
        WebElement notvalid1 =driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[3]"));
        System.out.println("email address is not a valid\n" +
                "Email format is not correct");

        driver.quit();


        driver =BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/input"));
        WebElement number= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/small[2]"));

        System.out.println("Phone format is not correct");

        driver.quit();



    }

}






