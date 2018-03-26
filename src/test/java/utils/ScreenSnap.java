package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenSnap {
	public static void takeSnapShot(WebDriver ldriver,String location){
		try {
		File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
		File DestFile=new File(location);
		FileUtils.copyFile(src, DestFile);
		}
		
		catch (IOException e)

		{
		System.out.println(e.getMessage());
		}
		}
	 public static void lele(WebDriver driver,String ocation) throws IOException{
		 final Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
	        final BufferedImage image = screenshot.getImage();
	        File destination=new File(ocation);
	        ImageIO.write(image, "PNG", destination);
	 }
}
