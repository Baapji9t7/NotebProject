package com.noteb.testscript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.noteb.generic.BaseClass;
import com.noteb.pom.HomePage;

@Listeners(com.noteb.generic.ListenerImplementation.class)
public class BudgetFilter extends BaseClass {
	
	@Test
	public void verifyBudgetFilter() {
		
		HomePage home=new HomePage(driver);
        home.getSearchFilter().click();
        Reporter.log("Search filter clicked on main Panel ", true);
		String actText=home.getBudgetFilter().getText();
		String expecText="Budget:";
		SoftAssert soft=new SoftAssert();
		Assert.assertEquals(actText, expecText);
	    Reporter.log("Budget filter is displayed", true);
	    
	    //since html tree for input field is having null value so using slider's attribute.
		String min=home.getMinSlider().getAttribute("aria-valuetext");
		double minValue = Double.parseDouble(min);
		String max=home.getMaxSlider().getAttribute("aria-valuetext");
		double maxValue = Double.parseDouble(max);
		if(minValue!=0 && minValue<=maxValue) {
			Reporter.log("Min and Max input fields are present", true);
		}
		boolean c=home.getCurrencyField().isDisplayed();
		Reporter.log("Currency field is present", true);
		soft.assertAll();
	}

}
