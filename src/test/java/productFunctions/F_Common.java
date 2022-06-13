package productFunctions;

import java.awt.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class F_Common {

	public static WebElement captureInterface(WebDriver pDriver, By pBy) {
		try {
			return pDriver.findElement(pBy);
		} catch (Exception e) {
			return null;
		}
	}

	public static WebElement captureInterface(WebDriver pDriver, String pBy) {
		try {
			return pDriver.findElement(By.xpath(pBy));
		} catch (Exception e) {
			return null;
		}
	}
	
	

	public static void clear(WebDriverWait pWait, WebDriver pDriver, By pBy) {
		try {
			pWait.until(ExpectedConditions.elementToBeClickable(pBy));
		} catch (Exception e) {
		}
		pDriver.findElement(pBy).clear();
	}

	public static void sendKeys(WebDriverWait pWait, WebDriver pDriver, By pBy, String pValue) {
		try {
			pWait.until(ExpectedConditions.elementToBeClickable(pBy));
		} catch (Exception e) {
		}
		WebElement mElement = pDriver.findElement(pBy);
		try {
			pWait.until(ExpectedConditions.elementToBeClickable(mElement));
		} catch (Exception e) {
		}
		mElement.sendKeys(pValue);

	}

	public static String getText(WebDriver pDriver, By pBy) {
		String text = "";
		try {
			text = pDriver.findElement(pBy).getText();
		} catch (Exception e) {
		}
		return text;
	}

	public static void dragAndDrop(WebDriver pDriver, WebElement psourceEle, WebElement ptargetEle) {
		Actions mBuilder = new Actions(pDriver);
		Action action = mBuilder.dragAndDrop(psourceEle, ptargetEle).build();
		action.perform();
	}

	public static void scrollToEle(WebDriver pDriver, By pBy) {
		((JavascriptExecutor) pDriver).executeScript("arguments[0].scrollIntoView(true);",
				captureInterface(pDriver, pBy));
		try {
			Thread.sleep(500);
		} catch (Exception ex) {
		}
	}

	/**
	 * scroll To view Element
	 * 
	 * @param Element
	 */
	public static void scrollToEle(WebDriver pDriver, WebElement pEle) {
		((JavascriptExecutor) pDriver).executeScript("arguments[0].scrollIntoView(true);", pEle);
		try {
			Thread.sleep(700);
		} catch (Exception ex) {
		}
	}

	/**
	 * Wait for a element visible
	 * 
	 * @param pBy A mechanism by which to find elements within a document
	 */
	public static void waitForElementVisible(WebDriverWait pWait, By pBy) {
		try {
			pWait.until(ExpectedConditions.visibilityOfElementLocated(pBy));
		} catch (Exception e) {

		}
	}

	/**
	 * Wait for a element invisible
	 * 
	 * @param pBy A mechanism by which to find elements within a document
	 */
	public static void waitForElementNotVisible(WebDriverWait pWait, By pBy) {
		try {
			pWait.until(ExpectedConditions.invisibilityOfElementLocated(pBy));
		} catch (Exception e) {
			System.out.println(pBy + " Not Visible");
		}
	}

	/**
	 * Wait for a value is populated in an element
	 * 
	 * @param pBy    A mechanism by which to find elements within a document
	 * @param pValue Expected value to wait for
	 */
	public static void waitForElementValue(WebDriverWait pWait, By pBy, String pValue) {
		try {
			pWait.until(ExpectedConditions.attributeToBe(pBy, "value", pValue));
		} catch (Exception e) {
		}
	}

	public static void selectDropdownByValue(WebDriver pDriver, By pBy, String pValue) {
		Select mSelect = new Select(pDriver.findElement(pBy));
		mSelect.selectByValue(pValue);
	}

	public static void selectDropdownByText(WebDriver pDriver, By pBy, String pText) {
		Select mSelect = new Select(pDriver.findElement(pBy));
		mSelect.selectByVisibleText(pText);
	}

	public static void selectDropdownByText(WebDriver pDriver, WebDriverWait pWait, By pBy, String pValue,
			String childTag) {
		waitForElementVisible(pWait, pBy);
		WebElement ddList = captureInterface(pDriver, pBy);
		WebElement item = ddList.findElement(By.xpath(childTag + "[contains(.,'" + pValue + "')]"));
		// scrollToEle(pDriver, item);
		item.click();
	}

	/**
	 * Select random in a drop down list on web application
	 * 
	 * @param pBy    A mechanism by which to find elements within a document
	 * @param pValue Text to select
	 */
	public static String selectRandomDropdown(WebDriver pDriver, By pBy) {
		Select mSelect = new Select(pDriver.findElement(pBy));

		WebElement ddList = captureInterface(pDriver, pBy);

		int count = ddList.findElements(By.xpath("option")).size();

		Random r = new Random();

		int s = r.nextInt(count - 1);

		List items = new List(count, false);
		for (int i = 0; i < count; i++) {
			WebElement col = ddList.findElement(By.xpath("option[" + (i + 1) + "]"));
			items.add(col.getText(), i);
		}

		String pText = items.getItem(s);
		if (pText.contentEquals("Select"))
			pText = items.getItem(s + 1);

		mSelect.selectByVisibleText(pText);
		return pText;
	}

	/**
	 * Switch to window by Title
	 */
	public static void switchToWindowHasTitle(WebDriver pDriver, String ptitle) {
		String currentWindow = pDriver.getWindowHandle();
		for (String winHandle : pDriver.getWindowHandles()) {
			if (pDriver.switchTo().window(winHandle).getTitle().equals(ptitle)) {
				break;
			} else {
				pDriver.switchTo().window(currentWindow);
			}
		}
	}
	public static void Click(WebDriver pDriver,By pBy) {
		Actions actions = new Actions(pDriver);
		WebElement elementLocator = pDriver.findElement(pBy);
		actions.click(elementLocator).perform();
	}

	public static void contextClick(WebDriver pDriver, By pBy) {
		Actions actions = new Actions(pDriver);
		WebElement elementLocator = pDriver.findElement(pBy);
		actions.contextClick(elementLocator).perform();

	}
	
	public static void doubleClick(WebDriver pDriver, By pBy) {
		Actions actions = new Actions(pDriver);
		WebElement elementLocator = pDriver.findElement(pBy);
		actions.doubleClick(elementLocator).perform();

	}

	/**
	 * Enter value to telerik element on web application
	 * 
	 * @param pBy    A mechanism by which to find elements within a document
	 * @param pValue Value to enter
	 */
	public static void telerikSendKeys(WebDriver pDriver, By pBy, String pValue) {
		Actions mBuilder = new Actions(pDriver);
		Action action = mBuilder.sendKeys(pDriver.findElement(pBy), (CharSequence) pValue).build();
		action.perform();
	}

}
