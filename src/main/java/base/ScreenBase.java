package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableList;

import driver.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;

public class ScreenBase {
	
	public static AppiumDriver driver;
	public WebDriverWait wait;
	static double SCROLL_RATIO = 0.5;
    static Duration SCROLL_DUR = Duration.ofMillis(500);
	
		public ScreenBase(AppiumDriver driver) {
			this.driver = driver;
			AppDriver.setDriver(this.driver);
		}
		
		public static void hideKeyboard() {
			((HidesKeyboard) driver).hideKeyboard();
		}
		
		protected void waitForVisibilityOf(String locatorID) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorID)));
		}
		
		
		public static void scroll(ScrollDirection dir, double scrollRatio) {

	        if (scrollRatio < 0 || scrollRatio > 1) {
	            throw new Error("Scroll distance must be between 0 and 1");
	        }
	        Dimension size = (AppDriver.getCurrentDriver()).manage().window().getSize();
	        System.out.println(size);
	        Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
	        int bottom = midPoint.y + (int) (midPoint.y * scrollRatio);
	        int top = midPoint.y - (int) (midPoint.y * scrollRatio);
	        //Point Start = new Point(midPoint.x, bottom );
	        //Point End = new Point(midPoint.x, top );
	        int left = midPoint.x - (int) (midPoint.x * scrollRatio);
	        int right = midPoint.x + (int) (midPoint.x * scrollRatio);

	        if (dir == ScrollDirection.UP) {
	            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
	        } else if (dir == ScrollDirection.DOWN) {
	            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
	        } else if (dir == ScrollDirection.LEFT) {
	            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
	        } else {
	            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
	        }
	    }
		
		public enum ScrollDirection {
	        UP, DOWN, LEFT, RIGHT
	    }
		
		protected static void swipe(Point start, Point end, Duration duration) {

	        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	        Sequence swipe = new Sequence(input, 0);
	        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
	        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
	        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        (driver).perform(ImmutableList.of(swipe));
	    }

}
