package AufgabeCucumber.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.MobileElement;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReusableMethods {
    public static int farbe(MobileElement element) throws IOException, InterruptedException  {
        org.openqa.selenium.Point point = element.getCenter();
        int centerx = point.getX();
        int centerY = point.getY();

        File scrFile = ((TakesScreenshot)AufgabeDriver.getAppiumDriver()).getScreenshotAs(OutputType.FILE);

        BufferedImage image = ImageIO.read(scrFile);
        // Getting pixel color by position x and y
        int clr=  image.getRGB(centerx,centerY);
        int  red   = (clr & 0x00ff0000) >> 16;

        return red;
    }
}
