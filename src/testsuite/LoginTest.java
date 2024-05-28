package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * <p>
 * Enter “Admin” username
 * Enter “admin123 password
 * Click on ‘LOGIN’ button
 * Verify the ‘Dashboard’ text is display
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //username elements
        WebElement UsernameField =driver.findElement(By.name("username"));
        UsernameField.sendKeys("Admin");

        //password elements
        WebElement PasswordField = driver.findElement(By.name("password"));
        PasswordField.sendKeys("admin123");

        //login elements
        WebElement LoginField = driver.findElement(By.xpath("//button[@type='submit']"));
        LoginField.click();

        //actual elements
        WebElement actualResult = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualMsg = actualResult.getText();

        //expected result
        String expectedMsg = "Dashboard";

        //actual and expected result
        Assert.assertEquals("not able to login", expectedMsg,actualMsg);
    }

    @After
    //Here After method for close the browser
    public void tearDown() {
        closeBrowser();

    }
}