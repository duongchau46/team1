package productFunctions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tests.TCResult;

public class F_Verification {

	public static void verifyElementContent(String pElementName, String pActualResult,
			String pExpectedResult, TCResult pResult) {
		if (!pActualResult.contains(pExpectedResult)) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is displayed " + pActualResult + " instead of " + pExpectedResult);
		}
	}
	
	public static void verifyElementValue(String pElementName, String pActualResult,
			String pExpectedResult, TCResult pResult) {
		if (!pActualResult.equals(pExpectedResult)) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is displayed " + pActualResult + " instead of " + pExpectedResult);
		}
	}

	public static void verifyElementVisible(WebElement pElement, String pElementName,
			TCResult pResult) {
		if (!pElement.isDisplayed()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is not displayed");
		}
	}
	
	public static void verifyElementInvisible(WebElement pElement, String pElementName,
			TCResult pResult) {
		if (pElement != null && pElement.isDisplayed()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is still displayed");
		}
	}
	
	public static void verifyElementSelected(WebElement pElement, String pElementName,
			TCResult pResult) {
		if (!pElement.isSelected()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is not selected");
		}
	}
	
	public static void verifyElementNotSelected(WebElement pElement, String pElementName,
			TCResult pResult) {
		if (pElement.isSelected()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is selected");
		}
	}

	public static void verifyElementEnabled(WebElement pElement, String pElementName, TCResult pResult) {
		if (!pElement.isEnabled()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is not enabled");
		}
	}
	
	public static void verifyElementNotEnabled(WebElement pElement,  String pElementName, TCResult pResult) {
	
		if (pElement.isEnabled()) {
			pResult.SetResult(false);
			pResult.SetMessage(pElementName + " is enabled");
		}
	}

	
	
}
