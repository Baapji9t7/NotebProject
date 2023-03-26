package com.noteb.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//img[@class='controlSvg']")
	private WebElement searchFilter;
	
	@FindBy(xpath="(//span[text()='Budget:'])[2]")
	private WebElement budgetFilter;	
	
	@FindBy(id="bdgminadv")
	private WebElement minValueField;
	
	@FindBy(id="bdgmaxadv")
	private WebElement maxValueField;
	
	@FindBy(xpath="//*[@id='budgetadv']/div/div[2]/div")
	private WebElement minSlider;
	
	@FindBy(xpath="//*[@id='budgetadv']/div/div[3]/div")
	private WebElement maxSlider;
	
	@FindBy(id="currencyadv")
	private WebElement currencyField;	
	
	@FindBy(id="submitformid")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[@class='btn btn-outline-secondary searchprice fakeBtn']")
	private List <WebElement> priceRange;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getBudgetFilter() {
	
		return budgetFilter;
	}
	public WebElement getSearchFilter() {
		return searchFilter;
	}


	public WebElement getMinValueField() {
		return minValueField;
	}

	public WebElement getMaxValueField() {
		return maxValueField;
	}

	public WebElement getMinSlider() {
		return minSlider;
	}

	public WebElement getMaxSlider() {
		return maxSlider;
	}

	public WebElement getCurrencyField() {
		return currencyField;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}

	
}
