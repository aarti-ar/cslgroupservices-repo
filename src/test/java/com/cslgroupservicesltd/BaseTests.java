package com.cslgroupservicesltd;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    WebDriver driver;


    public BaseTests(WebDriver driver){
        this.driver=driver;
    }

    public static void main(String []args) throws InterruptedException {


        System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        WebDriver driver=new FirefoxDriver();

        driver.get("https://cslgroupservices.co.uk/");  //Open URL in browser
        driver.manage().window().maximize();    //it will maximize the window
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);  //will wait for 5 seconds
        driver.manage().deleteAllCookies(); //will delete all cookies

            By aboutUsLink = By.xpath("//ul[@id='top-menu']//a[normalize-space()='ABOUT US']");//This will click on AboutUs link and will getTitle of AboutUs page
            Thread.sleep(5);
            driver.findElement(aboutUsLink).click();


            //driver.findElement(By.xpath("//ul[@id='top-menu']//a[normalize-space()='HOME']")).click();//click on Home button

            //validation
            //String exp_title="Home | CSL Group Services Ltd";//This title is for home page
            String exp_title = "About us | CSL Group Services Ltd";//this title is for AboutUs page
            String actual_title = driver.getTitle();
            System.out.println(actual_title);

            if (exp_title.equals(actual_title) == true) {
                System.out.println("Test is passed");
            } else {
                System.out.println("Test is failed");
            }

            //driver.close();
        }





}
