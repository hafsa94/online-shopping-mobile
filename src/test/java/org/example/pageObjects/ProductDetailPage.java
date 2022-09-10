package org.example.pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.HashMap;
import java.util.Map;

public class ProductDetailPage extends BasePage {

    @AndroidFindBy(accessibility = "txtPrice")
    private MobileElement productPrice;

    @AndroidFindBy(accessibility = "txtProductTitle")
    private MobileElement productName;

    @AndroidFindBy(accessibility = "ttlAddToBasketButton")
    private MobileElement addToBasketButton;

    @AndroidFindBy(accessibility = "txtCheckoutNow")
    private MobileElement checkoutNowButton;

    public boolean clickAddToBasketButton() {
        return clickOnElement(addToBasketButton);
    }

    public boolean clickCheckoutNowButton() {
        return clickOnElement(checkoutNowButton);
    }

    public String getProductPrice() {
        checkElementHasText(addToBasketButton, "Add to Basket");
        return getElementAttribute(productPrice, "text");
    }

    public Map<String, String> getProductTitlePrice() {
        return new HashMap<String, String>() {
            {
                put("title", getTextOfElement(productName));
                put("price", getProductPrice());
            }
        };
    }
}
