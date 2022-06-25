package AufgabeTestNG;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class aufgabe extends aufgabeBase{
    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        AndroidDriver driver = androidDriver();
        driver.findElementById("com.example.yeshasprabhakar.todo:id/fab").click();
        driver.findElementByXPath("//android.widget.EditText[@text='My Task']").sendKeys("Test");
        Thread.sleep(2000);
        driver.findElementById("com.example.yeshasprabhakar.todo:id/date").click();
        driver.findElementById("android:id/next").click();
        driver.findElementByXPath("//android.view.View[@text='13']").click();
        Thread.sleep(2000);

        String expextedData="Wed, Jul 13";
        String actualData = driver.findElementById("android:id/date_picker_header_date").getText();
        Assert.assertEquals("The Date not equals",expextedData,actualData);
        driver.findElementByXPath("//android.widget.Button[@text='OK']").click();

        driver.findElementById("com.example.yeshasprabhakar.todo:id/time").click();
        TouchAction touchAction = new TouchAction(driver);

        touchAction.press(ElementOption.element(driver.findElementByAccessibilityId("10"))).release().perform();
        touchAction.press(ElementOption.element(driver.findElementByAccessibilityId("30"))).release().perform();
        driver.findElementByXPath("//android.widget.Button[@text='OK']").click();

        //alternative way
        //touchAction.press(ElementOption.element(driver.findElementByAccessibilityId("10"))).
        //        waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).
        //        moveTo(ElementOption.element(driver.findElementByAccessibilityId("30"))).release().perform();

        driver.findElementByXPath("//android.widget.Button[@text='DONE']").click();
        Assert.assertEquals(driver.findElementById("com.example.yeshasprabhakar.todo:id/title").getText(),"Test");
        Assert.assertEquals(driver.findElementById("com.example.yeshasprabhakar.todo:id/dateTitle").getText(),"13 JULY");
        Assert.assertEquals(driver.findElementById("com.example.yeshasprabhakar.todo:id/timeTitle").getText(),"10 : 30 AM");


    }
    @Test
    public void test2() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();

        driver.findElementById("com.example.yeshasprabhakar.todo:id/fab").click();
        driver.findElementByXPath("//android.widget.EditText[@text='My Task']").sendKeys("Test");
        driver.findElementByXPath("//android.widget.Button[@text='CANCEL']").click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElementById("com.example.yeshasprabhakar.todo:id/emptyTextView").getText().contains("What do you want to do today?"));

        }

    @Test
    public void test3() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();
        driver.findElementById("com.example.yeshasprabhakar.todo:id/fab").click();
        driver.findElementByXPath("//android.widget.Button[@text='DONE']").click();
        Assert.assertTrue(driver.findElementByXPath("//android.widget.Toast[@text='Oops, Cannot set an empty ToDo!!!']").isDisplayed());


    }

    @Test
    public void test4() throws MalformedURLException, InterruptedException {
        AndroidDriver driver = androidDriver();
        driver.findElementById("com.example.yeshasprabhakar.todo:id/fab").click();
        driver.findElementByXPath("//android.widget.EditText[@text='My Task']").sendKeys("Test");
        driver.findElementByXPath("//android.widget.Button[@text='DONE']").click();
        Assert.assertEquals(driver.findElementById("com.example.yeshasprabhakar.todo:id/title").getText(),"Test");
        driver.findElementById("com.example.yeshasprabhakar.todo:id/delete").click();
        Assert.assertTrue(driver.findElementByXPath("//android.widget.Toast[@text='Deleted Successfully!']").isDisplayed());

    }

    @Test
    public void test5() throws IOException, InterruptedException {
        AndroidDriver driver = androidDriver();
        driver.findElementById("com.example.yeshasprabhakar.todo:id/themeActionButton").click();
        Thread.sleep(2000);
        driver.findElementById("com.example.yeshasprabhakar.todo:id/themeActionButton").click();

        MobileElement elem = (MobileElement) driver.findElementById("com.example.yeshasprabhakar.todo:id/action_bar");

        org.openqa.selenium.Point point = elem.getCenter();
        int centerx = point.getX();
        int centerY = point.getY();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        BufferedImage image = ImageIO.read(scrFile);
        // Getting pixel color by position x and y
        int clr=  image.getRGB(centerx,centerY);
        int  red   = (clr & 0x00ff0000) >> 16;
        Assert.assertEquals("Action bar color black",255,red);

    }



}
