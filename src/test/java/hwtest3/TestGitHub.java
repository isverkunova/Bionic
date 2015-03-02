package hwtest3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class TestGitHub {

    public WebDriver driver;

    @BeforeSuite
    public void initEnv(){
        driver = new FirefoxDriver();
    }

    @Test
    public void TestGit(){

        driver.get("https://github.com");

        driver.findElement(By.cssSelector("a.button:nth-child(2)")).click();

        driver.findElement(By.id("login_field")).sendKeys("isverkunova");

        driver.findElement(By.id("password")).sendKeys("Gfhjkmitqkf_2014");

        driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[1]/a/span/span")).getText(), "isverkunova");
    }

    @AfterSuite
    public void closeIt(){
        driver.quit();
    }
}