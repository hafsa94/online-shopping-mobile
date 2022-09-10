package org.example.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utils.DriverManager;
import org.example.utils.PropertyManager;
import org.example.utils.TestUtils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class BasePage {

    TestUtils utils = new TestUtils();

    private AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    public BasePage() {
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(TestUtils.WAIT)), this);
        this.wait = new WebDriverWait(driver, TestUtils.WAIT);
    }

    /**
     * This method simulates typing into an element, which may set its value.
     *
     * @param element   used to find the element
     * @param inputText string to send to the element
     * @return true when successfully send input to the element otherwise false
     */
    public boolean enterFieldInput(MobileElement element, String inputText) {
        boolean result = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(inputText);
            result = true;
        } catch (Exception e) {
            utils.log().error("Failed to send input to the element", e);
        }
        return result;
    }

    /**
     * This method clicks the element on the given index from the list of all the elements with the
     * same locator
     *
     * @param element used to find the element
     * @return true when successfully click the element otherwise false
     */
    public boolean clickOnElement(MobileElement element) {
        boolean result = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            result = true;
        } catch (Exception e) {
            utils.log().error("Failed to click on the element", e);
        }
        return result;
    }

    /**
     * This method returns the visible (i.e. not hidden by CSS) text of this element, including sub-elements
     *
     * @param element used to find the element
     * @return the visible text of this element otherwise empty string
     */
    public String getTextOfElement(MobileElement element) {
        String elementText = "";
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            elementText = element.getText();
        } catch (Exception e) {
            utils.log().error("Failed to get the text of the element", e);
        }
        return elementText;
    }

    /**
     * This method checks whether an element is visible on the DOM of a page or not
     *
     * @param element used to find the element
     * @return true when the element is visible otherwise false
     */
    public boolean checkElementIsVisible(MobileElement element) {
        boolean result = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            result = true;
        } catch (Exception e) {
            utils.log().error("Element is not visible on the page", e);
        }
        return result;
    }

    /**
     * This method returns the value of the given attribute of the element
     *
     * @param element used to find the element
     * @return The attribute/property's current value or "" if the value is not set
     */
    public String getElementAttribute(MobileElement element, String attribute) {
        String attributeValue = "";
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            attributeValue = element.getAttribute(attribute);
        } catch (Exception e) {
            utils.log().error("Failed to get the attribute of the element on the page", e);
        }
        return attributeValue;
    }

    /**
     * This method checks whether an element has a text on the DOM of a page or not
     *
     * @param element used to find the element
     * @return true when the text is present in the element otherwise false
     */
    public boolean checkElementHasText(MobileElement element, String text) {
        boolean result = false;
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            result = true;
        } catch (Exception e) {
            utils.log().error("Failed to find text in the element on the page", e);
        }
        return result;
    }
}




