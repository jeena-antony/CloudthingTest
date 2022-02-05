package com.example.cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CloudthingSteps {
    WebDriver driver;


    public CloudthingSteps() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/10/Programs/Webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Given("cloudthing page is open")
    public void cloudthingPageIsOpen() throws InterruptedException {
        driver.get("https://www.cloudthing.com");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        Assert.assertTrue(driver.getTitle().contains("CloudThing"));
    }

    @And("open careers menu")
    public void openCareersMenu() throws InterruptedException {
        System.out.println("open career");
        WebElement about = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/ul/li[5]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(about).moveToElement(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/ul/li[5]/div/ul/li[1]/a"))).click().build().perform();
        Assert.assertTrue(driver.getTitle().contains("Careers"));
    }

    @And("find {string} and enter {string},{string},{string},{string} and {string}")
    public void findAndEnterAnd(String section, String name, String email, String phone, String message, String cv) throws InterruptedException {
        System.out.println("find and enter data");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement post = driver.findElement(By.xpath("//*[contains(text(),\"" + section + "\")]"));
        System.out.println("//*[contains(text(),\"" + section + " - LEARN MORE\")]");
        if (post.isDisplayed()) {
            post.click();
        } else {
           System.out.println(post.getText());
           js.executeScript("arguments[0].click();",post);
   //         driver.get("https://cloudthing.com/careers/senior-performance-test-engineer/");
        }
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f500-o1\"]/form/div[2]/div[1]/span/input")).sendKeys(name);
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f500-o1\"]/form/div[2]/div[2]/span/input")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f500-o1\"]/form/div[2]/div[3]/span/input")).sendKeys(phone);
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f500-o1\"]/form/div[2]/div[4]/span/textarea")).sendKeys(message);
        driver.findElement(By.xpath("//*[@id=\"wpcf7-f500-o1\"]/form/div[2]/div[4]/p[2]/span/input")).sendKeys(cv);
        WebDriverWait wait=new WebDriverWait(driver,30);
       WebElement send_button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"contactformcareers\"]")));

        Thread.sleep(3000);
        if(send_button.isEnabled())
            send_button.click();
        Thread.sleep(10000);
        Assert.assertTrue(driver.getPageSource().contains("Thank you for your message. It has been sent."));

    }

    @Then("close browser")
    public void closeBrowser() {
        driver.quit();
    }


}

