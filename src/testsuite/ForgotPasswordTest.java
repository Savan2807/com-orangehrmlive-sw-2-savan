package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * 1. userShouldNavigateToForgotPasswordPageSuccessfully
 * <p>
 * <p>
 * click on the ‘Forgot your password’ link
 * Verify the text ‘Reset Password’
 */
public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {

        //forgetPassword elements
        WebElement ForgetPasswordField = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        ForgetPasswordField.click();

        //actualResult
        WebElement actualResult = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
        String actualMsg = actualResult.getText();

        //ExpectedResult
        String expectedMsg = "Reset Password";

        //match actual and expected result
        Assert.assertEquals("forget password ",  expectedMsg,actualMsg);
    }
}