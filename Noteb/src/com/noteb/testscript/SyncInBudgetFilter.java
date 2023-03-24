package com.noteb.testscript;

import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.noteb.generic.BaseClass;
import com.noteb.pom.HomePage;

@Listeners(com.noteb.generic.ListenerImplementation.class)
public class SyncInBudgetFilter extends BaseClass {
	
	@Test
	public void VerifySyncInBudgetFilter() throws InterruptedException {
		HomePage home=new HomePage(driver);
        home.getSearchFilter().click();
        Reporter.log("clicked on main Panel's Search filter ", true);
        SoftAssert soft=new SoftAssert();
       
        
        //System.out.println(home.getMinSlider().getLocation()); (473, 287)
        //System.out.println(home.getMaxSlider().getLocation()); (596, 287)
        
        
         Actions action=new Actions(driver);
         
      // move the min slider in positive axis:
         
         action.dragAndDropBy(home.getMinSlider(),50, 0).perform();
         String minSlider1 = home.getMinSlider().getAttribute("aria-valuenow");
         double minExpecValue5 = Double.parseDouble(minSlider1);
         //System.out.println(minExpecValue5); 760.0
         double minActValue5=760.0;
         soft.assertEquals(minActValue5, minExpecValue5, 0);
         Reporter.log("min slider dragged in positive axis and accordingly updated the input field", true);
         
         Thread.sleep(2000);
         
      //move the min slider in negative axis: 
         
         action.dragAndDropBy(home.getMinSlider(),-150, 0).perform();
         String minSlider2 = home.getMinSlider().getAttribute("aria-valuenow");
         double minExpecValue7 = Double.parseDouble(minSlider2);
         //System.out.println(minExpecValue7); 110.0
         double minActValue7=110.0;
        soft.assertEquals(minActValue7, minExpecValue7, 0);
        Reporter.log("min slider dragged in negative axis and accordingly updated the input field", true);
        
        Thread.sleep(2000);
         
         
       //move the max slider in positive axis:
         
         action.dragAndDropBy(home.getMaxSlider(),100, 0).perform();
         String maxSlider2 = home.getMaxSlider().getAttribute("aria-valuenow");
         double maxExpecValue7 = Double.parseDouble(maxSlider2);
         //System.out.println(maxExpecValue7); 2780.0
         double maxActValue7=2780.0;
         soft.assertEquals(maxActValue7, maxExpecValue7, 0);
         Reporter.log("max slider dragged in positive axis and accordingly updated the input field", true);
           
         Thread.sleep(2000);
         
        
     // move the max slider in negative axis:
         
        action.dragAndDropBy(home.getMaxSlider(),-150, 0).perform();
        String maxSlider1 = home.getMaxSlider().getAttribute("aria-valuenow");
        double maxExpecValue6 = Double.parseDouble(maxSlider1);
        //System.out.println(maxExpecValue6);  880.0
        double maxActValue6=880.0;
        soft.assertEquals(maxActValue6, maxExpecValue6, 0);
        Reporter.log("max slider dragged in negative axis and accordingly updated the input field", true);
        
        Thread.sleep(2000);

        //enter valid min Value:
        
        double minActValue1=110.0; 
        home.getMinValueField().sendKeys(Double.toString(minActValue1));
        Reporter.log("Entered a valid value in minValueField ", true);
        String min=home.getMinSlider().getAttribute("aria-valuenow");
        double minExpecValue1 = Double.parseDouble(min);
        soft.assertEquals(minActValue1, minExpecValue1, 0);
        Reporter.log("Min slider updates it's position as per entered input", true);
        
        Thread.sleep(2000);
        
        
        //enter valid max value:
        
         double maxActValue2=11030.0; 
         home.getMaxValueField().sendKeys(Double.toString(maxActValue2));
         Reporter.log("Entered a valid value in maxValueField ", true);
         String max=home.getMaxSlider().getAttribute("aria-valuenow");
         double maxExpecValue2 = Double.parseDouble(max);
         soft.assertEquals(maxActValue2, maxExpecValue2, 0);
         Reporter.log("Max slider updates it's position as per entered input", true);
        
         Thread.sleep(2000);
        
        //enter valid min and max of same value:
         
        double minActValue3=1000.0;
        double maxActValue3=1000.0;
        Reporter.log("Entered min and max value as same", true);
        home.getMinValueField().sendKeys(Double.toString(minActValue3));
        home.getMaxValueField().sendKeys(Double.toString(maxActValue3));
        String min1=home.getMinSlider().getAttribute("aria-valuenow");
        double minExpecValue3 = Double.parseDouble(min1);
        String max1=home.getMaxSlider().getAttribute("aria-valuenow");
        double maxExpecValue3 = Double.parseDouble(max1);
        soft.assertEquals(minExpecValue3, maxExpecValue3, 0);
        Reporter.log("Min and Max slider updates it's position as per entered input", true);
        
        Thread.sleep(2000);
        
        
        //enter valid min value greater than max value or max value less than min value:
        
        double minActValue4=1500.0;
        double maxActValue4=1000.0;
        Reporter.log("Entered min value greater than max value or max value less than min value", true);
        home.getMinValueField().sendKeys(Double.toString(minActValue4));
        home.getMaxValueField().sendKeys(Double.toString(maxActValue4));
        String min2=home.getMinSlider().getAttribute("aria-valuenow");
        double minExpecValue4 = Double.parseDouble(min2);
        String max2=home.getMaxSlider().getAttribute("aria-valuenow");
        double maxExpecValue4 = Double.parseDouble(max2);
        soft.assertEquals(minExpecValue4, maxExpecValue4, 0);
        Reporter.log("Min and Max slider updates it's position as per entered input", true);
        
        Thread.sleep(2000);
         
        soft.assertAll();
               
        
	}
	

}
