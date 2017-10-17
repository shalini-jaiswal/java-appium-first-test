package apptest;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.boon.core.Sys;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class iOSAppTest {

    IOSDriver driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    String testName = "Testing iOS App with Java";
    //String accessKey = System.getenv("SEETEST_IO_ACCESS_KEY");
    String accessKey = "eyJ4cC51IjoxNjUwLCJ4cC5wIjoxNDM1LCJ4cC5tIjoiTVRRNU5UQXhOelV3T0RreE1BIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjE4MTY0MzI4MDcsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.JBVpm1JBc8AEHSJm3nY8qv-7Orx0MfSN6D9BsxmfcSA";

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("testName", testName);
        dc.setCapability("accessKey", accessKey);
        //install the app on the device
        dc.setCapability(MobileCapabilityType.APP, "http://d242m5chux1g9j.cloudfront.net/eribank.ipa");
        //get an iOS device
        dc.setCapability("platformName", "iOS");
        //launch the app
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver(new URL("https://cloud.experitest.com:443/wd/hub"), dc);
    }

    @Test
    public void testYouriOSApp() {

        driver.findElement(By.xpath("//*[@text='Username']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='Password']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@text='loginButton']")).click();
        driver.findElement(By.xpath("//*[@text='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Phone']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@text='Name']")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@text='Amount']")).sendKeys("10");
        driver.findElement(By.xpath("//*[@text='Country']")).sendKeys("US");
        driver.findElement(By.xpath("//*[@text='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@text='Yes']")).click();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}